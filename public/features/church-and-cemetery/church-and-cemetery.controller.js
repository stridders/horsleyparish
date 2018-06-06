(function() {

    angular.module('horsley')
        .controller('ChurchAndCemeteryController', ChurchAndCemeteryController);

    ChurchAndCemeteryController.$inject = [
        'FlashService',
        'GoogleDriveService',
        '$scope'
    ];

    function ChurchAndCemeteryController(FlashService,
                                     GoogleDriveService,
                                     $scope) {

        let ccc = this;

        ccc.pages = [];
        ccc.title = "St.Martin's Church and Cemetery";
        ccc.subtitle = "";
        ccc.titleBkg = "/glos/features/church/img/horsley_PC_logo_small.png";
        ccc.antiCache = Math.floor((Math.random()*1000000)+1);
        ccc.feature = "church-and-cemetery";

        initialise();

        function initialise() {

            ccc.pages = [
                {
                    title:      'St.Martin\'s Church',
                    subtitle:   'Church Council',
                    pageName:   'home'
                },
                {
                    title:      'Cemetery',
                    subtitle:   'General Information',
                    pageName:   'cemetery',
                }
            ];

            // getFileList("0B5mg3C3GfH8dam1zc05RTUFyaFE", "files");


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

    }


})();
