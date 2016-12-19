(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('FileUploadService', FileUploadService);

    FileUploadService.$inject = ['$http','FlashService'];

    function FileUploadService($http,FlashService) {

        var service = {};
        service.getDocumentTypes = getDocumentTypes;
        service.initialiseSyncFilter = initialiseSyncFilter;
        service.initialiseAsyncFilter = initialiseAsyncFilter;
        service.configureCallbacks = configureCallbacks;

        return service;


        function getDocumentTypes(filter,callback) {
            $http.get('/api/document-types?doctype='+filter)
                .success(function (response) {
                    callback(response);
                })
                .error(function() {
                    callback(null);
                });
        }

        /**
         * Initialise a syncronous filter to verify file type and queue size
         * @param uploader
         * @param maxQueueSize
         * @param acceptFileTypes
         */
        function initialiseSyncFilter(uploader,maxQueueSize,acceptFileTypes) {
            uploader.filters.push({
                name: 'syncFilter',
                fn: function (item /*{File|FileLikeObject}*/, options) {
                    let type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                    let typeOK = acceptFileTypes.indexOf(type) !== -1;
                    return (this.queue.length < maxQueueSize && typeOK);
                }
            });
        }

        /**
         * Initialise an asynchronour timeout filter
         * @param uploader
         * @param timeout
         */
        function initialiseAsyncFilter(uploader,timeout) {
            uploader.filters.push({
                name: 'asyncFilter',
                fn: function (item /*{File|FileLikeObject}*/, options, deferred) {
                    setTimeout(deferred.resolve, timeout);
                }
            });
        }

        function configureCallbacks(uploader,formData) {

            uploader.onWhenAddingFileFailed = function (item /*{File|FileLikeObject}*/, filter, options) {
                console.info('onErrorItem', item, filter, options);
                let errMsg = "Unable to add document to queue. Most likely cause is the document type is invalid";
                FlashService.Error(errMsg);
            };
            // uploader.onAfterAddingFile = function (fileItem) {
            //     console.info('onAfterAddingFile', fileItem);
            // };
            // uploader.onAfterAddingAll = function (addedFileItems) {
            //     console.info('onAfterAddingAll', addedFileItems);
            // };
            uploader.onBeforeUploadItem = function (item) {
                formData.fileSize = item.file.size;
                item.formData[0] = formData;
            };
            // uploader.onProgressItem = function (fileItem, progress) {
            //     console.info('onProgressItem', fileItem, progress);
            // };
            // uploader.onProgressAll = function (progress) {
            //     console.info('onProgressAll', progress);
            // };
            // uploader.onSuccessItem = function (fileItem, response, status, headers) {
            //     console.info('onSuccessItem', fileItem, response, status, headers);
            // };
            uploader.onErrorItem = function (fileItem, response, status, headers) {
                console.info('onErrorItem', fileItem, response, status, headers);
                let errMsg = "Error while uploading file. ";
                FlashService.Error(errMsg);
            };
            // uploader.onCancelItem = function (fileItem, response, status, headers) {
            //     console.info('onCancelItem', fileItem, response, status, headers);
            // };
            // uploader.onCompleteItem = function (fileItem, response, status, headers) {
            //     console.info('onCompleteItem', fileItem, response, status, headers);
            // };
            // uploader.onCompleteAll = function () {
            //     console.info('onCompleteAll');
            // };
        }


    }


})();
