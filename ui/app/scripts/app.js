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
        'ngRoute',
        'ngAnimate'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/Main.html',
                controller: 'MainCtrl'
            })
            .when('/bottles', {
                templateUrl: 'views/Bottles.html',
                controller: 'BottlesCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
