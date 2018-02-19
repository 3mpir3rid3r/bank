<%-- 
    Document   : new_derails
    Created on : Jan 29, 2015, 2:38:34 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.BnkLonLoanMaster"%>
<%@page import="com.nbs.model.BnkLonLoanStatus"%>
<%@page import="com.nbs.model.BnkLonLoanFundSource"%>
<%@page import="com.nbs.model.BnkLonLoanDescriptions"%>
<%@page import="com.nbs.model.BnkLonLoanGroups"%>
<%@page import="com.nbs.model.BnkLonLoanDeductType"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.model.common.BnkLonLoanCtegoryTypes"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ණය තොරතුරු</title>

        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>
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
            }
            .bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:120px;                
            }
            .bg-top2{
                margin-top: -20px;                
            }
            .bg-panel{
                margin-bottom: -5px;
                background:#367fa9;
            }
            .bg-pad{
                padding-right: 0px;
            }
        </style>

        <script type="text/javascript" >
            <%
                if (request.getSession().getAttribute("bllcts") == null) {
            %>
            window.location = "../LoanDetailsServlet";
            <%
                }
            %>
        </script>

    </head>
    <body class="skin-blue  pace-done fixed" >

        <%
            String nLonMFID = "";
            if (request.getSession().getAttribute("mainInfroBllm") != null) {
                BnkLonLoanMaster bllm = (BnkLonLoanMaster) request.getSession().getAttribute("mainInfroBllm");
                nLonMFID = String.valueOf(bllm.getNLonMFID());
            }
        %>

        <!--header-->
        <%@include file="teller_header.jsp" %>
        <!--.............................header End......................-->

        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <aside id="content" class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        ණය තොරතුරු
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">ණය තොරතුරු</li>
                    </ol>
                </section>
                <!--..................................page content............-->
                <section class="content">
                    <%                        String cCIFNo = "";
                        String cMemberShipNo = "සාමාජික අංකය";
                        String cNICNo = " ජැ.හැ. අංකය";
                        String cUseName = "භාවිත නම";
                        String cFullName = "----සම්පූර්ණ නම----";
                        String cPAddLine1 = "----ලිපිනය----";
                        String saveType = "1";
                        String nCustomerID = "";

                        if (request.getSession().getAttribute("cutomerDetailsForCIF") != null) {
                            BnkCustomerMaster bnkCustomerMaster = (BnkCustomerMaster) request.getSession().getAttribute("cutomerDetailsForCIF");
                            cCIFNo = bnkCustomerMaster.getCCIFNo();
                            cMemberShipNo = bnkCustomerMaster.getCMemberShipNo();
                            cNICNo = bnkCustomerMaster.getCNICNo();
                            cFullName = bnkCustomerMaster.getCFullName();
                            cUseName = bnkCustomerMaster.getCUseName();
                            cPAddLine1 = bnkCustomerMaster.getCPAddLine1();

                            nCustomerID = String.valueOf(bnkCustomerMaster.getNCustomerID());
                        }
                        String loanDetailsCheck = "off";
                        if (request.getSession().getAttribute("loanDetailsCheck") != null) {
                            loanDetailsCheck = (String) request.getSession().getAttribute("loanDetailsCheck");
                            //request.getSession().removeAttribute("componontsHideCheck");
                        }
                        if (request.getSession().getAttribute("saveType") != null) {
                            saveType = (String) request.getSession().getAttribute("saveType");
                            //request.getSession().removeAttribute("componontsHideCheck");
                        }
//                        String nextBtnCheck = "";
//                        if (request.getSession().getAttribute("nextBtnCheck") != null) {
//                            nextBtnCheck = (String) request.getSession().getAttribute("nextBtnCheck");
//                        }
                    %>

                    <div class="row bg-searchheight bg-top">
                        <div class="col-md-12 bg-searchheight">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-5">  
                                            <div class="form-group">
                                                <form action="view_customers.jsp?tellerIndexKey=custCIFIDLoan" method="post" name="accForm" onsubmit="validateGetAccountNo(this);
                                                        return false;">
                                                    <label class="col-sm-4 control-label" id="accNumLabel" name="accNumLabel" ><h4><strong>පා.ලි අංකය</strong></h4></label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group">
                                                            <input type="text" class="form-control text-right" style="font-size: larger;font-weight: bold" autocomplete="off" placeholder="පා.ලි අංකය" maxlength="9" name="accountNumber" id="accountNumber" value="<%=cCIFNo%>" onkeyup="changeAccountNumber();">
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
                        <div class="col-md-12">
                            <div class="box-group" id="accordion">
                                <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                <div class="panel box box-info bg-panel">
                                    <form class="form-horizontal" action="../NewLonLoanMasterServlet" method="post" name="loanDetailForm" id="loanDetailForm" onsubmit="validateNewLoanDetails(this);
                                            return false;">
                                        <input type="hidden" id="saveType1" name="saveType" value='<%=saveType%>'/>
                                        <div class="box-header">
                                            <h5 class="box-title logo">
                                                <a id="collapseOneT" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" class="">
                                                    <span class="fa fa-pencil">  මුලික තොරතුරු </span>
                                                </a>
                                            </h5>
                                        </div>
                                        <div id="collapseOne" class="panel-collapse collapse" aria-expanded="true">
                                            <div class="box-body  bg-color">
                                                <div class="row">
                                                    <div class="col-md-5">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="panel panel-default bg-color" style="height: 885px">
                                                                    <div class="panel-heading">
                                                                        මූලික තොරතුරු 1
                                                                    </div>
                                                                    <div class="panel-body" style="margin-bottom: -20px;">
                                                                        <div class="form-group">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ණය වර්ගය :</label>

                                                                            <%
                                                                                String cLoanName = "";
                                                                                if (request.getParameter("cLoanName") != null) {
                                                                                    cLoanName = request.getParameter("cLoanName");
                                                                                }
                                                                                String nLonTypeIDHid = "0";
                                                                                if (request.getParameter("nLonTypeID") != null) {
                                                                                    nLonTypeIDHid = request.getParameter("nLonTypeID");
                                                                                }

