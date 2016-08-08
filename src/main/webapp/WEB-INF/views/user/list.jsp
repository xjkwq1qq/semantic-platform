<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="en">
<%@ include file="/common/header.jsp" %>
<head>
    <title>用户管理</title>
    <link href="${path}/static/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"
          rel="stylesheet">
    <link href="${path}/static/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
    <style>
        #page-wrapper {
            margin: 0 0 0 0px;
        }
    </style>
</head>
<body style="background-color:#ffffff">
<div id="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        查询条件
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form class="form-horizontal" id="searchForm">
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <label class="col-sm-4 control-label">终端：</label>
                                    <div class="col-sm-8">
                                        <select id="terminalId" name="terminalId" class="form-control">
                                            <option value="">全部</option>
                                            <option value="1">PC</option>
                                            <option value="2">手机</option>
                                            <option value="3">淘宝</option>
                                            <option value="4">天猫</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-sm-4">
                                    <label class="col-sm-4 control-label">任务类型：</label>
                                    <div class="col-sm-8">
                                        <select id="taskTypeId" name="taskTypeId" class="form-control">
                                            <option value="">全部类型</option>
                                            <option value="1">常规任务</option>
                                            <option value="2">特色任务</option>
                                            <option value="3">快速任务</option>
                                            <option value="4">特殊任务</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-sm-4">
                                    <label class="col-sm-4 control-label">任务状态：</label>
                                    <div class="col-sm-8">
                                        <select id="taskStatus" name="taskStatus" class="form-control">
                                            <option value="">全部状态</option>
                                            <option value="1">保存未发布</option>
                                            <option value="2">已发布</option>
                                            <option value="3">已撤销</option>
                                            <option value="4">进行中</option>
                                            <option value="5">已完成</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <label class="col-sm-4 control-label">商家生财ID：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="businessUserId"
                                               name="businessUserId"
                                               placeholder="商家生财ID">
                                    </div>
                                </div>
                                <div class="form-group col-sm-8">
                                    <label class="col-sm-2 control-label">发布时间：</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="input-append date form_datetime form-control"
                                               id="starttime"
                                               name="starttime" placeholder="开始时间">
                                    </div>
                                    <span style="float: left; padding-top: 10px;">~</span>
                                    <div class="col-sm-3">
                                        <input type="text" class="input-append date form_datetime form-control"
                                               id="endtime"
                                               name="endtime" placeholder="结束时间">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-sm-12" style=" text-align: center;">
                                <button type="button" id="searchButton"
                                        class="btn btn-primary glyphicon glyphicon-search"> 搜索
                                </button>
                                <button type="button" id="report" class="btn btn-success glyphicon glyphicon-download">
                                    批量导出
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        数据展示
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" width="100%" id="table">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>密码</th>
                                    <th>年龄</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<!-- DataTables JavaScript -->
<script src="${path}/static/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="${path}/static/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script src="${path}/static/bower_components/datatables-responsive/js/dataTables.responsive.js"></script>
<script>
    function doSearch() {
        //table展示
        var table = $('#table').DataTable({
            "processing": true,
            "serverSide": true,
            "bLengthChange": false,
            "bFilter": false,
            "bSort": false,
            "bDestroy": true,
            "language": {
                "url": path + "/static/language_datatables.json"
            },
            "ajax": {
                "url": path + "/user/datalists",
                "type": "POST",
                "data": {
                    "taskId": $('#taskId').val(),
                    "platformId": $('#platformId').val(),//审核申请ID
                    "storename": $('#storename').val(),//审核ID类型
                }
            },
            "columns": [
                {"data": "username", "width": "15%"},
                {"data": "password", "width": "15%"},
                {"data": "age", "width": "15%"},
                {"data": "id", "width": "25%"},
            ],
            "columnDefs": [
                /*{
                 "render": function (data, type, row) {
                 if (data == 1) {
                 return '保存未发布';
                 } else if (data == 2) {
                 return '已发布';
                 } else if (data == 3) {
                 return '已撤销';
                 } else if (data == 4) {
                 return '进行中';
                 } else {
                 return '已完成';
                 }
                 },
                 "targets": 1
                 },*/
//                {
//                    "render": function (data, type, row) {
//                        if (data == 1) {
//                            return '淘宝/天猫';
//                        } else {
//                            return '京东';
//                        }
//                    },
//                    "targets": 4
//                },
//                {
//                    "render": function (data, type, row) {
//                        if (data == 1) {
//                            return '常规任务';
//                        } else if (data == 2) {
//                            return '特色任务';
//                        } else if (data == 3) {
//                            return '快速任务';
//                        } else if (data == 4) {
//                            return '特殊任务';
//                        }
//                    },
//                    "targets": 5
//                },
                {
                    "render": function (data, type, row) {
                        return '<a class="btn btn-warning" href="' + path + '/task/detail/' + data + '?_d=' + new Date().getTime() + '">查看任务详情</a>';
                    },
                    "targets": 3
                }
            ]

        });
    }
    ;
    doSearch();
    //查询事件
    $('#searchButton').click(function () {
        doSearch();
    });
</script>
