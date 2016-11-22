(function() {

    angular.module('horsley')
        .controller('HomePageController', HomePageController);

    HomePageController.$inject = ['UserService', '$rootScope'];

    function HomePageController(UserService, $rootScope) {
        let hpc = this;
        hpc.config = {
            'title': 'Welcome to Horsley Parish',
            'subtitle': 'The community website for Horsley Parish, Gloucestershire'
        };
        hpc.links = [];
        hpc.user = null;
        hpc.logout = logout;

        if ($rootScope.globals == undefined) {
            $rootScope.globals = {};
        }
        if ($rootScope.globals.currentUser == undefined) {
            $rootScope.globals.currentUser = {};
        }

        initController();

        function initController() {
            loadCurrentUser();
        }

        function loadCurrentUser() {
            if ($rootScope.globals && $rootScope.globals.curentUser) {
                UserService.GetByUsername($rootScope.globals.currentUser.username)
                    .then(function (user) {
                        hpc.user = user;
                    });
            }
        }


        function logout() {
            UserService.ClearCredentials();
            hpc.user = undefined;
        }

    }

})();
