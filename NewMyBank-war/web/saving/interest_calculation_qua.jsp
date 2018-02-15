<%-- 
    Document   : index
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : mmh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saving</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        
        <link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>

        <style type="text/css">
            /*---------------------------------------------------------------------*/
            div.zTreeDemoBackground {width:auto;height:auto;text-align:left;}
            /*
            */ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;}
            ul.log {border: 1px solid #617775;background: #f0f6e4;width:300px;height:170px;overflow: hidden;}
            ul.log.small {height:45px;}
            ul.log li {color: #666666;list-style: none;padding-left: 10px;}
            ul.log li.dark {background-color: #E3E3E3;}
            /*------------------------------------------------------------------------*/
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:120px;                
            }
        </style>
    </head>

    <body class="skin-blue  pace-done" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include file="saving_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="../images/icon-user-default.png" class="img-circle" alt="User Image" >
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%=userName%></p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>

                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li>
                            <a href="../GetterBnkDepDetailsServlet" >
                                <i class="fa fa-users"></i> 
                                <span>තැම්පත් වර්ගයන්</span>
                            </a>
                        </li>
                        <li>
                            <a href="interest_calculation.jsp">
                                <i class="fa fa-money"></i>
                                <span>පොළී ගනණය</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="interest_calculation_qua.jsp">
                                <i class="fa fa-laptop"></i>
                                <span>පොළී ගනණය(කාර්තු)</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>පොළී ගනණය(ස්ථිර)</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-table"></i><span>ඉතුරුම් ගිනුම් හර</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-table"></i><span>ඉතුරුම් ගිනුම් බැර</span>
                            </a>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside id="content" class="right-side">
                <section class="content-header" >
                    <h1>
                        කල්පිරුණු ගිණුම්(කාර්තු)-
                        <small>පොළී ගනණය</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Saving</a></li>
                        <li><a href="#">පොළී ගනණය</a></li>
                        <li class="active">කල්පිරුණු ගිණුම්</li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom: -20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group"  style="margin-top:-10px">
                                                <label class="control-label col-sm-4 input-sm"></label>
                                                <div class="col-md-8">
                                                    <div class="radio">
                                                        <label>
                                                            <input class="input-sm" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                                            YEARLY
                                                        </label>
                                                        <label>
                                                            <input class="input-sm" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                                            MONTHLY
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12 bg-top">
                                            <div class="form-group">
                                                <br/>
                                                <label class="control-label col-sm-4 input-sm">තැන්පත් වර්ගය :</label>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.0" style="font-size:13px;" maxlength="25">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <br/>
                                                <label class="control-label col-sm-4 input-sm">තැන්පත් වර්ගය :</label>
                                                <div class="col-sm-8">
                                                    <select class="form-control my-input input-sm">...</select>     
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <br/>
                                                <label class="control-label col-sm-4 input-sm"></label>
                                                <div class="col-sm-8">
                                                    <div class="panel panel-default">
                                                        <div class="panel-body">
                                                            <div class="row">
                                                                <div class="col-md-12">
                                                                    <div class="form-group">
                                                                        <br/>
                                                                        <div class="col-sm-4">
                                                                            <label class="control-label col-sm-4 input-sm"></label>
                                                                        </div>
                                                                        <div class="col-sm-4">
                                                                            <label class="control-label col-sm-4 input-sm">Start Date</label>
                                                                        </div>
                                                                        <div class="col-sm-4">
                                                                            <label class="control-label col-sm-4 input-sm">End Date</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <br/>
                                                                        <div class="checkbox col-sm-4">
                                                                            <input type="checkbox" > ක්‍රියාකාරී ගිණුම් වර්ග
                                                                        </div>
                                                                        <div class="col-sm-8">
                                                                            <input type="date" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.0" style="font-size:13px;" maxlength="25">
                                                                        </div>
                                                                        <div class="col-sm-8">
                                                                            <input type="date" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.0" style="font-size:13px;" maxlength="25">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>
                    </div>
                </section>
            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

    </body>
</html>
