var app = angular.module('horsleyParish', [
    'horsleyParish.controllers',
    'ngRoute',
    'ngResource']);

app.config(function($routeProvider) {

    $routeProvider

        .when('/', {
            redirectTo  :   '/help'
        })
        .when('/me', {
            templateUrl  :   'web/pages/common/page-header.html'
            //controller    :   'ddd.controller'
        })

});
