(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('navbar', navbar);

    navbar.$inject = ['AuthenticationService', 'NavbarService', '$rootScope'];

    function navbar() {
        return {
            restrict: 'E',
            templateUrl: 'glos/features/navbar/navbar.html',
            scope: {
            },
            controllerAs: 'nbc',
            bindToController: true,

            controller: function (AuthenticationService, NavbarService, $rootScope) {

                let nbc = this;

                function initialisation() {
                    nbc.user = AuthenticationService.GetUserName();
                    let userRoles = AuthenticationService.GetUserRoles();
                    nbc.links = NavbarService.getDefaultLinks();

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
                        if (userRoles.length > 0 && userRoles.indexOf("ADMIN") > -1) {
                            nbc.links.push(
                                {
                                    heading: 'Upload',
                                    title:   'Upload Files(s)',
                                    image:   '/glos/img/upload.png',
                                    text:    '',
                                    link:    '/upload',
                                    bgcolour:  '#E54800'
                                },
                                {
                                    heading: 'User Admin',
                                    title:   'Manager User Accounts',
                                    image:   '/glos/img/users.png',
                                    text:    '',
                                    link:    '/admin-users',
                                    bgcolour:  '#E54800'
                                }
                            );
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

