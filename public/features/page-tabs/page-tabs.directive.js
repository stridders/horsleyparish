(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('pageTabs', pageTabs);

    pageTabs.$inject = ['$location', '$routeParams'];

    function pageTabs() {
        return {
            restrict:       'E',
            templateUrl:    'glos/features/page-tabs/page-tabs.html',
            scope: {
                heading:    '=',
                subheading: '=',
                background: '=',
                feature:    '=',
                pages:      '=',
                scope:      '=',
            },
            controllerAs: 'pl',
            bindToController: true,

            controller: function($scope, $location, $routeParams) {

                let pl = this;
                pl.scope = this.scope;
                pl.currentPage = $routeParams.page;
                let pageName;
                if (pl.currentPage) {
                    pageName = pl.feature + "-" + pl.currentPage + ".html";
                } else {
                    pageName = pl.feature + "-" + pl.pages[0].pageName + ".html";
                    pl.currentPage = pl.pages[0].pageName;
                }
                pl.pageURL = "/glos/features/"+pl.feature+"/" + pageName;
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