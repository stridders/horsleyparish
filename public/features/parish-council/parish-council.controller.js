(function() {

    angular.module('horsley')
        .controller('ParishCouncilController', ParishCouncilController);

    ParishCouncilController.$inject = ['Upload','$scope','moment','calendarConfig','ParishCouncilService'];

    function ParishCouncilController(Upload, $scope, moment, calendarConfig, ParishCouncilService) {
        let pcc = this;
        pcc.uploadMinutes = uploadMinutes;
        pcc.accountDocUpload = accountDocUpload;

        pcc.events = [];
        pcc.pages = [];
        pcc.accounting = {};
        pcc.calendarView = 'month';
        pcc.viewDate = moment().toDate();
        pcc.cellIsOpen = true;
        pcc.title = "Horsley Parish Council";
        pcc.subtitle = "";
        pcc.feature = "parish-council";

        initialise();

        function initialise() {
            ParishCouncilService.GetDocumentTypes("PC_ACCOUNT",function (response) {
                if (response) {
                    pcc.accounting.docTypeOptions = response.documentTypes;
                    pcc.accounting.upload = {
                        docType: pcc.accounting.docTypeOptions[0],
                    };
                } else {
                    let errMsg = "Unable to retieve document types from Horsley server";
                    FlashService.Error(errMsg);
                }
            });
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
                    title:      'Accounts',
                    subtitle:   'Annual reports',
                    pageName:   'accounts',
                    config:     {}
                },
                {
                    title:      'Contacts',
                    subtitle:   'How to get in touch',
                    pageName:   'contacts',
                },
                {
                    title:      'About the Parish',
                    subtitle:   'What constitutes the parish?',
                    pageName:   'about',
                },
                {
                    title:      'Meetings',
                    subtitle:   'Meeting schedules, agendas and minutes',
                    pageName:   'meetings',
                },
                {
                    title:      'Planning',
                    subtitle:   'Horsley Neighbourhood Plan',
                    pageName:   'planning',
                },
                {
                    title:      'Publications',
                    subtitle:   'Action plans, annual reports and other public documents',
                    pageName:   'publications',
                },
                {
                    title:      'Services',
                    subtitle:   'A list of council assets and services',
                    pageName:   'services',
                },
            ];
        }

        function accountDocUpload(file) {
            console.log("upload account document");
        }

        // upload on file select or drop
        function uploadMinutes(file) {

            Upload.upload({
                url: 'api/documents',
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


        $scope.$watchGroup([
            'pcc.calendarView',
            'pcc.viewDate'
        ], function() {

            // Use the rrule library to generate recurring events: https://github.com/jkbrzt/rrule
            let rule = new RRule({
                freq: RRule.WEEKLY,
                interval: 1,
                byweekday: [RRule.MO],
                dtstart: moment(pcc.viewDate).startOf(pcc.calendarView).toDate(),
                until: moment(pcc.viewDate).endOf(pcc.calendarView).toDate()
            });

            pcc.events = [{
                title: 'Recurs monthly',
                color: calendarConfig.colorTypes.warning,
                startsAt: moment().toDate(),
                recursOn: 'month'
            }, {
                title: 'Recurs yearly',
                color: calendarConfig.colorTypes.info,
                startsAt: moment().toDate(),
                recursOn: 'year'
            }];

            rule.all().forEach(function(date) {
                pcc.events.push({
                    title: 'Recurs weekly on mondays',
                    color: calendarConfig.colorTypes.success,
                    startsAt: new Date(date)
                });
            });

        });

        pcc.timespanClicked = function(date, cell) {

            if (pcc.calendarView === 'month') {
                if ((pcc.cellIsOpen && moment(date).startOf('day').isSame(moment(pcc.viewDate).startOf('day'))) || cell.events.length === 0 || !cell.inMonth) {
                    pcc.cellIsOpen = false;
                } else {
                    pcc.cellIsOpen = true;
                    pcc.viewDate = date;
                }
            } else if (pcc.calendarView === 'year') {
                if ((pcc.cellIsOpen && moment(date).startOf('month').isSame(moment(pcc.viewDate).startOf('month'))) || cell.events.length === 0) {
                    pcc.cellIsOpen = false;
                } else {
                    pcc.cellIsOpen = true;
                    pcc.viewDate = date;
                }
            }

        };

    }


})();
