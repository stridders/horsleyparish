(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('pageLoader', pageLoader);

    pageLoader.$inject = ['$location', '$routeParams'];

    function pageLoader() {
        return {
            restrict:       'E',
            templateUrl:    'web/features/page-loader/page-loader.html',
            scope: {
                heading:    '=',
                subheading: '=',
                feature:    '=',
                pages:      '=',
            },
            controllerAs: 'pl',
            bindToController: true,

            controller: function($scope, $location, $routeParams) {

                let pl = this;
                pl.currentPage = $routeParams.page;
                let pageName;
                if (pl.currentPage) {
                    pageName = pl.feature + "-" + pl.currentPage + ".html";
                } else {
                    pageName = pl.feature + "-" + pl.pages[0].pageName + ".html";
                }
                pl.pageURL = "/web/features/"+pl.feature+"/" + pageName;
                pl.goto = goto;

                /**
                 * redirects to a new URL
                 * @param path
                 */
                function goto(page) {
                    $location.path(pl.feature).search('page',page.pageName);
                }

            }

        }
    }



})();