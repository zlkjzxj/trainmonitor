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
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/echarts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/echarts-liquidfill.js"></script>
</head>
<body>
<style>
    html, body {
        width: 100%;
        height: 100%;
        margin: 0;
        background: #F1F7FF;
    }

    #main {
        padding: 20px;
    }

    #main:after {
        display: block;
        content: ' ';
        clear: both;
    }

    h1 {
        margin: 20px;
        font-size: 20px;
        font-weight: bold;
        text-align: center;
        color: #D94854;
    }

    .chart {
        width: 25%;
        height: 300px;
        float: left;
    }
    @media (max-width: 980px) {
        .chart {
            height: 200px;
        }
    }
    @media (max-width: 750px) {
        .chart {
            width: 33.333333%;
        }
    }
    @media (max-width: 500px) {
        .chart {
            width: 50%;
            height: 180px;
        }
    }


    .main-chart {
        width: 100%;
        height: 400px;
        float: none;
        margin: -50px 0;
    }

    .nav {
        text-align: center;
        margin: 10px;
    }

    a {
        text-decoration: none;
        background-color: #294D99;
        transition: 0.5s;
        color: white;
        padding: 6px 18px;
        border-radius: 20px;
        margin: 0 4px;
    }

    a:hover {
        background-color: #1598ED;
    }

    #view-more {
        text-align: center;
        margin: 20px 0 80px 0;
    }
</style>
<div id='main'>
    <div class="chart main-chart"></div>
    <h1>Liquid Fill Chart (ECharts Extension)</h1>
    <div class="nav">
        <a href="https://github.com/ecomfe/echarts-liquidfill">GitHub (Doc & API)</a>
        <a href="http://gallery.echartsjs.com/explore.html?u=bd-4013131402&type=work#tags=liquidFill">More Examples</a>
        <a href="http://echarts.baidu.com">ECharts</a>
    </div>
    <div class="chart"></div>
    <div class="chart"></div>
    <div class="chart"></div>
</div>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement('script');
        hm.src = '//hm.baidu.com/hm.js?4bad1df23f079e0d12bdbef5e65b072f';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(hm, s);
    })();

    var bgColor = '#E3F7FF';
    var containers = document.getElementsByClassName('chart');
    var options = [{
        series: [{
            type: 'liquidFill',
            data: [0.6],
            radius: '70%'
        }]
    }];

    var charts = [];
    for (var i = 0; i < options.length; ++i) {
        var chart = echarts.init(containers[i]);

        if (i > 0) {
            options[i].series[0].silent = true;
        }
        chart.setOption(options[i]);
        chart.setOption({
            baseOption: options[i],
            media: [{
                query: {
                    maxWidth: 300
                },
                option: {
                    series: [{
                        label: {
                            fontSize: 26
                        }
                    }]
                }
            }]
        });

        charts.push(chart);
    }

    window.onresize = function () {
        for (var i = 0; i < charts.length; ++i) {
            charts[i].resize();
        }
    };

    setInterval(update, 3000);

    function update() {
        var data = [];
        var last = 1;
        for (var i = 0; i < 4; ++i) {
            last = Math.floor(last * (Math.random() * 0.5 + 0.5)
                * 100) / 100;
            data.push(last);
        }
        charts[1].setOption({
            series: [{
                data: data
            }]
        });
    }
</script>
</body>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery-3.3.1.min.js"></script>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/bootstrap.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--var chart = echarts.init(document.getElementById('liquidfill-chart'));--%>

    <%--$(function () {--%>

        <%--var option = {--%>
            <%--series: [{--%>
                <%--type: 'liquidFill',--%>
                <%--data: [0.6, 0.5, 0.4, 0.3]--%>
            <%--}]--%>
        <%--};--%>
        <%--chart.setOption(option);--%>

    <%--})--%>
<%--</script>--%>
</html>