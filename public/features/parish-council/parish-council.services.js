(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('ParishCouncilService', ParishCouncilService);

    ParishCouncilService.$inject = ['$http','Upload'];

    function ParishCouncilService($http,Upload) {

        var service = {};
        service.getDocumentTypes = getDocumentTypes;
        service.timespanClicked = timespanClicked;
        service.uploadMinutes = uploadMinutes;
        service.accountDocUpload = accountDocUpload;

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

        function accountDocUpload(file,metadata) {
            console.log("upload account document");
            Upload.upload({
                url: 'api/documents',
                data: {
                    file: file,
                    documentType: metadata.docType.documentType,
                    name: metadata.docName,
                    group: metadata.group
                }
            }).then(function (resp) {
                console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
            }, function (resp) {
                console.log('Error status: ' + resp.status);
            }, function (evt) {
                var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file);
                pcc.file = evt.config.data.file;
            });
        }

        // upload on file select or drop
        function uploadMinutes(file) {

            Upload.upload({
                url: 'api/documents',
                data: {
                    file: file,
                    documentType: 'PC_MINUTES',
                    name: 'Test Minutes PDF file',
                    meetingId: '1001'
                }
            }).then(function (resp) {
                console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
            }, function (resp) {
                console.log('Error status: ' + resp.status);
            }, function (evt) {
                var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file);
                pcc.file = evt.config.data.file;
            });
        };

        function timespanClicked(date, cell) {
            if (pcc.calendarView === 'month') {
                if ((pcc.cellIsOpen && moment(date).startOf('day').isSame(moment(pcc.viewDate).startOf('day'))) || cell.events.length === 0 || !cell.inMonth) {
                    pcc.cellIsOpen = false;
                } else {
                    pcc.cellIsOpen = true;
                    pcc.viewDate = date;
                }
            } else if (pcc.calendarView === 'year') {
                if ((pcc.cellIsOpen && moment(date).startOf('month').isSame(moment(pcc.viewDate).startOf('month'))) || cell.events.length === 0) {
                    pcc.cellIsOpen = false;
                } else {
                    pcc.cellIsOpen = true;
                    pcc.viewDate = date;
                }
            }
        };

    }



})();