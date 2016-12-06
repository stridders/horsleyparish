(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('navbar', navbar);

    navbar.$inject = ['AuthenticationService', '$rootScope'];

    function navbar() {
        return {
            restrict: 'E',
            templateUrl: 'web/features/navbar/navbar.html',
            scope: {
            },
            controllerAs: 'nbc',
            bindToController: true,

            controller: function (AuthenticationService, $rootScope) {

                let nbc = this;

                function initialisation() {
                    nbc.user = AuthenticationService.GetUserName();
                    nbc.links = [
                        {
                            heading: 'Home',
                            title:   'Horsley Parish Home Page',
                            image:   '/web/img/home.png',
                            text:    '',
                            link:    '/'
                        },
                        {
                            heading: 'The Horses Mouth',
                            title:   'The Horsley Monthly Magazine',
                            image:   '/web/features/the-horses-mouth/img/ic_horses_mouth_sm_black.png',
                            text:    '',
                            link:    '/horses-mouth'
                        },
                        {
                            heading: 'Parish Council',
                            title:   'Horsley Parish Council',
                            image:   '/web/img/pc.png',
                            text:    '',
                            link:    '/parish-council'
                        },
                        {
                            heading: 'History',
                            title:   'A history of Horsley Parish',
                            image:   '/web/features/history/img/ic_history_sm_black.png',
                            text:    '',
                            link:    '/history'
                        }
                    ];
                    if (nbc.user) {
                        nbc.links.push(
                            {
                                heading: 'Logoff '+nbc.user,
                                title:   'Logout user: '+nbc.user,
                                image:   '/web/img/login_green.png',
                                text:    '',
                                link:    '/logout'
                            });
                    } else {
                        nbc.links.push(
                            {
                                heading: 'Login',
                                title:   'User login',
                                image:   '/web/img/login.png',
                                text:    '',
                                link:    '/login'
                            });
                    }
                }

                initialisation();

                $rootScope.$on('login:authenticated', function(event,currentUser) {
                    initialisation();
                });

                $rootScope.$on('login:rejected', function(event) {
                    initialisation();
                });

                $rootScope.$on('login:closed', function(event) {
                    initialisation();
                });

            }

        }
    }

})();

