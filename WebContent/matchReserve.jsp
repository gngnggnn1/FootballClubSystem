<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="entity.Team" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>预约比赛</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
    	<form action="MatchReserveServlet" method="post" class="form form-horizontal" id="form-matchReserve">
    		<div class="row">
	        	<% List<Team> teamList = (List)request.getAttribute("teamList");%>
	            <div class="col-sm-12">
	                <div class="ibox float-e-margins">
		                
	                    <div class="ibox-title">
	                        <h5>预约比赛 </h5>
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
	                    	
                        	<div class="form-group">
                                <label class="col-sm-2 control-label">我的球队</label>

                                <div class="col-sm-10">
                                    <input type="text" value=<%= request.getAttribute("teamName") %> class="form-control" name = "teamName1">
                                </div>
                            </div>
                        
	                        <div class="form-group">
		                        <label class="col-sm-2 control-label">选择对手</label>
		                        <div class="col-sm-10">
		                            <select class="form-control m-b" name="teamName2">
		                            	<% for(Team team:teamList){ %>
		                                	<option><%= team.getTeamName() %></option>
		                                <% } %>
		                            </select>
		                        </div>
	                        </div>
	                        
	                        <div class="form-group" id="data_1">
                           		<label class="col-sm-2 control-label">比赛日期</label>
                           		<div class="input-group date">
                               		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                               		<input type="text" class="form-control" value="2021-04-19" name = "matchDate">
                           		</div>
                       		</div>
	                        
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="submit">取消</button>
                                </div>
                            </div>
	                    </div>
	                </div>
	            </div>
	        </div>
		</form>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>
    
    <!-- Chosen -->
    <script src="js/plugins/chosen/chosen.jquery.js"></script>

    <!-- JSKnob -->
    <script src="js/plugins/jsKnob/jquery.knob.js"></script>

    <!-- Input Mask-->
    <script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>

    <!-- Data picker -->
    <script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

    <!-- Prettyfile -->
    <script src="js/plugins/prettyfile/bootstrap-prettyfile.js"></script>

    <!-- NouSlider -->
    <script src="js/plugins/nouslider/jquery.nouislider.min.js"></script>

    <!-- Switchery -->
    <script src="js/plugins/switchery/switchery.js"></script>

    <!-- IonRangeSlider -->
    <script src="js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>

    <!-- MENU -->
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Color picker -->
    <script src="js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

    <!-- Clock picker -->
    <script src="js/plugins/clockpicker/clockpicker.js"></script>

    <!-- Image cropper -->
    <script src="js/plugins/cropper/cropper.min.js"></script>

    <script src="js/demo/form-advanced-demo.js"></script>
    
    
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
