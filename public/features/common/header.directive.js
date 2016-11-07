(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('header', header);

    header.$inject = [];

    function header() {
        return {
            restrict:       'E',
            templateUrl:    'web/features/common/header.html',
            controller: function() {
                let parallax = document.querySelectorAll(".parallax");
                let speed = [0.9, 0.7, 0.5];
                let initPos = [15, 30, 35];
                let transform = ["transform", "msTransform", "webkitTransform", "mozTransform", "oTransform"];
                let transformProperty = getSupportedPropertyName(transform);
                scrollImages();

                window.onscroll = function(){
                    scrollImages();
                };

                function getSupportedPropertyName(properties) {
                    for (var i = 0; i < properties.length; i++) {
                        if (typeof document.body.style[properties[i]] != "undefined") {
                            return properties[i];
                        }
                    }
                    return null;
                }

                function scrollImages() {
                    [].slice.call(parallax).forEach(function(el,i){
                        let windowYOffset = window.pageYOffset;
                        let newPos = (initPos[i] + (windowYOffset * speed[i]));
                        el.style[transformProperty] = "translate(0px, " + newPos + "px)";
                    });
                }
            }
        }
    }

})();
