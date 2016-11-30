(function() {

    angular.module('horsley')
        .controller('ParishCouncilController', ParishCouncilController);

    ParishCouncilController.$inject = ['Upload'];

    function ParishCouncilController(Upload) {
        let pcc = this;
        pcc.uploadMinutes = uploadMinutes;

        pcc.config = {
            'title': 'Horsley Parish Council',
        };

        // upload on file select or drop
        function uploadMinutes(file) {

            Upload.upload({
                url: 'document',
                data: {
                    file: file,
                    documentType: 'PC_MINUTES',
                    name: 'Test Minutes PDF file',
                    meetingId: '1001'
                }
            }).then(function (resp) {
                console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
            }, function (resp) {
                console.log('Error status: ' + resp.status);
            }, function (evt) {
                var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file);
                pcc.file = evt.config.data.file;
            });
        };

    }

})();
