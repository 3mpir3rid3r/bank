<%-- 
    Document   : view_depositmaster
    Created on : Mar 2, 2015, 8:28:37 PM
    Author     : Kalana
--%>

<%@page import="com.nbs.model.BnkRefBankBranch"%>
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
        <title>Teller | View Depositors</title>

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
            String branchName = "";
            String key = "";
            if (request.getSession().getAttribute("branch") == null) {
                response.sendRedirect("../BranchSession?page=teller/view_acc4.jsp?tellerIndexKey=0");
            } else {
                ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
                branchName = bankBranch.getCSubSectionNameUni();
            }
        %>
        <%
            String tellerIndexKey = "";
            if (request.getParameter("tellerIndexKey") != null) {
                tellerIndexKey = request.getParameter("tellerIndexKey");
            }
        %>

        <!--........header.....-->
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
                        <small>View Deposit Customers</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">View Deposit Customers</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body">
                                    <div class="row">
                                        <form id="search" action="../GetViewDepositMasterServlet?tellerIndexKey=<%=tellerIndexKey%>" method="post">
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
                                                <thead style="background-color: #5bc0de">
                                                    <tr>
                                                        <th class="text-center" width="50px">ID</th>
                                                        <th class="text-center" width="100px">Our Acc No</th>
                                                        <th class="text-center" width="80px">Old Acc No</th>
                                                        <th class="text-center" width="100px">Cif No</th>
                                                        <th class="text-center" width="50px">Sys Code</th>
                                                        <th class="text-center" width="500px">Full Name</th>
                                                        <th class="text-center" width="100px">Book Balance</th>
                                                        <th class="text-center"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        try {
                                                            if (request.getSession().getAttribute("view2") != null) {
                                                                List<VFindDatabnkDepDepositMaster> bcms = (AbstractList<VFindDatabnkDepDepositMaster>) request.getSession().getAttribute("view2");
                                                                for (VFindDatabnkDepDepositMaster b : bcms) {
                                                    %>
                                                    <tr>
                                                        <td style="font-size: 12px;"><%=b.getNDepMFID()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCOurAccountNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCOldAccountNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCCIFNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCSysCode()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCFullName()%></td>
                                                        <td style="font-size: 12px;" class="text-right"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2"  pattern="##,###.##" type="" value="<%=b.getNCurBookBalance()%>"/></td>
                                                        <td class="text-center">
                                                            <%
                                                                if (tellerIndexKey.equals("1")) {
                                                            %>
                                                            <a href="../GetterDepositLoanDetailsServlet?identityEncript=1&accountValue=1&accountNumber=<%=Security.encrypt(b.getCOurAccountNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("moneySaving")) {
                                                            %>
                                                            <a href="../GetterMoneyTransactionServelet?identityEncript=1&searchingType=1&accountNumber=<%=Security.encrypt(b.getCOurAccountNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("moneyWidth")) {
                                                            %>
                                                            <a href="../GetterMoneyTransactionServelet?identityEncript=1&searchingType=2&accountNumber=<%=Security.encrypt(b.getCOurAccountNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("mTCR")) {
                                                            %>
                                                            <a href="../GetterOneDepositDetailServlet?tellerIndexKey=mTCR&nDepMFID=<%=Security.encrypt(b.getNDepMFID() + "")%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("mTBR")) {
                                                            %>
                                                            <a href="../GetterOneDepositDetailServlet?tellerIndexKey=mTBR&nDepMFID=<%=Security.encrypt(b.getNDepMFID() + "")%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("loanGarnter")) {
                                                            %>
                                                            <a href="../LoanDetailsServlet?checkGarenterType=deposit&accMifNumer=<%=Security.encrypt(String.valueOf(b.getNDepMFID()))%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("dailyCollection")) {
                                                            %>
                                                            <a href="daily_collection.jsp?index=<%=Security.encrypt(b.getNDepMFID() + "")%> &accNo=<%=Security.encrypt(b.getCOurAccountNo())%>&cFullName=<%=Security.encrypt(b.getCFullName())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("savingsCrBr")) {
                                                            %>
                                                            <a href="savings_CrDr.jsp?index=<%=Security.encrypt(b.getNDepMFID() + "")%> &accNo=<%=Security.encrypt(b.getCOurAccountNo())%>&cFullName=<%=Security.encrypt(b.getCFullName())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("getSavingDetail")) {
                                                            %>
                                                            <a href="saving_detail.jsp?index=<%=Security.encrypt(b.getNDepMFID() + "")%> &accNo=<%=Security.encrypt(b.getCOurAccountNo())%>&cFullName=<%=Security.encrypt(b.getCFullName())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%} else if (tellerIndexKey.equals("getSavingDetail1")) {%>
                                                            <a href="saving_detail.jsp?index1=<%=Security.encrypt(b.getNDepMFID() + "")%> &accNo1=<%=Security.encrypt(b.getCOurAccountNo())%>&cFullName1=<%=Security.encrypt(b.getCFullName())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%} else {%>
                                                            <a href="#" class="btn btn-default btn-xs">update</a>
                                                            <%
                                                                }
                                                            %> 
                                                        </td>
                                                    </tr>
                                                    <%
                                                                }
                                                            }
                                                            request.getSession().removeAttribute("view2");
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
