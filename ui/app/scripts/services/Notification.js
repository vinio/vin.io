angular.module('vin.io')
    .factory('Notification', function () {

        var _format = function (msg, params) {
            if (_.isNull(params) || !_.isArray(params) || _.size(params) == 0) {
                return msg;
            }
            var i = 0;
            return msg.replace(/{}/g, function () {
                return params[i++];
            });
        };

        return {

            notify: {
                log: function (msg, params) {
                    alertify.log(_format(msg, params));
                },
                success: function (msg, params) {
                    alertify.success(_format(msg, params));
                },
                error: function (msg, params) {
                    alertify.error(_format(msg, params), 10000);
                },
                warning: function (msg, params) {
                    alertify.log(_format(msg, params), "warning", 10000);
                }
            },
            dialog: {
                alert: function (msg, params) {
                    alertify.alert(_format(msg, params));
                },
                confirm: function (msg, params, handler) {
                    alertify.confirm(_format(msg, params), handler);
                },
                prompt: function (msg, params, handler) {
                    alertify.prompt(_format(msg, params), handler);
                }
            }
        };
    });