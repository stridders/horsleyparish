(function() {

    angular.module('horsley')
        .controller('BubbleChartController', BubbleChartController);

    BubbleChartController.$inject = [];

    function BubbleChartController() {
        let bcc = this;
        bcc.config = {
            'title': 'Bubble Chart',
            'subtitle': 'Test Page'
        };
        bcc.links = [];

    }

})();
