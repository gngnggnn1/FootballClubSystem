<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="entity.User" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>查看用户</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
    	<form action="RemoveUserServlet" method="post" class="form form-horizontal" id="form-addfield">	
	        <div class="row">
	        	<% List<User> userList = (List)request.getAttribute("userList");%>
	        	<% for(User user:userList){ %>
		            <div class="col-sm-4">
		                <div class="contact-box">
		                        <div class="col-sm-4">
		                            <div class="text-center">
		                            <% if(user.getIdentity() == 1){ %>
									    <img alt="image" class="img-circle m-t-xs img-responsive" src="img/admin.jpg">
									<% } %>
									<% if (user.getIdentity() == 2){ %>
											<img alt="image" class="img-circle m-t-xs img-responsive" src="img/user.jpg">
									<% } %>
									<% if (user.getIdentity() == 3){ %>
										<img alt="image" class="img-circle m-t-xs img-responsive" src="img/team.jpg">
									<% } %>
									<% if (user.getIdentity() == 4){ %>
										<img alt="image" class="img-circle m-t-xs img-responsive" src="img/coach.jpg">
									<% } %>
		                            </div>
		                        </div>
		                        <div class="col-sm-8">
		                        	<% session.setAttribute("userNameToRemove", user.getUserName()); %>
		                            <h3><strong> <%= user.getUserName() %> </strong></h3>
		                                                        用户真名：<%= user.getRealName() %><br>
		                            <address>
		                                                        用户性别：<%= user.getSex() %><br>
		                                                        联系方式：<%= user.getPhone() %><br>
		                                                   用户类别:<a href=""><% if(user.getIdentity() == 1) {%>
		                                                	  超级管理员
		                                                <% }; %> 
		                                                <% if(user.getIdentity() == 2) {%>
		                                                	  球员
		                                                <% }; %> 
		                                                <% if(user.getIdentity() == 3){%>
		                                                	  球队
		                                                <% }; %> 
		                                                <% if(user.getIdentity() == 4){%>
		                                                	  教练
		                                                <% }; %></a><br>
		                        </address>
		                        <button class="btn btn-primary" type="submit">删除用户</button>
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