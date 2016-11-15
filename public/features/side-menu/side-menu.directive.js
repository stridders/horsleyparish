(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('sideMenu', sideMenu);

    sideMenu.$inject = ['$location'];

    function sideMenu() {
        return {
            restrict:       'E',
            templateUrl:    'web/features/side-menu/side-menu.html',
            scope: {
                tabTitle:    '@',
            },
            controllerAs: 'smc',
            bindToController: true,
            controller: function($scope, $location) {
                let smc = this;
                smc.displayed = false;
                smc.redirect = redirectToURL;

                smc.links = [
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
                    },
                    {
                        heading: 'History',
                        title:   'A history of Horsley Parish',
                        image:   '/web/features/history/images/ic_history_sm.png',
                        text:    '',
                        link:    '/history'
                    },
                    {
                        heading: 'History',
                        title:   'A history of Horsley Parish',
                        image:   '/web/features/history/images/ic_history_sm.png',
                        text:    '',
                        link:    '/history'
                    }

                ];


                function redirectToURL(link) {
                    $location.path(link);
                }

                smc.toggleMenu = function() {
                    console.log("Clicked");
                    smc.displayed = !smc.displayed;
                }
            }
        }
    }



})();