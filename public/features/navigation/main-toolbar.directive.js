(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('mainToolbar', mainToolbar);

    mainToolbar.$inject = ['$rootScope'];

    function mainToolbar() {
        return {
            restrict: 'E',
            templateUrl: 'web/features/navigation/main-toolbar.html',
            scope: {
            },
            controllerAs: 'mtc',
            bindToController: true,

            controller: function ($rootScope) {

                let mtc = this;
                mtc.user = loadCurrentUser();

                mtc.links = [
                    {
                        heading: 'Home',
                        title:   'Hosrley Parish Home Page',
                        image:   '/web/images/home.png',
                        text:    '',
                        link:    '/'
                    },
                    {
                        heading: 'The Horses Mouth',
                        title:   'The Horsley Monthly Magazine',
                        image:   '/web/features/the-horses-mouth/images/ic_horses_mouth_sm_black.png',
                        text:    '',
                        link:    '/horses-mouth'
                    },
                    {
                        heading: 'Parish Council',
                        title:   'Horsley Parish Council',
                        image:   '/web/images/pc.png',
                        text:    '',
                        link:    '/pc'
                    },
                    {
                        heading: 'History',
                        title:   'A history of Horsley Parish',
                        image:   '/web/features/history/images/ic_history_sm_black.png',
                        text:    '',
                        link:    '/history'
                    },
                    {
                        heading: 'Login',
                        title:   'User login',
                        image:   '/web/images/login.png',
                        text:    '',
                        link:    '/login'
                    },
                    {
                        heading: 'Logoff',
                        title:   'Logout user:'+mtc.user,
                        image:   '/web/images/login_green.png',
                        text:    '',
                        link:    '/logoff'
                    }
                ];

                function loadCurrentUser() {
                    if ($rootScope.globals && $rootScope.globals.curentUser) {
                        UserService.GetByUsername($rootScope.globals.currentUser.username)
                            .then(function (user) {
                                mtc.user = user;
                            });
                    }
                }

            }

        }
    }

})();

