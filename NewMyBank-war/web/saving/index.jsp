<%-- 
    Document   : index
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : mmh
--%>

<%@page import="com.nbs.common.Alerts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saving</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
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

    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include file="saving_header.jsp" %>
        <!--..............................-->
 <%
        
            String alert="";
            if (request.getParameter("mg") != null) {
                String mg = (String) request.getParameter("mg");
                if (!("".equals(mg))) {
                    alert = Alerts.successAlert("Successfull", mg);
                }
            }
        %>
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
                        <li>
                            <a href="interest_calculation_qua.jsp">
                                <i class="fa fa-laptop"></i>
                                <span>පොළී ගනණය(කාර්තු)</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-edit"></i> <span class="">පොළී ගනණය(ස්ථිර)</span>
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
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Saving -
                        <small>Home</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Saving</a></li>
                        <li><a href="#">Home</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <%=alert%>
                <section id="content" class="content">
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
