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
                pl.currentPageName = $routeParams.name;
                let pageName = setPageName();
                pl.pageURL = "/web/features/"+pl.feature+"/" + pageName;
                pl.goto = goto;

                /**
                 * Sets the current HTML page name, based on URL params (if present)
                 */
                function setPageName() {
                    // Set default page name (e.g. history.html)
                    let pageName = pl.feature + ".html";

                    // If pageName URL parameter present, set pageName accordingly
                    if (pl.currentPageName) {
                        pageName = pl.currentPageName + ".html";
                    } else {
                        // Else if page number URL param prsent, then set pageName based on page number
                        if (pl.currentPage) {
                            pageName = pl.feature + pl.currentPage + ".html";
                        }
                    }
                    return pageName;
                }

                /**
                 * redirects to a new URL
                 * @param path
                 */
                function goto(page) {
                    if (page.name) {
                        $location.path(pl.feature).search('name',page.pageName);
                    } else {
                        $location.path(pl.feature).search('page',page.pageNumber);
                    }

                }

            }

        }
    }



})();