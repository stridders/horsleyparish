(function () {
    'use strict';

    angular
        .module('horsley')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];

    function LoginController($location, AuthenticationService, FlashService) {
        let log = this;

        log.login = login;
        initController();

        function initController() {
            AuthenticationService.ClearCredentials();
        }

        function login() {
            log.dataLoading = true;
            console.log("user:"+log.username);
            AuthenticationService.Login(log.username, log.password,
                function (response) {
                    if (response) {
                        log.dataLoading = false;
                        console.log("----- Success ---------"+JSON.stringify(response));
                        //$location.path("/");
                    } else {
                        log.dataLoading = false;
                        form.$invalid = false;
                        console.log("----- FAILURE ---------");
                    }
                })
        }



    }

})();

