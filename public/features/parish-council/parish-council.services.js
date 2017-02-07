(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('ParishCouncilService', ParishCouncilService);

    ParishCouncilService.$inject = ['$http'];

    function ParishCouncilService($http) {

        var service = {};
        service.getMinutesLinks = getMinutesLinks;
        service.getAgendaLinks = getAgendaLinks;

        return service;


        function getMinutesLinks(callback) {
            $http.get('/api/documents?doctype=PC_MEET_MINUTES')
                .success(function (response) {
                    callback(response);
                })
                .error(function() {
                    callback(null);
                });
        }

        function getAgendaLinks(callback) {
            $http.get('/api/documents?doctype=PC_MEET_AGENDA')
                .success(function (response) {
                    callback(response);
                })
                .error(function() {
                    callback(null);
                });
        }

    }



})();