(function() {

    angular.module('horsley')
        .controller('ParishCouncilController', ParishCouncilController);

    ParishCouncilController.$inject = [
        'FlashService',
        'GoogleDriveService',
        '$scope'
    ];

    function ParishCouncilController(FlashService,
                                     GoogleDriveService,
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
                    title:      'Notices',
                    subtitle:   'News and Updates',
                    pageName:   'notices'
                },
                {
                    title:      'About',
                    subtitle:   'About parish councils',
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

            getFileList("0B5mg3C3GfH8dam1zc05RTUFyaFE");

        }

        function getFileList(id) {

            GoogleDriveService.getFileList(id, function (response) {
                if (response) {
                    pcc.files = response
                        .sort(function(a,b){
                                return a.name > b.name;
                            }
                        );

                } else {
                    let errMsg = "Unable to retrieve file list from Google Drive folder";
                    FlashService.Error(errMsg);
                }
            });
        }

    }


})();
