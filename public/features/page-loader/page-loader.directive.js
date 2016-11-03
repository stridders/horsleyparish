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
                title:      '@',
                subtitle:   '@',
                feature:    '@',
                pages:      '@',
            },
            controllerAs: 'pl',
            bindToController: true,

            controller: function($scope, $location, $routeParams) {

                let pl = this;
                pl.goto = goto;
                pl.pageName = setPageName();

                /**
                 * Sets the current HTML page name, based on URL params (if present)
                 */
                function setPageName() {
                    // Set default page name (e.g. history.html)
                    let pageName = pl.feature + ".html";

                    // If pageName URL parameter present, set pageName accordingly
                    if ($routeParams.pageName) {
                        pageName = $routeParams.pageName + ".html";
                    } else {
                        // Else if page number URL param prsent, then set pageName based on page number
                        if ($routeParams.page) {
                            pageName = pl.feature + $routeParams.page + ".html";
                        }
                    }
                    return pageName;
                }

                /**
                 * redirects to a new URL
                 * @param path
                 */
                function goto(path) {
                    $location.path(path);
                }

            }

        }
    }



})();