(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('navbarButton', navbarButton);

    navbarButton.$inject = ['$location'];

    function navbarButton() {
        return {
            restrict:       'E',
            templateUrl:    'web/features/navbar/navbar-button.html',
            scope: {
                heading:  '@',
                title:    '@',
                image:    '@',
                text:     '@',
                link:     '@',
                bgcolour: '@'
            },
            controllerAs: 'snb',
            bindToController: true,
            controller: function($scope, $location) {
                let snb = this;
                snb.hdrClass = "sec-nav-hdr-hide";

                snb.redirect = redirectToURL;
                snb.showHdr = showHdr;
                snb.hideHdr = hideHdr;

                function redirectToURL(link) {
                    $location.path(link);
                }

                function showHdr() {
                    snb.hdrClass = "sec-nav-hdr-show";
                }

                function hideHdr() {
                    snb.hdrClass = "sec-nav-hdr-hide";
                }

            }
        }
    }



})();