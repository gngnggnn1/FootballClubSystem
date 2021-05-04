<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="entity.Field" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>查看场地</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
    	<form action="RemoveFieldServlet" method="post" class="form form-horizontal" id="form-addfield">	
	        <div class="row">
	        	<% List<Field> fieldList = (List)request.getAttribute("fieldList");%>
	        	<% for(Field field:fieldList){ %>
		            <div class="col-sm-4">
		                <div class="contact-box">
		                    <a href="ToModifyFieldServlet">
		                        <div class="col-sm-4">
		                            <div class="text-center">
		                                <img alt="image" class="img-circle m-t-xs img-responsive" src="img/field.jpg">
		                                <%-- <div class="m-t-xs font-bold" style="display: none" name = "fieldID" <%= field.getFieldID() %>></div> --%>
		                                <input type="text" style="display: none" value = <%= field.getFieldID() %> class="form-control" name = "fieldID">
		                                <% session.setAttribute("chosenField", field); %>
		                            </div>
		                        </div>
		                        <div class="col-sm-8">
		                            <h3><strong> <%= field.getFieldName() %> </strong></h3>
		                            <p><i class="fa fa-map-marker"></i> <%= field.getLocation() %> </p>
		                            <address>
		                                                   价格:<strong><%= field.getPrice() + "元/200分钟" %></strong><br>
		                                                   球场人数：<%= field.getSize() + "人"%><br>
									是否有灯：<%= field.getHasLight() == 1 ? "是" : "否" %><br>
		                                                   场地材质:<a href=""><%= field.getRealGrass() == 1 ? "是" : "否" %></a><br>                      
		                                                   是否室内:<a href=""><%= field.getInDoor() == 1 ? "是" : "否" %></a><br>
		                                                   便利店:<a href=""><%= field.getHasShop() == 1 ? "是" : "否" %></a><br>
		                        </address>
		                        <button class="btn btn-primary" type="submit">删除球场</button>
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

</html>
