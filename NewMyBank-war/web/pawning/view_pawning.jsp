<%-- 
    Document   : view_acc4
    Created on : Mar 7, 2015, 7:29:42 PM
    Author     : mmh
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkPwnPawnTypes"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.AbstractList"%>
<%@page import="com.nbs.model.BnkPwnPawnMaster"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | View Customers</title>

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
            }.bg-color2{
                background-color: #317eac;
            }.bg-top{
                margin-top: -10px;                
            }
            .bg-pad{
                padding-right:0px;                
            }
            td{
                padding-top: 0;
                padding-bottom: 0;
            }
        </style>
        <script type="text/javascript">

            function selectCmb1() {
                var id = document.getElementById("branchCmb").value;
                document.getElementById("cmb1").value = id;
            }
            function selectCmb2() {
                var id = document.getElementById("typeCmb").value;
                document.getElementById("cmb2").value = id;
            }
        </script>
    </head>

    <body class="skin-blue  pace-done fixed">

        <div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
                <div class="pace-progress-inner"></div>
            </div>
            <div class="pace-activity"></div>
        </div>

        <!--........header.....-->

        <%@include file="pawning_header.jsp" %>

        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include  file="pawning_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Pawning -
                        <small>View Pawning</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Pawning</a></li>
                        <li><a href="#">View Pawning</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body">

                                    <div class="row">
                                        <form action="../RePwnMasterServlet?key=viewPage" method="post">
                                            <div class=" col-sm-12">
                                                <!--                                                        <span class="input-group-addon"></span>-->
                                                <div class="form-group bg-top" style="margin-top: 5px">
                                                    <input value="0"type="hidden" id="cmb1" name="cmb1"/>
                                                    <select    style="margin-right: 5px" class=" col-sm-2  input-sm" name="branchCmb" id="branchCmb" onchange="selectCmb1()"   >
                                                        <% if (bankBranchs != null) {
                                                                for (ActSectionsSub branch : bankBranchs) {

                                                                    if (bankBranch.getNSubSectionID() == branch.getNSubSectionID()) {

                                                        %>

                                                        <option selected="" class="" value="<%=branch.getNSubSectionID()%>"><%= branch.getCSubSectionNameSin()%></option>
                                                        <%} else {%>
                                                        <option class="" value="<%=branch.getNSubSectionID()%>"><%= branch.getCSubSectionNameSin()%></option>
                                                        <% }
                                                                }
                                                            }%>
                                                    </select>
                                                    <input value="0"type="hidden" id="cmb2" name="cmb2"/>
                                                    <select  required  class=" col-sm-3  input-sm" name="typeCmb" id="typeCmb" onchange=" selectCmb2()"   >
                                                        <option  value="" style="display:none;"></option>
                                                        <% if (bankBranchs != null) {
                                                                for (BnkPwnPawnTypes bppt1 : bppt) {

                                                                    if (bppt1.getNPawnTypeID() == typeIds) {

                                                        %>

                                                        <option selected="" class="" value="<%=bppt1.getNPawnTypeID()%>"><%= bppt1.getCPawnType()%></option>
                                                        <% } else {%>

                                                        <option  class="" value="<%=bppt1.getNPawnTypeID()%>"><%= bppt1.getCPawnType()%></option>       

                                                        <%   }
                                                                }

                                                            }%>

                                                    </select>
                                                </div> 
                                                <div class=" form-group bg-top">
                                                    <label class="col-sm-1 input-sm text-right " style="margin-left: -5px">From:</label>
                                                    <div class="col-sm-2">
                                                        <input  autocomplete="off" required  class="form-control input-sm convertSinhalaAmali" type="date" name="fromDate" id="fromDate" value="<%=fromDate%>">
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-1 input-sm text-right" style="margin-left: ">To</label>
                                                    <div class="col-sm-2">
                                                        <input  autocomplete="off" required class="form-control input-sm convertSinhalaAmali" type="date" name="toDate" id="toDate" value="<%=toDate%>">
                                                    </div>
                                                </div>
                                                <input type="submit" class="btn btn-success btn-sm" value="Search"/>
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
                                            <table class="table table-bordered table-hover">
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Receipt No</th>
                                                    <th class="text-center">Ticket No</th>

                                                    <th class="text-center">NIC NO</th>
                                                    <th class="text-center">Full Name</th>
                                                    <th style="width: 50px"class="text-right">Balance</th>

                                                    <th class="text-center"></th>
                                                </tr>
                                                <tbody>
                                                    <%
                                                        if (request.getSession().getAttribute("BnkPwnPawnMasterList") != null) {
                                                            List<BnkPwnPawnMaster> bppms = (List<BnkPwnPawnMaster>) request.getSession().getAttribute("BnkPwnPawnMasterList");
                                                            for (BnkPwnPawnMaster b : bppms) {
                                                    %>
                                                    <tr>
                                                        <td style="font-size: 14px;"><%=b.getNPwnMasterID()%></td>
                                                        <td style="font-size: 14px;"><%=b.getCReceiptNo()%></td>
                                                        <td style="font-size: 14px;"><%=b.getCPwnTicketNo()%></td>
                                                        <td style="font-size: 14px;"><%=b.getCIDNo()%></td>
                                                        <td style="font-size: 14px;"><%=b.getCFullName()%></td> 
                                                        <td style="font-size: 14px;"><%=b.getNPwnBalanceAmount()%></td>
                                                        <td>
                                                            <a href="../RePwnMasterServlet?key=searchedKey&receiptNo=<%=b.getCReceiptNo()%>" class="btn btn-default btn-sm btn-block">Select</a>
                                                        </td>
                                                    </tr>
                                                    <%
                                                            }
                                                        }
                                                        request.getSession().removeAttribute("BnkPwnPawnMasterList");
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