//                                                                                if (request.getSession().getAttribute("bllcts") != null) {
//                                                                                    List<BnkLonLoanCtegoryTypes> categoryTypes = (List<BnkLonLoanCtegoryTypes>) request.getSession().getAttribute("bllcts");
                                                                            %>

                                                                            <div class="col-md-8">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonTypeID" name="nLonTypeID" onchange="onChangeAccType()" disabled>
                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                    <%                                                                                        if (request.getSession().getAttribute("bllcts") != null) {
                                                                                            List<BnkLonLoanCtegoryTypes> categoryTypes = (List<BnkLonLoanCtegoryTypes>) request.getSession().getAttribute("bllcts");
                                                                                            for (BnkLonLoanCtegoryTypes bllct : categoryTypes) {

                                                                                    %>
                                                                                    <option value="<%=bllct.getnLonTypeID()%>"><%=bllct.getcSysCode() + "-" + bllct.getcLonName()%></option>
                                                                                    <%
                                                                                            }
                                                                                            request.getSession().removeAttribute("bllcts");
                                                                                        }
                                                                                    %>
                                                                                </select>                                                                                
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ණය ස්වභාවය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="ණය ස්වභාවය" id="cLoanName" name="cLoanName" value="<%=cLoanName%>" disabled>                                                                               
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">කාරණය :</label>
                                                                            <div class="col-md-8">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonDescriptionID" name="nLonDescriptionID" disabled>
                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                    <%
                                                                                        if (request.getSession().getAttribute("bllds") != null) {
                                                                                            List<BnkLonLoanDescriptions> categoryTDescriptions = (List<BnkLonLoanDescriptions>) request.getSession().getAttribute("bllds");
                                                                                            for (BnkLonLoanDescriptions blld : categoryTDescriptions) {

                                                                                    %>
                                                                                    <option value="<%=blld.getNLonDescriptionID()%>"><%=blld.getCLonDescription()%></option>
                                                                                    <%
                                                                                            }
                                                                                            request.getSession().removeAttribute("bllds");
                                                                                        }
                                                                                    %>
                                                                                </select>                                                                                
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ණය මූලාශ්‍රය :</label>
                                                                            <div class="col-md-8">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonFundSourceID" name="nLonFundSourceID" disabled>
                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                    <%
                                                                                        if (request.getSession().getAttribute("bllfs") != null) {
                                                                                            List<BnkLonLoanFundSource> fundSources = (List<BnkLonLoanFundSource>) request.getSession().getAttribute("bllfs");
                                                                                            for (BnkLonLoanFundSource bllfs : fundSources) {

                                                                                    %>
                                                                                    <option value="<%=bllfs.getNLonFundSourceID()%>"><%=bllfs.getCLonFundSourceName()%></option>
                                                                                    <%
                                                                                            }
                                                                                            request.getSession().removeAttribute("bllfs");
                                                                                        }
                                                                                    %>
                                                                                </select>                                                                                
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <div class="row">
                                                                                <label class="col-sm-4 input-sm"></label>
                                                                                <div class="col-md-8">
                                                                                    <div class="row">
                                                                                        <div class="radio">
                                                                                            <label >
                                                                                                <input type="radio" id="bJoint1" name="bJoint" value="0" class="control-label" checked disabled> තනි පුද්ගල 
                                                                                            </label>
                                                                                            <label >
                                                                                                <input type="radio" id="bJoint2" name="bJoint" value="1" class="control-label" disabled> හවුල් 
                                                                                            </label>                                                                             
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ණයෙහි තත්වය :</label>
                                                                            <div class="col-md-8">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonStatusID" name="nLonStatusID" disabled>
                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                    <%
                                                                                        if (request.getSession().getAttribute("bllses") != null) {
                                                                                            List<BnkLonLoanStatus> loanStatuses = (List<BnkLonLoanStatus>) request.getSession().getAttribute("bllses");
                                                                                            for (BnkLonLoanStatus blls : loanStatuses) {

                                                                                    %>
                                                                                    <option value="<%=blls.getNLonStatusID()%>"><%=blls.getCLonStatus()%></option>
                                                                                    <%
                                                                                            }
                                                                                            request.getSession().removeAttribute("bllses");
                                                                                        }
                                                                                    %>
                                                                                </select>                                                                                
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ණය අංකය :</label>
                                                                            <div class="col-md-8">
                                                                                <input data="validate" data-type="number" type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="cLonAccountNo" name="cLonAccountNo" disabled>                                        
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ලෙජර අංකය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nLedgerBookNo" name="nLedgerBookNo" disabled>                                        
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">අනු අංකය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="cSerialNo" name="cSerialNo" disabled>                                                                              
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">අයදුම් කල දිනය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dApplyedDate" name="dApplyedDate" disabled>                                                                                 
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">අනුමත කල දිනය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dApprovedDate" name="dApprovedDate" disabled>                                                                                 
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ඉල්ලුම් කල මුදල :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nApplyedAmount" name="nApplyedAmount" disabled>                                                                                 
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">අනුමත කල මුදල :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nApprovedAmount" name="nApprovedAmount" disabled>                                                                                 
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">රක්ෂණ මුදල :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nInsuredAmount" name="nInsuredAmount" disabled>                                                                                 
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">රඳවා ගන්නා මුදල :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nReservedAmount" name="nReservedAmount" disabled>                                                                                 
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">පොළී අනුපාතය :</label>
                                                                            <div class="col-md-8">
                                                                                <div class="input-group">
                                                                                    <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="Amount" id="nEffectiveInt" name="nEffectiveInt" disabled>
                                                                                    <span class="input-group-addon input-sm">%</span>
                                                                                </div>                                                                                
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-left" style="font-size: 13px">දඩ පොළී අනුපාතය :</label>
                                                                            <div class="col-md-8">
                                                                                <div class="input-group">
                                                                                    <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="Amount" id="nPanaltyInt" name="nPanaltyInt" disabled>
                                                                                    <span class="input-group-addon input-sm">%</span>
                                                                                </div>                                                                                
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top"> 
                                                                            <label class="col-sm-12 input-sm" style="font-size: 14px">අධ්‍යක්ෂක මණ්ඩල තීරණ</label>
                                                                        </div>
                                                                        <div class="form-group bg-top"> 
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">අංකය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="cBoardApprovalNo" name="cBoardApprovalNo" disabled>     
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top"> 
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">දිනය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dBoardApprovalDate" name="dBoardApprovalDate" disabled>     
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="row">
                                                                    <div class="col-md-12">
                                                                        <a id="nextBtn1" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed btn btn-info btn-sm" aria-expanded="false" disabled>Next</a>
                                                                        <button id="saveBtn1" type="submit" class="btn btn-success btn-sm" disabled>
                                                                            Save  
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="panel panel-default bg-color">
                                                                    <div class="panel-heading">
                                                                        ගෙවීම් පටිපාටිය
                                                                    </div>
                                                                    <div class="panel-body" style="margin-bottom: -26px">
                                                                        <div class="form-group">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">කාල සීමාව :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonPeriodTypeID" name="nLonPeriodTypeID" onchange="onChangeNLPTypeIDLabel()" disabled>
                                                                                    <option value="1">-N/A-</option>
                                                                                    <option value="2">දින</option>
                                                                                    <option value="3">සති</option>
                                                                                    <option value="4">මාස</option>
                                                                                    <option value="5">වර්ෂ</option>
                                                                                </select>                                                                                   
                                                                            </div>
                                                                            <div class="col-md-2 bg-pad">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nLonPeriod" name="nLonPeriod" onkeyup="onChangeNLPTypeIDLabel()" onchange="onChangeNLPTypeIDLabel()" disabled>                                                                                 
                                                                            </div>
                                                                            <label class="col-sm-1 input-sm text-right" id="nLPTypeIDLabel"></label>
                                                                            <label class="col-sm-1 input-sm text-right">ක්</label>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">නිදහස් කාල සීමාව :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonPaymentFreeTypeID" name="nLonPaymentFreeTypeID" onchange="onChangeNLPFTypeIDLabel()" disabled>
                                                                                    <option value="1">-N/A-</option>
                                                                                    <option value="2">දින</option>
                                                                                    <option value="3">සති</option>
                                                                                    <option value="4">මාස</option>
                                                                                    <option value="5">වර්ෂ</option>
                                                                                </select>                                                                                   
                                                                            </div>
                                                                            <div class="col-md-2 bg-pad">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nLonPaymentFreeTime" name="nLonPaymentFreeTime" onkeypress="onChangeNLPFTypeIDLabel()" onchange="onChangeNLPFTypeIDLabel()" disabled>                                                                                 
                                                                            </div>
                                                                            <label class="col-sm-1 input-sm text-right" id="nLPFTypeIDLabel"></label>
                                                                            <label class="col-sm-1 input-sm text-right">ක්</label>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">පළමු ගෙවීම ආරම්භ වන දිනය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dFirstInstallmentDate" name="dFirstInstallmentDate" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">අවසාන ගෙවීම් දිනය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dMaturityDate" name="dMaturityDate" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ණය අයකරගැනිමේ වර්ගය :</label>
                                                                            <div class="col-md-8">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonDeductTypeID" name="nLonDeductTypeID" disabled>
                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                    <%
                                                                                        if (request.getSession().getAttribute("bllgs") != null) {
                                                                                            List<BnkLonLoanGroups> groupses = (List<BnkLonLoanGroups>) request.getSession().getAttribute("bllgs");
                                                                                            for (BnkLonLoanGroups bllg : groupses) {

                                                                                    %>
                                                                                    <option value="<%=bllg.getNLonGrpID()%>"><%=bllg.getCLonGrpDescription()%></option>
                                                                                    <%
                                                                                            }
                                                                                            request.getSession().removeAttribute("bllgs");
                                                                                        }
                                                                                    %>
                                                                                </select>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ණය අයකිරීමේ ක්‍රමය :</label>
                                                                            <div class="col-md-8">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonGrpID" name="nLonGrpID" disabled>
                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                    <%
                                                                                        if (request.getSession().getAttribute("blldt") != null) {
                                                                                            List<BnkLonLoanDeductType> deductTypes = (List<BnkLonLoanDeductType>) request.getSession().getAttribute("blldt");
                                                                                            for (BnkLonLoanDeductType blldt : deductTypes) {

                                                                                    %>
                                                                                    <option value="<%=blldt.getNLonDeductTypeID()%>"><%=blldt.getCLonDeductType()%></option>
                                                                                    <%
                                                                                            }
                                                                                            request.getSession().removeAttribute("blldt");
                                                                                        }
                                                                                    %>
                                                                                </select>                                                                                 
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top"> 
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">ස්ථිර පොළියක් නම් පොළී මුදල :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nFixedInterestValue" name="nFixedInterestValue" disabled>     
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top"> 
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">වාරික අය කිරීමේ ක්‍රමය :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="nLonInstallmentPayTypeID" name="nLonInstallmentPayTypeID" onchange="onChahgeNLIPTypeIDLabel()" disabled>
                                                                                    <option value="1">-N/A-</option>
                                                                                    <option value="2">දින</option>
                                                                                    <option value="3">සති</option>
                                                                                    <option value="4">මාස</option>
                                                                                    <option value="5">වර්ෂ</option>
                                                                                </select>                                                                                   
                                                                            </div>
                                                                            <div class="col-md-2 bg-pad">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nLonInstallmentPayTime" name="nLonInstallmentPayTime" onkeypress="onChahgeNLIPTypeIDLabel()" onchange="onChahgeNLIPTypeIDLabel()" disabled>                                                                                 
                                                                            </div>
                                                                            <label class="col-sm-1 input-sm text-left" style="font-size: 13px" id="nLIPTypeIDLabel"></label>
                                                                            <label class="col-sm-1 input-sm text-left" style="font-size: 13px">වරක්</label>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">වාරික මුදල :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nInstallmentAmount" name="nInstallmentAmount" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">සැකසු වාරිකය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nInstallmentAmountAdj" name="nInstallmentAmountAdj" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">අවසාන වාරිකය :</label>
                                                                            <div class="col-md-8">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nInstallmentAmountLast" name="nInstallmentAmountLast" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-4 input-sm text-right" style="font-size: 13px">කල්පසු වීමට දින ගණන :</label>
                                                                            <div class="col-md-2">
                                                                                <input type="text" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nDueDaysAfter" name="nDueDaysAfter" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-2 input-sm text-left" style="font-size: 13px">අයවන දිනය :</label>
                                                                            <div class="col-md-4">
                                                                                <input type="text" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nDeductDay" name="nDeductDay" disabled>                                                                                   
                                                                            </div>
                                                                        </div>                                                                    
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="panel panel-default bg-color">
                                                                    <div class="panel-heading">
                                                                        ණය ආපසු ගෙවිමේ තොරතුරු
                                                                    </div>
                                                                    <div class="panel-body" style="margin-bottom: -26px">
                                                                        <div class="form-group">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">නිකුත් කළ මුදල :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nIssuedAmount" name="nIssuedAmount" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-2 input-sm text-right" style="font-size: 13px">ඉතිරිය :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nBalanceToIssue" name="nBalanceToIssue" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">අයවී ඇති මුදල :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nTotRecvCapital" name="nTotRecvCapital" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-2 input-sm text-right" style="font-size: 13px">වාරික :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nTotRecvInstallment" name="nTotRecvInstallment" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">අයවිය යුතු මුදල :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nShouldRecvCapital" name="nShouldRecvCapital" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-2 input-sm text-right" style="font-size: 13px">වාරික :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nShouldRecvInstallment" name="nShouldRecvInstallment" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">අයවී ඇති පොළිය :</label>
                                                                            <div class="col-md-3">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nTotRecvInterest" name="nTotRecvInterest" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">අයවිය යුතු පොළිය :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nShouldRecvInterest" name="nShouldRecvInterest" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">ගෙවීමට ඇති මුදල :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nLonBalanceAmount" name="nLonBalanceAmount" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-2 input-sm text-right" style="font-size: 13px">වාරික :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nLonBalanceInstallment" name="nLonBalanceInstallment" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">අවසාන වාරික දිනය :</label>
                                                                            <div class="col-md-3 bg-pad">
                                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dLastCapitalPayDate" name="dLastCapitalPayDate" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">පොළී දිනය :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dLastIntPayDate" name="dLastIntPayDate" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">හිඟ වාරික මුදල :</label>
                                                                            <div class="col-md-4 bg-pad">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nToDateDueCapital" name="nToDateDueCapital" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-2 input-sm text-right" style="font-size: 13px">වාරික :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" id="nToDateDueInstallment" name="nToDateDueInstallment" disabled>                                                                                   
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group bg-top">
                                                                            <label class="col-sm-3 input-sm text-right" style="font-size: 13px">පොළිය :</label>
                                                                            <div class="col-md-3 bg-pad">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nToDateIntValueRound" name="nToDateIntValueRound" disabled>                                                                                   
                                                                            </div>
                                                                            <label class="col-sm-1 input-sm text-right" style="font-size: 13px"></label>
                                                                            <input type="hidden" class="form-control input-sm convertSinhalaIskolaPotha" id="nToDateDueDays" name="nToDateDueDays"/>                                                                                   
                                                                            <label class="col-sm-2 input-sm text-right" style="font-size: 13px">හිඟ පොළිය :</label>
                                                                            <div class="col-md-3" style="padding-left: 0px">
                                                                                <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha" id="nToDateTotIntersest" name="nToDateTotIntersest" disabled>                                                                                   
                                                                            </div>
                                                                        </div>                                                                   
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <input type="hidden" id="nCustomerID" name="nCustomerID" value="<%=nCustomerID%>"/>
                                    </form>
                                </div>
                                <div class="panel box box-info bg-panel">
                                    <div class="box-header">
                                        <h4 class="box-title logo">
                                            <a id="collapseTwoT" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed" aria-expanded="false">
                                                <span class="fa fa-dollar">  ණය ඉල්ලුම්පත </span>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body bg-color">
                                            <div class="row">                                                        
                                                <div class="col-md-12">
                                                    <div class="panel panel-default bg-color">
                                                        <div class="panel-heading">
                                                            <div class="btn-group btn-group-justified">
                                                                <div class="btn-group">
                                                                    <a id="aAdd" href="./view_customers.jsp?tellerIndexKey=loanpatner" type="button" class="btn btn-info">හවුල්කරුවන් ඇතුලත් කිරීම</a>
                                                                </div>
                                                                <div class="btn-group">
                                                                    <button id="btnRemove" type="button" class="btn btn-info" data-toggle="modal" data-target="#remove" disabled >හවුල්කරුවන්  ඉවත් කිරීම</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="panel-body">
                                                            <table class="table table-bordered">
                                                                <tr>
                                                                    <th class="text-center">පා .ලි .අංකය </th>
                                                                    <th class="text-center">නම </th>
                                                                    <th class="text-center"></th>
                                                                    <th class="text-center">අත්සන</th>
                                                                    <th class="text-center">වෙනත් විස්තර </th>
                                                                </tr>
                                                                <%
                                                                    BnkCustomerMaster bnkCustomerMaster;
                                                                    if (request.getSession().getAttribute("aPatner") != null) {
                                                                        List patner = (List) request.getSession().getAttribute("aPatner");
                                                                        for (int i = 0; i < patner.size(); i++) {
                                                                            bnkCustomerMaster = (BnkCustomerMaster) patner.get(i);
                                                                %> 
                                                                <tr data-bind='<%=bnkCustomerMaster.getNCustomerID()%>'>
                                                                    <td ><%=bnkCustomerMaster.getCCIFNo()%></td>
                                                                    <td><%=bnkCustomerMaster.getCFullName()%></td>
                                                                    <td></td>
                                                                    <td align="center"><input type="checkbox" name="checkbox"></td>
                                                                    <td></td>
                                                                </tr>
                                                                <%
                                                                        }
                                                                    }%>

                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="collapsed btn btn-warning btn-sm" aria-expanded="false">Back</a>
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed btn btn-info btn-sm" aria-expanded="false">Next</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel box box-info bg-panel">
                                    <div class="box-header">
                                        <h4 class="box-title logo">
                                            <a id="collapseThreeT" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed" aria-expanded="false">
                                                <span class="fa fa-money">ණය නිකුත්කිරීම හා අයකිරීම</span>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body bg-color">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <!--<h5>ණය නිකුත් කිරීමේ හා ආපසු ලබාගැනීමේ ක්‍රියා පටිපාටිය</h5>-->
                                                    <h5 class="panel-title">ණය අයකරගැනීමේ ආකාරයන් </h5>
                                                    <div class="panel panel-default bg-color">
                                                        <div class="panel-body">
                                                            <div class="form-group bg-top">
                                                                <div class="row">
                                                                    <label class="col-sm-6 input-sm"><input type="radio" name="c">වාරික මුදලින් අයකර ගැනීම</label>
                                                                    <div class="col-md-6">
                                                                        <label class="text-green input-sm">ගිණුම් අංකය :</label>                                                                                
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group bg-top">
                                                                <div class="row">
                                                                    <label class="col-sm-6 input-sm"><input type="radio" name="c">වාරිකය තැම්පත් ගිණුමකින් අයකරගැනීම </label>
                                                                    <div class="col-md-6">
                                                                        <div class="input-group">
                                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                            <span class="input-group-addon input-sm"><i class="fa fa-search"></i></span>
                                                                        </div>                                                                               
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group bg-top">
                                                                <div class="row">
                                                                    <label class="col-sm-6 input-sm text-red">සෑම මාසයකම ණය අයකරගැනීමේ දිනය </label>
                                                                    <div class="col-md-6">
                                                                        <input type="number" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <!--<h5>ණය නිකුත් කිරීමේ හා ආපසු ලබාගැනීමේ ක්‍රියා පටිපාටිය</h5>-->
                                                    <h5 class="panel-title">ණය නිකුත් කිරීමේ ආකාරයන් </h5>
                                                    <div class="panel panel-default bg-color">
                                                        <div class="panel-body">
                                                            <div class="form-group bg-top">
                                                                <div class="row">
                                                                    <label class="col-sm-6 input-sm"><input type="radio" name="d">ණය මුදලින් නිකුත් කිරීම </label>
                                                                    <div class="col-md-6">
                                                                        <label class="text-green input-sm">ගිණුම් අංකය :</label>                                                                                
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group bg-top">
                                                                <div class="row">
                                                                    <label class="col-sm-6 input-sm"><input type="radio" name="d">ණය මුදල වෙනත් ත්ම්පත් ගිණුමකට මාරු කිරීම </label>
                                                                    <div class="col-md-6">
                                                                        <div class="input-group">
                                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                            <span class="input-group-addon  input-sm"><i class="fa fa-search"></i></span>
                                                                        </div>                                                                               
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed btn btn-warning btn-sm" aria-expanded="false">Back</a>
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed btn btn-info btn-sm" aria-expanded="false">Next</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel box box-info bg-panel">
                                    <div class="box-header">
                                        <h4 class="box-title logo">
                                            <a id="collapseFourT" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed" aria-expanded="false">
                                                <span class="fa fa-book"> ලිපි ලේඛණ </span>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseFour" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body bg-color">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <table class="table table-bordered">
                                                        <tr>
                                                            <td>as</td>
                                                            <td>as</td>
                                                            <td>as</td>
                                                            <td>as</td>
                                                            <td>as</td>
                                                            <td>as</td>
                                                            <td>as</td>
                                                            <td>as</td>
                                                            <td>as</td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
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
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="col-md-4">
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed btn btn-warning btn-sm" aria-expanded="false">Back</a>
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive" class="collapsed btn btn-info btn-sm" aria-expanded="false">Next</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel box box-info bg-panel">
                                    <div class="box-header">
                                        <h4 class="box-title logo">
                                            <a id="collapseFiveT" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" class="collapsed" aria-expanded="false">
                                                <span class="fa fa-user">   පුද්ගල ඇපකරුවන්</span>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseFive" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body bg-color">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="box-body">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <table class="table table-bordered" style="margin-bottom: -9px">
                                                                    <tbody>
                                                                        <tr style="padding: 0px">
                                                                            <td style="padding: 0px;width: 150px" >
                                                                                <%
                                                                                    String accMifNumer = "";
                                                                                    String loanGarnterName = "";
                                                                                    if (request.getSession().getAttribute("garenterDetails") != null) {
                                                                                        List<String> garenterDetails = (List<String>) request.getSession().getAttribute("garenterDetails");
                                                                                        accMifNumer = Security.decrypt(garenterDetails.get(0).replace(" ", "+"));
                                                                                        loanGarnterName = Security.decrypt(garenterDetails.get(1).replace(" ", "+"));
                                                                                    }
                                                                                    request.getSession().removeAttribute("garenterDetails");
                                                                                %>

                                                                                <form class="form-horizontal" action="#" method="post" name="garenterDetailForm" id="garenterDetailForm" onsubmit="validateGaraenterDetails(this);
                                                                                        return false;">
                                                                                    <div class ="input-group">
                                                                                        <input type="hidden" name="accMifValue" id="accMifValue" value="loanMIFNumber" />
                                                                                        <input type="text" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="පා.ලි අංකය" id="accMifNumer" autocomplete="off" name="accMifNumer" value="<%=accMifNumer%>" onkeydown="accMIFCursorKeyDown(event)" style="font-size: 15px;font-weight: bold">
                                                                                        <span class="input-group-btn">
                                                                                            <button class="btn btn-info btn-flat btn-sm" type="submit"><i class="fa fa-search"></i></button>
                                                                                        </span>

                                                                                    </div>
                                                                                </form>
                                                                            </td>
                                                                            <td style="padding: 0px"><input type="text" data="validate" data-type="letterS  "class="form-control input-sm" id="loanGarnterName" name="loanGarnterName" value="<%=loanGarnterName%>" placeholder="නම" style="font-size: 15px;font-weight: bold"></td>
                                                                            <td style="padding: 0px;width: 150px">
                                                                                <select class="form-control input-sm convertSinhalaIskolaPotha" id="type" name="type">
                                                                                    <option value="Garrenter1">Garrenter 1</option>
                                                                                    <option value="Garrenter2">Garrenter 2</option>
                                                                                    <option value="Garrenter3">Garrenter 3</option>
                                                                                    <option value="Garrenter4">Garrenter 4</option>
                                                                                    <option value="Garrenter5">Garrenter 5</option>
                                                                                    <option value="Garrenter6">Garrenter 6</option>
                                                                                    <option value="Garrenter7">Garrenter 7</option>
                                                                                    <option value="Garrenter8">Garrenter 8</option>
                                                                                    <option value="Garrenter9">Garrenter 9</option>
                                                                                    <option value="Garrenter10">Garrenter 10</option>
                                                                                    <option value="Garrenter11">Garrenter 11</option>
                                                                                    <option value="Garrenter12">Garrenter 12</option>
                                                                                    <option value="Garrenter13">Garrenter 13</option>
                                                                                    <option value="Garrenter14">Garrenter 14</option>
                                                                                    <option value="Garrenter15">Garrenter 15</option>
                                                                                </select>
                                                                            </td>
                                                                            <td style="padding: 0px;width: 430px">
                                                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="remaks" name="remaks"/>
                                                                                <input type="hidden" class="form-control input-sm" id="indexNum" name="indexNum" value="-100"/>
                                                                            </td>
                                                                            <td style="padding: 0px;width: 10px">
                                                                                <input type="button" class="btn btn-sm" value="Add" id="addGarenter" name="addGarenter" onclick="onClickGarenterAdd()" />
                                                                            </td>
                                                                        </tr>
                                                                        <tr style="background-color: #00c0ef">
                                                                            <th class="text-center">පා.ලි අංකය</th>
                                                                            <th class="text-center">නම</th>
                                                                            <th class="text-center">Type</th>
                                                                            <th class="text-center" colspan="2">Remarks</th>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                                <div class="zTreeDemoBackground left">
                                                                    <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">
                                                                        <table id="garanterDetailsTable" class="table table-bordered" >
                                                                            <tbody>
                                                                                <%

                                                                                    if (request.getSession().getAttribute("gareterList") != null) {
                                                                                        List< List<String>> gareterList = (List< List<String>>) request.getSession().getAttribute("gareterList");
                                                                                        int i = 0;
                                                                                        for (List<String> list : gareterList) {
                                                                                %>
                                                                                <tr id="<%=i%>">
                                                                                    <td class="convertSinhalaIskolaPotha" style="width: 144px"><%=list.get(0)%></td>
                                                                                    <td class="convertSinhalaIskolaPotha"><%=list.get(1)%></td>
                                                                                    <td class="convertSinhalaIskolaPotha" style="width: 150px"><%=list.get(2)%></td>
                                                                                    <td class="convertSinhalaIskolaPotha" style="width: 380px"><%=list.get(3)%></td>
                                                                                    <td class="convertSinhalaIskolaPotha" style="width: 10px"><input type="button" name="selectGarenter" id="selectGarenter" value="Select" onclick="onClickGarenterSelect('<%=i%>')"/></td>
                                                                                </tr>
                                                                                <%
                                                                                            i++;
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
                                                    <form action="../NewBnkLonLoanGurantorServlet" method="post" name="savingDetailSubmitForm" onsubmit="validateGaraenterDetailsSubmit();
                                                            return false;">
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed btn btn-warning btn-sm" aria-expanded="false">Back</a>
                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="collapsed btn btn-info btn-sm" aria-expanded="false">Next</a>
                                                        <input type="hidden" id="nLonMFIDGarenter" name="nLonMFID" value="<%=nLonMFID%>"/>
                                                        <button class="btn btn-success btn-sm" type="submit">Save</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel box box-info bg-panel">
                                    <div class="box-header">
                                        <h4 class="box-title logo">
                                            <a id="collapseSixT"data-toggle="collapse" data-parent="#accordion" href="#collapseSix" class="collapsed" aria-expanded="false">
                                                <span class="fa fa-user">වෙනත් ඇප</span>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseSix" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                        <div class="box-body bg-color">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="nav-tabs-custom bg-color">
                                                        <ul class="nav nav-tabs">
                                                            <li class="active"><a href="#tab_1" data-toggle="tab">ස්ථිර තැම්පත් ණය </a></li>
                                                            <li><a href="#tab_2" data-toggle="tab">ඔප්පු ණය</a></li>                                                                    
                                                        </ul>
                                                        <div class="tab-content">
                                                            <div class="tab-pane active" id="tab_1">
                                                                <div class="row">
                                                                    <div class="col-md-12 ">
                                                                        <div class="form-group">
                                                                            <div class="row">
                                                                                <label class="col-sm-2 input-sm">ඔප්පුවේ නම  </label>
                                                                                <div class="col-md-4">                                                                                       
                                                                                    <div class="input-group">
                                                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                                        <span class="input-group-addon input-sm"><i class="fa fa-search"></i></span>
                                                                                    </div>
                                                                                </div> 
                                                                                <label class="col-sm-2 input-sm">වර්ගය </label>
                                                                                <label class="col-sm-4 input-sm">.......................</label>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-12 ">
                                                                        <div class="form-group bg-top">
                                                                            <div class="row">                                                                               
                                                                                <div class="col-md-6 btn-group">                                                                                       
                                                                                    <div class=" pull-right">
                                                                                        <button class="btn btn-success">පුද්ගල ඇපකරු 1</button>
                                                                                        <button class="btn btn-success">පුද්ගල ඇපකරු 2</button>
                                                                                    </div>
                                                                                </div> 
                                                                                <label class="col-sm-2 input-sm">නම </label>
                                                                                <label class="col-sm-4 input-sm">................................ </label>


                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-12 ">
                                                                        <div class="form-group bg-top">
                                                                            <div class="row">
                                                                                <label class="col-sm-4 input-sm pull-right">................................ </label>
                                                                                <label class="col-sm-2 input-sm pull-right">ශේෂය </label>
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                            <div class="tab-pane" id="tab_2">
                                                                <div class="row">                                                                    
                                                                    <div class="col-md-12">
                                                                        <div class="form-group">
                                                                            <div class="row">
                                                                                <label class="col-sm-1 input-sm">ඔප්පු අංකය </label>
                                                                                <div class="col-md-2">                                                                                       
                                                                                    <input type="text" data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                                </div>                                                                               
                                                                                <label class="col-sm-1 input-sm"> ලියාපදිංචි දිනය </label>
                                                                                <div class="col-md-2">                                                                                       
                                                                                    <input type="date" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                                </div>                                                                               
                                                                                <label class="col-sm-2 input-sm">උකස් වටිනාකම </label>
                                                                                <div class="col-md-4">                                                                                       
                                                                                    <input type="text" data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                                </div>                                                                               
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-12  bg-top">
                                                                        <div class="form-group">
                                                                            <div class="row">
                                                                                <label class="col-sm-1 input-sm">ඔප්පුවේ නම  </label>
                                                                                <div class="col-md-5">                                                                                       
                                                                                    <input type="text" data="validate" data-type="letterS" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                                </div>                                                                               

                                                                                <label class="col-sm-2 input-sm">උකස් නිදහස් කළ දිනය</label>
                                                                                <div class="col-md-4">                                                                                       
                                                                                    <input type="text" class="form-control input-sm convertSinhalaIskolaPotha">
                                                                                </div>                                                                               
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed btn btn-warning btn-sm" aria-expanded="false">Back</a>
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="collapsed btn btn-info btn-sm" aria-expanded="false">Next</a>
                                                    <a class="collapsed btn btn-success btn-sm" aria-expanded="false">Submit</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!--..................................page content............-->
            </aside>

            <input type="hidden" id="nLonTypeIDHid" name="nLonTypeIDHid" value="<%=nLonTypeIDHid%>"/>

            <input type="hidden" id="loanDetailsCheck" name="loanDetailsCheck" value="<%=loanDetailsCheck%>"/>

        </div>
        <div id="remove" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">හවුල්කරුවන්  ඉවත් කිරීම</h4>
                    </div>
                    <div class="modal-body">
                        <div class="panel-body">
                            <table class="table table-bordered">
                                <tr>
                                    <th class="text-center">පා .ලි .අංකය </th>
                                    <th class="text-center">නම </th>
                                    <th class="text-center"></th>
                                </tr>
                                <%
                                    if (request.getSession().getAttribute("aPatner") != null) {
                                        List patner = (List) request.getSession().getAttribute("aPatner");
                                        for (int i = 0; i < patner.size(); i++) {
                                            bnkCustomerMaster = (BnkCustomerMaster) patner.get(i);
                                %> 
                                <tr>
                                    <td ><%=bnkCustomerMaster.getCCIFNo()%></td>
                                    <td><%=bnkCustomerMaster.getCFullName()%></td>
                                    <td align="center"><button onclick="removePartner(this,<%=i%>)" class="btn btn-danger btn-xs">Delete</button></td>
                                </tr>
                                <%
                                        }
                                    }%>

                            </table>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </body>

    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    <script src="../js/bootbox.js" type="text/javascript"></script>
    <script src="../js/bootbox.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

    <script type="text/javascript">

                                        var nLonTypeIDHid = document.getElementById("nLonTypeIDHid").value;

                                        var loanDetailsCheck = document.getElementById("loanDetailsCheck").value;

                                        //-------- START RUN ----------
                                        $(document).ready(function () {
                                            $('#nLonTypeID').val(nLonTypeIDHid);

                                            if (loanDetailsCheck === "on") {
                                                document.getElementById("nLonTypeID").removeAttribute("disabled");
                                                document.getElementById("cLoanName").removeAttribute("disabled");
                                                document.getElementById("nLonDescriptionID").removeAttribute("disabled");
                                                document.getElementById("nLonFundSourceID").removeAttribute("disabled");
                                                document.getElementById("bJoint1").removeAttribute("disabled");
                                                document.getElementById("bJoint2").removeAttribute("disabled");
                                                document.getElementById("nLonStatusID").removeAttribute("disabled");
                                                document.getElementById("cLonAccountNo").removeAttribute("disabled");
                                                document.getElementById("nLedgerBookNo").removeAttribute("disabled");
                                                document.getElementById("cSerialNo").removeAttribute("disabled");
                                                document.getElementById("dApplyedDate").removeAttribute("disabled");
                                                document.getElementById("dApprovedDate").removeAttribute("disabled");
                                                document.getElementById("nApplyedAmount").removeAttribute("disabled");
                                                document.getElementById("nApprovedAmount").removeAttribute("disabled");
                                                document.getElementById("nInsuredAmount").removeAttribute("disabled");
                                                document.getElementById("nReservedAmount").removeAttribute("disabled");
                                                document.getElementById("nEffectiveInt").removeAttribute("disabled");
                                                document.getElementById("nPanaltyInt").removeAttribute("disabled");
                                                document.getElementById("cBoardApprovalNo").removeAttribute("disabled");
                                                document.getElementById("dBoardApprovalDate").removeAttribute("disabled");


                                                document.getElementById("nLonPeriodTypeID").removeAttribute("disabled");
                                                document.getElementById("nLonPeriod").removeAttribute("disabled");
                                                document.getElementById("nLonPaymentFreeTypeID").removeAttribute("disabled");
                                                document.getElementById("nLonPaymentFreeTime").removeAttribute("disabled");
                                                document.getElementById("dFirstInstallmentDate").removeAttribute("disabled");
                                                document.getElementById("dMaturityDate").removeAttribute("disabled");
                                                document.getElementById("nLonDeductTypeID").removeAttribute("disabled");
                                                document.getElementById("nLonGrpID").removeAttribute("disabled");
                                                document.getElementById("nFixedInterestValue").removeAttribute("disabled");
                                                document.getElementById("nLonInstallmentPayTypeID").removeAttribute("disabled");
                                                document.getElementById("nLonInstallmentPayTime").removeAttribute("disabled");
                                                document.getElementById("nInstallmentAmount").removeAttribute("disabled");
                                                document.getElementById("nInstallmentAmountAdj").removeAttribute("disabled");
                                                document.getElementById("nInstallmentAmountLast").removeAttribute("disabled");
                                                document.getElementById("nDueDaysAfter").removeAttribute("disabled");
                                                document.getElementById("nDeductDay").removeAttribute("disabled");

                                                document.getElementById("nIssuedAmount").removeAttribute("disabled");
                                                document.getElementById("nBalanceToIssue").removeAttribute("disabled");
                                                document.getElementById("nTotRecvCapital").removeAttribute("disabled");
                                                document.getElementById("nTotRecvInstallment").removeAttribute("disabled");
                                                document.getElementById("nShouldRecvCapital").removeAttribute("disabled");
                                                document.getElementById("nShouldRecvInstallment").removeAttribute("disabled");
                                                document.getElementById("nTotRecvInterest").removeAttribute("disabled");
                                                document.getElementById("nShouldRecvInterest").removeAttribute("disabled");
                                                document.getElementById("nLonBalanceAmount").removeAttribute("disabled");
                                                document.getElementById("nLonBalanceInstallment").removeAttribute("disabled");
                                                document.getElementById("dLastCapitalPayDate").removeAttribute("disabled");
                                                document.getElementById("dLastIntPayDate").removeAttribute("disabled");
                                                document.getElementById("nToDateDueCapital").removeAttribute("disabled");
                                                document.getElementById("nToDateDueInstallment").removeAttribute("disabled");
                                                document.getElementById("nToDateIntValueRound").removeAttribute("disabled");
                                                document.getElementById("nToDateTotIntersest").removeAttribute("disabled");

                                                document.getElementById("saveBtn1").removeAttribute("disabled");

                                                $("input[type='radio']:not(.simple)").iCheck({
                                                    radioClass: 'iradio_minimal'
                                                });
                                            }
                                        });

                                        $(document).ready(function () {
                                            var saveType = <%=saveType%>;
                                            if (saveType == "1") {
                                                $('#collapseOneT').click();
                                            } else if (saveType == "2") {
                                                $('#collapseTwoT').click();
                                            } else if (saveType == "3") {
                                                $('#collapseThreeT').click();
                                            } else if (saveType == "4") {
                                                $('#collapseFourT').click();
                                            } else if (saveType == "5") {
                                                $('#collapseFiveT').click();
                                            } else {
                                                $('#collapseSixT').click();
                                            }
                                        });
                                        //------- START RUN ------------

                                        //---------ON CHANGE ----------
                                        function onChangeAccType() {
                                            var nLonTypeID = document.getElementById("nLonTypeID").value;
                                            window.location = "../LoanDetailsServlet?nLonTypeID=" + nLonTypeID;
                                        }

                                        function onChangeNLPTypeIDLabel() {
                                            var nLonPeriodTypeID = document.getElementById("nLonPeriodTypeID").value;
                                            var nLonPeriod = document.getElementById("nLonPeriod").value;
                                            var nLPTypeIDLabel = document.getElementById("nLPTypeIDLabel");

                                            if (nLonPeriod !== "") {
                                                if (nLonPeriodTypeID === "3") {
                                                    nLPTypeIDLabel.innerHTML = parseInt(nLonPeriod) * 7;
                                                } else if (nLonPeriodTypeID === "4") {
                                                    nLPTypeIDLabel.innerHTML = parseInt(nLonPeriod) * 30;
                                                } else if (nLonPeriodTypeID === "5") {
                                                    nLPTypeIDLabel.innerHTML = parseInt(nLonPeriod) * 364;
                                                } else {
                                                    nLPTypeIDLabel.innerHTML = parseInt(nLonPeriod) * 1;
                                                }
                                            }
                                        }

                                        function onChangeNLPFTypeIDLabel() {
                                            var nLonPaymentFreeTypeID = document.getElementById("nLonPaymentFreeTypeID").value;
                                            var nLonPaymentFreeTime = document.getElementById("nLonPaymentFreeTime").value;
                                            var nLPFTypeIDLabel = document.getElementById("nLPFTypeIDLabel");

                                            if (nLonPaymentFreeTime !== "") {
                                                if (nLonPaymentFreeTypeID === "3") {
                                                    nLPFTypeIDLabel.innerHTML = parseInt(nLonPaymentFreeTime) * 7;
                                                } else if (nLonPaymentFreeTypeID === "4") {
                                                    nLPFTypeIDLabel.innerHTML = parseInt(nLonPaymentFreeTime) * 30;
                                                } else if (nLonPaymentFreeTypeID === "5") {
                                                    nLPFTypeIDLabel.innerHTML = parseInt(nLonPaymentFreeTime) * 364;
                                                } else {
                                                    nLPFTypeIDLabel.innerHTML = parseInt(nLonPaymentFreeTime) * 1;
                                                }
                                            }
                                        }

                                        function onChahgeNLIPTypeIDLabel() {
                                            var nLonInstallmentPayTypeID = document.getElementById("nLonInstallmentPayTypeID").value;
                                            var nLonInstallmentPayTime = document.getElementById("nLonInstallmentPayTime").value;
                                            var nLIPTypeIDLabel = document.getElementById("nLIPTypeIDLabel");

                                            if (nLonInstallmentPayTime !== "") {
                                                if (nLonInstallmentPayTypeID === "3") {
                                                    nLIPTypeIDLabel.innerHTML = parseInt(nLonInstallmentPayTime) * 7;
                                                } else if (nLonInstallmentPayTypeID === "4") {
                                                    nLIPTypeIDLabel.innerHTML = parseInt(nLonInstallmentPayTime) * 30;
                                                } else if (nLonInstallmentPayTypeID === "5") {
                                                    nLIPTypeIDLabel.innerHTML = parseInt(nLonInstallmentPayTime) * 364;
                                                } else {
                                                    nLIPTypeIDLabel.innerHTML = parseInt(nLonInstallmentPayTime) * 1;
                                                }
                                            }
                                        }
                                        //---------ON CHANGE ----------

                                        //--------KEY DOUWN------------
                                        function accMIFCursorKeyDown(e) {
                                            if (!e)
                                                e = window.event;

                                            var accMifNumer = document.getElementById("accMifNumer");
                                            var accMifValue = document.getElementById("accMifValue");

                                            switch (e.keyCode)
                                            {
                                                case 38:
                                                    if (accMifNumer.getAttribute("placeholder") === "පා.ලි අංකය") {
                                                        accMifNumer.setAttribute("placeholder", "ගිණුම් අංකය");
                                                        accMifValue.value = "loanAccNumber";
                                                    } else {
                                                        accMifNumer.setAttribute("placeholder", "පා.ලි අංකය");
                                                        accMifValue.value = "loanMIFNumber";
                                                    }
                                                    break;
                                                case 40:
                                                    if (accMifNumer.getAttribute("placeholder") === "පා.ලි අංකය") {
                                                        accMifNumer.setAttribute("placeholder", "ගිණුම් අංකය");
                                                        accMifValue.value = "loanAccNumber";
                                                    } else {
                                                        accMifNumer.setAttribute("placeholder", "පා.ලි අංකය");
                                                        accMifValue.value = "loanMIFNumber";
                                                    }
                                                    break;
                                            }
                                        }
                                        //--------KEY DOUWN-------------

                                        //-------------ONKEY UP---------
                                        function changeAccountNumber() {
                                            var aN = document.getElementById("accountNumber").value;
                                            aN = setAccountNumber(aN);
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
                                        //-------------ONKEY UP----------

                                        //----------ON CLICK ------------
                                        function onClickGarenterAdd() {
                                            var accMifNumer = document.getElementById("accMifNumer").value;
                                            var loanGarnterName = document.getElementById("loanGarnterName").value;
                                            var type = document.getElementById("type").value;
                                            var remaks = document.getElementById("remaks").value;
                                            var indexNum = document.getElementById("indexNum").value;

                                            if (accMifNumer === "" || loanGarnterName === "" || remaks === "") {
                                                alert("please search MIF number or account Number");
                                            } else {
                                                window.location = "../NewBnkLonLoanGurantorServlet?indexNum=" + indexNum + "&aM=" + accMifNumer + "&lgn=" + loanGarnterName + "&type=" + type + "&rks=" + remaks;
                                            }
                                        }

                                        function onClickGarenterSelect(index) {
                                            var accMifNumer = document.getElementById("accMifNumer");
                                            var loanGarnterName = document.getElementById("loanGarnterName");
                                            var type = document.getElementById("type");
                                            var remaks = document.getElementById("remaks");
                                            var indexNum = document.getElementById("indexNum");

                                            var trId = document.getElementById(index);
                                            accMifNumer.value = trId.cells[0].innerHTML;
                                            loanGarnterName.value = trId.cells[1].innerHTML;
                                            type.value = trId.cells[2].innerHTML;
                                            remaks.value = trId.cells[3].innerHTML;
                                            indexNum.value = index;
                                        }
                                        //----------ON CLICK ------------


                                        //-------SUBMIT FORM-------------
                                        function validateGetAccountNo(accForm) {
                                            var aN = document.getElementById("accountNumber").value;
                                            aN = setAccountNumber(aN);
                                            if (!isNaN(aN)) {
                                                document.forms["accForm"].submit();
                                            } else {
                                                bootbox.alert("<b>පා.ලි අංකය වැරදි.</b>", function () {
                                                });
                                            }
                                        }

                                        function validateNewLoanDetails() {
                                            document.forms["savingDetailForm"].submit();
                                        }

                                        function validateGaraenterDetails() {
                                            var accMifValue = document.getElementById("accMifValue").value;
                                            var garenterDetailForm = document.getElementById("garenterDetailForm");
                                            if (accMifValue === "loanAccNumber") {
                                                garenterDetailForm.setAttribute("action", "view_depositmaster.jsp?tellerIndexKey=loanGarnter");
                                            } else {
                                                garenterDetailForm.setAttribute("action", "view_customers.jsp?tellerIndexKey=loanGarnter");
                                            }
                                            document.forms["garenterDetailForm"].submit();
                                        }

                                        function validateGaraenterDetailsSubmit() {
                                            document.forms["savingDetailSubmitForm"].submit();
                                        }

                                        function removePartner(r, e) {
                                            alert("ඔබ මෙය අනුමත කරන්වාද ?");
                                            $.get("../LoanPatnerDetailsServlet?delete=" + e, function (data) {
                                                $(r).closest('tr').css('background-color', '#fcd0d0');
                                                alert(data);
                                            });
                                        }
                                        $('#remove').on('hidden.bs.modal', function () {
                                            location.reload();
                                        });
                                        //-------SUBMIT FORM-------------

        <%
            if (request.getSession().getAttribute("aPatner") != null) {
                List arry = (List) request.getSession().getAttribute("aPatner");
                if (arry.size() != 0) {
        %>
                                        $('#btnRemove').removeAttr("disabled");
        <%
                }
            }
        %>
    </script>
    script
</html>

