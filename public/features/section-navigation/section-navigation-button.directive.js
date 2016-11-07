(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('sectionNavBtn', sectionNavBtn);

    sectionNavBtn.$inject = ['$location'];

    function sectionNavBtn() {
        return {
            restrict:       'E',
            templateUrl:    'web/features/section-navigation/section-navigation-button.html',
            scope: {
                heading:  '@',
                title:    '@',
                image:    '@',
                text:     '@',
                link:     '@'
            },
            controllerAs: 'snb',
            bindToController: true,
            controller: function($scope, $location) {
                let snb = this;
                snb.redirect = redirectToURL;

                function redirectToURL(link) {
                    $location.path(link);
                }

            }
        }
    }



})();