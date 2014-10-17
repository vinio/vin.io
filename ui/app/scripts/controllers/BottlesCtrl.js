'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, Bottle) {

        $scope.bottles = Bottle.query();

    });