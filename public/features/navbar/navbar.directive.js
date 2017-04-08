(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('navbar', navbar);

    navbar.$inject = ['AuthenticationService', '$rootScope'];

    function navbar() {
        return {
            restrict: 'E',
            templateUrl: 'glos/features/navbar/navbar.html',
            scope: {
            },
            controllerAs: 'nbc',
            bindToController: true,

            controller: function (AuthenticationService, $rootScope) {

                let nbc = this;

                function initialisation() {
                    nbc.user = AuthenticationService.GetUserName();
                    let userRoles = AuthenticationService.GetUserRoles();
                    nbc.links = [
                        {
                            heading: 'Home',
                            title:   'Horsley Parish Home Page',
                            image:   '/glos/img/home.png',
                            text:    '',
                            link:    '/',
                            bgcolour:  '#4E342E'
                        },
                        {
                            heading: 'Community Shop',
                            title:   'Horsley Community Shop',
                            image:   '/glos/img/ico-shop.png',
                            text:    '',
                            link:    '/horsley-community-shop',
                            bgcolour:  '#FFFFFF'
                        },
                        {
                            heading: 'Village Hall',
                            title:   'Horsley Village Hall',
                            image:   '/glos/img/ico-village-hall.png',
                            text:    '',
                            link:    '/village-hall',
                            bgcolour:  '#00796B'
                        },
                        {
                            heading: 'The Horses Mouth',
                            title:   'The Horsley Monthly Magazine',
                            image:   '/glos/features/the-horses-mouth/img/ic_horses_mouth_sm_black.png',
                            text:    '',
                            link:    '/horses-mouth',
                            bgcolour:  '#4E342E'
                        },
                        {
                            heading: 'Parish Council',
                            title:   'Horsley Parish Council',
                            image:   '/glos/img/pc.png',
                            text:    '',
                            link:    '/parish-council',
                            bgcolour:  '#4E342E'
                        },
                        {
                            heading: 'History',
                            title:   'A history of Horsley Parish',
                            image:   '/glos/features/history/img/ic_history_sm_black.png',
                            text:    '',
                            link:    '/history',
                            bgcolour:  '#00796B'
                        }
                    ];
                    if (nbc.user) {
                        nbc.links.push(
                            {
                                heading: 'Logoff '+nbc.user,
                                title:   'Logout user: '+nbc.user,
                                image:   '/glos/img/login_green.png',
                                text:    '',
                                link:    '/logout',
                                bgcolour:  '#FFFFFF'
                            });
                        if (userRoles.length > 0) {
                            nbc.links.push(
                                {
                                    heading: 'Upload',
                                    title:   'Upload Files(s)',
                                    image:   '/glos/img/upload.png',
                                    text:    '',
                                    link:    '/upload',
                                    bgcolour:  '#E54800'
                                });
                        }
                    } else {
                        nbc.links.push(
                            {
                                heading: 'Login',
                                title:   'User login',
                                image:   '/glos/img/login.png',
                                text:    '',
                                link:    '/login',
                                bgcolour:  '#FFFFFF'
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
                    AuthenticationService.ClearCredentials();
                    initialisation();
                });

            }

        }
    }

})();

