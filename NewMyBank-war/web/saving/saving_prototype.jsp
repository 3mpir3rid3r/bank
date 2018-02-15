<%-- 
    Document   : index
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : mmh
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="com.nbs.model.ActChartOfAcctL5"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="com.nbs.common.Alerts"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<meta http-equiv="refresh"  uri="../GetterBnkDepDepositTypesServlet" >-->
        <title>Saving</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

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
            .bg-searchheight{
                height:120px;                
            }
            .bg-pad{
                padding-right:0px;                
            }.bg-padl{
                padding-left:0px;                
            }
            .bg-panelcolor{
                background:#367fa9;
            }
            .b-header{
                height:30px; 
            }

            #saving_proto_table td{
                padding-top: 0px;
                padding-bottom: 0px;
                font-size: 15px;
                font-weight: bold;
            }
        </style>
        <script type="text/javascript" >
            <%
                if (request.getSession().getAttribute("bnkDepDepositTypesAll") == null) {
            %>
//            window.location = "../GetterBnkDepDetailsServlet";
            <%
                    request.getSession().removeAttribute("bnkDepDepositTypesAll");
                }
            %>

//            function keyup1(e, element) {
//                var keynum;
//
//                if (window.event) { // IE                    
//                    keynum = e.keyCode;
//                } else if (e.which) { // Netscape/Firefox/Opera                   
//                    keynum = e.which;
//                }
//                if (keynum === 113) {
//                    document.getElementById('txtSinglish').setAttribute('onkeyup', "startText(document.getElementById('txtSinglish'),[document.getElementById('txtUnicode'),document.getElementById('" + element + "')]);");
//                    $("#myModal").modal();
//                }
//            }



            function keyup1(e, element) {
                var keynum;

                if (window.event) { // IE                    
                    keynum = e.keyCode;
                } else if (e.which) { // Netscape/Firefox/Opera                   
                    keynum = e.which;
                }
                if (keynum === 113) {
                    document.getElementById('txtSinglish').setAttribute('onkeyup', "startText(document.getElementById('txtSinglish'),[document.getElementById('txtUnicode'),document.getElementById('" + element + "'),document.getElementById('txtAmali')],'ama');");
                    $("#myModal").modal();
                }
            }
            
            
        </script>


    </head>

    <body class="skin-blue fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include file="saving_header.jsp" %>
        <!--..............................-->
        <%@include file="../uni_convert/unicode_converter.jsp" %>

        <%
            String alert = "";
            String nDepTypeID = "0";
            String checkSaving = "";

            //----------------------
            String sysCode = "";
            String nDepCatID = "0";
            String bActive = "";
            String cDepName = "";
            String cDepNameSin = "";
            String cDepNameTamil = "";
            //---------------------------
            String nMinParticipant = "0";
            String nMaxParticipant = "0";
            String nMinAge = "0";
            String nMaxAge = "0";
            String nOperatingGenderType = "";
            String nMinAmtStart = "";
            String nMinAmtContinue = "";
            String bInitialDepCash = "";
            String bInitialDepChque = "";
            String bInitialDepFTrnans = "";
            String bMultipleAcct = "";
            //------------------------
            String nMinMonths = "0";
            String nMaxMonths = "0";
            String nWithdrawlsAllowed = "";
            String nNoOfDays = "0";
            String nNoOfTimesPerMonth = "0";
            String nMinAgeLimitWithdrawls = "0";
            //--------------------------------
            String nCurrentIntRate = "";
            String nIntCalMethodID = "";
            String nIntCalID = "0";
            String nIntPayID = "0";
            String nMinAmtIntCal = "";
            String nMinAmtIntCR = "";
            String nInterestRoundMethod = "";
            //--------------------------------
            String nDepAcctLevelID4 = "";
            String nIntAcctLevelID4 = "";
            //----------------------------
            String bChangeToInactive = "";
            String nInacPeriod = "0";
            String cInacPeriodType = "0";
            String bChangeToHimiNopa = "";
            String nHimiPeriod = "0";
            String nHimiPeriodType = "0";
            String nBonusIntRate = "";
            String nLoanAmount = "";
            String ndepDepositype = "0";

            if (request.getSession().getAttribute("cp") != null) {

                ArrayList<String> cp = (ArrayList<String>) request.getSession().getAttribute("cp");

                sysCode = cp.get(0);
                nDepCatID = cp.get(1);
                bActive = cp.get(2);
                cDepName = cp.get(3);
                cDepNameSin = cp.get(4);
                cDepNameTamil = cp.get(5);
                //---------------------------
                nMinParticipant = cp.get(6);
                nMaxParticipant = cp.get(7);
                nMinAge = cp.get(8);
                nMaxAge = cp.get(9);
                nOperatingGenderType = cp.get(10);
                nMinAmtStart = cp.get(11);
                nMinAmtContinue = cp.get(12);
                bInitialDepCash = cp.get(13);
                bInitialDepChque = cp.get(14);
                bInitialDepFTrnans = cp.get(15);
                bMultipleAcct = cp.get(16);
                //------------------------
                nMinMonths = cp.get(17);
                nMaxMonths = cp.get(18);
                nWithdrawlsAllowed = cp.get(19);
                nNoOfDays = cp.get(20);
                nNoOfTimesPerMonth = cp.get(21);
                nMinAgeLimitWithdrawls = cp.get(22);
                //--------------------------------
                nCurrentIntRate = cp.get(23);
                nIntCalMethodID = cp.get(24);
                nIntCalID = cp.get(25);
                nIntPayID = cp.get(26);
                nMinAmtIntCal = cp.get(27);
                nMinAmtIntCR = cp.get(28);
                nInterestRoundMethod = cp.get(29);
                //--------------------------------
                nDepAcctLevelID4 = cp.get(30);
                nIntAcctLevelID4 = cp.get(31);
                //----------------------------
                bChangeToInactive = cp.get(32);
                nInacPeriod = cp.get(33);
                cInacPeriodType = cp.get(34);
                bChangeToHimiNopa = cp.get(35);
                nHimiPeriod = cp.get(36);
                nHimiPeriodType = cp.get(37);
                nBonusIntRate = cp.get(38);
                nLoanAmount = cp.get(39);
                ndepDepositype = cp.get(40);
                // request.getSession().removeAttribute("cp");
            }

            if (request.getSession().getAttribute("checkSaving") != null) {
                checkSaving = (String) request.getSession().getAttribute("checkSaving");
                request.getSession().removeAttribute("checkSaving");
            }

            if (request.getParameter("mg") != null) {
//                String mg = (String) request.getSession().getAttribute("mg");
                String mg = request.getParameter("mg");
                if (!("".equals(mg))) {
                    alert = Alerts.warningAlert("Something Wrong", mg + " You miss this Fields", "");
                }
                System.out.println("888888888888888888888888888    " + mg);
//                request.getSession().removeAttribute("mg");
            }

            if (request.getSession().getAttribute("nDepTypeID") != null) {
                nDepTypeID = (String) request.getSession().getAttribute("nDepTypeID");
                //request.getSession().removeAttribute("nDepTypeID");
            }

            // *=**********************=* Legger affairs*+===================================================================+*
            ActChartOfAcctL5 acctL10 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL11 = new ActChartOfAcctL5();

            if (session.getAttribute("acctL10") != null) {
                acctL10 = (ActChartOfAcctL5) session.getAttribute("acctL10");
            } else {
                acctL10.setCCAAcctNoL5("");
                acctL10.setCDescriptionSinL5("");
                acctL10.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL11") != null) {
                acctL11 = (ActChartOfAcctL5) session.getAttribute("acctL11");
            } else {
                acctL11.setCCAAcctNoL5("");
                acctL11.setCDescriptionSinL5("");
                acctL11.setNNoteNoL5(BigDecimal.ZERO);

            }

            List<ActChartOfAcctL5> acctL5s10 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s11 = new ArrayList<ActChartOfAcctL5>();

            if (session.getAttribute("chartOfAccount5Data10") != null) {
                acctL5s10 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data10");
            }

            if (session.getAttribute("chartOfAccount5Data11") != null) {
                acctL5s11 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data11");
            }

            if (session.getAttribute("keyNo2") != null) {
                String actId = String.valueOf(session.getAttribute("keyNo2"));

                int actIdNum = Integer.parseInt(actId);

                if (actIdNum == 10) {
                    for (ActChartOfAcctL5 actl : acctL5s10) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {

                                acctL10 = actl;
                                session.setAttribute("acctL10", acctL10);
                                session.removeAttribute("keyNo1");

                            }
                        }
                    }
                } else if (actIdNum == 11) {
                    for (ActChartOfAcctL5 actl : acctL5s11) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL11 = actl;
                                session.setAttribute("acctL11", acctL11);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                }
            }
            // session.removeAttribute("actid");
            //*=========================================END Common LEGGER================================================*//      

        %>

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="../images/icon-user-default.png" class="img-circle" alt="User Image" >
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
                            <a href="../GetterBnkDepDetailsServlet" >
                                <i class="fa fa-users"></i> 
                                <span>තැම්පත් වර්ගයන්</span>
                            </a>
                        </li>
                        <li>
                            <a href="interest_calculation.jsp">
                                <i class="fa fa-money"></i>
                                <span>පොළී ගනණය</span>
                            </a>
                        </li>
                        <li>
                            <a href="interest_calculation_qua.jsp">
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
                        තැම්පත් වර්ගයන්ගේ ආකෘති
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Saving</a></li>
                        <li class="active"><a href="#">තැම්පත් වර්ගයන්ගේ ආකෘති</a></li>
                    </ol>
                </section>
                <%=alert%>
                <section class="content">
                    <div class="row bg-top"  style="margin-bottom: -20px;height:auto">
                        <form class="form-horizontal" action="../NewDepDopositTypesServlet" method="post" name="saving" onsubmit="validateNewSavingProtype(this);
                                return false;">

                            <div class="col-md-12" > 
                                <!--./Tab Section-->
                                <ul class="nav nav-tabs" id="myTab">
                                    <li id="secA" class="active"><a id="tabA" data-toggle="tab" href="#sectionA"><b>සාරාංශ දැක්ම</b></a></li>
                                    <li id="secB" >
                                        <a id="tabB" data-toggle="tab" href="#sectionB"><b>විස්තරාත්මක දැක්ම</b>
                                        </a>
                                    </li>
                                </ul>
                                <!--./Tab Section-->
                                <!--./Tab Content-->
                                <div class="tab-content">
                                    <!--/.section A-->
                                    <div id="sectionA" class="tab-pane fade in active">
                                        <div class="panel panel-default" style="margin-bottom: 10px">
                                            <div class="panel-heading">
                                                <h6 class="panel-title">
                                                    තැම්පත් වර්ගයන්ගේ සාරාංශය
                                                </h6>
                                            </div>
                                            <div class="panel-body" style="background-color: #e7f0f7;">
                                                <div class="list-group col-lg-12" id="fontSize" style="padding: 0px">
                                                    <div class="zTreeDemoBackground left" style="margin:-14px;margin-top:-15px;margin-bottom:-25px">
                                                        <ul id="treeDemo" class="ztree" style="width: auto;height: 395px; ">
                                                            <div class="table-responsive">
                                                                <table class="table table-bordered" id="saving_proto_table" data-toggle="table" data-cache="false" >
                                                                    <tr>
                                                                        <th class="text-center" style="width:10px"> අංකය</th>
                                                                        <th class="text-center" style="width:100px"> තැම්පත් කේතය</th>
                                                                        <th class="text-center"> තැම්පත් නම</th>
                                                                        <th class="text-center"> තැම්පත් නම(සිංහල)</th>
                                                                        <th class="text-center" style="width:100px"> තැම්පත් වර්ගය</th>
                                                                        <th class="text-center" style="width:10px"> පොළිය</th>
                                                                    </tr>
                                                                    <c:forEach items="${bnkDepDepositTypesAll}" var="bddt">
                                                                        <tr>
                                                                            <td style="width:10px;height: 2px;" class="convertSinhalaIskolaPotha" >${bddt.nDepTypeID}</td>
                                                                            <td style="width:100px;height: 2px;" class="convertSinhalaIskolaPotha" >${bddt.cSysCode}</td>
                                                                            <td style="width:300px;height: 2px;" class="convertSinhalaIskolaPotha" >${bddt.cDepName}</td>
                                                                            <td style="width:300px;height: 2px;" class="convertSinhalaAmali" >${bddt.cDepNameSin}</td>
                                                                            <td style="width:200px;height: 2px;" class="convertSinhalaIskolaPotha">${bddt.cDepCategory}</td>
                                                                            <td style="width:10px;height: 2px;" class="convertSinhalaIskolaPotha">${bddt.nCurrentIntRate}</td>
                                                                            <td style="width:10px;height: 2px;" class="convertSinhalaIskolaPotha"><button type="button" onclick="selectBtnAction(${bddt.nDepTypeID})" class="btn btn-primary btn-xs">Select</button></td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                    <%
                                                                        request.getSession().removeAttribute("bnkDepDepositTypesAll");
                                                                    %>
                                                                </table>
                                                            </div>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/.section A-->
                                    <!--/.section B-->
                                    <div id="sectionB" class="tab-pane fade">
                                        <div class="panel panel-default" style="margin-bottom: 10px">
                                            <div class="panel-heading">
                                                <h6 class="panel-title">
                                                    මුලික තොරතුරු
                                                </h6>
                                            </div>
                                            <div class="panel-body" style="background-color: #e7f0f7;">
                                                <div class="list-group col-lg-12" id="fontSize" style="padding: 0px">
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">කේතය :</label>
                                                        <div class="col-md-3">
                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="කේතය"  maxlength="3" name="sysCode" id="sysCode" value="<%=sysCode%>">
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">තැම්පත් වර්ගය :</label>
                                                        <div class="col-sm-3">
                                                            <select class="form-control my-input input-sm" name="nDepCatID" id="nDepCatID">
                                                                <option value="0">-තෝරන්න-</option>
                                                                <c:forEach items="${bnkDepDepositCategoryAll}" var="bddc">
                                                                    <option class="convertSinhalaIskolaPotha" value="${bddc.key}">${bddc.value}</option>
                                                                </c:forEach>
                                                            </select>  
                                                            <%
                                                                //request.getSession().removeAttribute("bnkDepDepositCategoryAll");
                                                            %>
                                                        </div>

                                                        <div class="checkbox col-sm-3">
                                                            <% if (bActive.equals("true")) { %>
                                                            <input checked type="checkbox" id="bActive" name="bActive" > ක්‍රියාකාරී ගිණුම් වර්ග
                                                            <%} else {%>
                                                            <input  type="checkbox" id="bActive" name="bActive" > ක්‍රියාකාරී ගිණුම් වර්ග
                                                            <%}%>
                                                        </div>

                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">තැම්පතේ නම :</label>
                                                        <div class="col-md-6">
                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="තැම්පතේ නම"  maxlength="59" name="cDepName" id="cDepName" value="<%=cDepName%>">
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">තැම්පතේ නම(සිංහල) :</label>
                                                        <div class="col-md-6">
                                                            <input type="text" class="form-control input-sm convertSinhalaAmali"  maxlength="59" id="cDepNameSin" name="cDepNameSin" value="<%=cDepNameSin%>" onkeyup="keyup1(event, 'cDepNameSin')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">තැම්පතේ නම(දෙමළ) :</label>
                                                        <div class="col-md-6">
                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="තැම්පතේ නම(දෙමළ)"  maxlength="59" name="cDepNameTamil" id="cDepNameTamil" value="<%=cDepNameTamil%>">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="list-group col-lg-12" id="fontSize" style="padding: 0px;margin-top:-25px">
                                                    <div class="box-group" id="accordion">
                                                        <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                                        <div class="panel box box-info bg-bottom bg-panelcolor">
                                                            <div class="" >
                                                                <h4 class="box-title b-header logo " style="padding: 5px 10px 10px 10px;font-size: 17px">
                                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" class="">
                                                                        ගිණුම පවත්වගෙන යාමට උපදෙස් 
                                                                    </a>
                                                                </h4>
                                                            </div>
                                                            <div id="collapseOne" class="panel-collapse collapse in" aria-expanded="false">
                                                                <div class="box-body bg-color">
                                                                    <div class="row">
                                                                        <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                            <div class="panel-group" id="account">
                                                                                <div class="panel panel-default">
                                                                                    <div class="panel-heading" style="height:30px">
                                                                                        <h5 class="panel-title" style="font-size:15px">
                                                                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#account" href="#collapseAccount">
                                                                                                <b>ගිණුම් ආරම්භක කිරීමේ උපදෙස්</b>
                                                                                            </a>
                                                                                        </h5>
                                                                                    </div>
                                                                                    <div id="collapseAccount" class="panel-collapse collapse in">
                                                                                        <div class="panel-body">
                                                                                            <div class="form-group bg-top">
                                                                                                <div class="col-sm-5 " style="padding:2px">
                                                                                                    <div class="panel panel-primary">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title">
                                                                                                                හිමිකම
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="form-group" style="margin-top:-6px">
                                                                                                                <label class="control-label col-sm-6 input-sm">අවම හවුල්කරයන් :</label>
                                                                                                                <div class="col-md-6">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0"  name="nMinParticipant" id="nMinParticipant" value="<%=nMinParticipant%>" min="0">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                                <label class="control-label col-sm-6 input-sm">උපරිම හවුල්කරයන් :</label>
                                                                                                                <div class="col-md-6">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0" name="nMaxParticipant" id="nMaxParticipant" value="<%=nMaxParticipant%>" min="0">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-4" style="padding:2px">
                                                                                                    <div class="panel panel-primary">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title">
                                                                                                                වයස සීමාවන්
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color: #e7f0f7;">
                                                                                                            <div class="form-group" style="margin-top:-6px;">
                                                                                                                <label class="control-label col-sm-6 input-sm">අවම වයස් සීමා :</label>
                                                                                                                <div class="col-md-6">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0" id="nMinAge" name="nMinAge" value="<%=nMinAge%>" min="0">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                                <label class="control-label col-sm-6 input-sm">උපරිම වයස් සීමා :</label>
                                                                                                                <div class="col-md-6">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0"  id="nMaxAge" name="nMaxAge" value="<%=nMaxAge%>" min="0">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-3" style="padding:2px">


                                                                                                    <div class="panel panel-primary">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title">
                                                                                                                ස්ත්‍රි/පුරුෂ 
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <% if (nOperatingGenderType.equals("1")) {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px">
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType1" value="1" checked>
                                                                                                                        පුරුෂ පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType2" value="2" >
                                                                                                                        ස්ත්‍රි පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px;margin-bottom: -6px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType3" value="3" >
                                                                                                                        දෙවර්ගයම
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <%} else if (nOperatingGenderType.equals("2")) {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px">
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType1" value="1" >
                                                                                                                        පුරුෂ පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType2" value="2" checked>
                                                                                                                        ස්ත්‍රි පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px;margin-bottom: -6px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType3" value="3" >
                                                                                                                        දෙවර්ගයම
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <%} else if (nOperatingGenderType.equals("3")) {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px">
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType1" value="1" checked>
                                                                                                                        පුරුෂ පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType2" value="2" >
                                                                                                                        ස්ත්‍රි පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px;margin-bottom: -6px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType3" value="3" checked>
                                                                                                                        දෙවර්ගයම
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <%} else {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px">
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType1" value="1" checked>
                                                                                                                        පුරුෂ පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType2" value="2" >
                                                                                                                        ස්ත්‍රි පමනයි
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio" style="margin-top:-5px;margin-bottom: -6px">
                                                                                                                    <label>
                                                                                                                        <input class="input-sm" type="radio" name="nOperatingGenderType" id="nOperatingGenderType3" value="3" checked>
                                                                                                                        දෙවර්ගයම
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <%}%>



                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="form-group">
                                                                                                <div class="col-sm-7 bg-top" style="padding:2px">
                                                                                                    <div class="panel panel-primary">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title">
                                                                                                                මුලික තැන්පත්
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="form-group" style="margin-top:-6px;">
                                                                                                                <label class="control-label col-sm-6 input-sm">ගිනුමක් ආරම්භයට අවම මුදල :</label>
                                                                                                                <div class="col-md-6">
                                                                                                                    <input type="number" min="0" class="form-control input-sm text-right convertSinhalaIskolaPotha number"   maxlength="20" name="nMinAmtStart" id="nMinAmtStart" value="<%=nMinAmtStart%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                                <label class="control-label col-sm-6 input-sm">ගිනුමක් නඩත්තුවට අවම මුදල :</label>
                                                                                                                <div class="col-md-6">
                                                                                                                    <input type="number" min="0" class="form-control input-sm text-right convertSinhalaIskolaPotha number"   maxlength="20" name="nMinAmtContinue" id="nMinAmtContinue" value="<%=nMinAmtContinue%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-5 bg-top" style="padding:2px">
                                                                                                    <div class="panel panel-primary">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title">
                                                                                                                මුලික තැන්පත් 
                                                                                                            </h6>
                                                                                                        </div>


                                                                                                        <div class="col-md-12" style="margin-top:-10px">
                                                                                                            <br>
                                                                                                            <%if (bInitialDepCash.equals("true")) {%>
                                                                                                            <div class="checkbox" style="margin-top:-5px">
                                                                                                                <label>
                                                                                                                    <input checked class="input-sm " type="checkbox" id="bInitialDepCash" name="bInitialDepCash" >
                                                                                                                    මුදල්
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%} else {%>
                                                                                                            <div class="checkbox" style="margin-top:-5px">
                                                                                                                <label>
                                                                                                                    <input class="input-sm number" type="checkbox" id="bInitialDepCash" name="bInitialDepCash" >
                                                                                                                    මුදල්
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%}%>
                                                                                                            <%if (bInitialDepChque.equals("true")) {%>
                                                                                                            <div class="checkbox" style="margin-top:-5px">
                                                                                                                <label>
                                                                                                                    <input checked class="input-sm" type="checkbox" id="bInitialDepChque" name="bInitialDepChque">
                                                                                                                    House Cheque
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%} else {%>
                                                                                                            <div class="checkbox" style="margin-top:-5px">
                                                                                                                <label>
                                                                                                                    <input class="input-sm" type="checkbox" id="bInitialDepChque" name="bInitialDepChque">
                                                                                                                    House Cheque
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%}%>
                                                                                                            <% if (bInitialDepFTrnans.equals("true")) {%>
                                                                                                            <div class="checkbox" style="margin-top:-5px;margin-bottom: -6px">
                                                                                                                <label>
                                                                                                                    <input checked class="input-sm" type="checkbox" id="bInitialDepFTrnans" name="bInitialDepFTrnans">
                                                                                                                    ස්ථිර/සහතික තැන්පතු වලින් මුදල් හුවමරු
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%} else {%>
                                                                                                            <div class="checkbox" style="margin-top:-5px;margin-bottom: -6px">
                                                                                                                <label>
                                                                                                                    <input class="input-sm" type="checkbox" id="bInitialDepFTrnans" name="bInitialDepFTrnans">
                                                                                                                    ස්ථිර/සහතික තැන්පතු වලින් මුදල් හුවමරු
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <% }%>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group" style=" margin-top: -15px">
                                                                                            <div class="checkbox col-sm-12" style="text-align: center">
                                                                                                <%if (bMultipleAcct.equals("true")) {%>
                                                                                                <input checked type="checkbox" id="bMultipleAcct" name="bMultipleAcct"> එක් ගනුදෙනු කරුවෙකුට ගිනුම් කිහිපයක් අරම්භ කිරිමට අවසර දිම
                                                                                                <%} else {%>
                                                                                                <input type="checkbox" id="bMultipleAcct" name="bMultipleAcct"> එක් ගනුදෙනු කරුවෙකුට ගිනුම් කිහිපයක් අරම්භ කිරිමට අවසර දිම

                                                                                                <%}%>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>  
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div>
                                                                    <a style="margin-top: -20px" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="btn btn-info btn-sm bg-top" aria-expanded="false">
                                                                        Next  
                                                                    </a>
                                                                </div>  
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                                        <div class="">
                                                            <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 17px">
                                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed" aria-expanded="false">
                                                                    ක්‍රියාත්මක කිරිමට උපදෙස්
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapseTwo" class="panel-collapse collapse " aria-expanded="false">
                                                            <div class="box-body bg-color">
                                                                <div class="row">
                                                                    <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                        <div class="panel-group" id="account">
                                                                            <div class="panel panel-default">
                                                                                <div class="panel-heading" style="height:30px">
                                                                                    <h5 class="panel-title" style="font-size:15px">
                                                                                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#account" href="#collapseDeposit">
                                                                                            <b>තැන්පත්/ආපසු ගැනිමෙ උපදෙස්</b>
                                                                                        </a>
                                                                                    </h5>
                                                                                </div>
                                                                                <div id="collapseDeposit" class="panel-collapse collapse in">
                                                                                    <div class="panel-body">
                                                                                        <div class="form-group bg-top" style="margin-bottom: -10px">
                                                                                            <div class="col-sm-7 " style="padding:2px">
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading" style="height:30px">
                                                                                                        <h6 class="panel-title" style="font-size:15px">
                                                                                                            තැන්පත්
                                                                                                        </h6>
                                                                                                    </div>
                                                                                                    <div class="panel-body"  style="background-color:  #e7f0f7;">

                                                                                                        <% if (ndepDepositype.equals("1")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio1" value="1" checked>
                                                                                                                    සමන්‍ය තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ඕනෑම අවස්ථාවක මුදල් තැන්පත් කිරිමට</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio2" value="2" >
                                                                                                                    ස්ථාවර තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- එක් අවස්ථාවක පමණක් මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="optionsRadios3" value="3" >
                                                                                                                    ධනයෝජන තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ගිවිසුම්ගත කාලයකදි මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (ndepDepositype.equals("2")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio1" value="1" >
                                                                                                                    සමන්‍ය තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ඕනෑම අවස්ථාවක මුදල් තැන්පත් කිරිමට</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio2" value="2" checked >
                                                                                                                    ස්ථාවර තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- එක් අවස්ථාවක පමණක් මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="optionsRadios3" value="3" >
                                                                                                                    ධනයෝජන තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ගිවිසුම්ගත කාලයකදි මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (ndepDepositype.equals("3")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio1" value="1" >
                                                                                                                    සමන්‍ය තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ඕනෑම අවස්ථාවක මුදල් තැන්පත් කිරිමට</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio2" value="2" >
                                                                                                                    ස්ථාවර තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- එක් අවස්ථාවක පමණක් මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="optionsRadios3" value="3" checked >
                                                                                                                    ධනයෝජන තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ගිවිසුම්ගත කාලයකදි මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio1" value="1" checked>
                                                                                                                    සමන්‍ය තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ඕනෑම අවස්ථාවක මුදල් තැන්පත් කිරිමට</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="depRadio2" value="2" >
                                                                                                                    ස්ථාවර තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- එක් අවස්ථාවක පමණක් මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-4 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="optionsDepTypes" id="optionsRadios3" value="3" >
                                                                                                                    ධනයෝජන තැන්පත් 
                                                                                                                </label>
                                                                                                                <label class="input-sm col-md-8">- ගිවිසුම්ගත කාලයකදි මුදල් තැන්පත් කල යුතුය</label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%}%>


                                                                                                        <div class="form-group" style="margin-top:-10px">
                                                                                                            <label class="control-label col-sm-4 input-sm"></label>
                                                                                                            <label class="control-label col-sm-4 input-sm">- පවත්වගෙන යාමට අවම මාස</label>
                                                                                                            <div class="col-md-4">
                                                                                                                <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0"  id="nMinMonths" name="nMinMonths" value="<%=nMinMonths%>">
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                            <label class="control-label col-sm-4 input-sm"></label>
                                                                                                            <label class="control-label col-sm-4 input-sm">- පවත්වගෙන යාමට උපරිම මාස</label>
                                                                                                            <div class="col-md-4">
                                                                                                                <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0" id="nMaxMonths" name="nMaxMonths" value="<%=nMaxMonths%>">
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-5" style="padding:2px">
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading" style="height:30px">
                                                                                                        <h6 class="panel-title" style="font-size:15px">
                                                                                                            ආපසු ගැනිම
                                                                                                        </h6>
                                                                                                    </div>
                                                                                                    <div class="panel-body"  style="background-color: #e7f0f7;">
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <%if (nWithdrawlsAllowed.equals("1")) {%>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" id="withdrowbox1" name="nWithdrawlsAllowed" value="1" checked>
                                                                                                                    ගිනුම සම්පූර්න වනතුරු මුදල් ආපසු ගනිමට නොහැක 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" id="withdrowbox1" name="nWithdrawlsAllowed" value="2" >
                                                                                                                    ආපසු ගැනිමට ඉඩදිම 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%} else if (nWithdrawlsAllowed.equals("2")) {%>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" id="withdrowbox1" name="nWithdrawlsAllowed" value="1" >
                                                                                                                    ගිනුම සම්පූර්න වනතුරු මුදල් ආපසු ගනිමට නොහැක 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" id="withdrowbox1" name="nWithdrawlsAllowed" value="2" checked >
                                                                                                                    ආපසු ගැනිමට ඉඩදිම 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%} else {%>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" id="withdrowbox1" name="nWithdrawlsAllowed" value="1" checked>
                                                                                                                    ගිනුම සම්පූර්න වනතුරු මුදල් ආපසු ගනිමට නොහැක 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" id="withdrowbox1" name="nWithdrawlsAllowed" value="2" >
                                                                                                                    ආපසු ගැනිමට ඉඩදිම 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <%}%>

                                                                                                            <div class="form-group">
                                                                                                                <label class="col-md-4 input-sm text-right">දින</label>
                                                                                                                <div class="col-md-3">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="දින"  name="nNoOfDays" id="nNoOfDays" value="<%=nNoOfDays%>">
                                                                                                                </div>
                                                                                                                <label class="col-md-5 input-sm">පසුවට</label>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;">
                                                                                                                <label class="control-label col-sm-9 input-sm">පොළියට බලපෑමක් නොමැතිව මුදල් ගතහැකි වාරගනන</label>
                                                                                                                <div class="col-md-3">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0"  id="nNoOfTimesPerMonth" name="nNoOfTimesPerMonth" value="<%=nNoOfTimesPerMonth%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -10px">
                                                                                                                <label class="control-label col-sm-9 input-sm">ආපසු ගැනිම සඳහා අවම වයස් සීමා(වර්ෂ)</label>
                                                                                                                <div class="col-md-3">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0"  id="nMinAgeLimitWithdrawls" name="nMinAgeLimitWithdrawls" value="<%=nMinAgeLimitWithdrawls%>">
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
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-6  bg-top">
                                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="btn btn-warning btn-sm" aria-expanded="false">
                                                                            Back 
                                                                        </a>
                                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="btn btn-info btn-sm" aria-expanded="true">
                                                                            Next
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                                        <div class="">
                                                            <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 17px">
                                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed" aria-expanded="true">
                                                                    පොලී ගනණය කිරිම
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapseThree" class="panel-collapse collapse" aria-expanded="true">
                                                            <div class="box-body bg-color">
                                                                <div class="row">
                                                                    <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                        <div class="panel-group" id="account">
                                                                            <div class="panel panel-default">
                                                                                <div class="panel-heading" style="height:30px">
                                                                                    <h5 class="panel-title" style="font-size:15px">
                                                                                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#account" href="#collapseInterest">
                                                                                            <b>පොළී අනුපාතය හා ගනනය කිරිමෙ උපදෙස්</b>
                                                                                        </a>
                                                                                    </h5>
                                                                                </div>
                                                                                <div id="collapseInterest" class="panel-collapse collapse in">
                                                                                    <div class="panel-body">
                                                                                        <div class="form-group bg-top">
                                                                                            <div class="col-sm-12" style="text-align: center">
                                                                                                <label class="control-label col-sm-4 input-sm">පොළී අනුපාතය :</label>
                                                                                                <div class="col-md-3">
                                                                                                    <input type="number" min="0" class="form-control input-sm text-right " id="nCurrentIntRate" name="nCurrentIntRate" value="<%=nCurrentIntRate%>">
                                                                                                </div>
                                                                                                <label class="control-label col-sm-1 input-sm text-left"> % වර්ෂයට</label>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group bg-top" style="margin-bottom: -10px">
                                                                                            <div class="col-sm-7 " style="padding:2px">
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading" style="height:30px">
                                                                                                        <h6 class="panel-title" style="font-size:15px">
                                                                                                            පොළී ගණනය කිරිමේ ආකාර
                                                                                                        </h6>
                                                                                                    </div>
                                                                                                    <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                        <%if (nIntCalMethodID.equals("1")) {%>

                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios1" value="1" checked>
                                                                                                                    මෙම ගිනුමට පොළිය නොමැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios2" value="2" >
                                                                                                                    පොළී ගණනය හා බැර කිරිම අතින් සිදුකෙරේ 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios3" value="3" >
                                                                                                                    උසස් ආකාරයට ණය ගෙවිම
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios4" value="4" >
                                                                                                                    පොළිය ගණනය සරල එකතු කිරිමෙ ආකාරයට
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (nIntCalMethodID.equals("2")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios1" value="1" >
                                                                                                                    මෙම ගිනුමට පොළිය නොමැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios2" value="2" checked>
                                                                                                                    පොළී ගණනය හා බැර කිරිම අතින් සිදුකෙරේ 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios3" value="3" >
                                                                                                                    උසස් ආකාරයට ණය ගෙවිම
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios4" value="4" >
                                                                                                                    පොළිය ගණනය සරල එකතු කිරිමෙ ආකාරයට
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (nIntCalMethodID.equals("3")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios1" value="1" >
                                                                                                                    මෙම ගිනුමට පොළිය නොමැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios2" value="2" >
                                                                                                                    පොළී ගණනය හා බැර කිරිම අතින් සිදුකෙරේ 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios3" value="3" checked>
                                                                                                                    උසස් ආකාරයට ණය ගෙවිම
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios4" value="4" >
                                                                                                                    පොළිය ගණනය සරල එකතු කිරිමෙ ආකාරයට
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (nIntCalMethodID.equals("4")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios1" value="1" >
                                                                                                                    මෙම ගිනුමට පොළිය නොමැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios2" value="2" >
                                                                                                                    පොළී ගණනය හා බැර කිරිම අතින් සිදුකෙරේ 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios3" value="3" >
                                                                                                                    උසස් ආකාරයට ණය ගෙවිම
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios4" value="4" checked>
                                                                                                                    පොළිය ගණනය සරල එකතු කිරිමෙ ආකාරයට
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios1" value="1" checked>
                                                                                                                    මෙම ගිනුමට පොළිය නොමැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="calRadios2" value="2" >
                                                                                                                    පොළී ගණනය හා බැර කිරිම අතින් සිදුකෙරේ 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios3" value="3" >
                                                                                                                    උසස් ආකාරයට ණය ගෙවිම
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nIntCalMethodID" id="optionsRadios4" value="4" >
                                                                                                                    පොළිය ගණනය සරල එකතු කිරිමෙ ආකාරයට
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%}%>



                                                                                                        <div class="form-group">
                                                                                                            <label class="control-label col-sm-4 input-sm text-right">ගණනය සෑම : </label>
                                                                                                            <div class="col-md-8">
                                                                                                                <select class="form-control my-input input-sm" name="nIntCalID" id="nIntCalID">
                                                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                                                    <c:forEach items="${bnkDepIntCalByAll}" var="bdicb">
                                                                                                                        <option class="convertSinhalaIskolaPotha" value="${bdicb.key}">${bdicb.value}</option>
                                                                                                                    </c:forEach>
                                                                                                                </select>
                                                                                                                <%
//                                                                                                                    request.getSession().removeAttribute("bnkDepIntCalByAll");
                                                                                                                %>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <div class="form-group" style="margin-top:-10px;margin-bottom: 10px">
                                                                                                            <label class="control-label col-sm-4 input-sm text-right">ගිනුමට බැරවිම සෑම : </label>
                                                                                                            <div class="col-md-8">
                                                                                                                <select class="form-control my-input input-sm" name="nIntPayID" id="nIntPayID">
                                                                                                                    <option value="0">-තෝරන්න-</option>
                                                                                                                    <c:forEach items="${bnkDepIntPayByAll}" var="bdipb">
                                                                                                                        <option class="convertSinhalaIskolaPotha" value="${bdipb.key}">${bdipb.value}</option>
                                                                                                                    </c:forEach>
                                                                                                                </select>
                                                                                                                <%
//                                                                                                                    request.getSession().removeAttribute("bnkDepIntPayByAll");
                                                                                                                %>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="col-sm-5" style="padding:2px">
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading" style="height:30px">
                                                                                                        <h6 class="panel-title" style="font-size:15px">
                                                                                                            පොළී ගණනය කිරිමේ නීති
                                                                                                        </h6>
                                                                                                    </div>
                                                                                                    <div class="panel-body"  style="background-color: #e7f0f7;">
                                                                                                        <div class="form-group">
                                                                                                            <label class="control-label col-sm-6 input-sm text-right">පොළී ගණනයට අවම මුදල : </label>
                                                                                                            <div class="col-md-6">
                                                                                                                <input type="number" min="0" class="form-control input-sm text-right convertSinhalaIskolaPotha number"   maxlength="25" id="nMinAmtIntCal" name="nMinAmtIntCal" value="<%=nMinAmtIntCal%>">
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <div class="form-group" style="margin-top:-10px;margin-bottom: -10px">
                                                                                                            <label class="control-label col-sm-6 input-sm text-right">බැර කිරිමට අවම පොළී මුදල : </label>
                                                                                                            <div class="col-md-6">
                                                                                                                <input type="number" min="0" class="form-control input-sm text-right convertSinhalaIskolaPotha number"  style="font-size:15px;" maxlength="25" id="nMinAmtIntCR" name="nMinAmtIntCR" value="<%=nMinAmtIntCR%>">
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <div class="form-group" style="margin-top:-10px;margin-bottom: -10px">
                                                                                                            <label class="col-sm-12 input-sm" style="color: #005f8d">පොළිය වැටයීම</label>
                                                                                                        </div>

                                                                                                        <%if (nInterestRoundMethod.equals("1")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px;margin-bottom: -15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios1" value="1" checked>
                                                                                                                    වැටයීම්  නැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios2" value="2">
                                                                                                                    පොදු වැටයීම් 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios3" value="3">
                                                                                                                    වැඩි අගයකට 10.20-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios4" value="4">
                                                                                                                    අඩු අගයකට 10.66-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (nInterestRoundMethod.equals("2")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px;margin-bottom: -15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios1" value="1" >
                                                                                                                    වැටයීම්  නැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios2" value="2" checked>
                                                                                                                    පොදු වැටයීම් 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios3" value="3">
                                                                                                                    වැඩි අගයකට 10.20-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios4" value="4">
                                                                                                                    අඩු අගයකට 10.66-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (nInterestRoundMethod.equals("3")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px;margin-bottom: -15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios1" value="1" >
                                                                                                                    වැටයීම්  නැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios2" value="2">
                                                                                                                    පොදු වැටයීම් 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios3" value="3" checked>
                                                                                                                    වැඩි අගයකට 10.20-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios4" value="4">
                                                                                                                    අඩු අගයකට 10.66-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else if (nInterestRoundMethod.equals("4")) {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px;margin-bottom: -15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios1" value="1" >
                                                                                                                    වැටයීම්  නැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios2" value="2">
                                                                                                                    පොදු වැටයීම් 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios3" value="3">
                                                                                                                    වැඩි අගයකට 10.20-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios4" value="4" checked >
                                                                                                                    අඩු අගයකට 10.66-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%} else {%>
                                                                                                        <div class="col-md-12" style="margin-top:-15px;margin-bottom: -15px">
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios1" value="1" checked>
                                                                                                                    වැටයීම්  නැත
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios2" value="2">
                                                                                                                    පොදු වැටයීම් 
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios3" value="3">
                                                                                                                    වැඩි අගයකට 10.20-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                            <div class="radio">
                                                                                                                <label class="col-md-12 input-sm">
                                                                                                                    <input class="input-sm" type="radio" name="nInterestRoundMethod" id="optionsRadios4" value="4">
                                                                                                                    අඩු අගයකට 10.66-->11.00
                                                                                                                </label>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                        <%}%>



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
                                                                <div class="row">
                                                                    <div class="col-md-6  bg-top">
                                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="btn btn-warning btn-sm" aria-expanded="true">
                                                                            Back 
                                                                        </a>
                                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" class="btn btn-info btn-sm" aria-expanded="true">
                                                                            Next
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                                        <div class="">
                                                            <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 16px">
                                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" class="collapsed" aria-expanded="true">
                                                                    පොලී අනුපාත වෙනස් වූ ආකාරය 
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapseSeven" class="collapse " aria-expanded="true">
                                                            <div class="box-body bg-color">
                                                                <div class="row">
                                                                    <div class="panel-body" style="background-color: #e7f0f7;">
                                                                        <div class="list-group col-lg-12" id="fontSize" style="padding: 0px">
                                                                            <div class="zTreeDemoBackground left " style="">
                                                                                <ul id="treeDemo" class="ztree" style="width: auto;height: 200px; ">
                                                                                    <div class="table-responsive">
                                                                                        <table class="table table-bordered" id="table-style" data-toggle="table" data-cache="false" >
                                                                                            <tr>
                                                                                                <th class="text-center" style="width:10px"> AAA</th>
                                                                                                <th class="text-center" style="width:100px"> AAA</th>
                                                                                                <th class="text-center"> AAA</th>

                                                                                            </tr>

                                                                                        </table>
                                                                                    </div>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-6  bg-top">
                                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="btn btn-warning btn-sm" aria-expanded="false">
                                                                            Back 
                                                                        </a>
                                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="btn btn-info btn-sm" aria-expanded="false">
                                                                            Next
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="panel box box-info bg-bottom bg-panelcolor">
                                                        <div class="">
                                                            <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 17px">
                                                                <a id="title1" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed" aria-expanded="false">
                                                                    පොදු ලෙජරයට ඇති සම්බන්ධතාවය
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapseFour" class="panel-collapse collapse" aria-expanded="false">
                                                            <div class="box-body bg-color">
                                                                <div class="row">
                                                                    <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                        <div class="panel-group" id="account">
                                                                            <div id="lala"class="panel panel-default">
                                                                                <div class="panel-heading" style="height:30px">
                                                                                    <h5 class="panel-title" style="font-size:15px">
                                                                                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#account" href="#collapseInterest">
                                                                                            <b>ලෙජර සම්බන්ධතා</b>
                                                                                        </a>
                                                                                    </h5>
                                                                                </div>

                                                                                <div class="col-lg-12">
                                                                                    <div class="col-md-12">
                                                                                        <div class="form-group bg-top" style="margin-top:15px;">

                                                                                            <label class="col-sm-2 input-sm text-left">මුල් මුදලේ </label>
                                                                                            <div class="col-md-2 ">
                                                                                                <input type="text" id="AAcctNoL5_1" name="AAcctNoL5_1" value="<%= acctL10.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                            </div>
                                                                                            <div class="col-md-5" >
                                                                                                <input type="text" id="AAcctNoL5_1_name" name="AAcctNoL5_1_name" value="<%= acctL10.getCDescriptionSinL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-family: AMALEE;font-size: 15px;">
                                                                                            </div>
                                                                                            <div class="col-md-1 ">
                                                                                                <a type="button" onclick="storeData(10)"  class="btn btn-default btn-sm">...</a>
                                                                                            </div>
                                                                                            <div class="col-md-2">
                                                                                                <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha number" placeholder="0"   value="<%= acctL10.getNNoteNoL5()%>" onkeypress='return event.charCode < 64'>
                                                                                                <input type="hidden" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0"  name="nDepAcctLevelID4" value="<%= acctL10.getNAcctLevelID5()%>">

                                                                                            </div>

                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-md-12">
                                                                                        <div class="form-group " style="margin-top:-10px;">
                                                                                            <label class="col-sm-2 input-sm text-left">පොළී මුදලේ </label>

                                                                                            <div class="col-md-2 ">
                                                                                                <input type="text" id="AAcctNoL5_2" name="AAcctNoL5_2" value="<%= acctL11.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                            </div>
                                                                                            <div class="col-md-5 ">
                                                                                                <input type="text" id="AAcctNoL5_2_name" name="AAcctNoL5_2_name" value="<%= acctL11.getCDescriptionSinL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-family: AMALEE;font-size: 15px;">
                                                                                            </div>
                                                                                            <div class="col-md-1 ">
                                                                                                <button type="button" onclick="storeData(11)" class="btn btn-default btn-sm">...</button>
                                                                                            </div>

                                                                                            <div class="col-md-2">
                                                                                                <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha number" placeholder="0"   value="<%= acctL11.getNNoteNoL5()%>" onkeypress='return event.charCode < 64'>
                                                                                                <input type="hidden" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="0"  name="nIntAcctLevelID4" value="<%= acctL11.getNAcctLevelID5()%>">

                                                                                            </div>
                                                                                        </div>
                                                                                    </div>

                                                                                </div>  
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6  bg-top" style="margin-left: 20px">
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" class="btn btn-warning btn-sm" aria-expanded="false">
                                                                                Back 
                                                                            </a>
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive" class="btn btn-info btn-sm" aria-expanded="false">
                                                                                Next
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>





                                                        <div class="panel box box-info bg-bottom bg-panelcolor">
                                                            <div class="">
                                                                <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 17px"">
                                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix" class="collapsed" aria-expanded="false">
                                                                        වෙනත් තොරතුරු
                                                                    </a>
                                                                </h4>
                                                            </div>
                                                            <div id="collapseSix" class="panel-collapse collapse" aria-expanded="false">
                                                                <div class="box-body bg-color">
                                                                    <div class="row">
                                                                        <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                            <div class="panel-group" id="account">
                                                                                <div class="panel panel-default">
                                                                                    <div class="panel-heading" style="height:30px">
                                                                                        <h5 class="panel-title" style="font-size:15px">
                                                                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#account" href="#collapseInterest">
                                                                                                <b>අකාර්ය ගණයට මරු කිරීම</b>
                                                                                            </a>
                                                                                        </h5>
                                                                                    </div>
                                                                                    <div id="collapseInterest" class="panel-collapse collapse in">
                                                                                        <div class="panel-body">
                                                                                            <div class="form-group bg-top" style="margin-bottom: -10px">
                                                                                                <div class="col-sm-4 " style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="col-md-12" style="margin-top:-15px">
                                                                                                                <div class="checkbox">
                                                                                                                    <label class=input-sm">
                                                                                                                        <%if (bChangeToInactive.equals("true")) {%>
                                                                                                                        <input checked class="input-sm" type="checkbox" id="bChangeToInactive" name="bChangeToInactive">
                                                                                                                        <%} else {%>
                                                                                                                        <input class="input-sm" type="checkbox" id="bChangeToInactive" name="bChangeToInactive">
                                                                                                                        <%}%>

                                                                                                                        අකාර්ය ලෙස මාරු කිරිම
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group">
                                                                                                                <label class="col-sm-1 input-sm"></label>
                                                                                                                <label class="col-sm-11 input-sm">අකාර්ය ලෙස මාරු කල යුතු කාල සීමාව</label>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -15px">
                                                                                                                <label class="col-sm-1 input-sm bg-top"></label>
                                                                                                                <div class="col-md-3 bg-top">
                                                                                                                    <input type="number" min="0" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0" id="nInacPeriod" name="nInacPeriod" min="0" value="<%=nInacPeriod%>">
                                                                                                                </div>
                                                                                                                <div class="col-md-8 bg-top">
                                                                                                                    <%
                                                                                                                        if (cInacPeriodType.equals("Day")) {
                                                                                                                    %>
                                                                                                                    <select class="form-control my-input input-sm" name="cInacPeriodType" id="cInacPeriodType">
                                                                                                                        <option  value="0">-තෝරන්න-</option>
                                                                                                                        <option selected value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                    </select>
                                                                                                                    <%} else if (cInacPeriodType.equals("Month")) {%>
                                                                                                                    <select class="form-control my-input input-sm" name="cInacPeriodType" id="cInacPeriodType">

                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option value="1">Day</option>
                                                                                                                        <option selected value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                    </select>
                                                                                                                    <%} else if (cInacPeriodType.equals("Year")) {%>
                                                                                                                    <select class="form-control my-input input-sm" name="cInacPeriodType" id="cInacPeriodType">
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option  value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option selected value="3">Year</option>
                                                                                                                    </select>
                                                                                                                    <%} else if (cInacPeriodType.equals("4")) {%>
                                                                                                                    <select class="form-control my-input input-sm" name="cInacPeriodType" id="cInacPeriodType">
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option  value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option selected value="3">Year</option>
                                                                                                                    </select>
                                                                                                                    <%} else { %>
                                                                                                                    <select class="form-control my-input input-sm" name="cInacPeriodType" id="cInacPeriodType">
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option  value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                    </select>
                                                                                                                    <%}%>

                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-4 " style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="col-md-12" style="margin-top:-15px">
                                                                                                                <div class="checkbox">
                                                                                                                    <label class=input-sm">
                                                                                                                        <% if (bChangeToHimiNopa.equals("true")) {%>
                                                                                                                        <input checked class="input-sm" type="checkbox" name="bChangeToHimiNopa" id="bChangeToHimiNopa">
                                                                                                                        <%} else {%>
                                                                                                                        <input class="input-sm" type="checkbox" name="bChangeToHimiNopa" id="bChangeToHimiNopa">
                                                                                                                        <%}%>

                                                                                                                        හිමිකම් නොපෑ ලෙජරයට මාරු කිරීම
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group">
                                                                                                                <label class="col-sm-1 input-sm"></label>
                                                                                                                <label class="col-sm-11 input-sm">හිමිකම් නොපෑ ලෙජරයට කලයුතු කාල සීමාව</label>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -15px">
                                                                                                                <label class="col-sm-1 input-sm bg-top"></label>
                                                                                                                <div class="col-md-3 bg-top">
                                                                                                                    <input type="number" min="0" class="form-control input-sm text-right convertSinhalaIskolaPotha" id="nHimiPeriod" name="nHimiPeriod" min="0" value="<%=nHimiPeriod%>">
                                                                                                                </div>
                                                                                                                <div class="col-md-8 bg-top">
                                                                                                                    <select class="form-control my-input input-sm" name="nHimiPeriodType" id="nHimiPeriodType">
                                                                                                                        <%if (nHimiPeriodType.equals("Day")) {%>
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option selected value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                        <%} else if (nHimiPeriodType.equals("Month")) {%>
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option value="1">Day</option>
                                                                                                                        <option selected value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                        <%} else if (nHimiPeriodType.equals("Year")) {%>
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                        <%} else if (nHimiPeriodType.equals("4")) {%>
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                        <%} else {%>
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <option value="1">Day</option>
                                                                                                                        <option value="2">Month</option>
                                                                                                                        <option value="3">Year</option>
                                                                                                                        <%}%>


                                                                                                                    </select>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-4 " style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="row">
                                                                                                                <div class="col-sm-12">
                                                                                                                    <div class="form-group">
                                                                                                                        <label class="control-label col-sm-5 input-sm">බෝනස් පොළිය :</label>
                                                                                                                        <div class="col-md-7">
                                                                                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha number" placeholder="0.0"  maxlength="25" name="nBonusIntRate" id="nBonusIntRate" value="<%=nBonusIntRate%>"  onkeypress='return event.charCode < 64'>
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                    <div class="form-group" style="margin-bottom: 5px">
                                                                                                                        <label class="control-label col-sm-5 input-sm">ණය මුදල :</label>
                                                                                                                        <div class="col-md-7">
                                                                                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha number" placeholder="0.0"  maxlength="25" name="nLoanAmount" id="nLoanAmount" value="<%=nLoanAmount%>" onkeypress='return event.charCode < 64'>
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
                                                                                </div>  
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6  bg-top">
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive" class="btn btn-warning btn-sm" aria-expanded="false">
                                                                                Back 
                                                                            </a>
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="btn btn-info btn-sm" aria-expanded="false">
                                                                                Next
                                                                            </a>
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
                                    <!--/.section B-->
                                </div>
                                <!--./Tab Content-->
                            </div>
                            <div class="col-md-12">
                                <div class="panel panel-default" style="margin-bottom: 10px">
                                    <div class="panel-footer">
                                        <button type="button" class="btn btn-warning btn-sm">Report</button>
                                        <div class="pull-right">
                                            <button type="button" class="btn btn-primary btn-sm" onclick="newBtnAction()">New</button>
                                            <button type="submit" class="btn btn-success btn-sm" id="subnitBtn">Save</button>
                                            <button type="button" class="btn btn-danger btn-sm">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            <input type="hidden" value="<%=nDepTypeID%>" name="nDepTypeID" id="nDepTypeID">                                                                                               
                        </form>
                    </div>
                </section>
            </aside>
            <!--..............................-->



            <input type="hidden" value="<%=nDepCatID%>" id="nDepCatIdHidden">
            <input type="hidden" value="<%=nIntCalID%>" id="nIntCalIdHidden">
            <input type="hidden" value="<%=nIntPayID%>" id="nIntPayIdHidden">
            <input type="hidden" value="<%=cInacPeriodType%>" id="cInacPeriodTypeHidden">
            <input type="hidden" value="<%=nHimiPeriodType%>" id="nHimiPeriodTypeHidden">

            <input type="hidden" value="<%=checkSaving%>" id="saveError">
            <input type="hidden" value="<%=request.getSession().getAttribute("moveToGL")%>" id="moveToGL">
            <%

                if (request.getSession().getAttribute("moveToGL") != null) {
                    request.getSession().removeAttribute("moveToGL");
                }
            %>
        </div>
        <!--.......wrapper end...................-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

        <script language="javascript" type="text/javascript">
//var one=0;
//var two=0;
//var three=0;
//var four=0;
//var five=0;
//var six=0;
//var seven=0;
//function tab(num){
//    if(num===1){
//        one=1;
//        document.getElementById('').click();
//        if(two===1){
//           document.getElementById('').click(); 
//        }
//        if(three===1){
//           document.getElementById('').click(); 
//        }
//        if(four===1){
//           document.getElementById('').click(); 
//        }
//        if(five===1){
//           document.getElementById('').click(); 
//        }
//        if(six===1){
//           document.getElementById('').click(); 
//        }
//        if(seven===1){
//           document.getElementById('').click(); 
//        } 
//    }
//}

                                                var nDepCatID = document.getElementById("nDepCatIdHidden").value;
                                                var nIntCalID = document.getElementById("nIntCalIdHidden").value;
                                                var nIntPayID = document.getElementById("nIntPayIdHidden").value;
                                                var cInacPeriodType = document.getElementById("cInacPeriodTypeHidden").value;
                                                var nHimiPeriodType = document.getElementById("nHimiPeriodTypeHidden").value;
                                                var saveError = document.getElementById("saveError").value;

                                                $(document).ready(function () {
                                                    $('#nDepCatID').val(nDepCatID);
                                                    $('#nIntCalID').val(nIntCalID);
                                                    $('#nIntPayID').val(nIntPayID);
//                                                    $('#cInacPeriodType').val(cInacPeriodType);
//                                                    $('#nHimiPeriodType').val(nHimiPeriodType);
                                                    if (saveError === "on") {
                                                        viewSelectionB();
                                                    }

                                                    if (document.getElementById('moveToGL').value === "1") {
                                                        $('#tabB').click();
                                                        $('#title1').click();
                                                        setTimeout("delete1();", 500);
                                                    }
                                                });

                                                function delete1() {
                                                    window.scrollBy(0, 1000);
                                                }


                                                function viewSelectionB() {
                                                    var idSecA = document.getElementById("secA");
                                                    var idSecB = document.getElementById("secB");
                                                    var idsectionA = document.getElementById("sectionA");
                                                    var idsectionB = document.getElementById("sectionB");

                                                    idSecA.className = "";
                                                    idsectionA.className = "tab-pane fade";
                                                    idSecB.className = "active";
                                                    idsectionB.className = "tab-pane fade in active";

                                                }



                                                function selectBtnAction(s) {
                                                    window.location = "../GetterBnkDepDepositTypesServlet?nDepTypeID=" + s;
                                                }
                                                function newBtnAction() {
                                                    window.location = "../GetterBnkDepDetailsServlet?cs=on&new=on";
                                                }

                                                //--------------------------------
                                                function validateNewSavingProtype(cForm) {
                                                    var bool = new Boolean();
                                                    bool = true;

                                                    var sysCode = cForm["sysCode"].value;
                                                    var nDepCatID = cForm["nDepCatID"].value;
                                                    var cDepName = cForm["cDepName"].value;
                                                    var cDepNameSin = cForm["cDepNameSin"].value;

                                                    var nMinParticipant = cForm["nMinParticipant"].value;
                                                    var nMaxParticipant = cForm["nMaxParticipant"].value;
                                                    var nMinAge = cForm["nMinAge"].value;
                                                    var nMaxAge = cForm["nMaxAge"].value;
                                                    var nOperatingGenderType = cForm["nOperatingGenderType"].value;
//                                                    //                                                ......................
                                                    var nMinAmtStart = cForm["nMinAmtStart"].value;
                                                    var nMinAmtContinue = cForm["nMinAmtContinue"].value;

                                                    var nMinMonths = cForm["nMinMonths"].value;
                                                    var nMaxMonths = cForm["nMaxMonths"].value;
                                                    var nNoOfDays = cForm["nNoOfDays"].value;
                                                    var nNoOfTimesPerMonth = cForm["nNoOfTimesPerMonth"].value;
                                                    var nMinAgeLimitWithdrawls = cForm["nMinAgeLimitWithdrawls"].value;

                                                    var nCurrentIntRate = cForm["nCurrentIntRate"].value;
                                                    var nIntCalID = cForm["nIntCalID"].value;
                                                    var nIntPayID = cForm["nIntPayID"].value;
                                                    var nMinAmtIntCal = cForm["nMinAmtIntCal"].value;
                                                    var nMinAmtIntCR = cForm["nMinAmtIntCR"].value;

                                                    var AAcctNoL5_1 = cForm["AAcctNoL5_1"].value;
                                                    var AAcctNoL5_1_name = cForm["AAcctNoL5_1_name"].value;

                                                    var AAcctNoL5_2 = cForm["AAcctNoL5_2"].value;
                                                    var AAcctNoL5_2_name = cForm["AAcctNoL5_2_name"].value;

                                                    var nInacPeriod = cForm["nInacPeriod"].value;
                                                    var cInacPeriodType = cForm["cInacPeriodType"].value;
                                                    var nHimiPeriod = cForm["nHimiPeriod"].value;
                                                    var nHimiPeriodType = cForm["nHimiPeriodType"].value;
                                                    var nBonusIntRate = cForm["nBonusIntRate"].value;
                                                    var nLoanAmount = cForm["nLoanAmount"].value;
//                                                    var nMemPositionID = cForm["nMemPositionID"].value;
//                                                    var nMemStatusID = cForm["nMemStatusID"].value;
//                                                    var dMemberShipDate = cForm["dMemberShipDate"].value;
//                                                    var nMemberShipFee = cForm["nMemberShipFee"].value;
//                                                    var nMemAreaID = cForm["nMemAreaID"].value;

                                                    if (sysCode === "0" || sysCode === "") {
                                                        bool = false;
                                                        document.getElementById('sysCode').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('sysCode').style.borderColor = "";
                                                    }
//                                                    
                                                    if (nDepCatID === "0" || nDepCatID === "") {
                                                        bool = false;
                                                        document.getElementById('nDepCatID').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nDepCatID').style.borderColor = "";
                                                    }

                                                    if (cDepName === "") {
                                                        bool = false;
                                                        document.getElementById('cDepName').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('cDepName').style.borderColor = "";
                                                    }

                                                    if (cDepNameSin === "") {
                                                        bool = false;
                                                        document.getElementById('cDepNameSin').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('cDepNameSin').style.borderColor = "";
                                                    }


                                                    if (nMinParticipant === "0" || nMinParticipant === "") {
                                                        bool = false;
                                                        document.getElementById('nMinParticipant').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinParticipant').style.borderColor = "";
                                                    }

                                                    if (nMaxParticipant === "0" || nMaxParticipant === "") {
                                                        bool = false;
                                                        document.getElementById('nMaxParticipant').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMaxParticipant').style.borderColor = "";
                                                    }
                                                    if (nMinAge === "0" || nMinAge === "") {
                                                        bool = false;
                                                        document.getElementById('nMinAge').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinAge').style.borderColor = "";
                                                    }

                                                    if (nMaxAge === "0" || nMaxAge === "") {
                                                        bool = false;
                                                        document.getElementById('nMaxAge').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMaxAge').style.borderColor = "";
                                                    }
//
                                                    if (!(nOperatingGenderType === "1" || nOperatingGenderType === "2" || nOperatingGenderType === "3")) {
                                                        bool = false;
                                                        alert('Please Select the Gender');
                                                    }


                                                    if (nMinAmtStart === "" || nMinAmtStart === "0") {
                                                        bool = false;
                                                        document.getElementById('nMinAmtStart').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinAmtStart').style.borderColor = "";
                                                    }

                                                    if (nMinAmtContinue === "" || nMinAmtContinue === "0") {
                                                        bool = false;
                                                        document.getElementById('nMinAmtContinue').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinAmtContinue').style.borderColor = "";
                                                    }

                                                    if (nMinMonths === "0" || nMinMonths === "") {
                                                        bool = false;
                                                        document.getElementById('nMinMonths').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinMonths').style.borderColor = "";
                                                    }
                                                    if (nMaxMonths === "0" || nMaxMonths === "") {
                                                        bool = false;
                                                        document.getElementById('nMaxMonths').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMaxMonths').style.borderColor = "";
                                                    }
                                                    if (nNoOfDays === "0" || nNoOfDays === "") {
                                                        bool = false;
                                                        document.getElementById('nNoOfDays').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nNoOfDays').style.borderColor = "";
                                                    }
//
                                                    if (nNoOfTimesPerMonth === "0" || nNoOfTimesPerMonth === "") {
                                                        bool = false;
                                                        document.getElementById('nNoOfTimesPerMonth').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nNoOfTimesPerMonth').style.borderColor = "";
                                                    }
                                                    if (nMinAgeLimitWithdrawls === "0" || nMinAgeLimitWithdrawls === "") {
                                                        bool = false;
                                                        document.getElementById('nMinAgeLimitWithdrawls').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinAgeLimitWithdrawls').style.borderColor = "";
                                                    }

                                                    if (nCurrentIntRate === "0" || nCurrentIntRate === "") {
                                                        bool = false;
                                                        document.getElementById('nCurrentIntRate').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nCurrentIntRate').style.borderColor = "";
                                                    }

                                                    if (nIntCalID === "0" || nIntCalID === "") {
                                                        bool = false;
                                                        document.getElementById('nIntCalID').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nIntCalID').style.borderColor = "";
                                                    }

                                                    if (nIntPayID === "0" || nIntPayID === "") {
                                                        bool = false;
                                                        document.getElementById('nIntPayID').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nIntPayID').style.borderColor = "";
                                                    }

                                                    if (nMinAmtIntCal === "0" || nMinAmtIntCal === "") {
                                                        bool = false;
                                                        document.getElementById('nMinAmtIntCal').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinAmtIntCal').style.borderColor = "";
                                                    }
                                                    if (nMinAmtIntCR === "0" || nMinAmtIntCR === "") {
                                                        bool = false;
                                                        document.getElementById('nMinAmtIntCR').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinAmtIntCR').style.borderColor = "";
                                                    }
                                                    if (AAcctNoL5_1 === "") {
                                                        bool = false;
                                                        document.getElementById('AAcctNoL5_1').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('AAcctNoL5_1').style.borderColor = "";
                                                    }
//
                                                    if (AAcctNoL5_1_name === "") {
                                                        bool = false;
                                                        document.getElementById('AAcctNoL5_1_name').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('AAcctNoL5_1_name').style.borderColor = "";
                                                    }
                                                    if (AAcctNoL5_2 === "") {
                                                        bool = false;
                                                        document.getElementById('AAcctNoL5_2').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('AAcctNoL5_2').style.borderColor = "";
                                                    }
                                                    if (AAcctNoL5_2_name === "") {
                                                        bool = false;
                                                        document.getElementById('AAcctNoL5_2_name').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('AAcctNoL5_2_name').style.borderColor = "";
                                                    }

                                                    if (nInacPeriod === "" || nInacPeriod === "0") {
                                                        bool = false;
                                                        document.getElementById('nInacPeriod').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nInacPeriod').style.borderColor = "";
                                                    }

                                                    if (cInacPeriodType === "0" || cInacPeriodType === "") {
                                                        bool = false;
                                                        document.getElementById('cInacPeriodType').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('cInacPeriodType').style.borderColor = "";
                                                    }

                                                    if (nHimiPeriod === "0" || nHimiPeriod === "") {
                                                        bool = false;
                                                        document.getElementById('nHimiPeriod').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nHimiPeriod').style.borderColor = "";
                                                    }
                                                    if (nHimiPeriodType === "0" || nHimiPeriodType === "") {
                                                        bool = false;
                                                        document.getElementById('nHimiPeriodType').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nHimiPeriodType').style.borderColor = "";
                                                    }
                                                    if (nBonusIntRate === "0" || nBonusIntRate === "") {
                                                        bool = false;
                                                        document.getElementById('nBonusIntRate').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nBonusIntRate').style.borderColor = "";
                                                    }
//
                                                    if (nLoanAmount === "0" || nLoanAmount === "") {
                                                        bool = false;
                                                        document.getElementById('nLoanAmount').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nLoanAmount').style.borderColor = "";
                                                    }
//                                                    if (nMemStatusID === "0") {
//                                                        bool = false;
//                                                        document.getElementById('nMemStatusID').style.borderColor = "red";
//                                                    } else {
//                                                        document.getElementById('nMemStatusID').style.borderColor = "";
//                                                    }
//                                                    if (dMemberShipDate === "") {
//                                                        bool = false;
//                                                        document.getElementById('dMemberShipDate').style.borderColor = "red";
//                                                    } else {
//                                                        document.getElementById('dMemberShipDate').style.borderColor = "";
//                                                    }
//                                                    if (nMemberShipFee === "") {
//                                                        bool = false;
//                                                        document.getElementById('nMemberShipFee').style.borderColor = "red";
//                                                    } else {
//                                                        document.getElementById('nMemberShipFee').style.borderColor = "";
//                                                    }
//                                                    if (nMemAreaID === "0") {
//                                                        bool = false;
//                                                        document.getElementById('nMemAreaID').style.borderColor = "red";
//                                                    } else {
//                                                        document.getElementById('nMemAreaID').style.borderColor = "";
//                                                    }

                                                    if (bool) {
                                                        document.forms["cForm"].submit();
                                                    } else {
                                                        alert("ඇතුලත් කිරීමට අවශ්‍ය තොරතුරු නිවැරදිව ඇතුලත් වී නොමැත...");
                                                    }
                                                }

                                                function storeData(num) {

                                                    var depTypeId = document.getElementById("nDepTypeID").value;
                                                    var cSysCode = document.getElementById("sysCode").value;
                                                    var nDepCatID = document.getElementById("nDepCatID").value;
                                                    var bActive = document.getElementById("bActive").checked;
                                                    var cDepName = document.getElementById("cDepName").value;
                                                    var cDepNameSin = document.getElementById("cDepNameSin").value;
                                                    var cDepNameTamil = document.getElementById("cDepNameTamil").value;


                                                    var nMinParticipant = document.getElementById("nMinParticipant").value;
                                                    var nMaxParticipant = document.getElementById("nMaxParticipant").value;
                                                    var nMinAge = document.getElementById("nMinAge").value;
                                                    var nMaxAge = document.getElementById("nMaxAge").value;
                                                    var nOperatingGenderType = $('input[name="nOperatingGenderType"]:checked').val();
                                                    var nMinAmtStart = document.getElementById("nMinAmtStart").value;
                                                    var nMinAmtContinue = document.getElementById("nMinAmtContinue").value;
                                                    var bInitialDepCash = document.getElementById("bInitialDepCash").checked;
                                                    var bInitialDepChque = document.getElementById("bInitialDepChque").checked;
                                                    var bMultipleAcct = document.getElementById("bMultipleAcct").checked;
                                                    var bInitialDepFTrnans = document.getElementById("bInitialDepFTrnans").checked;

                                                    var optionsDepTypes = $('input[name="optionsDepTypes"]:checked').val();
                                                    var nMaxMonths = document.getElementById("nMaxMonths").value;
                                                    var nMinMonths = document.getElementById("nMinMonths").value;
                                                    var nWithdrawlsAllowed = $('input[name="nWithdrawlsAllowed"]:checked').val();
                                                    var nNoOfDays = document.getElementById("nNoOfDays").value;
                                                    var nNoOfTimesPerMonth = document.getElementById("nNoOfTimesPerMonth").value;
                                                    var nMinAgeLimitWithdrawls = document.getElementById("nMinAgeLimitWithdrawls").value;

                                                    var nIntCalMethodID = $('input[name="nIntCalMethodID"]:checked').val();
                                                    var nCurrentIntRate = document.getElementById("nCurrentIntRate").value;
                                                    var nIntCalID = document.getElementById("nIntCalID").value;
                                                    var nIntPayID = document.getElementById("nIntPayID").value;
                                                    var nMinAmtIntCal = document.getElementById("nMinAmtIntCal").value;
                                                    var nMinAmtIntCR = document.getElementById("nMinAmtIntCR").value;
                                                    var nMinAmtIntCR = document.getElementById("nMinAmtIntCR").value;
                                                    var nInterestRoundMethod = $('input[name="nInterestRoundMethod"]:checked').val();


                                                    var bChangeToInactive = document.getElementById("bChangeToInactive").checked;
                                                    var nInacPeriod = document.getElementById("nInacPeriod").value;
                                                    var cInacPeriodType = document.getElementById("cInacPeriodType").value;
                                                    var bChangeToHimiNopa = document.getElementById("bChangeToHimiNopa").value;
                                                    var nHimiPeriodType = document.getElementById("nHimiPeriodType").value;
                                                    var nBonusIntRate = document.getElementById("nBonusIntRate").value;
                                                    var nLoanAmount = document.getElementById("nLoanAmount").value;
                                                    var nHimiPeriod = document.getElementById("nHimiPeriod").value;

                                                    window.location = "../StorePawnTypeDetailsServlet?depos=true&depTypeId=" + depTypeId + "&iid=" + num + "&cSysCode=" + cSysCode + "&nDepCatID=" + nDepCatID + "&bActive=" + bActive + "&cDepName=" + cDepName + "&cDepNameSin=" + cDepNameSin + "&cDepNameTamil=" + cDepNameTamil + "&nMinParticipant=" + nMinParticipant + "&nMaxParticipant=" + nMaxParticipant + "&nMinAge=" + nMinAge + "&nMaxAge=" + nMaxAge + "&nOperatingGenderType=" + nOperatingGenderType + "&nMinAmtStart=" + nMinAmtStart + "&nMinAmtContinue=" + nMinAmtContinue + "&bInitialDepCash=" + bInitialDepCash + "&bInitialDepChque=" + bInitialDepChque + "&bInitialDepFTrnans=" + bInitialDepFTrnans + "&optionsDepTypes=" + optionsDepTypes + "&nMaxMonths=" + nMaxMonths + "&nMinMonths=" + nMinMonths + "&nWithdrawlsAllowed=" + nWithdrawlsAllowed + "&nNoOfDays=" + nNoOfDays + "&nNoOfTimesPerMonth=" + nNoOfTimesPerMonth + "&nMinAgeLimitWithdrawls=" + nMinAgeLimitWithdrawls + "&nIntCalMethodID=" + nIntCalMethodID + "&nMinAmtIntCal=" + nMinAmtIntCal + "&nIntCalID=" + nIntCalID + "&nIntPayID=" + nIntPayID + "&nCurrentIntRate=" + nCurrentIntRate + "&nMinAmtIntCR=" + nMinAmtIntCR + "&nInterestRoundMethod=" + nInterestRoundMethod + "&bChangeToInactive=" + bChangeToInactive + "&nInacPeriod=" + nInacPeriod + "&cInacPeriodType=" + cInacPeriodType + "&bChangeToHimiNopa=" + bChangeToHimiNopa + "&nHimiPeriodType=" + nHimiPeriodType + "&nBonusIntRate=" + nBonusIntRate + "&nLoanAmount=" + nLoanAmount + "&bMultipleAcct=" + bMultipleAcct + "&nHimiPeriod=" + nHimiPeriod + "";

                                                }
                                                function forceNumeric() {
                                                    var $input = $(this);
                                                    $input.val($input.val().replace(/[^\d]+/g, '0'));
                                                }
                                                $('body').on('propertychange input', 'input[type="number"]', forceNumeric);
                                                $(document).ready(function () {
                                                    $('.number').mask('00000.00', {reverse: true});
                                                });
        </script>
    </body>
</html>
