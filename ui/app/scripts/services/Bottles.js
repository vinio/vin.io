'use strict';

angular.module('vin.io')
    .service('Bottles', function ($resource) {

        return $resource("/api/bottles");
    });
