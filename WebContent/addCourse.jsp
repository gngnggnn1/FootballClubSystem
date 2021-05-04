<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>添加课程</title>
    
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
    	<form action="AddCourseServlet" method="post" class="form form-horizontal" id="form-addfield">
	        <div class="row">
	            <div class="col-sm-12">
	                <div class="ibox float-e-margins">
	                    <div class="ibox-title">
	                        <h5>添加课程<small>请输入课程基本信息</small></h5>
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
	                                <label class="col-sm-2 control-label">课程名</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder="请输入课程名" class="form-control" name = "courseName">
	                                </div>
	                            </div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">课程级别</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder="请输入课程级别" class="form-control" name = "courseGrade">
	                                </div>
	                            </div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">课程日期</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder="请输入课程日期" class="form-control" name = "time">
	                                </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">课程介绍</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" placeholder="请输入课程介绍" class="form-control" name = "description">
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
