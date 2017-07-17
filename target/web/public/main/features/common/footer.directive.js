(function() {
    'use strict';

    angular
        .module('horsley')
        .directive('footer', footer);

    footer.$inject = ['NavbarService'];

    function footer(NavbarService) {
        return {
            restrict:       'E',
            templateUrl:    'glos/features/common/footer.html',
            controllerAs:   'fd',
            controller: function() {
                let fd = this;
                fd.links = NavbarService.getDefaultLinks();
            }
        }
    }

})();
