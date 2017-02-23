(function() {

    angular.module('horsley')
        .controller('FileUploaderController', FileUploaderController);

    FileUploaderController.$inject = [
        'FlashService',
        'FileUploader',
        'AuthenticationService',
        'FileUploadService'
    ];

    function FileUploaderController(FlashService,
                                    FileUploader,
                                    AuthenticationService,
                                    FileUploadService) {

        let upl = this;
        let autoUpload = false;
        let maxFileSize = 2;
        let acceptFileTypes = "|jpg|png|jpeg|bmp|gif|pdf|";
        upl.maxQueueSize = 10;
        upl.formData = {
            fileTitle: null,
            docType: null,
            fileGroup: null,
            fileSize: null
        };
        upl.docTypeOptions = [];

        upl.uploader = new FileUploader({
            headers: AuthenticationService.GetSecurityHeader(),
            formData: [upl.formData],
            url: 'api/documents',
            removeAfterUpload: true,
            autoUpload: autoUpload
        });

        initialise();

        function initialise() {
            FileUploadService.getDocumentTypes(null,"ADMIN",function (response) {
                if (response) {
                    upl.docTypeOptions = response.documentTypes;
                } else {
                    let errMsg = "Unable to retieve document types from Horsley server";
                    FlashService.Error(errMsg);
                }
            });
            FileUploadService.initialiseSyncFilter(upl.uploader,upl.maxQueueSize,acceptFileTypes);
            FileUploadService.initialiseAsyncFilter(upl.uploader, 1e3);
            FileUploadService.configureCallbacks(upl.uploader,upl.formData);
        }

    }

})();