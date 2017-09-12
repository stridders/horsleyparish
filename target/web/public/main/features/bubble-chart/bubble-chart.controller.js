(function() {

    angular.module('horsley')
        .controller('BubbleChartController', BubbleChartController);

    BubbleChartController.$inject = [];

    function BubbleChartController() {
        let bcc = this;
        bcc.config = {
            'title': 'Bubble Chart',
            'subtitle': 'Test Page'
        };
        bcc.links = [];

        var url = 'glos/features/sample.pdf';
        //var url = '//cdn.mozilla.net/pdfjs/helloworld.pdf';

        // Disable workers to avoid yet another cross-origin issue (workers need
        // the URL of the script to be loaded, and dynamically loading a cross-origin
        // script does not work).
        //PDFJS.disableWorker = true;

        // The workerSrc property shall be specified.
        PDFJS.workerSrc = 'http://mozilla.github.io/pdf.js/build/pdf.worker.js';

        // Asynchronous download of PDF
        var loadingTask = PDFJS.getDocument(url);
        loadingTask.then(function(pdf) {
            console.log('PDF loaded');

            // Fetch the first page
            var pageNumber = 1;
            pdf.getPage(pageNumber).then(function(page) {
                console.log('Page loaded');

                var scale = 1.5;
                var viewport = page.getViewport(scale);

                // Prepare canvas using PDF page dimensions
                bcc.canvas = document.getElementById('the-canvas');
                var context = bcc.canvas.getContext('2d');
                bcc.canvas.height = viewport.height;
                bcc.canvas.width = viewport.width;

                // Render PDF page into canvas context
                var renderContext = {
                    canvasContext: context,
                    viewport: viewport
                };
                var renderTask = page.render(renderContext);
                renderTask.then(function () {
                    console.log('Page rendered');
                });
            });
        }, function (reason) {
            // PDF loading error
            console.error(reason);
        });

    }

})();
