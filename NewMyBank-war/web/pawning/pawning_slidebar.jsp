<%-- 
    Document   : pawning_sidebar
    Created on : Apr 3, 2015, 8:44:23 AM
    Author     : mmh
--%>

<%@page import="com.nbs.common.Security"%>
<%@page import="com.nbs.model.GenUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String userNameRigthSideBar = "User";
    //String userType = "Developer";
    if (request.getSession().getAttribute("user") != null) {
        GenUser genUser = (GenUser) request.getSession().getAttribute("user");
        userNameRigthSideBar = genUser.getCUserName();
    }

%>
<section class="sidebar">
    <!-- Sidebar user panel -->
    <div class="user-panel">
        <div class="pull-left image">
            <img src="../images/icon-user-default.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
            <p>Hello, <%=userNameRigthSideBar%></p>

            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
    </div>
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu">
        <!--./Money Deposit-->
        <input type="hidden" value="" name="nDepMFID" id="nDepMFID"/>
        <li style="background-color: #f9f9f9" id="moneyDepType1">
            <a href="../PawningMasterServlet">
                <i class="fa fa-plus-circle small"></i><span style="color: green;font-size: 13px;">අත්තිකරම්</span>
            </a>
        </li> 
        <li style="background-color: #f9f9f9" id="moneyDepType1">
            <a href="re_pawning.jsp?index=1001">
                <i class="fa fa-plus-circle small"></i><span style="color: green;font-size: 13px;">සම්පුර්නයෙන් බේරීම</span>
            </a>
        </li> 
        <li style="background-color: #f9f9f9" id="moneyDepType1">
            <a href="re_pawning.jsp?index=1002">
                <i class="fa fa-plus-circle small"></i><span style="color: green;font-size: 13px;">කොටසක් බැදීම</span>
            </a>
        </li> 
        <li style="background-color: #f9f9f9" id="moneyDepType1">
            <a href="re_pawning.jsp?index=1003">
                <i class="fa fa-plus-circle small"></i><span style="color: green;font-size: 13px;">නැවත තැබීම</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="pawntype">
            <a href="../GetPawningTypeServlet?index=1">
                <i class="fa fa-plus-circle small"></i><span style="color: green;font-size: 13px;">උකස් වර්ගයන්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="pawntype">
            <a href="../GetPawningTypeServlet?index=2">
                <i class="fa fa-plus-circle small"></i><span style="color: green;font-size: 13px;">සියළු උකස් දැකීම</span>
            </a>
        </li>
    </ul>
</section>