(function () {
    'use strict';

    angular
        .module('horsley')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        let reg = this;

        reg.register = register;

        function register() {
            reg.dataLoading = true;
            UserService.Create(reg.user)
                .then(function (response) {
                    if (response.success) {
                        FlashService.Success('Thank-you for registering. Confirmation instructions have been emailed to you.', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        reg.dataLoading = false;
                    }
                });
        }
    }

})();

