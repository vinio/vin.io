exports.config = {

    // The address of a running selenium server.
    seleniumAddress: 'http://localhost:4444/wd/hub',

    // App BaseURL
    baseUrl: 'http://localhost:8080/#/',

    // Capabilities to be passed to the webdriver instance.
    capabilities: {
        'browserName': 'chrome'
    },

    // list of specs
    specs: [
        'e2e/**/*.js'
    ],

    // Options to be passed to Jasmine-node.
    jasmineNodeOpts: {
        showColors: true
    }
};