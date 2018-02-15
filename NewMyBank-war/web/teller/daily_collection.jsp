<%-- 
    Document   : daily_collection
    Created on : Mar 29, 2015, 6:34:46 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.BnkDepDailyCollectionTemp"%>
<%@page import="com.nbs.common.DailyCollection"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | Daily Collection</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>

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
                height:128px;                
            }

        </style>
    </head>
    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include  file="teller_header.jsp" %>
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
                        <small>Daily Collection</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">Daily Collection</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-searchheight bg-top">
                        <div class="col-md-12 bg-searchheight bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="box-body">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <div class="col-md-3">
                                                            </div> 
                                                            <div class="col-md-3">
                                                                <input type="radio" class="form-control input-sm" name="a"> Daily Collection
                                                            </div> 
                                                            <div class="col-md-3">
                                                                <input type="radio" class="form-control input-sm" name="a"> Interest Crediting
                                                            </div> 
                                                            <div class="col-md-3">
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <%
                                                        int nDepMFID = 0;
                                                        String accNo = "";
                                                        String cFullName = "";
                                                        if (request.getParameter("index") != null) {
                                                            nDepMFID = Integer.parseInt(Security.decrypt(request.getParameter("index").replace(" ", "+")));
                                                        }
                                                        if (request.getParameter("accNo") != null) {
                                                            accNo = Security.decrypt(request.getParameter("accNo").replace(" ", "+"));
                                                        }
                                                        if (request.getParameter("cFullName") != null) {
                                                            cFullName = Security.decrypt(request.getParameter("cFullName").replace(" ", "+"));
                                                        }
                                                    %>

                                                    <div class="col-md-12">
                                                        <table class="table table-bordered" style="margin-bottom: -9px; margin-top: 15px;">
                                                            <tbody>
                                                                <tr style="padding: 0px">
                                                                    <td style="padding: 0px;width: 150px" >

                                                                        <div class ="input-group">
                                                                            <input type="hidden" value="<%=nDepMFID%>" name="nDepMFID" id="nDepMFID">
                                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="accNumber" autocomplete="off" name="accNumber" value="<%=accNo%>">
                                                                            <span class="input-group-btn">
                                                                                <a class="btn btn-info btn-flat btn-sm" href="view_depositmaster.jsp?tellerIndexKey=dailyCollection"><i class="fa fa-search"></i></a>
                                                                            </span>
                                                                        </div>

                                                                    </td>
                                                                    <td style="padding: 0px">
                                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="accName" name="accName" value="<%=cFullName%>">
                                                                    </td>
                                                                    <td style="padding: 0px;width: 430px">
                                                                        <input type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="bera" name="bera">
                                                                    </td>
                                                                    <td style="padding: 0px;width: 150px">
                                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="rno" onkeypress="AddToTable()" name="rno">
                                                                    </td>
                                                                </tr>
                                                                <tr style="background-color: #00c0ef">
                                                                    <th class="text-center">ගිණුම් අංකය </th>
                                                                    <th class="text-center">ගිනුම්කරුගේ නම </th>
                                                                    <th class="text-center">බැර </th>
                                                                    <th class="text-center">රිසිට් අංකය</th>
                                                                </tr>                                                                
                                                            </tbody>
                                                        </table>
                                                        <div class="zTreeDemoBackground left">
                                                            <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">
                                                                <table id="garanterDetailsTable" class="table table-bordered" >
                                                                    <tbody>
                                                                        <tr>
                                                                            <th class="text-center">ගිණුම් අංකය </th>
                                                                            <th class="text-center">ගිනුම්කරුගේ නම </th>
                                                                            <th class="text-center">බැර </th>
                                                                            <th class="text-center">රිසිට් අංකය</th>
                                                                            <th class="text-center" width="10px"></th>
                                                                        </tr>
                                                                        <%
                                                                            if (request.getSession().getAttribute("daily_collection2") != null) {
                                                                                List<BnkDepDailyCollectionTemp> list = (List<BnkDepDailyCollectionTemp>) request.getSession().getAttribute("daily_collection2");
                                                                                if (list != null) {
                                                                                    for (BnkDepDailyCollectionTemp b : list) {
                                                                        %>
                                                                        <tr>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getNDepMFID().getCOurAccountNo()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getNDepMFID().getNCustomerID().getCFullName()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getNCr()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getCReceiptNo()%></td>
                                                                            <td ><button type="button" onclick="removeRow(<%=b.getNTempDailyID()%>)">Remove</button></td>
                                                                        </tr>
                                                                        <%
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (request.getSession().getAttribute("daily_collection") != null) {
                                                                                List<DailyCollection> list = (List<DailyCollection>) request.getSession().getAttribute("daily_collection");
                                                                                if (list != null) {
                                                                                    for (DailyCollection b : list) {
                                                                        %>
                                                                        <tr>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getAccNumber()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getAccName()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getnCr() + ".00"%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><%=b.getcReceiptNo()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><button type="button" onclick="removeRow(<%=b.getnDepMFID()%>)">Remove</button></td>
                                                                        </tr>
                                                                        <%
                                                                                    }
                                                                                }
                                                                            }
                                                                        %>
                                                                    </tbody>
                                                                </table>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-1">
                                                <a class="btn btn-danger btn-sm" onclick="deleteRow('garanterDetailsTable')">Delete</a>
                                            </div>
                                            <div class="col-md-3">
                                                <button type="button" class="collapsed btn btn-info btn-sm" onclick="AddToTable()">New</button>
                                                <button type="submit" class="collapsed btn btn-success btn-sm" onclick="window.location = '../DailiCollectionServlet?save=save">Save</button>
                                                <button type="reset" class="collapsed btn btn-warning btn-sm" >change</button>
                                            </div>
                                            <div class="col-md-5">
                                                <button type="button" class="collapsed btn btn-success btn-sm" onclick="window.location = '../DailiCollectionServlet?refresh=refresh'">Refresh</button>
                                                <button type="button" class="collapsed btn btn-success btn-sm"><i class="fa fa-print"> Ledger Wise Report</i></button>
                                                <button type="button" class="collapsed btn btn-success btn-sm"><i class="fa fa-print"></i> Confirm Report</button>
                                                <button type="button" class="collapsed btn btn-success btn-sm"><i class="fa fa-print"></i> Report</button>
                                            </div>
                                            <div class="col-md-3">
                                                <label>amount = 100000</label> 
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </aside>
    </body>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

    <script type="text/javascript">
                                                    function AddToTable() {
                                                        if (event.keyCode == 13) { //Enter keycode
                                                            var accNumber = document.getElementById('accNumber').value;
                                                            var accName = document.getElementById('accName').value;
                                                            var bera = document.getElementById('bera').value;
                                                            var rno = document.getElementById('rno').value;
                                                            var nDepMFID = document.getElementById('nDepMFID').value;
                                                            window.location = '../DailiCollectionServlet?accNumber=' + accNumber + '&accName=' + accName + '&bera=' + bera + '&rno=' + rno + '&nDepMFID=' + nDepMFID + '&remove=0';
                                                        }
                                                    }
                                                    function removeRow(nDepMFID) {
                                                        window.location = '../DailiCollectionServlet?remove=' + nDepMFID;
                                                    }
    </script>
</html>
