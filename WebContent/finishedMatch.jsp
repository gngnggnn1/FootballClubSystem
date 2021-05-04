<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="entity.Match" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>查看已完成的比赛</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
    	<form action="RemoveMatchServlet" method="post" class="form form-horizontal" id="form-addfield">	
	        <div class="row">
	        	<% List<Match> matchList = (List)request.getAttribute("finishedMatchList");%>
	        	<% for(Match match:matchList){ %>
		            <div class="col-sm-4">
		                <div class="contact-box">
		                    <a href="ToModifyMatchServlet">
		                        <div class="col-sm-4">
		                            <div class="text-center">
		                                <img alt="image" class="img-circle m-t-xs img-responsive" src="img/a2.jpg">
		                                <%-- <div class="m-t-xs font-bold" style="display: none" name = "fieldID" <%= field.getFieldID() %>></div> --%>
		                                <input type="text" style="display: none" value = <%= match.getMatchID() %> class="form-control" name = "matchID">
		                                <% session.setAttribute("chosenMatch", match); %>
		                            </div>
		                        </div>
		                        <div class="col-sm-8">
		                            <h3><strong>主队:  <%= match.getTeamName1() %></strong></h3>
		                            <h3><strong>客队:  <%= match.getTeamName2() %></strong></h3>
		                            <h3><strong>比分（主：客）:  <%= match.getScore() %></strong></h3>
		                            <p>比赛过程： <%= match.getMatchDescription() %> </p>
		                            <p>比赛日期： <%= match.getMatchDate() %> </p>
		                            
		                        <button class="btn btn-primary" type="submit">删除比赛</button>
		                        </div>
		                        <div class="clearfix"></div>
		                    </a>
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

