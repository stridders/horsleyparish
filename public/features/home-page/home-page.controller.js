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
        hpc.links = [
            {
                heading: 'The Horses Mouth',
                icon: 'icon-horses-mouth',
                text: 'The Horsley Monthly Magazine',
                link:   '/horses-mouth'

            },
            {
                heading: 'History',
                icon: 'icon-history',
                text: 'A history of Horsley Parish',
                link:   '/history'
            }
        ];
    }

})();
