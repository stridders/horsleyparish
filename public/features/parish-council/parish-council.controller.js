(function() {

    angular.module('horsley')
        .controller('ParishCouncilController', ParishCouncilController);

    ParishCouncilController.$inject = ['$rootScope'];

    function ParishCouncilController($rootScope) {
        let pcc = this;
        pcc.config = {
            'title': 'Horsley Parish Council',
        };

    }

})();
