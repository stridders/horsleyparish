(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('CalendarService', CalendarService);

    CalendarService.$inject = ['$http'];

    function CalendarService($http) {

        var service = {};
        service.timespanClicked = timespanClicked;
        // service.uploadMinutes = uploadMinutes;
        // service.accountDocUpload = accountDocUpload;
        return service;



        function timespanClicked(ctrlr, date, cell) {
            if (ctrlr.calendarView === 'month') {
                if ((ctrlr.cellIsOpen && moment(date).startOf('day').isSame(moment(ctrlr.viewDate).startOf('day'))) || cell.events.length === 0 || !cell.inMonth) {
                    ctrlr.cellIsOpen = false;
                } else {
                    ctrlr.cellIsOpen = true;
                    ctrlr.viewDate = date;
                }
            } else if (ctrlr.calendarView === 'year') {
                if ((ctrlr.cellIsOpen && moment(date).startOf('month').isSame(moment(ctrlr.viewDate).startOf('month'))) || cell.events.length === 0) {
                    ctrlr.cellIsOpen = false;
                } else {
                    ctrlr.cellIsOpen = true;
                    ctrlr.viewDate = date;
                }
            }
        };

    }



})();