'use strict';

describe('Controller: BottlesCtrl', function () {

    // load the controller's module
    beforeEach(module('vin.io'));

    var BottlesCtrl, scope;

    // Initialize the controller and a mock scope
    beforeEach(inject(function ($controller, $rootScope) {
        scope = $rootScope.$new();
        BottlesCtrl = $controller('BottlesCtrl', {
            $scope: scope
        });
    }));

    it('should attach a list of awesomeThings to the scope', function () {
        expect(true).toBe(true);
    });
});
