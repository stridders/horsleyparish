(function() {

    angular.module('horsley')
        .controller('HomePageController', HomePageController);

    HomePageController.$inject = ['NavbarService'];

    function HomePageController(NavbarService) {
        let hpc = this;
        hpc.config = {
            'title': 'Welcome to Horsley Parish',
            'subtitle': 'The community website for Horsley Parish, Gloucestershire'
        };

        hpc.links = NavbarService.getDefaultLinks();
        hpc.show_form = true;
    }

})();
