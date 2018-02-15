<%-- 
    Document   : view_acc4
    Created on : Mar 7, 2015, 7:29:42 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="java.util.AbstractList"%>
<%@page import="com.nbs.model.ActChartOfAcctL4"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
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
    </head>

    <body class="skin-blue  pace-done fixed">

        <div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
                <div class="pace-progress-inner"></div>
            </div>
            <div class="pace-activity"></div>
        </div>

        <!--........header.....-->

        <%            String branchName = "";
            if (request.getSession().getAttribute("branch") == null) {
                response.sendRedirect("../BranchSession?page=teller/view_acc4.jsp?tellerIndexKey=0");
            } else {
                BnkRefBankBranch bankBranch = (BnkRefBankBranch) request.getSession().getAttribute("branch");
                branchName = bankBranch.getCBankName();
            }
        %>
        <%@include file="teller_header.jsp" %>

        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include  file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Teller -
                        <small>View ACC4</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">View ACC4</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body">
                                    <%                                        String key = "";
                                        String tellerIndexNo = "";
                                        if (request.getParameter("tellerIndexNo") != null) {
                                            tellerIndexNo = request.getParameter("tellerIndexNo");
                                        }
                                        String redirect = "";
                                        if (request.getParameter("pageId") != null) {
                                            request.getSession().setAttribute("pageId", request.getParameter("pageId"));
                                            if ("1".equals(request.getParameter("pageId"))) {
                                                redirect = "creditor_debtor.jsp";
                                            } else if ("2".equals(request.getParameter("pageId"))) {
                                                redirect = "savings_crdr.jsp";
                                            }
                                        } else if (request.getSession().getAttribute("pageId") != null) {
                                            if ("1".equals(request.getSession().getAttribute("pageId").toString())) {
                                                redirect = "creditor_debtor.jsp";
                                            } else if ("2".equals(request.getSession().getAttribute("pageId").toString())) {
                                                redirect = "savings_crdr.jsp";
                                            }
                                        }
                                    %>
                                    <div class="row">
                                        <form action="../GetViewACT4Servlet" method="post">
                                            <div class="col-md-12">  
                                                <div class="form-group">
                                                    <!--<div class="input-group">-->
                                                    <div class="input-group col-lg-12">
                                                        <span class="input-group-addon"><input checked type="checkbox" name="allcustomers"> All Customers</span>
                                                        <span class="input-group-addon"><%=branchName%></span>
                                                        <input type="text" class="form-control convertSinhalaIskolaPotha" name="searchText" value="<%=key%>">
                                                        <input type="hidden" class="form-control" name="tellerIndexNo" value="<%=tellerIndexNo%>">
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-default" type="submit"><span class="fa fa-search"></span>Search</button>
                                                        </span>
                                                    </div>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </form>
                                        <div class="col-md-12 bg-top">
                                            <!--                                        <table class="table table-bordered">
                                                                                        <tbody>
                                                                                            <tr style="background-color: #5bc0de">
                                                                                                <th class="text-center" width="90px">පා.අංකය</th>
                                                                                                <th class="text-center" width="100px">පා.ලි අංකය</th>
                                                                                                <th class="text-center" width="300px">සම්පූර්ණ නම</th>
                                                                                                <th class="text-center" width="300px">සම්පූර්ණ නම_am</th>
                                                                                                <th class="text-center">ලිපිනය</th>
                                                                                            </tr>
                                                                                        </tbody>
                                                                                    </table>-->
                                            <!--<div class="zTreeDemoBackground left bg-top" style="margin-bottom: -10px">-->
                                            <!--<ul id="treeDemo" class="ztree" style="width: auto;height:495px;padding:0px">-->
                                            <table class="table table-bordered table-hover table-style">
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Main Acc No</th>
                                                    <th class="text-center">Sub Acc No</th>
                                                    <th class="text-center">Description</th>
                                                    <th class="text-center"></th>
                                                </tr>
                                                <tbody>
                                                    <%
                                                        try {
                                                            if (request.getSession().getAttribute("viewAct") != null) {
                                                                List<ActChartOfAcctL4> acctL4s = (AbstractList<ActChartOfAcctL4>) request.getSession().getAttribute("viewAct");
                                                                for (ActChartOfAcctL4 l : acctL4s) {
                                                    %>
                                                    <tr>
                                                        <td class="convertSinhalaIskolaPotha"><%=l.getNAcctLevelID4()%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%=l.getCCAAcctNoL4()%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%=l.getCCAAcctNoL4()%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%=l.getCDescriptionUniL4()%></td>                                                            
                                                        <td>
                                                            <%if (tellerIndexNo.equals("1")) {%>
                                                            <a href="<%=redirect%>?act4=<%=Security.encrypt(l.getNAcctLevelID4() + "")%>&des=<%=Security.encrypt(l.getCDescriptionUniL4())%>" class="btn btn-default btn-sm btn-block">Select</a>
                                                            <%} else if (tellerIndexNo.equals("2")) {%>
                                                            <a href="<%=redirect%>?act4Id=<%=Security.encrypt(l.getNAcctLevelID4() + "")%>&sub=<%=Security.encrypt(l.getCDescriptionUniL4())%>&acc=<%=Security.encrypt(l.getCCAAcctNoL4() + "-" + l.getCCAAcctNoL4())%>" class="btn btn-default btn-sm btn-block">Select</a>
                                                            <%} else {%>
                                                            <a href="" class="btn btn-default btn-xs btn-block">update</a>                                                                
                                                            <%}%>
                                                        </td>
                                                    </tr>
                                                    <%}
                                                            }
                                                            request.getSession().removeAttribute("viewAct");
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

    </body>
</html>
