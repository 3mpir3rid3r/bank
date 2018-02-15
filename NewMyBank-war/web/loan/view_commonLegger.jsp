<%-- 
    Document   : view_depositmaster
    Created on : Mar 2, 2015, 8:28:37 PM
    Author     : Kalana
--%>

<%@page import="com.nbs.model.ActSectionsSub"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nbs.model.ActChartOfAcctL5"%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="com.nbs.model.BnkDepDepositMaster"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pawning | View Depositors</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
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


            .overlay {
                visibility: hidden;
                position: absolute;
                left: 0px;
                top: 0px;
                width:100%;
                height:100%;
                text-align:center;
                z-index: 1000;
            }

            .overlayDiv {

                margin: 100px auto;
                background-color: #fff;
                border:1px solid #000;
                padding:15px;
                text-align:center;
            }

            #ledger_table{
                padding: 0px;
                font-size: 15px;
                font-weight: bold;
                vertical-align: inherit;
                line-height: normal;
            }
            #ledger_table td{
                padding-top: 0px;
                padding-bottom: 0px;
            }
        </style>

        <script type="text/javascript">

            function searchFunction(comId, rid) {
                var input, filter, table, tr, td, i;
                input = document.getElementById(comId);
                filter = input.value.toUpperCase();
                table = document.getElementById("ledger_table");
                tr = table.getElementsByTagName("tr");
//                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[rid];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        </script>
    </head>

    <body class="skin-blue  pace-done fixed">
        <%            String branchName = "";

            if (request.getSession().getAttribute("branch") == null) {
                // response.sendRedirect("../BranchSession?page=teller/view_acc4.jsp?tellerIndexKey=0");
            } else {
                ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
                branchName = bankBranch.getCSubSectionNameUni();

            }
        %>


        <!--........header.....-->
        <%@include file="loan_header.jsp" %>
        <!--..............................-->


        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar3.png" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%=userName%></p>
                            <input type="hidden" value="<%=userName%>" name="userName"/>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>

                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="../GetterBnkLonDetailsServlet" >
                                <i class="fa fa-users"></i> 
                                <span>ණය වර්ගයන්</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-money"></i>
                                <span>පොළී ගනණය</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>පොළී ගනණය(කාර්තු)</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>පොළී ගනණය(ස්ථිර)</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-table"></i><span>ඉතුරුම් ගිනුම් හර</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-table"></i><span>ඉතුරුම් ගිනුම් බැර</span>
                            </a>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!--................................-->

            <!--...........right-side.........-->
            <aside id="content" class="right-side">
                <section class="content-header" >
                    <h1>
                        Accounts -
                        <small>Chart of account</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=""><i class="fa fa-home"></i> Chart of account</a></li>

                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body">
                                    <div class="row">
                                        <form action="../FindLeggerDetailsServlet" method="post">
                                            <div class="col-md-12">  
                                                <div class="form-group">
                                                    <!--<div class="input-group">-->
                                                    <div class="input-group col-lg-12">
                                                        <span class="input-group-addon"><input type="checkbox" id="allcustomers" name="allcustomers" checked> All </span>
                                                        <span class="input-group-addon"><%=branchName%></span>
                                                        <input type="text" class="form-control" name="key" id="key" >
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-default" type="submit"><span class="fa fa-search"></span>Search</button>
                                                        </span>
                                                    </div>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </form>
                                        <!--================================================================================-->
                                        <!--view Old Pawning Details Dialog-->
                                        <div class="overlay " id="overlay">
                                            <div class="overlayDiv">
                                                <div >
                                                    <div id="tblDiv" >

                                                    </div>
                                                    <br>

                                                    <!--view data--> 
                                                    <!--basic details-->
                                                    <div id="dataDiv" class="box box-info " >

                                                    </div>
                                                    <!--end basic details-->
                                                    <!--more Details-->

                                                    <!--end More details-->
                                                    <div style="width: auto">
                                                        <div style="" align="right">
                                                            <button onclick="overlayHide()" class="">Back</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>   
                                        <!--End Of The Dialog box-->

                                        <div class="col-md-12 bg-top">
                                            <table class="table table-bordered table-hover" id="ledger_table">
                                                <thead>
                                                <th class="text-center" width="50px"><input type="text" style="width: 100%;height: 100%;border-radius: 0px;" id="ledid1" onkeyup="searchFunction('ledid1', 0);"></th>
                                                <th class="text-center" width="50px"><input type="text" style="width: 100%;height: 100%;border-radius: 0px;" id="ledid2" onkeyup="searchFunction('ledid2', 1);"></th>
                                                <th class="text-center" width="80px"><input type="text" style="width: 100%;height: 100%;border-radius: 0px;" id="ledid3" onkeyup="searchFunction('ledid3', 2);"></th>
                                                <th class="text-center" width="115px"><input type="text" style="width: 100%;height: 100%;border-radius: 0px;" id="ledid4" onkeyup="searchFunction('ledid4', 3);"></th>
                                                <th class="text-center" width="115px"><input type="text" style="width: 100%;height: 100%;border-radius: 0px;" id="ledid5" onkeyup="searchFunction('ledid5', 4);"></th>
                                                <th class="text-center" width="5px" ></th>
                                                </thead>    
                                                <thead style="background-color: #5bc0de">
                                                <th class="text-center" width="50px"> ID</th>
                                                <th class="text-center" width="50px">Act4 ID</th>
                                                <th class="text-center" width="80px">Acc No</th>
                                                <th class="text-center" width="115px">Description</th>
                                                <th class="text-center" width="115px">Description(Eng)</th>
                                                <th class="text-center" width="5px" ></th>

                                                </thead>    
                                                <tbody id="tbody_ledger">
                                                    <%

                                                        List<ActChartOfAcctL5> acctL5s = new ArrayList<ActChartOfAcctL5>();
                                                        String dep = "off";

                                                        String keyNo = "";
                                                        if (request.getParameter("key2No") != null) {
                                                            keyNo = request.getParameter("key2No");
                                                        }

                                                        if (keyNo.equals("1")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data1");
                                                        } else if (keyNo.equals("2")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data2");
                                                        } else if (keyNo.equals("3")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data3");
                                                        } else if (keyNo.equals("4")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data4");
                                                        } else if (keyNo.equals("5")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data5");
                                                        } else if (keyNo.equals("6")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data6");
                                                        } else if (keyNo.equals("7")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data7");
                                                        } else if (keyNo.equals("8")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data8");
                                                        } else if (keyNo.equals("9")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data9");
                                                        } else if (keyNo.equals("10")) {
                                                            dep = "on";
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data10");
                                                        } else if (keyNo.equals("11")) {
                                                            dep = "on";
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data11");
                                                        }

                                                        if (acctL5s != null) {

                                                            for (ActChartOfAcctL5 acctL5 : acctL5s) {

                                                    %>
                                                    <tr  >
                                                        <td style="font-size: 12px;"><%=acctL5.getNAcctLevelID5()%></td>
                                                        <td style="font-size: 12px;"><%=acctL5.getNAcctLevelID4()%></td>
                                                        <td style="font-size: 12px;"><%=acctL5.getCCAAcctNoL5()%></td>
                                                        <td style="font-size: 12px;font-family: AMALEE;font-size: 15px;"><%=acctL5.getCDescriptionSinL5()%></td>
                                                        <td style="font-size: 12px;"><%=acctL5.getCDescriptionUniL5()%></td>

                                                        <td>
                                                            <a  href="../GetSelectedAct4Detail?actid=<%=acctL5.getNAcctLevelID5()%>&dep=<%= dep%>" class="btn btn-default btn-xs">Select</a>
                                                        </td>
                                                    </tr>
                                                    <% }

                                                        }%>
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

        <script type="text/javascript">

        </script>
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    </body>
</html>
