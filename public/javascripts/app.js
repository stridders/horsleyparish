var app = angular.module('horsley', ['horsley.controllers']);

app.config(function($routeProvider) {

    $routeProvider

        .when('/', {
            templateUrl  :   'web/pages/home.html'
        })
        .when('/help', {
            redirectTo  :   'web/pages/help/index.html'
            //templateUrl  :   '/web/pages/help/index.html'
            //controller    :   'ddd.controller'
        })


});
