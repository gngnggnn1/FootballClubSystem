<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="entity.Team" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>查看球队</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
    	<form action="AttendTeamServlet" method="post" class="form form-horizontal" id="form-addfield">	
	        <div class="row">
	        	<% List<Team> teamList = (List)request.getAttribute("teamList");%>
	        	<% for(Team team:teamList){ %>
		            <div class="col-sm-4">
		                <div class="contact-box">
		                        <div class="col-sm-4">
		                            <div class="text-center">
		                            	<% session.setAttribute("chosenTeam", team); %>
		                                <img alt="image" class="img-circle m-t-xs img-responsive" src="img/team.jpg">
		                                <input type="text" style="display: none" value = <%= team.getTeamID() %> class="form-control" name = "teamID">
		                            </div>
		                        </div>
		                        <div class="col-sm-8">
		                            <h3><strong> <%= team.getTeamName() %> </strong></h3>
		                                                    联系方式：<%= team.getContact() %><br>
		                            <address>
		                                                   队长:<strong><%= team.getCaptainName()%></strong><br>
		                                                   球队简介：<%= team.getDescription() %><br>
		                                                   球队级别:<a href=""><% if(team.getTeamGrade() == 1) {%>
		                                                	  成人组
		                                                <% }; %> 
		                                                <% if(team.getTeamGrade() == 2) {%>
		                                                	  青少年
		                                                <% }; %> 
		                                                <% if(team.getTeamGrade() == 3){%>
		                                                	  女足
		                                                <% }; %> </a><br>
		                        </address>
		                        <button class="btn btn-primary" type="submit">申请加入球队</button>
		                        </div>
		                        <div class="clearfix"></div>
		                </div>
		            </div>
		        <% } %>
	        </div>
	    </form>
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
