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
            /*vertical-align: middle;*/
            display: -webkit-flex;
            display: flex;
            -webkit-align-items: center;
            align-items: center;
            -webkit-justify-content: center;
            justify-content: center;
        }
        .sr-only1 {
            position: absolute;
            /* width: 1px; */
            /* height: 1px; */
            padding: 0;
            overflow: hidden;
            /* clip: rect(0, 0, 0, 0); */
            white-space: nowrap;
            /* -webkit-clip-path: inset(50%); */
            /* clip-path: inset(50%); */
            border: 0;
        }
    </style>
</head>
<body>

<div class="tabbable" id="Mytable" style="width: 100%;height: 100%;">
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
                            <option value="">--&nbsp;车&nbsp;&nbsp;队&nbsp;--</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <select name="input_city" id="input_city" class="form-control">
                            <option value="">--&nbsp;车&nbsp;&nbsp;组&nbsp;--</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <select name="input_area" id="input_area" class="form-control">
                            <option value="">--&nbsp;车&nbsp;&nbsp;次&nbsp;--</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <select name="input_iden" id="input_iden" class="form-control">
                            <option value="">--设备编号--</option>
                        </select>
                    </div>
                </div>
                <div style="">
                    <div style="margin: 0 auto;width: 400px;height:200px;border: #005cbf 0px solid;margin-top: 10px;" >
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">车&nbsp;&nbsp;&nbsp;队：</div>
                            <div class="col-5 col-sm-5 colText">
                                <input type="text" id="cdnum" value="" readonly>
                            </div>
                        </div>
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">车&nbsp;&nbsp;&nbsp;组：</div>
                            <div class="col-5 col-sm-5 colText">
                                <input type="text" id="cznum" value="" readonly>
                            </div>
                        </div>
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">车&nbsp;&nbsp;&nbsp;次：</div>
                            <div class="col-5 col-sm-5 colText">
                                <input type="text" id="ccnum" value="" readonly>
                            </div>
                        </div>
                        <div class="row" style="width: 400px;height: 50px;">
                            <div class="col-5 col-sm-5 colName">设备编号：</div>
                            <div class="col-5 col-sm-5 colText">
                                <input type="text" id="bhnum" value="" readonly>
                            </div>
                        </div>
                    </div>
                    <div style="margin: 0 auto;width: 400px;height:40px;border: #005cbf 0px solid;text-align: center;">
                        <button type="" class="btn btn-primary" data-loading-text="Loading..." id="init"
                                style="width: 100px;margin-top: 12px;">初始化
                        </button>
                    </div>
                    <input type="hidden" id="disks">
                    <input type="hidden" id="trainini">
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

<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/trainTree.js"></script>

</html>

