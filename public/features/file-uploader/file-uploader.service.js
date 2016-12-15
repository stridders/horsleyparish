(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('FileUploadService', FileUploadService);

    FileUploadService.$inject = ['$http'];

    function FileUploadService($http) {

        var service = {};
        service.getDocumentTypes = getDocumentTypes;

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

    }


})();
