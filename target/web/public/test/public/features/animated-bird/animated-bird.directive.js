(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('animatedBird', animatedBird);

    animatedBird.$inject = [];

    function animatedBird() {
        return {
            restrict:       'E',
            templateUrl:    'web/features/animated-bird/animated-bird.html',
            controllerAs: 'ab',
            bindToController: true,

            controller: function() {
                let ab = this;
                ab.xpos = 10;
                ab.ypos = 60;



            }

        }
    }



})();
