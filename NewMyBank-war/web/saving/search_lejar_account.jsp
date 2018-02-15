<%-- 
    Document   : index
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : mmh
--%>

<%@page import="java.util.Date"%>
<%@page import="com.nbs.common.LogedUser"%>
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
        <%
            String userName = "User";
            String userType = "Developer";
            if (request.getSession().getAttribute("LogedUser") != null) {
                LogedUser logedUser = (LogedUser) request.getSession().getAttribute("LogedUser");
                userName = logedUser.getUserName();
                userType = logedUser.getUserType();
            }
            if (request.getSession().getAttribute("LogedUser") == null) {
                //response.sendRedirect("../index.jsp");
            }
        %>
        <!--........header.....-->
        <header class="header">
            <a href="#" class="logo" style="font-size: x-large">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Saving
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">

                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li>
                            <a class="text-center" href="#">
                                <strong>Sign Up</strong>
                                <i class="fa fa-sign-out"></i>
                            </a>
                        </li>
                        <li class="dropdown messages-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope"></i>
                                <span class="label label-success">4</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 4 messages</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 200px;"><ul class="menu" style="overflow: hidden; width: 100%; height: 200px;">
                                            <li><!-- start message -->
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="../../img/avatar3.png" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Support Team
                                                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li><!-- end message -->
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="../../img/avatar2.png" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        AdminLTE Design Team
                                                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="../../img/avatar.png" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        Developers
                                                        <small><i class="fa fa-clock-o"></i> Today</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="../../img/avatar2.png" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        Sales Department
                                                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="../../img/avatar.png" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        Reviewers
                                                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                        </ul><div class="slimScrollBar" style="background-color: rgb(0, 0, 0); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: block; border-top-left-radius: 0px; border-top-right-radius: 0px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; z-index: 99; right: 1px; background-position: initial initial; background-repeat: initial initial;"></div><div class="slimScrollRail" style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-top-left-radius: 0px; border-top-right-radius: 0px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; background-color: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px; background-position: initial initial; background-repeat: initial initial;"></div></div>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>

                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user"></i>
                                <span><%=userName%> <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header bg-light-blue">
                                    <img src="../../img/avatar3.png" class="img-circle" alt="User Image">
                                    <p>
                                        <%=userName%> - <%=userType%>
                                        <small>Member start <%out.write(new Date().toString());%></small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Profile</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="../signOut" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 

            <!--...........right-side.........-->
            <aside id="content" class="right-side strech">
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
                <section class="content">
                    <div class="row bg-top">
                        <div class="col-md-12">
                            <img src="../img/teller/h.jpg" style="height: 430px;width: 100%"/>
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



