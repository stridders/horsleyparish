(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('UsersService', UsersService);

    UsersService.$inject = ['$http','FlashService'];

    function UsersService($http,FlashService) {

        var service = {};
        service.getUsers = getUsers;
        return service;

        function getUsers(callback) {
            $http.get('/api/users')
                .success(function (response) {
                    callback(response);
                })
                .error(function() {
                    callback(null);
                });
        }

    }


})();
