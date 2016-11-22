(function () {
    'use strict';

    angular
        .module('horsley')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];

    function LoginController($location, AuthenticationService, FlashService) {
        let lc = this;
        lc.errMsg = null;

        lc.login = login;
        lc.resetErrors = resetErrors;
        
        initController();

        function initController() {
            AuthenticationService.ClearCredentials();
        }

        function login() {
            lc.dataLoading = true;
            console.log("user:"+lc.username);
            AuthenticationService.Login(lc.username, lc.password,
                function (response) {
                    if (response) {
                        lc.dataLoading = false;
                        $location.path("/");
                    } else {
                        lc.dataLoading = false;
                        form.$invalid = false;
                        lc.errMsg = "Username and/or password are invalid";
                    }
                })
        }

        function resetErrors() {
            lc.dataLoading = false;
            form.$invalid = false;
            lc.errMsg = null;
        }



    }

})();

