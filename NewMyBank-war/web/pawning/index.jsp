<%-- 
    Document   : Home
    Created on : Nov 18, 2014, 3:33:53 PM
    Author     : kalana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pawning</title>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <!--<link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>-->
        <link href="../css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>

        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-pad{
                padding-right:0px;                
            }
            .bg-searchheight{
                height:128px;                
            }

            th,td { white-space: nowrap; }
            div.dataTables_wrapper {
                width: auto;
                margin: 0 auto;
            }

        </style>

        <!--script-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.dataTables.min.js" type="text/javascript"></script>

    </head>
    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">
        <!--........header.....-->
        <%@include  file="pawning_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="pawning_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Pawning -
                        <small>Home</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Pawning</a></li>
                        <li><a href="#">Home</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
            </aside>
        </div>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
        <script src="../js/bootbox.js" type="text/javascript"></script>
        <script src="../js/bootbox.min.js" type="text/javascript"></script>
    </body>
</html>
