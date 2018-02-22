<%-- 
    Document   : view_journal
    Created on : Mar 6, 2015, 10:21:40 PM
    Author     : mmh
--%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="com.nbs.model.ActJournalDT"%>
<%@page import="java.util.AbstractList"%>
<%@page import="com.nbs.model.ActJournalHD"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | View Journal</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            <%
                if (request.getSession().getAttribute("journalHd") == null) {
            %>
            window.location = "../GetViewActJournalServlet";
            <%}%>
//            }
        </script>
    </head>

    <body class="skin-blue  pace-done fixed">

        <div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
                <div class="pace-progress-inner"></div>
            </div>
            <div class="pace-activity"></div>
        </div>

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
                        <small>View Journal</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">View Journal</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body"><div class="row">
                                        <form id="search" action="../" method="post">
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
                                                <%
                                                    List<ActJournalHD> ajhds = (AbstractList<ActJournalHD>) request.getSession().getAttribute("journalHd");
                                                    List<ActJournalDT> ajdts = (AbstractList<ActJournalDT>) request.getSession().getAttribute("journalDt");
                                                    for (ActJournalHD a1 : ajhds) {
                                                %>
                                                <tr style="background-color: #0072b1">
                                                    <td colspan="6" style="color: white;">
                                                        <div class="col-md-6">
                                                            <div class="col-md-2"><label style="font-size: 14px;"><%=a1.getCJournalHDID()%></label></div>
                                                            <div class="col-md-10"><label style="font-size: 14px;"><%=a1.getCJournalHDID()%></label></div>                                                    
                                                            <div class="col-md-2"><label style="font-size: 14px;"><%=a1.getNGLTrnID()%></label></div>
                                                            <div class="col-md-10"><label style="font-size: 14px;"><%=a1.getCDescription()%></label></div>                                                      
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="col-md-12"><label style="font-size: 14px;"><%=a1.getDTrnDate()%></label></div> <br>                                                           
                                                            <div class="col-md-6"><button type="button" class="btn btn-success btn-block btn-xs">Cancel</button></div>
                                                            <div class="col-md-6"><button type="button" class="btn btn-success btn-block btn-xs">Recall</button></div>
                                                        </div>
                                                    </td>                                                    
                                                </tr>  
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Description</th>
                                                    <th class="text-center">DR</th>
                                                    <th class="text-center">CR</th>

                                                </tr>
                                                <tbody>  
                                                    <%
                                                        for (ActJournalDT a2 : ajdts) {
                                                            if (a2.getNJournalHDID() == a1.getNJournalHDID()) {
                                                    %>
                                                    <tr>
                                                        <td style="font-size: 12px;"><%=a2.getNJournalDTID()%></td>
                                                        <td style="font-size: 12px;"><%=a2.getNJournalDTID()%></td>
                                                        <td style="font-size: 12px;"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=a2.getNDrAmount()%>" pattern="##,###.##"/></td>
                                                        <td style="font-size: 12px;"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=a2.getNCrAmount()%>" pattern="##,###.##"/></td>                                                        
                                                    </tr>
                                                    <%}
                                                        }
                                                    %>
                                                </tbody>
                                                <%}%>                                                    
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
        <%
            request.getSession().removeAttribute("journalHd");
            request.getSession().removeAttribute("journalDt");
        %>
        <!--.......wrapper end...................-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    </body>
</html>

