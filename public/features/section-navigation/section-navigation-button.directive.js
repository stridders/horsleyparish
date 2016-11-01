(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('sectionNavBtn', sectionNavBtn);

    sectionNavBtn.$inject = [];

    function sectionNavBtn() {
        return {
            restrict:       'E',
            templateUrl:    'web/features/section-navigation/section-navigation-button.html',
            scope: {
                heading:  '@',
                image:    '@',
                text:     '@'
            },
            controllerAs: 'snb',
            bindToController: true,
            controller: function($scope) {
                let snb = this;
            }
        }
    }

})();