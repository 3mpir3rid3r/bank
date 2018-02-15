<%-- 
    Document   : pawnType
    Created on : Dec 18, 2014, 4:22:28 PM
    Author     : nuwan
--%>

<%@page import="com.nbs.model.BnkPwnPawnTypes"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nbs.model.ActChartOfAcctL5"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="">
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
            .my-input{
                height:30px;
            } 
            .my-panel{
                height: 130px;
            }
            .bg-color{
                background:#005888;
            }
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head>
    <body class=" skin-blue  pace-done fixed">
        <%@include file="pawning_header.jsp"%>

        <!--.............................header End......................-->
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="pawning_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>

            <%
//            String keyNo1 = String.valueOf(session.getAttribute("keyNo1"));
                String pwnTypeName = String.valueOf(session.getAttribute("pwnTypeName"));
                String syscode = String.valueOf(session.getAttribute("syscode"));
                String intRate = String.valueOf(session.getAttribute("intRate"));
                String monthsDate = String.valueOf(session.getAttribute("monthsDate"));
                String data = String.valueOf(session.getAttribute("intData"));
                String datad[] = data.split(" ");
                String intData = "";

                if (datad.length != 0) {
                    if (datad.length == 1) {
                        intData = datad[0];
                    } else {
                        intData = datad[1];

                    }
                }

                String data2 = String.valueOf(session.getAttribute("round"));
                String data2d[] = data2.split(" ");
                String round = "";
                if (data2d.length != 0) {
                    if (data2d.length == 1) {
                        round = data2d[0];
                    } else {
                        round = data2d[1];
                    }
                }
                if (pwnTypeName.equals("null")) {

                    pwnTypeName = "";
                }
                if (syscode.equals("null")) {
                    syscode = "";
                }
                if (intRate.equals("null")) {
                    intRate = "0";
                }
                if (monthsDate.equals("null")) {
                    monthsDate = "";
                }
                if (intData.equals("null")) {
                    intData = "";
                }
                if (round.equals("null")) {
                    round = "0";
                }

                ActChartOfAcctL5 acctL1 = new ActChartOfAcctL5();
                ActChartOfAcctL5 acctL2 = new ActChartOfAcctL5();
                ActChartOfAcctL5 acctL3 = new ActChartOfAcctL5();
                ActChartOfAcctL5 acctL4 = new ActChartOfAcctL5();
                ActChartOfAcctL5 acctL5 = new ActChartOfAcctL5();
                ActChartOfAcctL5 acctL6 = new ActChartOfAcctL5();
                ActChartOfAcctL5 acctL7 = new ActChartOfAcctL5();

                if (session.getAttribute("acctL1") != null) {
                    acctL1 = (ActChartOfAcctL5) session.getAttribute("acctL1");
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

                List<ActChartOfAcctL5> acctL5s1 = new ArrayList<ActChartOfAcctL5>();
                List<ActChartOfAcctL5> acctL5s2 = new ArrayList<ActChartOfAcctL5>();
                List<ActChartOfAcctL5> acctL5s3 = new ArrayList<ActChartOfAcctL5>();
                List<ActChartOfAcctL5> acctL5s4 = new ArrayList<ActChartOfAcctL5>();
                List<ActChartOfAcctL5> acctL5s5 = new ArrayList<ActChartOfAcctL5>();
                List<ActChartOfAcctL5> acctL5s6 = new ArrayList<ActChartOfAcctL5>();
                List<ActChartOfAcctL5> acctL5s7 = new ArrayList<ActChartOfAcctL5>();

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

                if (session.getAttribute("keyNo") != null) {
                    String actId = String.valueOf(session.getAttribute("keyNo"));

                    int actIdNum = Integer.parseInt(actId);

                    if (actIdNum == 1) {
                        for (ActChartOfAcctL5 actl : acctL5s1) {
                            if (Integer.parseInt(request.getParameter("actid")) == actl.getNAcctLevelID5()) {

                                acctL1 = actl;
                                session.setAttribute("acctL1", acctL1);
                                session.removeAttribute("keyNo");

                            }
                        }
                    } else if (actIdNum == 2) {
                        for (ActChartOfAcctL5 actl : acctL5s2) {
                            if (Integer.parseInt(request.getParameter("actid")) == actl.getNAcctLevelID5()) {
                                acctL2 = actl;
                                session.setAttribute("acctL2", acctL2);
                                session.removeAttribute("keyNo");

                            }
                        }

                    } else if (actIdNum == 3) {
                        for (ActChartOfAcctL5 actl : acctL5s3) {
                            if (Integer.parseInt(request.getParameter("actid")) == actl.getNAcctLevelID5()) {
                                acctL3 = actl;
                                session.setAttribute("acctL3", acctL3);
                                session.removeAttribute("keyNo");

                            }
                        }
                    } else if (actIdNum == 4) {
                        for (ActChartOfAcctL5 actl : acctL5s4) {
                            if (Integer.parseInt(request.getParameter("actid")) == actl.getNAcctLevelID5()) {
                                acctL4 = actl;
                                session.setAttribute("acctL4", acctL4);
                                session.removeAttribute("keyNo");

                            }
                        }
                    } else if (actIdNum == 5) {
                        for (ActChartOfAcctL5 actl : acctL5s5) {
                            if (Integer.parseInt(request.getParameter("actid")) == actl.getNAcctLevelID5()) {
                                acctL5 = actl;
                                session.setAttribute("acctL5", acctL5);
                                session.removeAttribute("keyNo");

                            }
                        }
                    } else if (actIdNum == 6) {
                        for (ActChartOfAcctL5 actl : acctL5s6) {
                            if (Integer.parseInt(request.getParameter("actid")) == actl.getNAcctLevelID5()) {
                                acctL6 = actl;
                                session.setAttribute("acctL6", acctL6);
                                session.removeAttribute("keyNo");

                            }
                        }
                    } else if (Integer.parseInt(request.getParameter("actid")) == 7) {
                        for (ActChartOfAcctL5 actl : acctL5s7) {
                            if (Integer.parseInt(request.getParameter("actid")) == actl.getNAcctLevelID5()) {
                                acctL7 = actl;
                                session.setAttribute("acctL7", acctL7);
                                session.removeAttribute("keyNo");

                            }
                        }
                    }
                }

            %>
            <!--................................-->

            <aside id="content" class="right-side" style="background: #2fa4e7; height:895px" >

                <section class="content-header">
                    <h1>
                        Pawn Type
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">Pawn Type</li>
                    </ol>
                </section>
                <br>
                <form action="../SavePawnTypeServlet" method="post">
                    <div id="page-wrapper"   >


                        <div class="row">
                            <div class="col-lg-12" >
                                <div class="col-lg-12"  >
                                    <div class="col-lg-12" style="margin-left: -15px; ">
                                        <div  class="  panel panel-default my-panel" style="height: 150px" >
                                            <div class="panel-body"  >
                                                <%                                                    List<BnkPwnPawnTypes> lists = (List<BnkPwnPawnTypes>) session.getAttribute("allpawnTypes");

                                                    String id = String.valueOf(session.getAttribute("setComboSeleect"));
                                                    if (id.equals("null")) {
                                                        id = "0";
                                                    }

                                                %>
                                                <div class="form-group">
                                                    <label for="inputEmail3" class="col-sm-2 control-label pull-left">Pawn Type</label>
                                                    <div class="col-sm-7">
                                                        <select onchange="fillTextField();" class="form-control my-input" id="typeCmb" name="typeCmb" style="font-size: 12px;height:  32px">
                                                            <option  value="" style="display:none;"></option>
                                                            <%                                                                if (lists != null) {
                                                                    for (BnkPwnPawnTypes bppt : lists) {
                                                                        if (Integer.parseInt(id) == bppt.getNPawnTypeID()) {
                                                            %>

                                                            <option selected value="<%=bppt.getNPawnTypeID()%>" ><%=  bppt.getCPawnType()%> </option>
                                                            <%} else {%>

                                                            <option  value="<%=bppt.getNPawnTypeID()%>" ><%=  bppt.getCPawnType()%> </option>
                                                            <%
                                                                        }
                                                                    }
                                                                }%>
                                                        </select>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="form-group" >
                                                    <label for="inputPassword3" class="col-sm-2 control-label pull-left">New Pawn Type</label>
                                                    <div class="col-sm-7">
                                                        <input type="text" value="<%= pwnTypeName%>" class="form-control input-sm" id="newPawnTypeName"name="newPawnTypeName" placeholder="New Pawn Type">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="form-group">
                                                    <label for="inputPassword3" class="col-sm-2 control-label pull-left">System Code</label>
                                                    <div class="col-sm-2">
                                                        <input type="text" value="<%=syscode%>" class="form-control input-sm" id="systemCode" name="systemCode" placeholder="System Code">
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-lg-12" >
                                <div class="col-lg-12" >
                                    <div class="col-sm-8" style="margin-left: -15px;">
                                        <ul class="list-group col-lg-12" id="fontSize">
                                            <li class="list-group-item">
                                                <h4>පළමු ගෙවීම සඳහා පොලිය අය කිරීම</h4>
                                            </li>
                                            <input type="hidden" value="<%= intData%>" name="checkbox1" id="checkbox1" />
                                            <%

                                                if (intData.equals("1")) {

                                            %>                                            
                                            <li class="list-group-item " style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(1);" checked="true" type="radio" value="1" name="interestData">උකස තැබූ දින සිට ගෙවන දින දක්ව පොලිය</span>

                                            </li>
                                            <li class="list-group-item" style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(2);" type="radio" value="2" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන මසකට අඩු නම් මාසයම සඳහා පොළිය</span>
                                            </li>
                                            <li class="list-group-item" style="height: 80px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(3);" type="radio" value="3" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන දින 15ට අඩුනම් දින 15 පොළියද දින 15ත් 30ත් අතර නම් දින 30ට පොළිය</span>
                                            </li>
                                            <%} else if (intData.equals("2")) {%>
                                            <li class="list-group-item " style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input type="radio" value="1" onclick="getValue(1)" name="interestData">උකස තැබූ දින සිට ගෙවන දින දක්ව පොලිය</span>
                                            </li>
                                            <li class="list-group-item" style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input checked type="radio"onclick="getValue(2)" value="2" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන මසකට අඩු නම් මාසයම සඳහා පොළිය</span>
                                            </li>
                                            <li class="list-group-item" style="height: 80px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input type="radio" onclick="getValue(3)"value="3" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන දින 15ට අඩුනම් දින 15 පොළියද දින 15ත් 30ත් අතර නම් දින 30ට පොළිය</span>
                                            </li>

                                            <%} else if (intData.equals("3")) {%>
                                            <li class="list-group-item " style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(1)"  type="radio" value="1" name="interestData">උකස තැබූ දින සිට ගෙවන දින දක්ව පොලිය</span>
                                            </li>
                                            <li class="list-group-item" style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(2)" type="radio" value="2" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන මසකට අඩු නම් මාසයම සඳහා පොළිය</span>
                                            </li>
                                            <li class="list-group-item" style="height: 80px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(3)" checked type="radio" value="3" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන දින 15ට අඩුනම් දින 15 පොළියද දින 15ත් 30ත් අතර නම් දින 30ට පොළිය</span>
                                            </li>

                                            <%} else if (intData.equals("4")) {%>

                                            <%} else {%>
                                            <li class="list-group-item "  style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(1)" type="radio" checked value="1" name="interestData">උකස තැබූ දින සිට ගෙවන දින දක්ව පොලිය</span>
                                            </li>
                                            <li class="list-group-item" style="height: 79px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(2)" type="radio" value="2" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන මසකට අඩු නම් මාසයම සඳහා පොළිය</span>
                                            </li>
                                            <li class="list-group-item" style="height: 80px">

                                                <span class="radio-inline" style="font-size: 14px;padding-top: 10px"><input onclick="getValue(3)"type="radio" value="3" name="interestData">උකස තැබූ දින සිට ගෙවන දිනට දින ගනන දින 15ට අඩුනම් දින 15 පොළියද දින 15ත් 30ත් අතර නම් දින 30ට පොළිය</span>
                                            </li>
                                            <%}%>
                                        </ul> 
                                        <br>
                                    </div>

                                    <div class="col-lg-4" style="margin-left: 15px" >
                                        <ul class="list-group col-lg-12" id="fontSize" >
                                            <li class="list-group-item">
                                                පොළී අනුපතය
                                                <input class="form-control my-input" value="<%=intRate%>"id="intRate" name="intRate" type="text">
                                            </li>
                                            <li class="list-group-item">
                                                මාසයකට දින ගණන
                                                <input class="form-control my-input" value="<%=monthsDate%>" id="monthsDate" name="monthsDate" type="text">
                                            </li>
                                        </ul>
                                        <input type="hidden" name="checkbox2" id="checkbox2"value="<%= round%>"/>
                                        <% if (round.equals("1")) { %>
                                        <ul class="list-group col-lg-12" id="fontSize" style="margin-top: -10px;">
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input name="round" onclick="getValue1(1)" checked value="1" type="radio">වැටයීමක් නැත</span>

                                            </li>
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input name="round" onclick="getValue1(2)"value="2"  type="radio">සාමන්‍ය වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input name="round" onclick="getValue1(3)" value="3"  type="radio">ඉදිරියට වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input name="round" onclick="getValue1(4)" value="4" type="radio">පසුපසට වැටයීම</span>
                                            </li>
                                        </ul>
                                        <%} else if (round.equals("2")) {%>
                                        <ul class="list-group col-lg-12" id="fontSize" >
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(1)" name="round" value="1" type="radio">වැටයීමක් නැත</span>
                                            </li>
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(2)" name="round" checked value="2" type="radio">සාමන්‍ය වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(3)" name="round" value="3" type="radio">ඉදිරියට වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(4)" name="round" value="4" type="radio">පසුපසට වැටයීම</span>
                                            </li>
                                        </ul>
                                        <%} else if (round.equals("3")) {%>
                                        <ul class="list-group col-lg-12" id="fontSize" >
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(1)" name="round" value="1" type="radio">වැටයීමක් නැත</span>
                                            </li>
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(2)" name="round" value="2" type="radio">සාමන්‍ය වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(3)" name="round" checked value="3" type="radio">ඉදිරියට වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(4)" name="round" value="4" type="radio">පසුපසට වැටයීම</span>
                                            </li>
                                        </ul>
                                        <%} else if (round.equals("4")) {%>
                                        <ul class="list-group col-lg-12" id="fontSize" >
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(1)"name="round" value="1" type="radio">වැටයීමක් නැත</span>
                                            </li>
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(2)"name="round" value="2" type="radio">සාමන්‍ය වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(3)"name="round" value="3" type="radio">ඉදිරියට වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(4)"name="round" checked value="4" type="radio">පසුපසට වැටයීම</span>
                                            </li>
                                        </ul>
                                        <%} else {%>
                                        <ul class="list-group col-lg-12" id="fontSize" >
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(1)"  checked name="round" value="1" type="radio">වැටයීමක් නැත</span>
                                            </li>
                                            <li class="list-group-item" style="height: 36px">

                                                <span class="radio-inline"><input onclick="getValue1(2)" name="round" value="2" type="radio">සාමන්‍ය වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(3)" name="round" value="3" type="radio">ඉදිරියට වැටයීම</span>
                                            </li>
                                            <li class="list-group-item" style="height: 37px">

                                                <span class="radio-inline"><input onclick="getValue1(4)" name="round" value="4" type="radio">පසුපසට වැටයීම</span>
                                            </li>
                                        </ul>
                                        <%}%>

                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12" style="margin-left: -15px;">
                            <div class="col-lg-12"  >
                                <div class="box box-info bg-color " >
                                    <div class="box-body"  >
                                        <div class="panel panel-default "  >
                                            <label style="font-size: 20px"> ලෙජර සම්බන්ධතා</label>
                                            <div class="row">
                                                <br>
                                                <div class="col-lg-12">

                                                    <div class="col-md-12">

                                                        <div class="form-group bg-top" style="margin-top:-10px;">
                                                            <label class="control-label col-sm-2 input-sm">මුල් මුදලේ</label>
                                                            <div class="col-md-2">
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

                                                </div>
                                            </div>
                                            <div align="right" style="margin-top: 5px;margin-right:  28px">
                                                <input type="submit" class="btn btn-sm btn-success" value="Save"/>
                                                <input onclick="resetData();" type="reset" class="btn btn-sm btn-primary" value="New"/>     
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>                                                                          

                    </div>


                </form>
                <br>


            </aside>
        </div>
        <script src="../js/my.js" type="text/javascript"></script>
        <script src="../js/bootbox.js" type="text/javascript"></script>
        <script src="../js/bootbox.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery.min.js" type="text/javascript"></script>

        <script type="text/javascript">
                                                    function getValue(num) {
                                                        document.getElementById("checkbox1").value = num;
                                                    }

                                                    function getValue1(num) {

                                                        document.getElementById("checkbox2").value = num;

                                                    }

                                                    function storeData(num) {
                                                        var newPawnTypeName = document.getElementById("newPawnTypeName").value;
                                                        var systemCode = document.getElementById("systemCode").value;
                                                        var intRate = document.getElementById("intRate").value;

//                                                                   ` var checkedValue = $('.messageCheckbox:checked').val();
                                                        var monthsDate = document.getElementById("monthsDate").value;

                                                        var intData = document.getElementById("checkbox1").value;
                                                        var round = document.getElementById("checkbox2").value;
                                                        urlName = "";

                                                        window.location = "../StorePawnTypeDetailsServlet?newPawnTypeName=" + newPawnTypeName + "&systemCode=" + systemCode + "&intRate=" + intRate + "&monthsDate= " + monthsDate + "&intData= " + intData + "&round= " + round + "&iid=" + num + "";
                                                    }

                                                    function fillTextField() {
                                                        var id = document.getElementById('typeCmb').value;
                                                        window.location = "../StorePawnTypeDetailsServlet?id=" + id + "";

                                                    }
                                                    function resetData() {
                                                        window.location = "../StorePawnTypeDetailsServlet?reset=1";
                                                    }
        </script>


    </body>

</html>
