'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, $route, Bottles, Notification) {

        angular.extend($scope, {

            bottles: Bottles.query(),

            colors: [ 'RED', 'WHITE', 'ROSE' ],

            detail: function (bottle) {
                $scope.selection = _.cloneDeep(bottle);
                $scope.currentPicture = bottle.picture;
            },

            edit: function (bottle) {
                return Bottles.createOrUpdate(bottle)
                    .then(function () {
                        Notification.notify.success('Bottle {} updated', [ bottle._id ]);
                        $route.reload();
                    })
                    .catch(function () {
                        Notification.notify.error('Error during bottle {} update', [ bottle._id ]);
                    });
            }

        });
    });
