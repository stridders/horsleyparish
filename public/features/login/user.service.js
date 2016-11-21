(function () {
    'use strict';

    angular
        .module('horsley')
        .service('UserService', UserService);

    UserService.$inject = ['$http'];

    function UserService($http) {

        var service = {};

        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            return $http.get('/api/users').then(returnResult, returnFailure('Error getting all users'));
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(returnResult, returnFailure('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get('/api/users/' + username).then(returnResult, returnFailure('Error getting user by username'));
        }

        function Create(user) {
            return $http.post('/api/users', user).then(returnResult, returnFailure('Error creating user'));
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(returnResult, returnFailure('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/api/users/' + id).then(returnResult, returnFailure('Error deleting user'));
        }

        // private functions

        function returnResult(res) {
            return res.data;
        }

        function returnFailure(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
