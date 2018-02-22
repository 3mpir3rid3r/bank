<%-- 
    Document   : view_customers
    Created on : Mar 2, 2015, 8:28:37 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.controller.get.GetViewCustomerServlet"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | View Customers</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>       
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            #mem_sea_table{
                padding: 0px;
                font-size: 15px;
                font-weight: bold;
                vertical-align: inherit;
                line-height: normal;
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

            String tellerIndexKey = "";
            if (request.getParameter("tellerIndexKey") != null) {
                tellerIndexKey = request.getParameter("tellerIndexKey");
            }
            String redirect = "";
            if (request.getParameter("pageId") != null || request.getSession().getAttribute("pageId") != null) {
                request.getSession().setAttribute("pageId", request.getParameter("pageId"));
                if ("1".equals(request.getSession().getAttribute("pageId").toString())) {
                    redirect = "creditor_debtor.jsp";
                } else if ("2".equals(request.getSession().getAttribute("pageId").toString())) {
                    redirect = "savings_crdr.jsp";
                }
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
                        <small>View Customers</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">View Customers</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body">
                                    <div class="row">
                                        <form id="search" action="../GetViewCustomerServlet?tellerIndexKey=<%=tellerIndexKey%>" method="post">
                                            <div class="col-md-12">  
                                                <div class="form-group">
                                                    <!--<div class="input-group">-->
                                                    <div class="input-group col-lg-12">
                                                        <span class="input-group-addon"><input checked type="checkbox" name="allcustomers"> All Customers</span>
                                                        <span class="input-group-addon"><%=branchName%></span>
                                                        <input type="text" class="form-control convertSinhalaIskolaPotha" name="searchText" value="<%=key%>">
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-default" type="submit"><span class="fa fa-search"></span>Search</button>
                                                        </span>
                                                    </div>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </form>
                                        <div class="col-md-12 bg-top" style="overflow: auto">
                                            <table class="table table-bordered table-hover" id="mem_sea_table">
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center" width="50px">ID</th>
                                                    <th class="text-center" width="50px">CIF No</th>
                                                    <th class="text-center" width="90px">Old CIF</th>
                                                    <th class="text-center" width="300px">Full Name</th>
                                                    <th class="text-center" width="300px">NIC</th>
                                                    <th class="text-center">Address</th>
                                                    <th class="text-center"></th>
                                                </tr>
                                                <tbody>
                                                    <%
                                                        try {
                                                            if (request.getSession().getAttribute("view1") != null) {
                                                                List<BnkCustomerMaster> bcms = (AbstractList<BnkCustomerMaster>) request.getSession().getAttribute("view1");
                                                                for (BnkCustomerMaster b : bcms) {
                                                    %>
                                                    <tr>
                                                        <td ><%=b.getNCustomerID()%></td>
                                                        <td style="font-size: 16px;"><%=b.getCCIFNo()%></td>
                                                        <td style="font-size: 16px;"><%=b.getCCIFNoOld()%></td>
                                                        <td style="font-size: 16px;"><%=b.getCFullName()%></td>
                                                        <td style="font-size: 16px;"><%=b.getCNICNo()%></td>
                                                        <td style="font-size: 16px;"><%=b.getCPAddLine1() + "," + b.getCPAddLine2() + "," + b.getCPAddLine3() + "," + b.getCPAddLine4()%></td>
                                                        <td class="text-center">
                                                            <%
                                                                if (tellerIndexKey.equals("2")) {
                                                            %>
                                                            <a href="../GetterDepositLoanDetailsServlet?identityEncript=1&accountValue=2&accountNumber=<%=Security.encrypt(b.getCCIFNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("3")) {
                                                            %>
                                                            <a href="../GetterDepositLoanDetailsServlet?identityEncript=1&accountValue=3&accountNumber=<%=Security.encrypt(b.getCNICNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("5")) {
                                                            %>
                                                            <a href="../GetterDepositLoanDetailsServlet?identityEncript=1&accountValue=5&accountNumber=<%=Security.encrypt(b.getCNICNo())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("sDInputCust")) {
                                                            %>
                                                            <a href="../SavingDetailsGetMasterDetilsServlet?tellerIndexKey=sDInputCust&masterID=<%=Security.encrypt(String.valueOf(b.getNCustomerID()))%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("custCIFID")) {
                                                            %>
                                                            <a href="../SavingDetailsGetMasterDetilsServlet?tellerIndexKey=custCIFID&masterID=<%=Security.encrypt(String.valueOf(b.getNCustomerID()))%>" class="btn btn-default btn-xs">Select</a>
                                                            <%

                                                            } else if (tellerIndexKey.equals("custCIFIDLoan")) {
                                                            %>
                                                            <a href="../LoanDetailsGetMasterDetilsServlet?tellerIndexKey=custCIFIDLoan&masterID=<%=Security.encrypt(String.valueOf(b.getNCustomerID()))%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("loanGarnter")) {
                                                            %>
                                                            <a href="../LoanDetailsServlet?checkGarenterType=customer&accMifNumer=<%=Security.encrypt(b.getCCIFNo())%>&loanGarnterName=<%=Security.encrypt(b.getCFullName())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("creditor")) {
                                                            %>
                                                            <a href="<%=redirect%>?cid=<%=Security.encrypt(b.getNCustomerID() + "")%>&cname=<%=Security.encrypt(b.getCFullName())%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else if (tellerIndexKey.equals("loanpatner")) {
                                                            %>
                                                            <a href="../LoanPatnerDetailsServlet?id=<%=b.getNCustomerID()%>" class="btn btn-default btn-xs">Select</a>
                                                            <%
                                                            } else {
                                                            %>
                                                            <a href="../LoadCustomerComboServlet?id=<%=b.getNCustomerID()%>" class="btn btn-default btn-xs">update</a>
                                                            <%
                                                                }
                                                            %>
                                                        </td>
                                                    </tr>
                                                    <%
                                                                }
                                                            }
                                                            request.getSession().removeAttribute("view1");
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            throw new ServletException(e);
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                            <!--</ul>-->
                                            <!--</div>-->
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
        <script>
            $(document).ready(function () {
                if (location.search.length == 17) {
                    $('#search').submit();
                }
            });
        </script>
    </body>
</html>
