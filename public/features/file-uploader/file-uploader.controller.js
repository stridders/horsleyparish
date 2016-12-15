(function() {

    angular.module('horsley')
        .controller('FileUploaderController', FileUploaderController);

    FileUploaderController.$inject = [
        '$scope',
        'FileUploader',
        'AuthenticationService',
        'FileUploadService'
    ];

    function FileUploaderController($scope,
                                    FileUploader,
                                    AuthenticationService,
                                    FileUploadService) {

        let upc = this;
        upc.docTypeOptions = [];


        let uploader = $scope.uploader = new FileUploader({
            headers: AuthenticationService.GetSecurityHeader(),
            url: 'api/documents'
        });


        function initialise() {
            let docOptions = [];
            FileUploadService.getDocumentTypes("PC_ACCOUNT",function (response) {
                if (response) {
                    upc.docTypeOptions = response.documentTypes;
                } else {
                    let errMsg = "Unable to retieve document types from Horsley server";
                    FlashService.Error(errMsg);
                }
            });
        }



        // FILTERS

        // a sync filter
        uploader.filters.push({
            name: 'syncFilter',
            fn: function (item /*{File|FileLikeObject}*/, options) {
                console.log('syncFilter');
                return this.queue.length < 10;
            }
        });

        // an async filter
        uploader.filters.push({
            name: 'asyncFilter',
            fn: function (item /*{File|FileLikeObject}*/, options, deferred) {
                console.log('asyncFilter');
                setTimeout(deferred.resolve, 1e3);
            }
        });

        // CALLBACKS

        uploader.onWhenAddingFileFailed = function (item /*{File|FileLikeObject}*/, filter, options) {
            console.info('onWhenAddingFileFailed', item, filter, options);
        };
        uploader.onAfterAddingFile = function (fileItem) {
            console.info('onAfterAddingFile', fileItem);
        };
        uploader.onAfterAddingAll = function (addedFileItems) {
            console.info('onAfterAddingAll', addedFileItems);
        };
        uploader.onBeforeUploadItem = function (item) {
            console.info('onBeforeUploadItem', item);
        };
        uploader.onProgressItem = function (fileItem, progress) {
            console.info('onProgressItem', fileItem, progress);
        };
        uploader.onProgressAll = function (progress) {
            console.info('onProgressAll', progress);
        };
        uploader.onSuccessItem = function (fileItem, response, status, headers) {
            console.info('onSuccessItem', fileItem, response, status, headers);
        };
        uploader.onErrorItem = function (fileItem, response, status, headers) {
            console.info('onErrorItem', fileItem, response, status, headers);
        };
        uploader.onCancelItem = function (fileItem, response, status, headers) {
            console.info('onCancelItem', fileItem, response, status, headers);
        };
        uploader.onCompleteItem = function (fileItem, response, status, headers) {
            console.info('onCompleteItem', fileItem, response, status, headers);
        };
        uploader.onCompleteAll = function () {
            console.info('onCompleteAll');
        };

        console.info('uploader', uploader);
    }

})();