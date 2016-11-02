(function() {

    angular.module('horsley')
        .controller('HomePageController', HomePageController);

    HomePageController.$inject = [];

    function HomePageController() {
        let hpc = this;
        hpc.config = {
            title: 'Welcome to Horsley Parish',
            subtitle: 'The community website for Horsley Parish, Gloucestershire'
        };
        hpc.links = [
            {
                heading: 'The Horses Mouth',
                image: '/web/pages/the-horses-mouth/images/icon_sm.png',
                text: 'The Horsley Monthly Magazine'
            }
        ];

    }

})();
