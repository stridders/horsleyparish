(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('HorsesMouthService', HorsesMouthService);

    HorsesMouthService.$inject = ['$http'];

    function HorsesMouthService($http) {

        var service = {};
        service.getMagazineLinks = getMagazineLinks;

        return service;

        function getMagazineLinks(callback) {
            $http.get('/api/documents?doctype=HORSES_MOUTH')
                .success(function (response) {
                    callback(response);
                })
                .error(function() {
                    callback(null);
                });
        }
    }



})();