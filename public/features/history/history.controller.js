(function() {

    angular.module('horsley')
        .controller('HistoryController', HistoryController);

    HistoryController.$inject = [];

    function HistoryController() {
        let hc = this;
        hc.title = "A History of Horsley";
        hc.subtitle = "A series of extracts from the History of Horsley Parish, documented by the Institute of Historical Reasearch";
        hc.feature = "history";
        hc.pages = [
            {
                title:      'Home',
                subtitle:   'A History of Horsley',
                number:     '1',
                url:       '/web/features/history?page=1',
            },
            {
                title:      'Horsley Estates',
                subtitle:   'Horsley Manor and Surrounding Estates',
                number:     '2',
                url:        '/web/features/history?page=2',
            },
        ]
    }

})();
