(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('mainToolbar', mainToolbar);

    mainToolbar.$inject = ['$location', '$routeParams'];

    function mainToolbar() {
        return {
            restrict: 'E',
            templateUrl: 'web/features/navigation/main-toolbar.html',
            scope: {
            },
            controllerAs: 'mtc',
            bindToController: true,

            controller: function ($scope, $location, $routeParams) {

                let mtc = this;

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
                    }
                ];

            }

        }
    }

})();

