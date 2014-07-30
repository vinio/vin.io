
var loadUrl = function (url) {
    browser.get(url);
};

describe('master/details e2e test', function () {

    var ptor = protractor.getInstance();

    it('should load bottles properly', function () {

        loadUrl('/bottles');

        element(by.repeater('bottle in bottles').row(0)).$('#copyCalc').click()
    });

});

