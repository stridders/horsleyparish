(function() {

    angular.module('horsley')
        .controller('HistoryController', HistoryController);

    HistoryController.$inject = [];

    function HistoryController() {
        let hc = this;
        hc.title = "A History of Horsley";
        hc.subtitle = "There's far more to Horsley than meets the eye";
        hc.feature = "history";
        hc.pages = [
            {
                title:      'Home',
                subtitle:   'A History of Horsley',
                pageName:   '1',
            },
            {
                title:      'Horsley Estates',
                subtitle:   'Horsley Manor and Surrounding Estates',
                pageName:   '2',
            },
            {
                title:      'Economic History',
                subtitle:   '',
                pageName:   '3',
            },
            {
                title:      'Local Government',
                subtitle:   '',
                pageName:   '4',
            },
            {
                title:      'The Church',
                subtitle:   '',
                pageName:   '5',
            },
            {
                title:      'Non-Conformity',
                subtitle:   '',
                pageName:   '6',
            },
            {
                title:      'Education',
                subtitle:   '',
                pageName:   '7',
            },
            {
                title:      'Image Gallery',
                subtitle:   '',
                pageName:   '8',
            },
        ];
    }

})();
