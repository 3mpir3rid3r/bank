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
            <img src="../images/icon-user-default.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
            <p>Hello, <%=userNameRigthSideBar%></p>

            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
    </div>
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu">
        <!--        <li style="background-color: #f9f9f9" id="moneyDepType1">
                    <a href="#" onclick="">
                        <i class="fa fa-plus-circle small"></i><span style="color: green;font-size: 13px;">සාමාජික නාම ලේඛණය</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="moneyDepType2">
                    <a href="#" onclick="">
                        <i class="fa fa-minus-circle small"></i><span style="color: green;font-size: 13px;">තොග</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="moneyDepType3">
                    <a href="#">
                        <i class="fa fa-exchange small"></i><span style="color: green;font-size: 13px;">ගෙවීම්</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="moneyLonType1">
                    <a href="#" onclick="">
                        <i class="fa fa-plus-square small"></i><span style="color: green;font-size: 13px;">මූලික අංශය</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="moneyLonType2">
                    <a href="#" onclick="passMoneyLoan(this)">
                        <i class="fa fa-minus-square small"></i><span style="color: green;font-size: 13px;">පාලක පැනලය</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="creditorDebtor114">
                    <a href="#">
                        <i class="fa fa-plus-square-o small"></i><span style="color: green;font-size: 13px;">පොදු ලේජරය</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="creditorDebtor115">
                    <a href="#">
                        <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">මුදල් අයකැම්</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="creditorDebtor115">
                    <a href="#">
                        <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">අංශය</span>
                    </a>
                </li>
                <li style="background-color: #f9f9f9" id="creditorDebtor115">
                    <a href="#">
                        <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">කාරනාව</span>
                    </a>
                </li>-->
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="f28_money_take.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">මුදල් ලැබීම්1</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="f28_money_payent.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">ණයහිමි ගෙවීම්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="f28_money_take1.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">මුදල් ලැබීම්2</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="f28_cr.jsp">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">හර සටහන්</span>
            </a>
        </li>
    </ul>
</section>
