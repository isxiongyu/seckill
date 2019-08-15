var seckill = {
    URL: {
        now: function () {
            return '/seckill/time/now';
        },
        exposer: function (seckillId) {
            return '/seckill/' + seckillId + '/expose';
        },
        execution: function (seckillId, md5) {
            return '/seckill/' + seckillId + '/' + md5 + '/execution';
        }
    },

    validatePhone: function (phone) {
        if (phone && phone.length === 11 && !isNaN(phone)) {
            return true;
        } else {
            return false;
        }
    },

    handleSeckill: function (seckillId, seckillBox) {
        seckillBox.hide().html('<button class="btn btn-primary" id="killBtn">开始秒杀</button>');
        $.get(seckill.URL.exposer(seckillId), {}, function (exposer) {
            if (exposer && exposer['exposed']) {
                var md5 = exposer['md5'];
                var killUrl = seckill.URL.execution(seckillId, md5);
                $('#killBtn').one('click', function () {
                    $(this).addClass('disable');
                    console.log(killUrl);
                    $.post(killUrl, {}, function (result) {
                        console.log(result);
                        if (result && result['succcess']) {
                            seckillBox.html('<span class="label label-success">秒杀成功</span>');
                        } else {
                            var stateInf = result['stateInf'];
                            seckillBox.html(stateInf);
                        }
                    });
                });
                seckillBox.show();
            }
            else {
                seckill.countdown(seckillId, exposer['now'], exposer['startTime'], exposer['endTime']);
            }
        });
    },

    countdown: function (seckillId, nowTime, startTime, endTime) {
        var seckillBox = $('#seckill-box');
        if (nowTime > endTime) {
            seckillBox.html('秒杀已结束');
        } else if (nowTime < startTime) {
            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime, function (event) {
                var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown', function () {
                seckill.handleSeckill(seckillId, seckillBox);
            })
        } else {
            seckill.handleSeckill(seckillId, seckillBox);
        }
    },

    detali: {
        init: function (param) {
            var killPhone = $.cookie('killPhone');
            if (!seckill.validatePhone(killPhone)) {
                var killPhoneModel = $('#killPhoneModel');
                killPhoneModel.modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#killPhoneId').val();
                    console.log(inputPhone);
                    if (seckill.validatePhone(inputPhone)) {
                        $.cookie('killPhone', inputPhone, {expire: 7, path: '/seckill'})
                        window.location.reload();
                    } else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
                    }
                });
            }
            // 已经登录
            var seckillId = param['seckillId'];
            var startTime = param['startTime'];
            var endTime = param['endTime'];
            $.get(seckill.URL.now(), {}, function (nowTime) {
                if (nowTime) {
                    seckill.countdown(seckillId, nowTime, startTime, endTime);
                }
            });
        }
    }
};