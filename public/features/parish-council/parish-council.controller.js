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
        pcc.antiCache = "D."+Date.now();
        pcc.feature = "parish-council";
        let autoUpload = false;
        let acceptFileTypes = "|pdf|doc|docx";
        pcc.maxQueueSize = 10;
        pcc.minutesLinks = {documents:[]};
        pcc.formData = {
            fileTitle: null,
            docType: "PC_MEET_MINUTES",
            fileGroup: "Minutes",
            fileSize: null
        };
        pcc.filteredDocs = [];
        pcc.currentPage = 0;
        pcc.pageSize = 4;

        pcc.setPage = function (pageNo) {
            pcc.currentPage = pageNo;
        };

        pcc.pageChanged = function() {
        };

        pcc.uploader = new FileUploader({
            headers: AuthenticationService.GetSecurityHeader(),
            formData: [pcc.formData],
            url: 'api/documents',
            removeAfterUpload: true,
            autoUpload: autoUpload
        });

        initialise();

        $scope.$watch('pcc.currentPage + pcc.pageSize', function() {
            let begin = ((pcc.currentPage - 1) * pcc.pageSize)
                , end = begin + pcc.pageSize;

            pcc.filteredDocs = pcc.minutesLinks.documents.slice(begin, end);
        });

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
            FileUploadService.initialiseSyncFilter(pcc.uploader,pcc.maxQueueSize,acceptFileTypes);
            FileUploadService.initialiseAsyncFilter(pcc.uploader, 1e3);
            FileUploadService.configureCallbacks(pcc.uploader,pcc.formData);
            pcc.showUploader = AuthenticationService.UserHasRole("HORSLEY_PC");

            ParishCouncilService.getMinutesLinks(function (response) {
                if (response) {
                    pcc.minutesLinks = response;
                    pcc.filteredDocs = pcc.minutesLinks.documents.slice(0, pcc.pageSize);
                    pcc.totalItems = pcc.minutesLinks.documents.length;
                } else {
                    let errMsg = "Unable to retrieve meeting minutes from Horsley server";
                    FlashService.Error(errMsg);
                }
            });
        }


        pcc.setFile = function(element) {
            var $scope = this.$scope;
            $scope.$apply(function() {
                $scope.filename = element.files[0];
            });
        };





    }


})();
