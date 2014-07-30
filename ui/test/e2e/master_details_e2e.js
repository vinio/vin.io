var loadUrl = function (url) {
    browser.get(browser.baseUrl + url);
};

describe('master/details e2e test', function () {

    var domainNames = [
        { domain: 'Chateau Petrus', vintage: '2008', description: 'Très bon !'},
        { domain: 'Chateau Margaux', vintage: '2005', description: 'Très très bon !'}
    ];

    it('should load bottles properly', function () {

        loadUrl('/bottles');

        var rows = element.all(by.repeater('bottle in bottles'));

        expect(rows.count()).toEqual(domainNames.length);

        for (var i = 0; i < domainNames.length; i++) {
            var expects = domainNames[i];
            var row = rows.get(i);
            expect(row.element(by.binding('bottle.domain')).getText()).toEqual(expects.domain);
            expect(row.element(by.binding('bottle.vintage')).getText()).toEqual(expects.vintage);
            expect(row.element(by.binding('bottle.description')).getText()).toEqual(expects.description);
        }
    });

});

