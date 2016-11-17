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
        hpc.allUsers = [];
        hpc.deleteUser = deleteUser;
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
            loadAllUsers();
            setLinks();
        }

        function loadCurrentUser() {
            if ($rootScope.globals && $rootScope.globals.curentUser) {
                UserService.GetByUsername($rootScope.globals.currentUser.username)
                    .then(function (user) {
                        hpc.user = user;
                    });
            }
        }

        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    hpc.allUsers = users;
                });
        }

        function deleteUser(id) {
            UserService.Delete(id)
                .then(function () {
                    loadAllUsers();
                });
        }

        function logout() {
            UserService.ClearCredentials();
            hpc.user = undefined;
        }

        function setLinks() {
            hpc.links = [
                {
                    heading: 'The Horses Mouth',
                    title:   'The Horsley Monthly Magazine',
                    image:   '/web/features/the-horses-mouth/images/ic_horses_mouth_sm.png',
                    text:    '',
                    link:    '/horses-mouth'
                },
                {
                    heading: 'History',
                    title:   'A history of Horsley Parish',
                    image:   '/web/features/history/images/ic_history_sm.png',
                    text:    '',
                    link:    '/history'
                }
            ];
        }
    }

})();
