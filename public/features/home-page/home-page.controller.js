(function() {

    angular.module('horsley')
        .controller('HomePageController', HomePageController);

    HomePageController.$inject = [];

    function HomePageController() {
        let hpc = this;
        hpc.config = {
            'title': 'Welcome to Horsley Parish',
            'subtitle': 'The community website for Horsley Parish, Gloucestershire'
        };
        console.log("---->"+JSON.stringify(hpc.config))
    }

})();
