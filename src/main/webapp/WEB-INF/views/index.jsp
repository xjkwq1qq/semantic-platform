<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<%@ include file="/common/header.jsp"%>
<head>
    <title>招标系统1</title>
    <!-- MetisMenu CSS -->
    <link href="${path}/static/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
</head>

<body>
<div id="wrapper" style="height: 100%">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${path}/toindex">招标抓取系统</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户信息</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 招标<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#" class="iframemenu" url="${path}/user/tolist">招标抓取</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i> 设置<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="panels-wells.html">关键词</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>
    <style>
        #page-wrapper{ position:absolute; left:0;right: 0;padding: 0 0}
        .index-iframe{ position:static; left:0; top:0; right:0; bottom:0; width:100%; height:100%; border:0; background:none;}
    </style>
    <div id="page-wrapper">
        <iframe src="welcome" class="index-iframe"   name="frmright" id="frmright" ></iframe>
    </div>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="${path}/static/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script>
        //修改高度
        function widthAndHeight(){
            var height = document.documentElement.clientHeight;
            $('#page-wrapper').height(height-$('.navbar-static-top').outerHeight()-5);
        }
        /*窗口大小改变事件*/
        window.onresize=function(){
            widthAndHeight();
        }

        function menuinit() {
            $('.iframemenu').click(function(){
                $('#frmright').attr('src',$(this).attr('url'));
            });
        }

        $(function() {
            widthAndHeight();
            menuinit();
        });
    </script>
</div>
</body>
</html>
