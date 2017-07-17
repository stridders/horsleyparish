(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('GoogleDriveService', GoogleDriveService);

    GoogleDriveService.$inject = ['$http','FlashService'];

    function GoogleDriveService($http,FlashService) {

        var service = {};
        service.getFileList = getFileList;

        return service;

        /**
         * Returns a list of files in a given Google Drive folder
         * @param folder
         */
        function getFileList(folder,callback) {
            $http.get('/api/google/list?folder='+folder)
                .success(function (response) {
                    callback(response);
                })
                .error(function() {
                    callback(null);
                });
        }

    }

})();
