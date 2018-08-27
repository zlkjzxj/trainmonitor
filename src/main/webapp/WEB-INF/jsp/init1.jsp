<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta name="theme-color" content="#000000">
    <%--<meta name="_csrf" content="${_csrf.token}" id="_csrf"/>--%>
    <%--<meta name="_csrf_header" content="${_csrf.headerName}" id="_csrf_header"/>--%>

    <title>设备初始化</title>
    <link href="${pageContext.request.contextPath }/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
</head>
<body onload="test()">

<div class="tabbable" style="width: 100%;height: 100%;">
    <ul class="nav nav-pills nav-fill">
        <li class="active" style="width: 50%;"><a href="#home" class="nav-item nav-link active" data-toggle="tab">初始化设备</a></li>
        <li style="width: 50%;"><a href="#profile" class="nav-item nav-link" data-toggle="tab">视频导出</a></li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab" style="border: 1px solid #000; border-radius: 5px;height: 100%;">
            <div style="margin-top: 8px;">
                <%--${user.username}--%>
                <%--<input type="button" id="init" onclick="init()" value="初始化">--%>
                <form action="${pageContext.request.contextPath }/checkInit" method="post" name="initForm" id="initForm">
                    <div class="form-group form-inline">
                        <div class="col-sm-1"></div>
                        <label class="col-sm-1 control-label"><i>*</i>车次信息</label>
                        <div class="col-sm-2">
                            <select name="input_province" id="input_province" class="form-control">
                                <option value="">&nbsp;--铁&nbsp;路&nbsp;局--</option>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <select name="input_city" id="input_city" class="form-control">
                                <option value="">--火&nbsp;车&nbsp;站--</option>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <select name="input_area" id="input_area" class="form-control">
                                <option value="">--&nbsp;车&nbsp;&nbsp;次&nbsp;--</option>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <select name="input_area" id="input_iden" class="form-control">
                                <option value="">--设备编号--</option>
                            </select>
                        </div>
                    </div>
                    <div style="">
                        <div style="margin: 0 auto;width: 400px;height:400px;border: #005cbf 1px solid;"></div>
                        <div style="margin: 0 auto;width: 400px;height:40px;border: #005cbf 0px solid;text-align: center;">

                            <button type="" class="btn btn-primary" data-loading-text="Loading..." id="cc" style="width: 100px;margin-top: 12px;" >初始化</button>


                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab" style="border: 1px solid #000; border-radius: 5px;height: 100%;">
            <div style="margin-top: 8px;">
                ${user.username}
                <button id="cc">xxxxxxxxxx</button>
                vvvvvvvvvvvvvv
            </div>
        </div>
    </div>
</div>
<!-- 模态遮罩层 -->
<div class="modal fade" id="loadingModal" tabindex="-1" role="dialog" aria-hidden="true" style="background-image: url('../../static/image/bg.png');">
    <div class="modal-dialog" style="height: 100%;">
        <div style="width: 200px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:-10px">
            <img src="../../../static/image/loading.gif">
            <%--<div class="progress progress-striped active" style="margin-bottom: 0;">--%>
                <%--<div class="progress-bar" style="width: 80%;"></div>--%>
            <%--</div>--%>
            <h5 style="font-weight: bold;color: #fff;">正在读取设备</h5>
        </div>
    </div>
</div>



</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/bootstrap.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/address.js"></script>

<script>
    function test(){

        //也可以一起运用
        //backdrop 为 static 时，点击模态对话框的外部区域不会将其关闭。
        //keyboard 为 false 时，按下 Esc 键不会关闭 Modal。
        $('#loadingModal').modal({backdrop: 'static', keyboard: false});
        $("#loadingModal").modal('show');
        setTimeout(function(){
            console.log("111222");
            $("#loadingModal").modal('hide');
            console.log("111222333");
        },5000);

    }



    $("#aa").on('click',function(){

    })
    $("#cc").on('click',function(){

        //alert("111222");
        <%--$.ajax({--%>
            <%--url:"${pageContext.request.contextPath }/checkInit",--%>
            <%--type:'post',--%>
            <%--dataType:'json',--%>
            <%--async:false,--%>
            <%--cache:false,--%>
            <%--dataType:'json',--%>
            <%--success:function(msg){--%>

            <%--}--%>
        <%--})--%>
    });


    $(function () {
        var html = "";
        $("#input_city").append(html); $("#input_area").append(html);
        $.each(pdata,function(idx,item){
            if (parseInt(item.level) == 0) {
                html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
            }
        });
        $("#input_province").append(html);
        $("#input_province").change(function(){
            if ($(this).val() == "") return;
            $("#input_city option").remove(); $("#input_area option").remove();
            var code = $(this).find("option:selected").attr("exid"); code = code.substring(0,2);
            var html = "<option value=''>--请选择--</option>"; $("#input_area").append(html);
            $.each(pdata,function(idx,item){
                if (parseInt(item.level) == 1 && code == item.code.substring(0,2)) {
                    html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
                }
            });
            $("#input_city").append(html);
        });
        $("#input_city").change(function(){
            if ($(this).val() == "") return;
            $("#input_area option").remove();
            var code = $(this).find("option:selected").attr("exid"); code = code.substring(0,4);
            var html = "<option value=''>--请选择--</option>";
            $.each(pdata,function(idx,item){
                if (parseInt(item.level) == 2 && code == item.code.substring(0,4)) {
                    html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
                }
            });
            $("#input_area").append(html);
        });
    });


</script>
</html>