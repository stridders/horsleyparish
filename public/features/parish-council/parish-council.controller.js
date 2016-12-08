(function() {

    angular.module('horsley')
        .controller('ParishCouncilController', ParishCouncilController);

    ParishCouncilController.$inject = ['Upload','$scope','moment','calendarConfig','ParishCouncilService'];

    function ParishCouncilController(Upload, $scope, moment, calendarConfig, ParishCouncilService) {
        let pcc = this;

        pcc.events = [];
        pcc.pages = [];
        pcc.accounting = {};
        pcc.calendarView = 'month';
        pcc.viewDate = moment().toDate();
        pcc.cellIsOpen = true;
        pcc.title = "Horsley Parish Council";
        pcc.subtitle = "";
        pcc.feature = "parish-council";

        pcc.timespanClicked = ParishCouncilService.timespanClicked;
        pcc.uploadMinutes = ParishCouncilService.uploadMinutes;
        pcc.accountDocUpload = ParishCouncilService.accountDocUpload;

        initialise();

        function initialise() {
            ParishCouncilService.getDocumentTypes("PC_ACCOUNT",function (response) {
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


    }


})();
