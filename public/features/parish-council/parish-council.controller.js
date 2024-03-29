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
                    title:      'Planning',
                    subtitle:   'Horsley Neighbourhood Plan, Applications and Related Notices',
                    pageName:   'Planning'
                },
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
                    title:      'Meeting Dates',
                    subtitle:   'Meeting Dates',
                    pageName:   'dates',
                },
                {
                    title:      'Minutes & Agendas',
                    subtitle:   'Links to Minute and Agenda Documents',
                    pageName:   'minutes',
                },
                {
                    title:      'Reports and Documents',
                    subtitle:   'View Parish Council Reports and Documents',
                    pageName:   'documents'
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
            getFileList("0B5mg3C3GfH8dTGoyQTNKTXpKamc", "minutes");
            getFileList("1qpNsCUKS54geU-sy43QVDiW12CBvz9O0", "np_docs");
            getFileList("1LHFB-WKvfC8unhrQEK9Cy1N8vunNQ7W6", "np_sup_docs");
        }

        function getFileList(id,variableName) {
            GoogleDriveService.getFileList(id, function (response) {
                if (response) {
                    pcc[variableName] = response
                        .sort(function(a,b){
                                return a.name > b.name;
                            }
                        );
                    pcc[variableName].size = (Math.ceil(response.length/4)*280) + "px";
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

        pcc.toggle_showFR2020 = function() {
            pcc.showFR2020 = !pcc.showFR2020;
            if (pcc.showFR2020) {
                getFileList("17kFIVE7mLl7JT3Glj-T0H0oOGltRi7dJ", "FR2020");
            }
        };

        pcc.toggle_showFR2021 = function() {
            pcc.showFR2021 = !pcc.showFR2021;
            if (pcc.showFR2021) {
                getFileList("1D_RmYu3GO1I9Fj4kzE0sb7unuX2HaTgq", "FR2021");
            }
        };

        pcc.toggle_showFR2022 = function() {
            pcc.showFR2022 = !pcc.showFR2022;
            if (pcc.showFR2022) {
                getFileList("1-Iw5njCuTJLzDGTxXI1tvVYUtU6pUh6p", "FR2022");
            }
        };

        pcc.toggle_showFR2023 = function() {
            pcc.showFR2023 = !pcc.showFR2023;
            if (pcc.showFR2023) {
                getFileList("1zuoQDTDfCD7xd3qTFpQYtT9brh49yrn9", "FR2023");
            }
        };

    }


})();
