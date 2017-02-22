(function() {

    angular.module('horsley')
        .controller('VillageHallController', VillageHallController);

    VillageHallController.$inject = ['$scope'];

    function VillageHallController($scope) {
        let vhc = this;
        vhc.title = "Horsley Village Hall";
        vhc.subtitle = "A great venue for public and private events";
        vhc.feature = "village-hall";
        vhc.pages = [
            {
                title:      'Home',
                subtitle:   'Horsley Village Hall',
                pageName:   '1',
            },
            {
                title:      'Management',
                subtitle:   'Management and Maintenance',
                pageName:   '2',
            },
            {
                title:      'Booking',
                subtitle:   'Booking calendar',
                pageName:   '3',
            },
            {
                title:      'Facilities',
                subtitle:   'Hall specifications and facilities',
                pageName:   '4',
            },
            {
                title:      'History',
                subtitle:   'Evolution of the Village Hall',
                pageName:   '5',
            },
        ];
        vhc.uploadMinutes = {};
        vhc.accountDocUpload = {};

    }

})();