<script>
    var containers = document.getElementsByClassName('optlq');
    var charts = [];
    var options = [];
    var tts = 20;

    //一直启动，用来扫盘符，监听描插入和拔出设备
    var socket = new WebSocket("ws://192.168.1.11:9871/init");
    //查看插入的设备是否初始化
    var outSocket = new WebSocket("ws://192.168.1.11:9871/outPutData");


    $(function () {



        test();
        trainBox();
        // generaSeries(20);
        socket.onopen = function () {
            console.log('open');
            socket.send('test');
        };

        socket.onmessage = function (e) {
            $("#disks").text(e.data);
            if (e.data != 'success' && e.data != 0) {
                $("#loadingModal").modal('hide');
            }else{
                test();
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
            // console.log(e.data+"outProgressT");
            initDisk(e.data);

            var disks = e.data.split("#");
            for (var i = 0; i < disks.length; i++) {
                var json = JSON.parse(disks[i].split(","));
                for (var j = 0; j < json.length; j++) {
                    if(json[j].trainInfo=="" || json[j].trainInfo==""){
                        $("#opd"+j).text("此设备未初始化");
                    }else{
                        $("#opd"+j).text(json[j].trainInfo);
                    }
                }
            }

        }
        outSocket.onclose = function () {
            console.log('close');
        };


        //关闭模态框事件
        $('#msgModal').on('hidden.bs.modal', function (e) {

        })
        //关闭模态框事件
        $('#msgModal').on('show.bs.modal', function (e) {
            console.log("@@@@");
        })


        var html = "";
        $("#input_city").append(html);
        $("#input_area").append(html);
        $("#input_iden").append(html);
        $.each(pdata, function (idx, item) {
            if (parseInt(item.level) == 0) {
                html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
            }
        });
        $("#input_province").append(html);
        $("#input_province").change(function () {
            $("#cdnum").val("");
            $("#cznum").val("");
            $("#ccnum").val("");
            $("#bhnum").val("");
            if ($(this).val() == "") return;
            $("#input_city option").remove();
            $("#input_area option").remove();
            $("#input_iden option").remove();
            var code = $(this).find("option:selected").attr("exid");
            code = code.substring(0, 2);
            $("#cdnum").val($(this).val());
            var html = "<option value=''>--请选择车组--</option>";
            $("#input_area").append(html);
            $("#input_iden").append(html);
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
            $("#input_iden option").remove();
            $("#cznum").val("");
            $("#ccnum").val("");
            $("#bhnum").val("");
            var code = $(this).find("option:selected").attr("exid");
            code = code.substring(0, 4);
            $("#cznum").val($(this).val());
            var html = "<option value=''>--请选择车次--</option>";
            $("#input_iden").append(html);
            $.each(pdata, function (idx, item) {
                if (parseInt(item.level) == 2 && code == item.code.substring(0, 4)) {
                    html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
                }
            });
            $("#input_area").append(html);
        });
        $("#input_area").change(function () {
            if ($(this).val() == "") return;
            $("#input_iden option").remove();
            $("#ccnum").val("");
            $("#bhnum").val("");
            var code = $(this).find("option:selected").attr("exid");
            code = code.substring(0, 6);
            $("#ccnum").val($(this).val());
            var html = "<option value=''>--请选择设备编号--</option>";
            $.each(pdata, function (idx, item) {
                if (parseInt(item.level) == 3 && code == item.code.substring(0, 6)) {
                    html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
                }
            });
            $("#input_iden").append(html);
        });
        $("#input_iden").change(function(){
            if ($(this).val() == ""){
                $("#bhnum").val("");
                return;
            }
            $("#bhnum").val($(this).val());
        });

    })
    var that = this;
    $("#init").on('click', function () {
        var disks = $("#disks").text();
        if(disks.indexOf("#")>0){
            $("#msgModalText").text('插入多个设备！只允许单个设备初始化！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
            return;
        }
        var disk = disks.split(",");
        var cd = $("#input_province").val();
        var cz = $("#input_city").val();
        var cc = $("#input_area").val();
        var bh = $("#input_iden").val();
        if(cd == null ||  cd ==""){
            $("#msgModalText").text('请选择车队！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
        }else if(cz == null || cz == ""){
            $("#msgModalText").text('请选择车组！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
        }else if(cc == null || cc == ""){
            $("#msgModalText").text('请选择车次！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
        }else if(bh == null || bh == ""){
            $("#msgModalText").text('请选择设备编号！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
        }
        var trainInfo = cd + "-" + cz + "-" + cc + "-" + bh;
        $("#trainini").val(trainInfo);
        //console.log(trainInfo);
        var flag=0;
        $.ajax({
            url: '${pageContext.request.contextPath }/init/' + disk[0] + '/' + trainInfo +'/'+ flag,
            type: 'POST',
            success: function (data) {
                //that.socket.close();

                if(data.code=="1"){
                    $("#msgModalText").text('初始化成功，请安全弹出设备！');
                    $("#msgModal").modal({backdrop: 'static', keyboard: false});
                    $("#msgModal").modal('show');
                    //test();
                }else if(data.code=="0"){
                    $("#msgModalText").text("设备已经初始化，车次信息为"+data.data+"，是否重新初始化？");
                    $("#modal-footer").html("<button type=\"button\" data-dismiss=\"modal\" id=\"\" onclick=\"changeInit()\" class=\"btn btn-danger\">确认更改</button>\n" +
                        "<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭</button>");
                    $("#msgModal").modal({backdrop: 'static', keyboard: false});
                    $("#msgModal").modal('show');
                }else{
                    $("#msgModalText").text('初始化失败！');
                    $("#msgModal").modal({backdrop: 'static', keyboard: false});
                    $("#msgModal").modal('show');
                }
            }
        })
    });

    $("#output").on('click', function () {
        console.log($("#disks").text());
        var disks = $("#disks").text().split("#");

        var newDisks = "";
        var notInit = 0;
        for (var i = 0; i < disks.length; i++) {
            var disk = disks[i].split(",");
            newDisks+=disk[0]+",";
            console.log(disk[3]);
            if(disk[3]=="" || disk[3]==null){
                notInit++;
            }
        }
        if(notInit>0){
            $("#msgModalText").text('设备未初始化，请先初始化！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
            return;
        }
        newDisks = newDisks.substring(0,newDisks.length-1);
        console.log(newDisks);
        var dataProgress = new WebSocket("ws://192.168.1.11:9871/dataProgress");
        $.ajax({
            url: '${pageContext.request.contextPath }/outData/' + newDisks,
            type: 'POST',
            success: function (data) {
                //console.log(data);
            }
        });
        dataProgress.onopen = function () {
            var disks = $("#disks").text()
            console.log('dataProgressSocketopen');
        };
        dataProgress.onmessage = function (e) {
            console.log(e.data+"进度");
            if(e.data!= null && e.data!="" && e.data != "success"){
                var dlists = JSON.parse(e.data);
                var closeCount = 0;
                for (var i = 0; i < dlists.length; i++) {
                    console.log(dlists[i].trainInfo+"*****");
                    var progress = dlists[i].progress;
                    var trainInfo = dlists[i].trainInfo;
                    progress = parseFloat(progress);
                    progress = (((progress/100).toFixed(2))*100).toFixed(0);
                    console.log(progress+"jindu盘"+i);
                    increment(progress,i);
                    $("#dState"+i).text("状态:正在导出......");


                    if(progress==100.0){
                        $("#dState"+i).text("状态:导出成功");
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
    function changeInit(){
        console.log("22222");
        console.log("123");
        var disks = $("#disks").text();
        if(disks.indexOf("#")>0){
            $("#msgModalText").text('插入多个设备！只允许单个设备初始化！');
            $("#msgModal").modal({backdrop: 'static', keyboard: false});
            $("#msgModal").modal('show');
            return;
        }
        var disk = disks.split(",");
        var trainInfo = $("#trainini").val();
        console.log(trainInfo+"++++");
        var flag=1;
        $.ajax({
            url: '${pageContext.request.contextPath }/init/' + disk[0] + '/' + trainInfo +'/'+ flag,
            type: 'POST',
            success: function (data) {
                //that.socket.close();

                if(data.code=="1"){
                    $("#msgModalText").text('初始化成功，请安全弹出设备！');
                    $("#msgModal").modal({backdrop: 'static', keyboard: false});
                    $("#msgModal").modal('show');
                    //test();
                }else{
                    $("#msgModalText").text('初始化失败！');
                    $("#msgModal").modal({backdrop: 'static', keyboard: false});
                    $("#msgModal").modal('show');
                }
            }
        })
    }
    function test() {
        //也可以一起运用
        //backdrop 为 static 时，点击模态对话框的外部区域不会将其关闭。
        //keyboard 为 false 时，按下 Esc 键不会关闭 Modal。
        $('#loadingModal').modal({backdrop: 'static', keyboard: false});
        $("#loadingModal").modal('show');
    }
    function trainBox() {

        for (var i = 0; i < tts; i++) {
            var div = "<div style=\"width:340px; height: 100px;margin:5px;float:left;border-radius: 5px;box-shadow:  0px 0px 5px #707070\" id=\"test"+i+"\" class=\"test\">" +
                "<div style=\"width:340px;height:75px;margin-bottom: 5px;\" class=\'optlqs\' id=\"optlqs"+i+"\">" +
                    "<div class=\"left-img\" style=\"width: 70px;height: 75px;float: left;\">\n" +
                    "    <img src=\"${pageContext.request.contextPath }/static/image/wjly.png\" id=\"jlyImg"+i+"\">\n" +
                    "</div>\n" +
                    "<div class=\"right-info\" style=\"width: 270px;height: 75px;float: left;\">\n" +
                    "    <p style=\"width: 100%;height: 25px;margin-bottom: 3px;\" id=\"tSize"+i+"\">容量:</p>\n" +
                    "    <p style=\"width: 100%;height: 25px;margin-bottom: 3px;\" id=\"dState"+i+"\">状态:</p>\n" +
                    "    <p style=\"width: 100%;height: 25px;margin-bottom: 3px;\" id=\"tInfo"+i+"\">车次:</p>\n" +
                    "</div>" +
                "</div>" +
                "<div id=\"test"+i+"\" class=\"test1\" style=\"width: 340px;height: 25px;\">" +
                    "<div class=\"progress progress-striped active\">\n" +
                    "  <div id=\"prog"+i+"\" class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"0\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 0%;\">\n" +
                    "    <span class=\"sr-only1\" id=\"progInner"+i+"\">0% Complete</span>\n" +
                    "  </div>\n" +
                    "</div>" +
                "</div>" +
                "</div>"
            $("#outputdiv").append(div);
        }
    }

    function initDisk(data) {
        if(data!=null && data != ""){
            var json = JSON.parse(data);
            for (var i = 0; i < tts; i++) {
                if(i<json.length){
                    console.log(json[i]+"扫盘绑定");
                    $("#tSize"+i).text("容量:"+json[i].freeSize+"可用/共"+json[i].totalSize);
                    $("#tInfo"+i).text("车次:"+json[i].trainInfo);
                    $("#jlyImg"+i).attr("src","${pageContext.request.contextPath }/static/image/yjly.png");
                    $("#test"+i).css("box-shadow", "0px 0px 5px #1296db");
                }else{
                    $("#tSize"+i).text("容量:");
                    $("#dState"+i).text("状态:");
                    $("#tInfo"+i).text("车次:");
                    $("#jlyImg"+i).attr("src","${pageContext.request.contextPath }/static/image/wjly.png");
                    $("#test"+i).css("box-shadow", "0px 0px 5px #707070");
                    $("#prog"+i).css("width","0%");
                    $("#progInner"+i).text("0% Complete");
                }
            }
        }
    }
    //百分数增加，0-30时为红色，30-60为黄色，60-90为蓝色，>90为绿色
    function increment(progress,numb) {
        console.log(progress+"*****");
        console.log((progress>=0)+"/////*****");
        console.log(numb);
        $("#prog"+numb).css("width",progress + "%");
        $("#progInner"+numb).text(progress + "% Complete");
    }
</script>
