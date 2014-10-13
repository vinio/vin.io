'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, $route, Bottles, Notification) {



        angular.extend($scope, {

            colors: [ 'RED', 'WHITE', 'ROSE' ],

            detail: function (bottle) {
                $scope.selection = bottle;
                $scope.currentPicture = bottle.picture;
            },

            closeDetail: function () {
                $scope.selection = null;
                $scope.currentPicture = null;
            },

            load: function () {
                $scope.bottles = Bottles.query();
            },

            edit: function (bottle) {
                return Bottles.createOrUpdate(bottle)
                    .then(function () {
                        Notification.notify.success('Bottle {} updated', [ bottle._id ]);
                        $scope.closeDetail();
                        $scope.load();
                    })
                    .catch(function () {
                        Notification.notify.error('Error during bottle {} update', [ bottle._id ]);
                    });
            },

            getVintageClass: function (bottle) {
                if (bottle.vintage >= 2010) return 'early';
                if (bottle.vintage >= 2005 && bottle.vintage < 2010) return 'good';
                if (bottle.vintage < 2005) return 'late';
            }

        });

        $scope.load();
    });
