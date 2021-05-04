<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>用户注册</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">
	<form action="RegistServlet" method="post" class="form form-horizontal">	
	    <div class="middle-box text-center loginscreen   animated fadeInDown">
	        <div>
	            <div>
	                <h1 class="logo-name">H+</h1>
	            </div>
	            <h3>欢迎注册五人制足球平台</h3>
	            <p>创建一个新账户</p>
	            <form class="m-t" role="form" action="login.html">
	                <div class="form-group">
	                    <input type="text" class="form-control" placeholder="请输入用户名" required="" name="userName">
	                </div>
	                <div class="form-group">
	                    <input type="text" class="form-control" placeholder="请输入真名" required="" name="realName">
	                </div>
	                <div class="form-group">
	                    <select class="form-control m-b" placeholder="性别" name="size">
	                         <option>男</option>
	                         <option>女</option>
		                </select>
	                </div>
	                <div class="form-group">
	                    <input type="text" class="form-control" placeholder="请输入年龄" required="" name="age">
	                </div>
	                <div class="form-group">
	                    <input type="text" class="form-control" placeholder="请输入电话号码" required="" name="phone">
	                </div>
	                <div class="form-group">
	                    <input type="password" class="form-control" placeholder="请输入密码" required="">
	                </div>
	                <div class="form-group">
	                    <input type="password" class="form-control" placeholder="请再次输入密码" required=""  name="password">
	                </div>
	                <div class="form-group text-left">
	                    <div class="checkbox i-checks">
	                        <label class="no-padding">
	                            <input type="checkbox"><i></i> 我同意注册协议</label>
	                    </div>
	                </div>
	                <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>
	
	                <p class="text-muted text-center"><small>已经有账户了？</small><a href="login.jsp">点此登录</a>
	                </p>
	
	            </form>
	        </div>
	    </div>
	</form>
    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
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
