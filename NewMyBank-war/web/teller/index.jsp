<%-- 
    Document   : index
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : mmh
--%>

<%@page import="com.nbs.common.Alerts"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="com.nbs.model.VFindDatabnkLonLoanMaster"%>
<%@page import="com.nbs.model.BnkLonLoanMaster"%>
<%@page import="com.nbs.model.BnkDepDepositMaster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-pad{
                padding-right:0px;                
            }
            .bg-searchheight{
                height:128px;                
            }
            th,td { 
                white-space: nowrap;
            }
            div.dataTables_wrapper {
                width: auto;
                margin: 0 auto;
            }
        </style>

        <!--script-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.dataTables.min.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#loanTable').dataTable({
                    "scrollY": 145,
                    "scrollX": true,
                    "paging": false,
                    "ordering": false,
                    "info": false
                });
            });
            $(document).ready(function () {
                $('#depositTable').dataTable({
                    "scrollY": 145,
                    "scrollX": true,
                    "paging": false,
                    "ordering": false,
                    "info": false
                });
            });
        </script>
    </head>

    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <%            String cCIFNo = "පා.ලි. අංකය ";
            String cMemberShipNo = "සාමාජික අංකය";
            String cNICNo = " ජැ.හැ. අංකය";
            String cUseName = "භාවිත නම";
            String cFullName = "--------------------සම්පූර්ණ නම--------------------";
            String cPAddLine1 = "----------ලිපිනය----------";
            if (request.getSession().getAttribute("allBnkCustomerMaster") != null) {
                BnkCustomerMaster bcm = (BnkCustomerMaster) request.getSession().getAttribute("allBnkCustomerMaster");
                if (bcm.getCCIFNo() != null) {
                    cCIFNo = bcm.getCCIFNo();
                    cMemberShipNo = bcm.getCMemberShipNo();
                    cNICNo = bcm.getCNICNo();
                    cFullName = bcm.getCFullName();
                    cUseName = bcm.getCUseName();
                    cPAddLine1 = bcm.getCPAddLine1();
                    request.getSession().removeAttribute("allBnkCustomerMaster");
                }
            }

            String accountNumber = "";
            if (request.getParameter("accountNumber") != null) {
                String value = request.getParameter("accountNumber");
                accountNumber = Security.decrypt(value.replace(" ", "+"));

            }

            String accountValue = "1";
            if (request.getParameter("accountValue") != null) {
                accountValue = request.getParameter("accountValue");
            }

            String errorAlert = "";
            if (request.getSession().getAttribute("error") != null) {
                String error = (String) request.getSession().getAttribute("error");
                System.out.println(error);
                errorAlert = Alerts.warningAlert("Searching Error", error, "");
                request.getSession().removeAttribute("error");
            }

            List<VFindDatabnkLonLoanMaster> loanMasters = null;
            List<VFindDatabnkDepDepositMaster> depositMasters = null;
            if (request.getSession().getAttribute("allBnkDepDepositMaster") != null) {
                depositMasters = (List<VFindDatabnkDepDepositMaster>) request.getSession().getAttribute("allBnkDepDepositMaster");
                request.getSession().removeAttribute("allBnkDepDepositMaster");
            }

            if (request.getSession().getAttribute("allBnkLonLoanMaster") != null) {
                loanMasters = (List<VFindDatabnkLonLoanMaster>) request.getSession().getAttribute("allBnkLonLoanMaster");
                request.getSession().removeAttribute("allBnkLonLoanMaster");
            }
        %>

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
                        <small>Home</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">Home</a></li>
                        <li class="active"></li>
                    </ol>
                </section>

                <section id="content" class="content">
                    <div class="row bg-top">
                        <div class="col-md-9 bg-pad">
                            <%=errorAlert%>
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-8">  
                                            <div class="form-group">
                                                <form action="../GetterDepositLoanDetailsServlet" method="post" name="accountNo" onsubmit="validateGetAccountDetails(this);
                                                        return false;">
                                                    <label class="col-sm-3 control-label" id="accNumLabel" name="accNumLabel" ><h4><strong>ගිණුම් අංකය</strong></h4></label>
                                                    <div class="col-sm-9">
                                                        <div class="input-group">
                                                            <input type="hidden" name="accountValue" id="accountValue" value="<%=accountValue%>" />
                                                            <input type="text" class="form-control text-right convertSinhalaIskolaPotha" style="font-size: larger;font-weight: bolder" autocomplete="off" placeholder="ගිණුම් අංකය" maxlength="15" name="accountNumber" id="accountNumber" onkeydown="CursorKeyDown(event)" onkeyup="changeAccountNumber();"  value="<%=accountNumber%>">
                                                            <span class="input-group-btn">
                                                                <button class="btn btn-info btn-flat" type="submit"><i class="fa fa-search"></i></button>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="col-md-12 bg-top" style="margin-bottom: -20px">
                                                <div class="row">
                                                    <div class="form-group">
                                                        <label for="inputEmail3" class="col-md-12 control-label input-sm text-center" name="cFullName" id="cFullName"><h4 style="font-style: italic;color: blue;font-size: 12px"><%=cFullName%></h4></label>
                                                        <label for="inputEmail3" class="col-md-12 control-label input-sm text-center bg-top" name="cPAddLine1" id="cPAddLine1"><h4 style="font-style: italic;color: blue;font-size: 12px"><%=cPAddLine1%></h4></label>
                                                    </div>
                                                </div>
                                            </div>                  
                                        </div>
                                        <div class="col-md-4 bg-top">
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right"  >පා.ලි. අංකය : </label>
                                                <label class="col-md-6 input-sm" name="cCIFNo" id="cCIFNo" ><%=cCIFNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px" >සාමාජික අංකය : </label>
                                                <label class="col-md-6 input-sm" style="margin-top: -15px" name="cMemberShipNo" id="cMemberShipNo" ><%=cMemberShipNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px" > ජැ.හැ. අංකය : </label>
                                                <label class="col-md-6 input-sm" name="cNICNo" style="margin-top: -15px" id="cNICNo" ><%=cNICNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px" >භාවිත නම : </label>
                                                <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -15px" id="cUseName" ><%=cUseName%></label>
                                            </div>
                                        </div>  
                                    </div>
                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12 bg-top">
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right"  >ආරම්භක ශේෂය :</label>
                                                <label class="col-md-6 input-sm" name="cCIFNo" id="cCIFNo" ><%=cCIFNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px" > හර :</label>
                                                <label class="col-md-6 input-sm" style="margin-top: -18px" name="cMemberShipNo" id="cMemberShipNo" ><%=cMemberShipNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px" >බැර :</label>
                                                <label class="col-md-6 input-sm" name="cNICNo" style="margin-top: -18px" id="cNICNo" ><%=cNICNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px" >අවසාන ශේෂය :</label>
                                                <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -18px" id="cUseName" ><%=cUseName%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px;margin-bottom: -3px" > බැංකු ශේෂය :</label>
                                                <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -18px;margin-bottom: -3px" id="cUseName" ><%=cUseName%></label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row"  style="margin-bottom:-10px">
                        <div class="col-md-9  bg-top bg-pad">
                            <div class="box box-info bg-color" style="margin-bottom:-10px">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12" style="margin-top: 5px">
                                            <table id="depositTable" class="cell-border compact" cellspacing="0" width="100%">
                                                <thead>
                                                    <tr style="background-color:  #dbc59e;" style="font-size: 13px">
                                                        <!--<th width="0px">nLoanMPId</th>-->
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th class="text-center">හවුල්</th>
                                                        <th class="text-center">ගිණුම් අංකය</th>
                                                        <th class="text-center">වර්ගය</th>
                                                        <th class="text-center">ශේෂය</th>
                                                        <th class="text-center">ගතහැකි ශේෂය</th>
                                                        <th class="text-center">රැඳවු මුදල</th>
                                                        <th class="text-center">රැඳවු පොළිය</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        if (depositMasters != null) {
                                                            for (VFindDatabnkDepDepositMaster depositMaster : depositMasters) {
                                                    %>
                                                    <tr id="<%=depositMaster.getNDepMFID()%>" onclick="depTrAction('<%=depositMaster.getNDepMFID()%>')" style="font-size: 12px;background-color: rgba(159, 224, 216, 0.7);">
                                                        <td><a title="මුදල් තැන්පතු"  href="../GetterMoneyTransactionServelet?moneyDepType=1" class="btn btn-success btn-xs" onclick="passMoneySavingBtnAction(this, '<%=depositMaster.getNDepMFID()%>')">D</a></td>
                                                        <td><a title="ආපසු ගැනීම්" href="../GetterMoneyTransactionServelet?moneyDepType=2" class="btn btn-success btn-xs" onclick="passMoneySavingBtnAction(this, '<%=depositMaster.getNDepMFID()%>')">W</a></td>
                                                        <td><input title="පාස්පොත මුද්‍රනය" type="button" class="btn btn-warning btn-xs" value="P"/></td>
                                                        <td><input title="ලෙජර පිටුව" type="button" class="btn btn-primary btn-xs" value="L"/></td>
                                                        <td><a title="පෙන්වන්න" href="../GetSavingData?" class="btn btn-danger btn-xs" onclick="passMoneySavingBtnAction(this,<%=depositMaster.getNDepMFID()%>)">V</a></td>
                                                        <%
                                                            if (depositMaster.getBJoint()) {
                                                        %>
                                                        <td class="text-center"><i class="fa fa-users"></i></td>
                                                            <%
                                                            } else {
                                                            %>
                                                        <td class="text-center"><i class="fa fa-user"></i></td>
                                                            <%
                                                                }
                                                            %>

                                                        <td class="text-left convertSinhalaIskolaPotha" style="padding-right: 5px !important;" data="id"><%=depositMaster.getCOurAccountNo()%></td>
                                                        <td class="text-left convertSinhalaIskolaPotha"><%=depositMaster.getCDepName()%></td>
                                                        <td class="text-right convertSinhalaIskolaPotha" style="color: #0066ff;"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=depositMaster.getNCurBookBalance()%>" pattern="##,###.##"/></td>
                                                        <td class="text-right convertSinhalaIskolaPotha" style="color: #068025;"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=depositMaster.getNAvailableBalance()%>" pattern="##,###.##"/></td>
                                                        <td class="text-right convertSinhalaIskolaPotha" style="color: #ff0033;"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=depositMaster.getNHoldedAmount()%>" pattern="##,###.##"/></td>
                                                        <td class="text-right convertSinhalaIskolaPotha" style="color: #ff3300;"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="<%=depositMaster.getNHoldedAmountInt()%>" pattern="##,###.##"/></td>
                                                    </tr>
                                                    <%
                                                            }
                                                        }
                                                    %> 
                                                </tbody>
                                            </table>
                                        </div>    
                                        <div class="col-md-12" style="margin-top: 5px">
                                            <table id="loanTable" class="cell-border compact" cellspacing="0" width="100%">
                                                <thead>
                                                    <tr style="background-color: #dbc59e" style="font-size: 13px">
                                                        <!--<th width="0px">nLoanMPId</th>-->
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th class="text-center">ණය අංකය</th>
                                                        <th class="text-center">ණය නම</th>
                                                        <th class="text-center">කාරණය</th>
                                                        <th class="text-center">අනුමත දිනය</th>
                                                        <th class="text-center">අනුමත මුදල</th>
                                                        <th class="text-center">පොළී.අනු</th>
                                                        <th class="text-center">ශේෂය</th>
                                                        <th class="text-center">මුලු පොළිය</th>
                                                        <th class="text-center">දින</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        if (loanMasters != null) {
                                                            for (VFindDatabnkLonLoanMaster loanMaster : loanMasters) {
                                                    %>
                                                    <tr id="<%=loanMaster.getNLonMFID()%>" onclick="lonTrAction('<%=loanMaster.getNLonMFID()%>')" style="font-size: 12px;background-color: rgba(159, 224, 216, 0.7);">
                                                        <td><a href="../GetterLoanTransactionServlet?moneyLonType=1" class="btn btn-success btn-xs" onclick="passMoneyLoanBtnAction(this, '<%=loanMaster.getNLonMFID()%>')">R</a></td>
                                                        <td><input title="Payment" type="button" class="btn btn-primary btn-xs" value="P"/></td>
                                                        <td><input title="Loan" type="button" class="btn btn-primary btn-xs" value="L"/></td>
                                                        <td><a title="පෙන්වන්න" href="../GetSavingData?" class="btn btn-danger btn-xs" onclick="passMoneyLoanBtnAction(this,<%=loanMaster.getNLonMFID()%>)">V</a></td>
                                                        <td class="text-center convertSinhalaIskolaPotha" style="padding-right: 5px !important;"><%=loanMaster.getCLonAccountNo()%></td>
                                                        <td class="text-center convertSinhalaIskolaPotha" ><%=loanMaster.getCLonName()%></td>
                                                        <td class="text-center convertSinhalaIskolaPotha"><%=loanMaster.getCLonDescription()%></td> 
                                                        <td class="text-center convertSinhalaIskolaPotha"><%=loanMaster.getDApprovedDate()%></td>
                                                        <td class="text-right convertSinhalaIskolaPotha" style="color: #0066ff;"><fmt:formatNumber value="<%=loanMaster.getNApprovedAmount()%>" pattern="##,###.##"/></td>
                                                        <td class="text-center convertSinhalaIskolaPotha" style="color: #068025;"><%=loanMaster.getNEffectiveInt()%></td>
                                                        <td class="text-right convertSinhalaIskolaPotha" style="color: #85144b;"><fmt:formatNumber value="<%=loanMaster.getNLonBalanceAmount()%>" pattern="##,###.##"/></td>
                                                        <td class="text-right convertSinhalaIskolaPotha" style="color: #ff3300;"><fmt:formatNumber value="<%=loanMaster.getNToDateIntValueRound()%>" pattern="##,###.##"/></td> 
                                                        <td class="text-center convertSinhalaIskolaPotha"><%=loanMaster.getNToDateDueDays()%></td> 
                                                    </tr>
                                                    <%
                                                            }
                                                        }
                                                    %> 
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3  bg-top">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <form action="../BackupDBServlet">
                                        <button class="btn btn-primary btn-xs" type="submit">Backup</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </aside>
            <!--..............................-->            
        </div>
        <!--.......wrapper end...................-->

        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
        <script src="../js/bootbox.js" type="text/javascript"></script>
        <script src="../js/bootbox.min.js" type="text/javascript"></script>


        <script type="text/javascript">

                                                            setLabelValue();

                                                            //-------------------------------------------------------------------------------
                                                            function CursorKeyDown(e)
                                                            {
                                                                if (!e)
                                                                    e = window.event;
                                                                var accNumLabel = document.getElementById("accNumLabel");
                                                                var accountNumber = document.getElementById("accountNumber");
                                                                var accountValue = document.getElementById("accountValue");
                                                                var oldName = accNumLabel.innerHTML;
                                                                switch (e.keyCode)
                                                                {
                                                                    case 38:
                                                                        upClick(accountValue);
                                                                        break;
                                                                    case 40:
                                                                        downClick(accountValue);
                                                                        break;
                                                                }
                                                            }

                                                            function upClick(s) {
                                                                if (accountValue.value === "1") {
                                                                    accNumLabel.innerHTML = "<h4><strong>පා.ලි අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "2");
                                                                    accountNumber.setAttribute("placeholder", "පා.ලි අංකය");
                                                                    accountNumber.setAttribute("maxlength", "9");
                                                                } else if (accountValue.value === "2") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ජැ.හැ. අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "3");
                                                                    accountNumber.setAttribute("placeholder", "ජැ.හැ. අංකය");
                                                                    accountNumber.setAttribute("maxlength", "10");
                                                                } else if (accountValue.value === "3") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ණය අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "4");
                                                                    accountNumber.setAttribute("placeholder", "ණය අංකය");
                                                                    accountNumber.setAttribute("maxlength", "15");
                                                                } else if (accountValue.value === "4") {
                                                                    accNumLabel.innerHTML = "<h4><strong>සාමාජික අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "5");
                                                                    accountNumber.setAttribute("placeholder", "සාමාජික අංකය");
                                                                    accountNumber.setAttribute("maxlength", "10");
                                                                } else if(accountValue.value === "5") {
                                                                    accNumLabel.innerHTML = "<h4><strong>සාමාජික අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "5");
                                                                    accountNumber.setAttribute("placeholder", "සාමාජික අංකය");
                                                                    accountNumber.setAttribute("maxlength", "10");
                                                                }
                                                            }

                                                            function downClick(s) {
                                                                if (accountValue.value === "5") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ණය අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "4");
                                                                    accountNumber.setAttribute("placeholder", "ණය අංකය");
                                                                    accountNumber.setAttribute("maxlength", "15");
                                                                } else if (accountValue.value === "4") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ජැ.හැ. අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "3");
                                                                    accountNumber.setAttribute("placeholder", "ජැ.හැ. අංකය");
                                                                    accountNumber.setAttribute("maxlength", "10");
                                                                } else if (accountValue.value === "3") {
                                                                    accNumLabel.innerHTML = "<h4><strong>පා.ලි අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "2");
                                                                    accountNumber.setAttribute("placeholder", "පා.ලි අංකය");
                                                                    accountNumber.setAttribute("maxlength", "9");
                                                                } else if (accountValue.value === "2") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ගිණුම් අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "1");
                                                                    accountNumber.setAttribute("placeholder", "ගිණුම් අංකය");
                                                                    accountNumber.setAttribute("maxlength", "15");
                                                                } else {
                                                                    //accountNumber.style.borderColor = "red";
                                                                }
                                                            }

                                                            function setLabelValue() {
                                                                var accountValue = document.getElementById("accountValue");
                                                                var accountNumber = document.getElementById("accountNumber");
                                                                var accNumLabel = document.getElementById("accNumLabel");

                                                                if (accountValue.value === "1") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ගිණුම් අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "1");
                                                                    accountNumber.setAttribute("placeholder", "ගිණුම් අංකය");
                                                                } else if (accountValue.value === "2") {
                                                                    accNumLabel.innerHTML = "<h4><strong>පා.ලි අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "2");
                                                                    accountNumber.setAttribute("placeholder", "පා.ලි අංකය");
                                                                } else if (accountValue.value === "3") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ජැ.හැ. අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "3");
                                                                    accountNumber.setAttribute("placeholder", "ජැ.හැ. අංකය");
                                                                } else if (accountValue.value === "4") {
                                                                    accNumLabel.innerHTML = "<h4><strong>ණය අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "4");
                                                                    accountNumber.setAttribute("placeholder", "ණය අංකය");
                                                                } else {
                                                                    accNumLabel.innerHTML = "<h4><strong>සාමාජික අංකය</strong></h4>";
                                                                    accountValue.setAttribute("value", "5");
                                                                    accountNumber.setAttribute("placeholder", "සාමාජික අංකය");
                                                                }
                                                            }

                                                            function changeAccountNumber() {
                                                                var aN = document.getElementById("accountNumber").value;
                                                                var aV = document.getElementById("accountValue").value;

                                                                aN = setAccountNumber(aN);

                                                                if (aV === "1" || aV === "4") {
                                                                    if (!isNaN(aN)) {

                                                                        document.getElementById("accountNumber").style.color = "black";

                                                                        if (aN.length > 5) {
                                                                            aN = aN.substring(0, 2) + "-" + aN.substring(2, 5) + "-" + aN.substring(5);
                                                                        } else if (aN.length <= 5 && aN.length > 2) {
                                                                            aN = aN.substring(0, 2) + "-" + aN.substring(2);
                                                                        } else {
                                                                            aN = aN.substring(0);
                                                                        }
                                                                    } else {
                                                                        document.getElementById("accountNumber").style.color = "red";
                                                                    }
                                                                } else if (aV === "2") {
                                                                    if (!isNaN(aN)) {
                                                                        document.getElementById("accountNumber").style.color = "black";
                                                                        if (aN.length > 3) {
                                                                            aN = aN.substring(0, 3) + "-" + aN.substring(3);
                                                                        } else {
                                                                            aN = aN.substring(0);
                                                                        }
                                                                    } else {
                                                                        document.getElementById("accountNumber").style.color = "red";
                                                                    }
                                                                } else if (aV === "3") {
                                                                    if (aN.length === 10) {
                                                                        if (!isNaN(aN.substr(0, 8)) && (aN.charAt(9) === "v" || aN.charAt(9) === "V")) {
                                                                            document.getElementById("accountNumber").style.color = "black";
                                                                        } else {
                                                                            document.getElementById("accountNumber").style.color = "red";
                                                                        }
                                                                    } else {
                                                                        if (!isNaN(aN)) {
                                                                            document.getElementById("accountNumber").style.color = "black";
                                                                        } else {
                                                                            document.getElementById("accountNumber").style.color = "red";
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (!isNaN(aN)) {
                                                                        document.getElementById("accountNumber").style.color = "black";
                                                                    } else {
                                                                        document.getElementById("accountNumber").style.color = "red";
                                                                    }
                                                                }
                                                                document.getElementById("accountNumber").value = aN;
                                                            }

                                                            const numberWithCommas = (x) => {

                                                                return x.toLocaleString()
                                                            }
                                                            function setAccountNumber(aN) {
                                                                var aNSp = aN.split("-");

                                                                if (aNSp.length > 0) {
                                                                    aN = "";
                                                                    var i;
                                                                    for (i = 0; i < aNSp.length; i++) {
                                                                        aN += aNSp[i];
                                                                    }
                                                                }
                                                                return aN;
                                                            }

                                                            //----------------------------------------------------------------------------------

                                                            //------------------validateGetAccountDetails(accForm)------------------------------
                                                            function validateGetAccountDetails(accForm) {
                                                                var aV = document.getElementById("accountValue").value;
                                                                var aN = document.getElementById("accountNumber").value;

                                                                aN = setAccountNumber(aN);

                                                                if (aV === "3") {
                                                                    if (!isNaN(aN.substr(0, 8)) && (aN.charAt(9) === "v" || aN.charAt(9) === "V")) {
                                                                        document.forms["accForm"].submit();
                                                                    } else {
                                                                        bootbox.alert("<b>ජැ.හැ. අංකය වැරදි.</b>", function () {
                                                                        });
                                                                    }
                                                                } else {
                                                                    if (!isNaN(aN)) {
                                                                        document.forms["accForm"].submit();
                                                                    } else {
                                                                        if (aV === "1") {
                                                                            bootbox.alert("<b>ගිණුම් අංකය වැරදි.</b>", function () {
                                                                            });
                                                                        } else if (aV === "2") {
                                                                            bootbox.alert("<b>පා.ලි අංකය වැරදි.</b>", function () {
                                                                            });
                                                                        } else if (aV === "4") {
                                                                            bootbox.alert("<b>ණය අංකය වැරදි.</b>", function () {
                                                                            });
                                                                        } else {
                                                                            bootbox.alert("<b>සාමාජික අංකය වැරදි.</b>", function () {
                                                                            });
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            //----------------------------------------------------------------------------------

                                                            //------------------depTrAction(dta)------------------------------------------------
                                                            var beforeDepId = "";
                                                            function depTrAction(dta) {
                                                                if (beforeDepId !== "") {
                                                                    document.getElementById(beforeDepId).style.setProperty("background-color", "");
                                                                }
                                                                document.getElementById(dta).style.setProperty("background-color", "rgba(219, 197, 158, 0.68)");
                                                                beforeDepId = dta;
                                                                document.getElementById("nDepMFID").value = dta;
                                                            }
                                                            //------------------lonTrAction(lta)------------------------------------------------
                                                            var beforeLonId = "";
                                                            function lonTrAction(lta) {
                                                                if (beforeLonId !== "") {
                                                                    document.getElementById(beforeLonId).style.setProperty("background-color", "");
                                                                }
                                                                document.getElementById(lta).style.setProperty("background-color", "rgba(219, 197, 158, 0.68)");
                                                                beforeLonId = lta;
                                                                document.getElementById("nLonMFID").value = lta;
                                                            }

                                                            function passMoneySavingBtnAction(e, lta) {
                                                                e.href = e.href + "&nDepMFID=" + lta;
                                                            }

                                                            function passMoneyLoanBtnAction(e, lta) {
                                                                e.href = e.href + "&nLonMFID=" + lta;
                                                            }

                                                            //----------------------------------------------------------------------------------
        </script>

    </body>
</html>
