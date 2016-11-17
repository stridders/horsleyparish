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
        .when('/login', {
            controller:     'LoginController',
            templateUrl:    'web/features/login/login.html',
            controllerAs:   'log'
        })

        .when('/register', {
            controller:     'RegisterController',
            templateUrl:    'web/features/login/register.html',
            controllerAs:   'reg'
        });

    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }


});
