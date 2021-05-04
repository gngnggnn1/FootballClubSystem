<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="entity.Field" %>    
<%@ page import="entity.Threads" %>
<%@ page import="entity.Team" %>  

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>管理员主页</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Morris -->
    <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<% List<Field> fieldList = (List)request.getAttribute("fieldList"); %>
	<% List<Team> teamList = (List)request.getAttribute("teamList"); %>
	<% List<Threads> threadList = (List)request.getAttribute("threadList"); %>
	<% int userSum = (int)request.getAttribute("userSum"); %>
	<% int playerSum = (int)request.getAttribute("playerSum"); %>
	<% int fieldReserveSum = (int)request.getAttribute("fieldReserveSum"); %>
	<% int teamSum = (int)request.getAttribute("teamSum"); %>
	<% int courseInfSum = (int)request.getAttribute("courseInfSum"); %>
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-success pull-right">总</span>
                        <h5>已注册会员</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins"><%= userSum %></h1>
                        <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i>
                        </div>
                        <small>会员数</small>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-info pull-right">全年</span>
                        <h5>订单</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins"><%= fieldReserveSum %></h1>
                        <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                        </div>
                        <small>新订单</small>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-primary pull-right">总</span>
                        <h5>球队数</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins"><%= teamSum %></h1>
                        <div class="stat-percent font-bold text-navy">44% <i class="fa fa-level-up"></i>
                        </div>
                        <small>总球队</small>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-danger pull-right">总</span>
                        <h5>球员数</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins"><%= playerSum %></h1>
                        <div class="stat-percent font-bold text-danger">38% <i class="fa fa-level-up"></i>
                        </div>
                        <small>总球员数</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>经营情况</h5>
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-xs btn-white active">天</button>
                                <button type="button" class="btn btn-xs btn-white">月</button>
                                <button type="button" class="btn btn-xs btn-white">年</button>
                            </div>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-9">
                                <div class="flot-chart">
                                    <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <ul class="stat-list">
                                    <li>
                                        <h2 class="no-margins"><%= fieldReserveSum + courseInfSum %></h2>
                                        <small>总订单数</small>
                                        <div class="stat-percent">48% <i class="fa fa-level-down text-navy"></i>
                                        </div>
                                        <div class="progress progress-mini">
                                            <div style="width: 48%;" class="progress-bar"></div>
                                        </div>
                                    </li>
                                    <li>
                                        <h2 class="no-margins "><%= fieldReserveSum %></h2>
                                        <small>场地预约</small>
                                        <div class="stat-percent">60% <i class="fa fa-level-down text-navy"></i>
                                        </div>
                                        <div class="progress progress-mini">
                                            <div style="width: 60%;" class="progress-bar"></div>
                                        </div>
                                    </li>
                                    <li>
                                        <h2 class="no-margins "><%= courseInfSum %></h2>
                                        <small>培训班报名</small>
                                        <div class="stat-percent">25% <i class="fa fa-level-down text-navy"></i>
                                        </div>
                                        <div class="progress progress-mini">
                                            <div style="width: 22%;" class="progress-bar"></div>
                                        </div>
                                    </li>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-sm-4">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>约球吧</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content ibox-heading">
                        <h3><i class="fa fa-envelope-o"></i> 新帖子</h3>
                    </div>
                    <div class="ibox-content">
                        <div class="feed-activity-list">
							<% for(Threads thread:threadList){ %>
	                            <div class="feed-element">
	                                <div>
	                                    <strong><%= thread.getTopic() %></strong>
	                                    <div><%= thread.getDetail() %></div>
	                                    <div><%= thread.getUserName() %></div>
	                                    <small class="text-muted"><%= thread.getTime() %></small>
	                                </div>
	                            </div>
	                        <% } %>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-sm-8">

                <div class="row">
                    <div class="col-sm-6">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>我的场地</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <table class="table table-hover no-margins">
                                    <thead>
                                        <tr>
                                            <th>球场名</th>
                                            <th>大小</th>
                                            <th>位置</th>
                                            <th>价格</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% for(Field field:fieldList){ %>
	                                        <tr>
	                                            <td><small><%= field.getFieldName() %></small>
	                                            </td>
	                                            <td><i class="fa fa-user"></i> <%= field.getSize() %></td>
	                                            <td><%= field.getLocation() %></td>
	                                            <td class="text-navy"> <i class="fa fa-cny"></i> <%= field.getPrice() %></td>
	                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>球队列表</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <table class="table table-hover no-margins">
                                    <thead>
                                        <tr>
                                            <th>球队名</th>
                                            <th>队长名</th>
                                            <th>简介</th>
                                            <th>联系电话</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% for(Team team:teamList){ %>
	                                        <tr>
	                                            <td><small><%= team.getTeamName() %></small>
	                                            </td>
	                                            <td><i class="fa fa-user"></i> <%= team.getCaptainName() %></td>
	                                            <td><%= team.getDescription() %></td>
	                                            <td class="text-navy"><%= team.getContact() %></td>
	                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>


        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>



    <!-- Flot -->
    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="js/plugins/flot/jquery.flot.symbol.js"></script>

    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>
    <script src="js/demo/peity-demo.js"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>


    <!-- jQuery UI -->
    <script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- Jvectormap -->
    <script src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

    <!-- EayPIE -->
    <script src="js/plugins/easypiechart/jquery.easypiechart.js"></script>

    <!-- Sparkline -->
    <script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <!-- Sparkline demo data  -->
    <script src="js/demo/sparkline-demo.js"></script>

    <script>
        $(document).ready(function () {
            $('.chart').easyPieChart({
                barColor: '#f8ac59',
                //                scaleColor: false,
                scaleLength: 5,
                lineWidth: 4,
                size: 80
            });

            $('.chart2').easyPieChart({
                barColor: '#1c84c6',
                //                scaleColor: false,
                scaleLength: 5,
                lineWidth: 4,
                size: 80
            });

            var data2 = [
                [gd(2012, 1, 1), 7], [gd(2012, 1, 2), 6], [gd(2012, 1, 3), 3], [gd(2012, 1, 4), 8],
                [gd(2012, 1, 5), 9], [gd(2012, 1, 6), 7], [gd(2012, 1, 7), 5], [gd(2012, 1, 8), 4],
                [gd(2012, 1, 9), 7], [gd(2012, 1, 10), 8], [gd(2012, 1, 11), 9], [gd(2012, 1, 12), 6],
                [gd(2012, 1, 13), 4], [gd(2012, 1, 14), 5], [gd(2012, 1, 15), 11], [gd(2012, 1, 16), 8],
                [gd(2012, 1, 17), 8], [gd(2012, 1, 18), 11], [gd(2012, 1, 19), 11], [gd(2012, 1, 20), 6],
                [gd(2012, 1, 21), 6], [gd(2012, 1, 22), 8], [gd(2012, 1, 23), 11], [gd(2012, 1, 24), 13],
                [gd(2012, 1, 25), 7], [gd(2012, 1, 26), 9], [gd(2012, 1, 27), 9], [gd(2012, 1, 28), 8],
                [gd(2012, 1, 29), 5], [gd(2012, 1, 30), 8], [gd(2012, 1, 31), 25]
            ];

            var data3 = [
                [gd(2012, 1, 1), 8], [gd(2012, 1, 2), 5], [gd(2012, 1, 3), 6], [gd(2012, 1, 4), 7],
                [gd(2012, 1, 5), 8], [gd(2012, 1, 6), 4], [gd(2012, 1, 7), 8], [gd(2012, 1, 8), 5],
                [gd(2012, 1, 9), 8], [gd(2012, 1, 10), 8], [gd(2012, 1, 11), 9], [gd(2012, 1, 12), 4],
                [gd(2012, 1, 13), 15], [gd(2012, 1, 14), 16], [gd(2012, 1, 15), 7], [gd(2012, 1, 16), 7],
                [gd(2012, 1, 17), 3], [gd(2012, 1, 18), 8], [gd(2012, 1, 19), 8], [gd(2012, 1, 20), 12],
                [gd(2012, 1, 21), 9], [gd(2012, 1, 22), 4], [gd(2012, 1, 23), 9], [gd(2012, 1, 24), 5],
                [gd(2012, 1, 25), 7], [gd(2012, 1, 26), 6], [gd(2012, 1, 27), 8], [gd(2012, 1, 28), 9],
                [gd(2012, 1, 29), 1], [gd(2012, 1, 30), 5], [gd(2012, 1, 31), 9]
            ];


            var dataset = [
                {
                    label: "场地预约数",
                    data: data3,
                    color: "#1ab394",
                    bars: {
                        show: true,
                        align: "center",
                        barWidth: 24 * 60 * 60 * 600,
                        lineWidth: 0
                    }

                }, {
                    label: "训练营学员数",
                    data: data2,
                    yaxis: 2,
                    color: "#464f88",
                    lines: {
                        lineWidth: 1,
                        show: true,
                        fill: true,
                        fillColor: {
                            colors: [{
                                opacity: 0.2
                            }, {
                                opacity: 0.2
                            }]
                        }
                    },
                    splines: {
                        show: false,
                        tension: 0.6,
                        lineWidth: 1,
                        fill: 0.1
                    },
                }
            ];


            var options = {
                xaxis: {
                    mode: "time",
                    tickSize: [3, "day"],
                    tickLength: 0,
                    axisLabel: "Date",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Arial',
                    axisLabelPadding: 10,
                    color: "#838383"
                },
                yaxes: [{
                        position: "left",
                        max: 20,
                        color: "#838383",
                        axisLabelUseCanvas: true,
                        axisLabelFontSizePixels: 12,
                        axisLabelFontFamily: 'Arial',
                        axisLabelPadding: 3
                }, {
                        position: "right",
                        clolor: "#838383",
                        axisLabelUseCanvas: true,
                        axisLabelFontSizePixels: 12,
                        axisLabelFontFamily: ' Arial',
                        axisLabelPadding: 67
                }
                ],
                legend: {
                    noColumns: 1,
                    labelBoxBorderColor: "#000000",
                    position: "nw"
                },
                grid: {
                    hoverable: false,
                    borderWidth: 0,
                    color: '#838383'
                }
            };

            function gd(year, month, day) {
                return new Date(year, month - 1, day).getTime();
            }

            var previousPoint = null,
                previousLabel = null;

            $.plot($("#flot-dashboard-chart"), dataset, options);

            var mapData = {
                "US": 298,
                "SA": 200,
                "DE": 220,
                "FR": 540,
                "CN": 120,
                "AU": 760,
                "BR": 550,
                "IN": 200,
                "GB": 120,
            };

            $('#world-map').vectorMap({
                map: 'world_mill_en',
                backgroundColor: "transparent",
                regionStyle: {
                    initial: {
                        fill: '#e4e4e4',
                        "fill-opacity": 0.9,
                        stroke: 'none',
                        "stroke-width": 0,
                        "stroke-opacity": 0
                    }
                },

                series: {
                    regions: [{
                        values: mapData,
                        scale: ["#1ab394", "#22d6b1"],
                        normalizeFunction: 'polynomial'
                    }]
                },
            });
        });
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
