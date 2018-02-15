<%-- 
    Document   : view_loanmaster
    Created on : Mar 2, 2015, 8:28:37 PM
    Author     : Kalana
--%>

<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="com.nbs.model.VFindDatabnkLonLoanMaster"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="com.nbs.model.BnkDepDepositMaster"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | View Loan Customers</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
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

    <body class="skin-blue  pace-done fixed">

        <%
            String tellerIndexKey = "";
            if (request.getParameter("tellerIndexKey") != null) {
                tellerIndexKey = request.getParameter("tellerIndexKey");
            }
        %>

        <!--........header.....-->
        <%
            String branchName = "";
            String key = "";
            if (request.getSession().getAttribute("branch") == null) {
                response.sendRedirect("../BranchSession?page=teller/view_acc4.jsp?tellerIndexKey=0");
            } else {
                ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
                branchName = bankBranch.getCSubSectionNameUni();
            }
        %>
        <%@include file="teller_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Teller -
                        <small>View Loan Customers</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">View Loan Customers</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body">
                                    <div class="row">
                                        <form id="search" action="../GetViewLoanMasterServlet?tellerIndexKey=<%=tellerIndexKey%>" method="post">
                                            <div class="col-md-12">  
                                                <div class="form-group">
                                                    <!--<div class="input-group">-->
                                                    <div class="input-group col-lg-12">
                                                        <span class="input-group-addon"><input checked type="checkbox" name="allcustomers"> All Customers</span>
                                                        <span class="input-group-addon"><%=branchName%></span>
                                                        <input type="text" class="form-control" name="searchText" value="<%=key%>">
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-default" type="submit"><span class="fa fa-search"></span>Search</button>
                                                        </span>
                                                    </div>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </form>
                                        <div class="col-md-12 bg-top">
                                            <table class="table table-bordered table-hover table-style">
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Loan Acc No</th>
                                                    <th class="text-center">Old Loan Acc No</th>
                                                    <th class="text-center">System Code</th>
                                                    <th class="text-center">Loan Name</th>
                                                    <th class="text-center">CIF No</th>
                                                    <th class="text-center">NIC</th>
                                                    <th class="text-center">Full Name</th>
                                                    <th class="text-center">Date</th>
                                                    <th class="text-center">App Amount</th>
                                                    <th class="text-center">Due</th>
                                                    <!--<th class="text-center"></th>-->
                                                </tr>
                                                <tbody>
                                                    <%
                                                        try {
                                                            if (request.getSession().getAttribute("view3") != null) {
                                                                List<VFindDatabnkLonLoanMaster> bcms = (AbstractList<VFindDatabnkLonLoanMaster>) request.getSession().getAttribute("view3");
                                                                for (VFindDatabnkLonLoanMaster b : bcms) {
                                                    %>
                                                    <tr>
                                                        <td style="font-size: 12px;"><%=b.getNLonMFID()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCLonAccountNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCOldLonAccountNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCSysCode()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCLonName()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCCIFNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCNICNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCFullName()%></td>
                                                        <td style="font-size: 12px;"><%=b.getDLoanDate()%></td>
                                                        <td style="font-size: 12px;" class="text-right"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=b.getNApprovedAmount()%>" pattern="##,###.##"/></td>
                                                        <td style="font-size: 12px;" class="text-right"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=b.getNToDateDueCapital()%>" pattern="##,###.##"/></td>
                                                        <td class="text-center">
                                                            <%
                                                                if (tellerIndexKey.equals("4")) {
                                                            %>
                                                            <a href="../GetterDepositLoanDetailsServlet?identityEncript=1&accountValue=4&accountNumber=<%=Security.encrypt(b.getCLonAccountNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("loanPayment")) {
                                                            %>
                                                            <a href="../GetterLoanTransactionServlet?identityEncript=1&searchingType=1&accountNumber=<%=Security.encrypt(b.getCLonAccountNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("loanIssue")) {
                                                            %>
                                                            <a href="../GetterLoanTransactionServlet?identityEncript=1&searchingType=2&accountNumber=<%=Security.encrypt(b.getCLonAccountNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else {
                                                            %>
                                                            <a href="#" class="btn btn-default btn-xs">update</a>
                                                            <%
                                                                }
                                                            %>
                                                        </td>
                                                    </tr>
                                                    <%
                                                                }
                                                            }
                                                            request.getSession().removeAttribute("view3");
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            throw new ServletException(e);
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
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
