<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta name="theme-color" content="#000000">
    <%--<meta name="_csrf" content="${_csrf.token}" id="_csrf"/>--%>
    <%--<meta name="_csrf_header" content="${_csrf.headerName}" id="_csrf_header"/>--%>

    <title>高铁视频导出系统</title>
    <link href="${pageContext.request.contextPath }/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <style >
        fieldset{padding:.35em .625em .75em;margin:0 2px;border-top:1px solid silver;border-radius:0px}
        legend{padding:0px;border:0;width:auto;margin-bottom:0px}
        .colName{
            text-align: right;
            line-height: 50px;
            padding-left: 0px;
            padding-right: 0px;
        }
        .colText{
            padding-left: 0px;
            padding-right: 0px;
            /*line-height: 50px;*/
            vertical-align: middle;
        }
    </style>
</head>
<body>

<div class="tabbable" style="width: 100%;height: 100%;">
    <ul class="nav nav-pills nav-fill">
        <li class="active" style="width: 50%;"><a href="#home" class="nav-item nav-link active"
                                                  data-toggle="tab">初始化设备</a></li>
        <li style="width: 50%;"><a href="#profile" class="nav-item nav-link" data-toggle="tab">视频导出</a></li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab"
             style="border: 1px solid #ccc; border-radius: 5px;height: 90%;">
            <div style="margin-top: 8px;">
                <fieldset><legend>车次信息</legend></fieldset>
                <div class="form-group form-inline">
                    <div class="col-sm-1"></div>
                    <label class="col-sm-1 control-label"></label>
                    <div class="col-sm-2">
                        <select name="input_province" id="input_province" class="form-control">
                            <option value="Xi'an">&nbsp;--铁&nbsp;路&nbsp;局--</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <select name="input_city" id="input_city" class="form-control">
                            <option value="Xi'an">--火&nbsp;车&nbsp;站--</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <select name="input_area" id="input_area" class="form-control">
                            <option value="G2581">--&nbsp;车&nbsp;&nbsp;次&nbsp;--</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <select name="input_area" id="input_iden" class="form-control">
                            <option value="123">--设备编号--</option>
                        </select>
                    </div>
                </div>
                <div style="">
                    <div style="margin: 0 auto;width: 400px;height:200px;border: #005cbf 0px solid;margin-top: 10px;" >
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">铁路局：</div>
                            <div class="col-5 col-sm-5 colText"></div>
                        </div>
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">火车站：</div>
                            <div class="col-5 col-sm-5 colText"></div>
                        </div>
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">车&nbsp;&nbsp;&nbsp;次：</div>
                            <div class="col-5 col-sm-5 colText"></div>
                        </div>
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">车厢号：</div>
                            <div class="col-5 col-sm-5 colText"><input type="text" value="你好"></div>
                        </div>
                    </div>
                    <div style="margin: 0 auto;width: 400px;height:40px;border: #005cbf 0px solid;text-align: center;">
                        <button type="" class="btn btn-primary" data-loading-text="Loading..." id="init"
                                style="width: 100px;margin-top: 12px;">初始化
                        </button>
                    </div>
                    <input type="hidden" id="disks">
                </div>
            </div>
        </div>

        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab"
             style="border-top: 1px solid #ccc; border-radius: 5px;height: 90%;">
            <div style="margin: 8px auto;width: 1750px;height:90%;" id="outputdiv"></div>
            <button type="" class="btn btn-primary" data-loading-text="Loading..." id="output"
                    style="width: 100px;margin-top: 12px;float:right;margin-right: 15px;">导出
            </button>
        </div>
    </div>
</div>
<!-- 模态遮罩层 -->
<div class="modal fade" id="loadingModal" tabindex="-1" role="dialog" aria-hidden="true"
     style="background-image: url('../../static/image/bg.png');">
    <div class="modal-dialog" style="height: 100%;">
        <div style="width: 200px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:-10px">
            <img src="../../../static/image/loading.gif">
            <h5 style="font-weight: bold;color: #fff;">正在读取设备</h5>
        </div>
    </div>
</div>
<!-- 模态弹出 -->
<div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-hidden="true" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">提示</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="msgModalText"></p>
            </div>
            <div class="modal-footer" id="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/sockjs.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/address.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/echarts-liquidfill.js"></script>

</html>

