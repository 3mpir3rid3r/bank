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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pawning | View Depositors</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

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
            td{
                padding-top: 0;
                padding-bottom: 0;
            }
        </style>
    </head>

    <body class="skin-blue  pace-done fixed">
        <%            String branchName = "";
            String key = "";
            if (request.getSession().getAttribute("branch") == null) {
                // response.sendRedirect("../BranchSession?page=teller/view_acc4.jsp?tellerIndexKey=0");
            } else {
                BnkRefBankBranch bankBranch = (BnkRefBankBranch) request.getSession().getAttribute("branch");
                branchName = bankBranch.getCBankName();
                key = request.getParameter("key");
            }
        %>


        <!--........header.....-->
        <%@include file="pawning_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="pawning_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Pawning -
                        <small>View Deposit Customers</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Pawning</a></li>
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
                                        <form action="../ViewDepositCustomerServlet" method="post">
                                            <div class="col-md-12">  
                                                <div class="form-group">
                                                    <!--<div class="input-group">-->
                                                    <div class="input-group col-lg-12">
                                                        <span class="input-group-addon"><input type="checkbox" id="allcustomers" name="allcustomers"> All Customers</span>
                                                        <span class="input-group-addon"><%=branchName%></span>
                                                        <input type="text" class="form-control" name="key" id="key" value="<%=key%>">
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
                                            <table class="table table-bordered table-hover">
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center" width="50px">ID</th>
                                                    <th class="text-center" width="50px">Our Acc No</th>
                                                    <th class="text-center" width="80px">Old Acc No</th>
                                                    <th class="text-center" width="100px">Cif No</th>
                                                    <th class="text-center" width="50px">Sys Code</th>
                                                    <th class="text-center" >Full Name</th>
                                                    <th class="text-center" width="100px">Book Balance</th>
                                                    <th class="text-center" width="100px" ></th>
                                                    <th class="text-center" width="100px" ></th>

                                                </tr>
                                                <tbody>
                                                    <%
                                                        List<VFindDatabnkDepDepositMaster> customersView = (List<VFindDatabnkDepDepositMaster>) session.getAttribute("pawningAllCustomers");

                                                        if (customersView != null) {

                                                            for (VFindDatabnkDepDepositMaster b : customersView) {

                                                    %>
                                                    <tr onclick="myfunction(this);" >
                                                        <td style="font-size: 12px;"><%=b.getNDepMFID()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCOurAccountNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCOldAccountNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCCIFNo()%></td>
                                                        <td style="font-size: 12px;"><%=b.getCSysCode()%></td>

                                                        <td style="font-size: 12px;"><%=b.getCFullName()%></td>
                                                        <td class="text-right" style="font-size: 12px;"><%=b.getNCurBookBalance()%></td>
                                                        <td>
                                                            <a onclick="downData();" href="../SelectCustomerDetailForPawningServlet?custId=<%=b.getNDepMFID()%>" class="btn btn-default btn-sm">Select</a>
                                                        </td>
                                                        <td>


                                                            <button id="noData" value="1" onclick="upData();" class="btn btn-default btn-sm">View Pawning</button>

                                                        </td>
                                                    </tr>
                                                    <%}
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

            function overlay() {
                el = document.getElementById("overlay");
                el.style.visibility = (el.style.visibility == "visible") ? "visible" : "visible";
            }
            function overlayHide() {
                removeSession();
                el = document.getElementById("overlay");
                el.style.visibility = (el.style.visibility == "visible") ? "hidden" : "visible";
            }
            function removeSession() {
                urlName = "../RemovePwningSessionServlet";
                $.post(urlName,
                        function (result) {

                        });
            }
            function myfunction(x) {
                var data = document.getElementById("noData").value;
                if (data === "2") {
                    overlay();
                    viewCustomerDetail(x);
                }

            }
            function upData() {
                document.getElementById("noData").setAttribute("value", "2");
            }
            function downData() {
                document.getElementById("noData").setAttribute("value", "1");
            }

            function viewCustomerDetail(x) {

                urlName = "../GetPwningDetailsServlet";
                $.post(urlName,
                        {storeRowNumber: x.rowIndex},
                        function (result) {

                            $("#tblDiv").html(result);
                        }
                );
            }

            function getMoreDetails(x) {
                urlName = "../GetPwningMoreDetailServlet";
                $.post(urlName,
                        {storeRowNumber: x.rowIndex},
                        function (result) {

                            $("#dataDiv").html(result);
                        });
            }

        </script>
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    </body>
</html>
