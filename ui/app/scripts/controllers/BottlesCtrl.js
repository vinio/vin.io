'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, $route, Bottles, Notification) {



        angular.extend($scope, {

            colors: [ 'RED', 'WHITE', 'ROSE' ],

            detail: function (bottle) {
                $scope.selection = _.cloneDeep(bottle);
                $scope.currentPicture = bottle.picture;
            },

            load: function () {
                $scope.bottles = Bottles.query();
            },

            edit: function (bottle) {
                return Bottles.createOrUpdate(bottle)
                    .then(function () {
                        Notification.notify.success('Bottle {} updated', [ bottle._id ]);
                        $scope.load();
                    })
                    .catch(function () {
                        Notification.notify.error('Error during bottle {} update', [ bottle._id ]);
                    });
            }

        });

        $scope.load();
    });
