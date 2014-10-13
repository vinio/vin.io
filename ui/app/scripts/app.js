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
                templateUrl: 'views/Main.html'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
