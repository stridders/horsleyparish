(function() {

    angular.module('horsley')
        .controller('UsersController', UsersController);

    UsersController.$inject = [
        'FlashService',
        'UsersService',
        '$scope'
    ];

    function UsersController(FlashService, UsersService, $scope) {

        let uc = this;
        uc.savePassword = savePassword;

        initialise();


        function initialise() {
            UsersService.getUsers(function (response) {
                if (response) {
                    uc.userList = response.users;
                } else {
                    let errMsg = "Unable to retieve user list from Horsley server";
                    FlashService.Error(errMsg);
                }
            });
        }

        function savePassword(user) {
            console.log("----->"+JSON.stringify(user));
        }

    }

})();