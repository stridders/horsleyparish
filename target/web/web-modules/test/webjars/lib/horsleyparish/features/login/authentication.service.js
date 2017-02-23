(function () {
    'use strict';

    angular
        .module('horsley')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['$http', '$window'];

    function AuthenticationService($http, $window) {

        var service = {};
        service.Login = Login;
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;
        service.GetUserName = GetUserName;
        service.GetUserContext = GetUserContext;
        service.GetUserProfile = GetUserProfile;
        service.GetSecurityHeader = GetSecurityHeader;
        service.GetUserRoles = GetUserRoles;
        service.UserHasRole = UserHasRole;

        return service;

        /**
         * Sends username and password credentials to the Horsley API webservice, to authenticate a user
         * @param username
         * @param password
         * @param callback
         * @constructor
         */
        function Login(username, password, callback) {
            let currentUser = SetCredentials(username, password);
            $http.get('/api/authentication')
                .success(function (response) {
                    StoreUserCredentials(currentUser, response);
                    callback(response);
                })
                .error(function() {
                    ClearCredentials();
                    callback(null);
                });
        }


        /**
         * Creates an HTTP default (OAuth2-style) authentication header and returns the
         * user credentials as a JSON string
         * @param username
         * @param password
         * @constructor
         */
        function SetCredentials(username, password) {
            let authdata = Base64.encode(username + ':' + password);
            let currentUser =  {
                    username: username,
                    authdata: authdata
            };
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
            return currentUser;
        }

        function GetSecurityHeader() {
            let currentUser = GetUserContext();
            let header = {};
            if (currentUser != null) {
                let authdata = currentUser.authdata;
                header = {"Authorization": 'Basic ' + authdata };
            }
            return header;
        }

        /**
         * Save user credentials to a session cookie
         * @param currentUser
         * @constructor
         */
        function StoreUserCredentials(currentUser, userProfile) {
            $window.localStorage.setItem("currentUser", angular.toJson(currentUser));
            $window.localStorage.setItem("userProfile", angular.toJson(userProfile));
        }

        /**
         * Get userName from session cookie (if user is logged in)
         * @returns {*}
         * @constructor
         */
        function GetUserName() {
            let userName = null;
            let userProfile = JSON.parse($window.localStorage.getItem("userProfile"));
            if (userProfile && userProfile.email) {
                userName = userProfile.email;
            }
            return userName;
        }

        /**
         * Get userRoles from session cookie (if user is logged in)
         * @returns {*}
         * @constructor
         */
        function GetUserRoles() {
            let userRoles = [];
            let userProfile = JSON.parse($window.localStorage.getItem("userProfile"));
            if (userProfile && userProfile.roles) {
                userRoles = userProfile.roles;
            }
            return userRoles;
        }

        /**
         * Determines if a user has a specific role or not
         * @param role
         * @returns {*}
         * @constructor
         */
        function UserHasRole(role) {
            let userRoles = this.GetUserRoles.toString();
            return userRoles.indexOf(role) > -1 || userRoles.indexOf("ADMIN");
        }

        /**
         * Returns the username and authdata for the currently logged in user
         * @constructor
         */
        function GetUserContext() {
            let currentUser =JSON.parse($window.localStorage.getItem("currentUser"));
            return currentUser;
        }

        /**
         * Returns the userProfile for the logged in user
         * @constructor
         */
        function GetUserProfile() {
            let userProfile =JSON.parse($window.localStorage.getItem("userProfile"));
            return userProfile;
        }

        /**
         * Clears user credentials from globals and the default HTTP context
         * @constructor
         */
        function ClearCredentials() {
            $window.localStorage.removeItem("userProfile");
            $window.localStorage.removeItem("currentUser");
            $http.defaults.headers.common.Authorization = 'Basic';
        }
    }

    // Base64 encoding service used by AuthenticationService
    var Base64 = {

        keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',

        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output +
                    this.keyStr.charAt(enc1) +
                    this.keyStr.charAt(enc2) +
                    this.keyStr.charAt(enc3) +
                    this.keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        },

        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                window.alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            do {
                enc1 = this.keyStr.indexOf(input.charAt(i++));
                enc2 = this.keyStr.indexOf(input.charAt(i++));
                enc3 = this.keyStr.indexOf(input.charAt(i++));
                enc4 = this.keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";

            } while (i < input.length);

            return output;
        }
    };

})();





