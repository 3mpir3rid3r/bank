<%-- 
    Document   : index
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : mmh
--%>

<%@page import="com.nbs.model.GenUser"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.ActChartOfAcctL5"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nbs.common.Alerts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loan</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

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
        </style>
        <script type="text/javascript" >
            <%
                if (request.getSession().getAttribute("bnkLonLoanTypesAll") == null) {
            %>
//            window.location = "../GetterBnkLonDetailsServlet";
            <%
                    request.getSession().removeAttribute("bnkLonLoanTypesAll");
                }
            %>
                
                
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

    <body class="skin-blue fixed" onload="" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include file="loan_header.jsp" %>
        
        <%@include file="../uni_convert/unicode_converter.jsp" %>
        <!--..............................-->

        <%
            String alert = "";
            String nLonTypeID = "0";
            String checkLoan = "";

            //----------------------
            String cSysCode = "";
            String nLonCatID = "0";
            String bActive = "";
            String cLonName = "";
            String cLonNameSin = "";
            String cLonNameTamil = "";
            //---------------------------
            String nMinParticipant = "0";
            String nMaxParticipant = "0";
            String nMinAge = "0";
            String nMaxAge = "0";
            String nMinLonAmt = "0";
            String nMaxLonAmt = "0";
            String nMinMonths = "0";
            String nMaxMonths = "0";
            String bMultipleAcct = "";
            //------------------------
            String nCurrentInt = "0";
            String nLonInterestMethodID = "0";
            String nIntCalMethodID = "";
            String nLonIntRoundID = "";
            String nPenaltyIntRate = "0";
            String nPIntRateForID = "0";
            String nPenaltyIntCal = "0";
            String nPIntCalForID = "0";
            String nPenaltyIntOP1 = "";
            String nPenaltyIntOP2 = "";
            //--------------------------------
            String nAcctLevelID4LoanCapital = "";
            String nAcctLevelID4Interest = "";
            String nAcctLevelID4Postage = "";
            String nAcctLevelID4Stationary = "";
            String nAcctLevelID4ArbitrationFees = "";
            String nAcctLevelID4LawFees = "";
            String nAcctLevelID4PenaltyInterest = "";

            if (request.getSession().getAttribute("cp") != null) {
                ArrayList<String> cp = (ArrayList<String>) request.getSession().getAttribute("cp");

                cSysCode = cp.get(0);
                System.out.println(cSysCode);
                nLonCatID = cp.get(1);
                bActive = cp.get(2);
                cLonName = cp.get(3);
                cLonNameSin = cp.get(4);

                if (cp.get(5) != null) {
                    cLonNameTamil = cp.get(5);
                }
                //---------------------------
                nMinParticipant = cp.get(6);
                nMaxParticipant = cp.get(7);
                nMinAge = cp.get(8);
                nMaxAge = cp.get(9);
                nMinLonAmt = cp.get(10);
                nMaxLonAmt = cp.get(11);
                nMinMonths = cp.get(12);
                nMaxMonths = cp.get(13);
                bMultipleAcct = cp.get(14);
                //------------------------
                nCurrentInt = cp.get(15);
                nLonInterestMethodID = cp.get(16);
                nIntCalMethodID = cp.get(17);
                nLonIntRoundID = cp.get(18);
                nPenaltyIntRate = cp.get(19);
                nPIntRateForID = cp.get(20);
                nPenaltyIntCal = cp.get(21);
                nPIntCalForID = cp.get(22);
                nPenaltyIntOP1 = cp.get(23);
                nPenaltyIntOP2 = cp.get(24);
                if (cp.size() > 25) {
                    //--------------------------------
                    nAcctLevelID4LoanCapital = cp.get(25);
                    nAcctLevelID4Interest = cp.get(26);
                    nAcctLevelID4Postage = cp.get(27);
                    nAcctLevelID4Stationary = cp.get(28);
                    nAcctLevelID4ArbitrationFees = cp.get(29);
                    nAcctLevelID4LawFees = cp.get(30);
                    nAcctLevelID4PenaltyInterest = cp.get(31);

                }
                request.getSession().removeAttribute("cp");

            }

            if (request.getSession().getAttribute("checkLoan") != null) {
                checkLoan = (String) request.getSession().getAttribute("checkLoan");
                request.getSession().removeAttribute("checkLoan");
            }

            if (request.getSession().getAttribute("mg") != null) {
                String mg = (String) request.getSession().getAttribute("mg");
                if (!("".equals(mg))) {
                    alert = Alerts.warningAlert("Something Wrong", mg + " You miss this Fields", "");
                }
                request.getSession().removeAttribute("mg");
            }

            if (request.getSession().getAttribute("nLonTypeID") != null) {
                nLonTypeID = (String) request.getSession().getAttribute("nLonTypeID");
                request.getSession().removeAttribute("nLonTypeID");
            }

            // *=**********************=* Legger affairs*+===================================================================+*
            ActChartOfAcctL5 acctL1 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL2 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL3 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL4 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL5 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL6 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL7 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL8 = new ActChartOfAcctL5();
            ActChartOfAcctL5 acctL9 = new ActChartOfAcctL5();

            if (session.getAttribute("acctL1") != null) {
                acctL1 = (ActChartOfAcctL5) session.getAttribute("acctL1");
                

        %>
        
        
        
        <input type="hidden" value="<%=request.getSession().getAttribute("moveToGL")%>" id="moveToGL">
            <%
                System.out.println("222222222222222  hhh  ="+request.getSession().getAttribute("moveToGL"));
                if (request.getSession().getAttribute("moveToGL") != null) {
                    request.getSession().removeAttribute("moveToGL");
                }
            %>
            
            
        <script type="text/javascript">

        </script>
        <%
            } else {
                acctL1.setCCAAcctNoL5("");
                acctL1.setCDescriptionSinL5("");
                acctL1.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL2") != null) {
                acctL2 = (ActChartOfAcctL5) session.getAttribute("acctL2");
            } else {
                acctL2.setCCAAcctNoL5("");
                acctL2.setCDescriptionSinL5("");
                acctL2.setNNoteNoL5(BigDecimal.ZERO);

            }

            if (session.getAttribute("acctL3") != null) {
                acctL3 = (ActChartOfAcctL5) session.getAttribute("acctL3");

            } else {
                acctL3.setCCAAcctNoL5("");
                acctL3.setCDescriptionSinL5("");
                acctL3.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL4") != null) {
                acctL4 = (ActChartOfAcctL5) session.getAttribute("acctL4");
            } else {
                acctL4.setCCAAcctNoL5("");
                acctL4.setCDescriptionSinL5("");
                acctL4.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL5") != null) {
                acctL5 = (ActChartOfAcctL5) session.getAttribute("acctL5");
            } else {
                acctL5.setCCAAcctNoL5("");
                acctL5.setCDescriptionSinL5("");
                acctL5.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL6") != null) {
                acctL6 = (ActChartOfAcctL5) session.getAttribute("acctL6");
            } else {
                acctL6.setCCAAcctNoL5("");
                acctL6.setCDescriptionSinL5("");
                acctL6.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL7") != null) {
                acctL7 = (ActChartOfAcctL5) session.getAttribute("acctL7");
            } else {
                acctL7.setCCAAcctNoL5("");
                acctL7.setCDescriptionSinL5("");
                acctL7.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL8") != null) {
                acctL8 = (ActChartOfAcctL5) session.getAttribute("acctL8");
            } else {
                acctL8.setCCAAcctNoL5("");
                acctL8.setCDescriptionSinL5("");
                acctL8.setNNoteNoL5(BigDecimal.ZERO);

            }
            if (session.getAttribute("acctL9") != null) {
                acctL9 = (ActChartOfAcctL5) session.getAttribute("acctL9");
            } else {
                acctL9.setCCAAcctNoL5("");
                acctL9.setCDescriptionSinL5("");
                acctL9.setNNoteNoL5(BigDecimal.ZERO);

            }

            List<ActChartOfAcctL5> acctL5s1 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s2 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s3 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s4 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s5 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s6 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s7 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s8 = new ArrayList<ActChartOfAcctL5>();
            List<ActChartOfAcctL5> acctL5s9 = new ArrayList<ActChartOfAcctL5>();

            if (session.getAttribute("chartOfAccount5Data1") != null) {
                acctL5s1 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data1");
            }

            if (session.getAttribute("chartOfAccount5Data2") != null) {
                acctL5s2 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data2");
            }
            if (session.getAttribute("chartOfAccount5Data3") != null) {
                acctL5s3 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data3");
            }
            if (session.getAttribute("chartOfAccount5Data4") != null) {
                acctL5s4 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data4");
            }
            if (session.getAttribute("chartOfAccount5Data5") != null) {
                acctL5s5 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data5");
            }
            if (session.getAttribute("chartOfAccount5Data6") != null) {
                acctL5s6 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data6");
            }
            if (session.getAttribute("chartOfAccount5Data7") != null) {
                acctL5s7 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data7");
            }
            if (session.getAttribute("chartOfAccount5Data8") != null) {
                acctL5s8 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data8");
            }
            if (session.getAttribute("chartOfAccount5Data9") != null) {
                acctL5s9 = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data9");
            }

            if (session.getAttribute("keyNo1") != null) {
                String actId = String.valueOf(session.getAttribute("keyNo1"));

                int actIdNum = Integer.parseInt(actId);

                if (actIdNum == 1) {
                    for (ActChartOfAcctL5 actl : acctL5s1) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {

                                acctL1 = actl;
                                session.setAttribute("acctL1", acctL1);
                                session.removeAttribute("keyNo1");

                            }
                        }
                    }
                } else if (actIdNum == 2) {
                    for (ActChartOfAcctL5 actl : acctL5s2) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL2 = actl;
                                session.setAttribute("acctL2", acctL2);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                } else if (actIdNum == 3) {
                    for (ActChartOfAcctL5 actl : acctL5s3) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL3 = actl;
                                session.setAttribute("acctL3", acctL3);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                } else if (actIdNum == 4) {
                    for (ActChartOfAcctL5 actl : acctL5s4) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL4 = actl;
                                session.setAttribute("acctL4", acctL4);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                } else if (actIdNum == 5) {
                    for (ActChartOfAcctL5 actl : acctL5s5) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL5 = actl;
                                session.setAttribute("acctL5", acctL5);
//                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                } else if (actIdNum == 6) {
                    for (ActChartOfAcctL5 actl : acctL5s6) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL6 = actl;
                                session.setAttribute("acctL6", acctL6);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                } else if (actIdNum == 7) {
                    for (ActChartOfAcctL5 actl : acctL5s7) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL7 = actl;
                                session.setAttribute("acctL7", acctL7);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                } else if (actIdNum == 8) {
                    for (ActChartOfAcctL5 actl : acctL5s8) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL8 = actl;
                                session.setAttribute("acctL8", acctL8);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                } else if (actIdNum == 9) {
                    for (ActChartOfAcctL5 actl : acctL5s9) {
                        if (session.getAttribute("actid") != null) {
                            if (Integer.parseInt(String.valueOf(session.getAttribute("actid"))) == actl.getNAcctLevelID5()) {
                                acctL9 = actl;
                                session.setAttribute("acctL9", acctL9);
                                session.removeAttribute("keyNo1");
                            }
                        }
                    }

                }
            }
            session.removeAttribute("actid");
            //*=========================================END Common LEGGER================================================*//      
            System.out.println(cSysCode + "A                  aasgddfhdfnnhiksjdnfaa");
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
                            <img src="../images/icon-user-default.png" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%= userName%></p>
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
                        ණය වර්ගයන්ගේ ආකෘති
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Saving</a></li>
                        <li class="active"><a href="#">ණය වර්ගයන්ගේ ආකෘති</a></li>
                    </ol>
                </section>
                <%=alert%>
                <section class="content">
                    <div class="row bg-top"  style="margin-bottom: -20px;height:auto">
                        <form class="form-horizontal" action="../NewBnkLonLoanTypesServlet" method="post" name="loan" onsubmit="validateNewLoanProtype(this);
                                return false;">
                            <div class="col-md-12" > 
                                <!--./Tab Section-->
                                <ul class="nav nav-tabs" id="myTab">
                                    <li id="secA" class="active"><a id="tabA" data-toggle="tab" href="#sectionA"><b>සාරාංශ දැක්ම</b></a></li>
                                    <li id="secB"><a id="tabB" data-toggle="tab" href="#sectionB"><b>විස්තරාත්මක දැක්ම</b></a></li>
                                </ul>
                                <!--./Tab Section-->
                                <!--./Tab Content-->
                                <div class="tab-content">
                                    <!--/.section A-->
                                    <div id="sectionA" class="tab-pane fade in active">
                                        <div class="panel panel-default" style="margin-bottom: 10px">
                                            <div class="panel-heading">
                                                <h6 class="panel-title">
                                                    ණය වර්ගයන්ගේ සාරාංශය
                                                </h6>
                                            </div>
                                            <div class="panel-body" style="background-color: #e7f0f7;">
                                                <div class="list-group col-lg-12" id="fontSize" style="padding: 0px">
                                                    <div class="zTreeDemoBackground left" style="margin:-14px;margin-top:-15px;margin-bottom:-25px">
                                                        <ul id="treeDemo" class="ztree" style="width: auto;height: 395px; ">
                                                            <div class="table-responsive">
                                                                <table class="table table-bordered table-hover table-responsive table-striped" id="table-style" data-toggle="table" data-cache="false" >
                                                                    <tr style="">
                                                                        <th class="text-center" style="width:10px"> අංකය</th>
                                                                        <th class="text-center" style="width:100px"> ණය කේතය</th>
                                                                        <th class="text-center"> ණය නම</th>
                                                                        <th class="text-center"> ණය නම(සිංහල)</th>
                                                                        <th class="text-center" style="width:100px"> ණය වර්ගය</th>
                                                                        <th class="text-center" style="width:10px"> පොළිය</th>
                                                                    </tr>
                                                                    <c:forEach items="${bnkLonLoanTypesAll}" var="bllt">
                                                                        <tr style="">
                                                                            <td style="width:10px">${bllt.nLonTypeID}</td>
                                                                            <td style="width:100px">${bllt.cSysCode}</td>
                                                                            <td style="width:300px">${bllt.cLonName}</td>
                                                                            <td style="width:300px;" class="convertSinhalaAmali ">${bllt.cLonNameSin}</td>
                                                                            <td style="width:200px;">${bllt.cLonCategory}</td>
                                                                            <td style="width:10px">${bllt.nCurrentInt}</td>
                                                                            <td style="width:10px"><button type="button" onclick="selectBtnAction(${bllt.nLonTypeID})" class="btn btn-primary btn-xs">select</button></td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                    <%
                                                                        request.getSession().removeAttribute("bnkLonLoanTypesAll");
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
                                                    <!--<form class="form-horizontal">-->
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">කේතය :</label>
                                                        <div class="col-md-3">
                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="කේතය" style="font-size:15px;" maxlength="3" name="cSysCode" id="cSysCode" value="<%=cSysCode%>">
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">ණය වර්ගය :</label>
                                                        <div class="col-sm-3">
                                                            <select class="form-control my-input input-sm" name="nLonCatID" id="nLonCatID">
                                                                <option value="0">-තෝරන්න-</option>
                                                                <c:forEach items="${bnkLonLoanCtegoryAll}" var="bllc">
                                                                    <option value="${bllc.key}" class="convertSinhalaAmali">${bllc.value}</option>
                                                                </c:forEach>
                                                            </select>     
                                                        </div>
                                                        <input type="hidden" value="0" name="storeCheckbox" id="storeCheckbox"/>
                                                        <div class="checkbox col-sm-3" name="bActive" id="bActive">
                                                            <% if (bActive.equals("true")) {%>
                                                            <input type="checkbox" id="checkBox1"checked > ක්‍රියාකාරී ගිණුම් වර්ග
                                                            <%} else {%>
                                                            <input type="checkbox" id="checkBox1" > ක්‍රියාකාරී ගිණුම් වර්ග
                                                            <%}%>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">ණය නම :</label>
                                                        <div class="col-md-6">
                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="ණය නම"  maxlength="65" name="cLonName" id="cLonName" value="<%=cLonName%>">
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">ණය නම(සිංහල) :</label>
                                                        <div class="col-md-6">
                                                            <input type="text" class="form-control input-sm convertSinhalaAmali" placeholder="ණය නම^සිංහල&"  maxlength="65" name="cLonNameSin" id="cLonNameSin" value="<%=cLonNameSin%>" onkeyup="keyup1(event, 'cLonNameSin')">
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-top:-10px">
                                                        <label class="control-label col-sm-3 input-sm">ණය නම(දෙමළ) :</label>
                                                        <div class="col-md-6">
                                                            <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="ණය නම(දෙමළ)"  maxlength="65" name="cLonNameTamil" id="cLonNameTamil" value="<%=cLonNameTamil%>">
                                                        </div>
                                                    </div>
                                                    <!--</form>-->
                                                </div>
                                                <div class="list-group col-lg-12" id="fontSize" style="padding: 0px;margin-top:-25px">
                                                    <div class="box-group" id="accordion">
                                                        <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                                        <div class="panel box box-info bg-bottom bg-panelcolor">
                                                            <div class="box-header b-header" >
                                                                <h4 class="box-title b-header logo " style="padding: 5px 10px 10px 10px;font-size: 18px">
                                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" class="">
                                                                        මුලීක ලක්ෂණ
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
                                                                                                <b>ගිණුම් ආරම්බ කිරීමේ උපදෙස්</b>
                                                                                            </a>
                                                                                        </h5>
                                                                                    </div>
                                                                                    <div id="collapseAccount" class="panel-collapse collapse in">
                                                                                        <div class="panel-body">
                                                                                            <div class="form-group bg-top">
                                                                                                <div class="col-sm-3 " style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title" style="font-size:15px">
                                                                                                                හිමිකම
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="form-group" style="margin-top:-10px">
                                                                                                                <label class="control-label col-sm-7 input-sm">අවම හවුල්කරයන් :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMinParticipant" id="nMinParticipant" value="<%=nMinParticipant%>" min="0">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                                <label class="control-label col-sm-7 input-sm">උපරිම හවුල්කරයන් :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMaxParticipant" id="nMaxParticipant" value="<%=nMaxParticipant%>" min="0">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-3" style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title" style="font-size:15px">
                                                                                                                වයස සීමාවන්
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color: #e7f0f7;">
                                                                                                            <div class="form-group" style="margin-top:-10px;">
                                                                                                                <label class="control-label col-sm-7 input-sm">අවම වයස් සීමා(වර්ෂ) :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMinAge" id="nMinAge" value="<%=nMinAge%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                                <label class="control-label col-sm-7 input-sm">උපරිම වයස් සීමා(වර්ෂ) :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMaxAge" id="nMaxAge" value="<%=nMaxAge%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-3" style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title" style="font-size:15px">
                                                                                                                ණය මුදල
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color: #e7f0f7;">
                                                                                                            <div class="form-group" style="margin-top:-10px;">
                                                                                                                <label class="control-label col-sm-7 input-sm">අවම ණය මුදල :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMinLonAmt" id="nMinLonAmt" value="<%=nMinLonAmt%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                                <label class="control-label col-sm-7 input-sm">උපරිම ණය මුදල :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMaxLonAmt" id="nMaxLonAmt" value="<%=nMaxLonAmt%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-3" style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title" style="font-size:15px">
                                                                                                                ණය වාර ගණන
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color: #e7f0f7;">
                                                                                                            <div class="form-group" style="margin-top:-10px;">
                                                                                                                <label class="control-label col-sm-7 input-sm">අවම ණය වාර ගණන :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMinMonths" id="nMinMonths" value="<%=nMinMonths%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -12px">
                                                                                                                <label class="control-label col-sm-7 input-sm">උපරිම ණය වාර ගණන :</label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha"  name="nMaxMonths" id="nMaxMonths" value="<%=nMaxMonths%>">
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div> 
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="form-group" style=" margin-bottom: -10px;margin-top: -15px">
                                                                                                <div class="checkbox col-sm-12" style="text-align: center">
                                                                                                    <%if (bMultipleAcct.equals("true")) {%>
                                                                                                    <input type="checkbox" checked="true" name="bMultipleAcct" id="bMultipleAcct"> එක් ගනුදෙනු කරුවෙකුට ගිනුම් කිහිපයක් අරම්භ කිරිමට අවසර දිම
                                                                                                    <%} else {%>
                                                                                                    <input type="checkbox" name="bMultipleAcct" id="bMultipleAcct"> එක් ගනුදෙනු කරුවෙකුට ගිනුම් කිහිපයක් අරම්භ කිරිමට අවසර දිම
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
                                                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="btn btn-info btn-sm collapsed" aria-expanded="false">
                                                                            Next
                                                                        </a>
                                                                    </div>  
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="panel box box-info bg-bottom bg-panelcolor">
                                                            <div class="box-header b-header">
                                                                <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 18px">
                                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed" aria-expanded="false">
                                                                        පොදු ලෙජර සම්බන්ධතාව 
                                                                    </a>
                                                                </h4>
                                                            </div>

                                                            <div id="collapseTwo" class="panel-collapse collapse" aria-expanded="false">
                                                                <div class="box-body bg-color">
                                                                    <div class="row">
                                                                        <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                            <div class="panel-group" id="account">
                                                                                <div class="panel panel-default">
                                                                                    <div id="collapseInterest" class="panel-collapse collapse in">
                                                                                        <div class="panel-body">
                                                                                            <div class="form-group bg-top" style="margin-bottom: -10px">
                                                                                                <div class="col-sm-8" style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title" style="font-size:15px">
                                                                                                                පොළී ගණනය කිරිමේ ආකාර
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="form-group">
                                                                                                                <label class="control-label col-sm-4 input-sm text-right">පොළී අනුපාතය : </label>
                                                                                                                <div class="col-md-3">
                                                                                                                    <input type="number" min="0" onclick="getValue1(2)" class="form-control input-sm convertSinhalaIskolaPotha"  name="nCurrentInt" id="nCurrentInt" value="<%=nCurrentInt%>">
                                                                                                                </div>
                                                                                                                <label class="col-sm-5 input-sm">% P.A </label>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;margin-bottom: -15px">
                                                                                                                <label class="control-label col-sm-4 input-sm text-right">පොළී ගණනය සෑම : </label>
                                                                                                                <div class="col-md-8">
                                                                                                                    <select class="form-control my-input input-sm" name="nLonInterestMethodID" id="nLonInterestMethodID">
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <c:forEach items="${bnkLonInterestMethodAll}" var="blirm">
                                                                                                                            <option class="convertSinhalaIskolaPotha"value="${blirm.key}">${blirm.value}</option>
                                                                                                                        </c:forEach>
                                                                                                                    </select>
                                                                                                                    <%
//                                                                                                                        request.getSession().removeAttribute("bnkLonInterestMethodAll");
                                                                                                                    %>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title" style="font-size:15px">
                                                                                                                දඩ පොළිය ගණනය කිරිමේ ආකාර
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;">
                                                                                                            <div class="form-group">
                                                                                                                <label class="control-label col-sm-4 input-sm text-right">දඩ පොළී අනුපතය : </label>
                                                                                                                <div class="col-md-2">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" style="font-size: 15px" name="nPenaltyIntRate" id="nPenaltyIntRate" value="<%=nPenaltyIntRate%>">
                                                                                                                </div>
                                                                                                                <label class="col-sm-1 input-sm">% Per </label>
                                                                                                                <div class="col-md-5">
                                                                                                                    <select class="form-control my-input input-sm" name="nPIntRateForID" id="nPIntRateForID">
                                                                                                                        <option value="0">-තෝරන්න-</option>

                                                                                                                        <c:forEach items="${bnkLonPenaltyIntRateForAll}" var="blpirf">

                                                                                                                            <option class="convertSinhalaIskolaPotha" value="${blpirf.key}">${blpirf.value}</option>
                                                                                                                        </c:forEach>
                                                                                                                    </select>
                                                                                                                    <%
//                                                                                                                        request.getSession().removeAttribute("bnkLonPenaltyIntRateForAll");
                                                                                                                    %>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-10px;">
                                                                                                                <label class="control-label col-sm-4 input-sm text-right">ගණනය කිරීම : </label>
                                                                                                                <div class="col-md-2">
                                                                                                                    <input type="number" min="0" class="form-control input-sm convertSinhalaIskolaPotha" style="font-size: 15px" name="nPenaltyIntCal" id="nPenaltyIntCal" value="<%=nPenaltyIntCal%>">
                                                                                                                </div>
                                                                                                                <label class="col-sm-1 input-sm"></label>
                                                                                                                <div class="col-md-4">
                                                                                                                    <select class="form-control my-input input-sm" name="nPIntCalForID" id="nPIntCalForID">
                                                                                                                        <option value="0">-තෝරන්න-</option>
                                                                                                                        <c:forEach items="${bnkLonPenaltyIntCalForAll}" var="blpicf">
                                                                                                                            <option class="convertSinhalaIskolaPotha" value="${blpicf.key}">${blpicf.value}</option>
                                                                                                                        </c:forEach>
                                                                                                                    </select>
                                                                                                                    <%
//                                                                                                                        request.getSession().removeAttribute("bnkLonPenaltyIntCalForAll");
                                                                                                                    %>
                                                                                                                </div>
                                                                                                                <label class="col-sm-1 input-sm">S </label>
                                                                                                            </div>
                                                                                                            <div class="col-md-12" style="margin-top:-15px;margin-bottom: -15px">
                                                                                                                <input type="hidden" name="intRadio" id="intRadio"/>
                                                                                                                <div class="col-md-6">
                                                                                                                    <%if (nPenaltyIntCal.equals("2")) {

                                                                                                                    %>
                                                                                                                    <div class="radio">
                                                                                                                        <label class="col-md-12 input-sm">
                                                                                                                            <input class="input-sm " type="radio"onclick="getValue1(1)" name="nPenaltyIntOP1" id="nPenaltyIntOP11" value="1" >
                                                                                                                            සියලු දිනයන්ට පොළී ගණනය
                                                                                                                        </label>
                                                                                                                    </div>
                                                                                                                    <div class="radio">
                                                                                                                        <label class="col-md-12 input-sm">
                                                                                                                            <input class="input-sm" type="radio" onclick="getValue1(2)" name="nPenaltyIntOP1" id="nPenaltyIntOP12" value="2" checked>
                                                                                                                            වැඩි වු දිනයන්ට පොළී ගණනය
                                                                                                                        </label>
                                                                                                                    </div>
                                                                                                                    <%} else {

                                                                                                                    %>

                                                                                                                    <div class="radio">
                                                                                                                        <label class="col-md-12 input-sm">
                                                                                                                            <input class="input-sm " type="radio"onclick="getValue1(1)" name="nPenaltyIntOP1" id="nPenaltyIntOP11" value="1"checked >
                                                                                                                            සියලු දිනයන්ට පොළී ගණනය
                                                                                                                        </label>
                                                                                                                    </div>
                                                                                                                    <div class="radio">
                                                                                                                        <label class="col-md-12 input-sm">
                                                                                                                            <input class="input-sm" type="radio" onclick="getValue1(2)" name="nPenaltyIntOP1" id="nPenaltyIntOP12" value="2" >
                                                                                                                            වැඩි වු දිනයන්ට පොළී ගණනය
                                                                                                                        </label>
                                                                                                                    </div>
                                                                                                                    <%}%>
                                                                                                                </div>
                                                                                                                <div class="col-md-6">
                                                                                                                    <div class="checkbox">
                                                                                                                        <label class="col-md-12 input-sm" style="color: #005f8d">කල් පිරේන දිනය නිවාඩු දිනයක් නම්</label>
                                                                                                                        <!--<center>-->
                                                                                                                        <label class="col-md-12 input-sm">
                                                                                                                            <%if (nPenaltyIntOP2.equals("true")) {%>
                                                                                                                            <input checked="" class="input-sm" type="checkbox" name="nPenaltyIntOP2" id="nPenaltyIntOP2">
                                                                                                                            <%} else {%>
                                                                                                                            <input class="input-sm" type="checkbox" name="nPenaltyIntOP2" id="nPenaltyIntOP2">
                                                                                                                            <%}%>
                                                                                                                            නිවාඩු දිනයන් හැර
                                                                                                                        </label>
                                                                                                                        <!--</center>-->
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-sm-4" style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading" style="height:30px">
                                                                                                            <h6 class="panel-title" style="font-size:15px">
                                                                                                                ආකාර
                                                                                                            </h6>
                                                                                                        </div>
                                                                                                        <div class="panel-body"  style="background-color: #e7f0f7;">
                                                                                                            <input type="hidden" name="intRadio1" id="intRadio1"/>
                                                                                                            <div class="col-md-12" style="margin-top:-10px;">

                                                                                                                <%if (nIntCalMethodID.equals("2")) {%>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(1)" name="nIntCalMethodID" id="nIntCalMethodID1" value="1" >
                                                                                                                        පොළිය නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(2)" name="nIntCalMethodID" id="nIntCalMethodID2" checked value="2">
                                                                                                                        හීනවන ශේෂ මත 
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(3)" name="nIntCalMethodID" id="nIntCalMethodID3" value="3">
                                                                                                                        හීනවන ශේෂය සමවාරික
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(4)" name="nIntCalMethodID" id="nIntCalMethodID4" value="4">
                                                                                                                        නියත පොළියකට
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <%} else if (nIntCalMethodID.equals("3")) {%>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(1)" name="nIntCalMethodID" id="nIntCalMethodID1" value="1" >
                                                                                                                        පොළිය නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(2)" name="nIntCalMethodID" id="nIntCalMethodID2" value="2">
                                                                                                                        හීනවන ශේෂ මත 
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(3)" name="nIntCalMethodID" id="nIntCalMethodID3" checked value="3">
                                                                                                                        හීනවන ශේෂය සමවාරික
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(4)" name="nIntCalMethodID" id="nIntCalMethodID4" value="4">
                                                                                                                        නියත පොළියකට
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <%} else if (nIntCalMethodID.equals("4")) {%>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(1)" name="nIntCalMethodID" id="nIntCalMethodID1" value="1" >
                                                                                                                        පොළිය නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(2)" name="nIntCalMethodID" id="nIntCalMethodID2" value="2">
                                                                                                                        හීනවන ශේෂ මත 
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(3)" name="nIntCalMethodID" id="nIntCalMethodID3" value="3">
                                                                                                                        හීනවන ශේෂය සමවාරික
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(4)" name="nIntCalMethodID" id="nIntCalMethodID4" value="4" checked>
                                                                                                                        නියත පොළියකට
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <%} else {%>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(1)" name="nIntCalMethodID" id="nIntCalMethodID1" value="1" checked >
                                                                                                                        පොළිය නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(2)" name="nIntCalMethodID" id="nIntCalMethodID2" value="2">
                                                                                                                        හීනවන ශේෂ මත 
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(3)" name="nIntCalMethodID" id="nIntCalMethodID3" value="3">
                                                                                                                        හීනවන ශේෂය සමවාරික
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue3(4)" name="nIntCalMethodID" id="nIntCalMethodID4" value="4" >
                                                                                                                        නියත පොළියකට
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <%}%>
                                                                                                            </div>
                                                                                                            <div class="form-group" style="margin-top:-7px;margin-bottom: -7px">
                                                                                                                <input type="hidden" name="roundRadio" id="roundRadio"/>
                                                                                                                <label class="col-sm-12 input-sm" style="color: #005f8d">පොළිය වැටයීම</label>
                                                                                                            </div>
                                                                                                            <%if (nLonIntRoundID.equals("2")) {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px;margin-bottom: 0px">
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onchange="getValue2(1)" name="nLonIntRoundID" id="nLonIntRoundID1" value="1" >
                                                                                                                        වැටයීම්  නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(2)" name="nLonIntRoundID" id="nLonIntRoundID2" value="2" checked>
                                                                                                                        පොදු වැටයීම් 
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(3)" name="nLonIntRoundID" id="nLonIntRoundID3" value="3">
                                                                                                                        වැඩි අගයකට 10.20-->11.00
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(4)"name="nLonIntRoundID" id="nLonIntRoundID4" value="4">
                                                                                                                        අඩු අගයකට 10.66-->11.00
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <%} else if (nLonIntRoundID.equals("3")) {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px;margin-bottom: 0px">
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(1)" name="nLonIntRoundID" id="nLonIntRoundID1" value="1" >
                                                                                                                        වැටයීම්  නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(2)" name="nLonIntRoundID" id="nLonIntRoundID2" value="2">
                                                                                                                        පොදු වැටයීම් 
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(3)" name="nLonIntRoundID" id="nLonIntRoundID3" value="3" checked>
                                                                                                                        වැඩි අගයකට 10.20-->11.00
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(4)"name="nLonIntRoundID" id="nLonIntRoundID4" value="4">
                                                                                                                        අඩු අගයකට 10.66-->11.00
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <%} else if (nLonIntRoundID.equals("4")) {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px;margin-bottom: 0px">
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onchange="getValue2(1)" onclick="getValue2(1)" name="nLonIntRoundID" id="nLonIntRoundID1" value="1" >
                                                                                                                        වැටයීම්  නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onchange="getValue2(1)"onclick="getValue2(2)" name="nLonIntRoundID" id="nLonIntRoundID2" value="2">
                                                                                                                        පොදු වැටයීම් 
                                                                                                                    </label>
                                                                                                                </div> 
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(3)" name="nLonIntRoundID" id="nLonIntRoundID3" value="3">
                                                                                                                        වැඩි අගයකට 10.20-->11.00
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(4)"name="nLonIntRoundID" id="nLonIntRoundID4" value="4" checked>
                                                                                                                        අඩු අගයකට 10.66-->11.00
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <%} else {%>
                                                                                                            <div class="col-md-12" style="margin-top:-10px;margin-bottom: 0px">
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onchange="getValue2(1)" onclick="getValue2(1)" name="nLonIntRoundID" id="nLonIntRoundID1" value="1" checked>
                                                                                                                        වැටයීම්  නැත
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onchange="getValue2(1)"onclick="getValue2(2)" name="nLonIntRoundID" id="nLonIntRoundID2" value="2">
                                                                                                                        පොදු වැටයීම් 
                                                                                                                    </label>
                                                                                                                </div> 
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(3)" name="nLonIntRoundID" id="nLonIntRoundID3" value="3">
                                                                                                                        වැඩි අගයකට 10.20-->11.00
                                                                                                                    </label>
                                                                                                                </div>
                                                                                                                <div class="radio">
                                                                                                                    <label class="col-md-12 input-sm">
                                                                                                                        <input class="input-sm" type="radio" onclick="getValue2(4)"name="nLonIntRoundID" id="nLonIntRoundID4" value="4">
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
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="btn btn-warning btn-sm" aria-expanded="false">
                                                                                Back 
                                                                            </a>
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="btn btn-info btn-sm" aria-expanded="false">
                                                                                Next
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="panel box box-info bg-bottom bg-panelcolor">
                                                            <div class="box-header b-header">
                                                                <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 18px">
                                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed" aria-expanded="false">
                                                                        වරකට පොළිය
                                                                    </a>
                                                                </h4>
                                                            </div>
                                                            <div id="collapseThree" class="panel-collapse collapse" aria-expanded="false">
                                                                <div class="box-body bg-color">
                                                                    <div class="row">
                                                                        <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                            <div class="panel-group" id="account">
                                                                                <div class="panel panel-default">
                                                                                    <div id="collapseInterest" class="panel-collapse collapse in">
                                                                                        <div class="panel-body">
                                                                                            <div class="form-group bg-top" style="margin-bottom: -10px">
                                                                                                <div class="col-sm-12 "  style="padding:0px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-body"  style="background-color:  #e7f0f7;padding:0px">
                                                                                                            <div class="col-md-12" style="padding: 0px">
                                                                                                                <table class="table table-bordered" style="margin-bottom: -9px">
                                                                                                                    <tbody>
                                                                                                                        <tr style="background-color: #00c0ef">
                                                                                                                            <th class="text-center" width="200px">ගිණුම් කේතය</th>
                                                                                                                            <th class="text-center">විස්තරය</th>
                                                                                                                            <th class="text-center" width="210px">%</th>
                                                                                                                        </tr>
                                                                                                                    </tbody>
                                                                                                                </table>
                                                                                                                <div class="zTreeDemoBackground left">
                                                                                                                    <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">
                                                                                                                        <table class="table table-bordered">
                                                                                                                            <tbody>
                                                                                                                                <tr>
                                                                                                                                    <td  width="190px"></td>
                                                                                                                                    <td></td>
                                                                                                                                    <td width="190px"></td>
                                                                                                                                </tr>
                                                                                                                            </tbody>
                                                                                                                        </table>
                                                                                                                    </ul>
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
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="btn btn-warning btn-sm" aria-expanded="false">
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
                                                            <div class="box-header b-header">
                                                                <% if (request.getParameter("selectCollapse") != null) { %>
                                                                <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 18px">
                                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed" aria-expanded="true">
                                                                        ලෙජරයන්
                                                                    </a>
                                                                </h4>
                                                                <%} else {%>
                                                                <h4 class="box-title b-header logo" style="padding: 5px 10px 10px 10px;font-size: 18px">
                                                                    <a id="autoClick2Nd" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed" aria-expanded="true">
                                                                        ලෙජරයන්
                                                                    </a>
                                                                </h4>
                                                                <%}%>
                                                            </div>
                                                            <div id="collapseFour" class="panel-collapse collapse" aria-expanded="true">
                                                                <div class="box-body bg-color">
                                                                    <div class="row">
                                                                        <div class="col-md-12 bg-top" style="padding: 5px;margin-bottom: -10px">
                                                                            <div class="panel-group" id="account">
                                                                                <div class="panel panel-default">
                                                                                    <div class="panel-heading" style="height:30px">
                                                                                        <h5 class="panel-title" style="font-size:15px">
                                                                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#account" href="#collapseInterest">
                                                                                                <b>ලෙජර සම්බන්ධතා</b>
                                                                                            </a>
                                                                                        </h5>
                                                                                    </div>
                                                                                    <div id="collapseInterest" class="panel-collapse collapse in">
                                                                                        <div class="panel-body">
                                                                                            <div class="form-group bg-top" style="margin-bottom: -10px">
                                                                                                <div class="col-sm-12 " style="padding:2px">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-body" style="background-color:  #e7f0f7;">
                                                                                                            <!--<center>-->
                                                                                                            <div class="form-group" style="margin-top:-10px">
                                                                                                                <label class="control-label col-sm-4 input-sm"></label>
                                                                                                                <label class="col-sm-8 input-sm text-left">ලෙජර සම්බන්ධතා</label>
                                                                                                            </div>
                                                                                                            <div class="col-lg-12">

                                                                                                                <div class="col-md-12">

                                                                                                                    <div class="form-group bg-top" style="margin-top:-10px;">
                                                                                                                        <label class="control-label col-sm-2 input-sm">මුල් මුදලේ</label>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="hidden" name="num1_1" value="<%=acctL1.getNAcctLevelID5()%>"/>
                                                                                                                            <input type="text" name="num1" id="num1" value="<%= acctL1.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc1" id="desc1" value="<%= acctL1.getCDescriptionSinL5()%>" class="form-control input-sm text-right convertSinhalaAmali">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(1);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm1" id="numm1" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%= acctL1.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <label class="control-label col-sm-2 input-sm">පොළීයේ</label>
                                                                                                                        <input type="hidden" name="num1_2" value="<%=acctL2.getNAcctLevelID5()%>"/>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num2" id="num2" value="<%= acctL2.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc2" id="desc2" value="<%= acctL2.getCDescriptionSinL5()%>" class="form-control input-sm text-right convertSinhalaAmali">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(2);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm2" id="numm2" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%= acctL3.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <label class="control-label col-sm-2 input-sm">තැපැල් ගාස්තු</label>
                                                                                                                        <input type="hidden" name="num1_3" value="<%=acctL3.getNAcctLevelID5()%>"/>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num3" id="num3" value="<%= acctL3.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc3" id="desc3" value="<%= acctL3.getCDescriptionUniL5()%>"class="form-control input-sm text-right convertSinhalaAmali">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(3);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm3" id="numm3" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%= acctL3.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <label class="control-label col-sm-2 input-sm">ලිපි ගාස්තු</label>
                                                                                                                        <input type="hidden" name="num1_4" value="<%=acctL4.getNAcctLevelID5()%>"/>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num4" id="num4" value="<%= acctL4.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc4" id="desc4" value="<%= acctL4.getCDescriptionSinL5()%>"class="form-control input-sm text-right convertSinhalaAmali">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(4);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm4" id="numm4" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%= acctL4.getCDescriptionSinL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <input type="hidden" name="num1_5" value="<%=acctL5.getNAcctLevelID5()%>"/>
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <label class="control-label col-sm-2 input-sm">වෙන්දේසි</label>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num5" id="num5" value="<%= acctL5.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc5" id="desc5" value="<%=acctL5.getCDescriptionSinL5()%>"class="form-control input-sm text-right convertSinhalaAmali">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(5);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm5" id="numm5" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%=acctL5.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <input type="hidden" name="num1_6" value="<%=acctL6.getNAcctLevelID5()%>"/>
                                                                                                                        <label class="control-label col-sm-2 input-sm">පොළී සහනය</label>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num6" id="num6" value="<%=acctL6.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc6" id="desc6" class="form-control input-sm text-right convertSinhalaAmali" value="<%=acctL6.getCDescriptionSinL5()%>">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(6);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm6" id="numm6" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%=acctL6.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <input type="hidden" name="num1_7" value="<%=acctL7.getNAcctLevelID5()%>"/>
                                                                                                                        <label class="control-label col-sm-2 input-sm">තීරක ගාස්තු</label>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num7" id="num7" value="<%=acctL7.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc7" id="desc7" class="form-control input-sm text-right convertSinhalaAmali" value="<%=acctL7.getCDescriptionSinL5()%>">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(7);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm7" id="numm7" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%=acctL7.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <input type="hidden" name="num1_8" value="<%=acctL8.getNAcctLevelID5()%>"/>
                                                                                                                        <label class="control-label col-sm-2 input-sm">නඩු ගාස්තු</label>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num8" id="num8" value="<%=acctL8.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc8" id="desc8" class="form-control input-sm text-right convertSinhalaAmali" value="<%=acctL8.getCDescriptionSinL5()%>">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(8);" class="btn btn-default btn-sm">.........</button>

                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm8" id="numm8" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%=acctL8.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                                <div class="col-lg-12">
                                                                                                                    <div class="form-group bg-top" >
                                                                                                                        <input type="hidden" name="num1_9" value="<%=acctL9.getNAcctLevelID5()%>"/>
                                                                                                                        <label class="control-label col-sm-2 input-sm">දඩ පොළී</label>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="num9" id="num9" value="<%=acctL9.getCCAAcctNoL5()%>" class="form-control input-sm text-right convertSinhalaIskolaPotha" >
                                                                                                                        </div>
                                                                                                                        <div class="col-md-5">
                                                                                                                            <input type="text" name="desc9" id="desc9" class="form-control input-sm text-right convertSinhalaAmali" value="<%=acctL9.getCDescriptionSinL5()%>">
                                                                                                                        </div>
                                                                                                                        <div class="col-md-1">
                                                                                                                            <button type="button" onclick="storeData(9);" class="btn btn-default btn-sm">.........</button>
                                                                                                                        </div>
                                                                                                                        <div class="col-md-2">
                                                                                                                            <input type="text" name="numm9" id="numm9" class="form-control input-sm text-right convertSinhalaIskolaPotha"   value="<%=acctL9.getNNoteNoL5()%>">
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <!--</center>-->
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
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="btn btn-warning btn-sm" aria-expanded="false">
                                                                                Back 
                                                                            </a>
                                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="btn btn-info btn-sm" aria-expanded="false">
                                                                                Start
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
                                        <button type="submit" class="btn btn-warning btn-sm">Report</button>
                                        <div class="pull-right">
                                            <button type="button" class="btn btn-primary btn-sm" onclick="newBtnAction()">New</button>
                                            <button type="submit" class="btn btn-success btn-sm">Save</button>
                                            <button type="button" class="btn btn-danger btn-sm">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" value="<%=nLonTypeID%>" name="nLonTypeID" id="nLonTypeID"> 
                            <input type="hidden" value="0" name="forCreateNewId"/>
                        </form>
                    </div>
                </section>
            </aside>
            <!--..............................-->


            <input type="hidden" value="<%=nLonCatID%>" id="nLonCatIdHidden">
            <input type="hidden" value="<%=nLonInterestMethodID%>" id="nLonInterestMethodIdHidden">
            <input type="hidden" value="<%=nPIntRateForID%>" id="nPIntRateForIdHidden">
            <input type="hidden" value="<%=nPIntCalForID%>" id="nPIntCalForIdHidden">
            <input type="hidden" value="<%=checkLoan%>" id="saveError">
            <input type="hidden" value="<%=request.getSession().getAttribute("moveToGL2")%>" id="moveToGL2">

            <%
                //
                String legger = String.valueOf(session.getAttribute("leggerSelect"));
                request.getSession().removeAttribute("leggerSelect");

                if (request.getSession().getAttribute("moveToGL2") != null) {
                    request.getSession().removeAttribute("moveToGL2");
                }

            %>
            <input type="hidden" value="<%=legger%>" id="legger">

        </div>
        <!--.......wrapper end...................-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
        <script language="javascript" type="text/javascript">

                                                var nLonCatID = document.getElementById("nLonCatIdHidden").value;
                                                var nLonInterestMethodID = document.getElementById("nLonInterestMethodIdHidden").value;
                                                var nPIntRateForID = document.getElementById("nPIntRateForIdHidden").value;
                                                var nPIntCalForID = document.getElementById("nPIntCalForIdHidden").value;
                                                var saveError = document.getElementById("saveError").value;
                                                var legger = document.getElementById("legger").value;

                                                $(document).ready(function () {

                                                    $('#nLonCatID').val(nLonCatID);
                                                    $('#nLonInterestMethodID').val(nLonInterestMethodID);
                                                    $('#nPIntRateForID').val(nPIntRateForID);
                                                    $('#nPIntCalForID').val(nPIntCalForID);
                                                    if (saveError === "on") {

                                                        viewSelectionB();

                                                    }

//                                                    if (document.getElementById('moveToGL2').value === "1") {
//                                                        $('#autoClick2Nd').click();
//                                                        setTimeout(delete1(), 500);
//                                                    }
                                                });

//                                                function delete1() {
//                                                    window.scrollBy(0, 1000);
//                                                }


                                                function viewSelectionB() {
                                                    var idSecA = document.getElementById("secA");
                                                    var idSecB = document.getElementById("secB");
                                                    var idsectionA = document.getElementById("sectionA");
                                                    var idsectionB = document.getElementById("sectionB");

                                                    idSecB.className = "active";
                                                    idsectionB.className = "tab-pane fade in active";
                                                    idSecA.className = "";
                                                    idsectionA.className = "tab-pane fade";
                                                }

                                                function selectBtnAction(l) {
                                                    window.location = "../GetterBnkLonLoanTypesServlet?nLonTypeID=" + l + "&selectId=on";
                                                }
                                                function newBtnAction() {
                                                    window.location = "../GetterBnkLonDetailsServlet?ls=on&new=on";
                                                }

                                                //--------------------------------
                                                function validateNewLoanProtype(cForm) {

                                                    var bool = new Boolean();
                                                    bool = true;

                                                    var cSysCode = cForm["cSysCode"].value;
                                                    var nLonCatID = cForm["nLonCatID"].value;
                                                    var cLonName = cForm["cLonName"].value;
                                                    var cLonNameSin = cForm["cLonNameSin"].value;
                                                    var cLonNameTamil = cForm["cLonNameTamil"].value;

                                                    var nMinParticipant = cForm["nMinParticipant"].value;
                                                    var nMaxParticipant = cForm["nMaxParticipant"].value;
                                                    var nMinAge = cForm["nMinAge"].value;
                                                    var nMaxAge = cForm["nMaxAge"].value;
                                                    //                                                ......................
                                                    var nMinLonAmt = cForm["nMinLonAmt"].value;
                                                    var nMaxLonAmt = cForm["nMaxLonAmt"].value;

                                                    var nMinMonths = cForm["nMinMonths"].value;
                                                    var nMaxMonths = cForm["nMaxMonths"].value;
                                                    var nCurrentInt = cForm["nCurrentInt"].value;
                                                    var nLonInterestMethodID = cForm["nLonInterestMethodID"].value;
                                                    var nPenaltyIntRate = cForm["nPenaltyIntRate"].value;

                                                    var nPenaltyIntCal = cForm["nPenaltyIntCal"].value;
                                                    var nPIntRateForID = cForm["nPIntRateForID"].value;
                                                    var nPIntCalForID = cForm["nPIntCalForID"].value;

                                                    var num1 = cForm["num1"].value;
                                                    var desc1 = cForm["desc1"].value;
                                                    var numm1 = cForm["numm1"].value;

                                                    var num2 = cForm["num2"].value;
                                                    var desc2 = cForm["desc2"].value;
                                                    var numm2 = cForm["numm2"].value;
                                                    //
                                                    var num3 = cForm["num3"].value;
                                                    var desc3 = cForm["desc3"].value;
                                                    var numm3 = cForm["numm3"].value;

                                                    var num4 = cForm["num4"].value;
                                                    var desc4 = cForm["desc4"].value;
                                                    var numm4 = cForm["numm4"].value;

                                                    var num6 = cForm["num6"].value;
                                                    var desc6 = cForm["desc6"].value;
                                                    var numm6 = cForm["numm6"].value;

                                                    var num7 = cForm["num7"].value;
                                                    var desc7 = cForm["desc7"].value;
                                                    var numm7 = cForm["numm7"].value;

                                                    var num8 = cForm["num8"].value;
                                                    var desc8 = cForm["desc8"].value;
                                                    var numm8 = cForm["numm8"].value;

                                                    var num9 = cForm["num9"].value;
                                                    var desc9 = cForm["desc9"].value;
                                                    var numm9 = cForm["numm9"].value;
                                                    //                                                    
                                                    //                                                    var nHimiPeriodType = cForm["nHimiPeriodType"].value;
                                                    //                                                    var nBonusIntRate = cForm["nBonusIntRate"].value;
                                                    //                                                    var nLoanAmount = cForm["nLoanAmount"].value;

                                                    if (cSysCode === "0" || cSysCode === "") {
                                                        bool = false;
                                                        document.getElementById('cSysCode').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('cSysCode').style.borderColor = "";
                                                    }

                                                    if (nLonCatID === "0" || nLonCatID === "") {
                                                        bool = false;
                                                        document.getElementById('nLonCatID').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nLonCatID').style.borderColor = "";
                                                    }

                                                    if (cLonName === "") {
                                                        bool = false;
                                                        document.getElementById('cLonName').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('cLonName').style.borderColor = "";
                                                    }

                                                    if (cLonNameSin === "") {
                                                        bool = false;
                                                        document.getElementById('cLonNameSin').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('cLonNameSin').style.borderColor = "";
                                                    }


                                                    if (cLonNameTamil === "0" || cLonNameTamil === "") {
                                                        bool = false;
                                                        document.getElementById('cLonNameTamil').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('cLonNameTamil').style.borderColor = "";
                                                    }
                                                    //
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

                                                    if (nMaxAge === "" || nMaxAge === "0") {
                                                        bool = false;
                                                        document.getElementById('nMaxAge').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMaxAge').style.borderColor = "";
                                                    }

                                                    if (nMinLonAmt === "" || nMinLonAmt === "0") {
                                                        bool = false;
                                                        document.getElementById('nMinLonAmt').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMinLonAmt').style.borderColor = "";
                                                    }

                                                    if (nMaxLonAmt === "0" || nMaxLonAmt === "") {
                                                        bool = false;
                                                        document.getElementById('nMaxLonAmt').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nMaxLonAmt').style.borderColor = "";
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
                                                    //
                                                    if (nCurrentInt === "0" || nCurrentInt === "") {
                                                        bool = false;
                                                        document.getElementById('nCurrentInt').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nCurrentInt').style.borderColor = "";
                                                    }

                                                    if (nLonInterestMethodID === "0" || nLonInterestMethodID === "") {
                                                        bool = false;
                                                        document.getElementById('nLonInterestMethodID').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nLonInterestMethodID').style.borderColor = "";
                                                    }

                                                    if (nPenaltyIntRate === "0" || nPenaltyIntRate === "") {
                                                        bool = false;
                                                        document.getElementById('nPenaltyIntRate').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nPenaltyIntRate').style.borderColor = "";
                                                    }

                                                    if (nPenaltyIntCal === "0" || nPenaltyIntCal === "") {
                                                        bool = false;
                                                        document.getElementById('nPenaltyIntCal').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nPenaltyIntCal').style.borderColor = "";
                                                    }

                                                    if (nPIntRateForID === "0" || nPIntRateForID === "") {
                                                        bool = false;
                                                        document.getElementById('nPIntRateForID').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nPIntRateForID').style.borderColor = "";
                                                    }

                                                    if (nPIntCalForID === "0" || nPIntCalForID === "") {
                                                        bool = false;
                                                        document.getElementById('nPIntCalForID').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('nPIntCalForID').style.borderColor = "";
                                                    }

                                                    if (num1 === "") {
                                                        bool = false;
                                                        document.getElementById('num1').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num1').style.borderColor = "";
                                                    }

                                                    if (desc1 === "") {
                                                        bool = false;
                                                        document.getElementById('desc1').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc1').style.borderColor = "";
                                                    }
                                                    ////
                                                    if (numm1 === "") {
                                                        bool = false;
                                                        document.getElementById('numm1').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm1').style.borderColor = "";
                                                    }

                                                    if (num2 === "") {
                                                        bool = false;
                                                        document.getElementById('num2').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num2').style.borderColor = "";
                                                    }

                                                    if (desc2 === "") {
                                                        bool = false;
                                                        document.getElementById('desc2').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc2').style.borderColor = "";
                                                    }
                                                    //
                                                    if (numm2 === "") {
                                                        bool = false;
                                                        document.getElementById('numm2').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm2').style.borderColor = "";
                                                    }
                                                    //
                                                    if (num3 === "") {
                                                        bool = false;
                                                        document.getElementById('num3').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num3').style.borderColor = "";
                                                    }
                                                    //
                                                    if (desc3 === "") {
                                                        bool = false;
                                                        document.getElementById('desc3').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc3').style.borderColor = "";
                                                    }
                                                    if (numm3 === "") {
                                                        bool = false;
                                                        document.getElementById('numm3').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm3').style.borderColor = "";
                                                    }


                                                    if (num4 === "") {
                                                        bool = false;
                                                        document.getElementById('num4').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num4').style.borderColor = "";
                                                    }
                                                    //
                                                    if (desc4 === "") {
                                                        bool = false;
                                                        document.getElementById('desc4').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc4').style.borderColor = "";
                                                    }
                                                    if (numm4 === "") {
                                                        bool = false;
                                                        document.getElementById('numm4').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm4').style.borderColor = "";
                                                    }



                                                    if (num6 === "") {
                                                        bool = false;
                                                        document.getElementById('num6').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num6').style.borderColor = "";
                                                    }
                                                    //
                                                    if (desc6 === "") {
                                                        bool = false;
                                                        document.getElementById('desc6').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc6').style.borderColor = "";
                                                    }
                                                    if (numm6 === "") {
                                                        bool = false;
                                                        document.getElementById('numm6').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm6').style.borderColor = "";
                                                    }


                                                    if (num7 === "") {
                                                        bool = false;
                                                        document.getElementById('num7').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num7').style.borderColor = "";
                                                    }
                                                    //
                                                    if (desc7 === "") {
                                                        bool = false;
                                                        document.getElementById('desc7').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc7').style.borderColor = "";
                                                    }
                                                    if (numm7 === "") {
                                                        bool = false;
                                                        document.getElementById('numm7').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm7').style.borderColor = "";
                                                    }


                                                    if (num8 === "") {
                                                        bool = false;
                                                        document.getElementById('num8').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num8').style.borderColor = "";
                                                    }
                                                    //
                                                    if (desc8 === "") {
                                                        bool = false;
                                                        document.getElementById('desc8').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc8').style.borderColor = "";
                                                    }
                                                    if (numm8 === "") {
                                                        bool = false;
                                                        document.getElementById('numm8').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm8').style.borderColor = "";
                                                    }


                                                    if (num9 === "") {
                                                        bool = false;
                                                        document.getElementById('num9').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('num9').style.borderColor = "";
                                                    }
                                                    //
                                                    if (desc9 === "") {
                                                        bool = false;
                                                        document.getElementById('desc9').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('desc9').style.borderColor = "";
                                                    }
                                                    if (numm9 === "") {
                                                        bool = false;
                                                        document.getElementById('numm9').style.borderColor = "red";
                                                    } else {
                                                        document.getElementById('numm9').style.borderColor = "";
                                                    }


                                                    //                                                    if (nBonusIntRate === "0" || nBonusIntRate === "") {
                                                    //                                                        bool = false;
                                                    //                                                        document.getElementById('nBonusIntRate').style.borderColor = "red";
                                                    //                                                    } else {
                                                    //                                                        document.getElementById('nBonusIntRate').style.borderColor = "";
                                                    //                                                    }
                                                    ////
                                                    //                                                    if (nLoanAmount === "0" || nLoanAmount === "") {
                                                    //                                                        bool = false;
                                                    //                                                        document.getElementById('nLoanAmount').style.borderColor = "red";
                                                    //                                                    } else {
                                                    //                                                        document.getElementById('nLoanAmount').style.borderColor = "";
                                                    //                                                    }

                                                    if (bool) {
                                                        document.forms["cForm"].submit();
                                                    } else {
                                                        alert("ඇතුලත් කිරීමට අවශ්‍ය තොරතුරු නිවැරදිව ඇතුලත් වී නොමැත...");
                                                    }


                                                }

                                                /// this function using for common legger part
                                                function storeData(num) {
                                                    //       

                                                    var cSysCode = document.getElementById("cSysCode").value;
                                                    var nLonCatID = document.getElementById("nLonCatID").value;
                                                    var bActive = document.getElementById("checkBox1").checked;
                                                    var cLonName = document.getElementById("cLonName").value;
                                                    var cLonNameSin = document.getElementById("cLonNameSin").value;
                                                    var cLonNameTamil = document.getElementById("cLonNameTamil").value;

                                                    var nMinParticipant = document.getElementById("nMinParticipant").value;
                                                    var nMinAge = document.getElementById("nMinAge").value;
                                                    var nMinLonAmt = document.getElementById("nMinLonAmt").value;
                                                    var nMinMonths = document.getElementById("nMinMonths").value;
                                                    var nMaxParticipant = document.getElementById("nMaxParticipant").value;
                                                    var nMaxAge = document.getElementById("nMaxAge").value;
                                                    var nMaxLonAmt = document.getElementById("nMaxLonAmt").value;
                                                    var nMaxMonths = document.getElementById("nMaxMonths").value;
                                                    var bMultipleAcct = document.getElementById("bMultipleAcct").checked;

                                                    var nPenaltyIntRate = document.getElementById("nPenaltyIntRate").value;
                                                    var nPIntRateForID = document.getElementById("nPIntRateForID").value;
                                                    var nCurrentInt = document.getElementById("nCurrentInt").value;
                                                    var nLonInterestMethodID = document.getElementById("nLonInterestMethodID").value;
                                                    var nPenaltyIntCal = document.getElementById("nPenaltyIntCal").value;
                                                    var nPIntCalForID = document.getElementById("nPIntCalForID").value;
                                                    var nPenaltyIntOP2 = document.getElementById("nPenaltyIntOP2").checked;
                                                    //                                                     document.getElementById("intRadio").value;
                                                    //                                                     document.getElementById("roundRadio").value;
                                                    //                                                     document.getElementById("intRadio1").value;


                                                    var intRadio = $('input[name="nIntCalMethodID"]:checked').val();
                                                    var roundRadio = $('input[name="nLonIntRoundID"]:checked').val();
                                                    var intRadio1 = $('input[name="nPenaltyIntOP1"]:checked').val();
                                                    window.location = "../StorePawnTypeDetailsServlet?iid=" + num + "&type=1&cSysCode=" + cSysCode + "&nLonCatID=" + nLonCatID + "&cLonName=" + cLonName + "&cLonNameSin=" + cLonNameSin + "&cLonNameTamil" + cLonNameTamil + "&bActive=" + bActive + "&nMinParticipant=" + nMinParticipant + "&nMinAge=" + nMinAge + "&nMinLonAmt=" + nMinLonAmt + "&nMinMonths=" + nMinMonths + "&nMaxParticipant=" + nMaxParticipant + "&nMaxAge=" + nMaxAge + "&nMaxLonAmt=" + nMaxLonAmt + "&nMaxMonths=" + nMaxMonths + "&bMultipleAcct=" + bMultipleAcct + "&nPenaltyIntRate=" + nPenaltyIntRate + "&nPIntRateForID=" + nPIntRateForID + "&nCurrentInt=" + nCurrentInt + "&nLonInterestMethodID=" + nLonInterestMethodID + "&nPenaltyIntCal=" + nPenaltyIntCal + "&nPIntCalForID=" + nPIntCalForID + "&nPenaltyIntOP2=" + nPenaltyIntOP2 + "&intRadio=" + intRadio + "&roundRadio=" + roundRadio + "&intRadio1=" + intRadio1 + "";
                                                }


                                                function getValue1(num) {
                                                    document.getElementById("intRadio").value = num;
                                                }
                                                function getValue2(num) {
                                                    document.getElementById("roundRadio").value = num;
                                                }
                                                function getValue3(num) {
                                                    document.getElementById("intRadio1").value = num;
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
                                                
                                                
                                                
                                                
                                                $(document).ready(function () {
//                                                    $('#nDepCatID').val(nDepCatID);
//                                                    $('#nIntCalID').val(nIntCalID);
//                                                    $('#nIntPayID').val(nIntPayID);
////                                                    $('#cInacPeriodType').val(cInacPeriodType);
////                                                    $('#nHimiPeriodType').val(nHimiPeriodType);
//                                                    if (saveError === "on") {
//                                                        viewSelectionB();
//                                                    }
//

                                                    if (document.getElementById('moveToGL').value === "1") {
                                                        $('#tabB').click();
                                                        $('#autoClick2Nd').click();
                                                        setTimeout("delete1();", 500);
                                                    }
                                                });

                                                function delete1() {
                                                    window.scrollBy(0, 1000);
                                                }
                                                
                                                
                                                
        </script>
    </body>


</html>
