(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('ParishCouncilService', ParishCouncilService);

    ParishCouncilService.$inject = ['$http'];

    function ParishCouncilService($http) {

        var service = {};
        service.getDocumentTypes = getDocumentTypes;
        service.timespanClicked = timespanClicked;
        // service.uploadMinutes = uploadMinutes;
        // service.accountDocUpload = accountDocUpload;

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

        // function accountDocUpload(file,metadata) {
        //     console.log("upload account document");
        //     Upload.upload({
        //         url: 'api/documents',
        //         data: {
        //             file: file,
        //             documentType: metadata.docType.documentType,
        //             name: metadata.docName,
        //             group: metadata.group,
        //             // size: file.size
        //         }
        //     }).then(resp => {
        //         $timeout(function() {
        //             console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
        //             file.result = res.data;
        //         });
        //
        //     }, function (resp) {
        //         if (resp.status > 0) {
        //             console.log("Error:"+resp.status + ' - ' + resp.data);
        //         }
        //     }, function (evt) {
        //         file.progress = Math.min(100, parseInt(100.00 * evt.loaded / evt.total));
        //         var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
        //         console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file);
        //     });
        // }



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