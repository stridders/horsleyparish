(function () {
    'use strict';

    angular
        .module('horsley')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$state', 'AuthenticationService', 'FlashService','$rootScope'];

    function LoginController($state, AuthenticationService, FlashService, $rootScope) {
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
            AuthenticationService.Login(lc.username, lc.password,
                function (response) {
                    if (response) {
                        lc.dataLoading = false;
                        $rootScope.$emit('login:authenticated',response);
                        $state.go('home', {}, {reload: true});

                    } else {
                        lc.dataLoading = false;
                        form.$invalid = false;
                        $rootScope.$emit('login:rejected');
                        lc.errMsg = "Username and/or password are invalid";
                        FlashService.Error("Username and/or password are invalid");
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

