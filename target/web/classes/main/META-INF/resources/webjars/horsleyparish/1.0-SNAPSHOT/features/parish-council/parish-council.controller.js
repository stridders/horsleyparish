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
                    title:      'Notes',
                    subtitle:   'News and Updates',
                    pageName:   'home'
                },
                {
                    title:      'About',
                    subtitle:   'Horsley parish council home page',
                    pageName:   'about',
                },
                {
                    title:      'Councillors',
                    subtitle:   'Members of the parish council',
                    pageName:   'councillors',
                },
                {
                    title:      'Dates',
                    subtitle:   'Meeting Dates',
                    pageName:   'dates',
                },
                {
                    title:      'Agenda',
                    subtitle:   'Next Meeting Date and Agenda',
                    pageName:   'agenda',
                    noCache:    'true'
                },
                {
                    title:      'Minutes',
                    subtitle:   'Links to Minute and Agenda Documents',
                    pageName:   'minutes',
                },
                {
                    title:      'Planning',
                    subtitle:   'Local Planning Applications, News and Issues',
                    pageName:   'Planning'
                },
                {
                    title:      'Map',
                    subtitle:   'Map of Horsley Parish Boundaries',
                    pageName:   'map'
                },
            ];

        }

    }


})();
