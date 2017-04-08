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
        pcc.title = "";
        pcc.subtitle = "";
        pcc.titleBkg = "/glos/features/parish-council/img/horsley_PC_logo_small.png";
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
                {
                    title:      'Planning',
                    subtitle:   'Local Planning Applications, News and Issues',
                    pageName:   'Planning'
                },
            ];

        }

    }


})();
