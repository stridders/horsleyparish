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
                pageNumber: '1',
            },
            {
                title:      'Horsley Estates',
                subtitle:   'Horsley Manor and Surrounding Estates',
                pageNumber: '2',
            },
            {
                title:      'Economic History',
                subtitle:   '',
                pageNumber: '3',
            },
        ];
    }

})();
