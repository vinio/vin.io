'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, Bottles) {

        $scope.bottles = Bottles.query();

        $scope.select = function (bottle) {
            $scope.selection = bottle;
        };
    });
