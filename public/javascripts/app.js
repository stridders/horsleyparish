var app = angular.module('horsley', ['horsley.controllers']);

app.config(function($routeProvider) {

    $routeProvider

        .when('/', {
            controller  :   'HomePageController',
            controllerAs :  'hpc',
            templateUrl :   'web/features/home-page/home-page.html'

        })
        .when('/history', {
            controller  :   'HistoryController',
            controllerAs:   'hc',
            templateUrl :   'web/features/history/history.html'
        })

});
