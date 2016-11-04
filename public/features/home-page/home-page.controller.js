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
                title:   'The Horsley Monthly Magazine',
                image:   '/web/features/the-horses-mouth/images/ic_horses_mouth_sm.png',
                text:    '',
                link:    '/horses-mouth'
            },
            {
                heading: 'History',
                title:   'A history of Horsley Parish',
                image:   '/web/features/history/images/ic_history_sm.png',
                text:    '',
                link:    '/history'
            }
        ];
    }

})();
