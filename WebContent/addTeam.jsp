<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>添加球队</title>
    
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
    	<form action="AddTeamServlet" method="post" class="form form-horizontal" id="form-addfield">
	        <div class="row">
	            <div class="col-sm-12">
	                <div class="ibox float-e-margins">
	                    <div class="ibox-title">
	                        <h5>添加球队 <small>并为球队创建账号</small></h5>
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
	                        <form method="get" class="form-horizontal">
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">球队名</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder="请输入球队名" class="form-control" name = "teamName">
	                                </div>
	                            </div>
								
								<div class="form-group">
	                                <label class="col-sm-2 control-label">球队简介</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder="请输入球队简介" class="form-control" name = "description">
	                                </div>
	                            </div>
								
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">球队级别
	                                    <br/>
	                                </label>
	
	                                <div class="col-sm-10">
	                                    
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" checked="" value="1" id="optionsRadios1" name="teamGrade">成年队</label>
	                                    </div>
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" value="2" id="optionsRadios2" name="teamGrade">青少年队</label>
	                                    </div>
	                                    <div class="radio">
	                                        <label>
	                                            <input type="radio" value="3" id="optionsRadios2" name="teamGrade">女足</label>
	                                    </div>
	                                </div>
	                            </div>
								
								<div class="form-group">
	                                <label class="col-sm-2 control-label">队长姓名</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" name = "captainName">
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">球队联系方式</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" name = "contact">
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">球队账号用户名</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" name = "teamUserName">
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">球队账号密码</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" name = "teamPassword">
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
