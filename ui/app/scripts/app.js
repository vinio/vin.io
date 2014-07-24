'use strict';

/**
 * @ngdoc overview
 * @name vin.io
 * @description
 * # vin.io
 *
 * Main module of the application.
 */
angular
    .module('vin.io', [
        'ngResource',
        'ngRoute'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .when('/about', {
                templateUrl: 'views/about.html',
                controller: 'AboutCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
