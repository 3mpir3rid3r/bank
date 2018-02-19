<%-- 
    Document   : loan_payment
    Created on : Feb 4, 2015, 10:54:38 AM
    Author     : mmh
--%>

<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.VFindDatabnkLonLoanMaster"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }
            .bg-top10{
                margin-top: -10px;
            }
            .bg-top{
                margin-top: -10px;
            }.bg-bottom{
                margin-bottom: -5px;
            }
            .bg-searchheight{
                height:132px;                
            }.bg-mainheight{
                height:400px;                
            }
            .bg-pad{
                padding-right:0px;                
            }.bg-padl{
                padding-left:0px;                
            }
            .bg-panelcolor{
                background:#367fa9;
            }
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head>

    <body class="skin-blue fixed">

        <%            String successMsg = "";
            if (request.getParameter("successMsg") != null) {
                successMsg = request.getParameter("successMsg");
            }

            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            formatter.setDecimalFormatSymbols(symbols);

            String cFullName = "--------------------සම්පූර්ණ නම--------------------";
            String cPAddLine1 = "----------ලිපිනය----------";

            String nApprovedAmount = "";
            String nIssuedAmount = "";

            String nAmount = "";

            String cLonAccountNo = "";

            String nToDatePanaltyIntSubjectAmount = "";
            String nToDatePanaltyIntValue = "";

            if (request.getSession().getAttribute("lonLoanMaster") != null) {
                VFindDatabnkLonLoanMaster lonLoanMaster = (VFindDatabnkLonLoanMaster) request.getSession().getAttribute("lonLoanMaster");

                cFullName = lonLoanMaster.getCFullName();
                cPAddLine1 = lonLoanMaster.getCPAddLine1();
                BigDecimal nApprovedAmountBig = lonLoanMaster.getNApprovedAmount();
                nApprovedAmount = formatter.format(nApprovedAmountBig);
                BigDecimal nIssuedAmountBig = lonLoanMaster.getNIssuedAmount();
                nIssuedAmount = formatter.format(nIssuedAmountBig);

                BigDecimal nAmountBig = BigDecimal.valueOf(nApprovedAmountBig.doubleValue() - nIssuedAmountBig.doubleValue());
                nAmount = formatter.format(nAmountBig);

                cLonAccountNo = lonLoanMaster.getCLonAccountNo();

                if (cLonAccountNo.length() > 5) {
                    cLonAccountNo = cLonAccountNo.substring(0, 2) + "-" + cLonAccountNo.substring(2, 5) + "-" + cLonAccountNo.substring(5);
                } else if (cLonAccountNo.length() <= 5 && cLonAccountNo.length() > 2) {
                    cLonAccountNo = cLonAccountNo.substring(0, 2) + "-" + cLonAccountNo.substring(2);
                } else {
                    cLonAccountNo = cLonAccountNo.substring(0);
                }
            }

            String nIssueToDepMFID = "";
            String isNulllonLoanMaster = "false";

            if (request.getSession().getAttribute("depDepositMaster") != null) {
                VFindDatabnkDepDepositMaster depDepositMaster = (VFindDatabnkDepDepositMaster) request.getSession().getAttribute("depDepositMaster");
                nIssueToDepMFID = depDepositMaster.getCOurAccountNo();
                isNulllonLoanMaster = "true";

                if (nIssueToDepMFID.length() > 5) {
                    nIssueToDepMFID = nIssueToDepMFID.substring(0, 2) + "-" + nIssueToDepMFID.substring(2, 5) + "-" + nIssueToDepMFID.substring(5);
                } else if (nIssueToDepMFID.length() <= 5 && nIssueToDepMFID.length() > 2) {
                    nIssueToDepMFID = nIssueToDepMFID.substring(0, 2) + "-" + nIssueToDepMFID.substring(2);
                } else {
                    nIssueToDepMFID = nIssueToDepMFID.substring(0);
                }
            }

            System.out.println("nIssueToDepMFID = " + nIssueToDepMFID);

            String toDate = request.getSession().getAttribute("logDate").toString();

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
            <aside id="content" class="right-side">
                <section class="content-header" >
                    <h1>
                        ණය ගෙවීම/මුදලින්
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">ණය</a></li>
                        <li class="active">ණය ගෙවීම</li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top10">
                        <div class="col-md-12 ">
                            <div class="box box-info bg-color" >
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-5">  
                                            <div class="form-group">
                                                <form action="../GetterLoanTransactionServlet?searchingType=2" method="post" name="accForm" onsubmit="validateGetAccountNo(this);
                                                        return false;">
                                                    <label class="col-sm-4 control-label" id="accNumLabel"><h4><strong>ණය අංකය</strong></h4></label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group">
                                                            <input type="text" class="form-control text-right convertSinhalaIskolaPotha" style="font-size: larger;font-weight: bold" autocomplete="off" placeholder="ණය අංකය" maxlength="15" onkeyup="changeAccountNumber()" name="accountNumber" id="accountNumber" value="<%=cLonAccountNo%>">
                                                            <span class="input-group-btn">
                                                                <button class="btn btn-info btn-flat" type="submit"><i class="fa fa-search"></i></button>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="col-md-7 bg-top10" style="margin-bottom: -20px">
                                            <div class="row">
                                                <div class="form-group">
                                                    <label for="inputEmail3" class="col-md-12 control-label input-sm text-center" name="cFullName" id="cFullName"><h4 style="font-style: italic;color: blue;font-size: 14px;"><%=cFullName%></h4></label>
                                                    <label for="inputEmail3" class="col-md-12 control-label input-sm text-center bg-top10" name="cPAddLine1" id="cPAddLine1"><h4 style="font-style: italic;color: blue;font-size: 14px"><%=cPAddLine1%></h4></label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>
                    </div>
                    <form  class="form-horizontal" action="../NewBnkLonLoanIsuuePaymentServlet" method="post" name="lonForm" onsubmit="validateNewLoan(this);
                            return false;">                            
                        <div class="row bg-top10">
                            <div class="col-md-6 bg-top bg-pad">
                                <!--./box-->
                                <div class="panel box box-info bg-color" style="height: 456px">
                                    <!--./body-->
                                    <div class="box-body bg-mainheight" style="padding: 0px">
                                        <div class="col-md-12 bg-pad" style="padding: 0px">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" style="padding-bottom: 0px;padding-top: 5px">
                                                    <label style="color: #555555">ණය තොරතුරු</label>
                                                </div>
                                                <div class="panel-body bg-color">
                                                    <div class="form-group bg-top10">
                                                        <label class="control-label col-sm-4 input-sm ">අනුමත ණය මුදල :</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size:17px;" placeholder="0.00" name="nApprovedAmount" id="nApprovedAmount" value="<%=nApprovedAmount%>" data="validate" data-type="decimal">
                                                        </div>
                                                    </div>
                                                    <div class="form-group bg-top10">
                                                        <label class="control-label col-sm-4 input-sm ">නිකුත් කල මුදල :</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size:17px;" placeholder="0.00" name="nIssuedAmount" id="nIssuedAmount" value="<%=nIssuedAmount%>" data="validate" data-type="decimal">
                                                        </div>
                                                    </div>
                                                    <div class="form-group bg-top10">
                                                        <label class="control-label col-sm-4 input-sm ">නිකුත් කිරිමට ඇති ශේෂය :</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size:17px;" placeholder="0.00" name="dDepositDate" id="dDepositDate" value="<%=nAmount%>" data="validate" data-type="decimal">
                                                        </div>
                                                    </div>
                                                    <div class="form-group bg-top10" style="margin-bottom: -5px">
                                                        <label class="control-label col-sm-4 input-sm ">අයවියයුතු පොළිය :</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size:17px;" placeholder="0.00" name="dDepositDate" id="dDepositDate" value="" data="validate" data-type="decimal">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="panel panel-default" style="margin-top: -25px">
                                                <div class="panel-body bg-color">
                                                    <div class="form-group" style="margin-top: -10px;">
                                                        <div class="col-md-12" style="margin-bottom: -10px">
                                                            <div class="radio">
                                                                <label class="" style="font-weight: bold;color: red" onclick="divShowed('m')">
                                                                    <input class="input-sm" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="" style="position: absolute; opacity: 0;">
                                                                    මුදලින්
                                                                </label>
                                                                <label class="" id="depAccountLabel" style="font-weight: bold;color: red" onclick="divShowed('d')" hidden="">
                                                                    <input class="input-sm" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" style="position: absolute; opacity: 0;">
                                                                    තැන්පත් ගිණුමකින්
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>  
                                                </div>
                                            </div>
                                            <div class="panel panel-default" style="margin-top: -25px" >
                                                <div class="panel-heading" style="padding-bottom: 0px;padding-top: 5px;">
                                                    <label style="color: #555555">හුවමාරුව</label>
                                                </div>
                                                <div class="panel-body bg-color" style="height: 190px">
                                                    <div class="form-group bg-top10">
                                                        <label class="control-label col-sm-4 input-sm ">ගණුදෙනු දිනය :</label>
                                                        <label class="control-label col-sm-2 input-sm" style="color: blue"><%=toDate%></label>
                                                    </div>
                                                    <div class="form-group bg-top10">
                                                        <label class="control-label col-sm-4 input-sm ">නිකුත් කල මුදල :</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size:17px;" placeholder="0.00" name="dDepositDate" id="dDepositDate" value="" data="validate" data-type="decimal">
                                                        </div>
                                                    </div>
                                                    <div class="form-group bg-top10" hidden id="accountLabelDiv">
                                                        <label class="control-label col-sm-12 input-sm " style="color: blue">තැම්පත් ගිණුමට දැමිය යුතු ණය මුදල</label>
                                                    </div>
                                                    <div class="form-group bg-top10" hidden id="accountDiv">
                                                        <label class="control-label col-sm-4 input-sm ">ගිණුම් අංකය :</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size:17px;" placeholder="0.00" name="nIssueToDepMFID" id="nIssueToDepMFID" value="<%=nIssueToDepMFID%>">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <button type="submit" class="btn btn-sm btn-info " onclick="" style="font-weight: bold;">නිකුත් කරන්න</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>                           
                                </div>
                                <!--./box-->
                            </div>
                            <!--./right-box-->
                            <div class="col-md-3 bg-top10" >
                                <div class="panel box box-info bg-color" style="height: 456px">
                                    <!--./body-->
                                    <div class="box-body">
                                        <!--./row-->
                                        <div class="row">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <input type="hidden" name="isNulllonLoanMaster" id="isNulllonLoanMaster" value="<%=isNulllonLoanMaster%>"/>
                </section>
            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

        <script type="text/javascript" >

                                                                    $(document).ready(function () {
                                                                        //document.getElementById("moneyLonType1").className = "active";
                                                                        var isNulllonLoanMaster = document.getElementById("isNulllonLoanMaster").value;

                                                                        if (isNulllonLoanMaster === "true") {
                                                                            document.getElementById("depAccountLabel").removeAttribute("hidden");
                                                                            $("input[type='checkbox']:not(.simple), input[type='radio']:not(.simple)").iCheck({
                                                                                checkboxClass: 'icheckbox_minimal',
                                                                                radioClass: 'iradio_minimal'
                                                                            });
                                                                        }
                                                                    });
                                                                    //-------ON CLICK------------------
                                                                    function divShowed(sd) {
                                                                        if (sd === 'd') {
                                                                            document.getElementById("accountLabelDiv").removeAttribute("hidden");
                                                                            document.getElementById("accountDiv").removeAttribute("hidden");
                                                                        } else {
                                                                            document.getElementById("accountLabelDiv").setAttribute("hidden", "");
                                                                            document.getElementById("accountDiv").setAttribute("hidden", "");
                                                                        }
                                                                    }
                                                                    //---------------------------------
        </script>
        <script src="../js/validate.js" type="text/javascript"></script>
    </body>
</html>
