'use strict';

angular.module('vin.io')
    .service('Bottle', function ($resource) {

        return $resource('/api/bottles');

});