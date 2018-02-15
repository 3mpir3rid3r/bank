<%-- 
    Document   : teller_header
    Created on : Feb 21, 2015, 3:53:20 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.ActSectionsSub"%>
<%@page import="com.nbs.model.GenUser"%>
<%@page import="java.util.Date"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String userName = "User";
    String userType = "Developer";
    if (request.getSession().getAttribute("user") != null) {
        GenUser genUser = (GenUser) request.getSession().getAttribute("user");
        userName = genUser.getCUserName();
        userType = genUser.getNUserTypeID().getCUserType();
    }
    if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("../");
    }

    ActSectionsSub bankBranch1 = (ActSectionsSub) session.getAttribute("branch");
%>
<header class="header">
    <a href="index.jsp" class="logo" style="font-size: x-large">
        <!-- Add the class icon to your logo image or logo icon to add the margining -->
        Pawning
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <ul class="nav navbar-nav" style="margin-left: 10px;">
            <li>
                <a class="text-center" href="../main.jsp">
                    <strong>මුල් පිටුව</strong>
                </a>
            </li>
        </ul>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li>
                    <a class="text-center" href="#">
                        <strong>Branch : <%= bankBranch1.getCSubSectionNameUni() + " - ( " + bankBranch1.getNSubSectionID() + " )"%></strong>
                    </a>
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
