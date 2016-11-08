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