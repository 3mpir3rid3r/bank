<%-- 
    Document   : pawning_master
    Created on : Dec 10, 2014, 5:58:44 PM
    Author     : nuwan
--%>

<%@page import="com.nbs.model.BnkDepDepositMaster"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.nbs.common.Alerts"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkPwnRefCarateValues"%>
<%@page import="com.nbs.model.BnkPwnRefArticls"%>
<%@page import="com.nbs.model.BnkPwnPawnMaster"%>
<%@page import="com.nbs.common.CrDrTable"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="java.util.AbstractList"%>
<%@page import="com.nbs.model.BnkPwnPawnTypes"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.controller.pawning.save.PawningMasterServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <Title>උකස් තොරතුරු </Title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
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

            .bg-color{
                background-color: #e7f0f7;
            }
            .bg-top{
                margin-top: -10px;                
            }.bg-top1{
                margin-top: -15px;     
            }
            /*   }
              .bg-searchheight{
                  height:222px;                
              }
              .bg-pad{
                  padding-right:0px;                
              }*/

            .overlay {
                visibility: hidden;
                position: absolute;
                left: 0px;
                top: -35px;
                width:100%;
                height:100%;
                text-align:center;
                z-index: 1000;
            }
            .overlay2 {
                visibility: hidden;
                position: absolute;
                left: 150px;
                top: -125px;
                width:20%;
                height:100%;
                text-align:center;
                z-index: 1000;  
            }
            .overlay1 {
                visibility: hidden;
                position: absolute;
                left: 445px;
                top: 220px;
                width:50%;
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
            #content *{
                font-size-adjust: 0.52;
            }
            tr {
                cursor: pointer;
            }
        </style>

        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/my.js" type="text/javascript"></script>
        <script src="../js/bootbox.js" type="text/javascript"></script>
        <script src="../js/bootbox.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery.form.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            var call = 0;

        </script>
    </head> 
    <body class="skin-blue  pace-done fixed">
        <%    String alert = "";

            if (request.getParameter("mg") != null) {
                String mg = request.getParameter("mg");
                if ("error".equals(mg)) {
                    alert = Alerts.warningAlert("Something Wrong", "You miss some Fields", "");
                } else if ("saved".equals(mg)) {
                    alert = Alerts.successAlert("success", "Successfully saved");
                } else if ("updated".equals(mg)) {
                    alert = Alerts.successAlert("success", "Customer Successfully updated");
                }
            }
        %>
        <!--header-->
        <%@include file="pawning_header.jsp" %>
        <!------------------------->

        <!--.............................header End......................-->
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="pawning_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->
            <aside id="content" class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        උකස් අත්තිකරම්
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">උකස් අත්තිකරම්</li>
                    </ol>
                </section>
                <%  Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String currentDate = sdf.format(date);

                    String cNICNo = "";
                    String dNICIssuedDate = null;
                    String cFullName = "";
                    String cPAddLine1 = "";
                    String cPAddLine2 = "";
                    String cPAddLine3 = "";
                    String cPAddLine4 = "";
                    String cPTelNo1 = "";
                    String cBTelNo1 = "";
                    String cPEmail = "";

                    String cReceiptNo = "";
                    int nPwnDescriptionID = 0;
                    short nPwnPeriodTypeID = 0;

                    int nPwnPeriod = 0;
                    String nTotWgtArt = "";
                    String nTotWgtGold = "";
                    String nTotMkrtValue = "";
                    String nAgreedInt = "";
                    String nOneGramAssessedValue = "";
                    String nTotAdvAmount = "";

                    String nActualInt = "";
                    String nBalAmount = "";
                    String cRemrks = "";
                    String v_dMaturityDate = null;
                    String lastPayDate = null;
                    boolean isChecked = true;
                    double nTotAssessedValue = 0;
                    int pwnTypeId = 0;

                    if (request.getSession().getAttribute("iddetail") != null) {
                        BnkPwnPawnMaster pawnMaster = (BnkPwnPawnMaster) request.getSession().getAttribute("iddetail");
                        if (pawnMaster != null) {

                            cNICNo = pawnMaster.getCIDNo();
                            if (pawnMaster.getDIssueDate() != null) {
                                dNICIssuedDate = sdf.format(pawnMaster.getDIssueDate());
                            }
                            cFullName = pawnMaster.getCFullName();
                            cPAddLine1 = pawnMaster.getCPAddLine1();
                            cPAddLine2 = pawnMaster.getCPAddLine2();
                            cPAddLine3 = pawnMaster.getCPAddLine3();
                            cPAddLine4 = pawnMaster.getCPAddLine4();
                            cPTelNo1 = pawnMaster.getCPTelNo1();
                            cBTelNo1 = pawnMaster.getCPTelNo1();

                            if (pawnMaster.getNTotWgtArt() != null && pawnMaster.getNTotWgtArt().doubleValue() != 0.0) {
                                nTotWgtArt = pawnMaster.getNTotWgtArt().toString();
                            }

                            if (pawnMaster.getNTotWgtGold() != null && pawnMaster.getNTotWgtGold().doubleValue() != 0.0) {
                                nTotWgtGold = pawnMaster.getNTotWgtGold().toString();
                            }
                            if (pawnMaster.getCReceiptNo() != null) {
                                cReceiptNo = pawnMaster.getCReceiptNo();
                            }
                            if (pawnMaster.getNPwnDescriptionID() != null) {
                                nPwnDescriptionID = pawnMaster.getNPwnDescriptionID();
                            }
                            if (pawnMaster.getNPwnPeriodTypeID() != null) {
                                nPwnPeriodTypeID = pawnMaster.getNPwnPeriodTypeID();
                            }
                            if (pawnMaster.getNPwnPeriod() != null) {
                                nPwnPeriod = pawnMaster.getNPwnPeriod();
                            }

                            if (pawnMaster.getNTotMkrtValue() != null && pawnMaster.getNTotMkrtValue().doubleValue() != 0.0) {
                                nTotMkrtValue = pawnMaster.getNTotMkrtValue().toString();
                            }
                            if (pawnMaster.getNOneGramAssessedValue() != null && pawnMaster.getNOneGramAssessedValue().doubleValue() != 0.0) {
                                nOneGramAssessedValue = pawnMaster.getNOneGramAssessedValue().toString();
                            }
                            if (pawnMaster.getNEffectiveInt() != null && pawnMaster.getNEffectiveInt().doubleValue() != 0.0) {
                                nAgreedInt = pawnMaster.getNEffectiveInt().toString();
                            }
                            if (pawnMaster.getNPwnAdvancedIssued() != null && pawnMaster.getNPwnAdvancedIssued().doubleValue() != 0.0) {
                                nTotAdvAmount = pawnMaster.getNPwnAdvancedIssued().toString();
                            }
                            if (pawnMaster.getNActualInt() != null && pawnMaster.getNActualInt().doubleValue() != 0.0) {
                                nActualInt = pawnMaster.getNActualInt().toString();
                            }
                            if (pawnMaster.getNPwnBalanceAmount() != null && pawnMaster.getNPwnBalanceAmount().doubleValue() != 0.0) {
                                nBalAmount = pawnMaster.getNPwnBalanceAmount().toString();
                            }
                            if (pawnMaster.getDLastIntPayDate() != null) {
                                lastPayDate = sdf.format(pawnMaster.getDLastIntPayDate());
                            }
                            if (pawnMaster.getDMaturityDate() != null) {
                                v_dMaturityDate = sdf.format(pawnMaster.getDMaturityDate());
                            }
                            if (cRemrks != null) {
                                cRemrks = pawnMaster.getCRemrks();
                            }
                            if (pawnMaster.getBOldPawn() != null) {
                                isChecked = pawnMaster.getBOldPawn();
                            }
                            if (Integer.toString(pawnMaster.getNPwnTypeID()) != null) {
                                pwnTypeId = pawnMaster.getNPwnTypeID();
                            }
                            if (pawnMaster.getNTotWgtGold() != null && pawnMaster.getNTotWgtGold().doubleValue() != 0.0 && pawnMaster.getNOneGramAssessedValue() != null && pawnMaster.getNOneGramAssessedValue().doubleValue() != 0.0) {
                                nTotAssessedValue = pawnMaster.getNTotWgtGold().doubleValue() * pawnMaster.getNOneGramAssessedValue().doubleValue();
                            }
                        }
                    } else if (request.getSession().getAttribute("depositCustomer") != null) {
//                        request.getSession().removeAttribute("iddetail");
//                        BnkCustomerMaster bcm = (BnkCustomerMaster) request.getSession().getAttribute("depositCustomer");
//                        if (bcm != null) {
//                            cNICNo = bcm.getCNICNo();
////                           
//                            if( bcm.getDNICIssuedDate()!=null){
//                                dNICIssuedDate = bcm.getDNICIssuedDate().toString();
//                            }
//                            cPAddLine1 = bcm.getCPAddLine1();
//                            cPAddLine2 = bcm.getCPAddLine2();
//                            cPAddLine3 = bcm.getCPAddLine3();
//                            cPAddLine4 = bcm.getCPAddLine4();
//                            cPTelNo1 = bcm.getCPTelNo1();
//                            cBTelNo1 = bcm.getCPTelNo2();
//                            cFullName = bcm.getCFullName();
//                       }
//                        request.getSession().removeAttribute("depositCustomer");
                    }

                %>
                <%= alert%>
                <section class="content">
                    <div class="row bg-searchheight bg-top">
                        <div class="col-md-12 bg-searchheight bg-pad" >
                            <form action="../PawningMasterServlet?key=0" method="post" name="ff" onsubmit="accept(this);
                                    return true">
                                <input type="hidden" value="0" id="tAdd" name="tAdd">
                                <div class="row" >
                                    <div class="col-md-12 bg-pad"  >
                                        <div class="col-lg-12" style="margin-left: -15px;">
                                            <div class="box box-success bg-color">
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="form-group bg-top1">
                                                            <div class="col-lg-2">
                                                                <label  class="control-label" id="fontSize"></label><br>

                                                                <%if (isChecked) {%>
                                                                <label class="radio-inline"> <input type="radio" name="PWN" checked="" id="newPwn" onchange="disableDate()"> නව</label>
                                                                <label class="radio-inline  pull-right"><input type="radio" name="PWN" id="oldPwn" onchange="disableDate()"> පැරණි</label>
                                                                    <%} else {%>
                                                                <label class="radio-inline"> <input type="radio" name="PWN" checked="" id="newPwn" onchange="disableDate()"> නව</label>
                                                                <label class="radio-inline  pull-right"><input type="radio" checked name="PWN" id="oldPwn" onchange="disableDate()"> පැරණි</label>
                                                                    <%}%>
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <label  class="control-label" id="fontSize"></label>
                                                                <select required="" class="form-control input-sm" id="BnkPwnPawnTypesID" name="BnkPwnPawnTypesID">
                                                                    <option value="" style="display:none;"></option>

                                                                    <% List<BnkPwnPawnTypes> list = (List<BnkPwnPawnTypes>) request.getSession().getAttribute("pawntypecombo");
                                                                        if (list != null) {
                                                                            for (BnkPwnPawnTypes b : list) {

                                                                                if (pwnTypeId == b.getNPawnTypeID()) {


                                                                    %>
                                                                    <option selected class="convertSinhalaIskolaPotha" value="<%=b.getNPawnTypeID()%>"><%=b.getCPawnType()%></option>
                                                                    <% } else {
                                                                    %>
                                                                    <option  class="convertSinhalaIskolaPotha" value="<%=b.getNPawnTypeID()%>"><%=b.getCPawnType()%></option>

                                                                    <% }
                                                                            }
                                                                        }%>  
                                                                </select>
                                                            </div>
                                                            <div class="col-lg-4">
                                                                <label  class="control-label" id="fontSize"></label>
                                                                <input class="form-control input-sm convertSinhalaIskolaPotha" placeholder="උකස් කුයිතාන්සි අංකය" type="text" disabled="">
                                                            </div><div class="col-lg-3">
                                                                <label  class="control-label" id="fontSize"></label>
                                                                <input class="form-control input-sm convertSinhalaIskolaPotha" type="date" value="<%= session.getAttribute("storeLoggedDate")%>" name="currentDate" id="currentDate">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>          
                                        <!--old pwing find dialog-->   
                                        <!--data fill ajax-->
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
                                                            <button type="button" onclick="overlayHide()" class="">Back</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>         

                                        <!--end old pwning find-->    

                                        <!--find B'day-->
                                        <div class="overlay2 " id="overlay2" >
                                            <div class="overlayDiv">
                                                <div id="loadBday">

                                                </div>
                                            </div>
                                        </div>
                                        <!--b'day end-->
                                        <!-------------------------------------->
                                        <!--******************************************-->
                                        <div class="col-md-9 bg-pad bg-top" style="margin-left: -15px;">
                                            <div class="box box-info bg-color">
                                                <div class="box-body">
                                                    <div class="row">
                                                        <!--<div class="col-md-9">-->
                                                        <div class="form-group">
                                                            <label  id="lbl" class="col-sm-2 input-sm text-right"  >ජා.හැ.අංකය :</label>
                                                            <input type="hidden" value="1" id="lblChangName"/>
                                                            <div class="col-sm-4">
                                                                <div class="input-group">
                                                                    <input autocomplete="off" required class="form-control input-sm text-right convertSinhalaIskolaPotha" onkeydown="findDetails(event);
                                                                            searchTypeChanger();" placeholder="ජා.හැ.අංකය" type="text" maxlength="10" id="cNICNo" name="cNICNo"  value="<%=cNICNo%>" >
                                                                    <span class="input-group-btn">
                                                                        <button class="btn btn-info btn-flat btn-sm" type="button" onclick="idSearch(event)"><i class="fa fa-search"></i></button>
                                                                        <button class="btn-sm btn-success btn-flat btn" type="button" onclick="getBirthDay();">B'day</button>

                                                                    </span>
                                                                </div>
                                                            </div>
                                                            <label class="col-sm-2 input-sm text-right">නිකුත්කළ දිනය :</label>
                                                            <div class="col-md-4">
                                                                <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" name="dNICIssuedDate" id="dNICIssuedDate" placeholder="නිකුත් කළ දිනය" value="<%=dNICIssuedDate%>"/>
                                                            </div>
                                                        </div><br>
                                                        <div class="form-group">
                                                            <label class="col-sm-2 input-sm text-right">සම්පූර්ණ නම :</label>                                                                                                                           
                                                            <div class="col-md-10">
                                                                <input  required type="text" class="form-control input-sm convertSinhalaIskolaPotha" id="cFullName" name="cFullName" placeholder="සම්පූර්ණ නම" value="<%=cFullName%>"/>
                                                            </div>
                                                        </div><br>  
                                                        <div class="form-group">
                                                            <label class="col-sm-2 input-sm text-right">ලිපිනය 1 :</label>
                                                            <div class="col-md-4">
                                                                <input  required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" id="cPAddLine1" name="cPAddLine1" placeholder="ලිපිනය 1" value="<%=cPAddLine1%>"/>
                                                            </div> 
                                                            <label class="col-sm-2 input-sm text-right">ලිපිනය 2 :</label>
                                                            <div class="col-md-4">
                                                                <input  type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" id="cPAddLine2" name="cPAddLine2" placeholder="ලිපිනය 2" value="<%=cPAddLine2%>"/>
                                                            </div> 
                                                        </div> <br> 
                                                        <div class="form-group">
                                                            <label class="col-sm-2 input-sm text-right">ලිපිනය 3 :</label>
                                                            <div class="col-md-4">
                                                                <input  type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" id="cPAddLine3" name="cPAddLine3" placeholder="ලිපිනය 3" value="<%=cPAddLine3%>"/>
                                                            </div> 
                                                            <label class="col-sm-2 input-sm text-right">ලිපිනය 4 :</label>
                                                            <div class="col-md-4">
                                                                <input  type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" id="cPAddLine4" name="cPAddLine4" placeholder="ලිපිනය 4" value="<%=cPAddLine4%>"/>
                                                            </div> 
                                                        </div> <br> 
                                                        <div class="form-group">
                                                            <label class="col-sm-2 input-sm text-right">දුරකතන අංකය 1 :</label>
                                                            <div class="col-md-4">
                                                                <input required type="text" class="form-control input-sm col-lg-6 convertSinhalaIskolaPotha " id="cPTelNo1" maxlength="10"  min="0"  name="cPTelNo1"  placeholder="දුරකතන අංකය 1" value="<%=cPTelNo1%>" data="number" data-type="number"/>
                                                            </div> 
                                                            <label class="col-sm-2 input-sm text-right">දුරකතන අංකය 2 :</label>
                                                            <div class="col-md-4">
                                                                <input type="text" class="form-control input-sm col-lg-6 convertSinhalaIskolaPotha " id="cBTelNo1" maxlength="10"  min="0" name="cBTelNo1"  placeholder="දුරකතන අංකය 2" value="<%=cBTelNo1%>" data="number" data-type="number" />
                                                            </div> 
                                                        </div> 
                                                    </div>
                                                </div>  
                                            </div>
                                        </div>
                                        <!--select other details-->
                                        <!--===============================-->
                                        <div class="overlay1 " id="overlay1">
                                            <div>
                                                <div  class="overlayDiv" >
                                                    <div id="tblrw"></div>

                                                    <div class="col-sm-12">
                                                        <div class="form-group" >
                                                            <label class="col-sm-3 input-sm text-right" style="padding-left: 3px;"> New Pawn Reason :</label>
                                                            <div class="col-md-9">
                                                                <input type="text" class="form-control input-sm col-lg-4 convertSinhalaAmali" id="pwnReasonSin" name="pwnReasonSin"  value="<%=cPAddLine4%>"/>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="form-group" >
                                                            <label class="col-sm-3 input-sm text-right" style="padding-left: 3px;">Pawn Reason(Eng) :</label>
                                                            <div class="col-md-9">
                                                                <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" id="pwnReasoneng" name="pwnReasoneng"  value="<%=cPAddLine4%>"/>
                                                            </div>
                                                        </div>
                                                        <br>
                                                    </div>  
                                                    <div class="col-sm-12">
                                                        <div style="" align="right" class="form-group col-sm-12">
                                                            <div class="col-lg-8"></div>
                                                            <button type="button" onclick="saveNewReason();" class=" btn-success col-sm-2">Save</button>
                                                            <button type="button" onclick="overlay1Hide()" class="btn-default col-sm-2">Cancel</button>
                                                        </div>
                                                    </div>
                                                    <br><br><br><br><br>
                                                </div>
                                            </div>

                                        </div>                   

                                        <!--..................................................-->
                                        <div class="col-md-3 bg-top" style=" height:190px">
                                            <div class="box box-info bg-color" style=" height:195px">
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <!--<canvas id="canvas" style="width: 120px;height: 130px"></canvas>-->
                                                            <center>
                                                                <img id="userImage" class="img-thumbnail" src="../images/icon-user-default.png" style="width: 170px;height: 150px">
                                                            </center>
                                                        </div>
                                                    </div>
                                                </div><!-- /.box-body -->
                                            </div>
                                        </div>

                                        <div class="col-md-12 bg-top" style=" height:190px; ">

                                            <div class="box box-info bg-color" style=" height:180px; margin-left: -15px">
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <table id="dataTable" class="  table-bordered table-hover text-center col-lg-12">
                                                                <thead style="background-color: #005888">
                                                                    <tr>
                                                                        <th style="color: #e7f0f7" class="text-center input-sm">උකස් භාණ්ඩ</th>
                                                                        <th style="color: #e7f0f7" class="text-center input-sm">කැරට් අගය</th>
                                                                        <th style="color: #e7f0f7;width: 10px" class="text-center input-sm">ප්‍රමානය</th>
                                                                        <th style="color: #e7f0f7" class="text-center input-sm">වෙනත්</th>
                                                                        <th style="color: #e7f0f7" class="text-center input-sm"></th>
                                                                        <th style="color: #e7f0f7" class="text-center input-sm"></th>

                                                                    </tr>
                                                                </thead>

                                                                <tr>
                                                                    <th>
                                                                        <select class="form-control input-sm" name="col1" id="col1">
                                                                            <option>- Select -</option>
                                                                            <% List<BnkPwnRefArticls> list2 = (List<BnkPwnRefArticls>) request.getSession().getAttribute("RefArticlcombo");
                                                                                if (list != null) {
                                                                                    for (BnkPwnRefArticls b : list2) {
                                                                            %>
                                                                            <option class="convertSinhalaIskolaPotha" value="<%=b.getNPwnRefArticlID()%>"><%=b.getCPwnArticlName()%></option>
                                                                            <%}
                                                                                }%>
                                                                        </select>
                                                                    </th>
                                                                    <th>
                                                                        <select class="form-control input-sm" name="col2" id="col2">
                                                                            <option>- Select -</option>
                                                                            <% List<BnkPwnRefCarateValues> list3 = (List<BnkPwnRefCarateValues>) request.getSession().getAttribute("RefCarateValuescombo");
                                                                                if (list != null) {
                                                                                    for (BnkPwnRefCarateValues b : list3) {
                                                                            %>
                                                                            <option class="convertSinhalaIskolaPotha" value="<%=b.getNPwnCaratValID()%>"><%=b.getCCaratType()%></option>
                                                                            <%}
                                                                                }%>
                                                                        </select>
                                                                    </th>
                                                                    <th> <input type="text" class="form-control input-sm col-lg-6 input-sm convertSinhalaIskolaPotha number" name="col3" id="col3" data="number" data-type="number"/></th>
                                                                    <th> 
                                                                        <!--                                                            <div class="input-group">-->
                                                                        <input type="text" class="form-control input-sm col-lg-6 input-sm convertSinhalaIskolaPotha"  onkeypress="enterSubmit(event)" name="col4" id="col4"/>
                                                                        <!--<th><span class="input-group-btn">-->
                                                                    <th width="10px">  <button class="btn btn-info btn-sm" type="button" onclick="overlay1();"><i class="fa fa-plus"></i>වෙනත්</button>
                                                                        <!--</span>-->
                                                                    </th>
                                                                    <th width="10px">  <button class="btn btn-info btn-sm" type="button" onclick="addTable();
                                                                            checkTableData();"><i class="fa fa-plus"></i></button>
                                                                        <!--</span>-->
                                                                    </th>
                                                                    <!--</div>-->

                                                                </tr>

                                                                <tbody  >
                                                                    <%
                                                                        if (request.getSession().getAttribute("tlist") != null) {
                                                                            List<CrDrTable> cdts = (List<CrDrTable>) request.getSession().getAttribute("tlist");
                                                                            for (CrDrTable l : cdts) {
                                                                    %>
                                                                    <tr>
                                                                        <td class="convertSinhalaIskolaPotha"><%=l.getRow1()%></td>
                                                                        <td class="convertSinhalaIskolaPotha"><%=l.getRow2()%></td>
                                                                        <td class="convertSinhalaIskolaPotha"><%=l.getRow3()%></td>
                                                                        <td class="convertSinhalaIskolaPotha" ><%=l.getRow4()%></td>
                                                                        <td class="convertSinhalaIskolaPotha" ></td>
                                                                        <td width="10px"><a href="../PawningMasterServlet?key=delete&did=<%=l.getId()%>" class="btn btn-danger btn-sm"><i class="fa fa-minus"></i></a></td>
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
                                    </div>
                                    <!--...........................................-->

                                </div>

                                <!--------------------------------------->
                                <!--<div class="col-md-12" style="margin-left: -15px; width: " >-->
                                <div id="alertDialogs"></div>
                                <div style="margin-left: 15px;">
                                    <div class="box box-info bg-color" style="margin-left: -15px;">
                                        <div class="box-body" id="setSizeDiv">
                                            <div class="row">

                                                <div id="hiddenDataDiv1" class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">භාණ්ඩ බර :</label>
                                                    <div class="col-md-4">
                                                        <input required  type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="භාණ්ඩ බර" name="nTotWgtArt" value="<%= nTotWgtArt%>" id="nTotWgtArt" onkeyup="setTotWeightGold();
                                                                checkTableData();" onclick="setTotWeightGold();
                                                                        checkTableData();"  data="number" data-type="weight"/>
                                                    </div> 
                                                    <label class="col-sm-2 input-sm text-right">ශුද්ධ රන් බර :</label>
                                                    <div class="col-md-4">
                                                        <input required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="ශුද්ධ රන් බර" value="<%= nTotWgtGold%>" name="nTotWgtGold" id="nTotWgtGold" onkeyup="calPrice()"  data="number" data-type="weight"/>
                                                    </div> 
                                                </div><div id="hiddenBrDiv1"> <br></div>
                                                <div id="hiddenDataDiv2" class="form-group">

                                                    <label class="col-sm-2 input-sm text-right">1 g 1ක වටිනාකම :</label>
                                                    <div class="col-md-4">
                                                        <input  required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="1g 1ක වටිනාකම" value="<%= nOneGramAssessedValue%>" name="nOneGramAssessedValue" id="nOneGramAssessedValue" onkeyup="calPrice()"  data="number" data-type="decimal"/>
                                                    </div> 
                                                    <label class="col-sm-2 input-sm text-right">වෙළදපල වටිනාකම :</label>
                                                    <div class="col-md-4">
                                                        <input  required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="වෙළදපල වටිනාකම" value="<%= nTotMkrtValue%>" name="nTotMkrtValue" id="nTotMkrtValue" maxlength="10" onclick="setMaxPriceForAdv();" onkeyup="setMaxPriceForAdv();" data="number" data-type="decimal"/>
                                                    </div>
                                                </div><div id="hiddenBrDiv2"> <br></div>
                                                <div id="hiddenDataDiv3" class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">තක්සේරු මුදල :</label>
                                                    <div class="col-md-4">
                                                        <input  disabled type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="තක්සේරු මුදල" value="<%= nTotAssessedValue%>" name="nTotAssessedValue"  id="nTotAssessedValue" data="number" data-type="decimal"/>
                                                    </div> 
                                                    <label class="col-sm-2 input-sm text-right">නිකුත්කල ණය මුදල :</label>
                                                    <div class="col-md-4">
                                                        <input  required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="නිකුත්කල ණය මුදල" value="<%= nTotAdvAmount%>" name="nTotAdvAmount" id="nTotAdvAmount" maxlength="10" onclick="setMaxPriceForAdv();
                                                                checkTableData();" onkeyup="setMaxPriceForAdv();
                                                                        checkTableData();" data="number" data-type="decimal"/>
                                                    </div> 
                                                </div> <div id="hiddenBrDiv3"> <br></div>
                                                <div id="hiddenDataDiv4" class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">පොළි අනුපාතය :</label>
                                                    <div class="col-md-4">
                                                        <input  required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="පොළි අනුපාතය" value="<%= nActualInt%>" name="nActualInt" id="nActualInt" data="number" data-type="decimal"/>
                                                    </div> 
                                                    <label class="col-sm-2 input-sm text-right">එකග වූ පොළි අනුපාතය :</label>
                                                    <div class="col-md-4">
                                                        <input  required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number"  placeholder="එකග වූ පොළි අනුපාතය" value="<%=  nAgreedInt%>" name="nAgreedInt" id="nAgreedInt" data="number" data-type="decimal"/>                                                        
                                                    </div> 
                                                </div> <div id="hiddenBrDiv4"> <br></div>
                                                <div id="hiddenDataDiv5" class="form-group">
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">අපසු ගෙවීම :</label>
                                                    <div class="col-md-2 bg-pad">
                                                        <select required class="form-control input-sm number" id="nPwnPeriodTypeID"  "name="nPwnPeriodTypeID" onchange="onChangeNLPTypeIDLabel()">
                                                            <% if (nPwnPeriodTypeID == 1) {%>
                                                            <option value="1" selected >-N/A-</option>
                                                            <option value="2">දින</option>
                                                            <option value="3">සති</option>
                                                            <option value="4">මාස</option>
                                                            <option value="5" >වර්ෂ</option>
                                                            <%} else if (nPwnPeriodTypeID == 2) {%>
                                                            <option value="1"  >-N/A-</option>
                                                            <option value="2" selected >දින</option>
                                                            <option value="3">සති</option>
                                                            <option value="4">මාස</option>
                                                            <option value="5" >වර්ෂ</option>

                                                            <%} else if (nPwnPeriodTypeID == 3) {%>
                                                            <option value="1"  >-N/A-</option>
                                                            <option value="2"  >දින</option>
                                                            <option value="3" selected>සති</option>
                                                            <option value="4">මාස</option>
                                                            <option value="5" >වර්ෂ</option>
                                                            <%} else if (nPwnPeriodTypeID == 4) {%>
                                                            <option value="1"  >-N/A-</option>
                                                            <option value="2"  >දින</option>
                                                            <option value="3" >සති</option>
                                                            <option value="4" selected>මාස</option>
                                                            <option value="5" >වර්ෂ</option>
                                                            <%} else {%>
                                                            <option value="1"  >-N/A-</option>
                                                            <option value="2"  >දින</option>
                                                            <option value="3" >සති</option>
                                                            <option value="4" >මාස</option>
                                                            <option value="5" selected>වර්ෂ</option>
                                                            <% }%>

                                                        </select>                                                                                   
                                                    </div>
                                                    <div class="col-md-1 bg-pad">
                                                        <input required type="number" class="form-control input-sm number" id="nPwnPeriod" value="<%= nPwnPeriod%>" name="nPwnPeriod" onkeyup="onChangeNLPTypeIDLabel()" onchange="onChangeNLPTypeIDLabel()"  min="1" data="number" data-type="number">                                                                                 
                                                    </div>
                                                    <label class="col-sm-1 input-sm text-left" id="nLPTypeIDLabel">දින 365 ක්</label>
                                                    <!--<label class="col-sm-1 input-sm text-right">ක්</label>-->
                                                    <label class="col-sm-2 input-sm text-right">කල් පිරෙන දිනය :</label>
                                                    <div class="col-md-4">
                                                        <input required type="date" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha"  placeholder="කල් පිරෙන දිනය" value="<%= v_dMaturityDate%>" name="dMaturityDate" id="dMaturityDate" />
                                                    </div>
                                                </div><div id="hiddenBrDiv5"> <br></div>
                                                <div  id="hiddenDataDiv6" class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">කුයිතාන්සි අංකය :</label>
                                                    <div class="col-md-4">
                                                        <input required type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" value="<%= cReceiptNo%>" placeholder="කුයිතාන්සි අංකය" name="cReceiptNo" id="cReceiptNo" data="number" data-type="number"/>
                                                    </div> 
                                                    <label class="col-sm-2 input-sm text-right">කාරණාව :</label>
                                                    <div class="col-md-4">
                                                        <select class="form-control input-sm " id="nPwnDescriptionID" name="nPwnDescriptionID" disabled="">
                                                            <option value="1">-N/A-</option>                                                            
                                                        </select>  
                                                    </div> 
                                                </div> <div id="hiddenBrDiv6"> <br></div>
                                                <div id="hiddenDataDiv7" class="form-group">                                                    
                                                    <label class="col-sm-2 input-sm text-right">අවසාන ගණුදෙනු දිනය :</label>
                                                    <div class="col-md-4">
                                                        <input type="date" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha"  placeholder="අවසාන ගණුදෙනු දිනය" value="<%= lastPayDate%>" name="dLastPaymentDate" id="dLastPaymentDate"/>
                                                    </div> 

                                                    <label class="col-sm-2 input-sm text-right">දැනට ශේෂය :</label>
                                                    <div class="col-md-4">
                                                        <input onkeypress='return ((event.which == 190) && (event.which < 48 || event.which > 57))' type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right number " placeholder="දැනට ශේෂය" value="<%= nBalAmount%>" name="nBalAmount" id="nBalAmount" data="number" data-type="decimal"/>
                                                    </div> 
                                                </div><div id="hiddenBrDiv7"> <br></div>
                                                <div id="hiddenDataDiv8" class="form-group"> 
                                                    <label class="col-sm-2 input-sm text-right">වෙනත් විස්තර :</label>
                                                    <div class="col-md-10">
                                                        <!--<input type="text" class="form-control input-sm col-lg-3"  placeholder="වෙනත් විස්තර" name="cRemrks " id="cRemrks "/>-->
                                                        <textarea style="min-width: 898.3333px;max-width: 898.3333px;min-height: 100px;" placeholder="වෙනත් විස්තර" name="cRemrks " id="cRemrks" class="form-control input-sm col-lg-3 convertSinhalaIskolaPotha"><%= cRemrks%></textarea>
                                                    </div> 
                                                </div>
                                                <!--New Article-->
                                                <div id="articleDiv" hidden >

                                                    <div  class="form-group" >
                                                        <label class="col-sm-1 input-sm text-right">Article Name</label>
                                                        <div class="col-md-3">
                                                            <input type="text" class="form-control input-sm col-lg-4 convertSinhalaAmali"  placeholder="" name="cArticlenameSin" id="cArticlenameSin"/>
                                                        </div> 
                                                    </div>
                                                    <div  class="form-group">
                                                        <label class="col-sm-2 input-sm text-right">Article Name(Eng)</label>
                                                        <div class="col-md-3">
                                                            <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha"  placeholder="" name="cArticlenameEng" id="cArticlenameEng"/>
                                                        </div> 
                                                    </div>
                                                    <div class="col-sm-2" >
                                                        <input onclick="saveNewArticle()" id="btn1"  type="button" class="btn btn-success btn-sm " value="Save"/>
                                                        <input onclick="deActiveNewArticleDiv()" id="btn1"  type="button" class="btn btn-primary btn-sm " value="Back"/>
                                                    </div>

                                                </div>   
                                                <!--end new Article-->
                                                <div class="alignright"  >
                                                    <div id="btnGroup" class="col-md-10 pull-right bg-top" style="margin-top: 5px;">
                                                        <button id="btnPay"  type="submit" class="btn btn-info  col-lg-2">ගෙවන්න/Pay</button>
                                                        <button onclick="activeNewArticleDiv();" type="button" class="btn btn-primary col-lg-2">Add Articles</button>
                                                        <button type="button" onclick="$('#myFile').modal('show')" class="btn btn-success col-lg-2">Add NIC Picture</button>
                                                        <button type="button" onclick="$('#myCam').modal('show')" class="btn btn-success col-lg-2">Add Picture</button>
                                                        <button onclick="removeSessionStoreDetails()" type="reset" class="btn btn-danger col-lg-2">Reset</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" value="" id="pic" name="userImage">
                            </form>
                        </div>
                    </div>
                </section>
            </aside>
        </div>   

        <script type="text/javascript">
            function getBirthDay() {
                var cNICNo = document.getElementById('cNICNo').value;
                if (cNICNo === "") {
                    alert('ජැ.හැ. අංකය වැරදි');

                } else if (!isNaN(cNICNo.substr(0, 8)) && (cNICNo.charAt(9) === "v" || cNICNo.charAt(9) === "V")) {
                    url = "../NicGenarator";
                    $.post(url,
                            {nicNo: cNICNo},
                            function (res) {
                                $("#loadBday").html(res);

                            });
                    overlay2();
                    window.setTimeout("hideMessage()", 5000);
                } else {
                    alert('ජැ.හැ. අංකය වැරදි');
                }
            }

            function hideMessage() {
                document.getElementById("overlay2").style.visibility = "hidden";
            }

            function idSearch(e) {
                var lblValue = document.getElementById("lblChangName").value;
                if (lblValue === "1") {
                    var cNICNo = document.getElementById('cNICNo').value;
                    if (cNICNo === "") {
                        alert('ජැ.හැ. අංකය වැරදි');

                    } else if (!isNaN(cNICNo.substr(0, 8)) && (cNICNo.charAt(9) === "v" || cNICNo.charAt(9) === "V")) {

                        if (e.keyCode == 9) {
                            window.location = '../PawningMasterServlet?keySerch=' + cNICNo + ' &nic=1';
                        } else {
                            idSearchAndFindData();
                        }
                    } else {
                        alert('ජැ.හැ. අංකය වැරදි');

                    }
                } else {
                    var depositNo = document.getElementById('cNICNo').value;
                    window.location = '../PawningMasterServlet?keySerch=' + depositNo + ' &nic=0';
                }
            }

            function idSearchAndFindData() {
                var lblValue = document.getElementById("lblChangName").value;
                if (lblValue === "1") {
                    var cNICNo = document.getElementById('cNICNo').value;
                    if (cNICNo === "") {
                        alert('ජැ.හැ. අංකය වැරදි');

                    } else if (!isNaN(cNICNo.substr(0, 8)) && (cNICNo.charAt(9) === "v" || cNICNo.charAt(9) === "V")) {

                        urlName = "../GetPwningDetailsForNunMemberServlet";
                        $.post(urlName,
                                {cNICNo: cNICNo},
                                function (result) {
                                    overlay();
                                    $("#tblDiv").html(result);
                                }
                        );
                    } else {
                        alert('ජැ.හැ. අංකය වැරදි');

                    }
                } else {
                    var depositNo = document.getElementById('cNICNo').value;
                    window.location = '../PawningMasterServlet?keySerch=' + depositNo + ' &nic=0';
                }
            }
            function overlay() {
                el = document.getElementById("overlay");
                el.style.visibility = (el.style.visibility === "visible") ? "visible" : "visible";
            }
            function overlay1() {
                el = document.getElementById("overlay1");
                el.style.visibility = (el.style.visibility === "visible") ? "visible" : "visible";
                urlName = "../GetLoadOtherServlet";
                $.post(urlName,
                        function (result) {
                            $("#tblrw").html(result);
                        }
                );
            }
            function overlay2() {
                el = document.getElementById("overlay2");
                el.style.visibility = (el.style.visibility === "visible") ? "visible" : "visible";
            }
            function overlayHide() {
                removeSession();
                document.getElementById("dataDiv").innerHTML = "";
                el = document.getElementById("overlay");
                el.style.visibility = (el.style.visibility === "visible") ? "hidden" : "visible";

            }
            function overlay1Hide() {
                el = document.getElementById("overlay1");
                el.style.visibility = (el.style.visibility === "visible") ? "hidden" : "visible";

            }
            function removeSession() {
                urlName = "../RemovePwningSessionServlet";
                $.post(urlName,
                        function (result) {

                        });
            }
            function getMoreDetails(x) {
                urlName = "../GetPwningMoreDetailServlet";
                $.post(urlName,
                        {storeRowNumber: x.rowIndex},
                        function (result) {
                            $("#dataDiv").html(result);
                        });
            }
            function setDataIntoTable(x) {
                urlName = "../GetSelectedPwnReasonServlet";

                $.post(urlName,
                        {storeRowNumber: x.rowIndex},
                        function (result) {
                            overlay1Hide();

                            document.getElementById("col4").value = result;
                            // $("#col4").html(result);

                        }
                );
            }
            function saveNewReason() {
                var pwnReasonEng = document.getElementById("pwnReasonSin").value;
                var pwnReasonSin = document.getElementById("pwnReasoneng").value;
                if (pwnReasonSin === "") {
                } else if (pwnReasonEng === "") {
                } else {
                    urlName = "../PwningReasonServlet";
                    $.post(
                            urlName,
                            {pwnReasonEng: pwnReasonEng, pwnReasonSin: pwnReasonSin},
                            function (res) {
                                document.getElementById("pwnReasonSin").value = "";
                                document.getElementById("pwnReasoneng").value = "";
                                $('#tblrw').find('table').remove();
                                $("#tblrw").html(res);
                            }
                    );
                }

            }
            function enterSubmit(e) {
                var code = (e.keyCode ? e.keyCode : e.which);
                if (code === 13) {

                }
            }
            function findDetails(e) {
                if (e.keyCode === 9) {
                    idSearch(e);


                }

            }
            function addTable() {
                var col_1 = document.getElementById('col1');
                var col1 = col_1.options[col_1.selectedIndex].text;
                var col_2 = document.getElementById('col2');
                var col2 = col_2.options[col_2.selectedIndex].text;
                var col3 = document.getElementById('col3').value;
                var col4 = document.getElementById('col4').value;

                var cNICNo = document.getElementById("cNICNo").value;
                var dNICIssuedDate = document.getElementById("dNICIssuedDate").value;
                var cFullName = document.getElementById("cFullName").value;
                var cPAddLine1 = document.getElementById("cPAddLine1").value;
                var cPAddLine2 = document.getElementById("cPAddLine2").value;
                var cPAddLine3 = document.getElementById("cPAddLine3").value;
                var cPAddLine4 = document.getElementById("cPAddLine4").value;
                var cPTelNo1 = document.getElementById("cPTelNo1").value;
                var cBTelNo1 = document.getElementById("cBTelNo1").value;

                var id1 = col_1.value;
                var id2 = col_2.value;

                var nActualInt = document.getElementById("nActualInt").value;
                var dMaturityDate = document.getElementById("dMaturityDate").value;
                var cReceiptNo = document.getElementById("cReceiptNo").value;
                var dLastPaymentDate = document.getElementById("dLastPaymentDate").value;
                var cRemrks = document.getElementById("cRemrks").value;

                var nTotWgtArt = parseFloat(document.getElementById("nTotWgtArt").value);
                var nTotMkrtValue = parseFloat(document.getElementById("nTotMkrtValue").value);
                var nTotWgtGold = parseFloat(document.getElementById("nTotWgtGold").value);
                var nOneGramAssessedValue = parseFloat(document.getElementById("nOneGramAssessedValue").value);
                var nTotAdvAmount = parseFloat(document.getElementById("nTotAdvAmount").value);
                var nBalAmount = parseFloat(document.getElementById("nBalAmount").value);
                var nAgreedInt = parseFloat(document.getElementById("nAgreedInt").value);
                var nPwnPeriodTypeID = parseInt(document.getElementById("nPwnPeriodTypeID").value);
                var nPwnPeriod = parseInt(document.getElementById("nPwnPeriod").value);

                var isSelect = document.getElementById("newPwn").checked;

                var bnkPwnPawnTypesID = document.getElementById("BnkPwnPawnTypesID").value;

                if (isNaN(nTotWgtArt)) {
                    nTotWgtArt = 0;
                }
                if (isNaN(nTotWgtGold)) {
                    nTotWgtGold = 0;
                }
                if (isNaN(nOneGramAssessedValue)) {
                    nOneGramAssessedValue = 0;
                }
                if (isNaN(nTotAdvAmount)) {
                    nTotAdvAmount = 0;
                }
                if (isNaN(nBalAmount)) {
                    nBalAmount = 0;
                }
                if (isNaN(nAgreedInt)) {

                    nAgreedInt = 0;

                }
                if (isNaN(nTotMkrtValue)) {
                    nTotMkrtValue = 0;
                }
                if (isNaN(nPwnPeriodTypeID)) {
                    nPwnPeriodTypeID = 0;
                }
                if (isNaN(nPwnPeriod)) {
                    nPwnPeriod = 0;
                }
                if (isNaN(nActualInt)) {
                    nActualInt = 0;
                }
                if (nActualInt === "") {
                    nActualInt = 0;
                }

                window.location = '../PawningMasterServlet?key=addTable&col1=' + col1 + '&col2=' + col2 + '&col3=' + col3 + '&col4=' + col4 + '&id1=' + id1 + '&id2=' + id2 + '&cNICNo=' + cNICNo + '&dNICIssuedDate=' + dNICIssuedDate + '&cFullName=' + cFullName + '&cPAddLine1=' + cPAddLine1 + '&cPAddLine2=' + cPAddLine2 + '&cPAddLine3=' + cPAddLine3 + '&cPAddLine4=' + cPAddLine4 + '&cPTelNo1=' + cPTelNo1 +
                        '&cBTelNo1=' + cBTelNo1 + '&nActualInt=' + nActualInt + '&dMaturityDate=' + dMaturityDate + '&cReceiptNo=' + cReceiptNo + '&dLastPaymentDate=' + dLastPaymentDate + '&cRemrks=' + cRemrks + '&nTotWgtArt=' + nTotWgtArt + '&nTotWgtGold=' + nTotWgtGold +
                        '&nOneGramAssessedValue=' + nOneGramAssessedValue + '&nTotAdvAmount=' + nTotAdvAmount + '&nBalAmount=' + nBalAmount + '&nAgreedInt=' + nAgreedInt + '&nPwnPeriodTypeID=' + nPwnPeriodTypeID + '&nPwnPeriod=' + nPwnPeriod + '&isSelecet=' + isSelect + '&bnkPwnPawnTypesID=' + bnkPwnPawnTypesID + '&nTotMkrtValue=' + nTotMkrtValue;
            }

            function onChangeNLPTypeIDLabel() {
                var nPwnPeriodTypeID = document.getElementById("nPwnPeriodTypeID").value;
                var nPwnPeriod = document.getElementById("nPwnPeriod").value;
                var nLPTypeIDLabel = document.getElementById("nLPTypeIDLabel");
                var dMaturityDate = document.getElementById("dMaturityDate");
                var plusDate;
                if (nPwnPeriod !== "") {
                    if (nPwnPeriodTypeID === "3") {
                        nLPTypeIDLabel.innerHTML = 'දින ' + parseInt(nPwnPeriod) * 7 + ' ක්';
                        plusDate = parseInt(nPwnPeriod) * 7;
                    } else if (nPwnPeriodTypeID === "4") {
                        nLPTypeIDLabel.innerHTML = 'දින ' + parseInt(nPwnPeriod) * 30 + ' ක්';
                        plusDate = parseInt(nPwnPeriod) * 30;
                    } else if (nPwnPeriodTypeID === "5") {
                        nLPTypeIDLabel.innerHTML = 'දින ' + parseInt(nPwnPeriod) * 365 + ' ක්';
                        plusDate = parseInt(nPwnPeriod) * 365;
                    } else {
                        nLPTypeIDLabel.innerHTML = 'දින ' + (nPwnPeriod) * 1 + ' ක්';
                        plusDate = (nPwnPeriod) * 1;
                    }

                    var someDate = new Date(document.getElementById('currentDate').value);
                    var numberOfDaysToAdd = plusDate;
                    someDate.setDate(someDate.getDate() + numberOfDaysToAdd);
                    var dd = someDate.getDate();
                    var mm = someDate.getMonth() + 1;
                    var yy = someDate.getFullYear();
                    var M;
                    var D;
                    var someFormattedDate;
                    if (mm < 10 && dd > 10) {
                        someFormattedDate = yy + '-0' + mm + '-' + dd;
                    } else if (dd < 10 && mm > 10) {
                        someFormattedDate = yy + '-' + mm + '-0' + dd;
                    } else if (mm < 10 && dd < 10) {
                        someFormattedDate = yy + '-0' + mm + '-0' + dd;
                    } else if (mm >= 10 && dd >= 10) {
                        someFormattedDate = yy + '-' + mm + '-' + dd;
                    }
                    //                    alert(someFormattedDate);
                    dMaturityDate.value = someFormattedDate;
                }
            }
            function disableDate() {
                var oldPwn = document.getElementById('oldPwn').checked;
                var newPwn = document.getElementById('newPwn').checked;
                if (oldPwn) {
                    document.getElementById('currentDate').setAttribute('disabled', '');
                    document.getElementById('currentDate').value = "";

                }
                if (newPwn) {
                    document.getElementById('currentDate').value = "<%= session.getAttribute("storeLoggedDate")%>";
                    document.getElementById('currentDate').removeAttribute('disabled');
                }
            }
            function calPrice() {
                var nTotWgtGold = document.getElementById('nTotWgtGold').value;
                var nOneGramAssessedValue = document.getElementById('nOneGramAssessedValue').value;
                nTotWgtGold.toString().split(',').join("");
                nOneGramAssessedValue.toString().replace('/^\,/g','');
                    console.log(nTotWgtGold + "  " + nOneGramAssessedValue);
                var tot = parseFloat(nTotWgtGold) * parseFloat(nOneGramAssessedValue);
                if (isNaN(tot)) {
                    tot = 0;
                }
                tot = tot.toFixed(2);
                document.getElementById('nTotAssessedValue').value = tot;
                document.getElementById('nTotMkrtValue').value = tot;
            }
            function setTotWeightGold() {

                var weight = document.getElementById('nTotWgtArt').value;
                document.getElementById('nTotWgtGold').value = weight;
            }
            function setMaxPriceForAdv() {
                var marketPrice = document.getElementById('nTotMkrtValue').value;
                var totAdv = document.getElementById('nTotAdvAmount').value;

                var marketPrice1 = parseFloat(marketPrice);
                var totAdv1 = parseFloat(totAdv);
                if (marketPrice1 < totAdv1) {
                    document.getElementById('nTotAdvAmount').style.color = "red";
                } else {
                    document.getElementById('nTotAdvAmount').style.color = "black";
                }
            }

            function activeNewArticleDiv() {
                document.getElementById("articleDiv").hidden = false;
                document.getElementById("hiddenDataDiv1").hidden = true;
                document.getElementById("hiddenDataDiv2").hidden = true;
                document.getElementById("hiddenDataDiv3").hidden = true;
                document.getElementById("hiddenDataDiv4").hidden = true;
                document.getElementById("hiddenDataDiv5").hidden = true;
                document.getElementById("hiddenDataDiv6").hidden = true;
                document.getElementById("hiddenDataDiv7").hidden = true;
                document.getElementById("hiddenDataDiv8").hidden = true;

                document.getElementById("hiddenBrDiv1").hidden = true;
                document.getElementById("hiddenBrDiv2").hidden = true;
                document.getElementById("hiddenBrDiv3").hidden = true;
                document.getElementById("hiddenBrDiv4").hidden = true;
                document.getElementById("hiddenBrDiv5").hidden = true;
                document.getElementById("hiddenBrDiv6").hidden = true;
                document.getElementById("hiddenBrDiv7").hidden = true;

                document.getElementById("btnGroup").hidden = true;

            }
            function deActiveNewArticleDiv() {
                document.getElementById("articleDiv").hidden = true;
                document.getElementById("hiddenDataDiv1").hidden = false;
                document.getElementById("hiddenDataDiv2").hidden = false;
                document.getElementById("hiddenDataDiv3").hidden = false;
                document.getElementById("hiddenDataDiv4").hidden = false;
                document.getElementById("hiddenDataDiv5").hidden = false;
                document.getElementById("hiddenDataDiv6").hidden = false;
                document.getElementById("hiddenDataDiv7").hidden = false;
                document.getElementById("hiddenDataDiv8").hidden = false;

                document.getElementById("hiddenBrDiv1").hidden = false;
                document.getElementById("hiddenBrDiv2").hidden = false;
                document.getElementById("hiddenBrDiv3").hidden = false;
                document.getElementById("hiddenBrDiv4").hidden = false;
                document.getElementById("hiddenBrDiv5").hidden = false;
                document.getElementById("hiddenBrDiv6").hidden = false;
                document.getElementById("hiddenBrDiv7").hidden = false;
                document.getElementById("btnGroup").hidden = false;

            }
            function saveNewArticle() {
                var articleNameEng = document.getElementById("cArticlenameEng").value;
                var articleNameSin = document.getElementById("cArticlenameSin").value;

                if (articleNameSin === "") {
                    //document.getElementById("cArticlenameSin").style.borderColor = "red";
                } else if (articleNameEng === "") {

                } else {
                    // document.getElementById("cArticlenameEng").style.borderColor = "black";
                    //document.getElementById("cArticlenameSin").style.borderColor = "black";

                    urlName = "../PawningArticleServlet";
                    $.post(urlName,
                            {articlenameEng: articleNameEng, articleNameSin: articleNameSin},
                            function (result) {
                                if (result !== "Failed!") {
                                    document.getElementById("cArticlenameEng").value = "";
                                    document.getElementById("cArticlenameSin").value = "";

                                    $("#col1").html(result);
                                    deActiveNewArticleDiv();

                                }
                            }
                    );
                }

            }
            function  removeSessionStoreDetails() {

                window.location = '../PawningMasterServlet?key=delete&deleteAll=1';
            }
            function searchTypeChanger() {

                var ev = window.event;
                if (ev.keyCode === 38 | ev.keyCode === 40) {
                    var lblValue = document.getElementById("lblChangName").value;
                    if (lblValue === "1") {
                        document.getElementById("cNICNo").setAttribute("placeholder", "තැන්පත් අංකය");
                        lbl.innerHTML = "තැන්පත් අංකය :";
                        document.getElementById("lblChangName").value = "2";

                        document.getElementById("cNICNo").setAttribute("maxlength", "20");
                    } else {
                        lbl.innerHTML = "ජා.හැ.අංකය :";
                        document.getElementById("cNICNo").setAttribute("placeholder", "ජා.හැ.අංකය");
                        document.getElementById("lblChangName").value = "1";
                        document.getElementById("cNICNo").setAttribute("maxlength", "10");
                    }
                }
            }

            function checkTableData() {
                var marketPrice = document.getElementById('nTotMkrtValue').value;
                var totAdv = document.getElementById('nTotAdvAmount').value;
                var rowNumber = document.getElementById("dataTable").rows.length;

                var marketPrice1 = parseFloat(marketPrice);
                var totAdv1 = parseFloat(totAdv);
                if (marketPrice1 < totAdv1) {
                    document.getElementById("btnPay").setAttribute("disabled", "");
                } else if (rowNumber === 2) {
                    document.getElementById("btnPay").setAttribute("disabled", "");
                } else {
                    document.getElementById("btnPay").removeAttribute("disabled");
                }

            }

            function accept(acptForm) {

                var isOk = confirm("ගනුදෙණුව නිවැරදි බව තහවුරු කරන්න");
                if (isOk === true) {
                    isOk = confirm("මෙය තහවුරු කල පසු දත්තයන් කිසිදු ආකාරයකින් වෙනස් කල නොහැක.තහවුරු කරන්න");
                    if (isOk) {
                        document.forms["acptForm"].submit();
                    }
                } else {
                }
            }
            // Put event listeners into place
            window.addEventListener("DOMContentLoaded", function () {
                // Grab elements, create settings, etc.
                var canvas = document.getElementById("canvas"),
                        context = canvas.getContext("2d"),
                        video = document.getElementById("video"),
                        videoObj = {"video": true},
                        errBack = function (error) {
                            console.log("Video capture error: ", error.code);
                        };
                // Put video listeners into place
                if (navigator.getUserMedia) { // Standard
                    navigator.getUserMedia(videoObj, function (stream) {
                        video.src = stream;
                        video.play();
                    }, errBack);
                } else if (navigator.webkitGetUserMedia) { // WebKit-prefixed
                    navigator.webkitGetUserMedia(videoObj, function (stream) {
                        video.src = window.webkitURL.createObjectURL(stream);
                        video.play();
                    }, errBack);
                } else if (navigator.mozGetUserMedia) { // WebKit-prefixed
                    navigator.mozGetUserMedia(videoObj, function (stream) {
                        video.src = window.URL.createObjectURL(stream);
                        video.play();
                    }, errBack);
                }

                // Trigger photo take
                document.getElementById("snap").addEventListener("click", function () {
                    context.drawImage(video, 0, 0, 320, 240);
                    document.getElementById('userImage').src = canvas.toDataURL('image/png');
                });
            }, false);

            function send() {
                var canvasServer = document.getElementById("canvas");
                var context = canvasServer.getContext("2d");
                var imageDataURL = canvasServer.toDataURL('image/png');
                $.post('../saveImageServlet', imageDataURL, function (responseText) {
                    if (responseText !== "fail") {
                        document.getElementById('pic').value = responseText;
                        alert("File has been uploaded successfully");
                    } else {
                        alert("Failed to upload file");
                    }
                });
            }

            $('input[type="number"]').keypress(function onlyNumbersWithDot(e) {
                var charCode;
                if (e.keyCode > 0) {
                    charCode = e.which || e.keyCode;
                } else if (typeof (e.charCode) != "undefined") {
                    charCode = e.which || e.keyCode;
                }
                if (charCode == 46)
                    return true
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                    return false;
                return true;
            });
            function allownumericwithdecimal(event) {
                alert(0);
                //this.value = this.value.replace(/[^0-9\.]/g,'');
                $(this).val($(this).val().replace(/[^0-9\.]/g, ''));
                if ((event.which != 46 || $(this).val().indexOf('.') !== -1) && (event.which < 48 || event.which > 57)) {
                    ;
                }
            }

            function allownumericwithoutdecimal(event) {
                alet(1);
                $(this).val($(this).val().replace(/[^\d].+/, ""));
                if ((event.which < 48 || event.which > 57)) {
                    return false;
                }
            }
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    var id = $(input).attr('name')
                    reader.onload = function (e) {
                        $('#data div img[id=' + id + ']')
                                .attr('src', e.target.result)
                                .width(150)
                                .height(200);
                    };
                    reader.readAsDataURL(input.files[0]);
                }
            }
            function fileUpload() {
                var form = $('#imgForm');
                $.ajax({
                    type: "POST",
                    url: form.attr('action'),
                    async: true,
                    data: form.serialize(),
//                    contentType: "multipart/form-data",
                    contentType: "",
                    processData: false,
                    success: function (msg) {
                        alert("File has been uploaded successfully");
                    },
                    error: function (msg) {
                        alert("Failed to upload file");
                    }
                });
            }
        </script>

        <div id="myCam" class="modal fade" style="display: none;" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <strong style="font-size: 20px;">Take Picture</strong>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>                   
                    </div>
                    <div class="modal-body " style="padding: 5px;">
                        <div class="row">
                            <center><video id="video" autoplay="" style="margin: 0px ;border: 10px #333 solid;border-radius: 5px;" src="blob:http://localhost:8080/b9a68533-8278-440d-b82a-39bb06f039a2" width="325" height="240"></video></center> 
                        </div>
                        <div class="row">
                            <center><canvas id="canvas" height="240" width="325"></canvas></center> 
                        </div>
                        <div class="row" style="padding-right: 30px;">
                            <button type="button" class="btn btn-info" id="snap" style="float: right">Snap</button>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal" onclick="send()">Save & Close</button>
                    </div>
                </div>
            </div>
        </div>
        <div id="myFile" class="modal fade" style="display: none;" aria-hidden="true">
            <div class="modal-dialog">
                <form id="imgForm" action="../saveNic" method="post" enctype ="multipart/form-data" >
                    <div class="modal-content">
                        <div class="modal-header">
                            <strong style="font-size: 20px;">Select NIC Picture</strong>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>                   
                        </div>
                        <div class="modal-body " style="padding: 5px;">
                            <div id="data" class="row">

                                <div class="col-md-6">
                                    <input type="file" name="nicUp"  onchange="readURL(this);" />
                                    <img id="nicUp" src="#" alt="your Nic up image" />
                                </div>
                                <div class="col-md-6">
                                    <input type="file" name="nicDown" onchange="readURL(this);" />
                                    <img id="nicDown" src="#" alt="your Nic Down image" />
                                </div>

                            </div>
                        </div>
                        <div class="panel-footer">
                            <button id="submitButton" type="button" class="btn btn-info" data-dismiss="modal" onclick="fileUpload()">Save & Close</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="../js/validate.js" type="text/javascript"></script>
    </body>
</html>

