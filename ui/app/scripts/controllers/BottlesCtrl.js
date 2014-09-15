'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, Bottles, Notification) {

        angular.extend($scope, {

            bottles: Bottles.query(),

            detail: function (bottle) {
                $scope.selection = bottle;
                $scope.currentPicture = bottle.picture;
            },

            edit: function (bottle) {
                return Bottles.createOrUpdate(bottle)
                    .then(function () {
                        Notification.notify.success('Bottle {} updated', [ bottle._id ]);
                    })
                    .catch(function () {
                        Notification.notify.error('Error during bottle {} update', [ bottle._id ]);
                    });
            }

        });
    });
