<%-- 
    Document   : saving_detail
    Created on : Jan 29, 2015, 2:23:59 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkDepDepositMaster"%>
<%@page import="com.nbs.common.Alerts"%>
<%@page import="com.nbs.model.common.BnkDepDepositCategoryTypes"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>තැම්පත් තොරතුරු</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
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
            }
            .bg-top{
                margin-top: -10px;
            }.bg-bottom{
                margin-bottom: -5px;
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

        <script type="text/javascript" >
            <%                if (request.getSession().getAttribute("bddcts") == null) {
            %>
            window.location = "../SavingDetailsServlet?moneyDepType=5";
            <%
                    request.getSession().removeAttribute("bddcts");
                }
            %>
        </script>

    </head>

    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">
        <%            String alerts = "";
            if (request.getParameter("error") != null) {
                String error = request.getParameter("error");
                alerts = Alerts.dangerAlert("Database Error", error);
            }

            String nDepMFID = "0";
            String nDepTypeIDHid = "0";
            String nBankBranchID = "";
            String cOurAccountNo = "";
            String cSerialNo = "";
            String nLedgerBookNo = "";
            String nEffectiveInt = "";
            String bJoint = "";
            String dStartDate = "";
            String nAcctStatusID = "";

            String nFDIntialiDeposit = "";
            String nFDPeriod = "";
            String nFDPeriodTypeID = "0";
            String dFDMaturityDate = "";
            String nFDMaturityValue = "";
            String cFDAgreementNo = "";
            String nFDClosingMethodID = "";
            String nFDIntCalMethodID = "0";
            String nFDIntCalMethodValue = "";
            String nFDIntCRMethodID = "0";
            String nFDIntCRMethodValue = "";
            String bIntCreditingDiffAcc = "";
            String nIntCRnDepMFID = "";

            String bAmtHolded = "";
            String nHoldedAmount = "";
            String dHoldFromDate = "";
            String dHoldToDate = "";
            String nHoldedAmountInt = "";
            String bIntHolded = "";
            String dIntHoldFromDate = "";
            String dIntHoldToDate = "";
            String nInstDRnDepMFID = "";
            String nInstDRValue = "";
            String nTDDepositPeriod = "";
            String nTDAgreedAmount = "";
            String nTDPaymentDay = "";
            String cAddBy = "";
            boolean view = false;
            if (request.getSession().getAttribute("insertDepositMaster") != null || request.getSession().getAttribute("view") != null) {

                BnkDepDepositMaster bddm;
                bddm = (request.getSession().getAttribute("insertDepositMaster") != null) ? (BnkDepDepositMaster) request.getSession().getAttribute("insertDepositMaster") : (BnkDepDepositMaster) request.getSession().getAttribute("view");
                view = request.getSession().getAttribute("view") != null;

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                nDepMFID = String.valueOf(bddm.getNDepMFID());
                nDepTypeIDHid = String.valueOf(bddm.getNDepTypeID());
                //nCustomerID = String.valueOf(bddm.getNCustomerID());
                nBankBranchID = String.valueOf(bddm.getNBankBranchID());
                cOurAccountNo = bddm.getCOurAccountNo();
                cSerialNo = bddm.getCSerialNo();
                nLedgerBookNo = String.valueOf(bddm.getNLedgerBookNo());
                if (bddm.getNEffectiveInt() != null) {
                    nEffectiveInt = String.valueOf(bddm.getNEffectiveInt());
                }

                bJoint = String.valueOf(bddm.getBJoint());
                if (bddm.getDStartDate() != null) {
                    dStartDate = dateFormat.format(bddm.getDStartDate());
                }

                nAcctStatusID = String.valueOf(bddm.getNAcctStatusID());

                nFDIntialiDeposit = String.valueOf(bddm.getNFDIntialiDeposit());
                if (bddm.getNFDIntialiDeposit() == BigDecimal.ZERO) {
                    nFDIntialiDeposit = "";
                }
                nFDPeriod = String.valueOf(bddm.getNFDPeriod());
                nFDPeriodTypeID = String.valueOf(bddm.getNFDPeriodTypeID());
                if (bddm.getDFDMaturityDate() != null) {
                    dFDMaturityDate = dateFormat.format(bddm.getDFDMaturityDate());
                }
                nFDMaturityValue = String.valueOf(bddm.getNFDMaturityValue());
                if (bddm.getNFDMaturityValue() == BigDecimal.ZERO) {
                    nFDMaturityValue = "";
                }
                cFDAgreementNo = bddm.getCFDAgreementNo();
                nFDClosingMethodID = String.valueOf(bddm.getNFDClosingMethodID());
                nFDIntCalMethodID = String.valueOf(bddm.getNFDIntCalMethodID());
                nFDIntCalMethodValue = String.valueOf(bddm.getNFDIntCalMethodValue());
                nFDIntCRMethodID = String.valueOf(bddm.getNFDIntCRMethodID());
                nFDIntCRMethodValue = String.valueOf(bddm.getNFDIntCRMethodValue());
                bIntCreditingDiffAcc = String.valueOf(bddm.getBIntCreditingDiffAcc());
                nIntCRnDepMFID = String.valueOf(bddm.getNIntCRnDepMFID());

                bAmtHolded = String.valueOf(bddm.getBAmtHolded());
                nHoldedAmount = String.valueOf(bddm.getNHoldedAmount());
                if (bddm.getDHoldFromDate() != null) {
                    dHoldFromDate = dateFormat.format(bddm.getDHoldFromDate());
                }
                if (bddm.getDHoldToDate() != null) {
                    dHoldToDate = dateFormat.format(bddm.getDHoldToDate());
                }

                nHoldedAmountInt = String.valueOf(bddm.getNHoldedAmountInt());
                bIntHolded = String.valueOf(bddm.getBIntHolded());
                if (bddm.getDIntHoldFromDate() != null) {
                    dIntHoldFromDate = dateFormat.format(bddm.getDIntHoldFromDate());
                }
                if (bddm.getDIntHoldToDate() != null) {
                    dIntHoldToDate = dateFormat.format(bddm.getDIntHoldToDate());
                }
                nInstDRnDepMFID = String.valueOf(bddm.getNInstDRnDepMFID());
                nInstDRValue = String.valueOf(bddm.getNInstDRValue());
                nTDDepositPeriod = String.valueOf(bddm.getNTDDepositPeriod());
                nTDAgreedAmount = String.valueOf(bddm.getNTDAgreedAmount());
                nTDPaymentDay = String.valueOf(bddm.getNTDPaymentDay());
                cAddBy = bddm.getCAddBy();

                //request.getSession().removeAttribute("insertDepositMaster");
            }
            String saveType = "1";
            if (request.getSession().getAttribute("saveType") != null) {
                saveType = (String) request.getSession().getAttribute("saveType");
                //   request.getSession().removeAttribute("saveType");
            }
        %>

        <!--........header.....-->
        <%@include file="teller_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include  file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside id="content" class="right-side">
                <section class="content-header">
                    <h1>
                        තැම්පත් තොරතුරු -
                        <small>තැම්පත් ගණුදෙණු</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">තැම්පත් ගණුදෙණු</a></li>
                        <li class="active">තැම්පත් තොරතුරු -</li>
                    </ol>
                </section>
                <%=alerts%>
                <section class="content">
                    <div id="row" class="row bg-top">
                        <div class="col-md-12">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-5">  
                                            <div class="form-group">
                                                <%
                                                    String cCIFNo = "";
                                                    String cMemberShipNo = "සාමාජික අංකය";
                                                    String cNICNo = " ජැ.හැ. අංකය";
                                                    String cUseName = "භාවිත නම";
                                                    String cFullName = "--------------------සම්පූර්ණ නම--------------------";
                                                    String cPAddLine1 = "----------ලිපිනය----------";

                                                    String nCustomerID = "";

                                                    if (request.getSession().getAttribute("cutomerDetailsForCIF") != null) {
                                                        System.out.println("ASDF");
                                                        BnkCustomerMaster bnkCustomerMaster = (BnkCustomerMaster) request.getSession().getAttribute("cutomerDetailsForCIF");
                                                        cCIFNo = bnkCustomerMaster.getCCIFNo();

                                                        if (cCIFNo.length() > 3) {
                                                            cCIFNo = cCIFNo.substring(0, 3) + "-" + cCIFNo.substring(3);

                                                        } else {
                                                            cCIFNo = cCIFNo.substring(0);

                                                        }

                                                        cMemberShipNo = bnkCustomerMaster.getCMemberShipNo();
                                                        cNICNo = bnkCustomerMaster.getCNICNo();
                                                        cFullName = bnkCustomerMaster.getCFullName();
                                                        cUseName = bnkCustomerMaster.getCUseName();
                                                        cPAddLine1 = bnkCustomerMaster.getCPAddLine1();

                                                        nCustomerID = String.valueOf(bnkCustomerMaster.getNCustomerID());
                                                    }
                                                    String depDetailsCheck = "off";
                                                    if (request.getSession().getAttribute("depDetailsCheck") != null) {
                                                        depDetailsCheck = (String) request.getSession().getAttribute("depDetailsCheck");
                                                        //request.getSession().removeAttribute("componontsHideCheck");
                                                    }
                                                    String nextBtnCheck = "";
                                                    if (request.getSession().getAttribute("nextBtnCheck") != null) {
                                                        nextBtnCheck = (String) request.getSession().getAttribute("nextBtnCheck");
                                                    }

                                                %>
                                                <form action="view_customers.jsp?tellerIndexKey=custCIFID" method="post" name="accForm" onsubmit="validateGetAccountNo(this);
                                                        return false;">
                                                    <label class="col-sm-4 control-label" id="accNumLabel" name="accNumLabel" ><h4><strong id="name">පා.ලි අංකය</strong></h4></label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group">
                                                            <%if (request.getSession().getAttribute("view") != null) {%>
                                                            <input required="" type="text" class="form-control text-right" style="font-size: larger;font-weight: bold" autocomplete="off" placeholder="ගිණුම් අංකය" maxlength="9" name="accountNumber" id="accountNumber" value="<%=cOurAccountNo%>" onkeyup="changeAccountNumber();">
                                                            <%} else {%>
                                                            <input required="" type="text" class="form-control text-right" style="font-size: larger;font-weight: bold" autocomplete="off" placeholder="පා.ලි අංකය" maxlength="9" name="accountNumber" id="accountNumber" value="<%=cCIFNo%>" onkeyup="changeAccountNumber();">
                                                            <%}%>
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
                                        <div class="col-md-3">

                                        </div>
                                    </div>
                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <form class="form-horizontal" action="../NewDepDepositMasterServlet" method="post" name="savingDetailForm" id="savingDetailForm" onsubmit="validateNewSavingDetails(this);
                                return false;">
                            <div class="col-md-12">
                                <div class="box-group bg-top" id="accordion">
                                    <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                        <div class="box-header">
                                            <h4 class="box-title logo">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" class="">
                                                    තැම්පත් විස්තර
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseOne" class="panel-collapse collapse in" aria-expanded="true">
                                            <div class="box-body bg-color">
                                                <div class="row">
                                                    <div class="col-md-9">
                                                        <div class="row">
                                                            <div class="col-md-8 bg-pad">
                                                                <div class="panel panel-default" >
                                                                    <div class="panel-body bg-color" style="height: 135px">
                                                                        <div class="form-group bg-top" >
                                                                            <label class="col-md-3 input-sm text-right" style="font-size: 14px">ගිණුමේ නම :</label>
                                                                            <div class="col-md-9">
                                                                                <%
                                                                                    String cDepName = "";

                                                                                    if (request.getParameter("cDepName") != null) {
                                                                                        cDepName = request.getParameter("cDepName");
                                                                                    }

                                                                                    if (request.getParameter("nDepTypeID") != null) {
                                                                                        nDepTypeIDHid = request.getParameter("nDepTypeID");
                                                                                        session.setAttribute("nDepTypeIDDataTest", nDepTypeIDHid);
                                                                                    }

                                                                                    if (request.getSession().getAttribute("bddcts") != null) {
                                                                                        List<BnkDepDepositCategoryTypes> categoryTypes = (List<BnkDepDepositCategoryTypes>) request.getSession().getAttribute("bddcts");
                                                                                %>
                                                                                <select required="" class="form-control input-sm convertSinhalaIskolaPotha" id="nDepTypeID" name="nDepTypeID" onchange="onChangeAccType()" style="font-size: 14px" >
                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                    <%
                                                                                        for (BnkDepDepositCategoryTypes bddct : categoryTypes) {
                                                                                    %>
                                                                                    <option value="<%=bddct.getnDepTypeID()%>"><%=bddct.getcSysCode() + "-" + bddct.getcDepName()%></option>
                                                                                    <%
                                                                                            }
                                                                                            //request.getSession().removeAttribute("bddcts");

                                                                                        }
                                                                                    %>
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top" >
                                                                            <label class="col-md-3 input-sm text-right" style="font-size: 14px" >ගිණුමේ වර්ගය :</label>
                                                                            <div class="col-md-9">
                                                                                <input required="" type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="cDepName" name="cDepName" value="<%=cDepName%>"  placeholder="ගිණුමේ වර්ගය" style="font-size: 14px" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-5" style="margin-top:-10px">
                                                                            <div class="form-group" >
                                                                                <div class="row">
                                                                                    <div class="radio">
                                                                                        <label>
                                                                                            <input class="input-sm" type="radio" name="bJoint" id="bJoint1" value="0" checked >
                                                                                            තනි පුද්ගල
                                                                                        </label>
                                                                                        <label>
                                                                                            <input class="input-sm convertSinhalaIskolaPotha" type="radio" name="bJoint" id="bJoint2" value="1" >
                                                                                            හවුල්
                                                                                        </label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-7" style="padding:0px">
                                                                            <div class="form-group" style="margin-top:-5px" >
                                                                                <label class="col-md-5 input-sm text-right" style="font-size: 14px">අරම්භක දිනය :</label>
                                                                                <div class="col-md-7">
                                                                                    <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dStartDate" name="dStartDate" value="<%=dStartDate%>" />
                                                                                </div>
                                                                            </div>
                                                                        </div>    
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="panel panel-default">
                                                                    <div class="panel-body bg-color" style="height: 135px">
                                                                        <div class="form-group bg-top" >
                                                                            <label class="col-md-12" style="font-size: 14px">ගිණුම් අංකය :</label>
                                                                            <div class="col-md-12">
                                                                                <input required="" type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="cOurAccountNo" name="cOurAccountNo" value="<%=cOurAccountNo%>" placeholder="ගිණුම් අංකය" style="font-size: 14px" >
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-md-12" style="font-size: 14px">අනු අංකය :</label>
                                                                            <div class="col-md-12">
                                                                                <input required="" type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="cSerialNo" name="cSerialNo" value="<%=cSerialNo%>" placeholder="0" style="font-size: 14px" >
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3 bg-padl bg-pad">
                                                        <div class="col-md-12 bg-padl">
                                                            <div class="panel panel-default">
                                                                <div class="panel-body bg-color" style="height: 135px">
                                                                    <div class="form-group bg-top" >
                                                                        <label class="col-md-12" style="font-size: 14px">පොළී අනුපාතය :</label>
                                                                        <div class="col-md-12">
                                                                            <input required="" type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="nEffectiveInt" name="nEffectiveInt" value="<%=nEffectiveInt%>" placeholder="පොළී අනුපාතය" style="font-size: 14px" >
                                                                        </div>
                                                                    </div>                                               
                                                                    <div class="form-group bg-top">
                                                                        <label class="col-md-12" style="font-size: 14px">ලෙජර් අංකය :</label>
                                                                        <div class="col-md-12">
                                                                            <input required="" type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nLedgerBookNo" name="nLedgerBookNo" value="<%=nLedgerBookNo%>" placeholder="0" style="font-size: 14px" min="0" >
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div>
                                                    <a id="nextBtn1" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="btn btn-info btn-sm bg-top" aria-expanded="true" onclick="depDetailNextBtnAction()" >
                                                        Next  
                                                    </a>
                                                    <button type="submit" id="saveBtn1" class="btn btn-success btn-sm bg-top" onclick="saveBtnAction(1)" >
                                                        Save  
                                                    </button>
                                                </div>  
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                        <div class="box-header">
                                            <h4 class="box-title logo">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed" aria-expanded="false">
                                                    ස්ථිර හා සහතික තැම්පත්
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseTwo" class="panel-collapse collapse" aria-expanded="false">
                                            <div class="box-body bg-color">
                                                <div class="row">
                                                    <div class="col-md-4 bg-pad">
                                                        <div class="panel panel-default ">
                                                            <div class="panel-heading">
                                                                ස්ථිර/සහතික තැම්පත්
                                                            </div>
                                                            <div class="panel-body bg-color"  style="height: 220px">
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm" style="font-size:14px;">මූලික තැම්පත් මුදල :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" id="nFDIntialiDeposit" name="nFDIntialiDeposit" value="<%=nFDIntialiDeposit%>" placeholder="0.00" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm" style="font-size:14px;">පොළී අනුපතය :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" value="<%=nEffectiveInt%>" placeholder="0.0" style="font-size:14px;" maxlength="25" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm" style="font-size:14px;">කාලසීමාව :</label>
                                                                    <div class="col-md-3">
                                                                        <input type="number" class="form-control input-sm text-left convertSinhalaIskolaPotha" id="nFDPeriod" name="nFDPeriod" value="<%=nFDPeriod%>" placeholder="0" style="font-size:14px;" min="0" >
                                                                    </div>
                                                                    <div class="col-md-4">
                                                                        <select class="form-control input-sm convertSinhalaIskolaPotha" id="nFDPeriodTypeID" name="nFDPeriodTypeID" style="font-size: 14px" >
                                                                            <option value="0">-තෝරන්න-</option>
                                                                            <option value="1">දින</option>
                                                                            <option value="2">සති</option>
                                                                            <option value="3">මාස</option>
                                                                            <option value="4">වර්ෂ</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm " style="font-size:14px;">කල්පිරීමේ දිනය :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="date" class="form-control input-sm text-center convertSinhalaIskolaPotha" id="dFDMaturityDate" name="dFDMaturityDate" value="<%=dFDMaturityDate%>" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm" style="font-size:14px;">කලපිරුනු පසු මුදල :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" id="nFDMaturityValue" name="nFDMaturityValue" value="<%=nFDMaturityValue%>" placeholder="0.00" style="font-size:14px;" maxlength="25" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm" style="font-size:14px;">ගිවිසුම් අංකය :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="text" class="form-control input-sm text-left convertSinhalaIskolaPotha" id="cFDAgreementNo" name="cFDAgreementNo" value="<%=cFDAgreementNo%>" placeholder="0" style="font-size:14px;" maxlength="25" >
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4 bg-pad">
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">
                                                                ස්ථිර/සහතික තැම්පත් වැසිමේ ආකාරයන්
                                                            </div>
                                                            <div class="panel-body bg-color" style="height: 220px">
                                                                <div class="form-group">
                                                                    <div class="col-md-12">
                                                                        <div class="radio">
                                                                            <label>
                                                                                <input class="input-sm" type="radio" name="nFDClosingMethodID" id="nFDClosingMethodID1" value="0" checked > 
                                                                                ආපසු ගැනීම
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="col-md-12">
                                                                        <div class="radio">
                                                                            <label>
                                                                                <input class="input-sm" type="radio" id="nFDClosingMethodID2" name="nFDClosingMethodID" value="2" style="font-size: 14px" >
                                                                                වෙනත් ගිණුමකට මරු කිරිම
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="col-md-12">
                                                                        <div class="radio">
                                                                            <label>
                                                                                <input class="input-sm" type="radio" id="nFDClosingMethodID3" name="nFDClosingMethodID" value="3" style="font-size: 14px" >
                                                                                පොළිය සමඟ ඉදිරියට
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="col-md-12">
                                                                        <div class="radio">
                                                                            <label>
                                                                                <input class="input-sm" type="radio" id="nFDClosingMethodID4" name="nFDClosingMethodID" value="4" style="font-size: 14px" >
                                                                                පොළිය රහිත ඉදිරියට
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <div class="col-md-4">
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">
                                                                පොළී ගණනය/
                                                            </div>
                                                            <div class="panel-body bg-color" style="height: 220px">
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm " style="font-size:14px;">පොළී ක්‍රමය :</label>
                                                                    <div class="col-md-7">
                                                                        <select class="form-control input-sm convertSinhalaIskolaPotha" id="nFDIntCalMethodID" name="nFDIntCalMethodID" style="font-size: 14px" >
                                                                            <option value="0">-තෝරන්න-</option>
                                                                            <option value="1">දින</option>
                                                                            <option value="2">සති</option>
                                                                            <option value="3">මාස</option>
                                                                            <option value="4">වර්ෂ</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm" style="font-size:14px;">වාර :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="number" class="form-control input-sm text-left convertSinhalaIskolaPotha" id="nFDIntCalMethodValue" name="nFDIntCalMethodValue" value="<%=nFDIntCalMethodValue%>" placeholder="0" style="font-size:14px;" min="0" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm " style="font-size:14px;">බැර ක්‍රමය :</label>
                                                                    <div class="col-md-7">
                                                                        <select class="form-control input-sm" id="nFDIntCRMethodID" name="nFDIntCRMethodID" style="font-size: 14px" >
                                                                            <option value="0">-තෝරන්න-</option>
                                                                            <option value="1">දින</option>
                                                                            <option value="2">සති</option>
                                                                            <option value="3">මාස</option>
                                                                            <option value="4">වර්ෂ</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-5 input-sm" style="font-size:14px;">වාර :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="number" class="form-control input-sm text-left convertSinhalaIskolaPotha" id="nFDIntCRMethodValue" name="nFDIntCRMethodValue" value="<%=nFDIntCRMethodValue%>" placeholder="0" style="font-size:14px;" min="0" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top" >
                                                                    <div class="checkbox">
                                                                        <label style="color: red">
                                                                            <input type="checkbox" id="bIntCreditingDiffAcc" name="bIntCreditingDiffAcc" >
                                                                            පොළී මුදල බැරවන ගිණුම
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top" >
                                                                    <div class="col-md-12">
                                                                        <div class="input-group">
                                                                            <%

                                                                                if (request.getParameter(
                                                                                        "accNo") != null) {
                                                                                    //  nIntCRnDepMFID = Security.decrypt(request.getParameter("accNo"));
                                                                                    nIntCRnDepMFID = Security.decrypt(request.getParameter("accNo").toString().replace(" ", "+"));
                                                                                    session.setAttribute("accN", nIntCRnDepMFID);

                                                                                }

                                                                                if (session.getAttribute(
                                                                                        "accN") != null) {
                                                                                    nIntCRnDepMFID = String.valueOf(session.getAttribute("accN"));
                                                                                }


                                                                            %>
                                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size: 14px" placeholder="ගිණුම් අංකය" maxlength="20" name="nIntCRnDepMFID" id="nIntCRnDepMFID" value="<%= nIntCRnDepMFID%>" >
                                                                            <span class="input-group-btn">
                                                                                <button class="btn btn-info btn-flat btn-sm" type="button" onclick="searchTargetAccount()"><i class="fa fa-search"></i></button>
                                                                            </span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                </div>
                                                <div class="row" >
                                                    <div class="col-md-6  bg-top">
                                                        <a id="backBtn1" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="btn btn-warning btn-sm" aria-expanded="false" >
                                                            Back 
                                                        </a>
                                                        <a id="nextBtn2" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="btn btn-info btn-sm" aria-expanded="false" onclick="depFixCertificetBtnAction()" >
                                                            Next
                                                        </a>
                                                        <button id="saveBtn2" type="submit" class="btn btn-success btn-sm" onclick="saveBtnAction(2)" >
                                                            Save  
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                        <div class="box-header">
                                            <h4 class="box-title logo">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed" aria-expanded="false">
                                                    ගිණුම් පාලනය
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseThree" class="panel-collapse collapse" aria-expanded="false">
                                            <div class="box-body bg-color">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="panel panel-default">
                                                            <div class="panel-body bg-color"  style="height: 295px">
                                                                <div class="form-group bg-top">
                                                                    <label class="col-md-3"></label>
                                                                    <div class="col-md-9">
                                                                        <div class="checkbox">
                                                                            <label>
                                                                                <input type="checkbox" name="bAmtHolded" id="bAmtHolded" >
                                                                                මුදල් රැඳවීම
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-3 input-sm">රැඳවු මුදල :</label>
                                                                    <div class="col-md-9">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" name="nHoldedAmount" id="nHoldedAmount" value="<%=nHoldedAmount%>" placeholder="0.00" style="font-size:14px;" maxlength="25" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-3 input-sm">ආරම්භක දිනය :</label>
                                                                    <div class="col-md-9">
                                                                        <input type="date" class="form-control input-sm text-center convertSinhalaIskolaPotha" name="dHoldFromDate" id="dHoldFromDate" value="<%=dHoldFromDate%>" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-3 input-sm ">අවසාන දිනය :</label>
                                                                    <div class="col-md-9">
                                                                        <input type="date" class="form-control input-sm text-center convertSinhalaIskolaPotha" name="dHoldToDate" id="dHoldToDate" value="<%=dHoldToDate%>" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="col-md-3"></label>
                                                                    <div class="col-md-9">
                                                                        <div class="checkbox">
                                                                            <label>
                                                                                <input type="checkbox" name="bIntHolded" id="bIntHolded" >
                                                                                පොළී රැඳවීම
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-3 input-sm">රැඳවු මුදල :</label>
                                                                    <div class="col-md-9">
                                                                        <input type="text" class="form-control input-sm text-right" name="nHoldedAmountInt" id="nHoldedAmountInt" value="<%=nHoldedAmountInt%>" placeholder="0.00" style="font-size:14px;" maxlength="25" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-3 input-sm">ආරම්භක දිනය :</label>
                                                                    <div class="col-md-9">
                                                                        <input type="date" class="form-control input-sm text-center convertSinhalaIskolaPotha" name="dIntHoldFromDate" id="dIntHoldFromDate" value="<%=dIntHoldFromDate%>" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-3 input-sm ">අවසාන දිනය :</label>
                                                                    <div class="col-md-9">
                                                                        <input type="date" class="form-control input-sm text-center convertSinhalaIskolaPotha" name="dIntHoldToDate" id="dIntHoldToDate" value="<%=dIntHoldToDate%>" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="panel panel-default">
                                                            <div class="panel-body bg-color" style="height: 295px">
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm">ගිණුම් අංකය :</label>
                                                                    <div class="col-md-8">

                                                                        <%

                                                                            if (request.getParameter(
                                                                                    "accNo1") != null) {
                                                                                //  nIntCRnDepMFID = Security.decrypt(request.getParameter("accNo"));
                                                                                nInstDRnDepMFID = Security.decrypt(request.getParameter("accNo1").toString().replace(" ", "+"));
                                                                                session.setAttribute("accN1", nInstDRnDepMFID);

                                                                            }

                                                                            if (session.getAttribute(
                                                                                    "accN1") != null) {
                                                                                nInstDRnDepMFID = String.valueOf(session.getAttribute("accN1"));
                                                                            }


                                                                        %>



                                                                        <div class="input-group">
                                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size: 14px" placeholder="ගිණුම් අංකය" maxlength="20" name="nInstDRnDepMFID" id="nInstDRnDepMFID" value="<%=nInstDRnDepMFID%>" >
                                                                            <span class="input-group-btn">
                                                                                <button class="btn btn-info btn-flat btn-sm" type="button" onclick="searchTargetAccount1()"><i class="fa fa-search"></i></button>
                                                                            </span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm ">හරවන මුදල :</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" name="nInstDRValue" id="nInstDRValue" value="<%=nInstDRValue%>" placeholder="0.00" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm">පවත්නා ශේෂය :</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.00" style="font-size:14px;" maxlength="25" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm ">බැර නොවු ශේෂය :</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.00" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm">බැර නොවු පොළීය :</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.00" style="font-size:14px;" maxlength="25" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm ">ඉදිරියට ඇති මාස ගණන :</label>
                                                                    <div class="col-md-8">
                                                                        <input type="number" class="form-control input-sm text-left convertSinhalaIskolaPotha" name="nTDDepositPeriod" id="nTDDepositPeriod" value="<%=nTDDepositPeriod%>" placeholder="0" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm">ගිවිසුම් ගත තැම්පත් මුදල :</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" name="nTDAgreedAmount" id="nTDAgreedAmount" value="<%=nTDAgreedAmount%>" placeholder="0.00" style="font-size:14px;" >
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-4 input-sm ">ගෙවීම සෑම දින :</label>
                                                                    <div class="col-md-6"> 
                                                                        <input type="number" class="form-control input-sm text-left convertSinhalaIskolaPotha" name="nTDPaymentDay" id="nTDPaymentDay" value="<%=nTDPaymentDay%>" placeholder="0" style="font-size:14px;" >
                                                                    </div>
                                                                    <label class="col-sm-2 input-sm">වරක්</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row" >
                                                    <div class="col-md-6  bg-top">
                                                        <a id="backBtn2" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="btn btn-warning btn-sm" aria-expanded="false" >
                                                            Back 
                                                        </a>
                                                        <a id="nextBtn3" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="btn btn-info btn-sm" aria-expanded="false" >
                                                            Next
                                                        </a>
                                                        <button id="saveBtn3" type="submit" class="btn btn-success btn-sm" onclick="saveBtnAction(3)" >
                                                            Save  
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                        <div class="box-header">
                                            <h4 class="box-title logo">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed" aria-expanded="false">
                                                    හිමිකරුවන්ගේ විස්තර
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseFour" class="panel-collapse collapse" aria-expanded="false">
                                            <div class="box-body bg-color">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="panel panel-default">
                                                            <div class="panel-body bg-color" style="height: 44px;">
                                                                <div class="pull-right bg-top">
                                                                    <a href="view_customers.jsp?tellerIndexKey=sDInputCust" class="btn btn-success btn-sm" style="font-size: 14px;">
                                                                        ගණුදෙනු කරුවන් ඇතුලත් කිරීම
                                                                    </a>
                                                                    <a href="../StoreSavingDetailDataServlet?removeCust=true" class="btn btn-success btn-sm" style="font-size: 14px;">
                                                                        ගණුදෙනු කරුවන් ඉවත් කිරීම
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-12 bg-top">
                                                        <table class="table table-bordered" style="margin-bottom: -9px">
                                                            <tbody>
                                                                <tr style="background-color: #93bace">
                                                                    <th class="text-center" width="200px">පා.ලි අංකය</th>
                                                                    <th class="text-center" width="250px">නම</th>
                                                                    <th class="text-center" width="10px">සම්බන්ධය</th>
                                                                    <th class="text-center">අත්සන</th>
                                                                    <th class="text-center" width="200px">වෙනත් තොරතුරු</th>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <div class="zTreeDemoBackground left">
                                                            <ul id="treeDemo" class="ztree" style="width: auto;height:130px;">
                                                                <table class="table table-bordered table-hover">
                                                                    <tbody id="depositBody">
                                                                        <%

                                                                            if (request.getSession()
                                                                                    .getAttribute("inputCutomerDetails") != null) {
                                                                                List<BnkCustomerMaster> customerMasters = (List<BnkCustomerMaster>) request.getSession().getAttribute("inputCutomerDetails");
                                                                                for (BnkCustomerMaster bcm : customerMasters) {
                                                                        %>
                                                                        <tr>
                                                                            <td class="convertSinhalaIskolaPotha "><%=bcm.getCCIFNo()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"><%=bcm.getCFullName()%></td>
                                                                            <td class="convertSinhalaIskolaPotha"></td>
                                                                            <td class="convertSinhalaIskolaPotha"></td>
                                                                            <td class="convertSinhalaIskolaPotha"></td>
                                                                        </tr>
                                                                        <%

                                                                                }
                                                                            }
                                                                        %>
                                                                    </tbody>
                                                                </table>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row bg-top">
                                                    <br/>
                                                    <div class="col-md-6">
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="btn btn-warning btn-sm" aria-expanded="false">
                                                            Back 
                                                        </a>
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix" class="btn btn-info btn-sm" aria-expanded="false">
                                                            Next
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                        <div class="box-header">
                                            <h4 class="box-title logo">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix" class="collapsed" aria-expanded="false">
                                                    ප්&zwj;රතිලාබ ලබන්නන් 
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseSix" class="panel-collapse collapse" aria-expanded="false">
                                            <div class="box-body bg-color">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="panel panel-default">
                                                            <div class="panel-body bg-color" style="height: 75px">
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-2 input-sm">බැර නොවූ පොලි :</label>
                                                                    <div class="col-md-3">
                                                                        <input type="text" class="convertSinhalaIskolaPotha form-control input-sm text-right" placeholder="0.0" style="font-size:large;" maxlength="25">
                                                                    </div>
                                                                    <label class="control-label col-sm-2 input-sm">බැර නොවූ පොලි :</label>
                                                                    <div class="col-md-5">
                                                                        <input type="text" class=" convertSinhalaIskolaPotha form-control input-sm text-right" placeholder="0.0" style="font-size:large;" maxlength="25">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group bg-top">
                                                                    <label class="control-label col-sm-2 input-sm ">ගණුදෙණු දිනය :</label>
                                                                    <div class="col-md-3">
                                                                        <input type="text" class=" convertSinhalaIskolaPotha form-control input-sm text-center" placeholder="dd/mm/yyyy"  style="font-size:large;">
                                                                    </div>
                                                                    <label class="control-label col-sm-2 input-sm ">ගණුදෙණු දිනය :</label>
                                                                    <div class="col-md-3">
                                                                        <input type="text" class="convertSinhalaIskolaPotha form-control input-sm text-center" placeholder="dd/mm/yyyy"  style="font-size:large;">
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <button type="submit" class="btn btn-primary btn-sm" onclick="#">New</button>
                                                                        <button type="submit" class="btn btn-primary btn-sm" onclick="#">Save</button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12 bg-top">
                                                        <div class="panel panel-default">
                                                            <div class="panel-body bg-color">
                                                                <table class="table table-bordered">
                                                                    <tbody>
                                                                        <tr>
                                                                            <th>අංකය</th>
                                                                            <th>දිනය</th>
                                                                            <th>ගනුදෙනු වර්ගය</th>
                                                                            <th >හර</th>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>   
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row" >
                                                    <div class="col-md-6  bg-top">
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive" class="btn btn-warning btn-sm" aria-expanded="false">
                                                            Back 
                                                        </a>
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" class="btn btn-info btn-sm" aria-expanded="false">
                                                            Next
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                        <div class="box-header">
                                            <h4 class="box-title logo">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" class="collapsed" aria-expanded="false">
                                                    ලිපි ලයිස්තුව
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseSeven" class="panel-collapse collapse" aria-expanded="false">
                                            <div class="box-body bg-color">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="panel panel-default">
                                                            <div class="panel-body bg-color" style="height: 40px;">
                                                                <div class="pull-right bg-top">
                                                                    <button type="submit" class="btn btn-primary btn-sm" onclick="#">ගනුදෙනු කරුවන් ඇතුල් කිරීම</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12 bg-top">
                                                        <div class="panel panel-default">
                                                            <div class="panel-body bg-color">
                                                                <table class="table table-bordered">
                                                                    <tbody>
                                                                        <tr>
                                                                            <th>අංකය</th>
                                                                            <th>දිනය</th>
                                                                            <th>ගනුදෙනු වර්ගය</th>
                                                                            <th >හර</th>
                                                                            <th >බැර</th>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row" >
                                                    <div class="col-md-6  bg-top">
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix" class="btn btn-warning btn-sm" aria-expanded="false">
                                                            Back 
                                                        </a>
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="btn btn-info btn-sm" aria-expanded="false">
                                                            Next
                                                        </a>
                                                        <input type="submit" class="btn btn-success btn-sm" aria-expanded="false" value="Submit"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--nDepMFID-->                                        
                            <input type="hidden" id="nDepMFID" name="nDepMFID" value="<%=nDepMFID%>"/>
                            <!--customerID-->
                            <input type="hidden" id="nCustomerID" name="nCustomerID" value="<%=nCustomerID%>"/>
                            <!--------------->
                            <!--saveType-->
                            <input type="hidden" id="saveType" name="saveType" value="<%=saveType%>"/>
                            <!--------------->
                            <!--userName-->
                            <input type="hidden" id="userName" name="userName" value="<%=userName%>"/>
                            <!--------------->
                        </form>
                    </div>
                </section>
            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->

    </body>

    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    <script src="../js/bootbox.js" type="text/javascript"></script>
    <script src="../js/bootbox.min.js" type="text/javascript"></script>
    <script src="../js/validate.js" type="text/javascript"></script>
    <script type="text/javascript" >

                                                                        //-----------Action Function-------------

                                                                        function crBrAccountAcction() {
                                                                            window.location = "view_depositmaster.jsp?tellerIndexKey=mTCR";
                                                                        }

                                                                        function brBrAccountAcction() {
                                                                            window.location = "view_depositmaster.jsp?tellerIndexKey=mTBR";
                                                                        }
                                                                        if (<%=view%>) {
                                                                            $('#name').html('ගිණුම් අංකය');
                                                                        }
                                                                        //---------------------------------------

    </script>

</html>
