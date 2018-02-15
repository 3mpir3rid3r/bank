<%-- 
    Document   : teller_sidebar
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
            <img src="../../images/icon-user-default.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
            <p>Hello, <%=userNameRigthSideBar%></p>

            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
    </div>
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu">
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="16ab_take.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">16/B ගැනුම්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="16ab_take_aththikaram.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">16/B ගැනුම් අත්තිකාරම්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="16ab_store_labim.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">16/B ගබඩා ලැබීම්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="14c9b_vikunum.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">14C/9B විකුණුම්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="f17.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">F 17</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="f18.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">F 18</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="f19.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">F 19</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="item_minmax.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">බඩු අඩු වැඩිය</span>
            </a>
        </li>
    </ul>
</section>
