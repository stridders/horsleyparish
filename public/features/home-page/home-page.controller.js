(function() {

    angular.module('horsley')
        .controller('HomePageController', HomePageController);

    HomePageController.$inject = [];

    function HomePageController() {
        let hpc = this;
        hpc.config = {
            'title': 'Welcome to Horsley Parish',
            'subtitle': 'The community website for Horsley Parish, Gloucestershire'
        };
        hpc.links = [];

        // if ($rootScope.globals == undefined) {
        //     $rootScope.globals = {};
        // }
        // if ($rootScope.globals.currentUser == undefined) {
        //     $rootScope.globals.currentUser = {};
        // }


        // function loadCurrentUser() {
        //     if ($rootScope.globals && $rootScope.globals.curentUser) {
        //         UserService.GetByUsername($rootScope.globals.currentUser.username)
        //             .then(function (user) {
        //                 hpc.user = user;
        //             });
        //     }
        // }


        // function logout() {
        //     UserService.ClearCredentials();
        //     hpc.user = undefined;
        // }

    }

})();
