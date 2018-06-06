(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('NavbarService', NavbarService);

    NavbarService.$inject = [];

    function NavbarService() {

        var service = {};
        service.getDefaultLinks = getDefaultLinks;

        return service;

        function getDefaultLinks(callback) {
            var links = [
                {
                    heading: 'Home',
                    title: 'Horsley Parish Home Page',
                    image: '/glos/img/home.png',
                    text: '',
                    link: '/',
                    bgcolour: '#4E342E'
                },
                {
                    heading: 'Community Shop',
                    title: 'Horsley Community Shop',
                    image: '/glos/img/ico-shop.png',
                    text: '',
                    link: '/horsley-community-shop',
                    bgcolour: '#FFFFFF'
                },
                {
                    heading: 'Village Hall',
                    title: 'Horsley Village Hall',
                    image: '/glos/img/ico-village-hall.png',
                    text: '',
                    link: '/village-hall',
                    bgcolour: '#00796B'
                },
                {
                    heading: 'Church and Cemetery',
                    title: 'St.Martin\'s Church and Cemetery',
                    image: '/glos/img/ico_church.png',
                    text: '',
                    link: '/church-and-cemetery',
                    bgcolour: '#26a63b'
                },
                {
                    heading: 'The Horse\'s Mouth',
                    title: 'The Horsley Monthly Magazine',
                    image: '/glos/features/the-horses-mouth/img/ic_horses_mouth_sm_black.png',
                    text: '',
                    link: '/horses-mouth',
                    bgcolour: '#4E342E'
                },
                {
                    heading: 'Parish Council',
                    title: 'Horsley Parish Council',
                    image: '/glos/img/pc.png',
                    text: '',
                    link: '/parish-council',
                    bgcolour: '#4E342E'
                },
                {
                    heading: 'History',
                    title: 'A history of Horsley Parish',
                    image: '/glos/features/history/img/ic_history_sm_black.png',
                    text: '',
                    link: '/history',
                    bgcolour: '#00796B'
                }
            ];
            return links;
        }

    }

})();
