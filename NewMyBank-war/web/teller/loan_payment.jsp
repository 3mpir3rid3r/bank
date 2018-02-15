<%-- 
    Document   : loan_issue_money
    Created on : Feb 4, 2015, 10:56:05 AM
    Author     : mmh
--%>

<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.VFindDatabnkLonLoanMaster"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ණය අයකරගැනීම/මුදලින්</title>

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

            .bg-pad{
                padding-right:0px;                
            }.bg-padl{
                padding-left:0px;                
            }
            .bg-panelcolor{
                background:#367fa9;
            }

            .f-size13{
                font-size: 13px;
            }

            .box-label{
                font-size: 13px;
                margin-top: -4px;
            }

            .box-field{
                font-size: 13px;
                height: 25px;
            }
            #content *{
                font-size-adjust: 0.51;
            }
        </style>
    </head>
    <body class="skin-blue fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <%            String successMsg = "";
            if (request.getParameter("successMsg") != null) {
                successMsg = request.getParameter("successMsg");
            }

            String cFullName = "--------------------සම්පූර්ණ නම--------------------";
            String cPAddLine1 = "----------ලිපිනය----------";

            String cLonName = "";
            String cLonC = "";
            String cLonDescription = "";
            String cCIFNo = "";
            String cMemberShipNo = "";
            String cNICNo = "";
            String cPTelNo1 = "";
            String cUseName = "";

            String cLonAccountNo = "";

            String nLonMFID = "";

            String nIssuedAmount = "";
            String nBalanceToIssue = "";

            String nEffectiveInt = "";
            String nInstallmentAmountAdj = "";

            String nTotRecvCapital = "";
            String nTotRecvInstallment = "";
            String nShouldRecvCapital = "";
            String nShouldRecvInstallment = "";
            String nTotRecvInterest = "";

            String nShouldRecvInterest = "";
            String nLonBalanceAmount = "";
            String nLonBalanceInstallment = "";
            String dLastCapitalPayDate = "";
            String dLastIntPayDate = "";

            String nToDateDueCapital = "";
            String nToDateDueInstallment = "";
            String nToDateIntValueRound = "";
            String nToDateTotIntersest = "";

            String nToDatePanaltyIntSubjectAmount = "";
            String nToDatePanaltyIntValue = "";

            String nTotRecvStationary = "";
            String nTotRecvPostage = "";
            String nTotRecvCaurtFees = "";
            String nTotRecvArbitrationFees = "";

            if (request.getSession().getAttribute("lonLoanMaster") != null) {
                VFindDatabnkLonLoanMaster lonLoanMaster = (VFindDatabnkLonLoanMaster) request.getSession().getAttribute("lonLoanMaster");

                cFullName = lonLoanMaster.getCFullName();
                cPAddLine1 = lonLoanMaster.getCPAddLine1();

                cLonName = lonLoanMaster.getCLonName();
                cLonDescription = lonLoanMaster.getCLonDescription();
                cLonDescription = lonLoanMaster.getCLonDescription();
                cCIFNo = lonLoanMaster.getCCIFNo();
                cMemberShipNo = lonLoanMaster.getCMemberShipNo();
                cNICNo = lonLoanMaster.getCNICNo();
                cPTelNo1 = lonLoanMaster.getCPTelNo1();
                cUseName = lonLoanMaster.getCUseName();

                nIssuedAmount = String.valueOf(lonLoanMaster.getNIssuedAmount());
                nBalanceToIssue = String.valueOf(lonLoanMaster.getNBalanceToIssue());

                nEffectiveInt = String.valueOf(lonLoanMaster.getNEffectiveInt());
                nInstallmentAmountAdj = String.valueOf(lonLoanMaster.getNInstallmentAmountAdj());

                nTotRecvCapital = String.valueOf(lonLoanMaster.getNTotRecvCapital());
                nTotRecvInstallment = String.valueOf(lonLoanMaster.getNTotRecvInstallment());
                nShouldRecvCapital = String.valueOf(lonLoanMaster.getNShouldRecvCapital());
                nShouldRecvInstallment = String.valueOf(lonLoanMaster.getNShouldRecvInstallment());
                nTotRecvInterest = String.valueOf(lonLoanMaster.getNTotRecvInterest());

                nShouldRecvInterest = String.valueOf(lonLoanMaster.getNShouldRecvInterest());
                nLonBalanceAmount = String.valueOf(lonLoanMaster.getNLonBalanceAmount());
                nLonBalanceInstallment = String.valueOf(lonLoanMaster.getNLonBalanceInstallment());

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                dLastCapitalPayDate = dateFormat.format(lonLoanMaster.getDLastCapitalPayDate());
                dLastIntPayDate = dateFormat.format(lonLoanMaster.getDLastIntPayDate());

                nToDateDueCapital = String.valueOf(lonLoanMaster.getNToDateDueCapital());
                nToDateDueInstallment = String.valueOf(lonLoanMaster.getNToDateDueInstallment());
                nToDateIntValueRound = String.valueOf(lonLoanMaster.getNToDateIntValueRound());
                nToDateTotIntersest = String.valueOf(lonLoanMaster.getNToDateTotIntersest());

                nToDatePanaltyIntSubjectAmount = String.valueOf(lonLoanMaster.getNToDatePanaltyIntSubjectAmount());
                nToDatePanaltyIntValue = String.valueOf(lonLoanMaster.getNToDatePanaltyIntValue());

                cLonAccountNo = lonLoanMaster.getCLonAccountNo();

                if (cLonAccountNo.length() > 5) {
                    cLonAccountNo = cLonAccountNo.substring(0, 2) + "-" + cLonAccountNo.substring(2, 5) + "-" + cLonAccountNo.substring(5);
                } else if (cLonAccountNo.length() <= 5 && cLonAccountNo.length() > 2) {
                    cLonAccountNo = cLonAccountNo.substring(0, 2) + "-" + cLonAccountNo.substring(2);
                } else {
                    cLonAccountNo = cLonAccountNo.substring(0);
                }

                nLonMFID = String.valueOf(lonLoanMaster.getNLonMFID());

                nTotRecvStationary = String.valueOf(lonLoanMaster.getNTotRecvStationary());
                nTotRecvPostage = String.valueOf(lonLoanMaster.getNTotRecvPostage());
                nTotRecvCaurtFees = String.valueOf(lonLoanMaster.getNTotRecvCaurtFees());
                nTotRecvArbitrationFees = String.valueOf(lonLoanMaster.getNTotRecvArbitrationFees());

            }
            String cDepName = "";
            String nCurBookBalance = "";
            String cFullNameDep = "";

            String isNulllonLoanMaster = "false";

            if (request.getSession().getAttribute("depDepositMaster") != null) {
                VFindDatabnkDepDepositMaster depDepositMaster = (VFindDatabnkDepDepositMaster) request.getSession().getAttribute("depDepositMaster");
                cDepName = depDepositMaster.getCDepName();
                nCurBookBalance = String.valueOf(depDepositMaster.getNCurBookBalance());
                cFullNameDep = depDepositMaster.getCInitials() + " " + depDepositMaster.getCLastName();
                isNulllonLoanMaster = "true";
            }

            System.out.println("cDepName = " + cDepName);

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
                        ණය අයකරගැනීම/මුදලින්
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">ණය</a></li>
                        <li class="active">ණය අයකරගැනීම</li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top10">
                        <div class="col-md-12 ">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-5">  
                                            <div class="form-group">
                                                <form action="../GetterLoanTransactionServlet?searchingType=1" method="post" name="accForm" onsubmit="validateGetAccountNo(this);
                                                        return false;">
                                                    <label class="col-sm-4 control-label" id="accNumLabel" name="accNumLabel"><h4><strong>ණය අංකය</strong></h4></label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group">
                                                            <input type="text" class="form-control text-right" style="font-size: larger;font-weight: bold" autocomplete="off" placeholder="ණය අංකය" maxlength="15" onkeyup="changeAccountNumber()" name="accountNumber" id="accountNumber" value="<%=cLonAccountNo%>">
                                                            <span class="input-group-btn">
                                                                <button class="btn btn-info btn-flat" type="submit"><i class="fa fa-search"></i></button>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="col-md-12 bg-top10" style="margin-bottom: -20px">
                                                <div class="row">
                                                    <div class="form-group">
                                                        <label for="inputEmail3" class="col-md-12 control-label input-sm text-center" name="cFullName" id="cFullName"><h4 style="font-style: italic;color: blue;font-size: 12px;"><%=cFullName%></h4></label>
                                                        <label for="inputEmail3" class="col-md-12 control-label input-sm text-center bg-top10" name="cPAddLine1" id="cPAddLine1"><h4 style="font-style: italic;color: blue;font-size: 12px"><%=cPAddLine1%></h4></label>
                                                    </div>
                                                </div>
                                            </div> 
                                        </div>
                                        <div class="col-md-4 bg-top10">
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right">ණය ගිණුමේ නම : </label>
                                                <label class="col-md-6 input-sm" name="cCIFNo" id="cCIFNo"><%=cLonName%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px">ණය වර්ගය : </label>
                                                <label class="col-md-6 input-sm" style="margin-top: -15px" name="cMemberShipNo" id="cMemberShipNo"><%=cLonDescription%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px">කාරණය : </label>
                                                <label class="col-md-6 input-sm" name="cNICNo" style="margin-top: -15px" id="cNICNo"><%=cLonDescription%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px">පා.ලි. අංකය : </label>
                                                <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -15px" id="cUseName"><%=cCIFNo%></label>
                                            </div>
                                        </div>
                                        <div class="col-md-3 bg-top10">
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right">සාමාජික අංකය : </label>
                                                <label class="col-md-6 input-sm" name="cCIFNo" id="cCIFNo"><%=cMemberShipNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px">ජැ.හැ. අංකය : </label>
                                                <label class="col-md-6 input-sm" style="margin-top: -15px" name="cMemberShipNo" id="cMemberShipNo"><%=cNICNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px">දුරකතන අංකය : </label>
                                                <label class="col-md-6 input-sm" name="cNICNo" style="margin-top: -15px" id="cNICNo"><%=cPTelNo1%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -15px">භාවිත නම : </label>
                                                <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -15px" id="cUseName"><%=cUseName%></label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>
                    </div>
                    <form  class="form-horizontal" action="../NewBnkLonLoanTransactionsServlet" method="post" name="lonForm" onsubmit="validateNewLoan(this);return false;">
                        <div class="row bg-top10">
                            <div class="col-md-12 bg-top10">
                                <div class="panel box box-info bg-color">
                                    <!--./body-->
                                    <div class="box-body" style="height: 50px">
                                        <div class="form-group">
                                            <label class="col-sm-2 text-right input-sm">ලද දිනය :</label>
                                            <div class="col-md-2 bg-pad">
                                                <input style="height: 30px;" type="date" class="form-control input-sm text-right box-field convertSinhalaIskolaPotha" placeholder="0.00" name="dDepositDate" id="dDepositDate" value="<%=toDate%>">
                                            </div>
                                            <label class="col-sm-2 text-right input-sm">බිල් අංකය :</label>
                                            <div class="col-md-2">
                                                <input style="height: 30px;" type="text" class="form-control input-sm text-right box-field convertSinhalaIskolaPotha" placeholder="0.00" name="cReceiptNo" id="cReceiptNo"> 
                                            </div>
                                            <label class="col-sm-2 text-right input-sm">භා. බිල් අංකය :</label>
                                            <div class="col-md-2">
                                                <input style="height: 30px;" type="text" class="form-control input-sm text-right box-field convertSinhalaIskolaPotha" placeholder="0.00" name="cReceiptNo2" id="cReceiptNo2">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 bg-pad bg-top10">
                                <!--./box-->
                                <div class="panel box box-info bg-color">
                                    <!--./body-->
                                    <div class="box-body" style="margin-bottom:-25px">
                                        <label class="col-sm-12 input-sm" style="color: #FF9233;margin-bottom:-15px;margin-top:-15px"><%=toDate%> දිනට</label>
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 input-sm f-size13">ලිපි ගාස්තු :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"><%=nTotRecvStationary%></label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field convertSinhalaIskolaPotha" placeholder="0.00"  name="nPaidStationary" id="nPaidStationary">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">තැපැල් ගාස්තු :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13" ><%=nTotRecvPostage%></label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field convertSinhalaIskolaPotha" placeholder="0.00" name="nPaidPostage" id="nPaidPostage">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">නඩු ගාස්තු :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"><%=nTotRecvCaurtFees%></label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00" name="nPaidCaurtFees" id="nPaidCaurtFees">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">තීරක ගාස්තු :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"><%=nTotRecvArbitrationFees%></label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00" name="nPaidArbitrationFees" id="nPaidArbitrationFees">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">දිනට පොළිය :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"><%=nToDateTotIntersest%></label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00" name="nPaidIntValue" id="nPaidIntValue">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">දිනට දඩ පොළිය :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"><%=nToDatePanaltyIntValue%></label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00" name="nPaidPenaltyValue" id="nPaidPenaltyValue">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">ඉ.ගෙ හිඟ පොළිය :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"  style="padding-top: 3px;">0.00</label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">ඉ.ගෙ දඩ පොළිය :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"  style="padding-top: 3px;">0.00</label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <label class="control-label col-sm-4 input-sm f-size13">දිනට හිඟ වාරික :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"><%=nToDateDueInstallment%></label>
                                            <label class="control-label col-sm-2 input-sm f-size13"><%=nToDateDueCapital%></label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00" name="nPaidCapitalVal" id="nPaidCapitalVal">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-15px;">
                                            <div class="col-sm-12">
                                                <div class="col-sm-12" style="background-color: #044687;height: 2px;margin-bottom: 4px;margin-top: 4px;"></div>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top:-12px;">
                                            <label class="control-label col-sm-4 input-sm f-size13" style="font-weight:bold;padding-top: 3px;">ගෙවිය යුතු අවම මුදල :</label>
                                            <label class="control-label col-sm-2 input-sm f-size13"></label>
                                            <label class="control-label col-sm-2 input-sm f-size13" style="padding-top: 3px;">0.00</label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right box-field" placeholder="0.00">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--./box-->
                            </div>
                            <!--./right-box-->
                            <div class="col-md-6 bg-top10">
                                <div class="panel box box-info bg-color">
                                    <!--./body-->
                                    <div class="box-body">
                                        <div class="row">

                                            <label class="col-sm-4 input-sm text-right f-size13 bg-top10" >නිකුත් කළ මුදල :</label>
                                            <label class="col-sm-3 input-sm text-left f-size13 bg-top10"  ><%=nIssuedAmount%></label>
                                            <label class="col-sm-3 input-sm text-right f-size13 bg-top10" >ඉතිරිය :</label>
                                            <label class="col-sm-2 input-sm text-left f-size13 bg-top10"  ><%=nBalanceToIssue%></label>

                                            <label class="col-sm-4 input-sm text-right box-label" >පොළී අනුපාතය :</label>
                                            <label class="col-sm-3 input-sm text-left box-label" ><%=nEffectiveInt%></label>
                                            <label class="col-sm-3 input-sm text-right box-label">වාරිකය මුදල :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nInstallmentAmountAdj%></label>

                                            <label class="col-sm-4 input-sm text-right box-label" >අයවී ඇති මුදල :</label>
                                            <label class="col-sm-3 input-sm text-left box-label" ><%=nTotRecvCapital%></label>
                                            <label class="col-sm-3 input-sm text-right box-label" >වාරික :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nTotRecvInstallment%></label>

                                            <label class="col-sm-4 input-sm text-right box-label" >අයවිය යුතු මුදල :</label>
                                            <label class="col-sm-3 input-sm text-left box-label" ><%=nShouldRecvCapital%></label>
                                            <label class="col-sm-3 input-sm text-right box-label" >වාරික :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nShouldRecvInstallment%></label>

                                            <label class="col-sm-4 input-sm text-right box-label" >අයවී ඇති පොළිය :</label>
                                            <label class="col-sm-3 input-sm text-left box-label" ><%=nTotRecvInterest%></label>
                                            <label class="col-sm-3 input-sm text-right box-label">අයවිය යුතු පොළිය :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nShouldRecvInterest%></label>

                                            <label class="col-sm-4 input-sm text-right box-label">ගෙවීමට ඇති මුදල :</label>
                                            <label class="col-sm-3 input-sm text-left box-label" ><%=nLonBalanceAmount%></label>
                                            <label class="col-sm-3 input-sm text-right box-label">වාරික :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nLonBalanceInstallment%></label>

                                            <label class="col-sm-4 input-sm text-right box-label">අවසාන වාරික දිනය :</label>
                                            <label class="col-sm-3 input-sm text-left box-label" ><%=dLastCapitalPayDate%></label>
                                            <label class="col-sm-3 input-sm text-right box-label">පොළී දිනය :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=dLastIntPayDate%></label>

                                            <label class="col-sm-4 input-sm text-right box-label">හිඟ වාරික මුදල :</label>
                                            <label class="col-sm-3 input-sm text-left box-label" ><%=nToDateDueCapital%></label>
                                            <label class="col-sm-3 input-sm text-right box-label">වාරික :</label>
                                            <label class="col-sm-2 input-sm text-left box-label"><%=nToDateDueInstallment%></label>

                                            <label class="col-sm-4 input-sm text-right box-label">පොළිය :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nToDateIntValueRound%></label>
                                            <label class="col-sm-1 input-sm text-right box-label" ></label>
                                            <label class="col-sm-3 input-sm text-right box-label" >හිඟ පොළිය :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nToDateTotIntersest%></label>

                                            <label class="col-sm-4 input-sm text-right box-label">දඩ පොළි මුදල :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nToDatePanaltyIntSubjectAmount%></label>
                                            <label class="col-sm-1 input-sm text-right box-label" ></label>
                                            <label class="col-sm-3 input-sm text-right box-label" >දඩ පොළී :</label>
                                            <label class="col-sm-2 input-sm text-left box-label" ><%=nToDatePanaltyIntValue%></label>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row bg-top10">
                            <div class="col-md-12 bg-top10" style="margin-bottom: -20px">
                                <!--./box-->
                                <div class="box box-info bg-color" style="margin-bottom: -20px">
                                    <!--./body-->
                                    <div class="box-body" style="height: 50px">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="radio">
                                                    <label class="" style="font-weight: bold;color: red" onclick="labelShowed('d')">
                                                        <input class="input-sm" type="radio" name="optionsRadios" id="money" value="option1" checked="" style="position: absolute; opacity: 0;" >
                                                        මුදලින්
                                                    </label>
                                                    <label class="" id="depAccountLabel" style="font-weight: bold;color: red" onclick="labelShowed('s')" hidden="">
                                                        <input class="input-sm" type="radio" name="optionsRadios" id="depAccount" value="option1" style="position: absolute; opacity: 0;">
                                                        තැන්පත් ගිණුමකින්
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="col-sm-4 input-sm text-right" style="font-size: 14px">මුදල :</label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control input-sm text-right" placeholder="0.00" name="nPaymentVal" id="nPaymentVal" style="font-size: 14px">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="col-sm-12 text-right input-sm " style ="font-size: 12px;margin-top: -10px" hidden id="cFullNameDep"><%=cFullNameDep + "( "%><font style="color: green"><%=cDepName%></font><%=" )"%></label>
                                                    <label class="col-sm-12 text-right input-sm "  style ="font-size: 12px;margin-top: -20px;margin-bottom: -20px" hidden id="cDepName"><%=nCurBookBalance%></label>
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <div class="col-md-12">
                                                        <div class="pull-right">
                                                            <button type="submit" class="btn btn-sm btn-primary " >ගණුදෙණුව සිදුකරන්න</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="nLonMFID" id="nDepMFID" value="<%=nLonMFID%>"/>

                        <input type="hidden" name="isNulllonLoanMaster" id="isNulllonLoanMaster" value="<%=isNulllonLoanMaster%>"/>
                    </form>
                </section>
            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
        <script src="../js/bootbox.js" type="text/javascript"></script>
        <script src="../js/bootbox.min.js" type="text/javascript"></script>

        <script type="text/javascript">

                                                        $(document).ready(function () {
                                                            document.getElementById("moneyLonType1").className = "active";
                                                            var isNulllonLoanMaster = document.getElementById("isNulllonLoanMaster").value;

                                                            if (isNulllonLoanMaster === "true") {
                                                                //document.getElementById("depAccount").removeAttribute("hidden");
                                                                document.getElementById("depAccountLabel").removeAttribute("hidden");
                                                                $("input[type='checkbox']:not(.simple), input[type='radio']:not(.simple)").iCheck({
                                                                    checkboxClass: 'icheckbox_minimal',
                                                                    radioClass: 'iradio_minimal'
                                                                });
                                                            }
                                                        });

                                                        //-------ON CLICK------------------
                                                        function labelShowed(sd) {
                                                            if (sd === 's') {
                                                                document.getElementById("cFullNameDep").removeAttribute("hidden");
                                                                document.getElementById("cDepName").removeAttribute("hidden");
                                                                document.getElementById("nCurBookBalance").removeAttribute("hidden");
                                                            } else {
                                                                document.getElementById("cFullNameDep").setAttribute("hidden", "");
                                                                document.getElementById("cDepName").setAttribute("hidden", "");
                                                                document.getElementById("nCurBookBalance").setAttribute("hidden", "");
                                                            }
                                                        }
                                                        //---------------------------------

                                                        //-------ONKEY UP----------------------
                                                        function changeAccountNumber() {
                                                            var aN = document.getElementById("accountNumber").value;
                                                            aN = setAccountNumber(aN);
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
                                                            document.getElementById("accountNumber").value = aN;
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
                                                        //-------ONKEY UP----------------------

                                                        //---------SUBMIT FUNCTION--------------------
                                                        function validateGetAccountNo(accForm) {
                                                            var aN = document.getElementById("accountNumber").value;
                                                            aN = setAccountNumber(aN);
                                                            if (!isNaN(aN)) {
                                                                document.forms["accForm"].submit();
                                                            } else {
                                                                bootbox.alert("<b>ණය අංකය වැරදි.</b>", function () {
                                                                });
                                                            }
                                                        }

                                                        function validateNewLoan(lonForm) {
                                                            var cReceiptNo = document.getElementById("cReceiptNo");
                                                            var nPaymentVal = document.getElementById("nPaymentVal");

                                                            if (cReceiptNo.value.length === 0) {
                                                                bootbox.alert("<b>බිල් අංක 1 පුරවන්න</b>", function () {
                                                                });
                                                            } else if (nPaymentVal.value.length === 0) {
                                                                bootbox.alert("<b>මුදල පුරවන්න</b>", function () {
                                                                });
                                                            } else {
                                                                bootbox.confirm("<b>(" + nPaymentVal.value + ") ඔබ මේ ගණුදෙනුව කිරිමට සුදානම්ද ?</b>", function (result) {
                                                                    if (result) {
                                                                        document.forms["lonForm"].submit();
                                                                    }
                                                                });
                                                            }
                                                        }
        </script>

    </body>
</html>
