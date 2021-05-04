<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="entity.Field" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>修改球场信息</title>
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
    	<form action="ModifyFieldServlet" method="post" class="form form-horizontal" id="form-addfield">
	        <div class="row">
	            <div class="col-sm-12">
	                <div class="ibox float-e-margins">
	                    <div class="ibox-title">
	                        <h5>修改球场 <small>修改球场基本信息</small></h5>
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
	                    <% Field field = (Field)request.getAttribute("field"); %>
	                    <% session.setAttribute("fieldID", field.getFieldID()); %>
	                        <form method="get" class="form-horizontal">
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">球场名</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" disabled="" placeholder= <%= field.getFieldName() %> class="form-control" name = "fieldName">
	                                </div>
	                            </div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">球场位置</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" disabled="" placeholder= <%= field.getLocation() %> class="form-control" name = "location">
	                                </div>
	                            </div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">球场描述</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder= <%= field.getDescription() %> class="form-control" name = "description">
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">是否有灯
	                                    <br/>
	                                </label>
	
	                                <div class="col-sm-10">
	                                    
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" checked="" value="1" id="optionsRadios1" name="hasLight">是</label>
	                                    </div>
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" value="0" id="optionsRadios2" name="hasLight">否</label>
	                                    </div>
	                                </div>
	                            </div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">是否室内
	                                    <br/>
	                                </label>
	
	                                <div class="col-sm-10">
	                                    
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" checked="" value="1" id="optionsRadios1" name="inDoor">是</label>
	                                    </div>
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" value="0" id="optionsRadios2" name="inDoor">否</label>
	                                    </div>
	                                </div>
	                            </div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">是否真草
	                                    <br/>
	                                </label>
	
	                                <div class="col-sm-10">
	                                    
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" checked="" value="1" id="optionsRadios1" name="realGrass">是</label>
	                                    </div>
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" value="0" id="optionsRadios2" name="realGrass">否</label>
	                                    </div>
	                                </div>
	                            </div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">是否有便利店
	                                    <br/>
	                                </label>
	
	                                <div class="col-sm-10">
	                                    
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" checked="" value="1" id="optionsRadios1" name="hasShop">是</label>
	                                    </div>
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" value="0" id="optionsRadios2" name="hasShop">否</label>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">球场建议人数</label>
	
	                                <div class="col-sm-10">
	                                    <select class="form-control m-b" name="size">
	                                        <option>5</option>
	                                        <option>7</option>
	                                        <option>9</option>
	                                        <option>11</option>
	                                    </select>
	
	                                    
	                                </div>
	                            </div>
								
								<div class="form-group">
	                                <label class="col-sm-2 control-label">球场价格（元/200分钟）</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder = <%= field.getPrice() %> class="form-control" name = "price">
	                                </div>
	                            </div>
	                            
	                            <div class="hr-line-dashed"></div>
	                            <div class="form-group">
	                                <div class="col-sm-4 col-sm-offset-2">
	                                    <button class="btn btn-primary" type="submit">保存内容</button>
	                                    <button class="btn btn-white" type="submit">取消</button>
	                                </div>
	                            </div>
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
		</form>
    </div>

    <div id="modal-form" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6 b-r">
                            <h3 class="m-t-none m-b">登录</h3>

                            <p>欢迎登录本站(⊙o⊙)</p>

                            <form role="form">
                                <div class="form-group">
                                    <label>用户名：</label>
                                    <input type="email" placeholder="请输入用户名" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>密码：</label>
                                    <input type="password" placeholder="请输入密码" class="form-control">
                                </div>
                                <div>
                                    <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit"><strong>登录</strong>
                                    </button>
                                    <label>
                                        <input type="checkbox" class="i-checks">自动登录</label>
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <h4>还不是会员？</h4>
                            <p>您可以注册一个账户</p>
                            <p class="text-center">
                                <a href="form_basic.html"><i class="fa fa-sign-in big-icon"></i></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
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
