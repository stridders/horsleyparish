(function() {

    angular.module('horsley')
        .controller('AboutController', AboutController);

    AboutController.$inject = ['NavbarService'];

    function AboutController(NavbarService) {
        let ac = this;
        ac.config = {
            'title': 'About Horsley',
            'subtitle': 'A quick introduction to Horsley, Gloucestershire'
        };

        ac.links = NavbarService.getDefaultLinks();

    }

})();