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
        pcc.showFR2016 = false;
        pcc.showFR2017 = false;
        pcc.showFR2018 = false;
        pcc.showFR2019 = false;

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
                    title:      'Reports and Documents',
                    subtitle:   'View Parish Council Reports and Documents',
                    pageName:   'documents'
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

            getFileList("0B5mg3C3GfH8dam1zc05RTUFyaFE", "files");
            getFileList("1WuXsxBENQWrnoBq2dZbg3QJm_OiscMMn", "reports");
            getFileList("1Yu4VbOK7ujk9c7qxb5dEL2SeyCR36Ckp", "documents");
        }

        function getFileList(id,variableName) {
            GoogleDriveService.getFileList(id, function (response) {
                if (response) {
                    pcc[variableName] = response
                        .sort(function(a,b){
                                return a.name > b.name;
                            }
                        );
                } else {
                    let errMsg = "Unable to retrieve file list from Google Drive folder";
                    FlashService.Error(errMsg);
                }
            })
        }

        pcc.toggle_showFR2016 = function() {
            pcc.showFR2016 = !pcc.showFR2016;
            if (pcc.showFR2016) {
                getFileList("1OVZ5x30flDGaFaiFLIgooK7WhUYtjQ8y", "FR2016");
            }
        };

        pcc.toggle_showFR2017 = function() {
            pcc.showFR2017 = !pcc.showFR2017;
            if (pcc.showFR2017) {
                getFileList("1Kl6PJCOdvjRYwhHXbz1PZyWnXV5SbKeO", "FR2017");
            }
        };

        pcc.toggle_showFR2018 = function() {
            pcc.showFR2018 = !pcc.showFR2018;
            if (pcc.showFR2018) {
                getFileList("1QxWWeMvJ5xhAUyLaKl9BVmeuAsmwCnEv", "FR2018");
            }
        };

        pcc.toggle_showFR2019 = function() {
            pcc.showFR2019 = !pcc.showFR2019;
            if (pcc.showFR2019) {
                getFileList("1YLsVvXVfx6RLFfAaeZYD0LF2nJWzQPaE", "FR2019");
            }
        };

    }


})();
