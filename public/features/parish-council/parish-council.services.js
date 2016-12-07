(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('ParishCouncilService', ParishCouncilService);

    ParishCouncilService.$inject = ['$http'];

    function ParishCouncilService($http) {

        var service = {};
        service.GetDocumentTypes = GetDocumentTypes;

        return service;


        function GetDocumentTypes(filter,callback) {
            $http.get('/api/document-types?doctype='+filter)
                .success(function (response) {
                    callback(response);
                })
                .error(function() {
                    callback(null);
                });
        }

    }



})();