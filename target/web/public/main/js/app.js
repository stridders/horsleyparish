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
                templateUrl: 'glos/features/home-page/home-page.html'

            })
            .when('/horsley-community-shop', {
                templateUrl: 'glos/features/horsley-community-shop/shop.html'
            })
            .when('/history', {
                controller: 'HistoryController',
                controllerAs: 'hc',
                templateUrl: 'glos/features/history/history.html'
            })
            .when('/about', {
                controller: 'AboutController',
                controllerAs: 'ac',
                templateUrl: 'glos/features/about/about.html'
            })
            .when('/village-hall', {
                controller: 'VillageHallController',
                controllerAs: 'vhc',
                templateUrl: 'glos/features/village-hall/village-hall.html'
            })
            .when('/church-and-cemetery', {
                controller: 'ChurchAndCemeteryController',
                controllerAs: 'ccc',
                templateUrl: 'glos/features/church-and-cemetery/church-and-cemetery.html'
            })
            .when('/horses-mouth', {
                controller: 'HorsesMouthController',
                controllerAs: 'hmc',
                templateUrl: 'glos/features/the-horses-mouth/horses-mouth.html'
            })
            .when('/parish-council', {
                controller: 'ParishCouncilController',
                controllerAs: 'pcc',
                templateUrl: 'glos/features/parish-council/parish-council.html'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'glos/features/login/login.html',
                controllerAs: 'lc'
            })
            .when('/logout', {
                template:   '<div></div>',
                controller: 'LogoutController'
            })
            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'glos/features/login/register.html',
                controllerAs: 'reg'
            })
            .when('/admin-users', {
                controller: 'UsersController',
                templateUrl: 'glos/admin/users/users.html'
            })


        $stateProvider

            .state('home', {
                url: '/',
                controller: 'HomePageController',
                controllerAs: 'hpc',
                templateUrl: 'glos/features/home-page/home-page.html'
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