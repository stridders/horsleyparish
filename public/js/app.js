(function () {

    angular
        .module('horsley', ['horsley.controllers','horsley.services'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider) {

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
            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'web/features/login/register.html',
                controllerAs: 'reg'
            });

    }

    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];

    function run($scope, $cookies, $http) {
        $scope.currentUser = $cookies['currentUser'];
        console.log("App init: Cur User="+$scope.currentUser);
        if ($scope.currentUser && $scope.currentUser.authdata) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $scope.currentUser.authdata;
        }
    }

})();