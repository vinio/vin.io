'use strict';

angular.module('vin.io')
    .filter('currency', function () {
        return function (input) {
            return input + ' €';
        };
    });

