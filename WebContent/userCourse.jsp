<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="entity.CourseInf" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>我的课程-学员</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
	        <div class="row">
	        	<% List<CourseInf> courseList = (List)request.getAttribute("courseList");%>
	        	<% for(CourseInf courseInf:courseList){ %>
		            <div class="col-sm-4">
		                <div class="contact-box">
	                        <div class="col-sm-4">
	                            <div class="text-center">
	                                <img alt="image" class="img-circle m-t-xs img-responsive" src="img/training.jpg">
	                            </div>
	                        </div>
	                        <div class="col-sm-8">
	                            	课程名：<h3><strong> <%= courseInf.getCourseName() %> </strong></h3>
	                            	<div>课程提示：量力而行，快乐运动</div>
	                            	<div>养成良好习惯，健康生活一辈子</div>
	                            	<div>快乐足球，从我做起</div>
	                        </div>
	                        <div class="clearfix"></div>
		                </div>
		            </div>
		        <% } %>
	        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>



    <script>
        $(document).ready(function () {
            $('.contact-box').each(function () {
                animationHover(this, 'pulse');
            });
        });
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
