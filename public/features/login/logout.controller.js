(function () {
    'use strict';

    angular
        .module('horsley')
        .controller('LogoutController', LogoutController);

    LogoutController.$inject = ['$state', 'AuthenticationService', '$rootScope'];

    function LogoutController($state, AuthenticationService, $rootScope) {

        AuthenticationService.ClearCredentials();
        $rootScope.$emit('login:closed');
        $state.go('home', {}, {reload: true});

    }

})();

