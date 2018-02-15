<%-- 
    Document   : 16ab_ganum
    Created on : May 10, 2015, 10:09:09 AM
    Author     : lasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>16/B ගබඩා ලැබීම්</title>

        <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-pad{
                padding-right:0px;                
            }

        </style>

    </head>
    <body class="skin-blue fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include file="../f28_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="whole_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        තොග -
                        <small>16/B ගබඩා ලැබීම්</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> F-28</a></li>
                        <li><a href="#">තොග</a></li>
                        <li><a href="#">16/B ගබඩා ලැබීම්</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <%@include file="../f28_money_header.jsp" %>

                    <form  class="form-horizontal" action="#" method="post" name="depForm" onsubmit="validateNewDeposit(this);
                            return false;">
                        <div class="row">
                            <div class="col-md-6 bg-top">
                                <!--./box-->
                                <div class="panel box box-info bg-color">
                                    <!--./body-->
                                    <div class="box-body" style="margin-bottom:-15px;">
                                        <div class="form-group">
                                            <label class="control-label col-sm-3 input-sm">අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm">අංශය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13">සැපයුම්කරු :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13">16 අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13"> බිල් අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13">දිනය :</label>
                                            <div class="col-md-9">
                                                <input type="date" class="form-control input-sm text-right">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13">ගෙවියයුතු දිනය :</label>
                                            <div class="col-md-9">
                                                <input type="date" class="form-control input-sm text-right">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13">ණය සීමාව :</label>
                                            <div class="col-md-5">
                                                <input type="number" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                            <label class="control-label col-sm-2 input-sm f-size13">දින</label>
                                        </div>
                                    </div>
                                </div>
                                <!--./box-->
                            </div>
                            <div class="col-md-6 bg-top" style="padding-left: 0px">
                                <div class="panel panel-default ">
                                    <div class="panel-heading"  style="padding-bottom: 0px;padding-top: 5px">
                                        ස්ථිර/සහතික තැම්පත්
                                    </div>
                                    <div class="panel-body bg-color" style="height: 186px">
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm">අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm">අංශය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13">සැපයුම්කරු :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13">16 අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13"> බිල් අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 bg-top" style="padding-left: 0px">
                                <div class="panel panel-default ">
                                    <div class="panel-heading" style="padding-bottom: 0px;padding-top: 5px">
                                        ස්ථිර/සහතික තැම්පත්
                                    </div>
                                    <div class="panel-body bg-color" style="height: 46px">
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13"> බිල් අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 bg-top">
                                <!--./box-->
                                <div class="panel box box-info bg-color">
                                    <!--./body-->
                                    <div class="box-body" style="margin-bottom:-25px;padding-left: 0px;padding-right: 0px;padding-top: 0px ">
                                        <div class="form-group">
                                            <div class="col-md-12" >
                                                <textarea class="form-control" rows="4" style="height: 105px"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <!--./body-->    
                                </div>
                                <!--./box-->
                            </div>
                            <div class="col-md-6 bg-top" style="padding-left: 0px">
                                <div class="panel panel-default ">
                                    <div class="panel-heading" style="padding-bottom: 0px;padding-top: 5px">
                                        ස්ථිර/සහතික තැම්පත්
                                    </div>
                                    <div class="panel-body bg-color" style="height:80px">
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13"> බිල් අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-10px;">
                                            <label class="control-label col-sm-3 input-sm f-size13"> බිල් අංකය :</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control input-sm text-right" placeholder="0.00">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 bg-top">
                                <!--./box-->
                                <div class="panel box box-info bg-color">
                                    <!--./body-->
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <button type="button" class="btn btn-sm btn-warning" onclick="" style="background-color: #1F9DE5;color: white">Confirm</button>
                                                <button type="button" class="btn btn-sm btn-warning" onclick="" style="background-color: #1F9DE5;color: white">Complete</button>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="pull-right">
                                                    <button type="button" class="btn btn-sm" onclick="" style="background-color: #1F9DE5;color: white">New</button>
                                                    <button type="button" class="btn btn-sm btn-success" onclick="" style="background-color: #1F9DE5;color: white">Save</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--./body-->    
                                </div>
                                <!--./box-->
                            </div>
                        </div>
                    </form>
                </section>
            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->

        <script src="../../js/jquery.min.js" type="text/javascript"></script>
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../js/AdminLTE/app.js" type="text/javascript"></script>

    </body>
</html>
