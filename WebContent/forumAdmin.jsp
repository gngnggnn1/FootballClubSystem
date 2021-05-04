<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.Threads" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>约球吧</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="row">
    	<form action="RemoveThreadServlet" method="post" class="form form-horizontal" id="form-removeThread">
	        <div class="wrapper wrapper-content animated fadeInRight">
	            <div class="row">
	                <div class="col-sm-12">
	                    <div class="wrapper wrapper-content animated fadeInRight">
	
	                        <div class="ibox-content m-b-sm border-bottom">
	                            <div class="p-xs">
	                                <div class="pull-left m-r-md">
	                                    <i class="fa fa-globe text-navy mid-icon"></i>
	                                </div>
	                                <h2>欢迎来到约球吧</h2>
	                                <span>想踢球没有队友？快发帖约起来</span>
	                            </div>
	                        </div>
	
	                        <div class="ibox-content forum-container">
	
	                            <div class="forum-title">
	                                <div class="pull-right forum-desc">
	                                    <samll>总帖子数： <%= request.getAttribute("adminThreadSum") %></samll>
	                                </div>
	                                <h3>发帖须知</h3>
	                            </div>
	                            <% Random rd = new Random(); %>
								<% List<Threads> adminThreadList = (List)request.getAttribute("adminThreadList"); %>
								<% for(Threads thread:adminThreadList){ %>
		                            <div class="forum-item active">
		                            	<input type="text" style="display: none" value = <%= thread.getThreadID() %> class="form-control" name = "threadID">
		                                <div class="row">
		                                    <div class="col-sm-9">
		                                        <div class="forum-icon">
		                                            <i class="fa fa-shield"></i>
		                                        </div>
		                                        <a href="forum_post.html" class="forum-item-title"><%= thread.getTopic() %></a>
		                                        <div class="forum-sub-title"><%= thread.getDetail() %></div>
		                                    </div>
		                                    <div class="col-sm-1 forum-info">
		                                        <span class="views-number">
		                                            <%= thread.getUserName() %>
		                                        </span>
		                                        <div>
		                                            <small>发帖人</small>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-1 forum-info">
		                                        <span class="views-number">
		                                            <%= rd.nextInt(100) %>
		                                        </span>
		                                        <div>
		                                            <small>浏览</small>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-1 forum-info">
		                                            <small><%= thread.getTime() %></small>
		                                        <div>
		                                            <small>最后回复</small>
		                                        </div>
		                                    </div>
		                                </div>
		                                <button class="btn btn-primary" type="submit">删除</button>
		                            </div>
								<% } %>
								
								
	                            <div class="forum-title">
	                                <div class="pull-right forum-desc">
	                                    <samll>总贴子数：<%= request.getAttribute("threadSum") %></samll>
	                                </div>
	                                <h3>讨论区</h3>
	                            </div>
	                            
								<% List<Threads> threadList = (List)request.getAttribute("threadList"); %>
								<% for(Threads thread:threadList){ %>
		                            <div class="forum-item">
		                            	<input type="text" style="display: none" value = <%= thread.getThreadID() %> class="form-control" name = "threadID">
		                                <div class="row">
		                                    <div class="col-sm-9">
		                                        <div class="forum-icon">
		                                            <i class="fa fa-clock-o"></i>
		                                        </div>
		                                        <a href="forum_post.html" class="forum-item-title"><%= thread.getTopic() %> </a>
		                                        <div class="forum-sub-title"><%= thread.getDetail() %></div>
		                                    </div>
		                                    <div class="col-sm-1 forum-info">
		                                        <span class="views-number">
		                                            <%= thread.getUserName() %>
		                                        </span>
		                                        <div>
		                                            <small>发帖人</small>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-1 forum-info">
		                                        <span class="views-number">
		                                            <%= rd.nextInt(100) %>
		                                        </span>
		                                        <div>
		                                            <small>浏览</small>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-1 forum-info">
		                                            <small><%= thread.getTime() %></small>
		                                        <div>
		                                            <small>最后回复</small>
		                                        </div>
		                                    </div>
		                                </div>
		                                <button class="btn btn-primary" type="submit">删除</button>
		                            </div>
								<% } %>
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



    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>


    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
