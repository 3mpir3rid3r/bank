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
        <title>බඩු අඩු වැඩිය</title>

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
                        <small>බඩු අඩු වැඩිය</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> F-28</a></li>
                        <li><a href="#">තොග</a></li>
                        <li><a href="#">බඩු අඩු වැඩිය</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <%@include file="../f28_money_header.jsp" %>

                    <div class="row">
                        <div class="col-md-12 bg-top">
                            <!--Money saving-->
                            <div class="panel box box-info bg-color">
                                <!--./body-->
                                <form  class="form-horizontal" action="../NewBnkDepDepositTransactionServlet" method="post" name="depForm" onsubmit="validateNewDeposit(this);
                                        return false;">
                                    <div class="box-body">
                                        <h1>බඩු අඩු වැඩිය</h1>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--Money saving-->
                    </div>
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
