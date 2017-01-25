(function() {

    angular.module('horsley')
        .controller('VillageHallController', VillageHallController);

    VillageHallController.$inject = ['$scope','moment','calendarConfig','CalendarService'];

    function VillageHallController($scope, moment, calendarConfig, CalendarService) {
        let vhc = this;
        vhc.title = "Horsley Village Hall";
        vhc.subtitle = "A great venue for public and private events";
        vhc.feature = "village-hall";
        vhc.pages = [
            {
                title:      'Home',
                subtitle:   'Horsley Village Hall',
                pageName:   '1',
            },
            {
                title:      'Management',
                subtitle:   'Management and Maintenance',
                pageName:   '2',
            },
            {
                title:      'Booking',
                subtitle:   'Booking calendar',
                pageName:   '3',
            },
            {
                title:      'Facilities',
                subtitle:   'Hall specifications and facilities',
                pageName:   '4',
            },
            {
                title:      'History',
                subtitle:   'Evolution of the Village Hall',
                pageName:   '5',
            },
        ];
        vhc.events = [];
        vhc.calendarView = 'month';
        vhc.viewDate = moment().toDate();
        vhc.cellIsOpen = true;
        vhc.timespanClicked = CalendarService.timespanClicked;
        vhc.uploadMinutes = {};
        vhc.accountDocUpload = {};

        $scope.$watchGroup([
            'vhc.calendarView',
            'vhc.viewDate'
        ], function() {
            vhc.events = [];
            console.log("Watched it change");
            // Use the rrule library to generate recurring events: https://github.com/jkbrzt/rrule
            let rule = new RRule({
                freq: RRule.WEEKLY,
                interval: 1,
                byweekday: [RRule.MO],
                dtstart: moment(vhc.viewDate).startOf(vhc.calendarView).toDate(),
                until: moment(vhc.viewDate).endOf(vhc.calendarView).toDate()
            });

            vhc.events = [{
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
                vhc.events.push({
                    title: 'Recurs weekly on mondays',
                    color: calendarConfig.colorTypes.success,
                    startsAt: new Date(date)
                });
            });

        });
    }

})();
