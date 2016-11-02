var app = angular.module('horsley', ['horsley.controllers']);

app.config(function($routeProvider) {

    $routeProvider

        .when('/', {
            controller  :   'HomePageController',
            templateUrl :   'web/features/home-page/home-page.html'

        })



});