<script>
    var containers = document.getElementsByClassName('optlq');
    var charts = [];
    var options = [];

    var socket = new WebSocket("ws://localhost:9871/init");
    var outSocket = new WebSocket("ws://localhost:9871/outPutData");
    $(function () {
        test();
        trainBox();
        generaSeries(20);
        socket.onopen = function () {
            console.log('open');
            socket.send('test');
        };

        socket.onmessage = function (e) {
            console.log('message', e.data);
            console.log(e.data);
            if (e.data !== 'success') {
                if(e.data !== '0'){
                    $("#disks").text(e.data);
                    $("#loadingModal").modal('hide');
                }else{
                    test();
                }

            }

            // socket.close();
        };

        socket.onclose = function () {
            console.log('close');
        };

        outSocket.onopen = function () {
            console.log('open');
            socket.send('test');
        };
        outSocket.onmessage = function (e) {
            console.log(e.data);
            var json = JSON.parse(e.data);
            for (var i = 0; i < json.length; i++) {
                if(json[i].trainInfo=="" || json[i].trainInfo==""){
                    $("#opd"+i).text("此设备未初始化");
                }else{
                    $("#opd"+i).text(json[i].trainInfo);
                }
            }

        }
        outSocket.onclose = function () {
            console.log('close');
        };
        //关闭模态框事件
        $('#msgModal').on('hidden.bs.modal', function (e) {

        })


        var html = "";
        $("#input_city").append(html);
        $("#input_area").append(html);
        $.each(pdata, function (idx, item) {
            if (parseInt(item.level) == 0) {
                html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
            }
        });
        $("#input_province").append(html);
        $("#input_province").change(function () {
            if ($(this).val() == "") return;
            $("#input_city option").remove();
            $("#input_area option").remove();
            var code = $(this).find("option:selected").attr("exid");
            code = code.substring(0, 2);
            var html = "<option value=''>--请选择--</option>";
            $("#input_area").append(html);
            $.each(pdata, function (idx, item) {
                if (parseInt(item.level) == 1 && code == item.code.substring(0, 2)) {
                    html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
                }
            });
            $("#input_city").append(html);
        });
        $("#input_city").change(function () {
            if ($(this).val() == "") return;
            $("#input_area option").remove();
            var code = $(this).find("option:selected").attr("exid");
            code = code.substring(0, 4);
            var html = "<option value=''>--请选择--</option>";
            $.each(pdata, function (idx, item) {
                if (parseInt(item.level) == 2 && code == item.code.substring(0, 4)) {
                    html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
                }
            });
            $("#input_area").append(html);
        });

    })
    var that = this;
    $("#init").on('click', function () {
        if(($("#disks").text()).indexOf(",")>0){

            $("#msgModalText").text('插入多个设备！只允许单个设备初始化！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
            return;

        }

        var trainInfo = $("#input_province").val() + "-" + $("#input_city").val() + "-" + $("#input_area").val() + "-" + $("#input_iden").val();
        console.log(trainInfo);
        $.ajax({
            url: '${pageContext.request.contextPath }/init/' + $("#disks").text() + '/' + trainInfo,
            type: 'POST',
            // data: {'path': $("#disks").text(), 'trainInfo': trainInfo},
            success: function (data) {
                //that.socket.close();
                console.log(data);
                // alert(data.msg);

                if(data.code=="1"){
                    $("#msgModalText").text('初始化成功，请安全弹出设备！');
                    $("#msgModal").modal({backdrop: 'static', keyboard: false});
                    $("#msgModal").modal('show');
                    //test();
                }else if(data.code=="0"){
                    $("#msgModalText").text("设备已经初始化，车次信息为"+data.data+"，是否重新初始化？");
                    $("#modal-footer").html("<button type=\"button\" class=\"btn btn-danger\">确认更改</button>\n" +
                        "<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭</button>");
                    $("#msgModal").modal({backdrop: 'static', keyboard: false});
                    $("#msgModal").modal('show');
                }
                // $("#cc").disable;
            }
        })
    });

    $("#output").on('click', function () {
        var dataProgress = new WebSocket("ws://localhost:9871/dataProgress");
        $.ajax({
            url: '${pageContext.request.contextPath }/outData/' + $("#disks").text(),
            type: 'POST',
            success: function (data) {
                //console.log(data);
            }
        })
        dataProgress.onopen = function () {
            var disks = $("#disks").text()
            console.log('dataProgressSocketopen');
            dataProgress.send(JSON.stringify({disks:disks}));
        };
        dataProgress.onmessage = function (e) {
            if(e.data!= null && e.data!="" && e.data != "success"){
                var dlists = JSON.parse(e.data);
                var closeCount = 0;
                for (var i = 0; i < dlists.length; i++) {
                    var progress = dlists[i].progress;
                    var trainInfo = dlists[i].trainInfo;
                    progress = parseFloat(progress);
                    progress = (progress/100).toFixed(2);
                    var vl={
                        name: trainInfo,
                        value: progress,
                        direction: 'right',
                        itemStyle: {
                            normal: {
                                color: '#3300ff'
                            }
                        }
                    }
                    var data = [];
                    data.push(vl);
                    charts[i].setOption({
                        series: [{
                            data: data,
                            direction: 'right',
                            radius: '95%',
                            waveAnimation: false,
                            amplitude: 0,
                            silent: true,
                            itemStyle: {
                                normal: {
                                    color: '#3300ff'
                                }
                            }
                        }]
                    });
                    if(progress==100.0){
                        closeCount+=1;
                    }
                }
                if(closeCount==dlists.length){
                    dataProgress.close();
                }
            }

        }
        dataProgress.onclose = function () {
            console.log('close');
        };
    });
    function test() {

        //也可以一起运用
        //backdrop 为 static 时，点击模态对话框的外部区域不会将其关闭。
        //keyboard 为 false 时，按下 Esc 键不会关闭 Modal。
        $('#loadingModal').modal({backdrop: 'static', keyboard: false});
        $("#loadingModal").modal('show');
    }
    function trainBox() {

        for (var i = 0; i < 20; i++) {
            var div = "<div style=\"width:340px;height:200px;margin:5px;float:left;\" class=\'optlq\' id=\"optlq"+i+"\"></div>"
            $("#outputdiv").append(div);
        }
    }
    function generaSeries(slength) {
        for (var i = 0; i < slength; i++) {
            var j = {
                series: [{
                        name: '',
                        type: 'liquidFill',
                        waveAnimation: false,
                        silent: true,
                        amplitude: 0,
                        radius: '95%',
                        outline: {
                            show: false
                        },backgroundStyle: {
                            borderColor: '#3399ff',
                            borderWidth: 0,
                            shadowColor: 'rgba(0, 100, 50, 0.4)',
                            shadowBlur: 10
                        },
                        data: [{
                            name: '暂无数据',
                            value: 0,
                            direction: 'right',
                            itemStyle: {
                                normal: {
                                    color: '#3300ff'
                                }
                            }
                        }],
                        label: {
                                normal: {
                                    formatter: function (e) {
                                        var eval = 0;
                                        if(!isNaN(e.value)){
                                            if(e.value==0.00){
                                                eval=0;
                                            }else if(e.value==1.00){
                                                eval=100+"%";
                                            }else{
                                                eval=(e.value*100).toFixed(0)+"%";
                                            }
                                        }
                                        return e.seriesName + '\n'
                                            + e.name + '\n\n'
                                            + eval+'';
                                    },textStyle: {
                                        fontSize: 16,
                                        color: '#d93268'
                                    }
                                }
                            }
                        }]
                };

            options.push(j);
        }

        for (var k = 0; k < options.length; k++) {
            var chart = echarts.init(containers[k]);
            if (k > 0) {
                options[k].series[0].silent = true;
            }
            chart.setOption(options[k]);
            chart.setOption({
                baseOption: options[k],
                media: [{
                    query: {
                        maxWidth: 200
                    },
                    option: {
                        series: [{
                            label: {
                                fontSize: 20
                            }
                        }]
                    }
                }]
            });

            charts.push(chart);
        }

        window.onresize = function () {
            for (var m = 0; m < charts.length; ++m) {
                charts[m].resize();
            }
        };
    }
    // function update(str) {
    //     var data = [{value:parseFloat(str)/100}];
    //     charts[1].setOption({
    //         series: [{
    //             name:'西铁局',
    //             data: data,
    //             direction: 'right',
    //             itemStyle: {
    //                 normal: {
    //                     color: '#3300ff'
    //                 }
    //             }
    //         }]
    //     });
    // }
</script>
