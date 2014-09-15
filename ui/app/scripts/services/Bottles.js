'use strict';

angular.module('vin.io')
    .service('Bottles', function ($resource) {

        var resource = $resource("/api/bottles/:id");

        return angular.extend(resource, {

            createOrUpdate: function (bottle) {
                return resource.save(bottle).$promise;
            }

        });
    });
