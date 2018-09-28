(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('animatedBird', animatedBird);

    animatedBird.$inject = [];

    function animatedBird() {
        return {
            restrict:       'E',
            templateUrl:    'glos/features/animated-bird/animated-bird.html',
            controllerAs: 'ab',
            bindToController: true,

            controller: function() {
                let ab = this;
                ab.birds = [
                    {
                        top: 40,
                        iterations: 1,
                        delay: '2s'
                    },
                    {
                        top: 20,
                        iterations: 3,
                        delay: '0s'
                    },
                    {
                        top: 25,
                        iterations: 4,
                        delay: '0.4s'
                    },
                    {
                        top: 18,
                        iterations: 1,
                        delay: '14s'
                    },
                    {
                        top: 22,
                        iterations: 1,
                        delay: '10s'
                    }
                ];

            }

        }
    }



})();
