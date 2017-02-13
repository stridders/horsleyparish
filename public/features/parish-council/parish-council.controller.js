(function() {

    angular.module('horsley')
        .controller('ParishCouncilController', ParishCouncilController);

    ParishCouncilController.$inject = [
        'FlashService',
        'FileUploader',
        'AuthenticationService',
        'FileUploadService',
        'ParishCouncilService',
        '$scope'
    ];

    function ParishCouncilController(FlashService,
                                     FileUploader,
                                     AuthenticationService,
                                     FileUploadService,
                                     ParishCouncilService,
                                     $scope) {

        let pcc = this;

        pcc.pages = [];
        pcc.title = "Horsley Parish Council";
        pcc.subtitle = "";
        pcc.antiCache = Math.floor((Math.random()*1000000)+1);
        pcc.feature = "parish-council";

        initialise();

        function initialise() {

            pcc.pages = [
                {
                    title:      'Home',
                    subtitle:   'Horsley parish council home page',
                    pageName:   'home',
                },
                {
                    title:      'Councillors',
                    subtitle:   'Members of the parish council',
                    pageName:   'councillors',
                },
                {
                    title:      'Parish Council Boundaries',
                    subtitle:   'Map of Horsley Parish',
                    pageName:   'map'
                },
                {
                    title:      'Meetings',
                    subtitle:   'Meeting schedules, agendas and minutes',
                    pageName:   'meetings',
                    noCache:    'true'
                },
            ];

        }

    }


})();
