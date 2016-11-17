(function () {
    'use strict';

    angular
        .module('horsley')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function LoginController($location, AuthenticationService, FlashService) {
        var log = this;

        log.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            log.dataLoading = true;
            AuthenticationService.SetCredentials(log.username, log.password);
            AuthenticationService.Login(log.username, log.password, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials(log.username, log.password);
                    $location.path('/');
                } else {
                    // FlashService.Error(response.message);
                    log.dataLoading = false;
                }
            });
        };
    }

})();

