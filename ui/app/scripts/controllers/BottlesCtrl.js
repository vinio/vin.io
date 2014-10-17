'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, Bottle, Notification) {

        $scope.bottles = Bottle.query();

        $scope.showDetail = function(bottle) {
            $scope.selection = bottle;
        };

        $scope.edit = function(bottle) {
            Bottle.save(bottle).$promise
                .then(function () {
                    Notification.notify.success('OK');
                })
                .catch(function () {
                    Notification.notify.error('OK');
                });
        };

    });