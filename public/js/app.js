(function () {

    angular
        .module('horsley', ['horsley.controllers','horsley.services'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$stateProvider'];
    function config($routeProvider, $stateProvider) {

        $routeProvider

            .when('/', {
                controller: 'HomePageController',
                controllerAs: 'hpc',
                templateUrl: 'web/features/home-page/home-page.html'

            })
            .when('/history', {
                controller: 'HistoryController',
                controllerAs: 'hc',
                templateUrl: 'web/features/history/history.html'
            })
            .when('/pc', {
                controller: 'ParishCouncilController',
                templateUrl: 'web/features/parish-council/parish-council.html',
                controllerAs: 'pcc'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'web/features/login/login.html',
                controllerAs: 'lc'
            })
            .when('/logout', {
                template:   '<div></div>',
                controller: 'LogoutController'
            })
            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'web/features/login/register.html',
                controllerAs: 'reg'
            });

        $stateProvider

            .state('home', {
                url: '/',
                controller: 'HomePageController',
                controllerAs: 'hpc',
                templateUrl: 'web/features/home-page/home-page.html'
            });

    }

    run.$inject = ['$http','AuthenticationService'];

    function run($http, AuthenticationService) {
        let currentUser = AuthenticationService.GetUserContext();
        if (currentUser && currentUser.authdata) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + currentUser.authdata;
        }
    }

})();