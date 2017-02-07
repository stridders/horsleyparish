(function() {

    angular.module('horsley')
        .controller('HorsesMouthController', HorsesMouthController);

    HorsesMouthController.$inject = [
        'FlashService',
        'FileUploader',
        'AuthenticationService',
        'FileUploadService',
        'HorsesMouthService',
        '$scope'
    ];

    function HorsesMouthController(FlashService,
                                   FileUploader,
                                   AuthenticationService,
                                   FileUploadService,
                                   HorsesMouthService,
                                   $scope) {

        let hmc = this;
        let autoUpload = false;
        let acceptFileTypes = "|pdf|";
        hmc.maxQueueSize = 10;
        hmc.magazineLinks = {documents:[]};
        hmc.formData = {
            fileTitle: null,
            docType: "HORSES_MOUTH",
            fileGroup: "Magazine",
            fileSize: null
        };
        hmc.filteredDocs = [];
        hmc.currentPage = 0;
        hmc.pageSize = 4;

        hmc.setPage = function (pageNo) {
            hmc.currentPage = pageNo;
        };

        hmc.pageChanged = function() {
        };

        hmc.uploader = new FileUploader({
            headers: AuthenticationService.GetSecurityHeader(),
            formData: [hmc.formData],
            url: 'api/documents',
            removeAfterUpload: true,
            autoUpload: autoUpload
        });

        initialise();

        $scope.$watch('hmc.currentPage + hmc.pageSize', function() {
            let begin = ((hmc.currentPage - 1) * hmc.pageSize)
                , end = begin + hmc.pageSize;

            hmc.filteredDocs = hmc.magazineLinks.documents.slice(begin, end);
        });

        function initialise() {
            FileUploadService.initialiseSyncFilter(hmc.uploader,hmc.maxQueueSize,acceptFileTypes);
            FileUploadService.initialiseAsyncFilter(hmc.uploader, 1e3);
            FileUploadService.configureCallbacks(hmc.uploader,hmc.formData);
            hmc.showUploader = AuthenticationService.UserHasRole("HORSES_MOUTH");

            HorsesMouthService.getMagazineLinks(function (response) {
                if (response) {
                    hmc.magazineLinks = response;
                    hmc.filteredDocs = hmc.magazineLinks.documents.slice(0, hmc.pageSize);
                    hmc.totalItems = hmc.magazineLinks.documents.length;
                } else {
                    let errMsg = "Unable to retrieve magazines from Horsley server";
                    FlashService.Error(errMsg);
                }
            });

        }


    }

})();