<%-- 
    Document   : customer_details
    Created on : Jan 26, 2015, 3:30:24 PM
    Author     : mmh
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.MemMemberShipMaster"%>
<%@page import="com.nbs.model.MemRefMemberShipStatus"%>
<%@page import="com.nbs.model.BnkRefMemberAreasGroups"%>
<%@page import="java.util.AbstractList"%>
<%@page import="com.nbs.model.BnkRefMemberStatus"%>
<%@page import="com.nbs.model.BnkRefMemberPosition"%>
<%@page import="com.nbs.model.BnkRefMemberAreas"%>
<%@page import="com.nbs.model.GenRefReligion"%>
<%@page import="com.nbs.model.GenRefNationality"%>
<%@page import="com.nbs.model.GenRefCivilStatus"%>
<%@page import="com.nbs.model.GenRefCustomerTittle"%>
<%@page import="com.nbs.model.BnkRefCustomerCategory"%>
<%@page import="java.math.BigInteger"%>
<%@page import="com.nbs.controller.get.GetViewCustomerServlet"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="com.nbs.common.Alerts"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>සාමාජික තොරතුරු</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;                
            }.bg-top1{
                margin-top: -15px;                
            }
            .bg-searchheight{
                height:222px;                
            }
            .bg-pad{
                padding-right:0px;                
            }
            #content *{
                font-size-adjust: 0.52;
            }
        </style>

    </head> 
    <%    String alert = "";

        if (request.getParameter("mg") != null) {
            String mg = request.getParameter("mg");
            if ("error".equals(mg)) {
                alert = Alerts.warningAlert("Something Wrong", "You miss some Fields", "");
            } else if ("saved".equals(mg)) {
                alert = Alerts.successAlert("success", "Member Successfully saved");
            } else if ("updated".equals(mg)) {
                alert = Alerts.successAlert("success", "Customer Successfully updated");
            }
        }
    %>

    <body class="skin-blue  pace-done fixed">

        <!--./header-->
        <%@include file="../teller/teller_header.jsp" %>
        <!--./header-->

        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--./left-side-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- ./sidebar-->
                <%@include file="../teller/teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--./left-side-->

            <!--./right-side-->
            <aside id="content"  class="right-side">
                <!-- ./Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        සාමාජික තොරතුරු
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">සාමාජික තොරතුරු</li>
                    </ol>
                </section>
                <!-- ./Content Header (Page header) -->

                <!--./page content-->

                <%=alert%>

                <%
                    MemMemberShipMaster master = new MemMemberShipMaster();
                    if (session.getAttribute("Searchedmember") != null) {
                        master = (MemMemberShipMaster) session.getAttribute("Searchedmember");
                        System.out.println(master.getBFeMale());
                        if (master.getCBAddLine1() == null) {
                            master.setCBAddLine1("");
                        }
                        if (master.getCBAddLine2() == null) {
                            master.setCBAddLine2("");
                        }
                        if (master.getCBAddLine3() == null) {
                            master.setCBAddLine3("");
                        }
                        if (master.getCBAddLine4() == null) {
                            master.setCBAddLine4("");
                        }

                        if (master.getCPAddLine1() == null) {
                            master.setCPAddLine1("");
                        }
                        if (master.getCPAddLine2() == null) {
                            master.setCPAddLine2("");
                        }
                        if (master.getCPAddLine3() == null) {
                            master.setCPAddLine3("");
                        }
                        if (master.getCPAddLine4() == null) {
                            master.setCPAddLine4("");
                        }
                        if (master.getCBEmail() == null) {
                            master.setCBEmail("");
                        }
                        if (master.getCPEmail() == null) {
                            master.setCPEmail("");
                        }
                        if (master.getCBTelNo1() == null) {
                            master.setCBTelNo1("");
                        }
                        if (master.getCBTelNo2() == null) {
                            master.setCBTelNo2("");
                        }
                        if (master.getCPTelNo1() == null) {
                            master.setCPTelNo1("");
                        }
                        if (master.getCPTelNo2() == null) {
                            master.setCPTelNo2("");
                        }
                        if (master.getCFullName() == null) {
                            master.setCFullName("");
                        }
                        if (master.getCFullNameAma() == null) {
                            master.setCFullNameAma("");
                        }
                        if (master.getCInitials() == null) {
                            master.setCInitials("");
                        }

                        if (master.getCLastName() == null) {
                            master.setCLastName("");
                        }
                        if (master.getCMemberShipNo() == null) {
                            master.setCMemberShipNo("");
                        }
                        if (master.getCMotherMadName() == null) {
                            master.setCMotherMadName("");
                        }
                        if (master.getCNICNo() == null) {
                            master.setCNICNo("");
                        }
                        if (master.getCUseName() == null) {
                            master.setCUseName("");
                        }
                        if (master.getDAddDate() == null) {
                            master.setDAddDate(new Date());
                        }
                        if (master.getDConfirmDate() == null) {
                            master.setDAddDate(new Date());
                        }
                        if (master.getDDateOfBirth() == null) {
                            master.setDDateOfBirth(new Date());
                        }
                        if (master.getDEditDate() == null) {
                            master.setDEditDate(new Date());
                        }
                        if (master.getDJoineDate() == null) {
                            master.setDJoineDate(new Date());
                        }
                        if (master.getDNICIssuedDate() == null) {
                            master.setDNICIssuedDate(new Date());
                        }
                        if (master.getDMemberShipDate() == null) {
                            master.setDMemberShipDate(new Date());
                        }
                        if (master.getNMemberShipFee() == null) {
                            master.setNMemberShipFee(BigDecimal.ZERO);
                        }

                        if (master.getCOcupation() == null) {
                            master.setCOcupation("");
                        }

                        if (master.getNNoOfShares() == null) {
                            master.setNNoOfShares(0);
                        }
                    } else {
                        master.setNMemberID((long) 00000000);
                        master.setBFeMale(false);
                        master.setCBAddLine1("");
                        master.setCBAddLine2("");
                        master.setCBAddLine3("");
                        master.setCBAddLine4("");
                        master.setCPAddLine1("");
                        master.setCPAddLine2("");
                        master.setCPAddLine3("");
                        master.setCPAddLine4("");
                        master.setCBEmail("");
                        master.setCPEmail("");
                        master.setCBTelNo1("");
                        master.setCBTelNo2("");
                        master.setCPTelNo1("");
                        master.setCPTelNo2("");
                        master.setCFullName("");
                        master.setCFullNameAma("");
                        master.setCInitials("");
                        master.setCLastName("");
                        master.setCMemberShipNo("");
                        master.setCMotherMadName("");
                        master.setCNICNo("");
                        master.setCUseName("");
                        master.setDAddDate(new Date());
                        master.setDConfirmDate(new Date());
                        master.setDDateOfBirth(new Date());
                        master.setDJoineDate(new Date());
                        master.setDMemberShipDate(new Date());
                        master.setDNICIssuedDate(new Date());
                        master.setNMemberShipFee(BigDecimal.ZERO);
                        master.setNNoOfShares(0);
                        master.setCOcupation("");

                    }

                %>


                <section class="content">
                    <form class="form-horizontal" action="../NewMember"  name="member" method="post">

                        <input type="hidden" value="" name="pk">
                        <div class="row bg-top">
                            <div class="col-md-9 bg-pad" >
                                <div class="box box-info bg-color" style=" height:250px">
                                    <div class="box-body">                 

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">සාමාජික අංකය :</label>
                                                    <div class="col-sm-4">
                                                        <div class="input-group">
                                                            <input  disabled value="<%= master.getNMemberID()%>"  type="text"  class="form-control input-sm" name="nmemberNo" id="nmemberNo" >
                                                            <input type="hidden" value="<%= master.getNMemberID()%>" name="memberNo1" id="memberNo1">
                                                            <span class="input-group-btn">

                                                                <button class="btn btn-info btn-flat btn-sm" type="button" onclick="cMIFBtnAction()"><i class="fa fa-search"></i></button>

                                                            </span>
                                                        </div>
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right">සාමාජික තත්වය :</label>
                                                    <div class="col-md-4">
                                                        <% List<MemRefMemberShipStatus> mrmsses = (List<MemRefMemberShipStatus>) session.getAttribute("Possition"); %>
                                                        <select   required class="form-control input-sm convertSinhalaIskolaPotha" name="nMemberPossition" id="nCustomerCategoryID" placeholder="ss">
                                                            <option value="" style="display:none;"></option>

                                                            <%for (MemRefMemberShipStatus mrmss : mrmsses) {%>
                                                            <%if (mrmss.getNMemberShipSatusID() == master.getNMemStatusID()) {%>

                                                            <option  selected value="<%= mrmss.getNMemberShipSatusID()%>"><label class><%= mrmss.getCMemberShipSatus()%></label></option>
                                                            <%} else {%>
                                                            <option   value="<%= mrmss.getNMemberShipSatusID()%>"><label class><%= mrmss.getCMemberShipSatus()%></label></option>
                                                            <%}
                                                                }%>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">භාවිතා වන නම :</label>
                                                    <div class="col-md-2">
                                                        <%
                                                            List<GenRefCustomerTittle> al = (List<GenRefCustomerTittle>) request.getSession().getAttribute("GenRefCustomerTittle");
                                                        %>
                                                        <select required class="form-control input-sm convertSinhalaIskolaPotha" name="nTitleID" id="nTitleID" onchange="this.style.borderColor = ''">
                                                            <option value="" style="display:none;"></option>
                                                            <%
                                                                for (GenRefCustomerTittle c : al) {
                                                            %>
                                                            <%if (c.getNTitleID() == master.getNTitleID()) {%>
                                                            <option selected value="<%=c.getNTitleID()%>"><label class="control-label"><%=c.getCTitle()%></label></option>
                                                            <%
                                                            } else {
                                                            %>
                                                            <option value="<%=c.getNTitleID()%>"><label class="control-label"><%=c.getCTitle()%></label></option>
                                                            <%}
                                                                }%>
                                                        </select>
                                                    </div>                                                        
                                                    <div class="col-md-8" >
                                                        <input required type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="<%= master.getCUseName()%>" onclick="this.style.borderColor = ''" data="validate" data-type="letterS">
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">සම්පූර්ණ නම :</label>
                                                    <div class="col-md-10">
                                                        <input  required type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullName" id="cFullName" value="<%= master.getCFullName()%>" onkeyup ="breakDownFullName();" data="validate" data-type="letterS">
                                                    </div> 
                                                </div> 
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">සම්පූර්ණ නම(සි) :</label>
                                                    <div class="col-md-10">
                                                        <input  type="text" class="form-control input-sm convertSinhalaAmali" name="cFullNameSin" id="cFullNameSin" value="<%= master.getCFullName()%>" onclick="this.style.borderColor = ''" data="validate" data-type="letterSS">
                                                    </div>
                                                </div> 
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">මුලකුරු :</label>
                                                    <div class="col-md-2">
                                                        <input readonly="" type="text" class="form-control input-sm bg-pad convertSinhalaIskolaPotha" name="cInitials" id="cInitials" value="<%= master.getCInitials()%>" onclick="this.style.borderColor = ''">
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right">අවසාන නම :</label>
                                                    <div class="col-md-3">
                                                        <input readonly="" type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cLastName" id="cLastName" value="<%= master.getCLastName()%>" onclick="this.style.borderColor = ''">
                                                    </div>
                                                    <!--<label class="col-sm-1 input-sm text-right">ස්ත්‍රී/පුරුෂ :</label>-->
                                                    <div class="col-md-3" style="margin-top: -5px">
                                                        <%if (master.getBFeMale()) {%>
                                                        <label  class="radio-inline"><input checked required type="radio" value="1" name="bFeMale" id="female" > ස්ත්‍රී</label>
                                                        <label class="radio-inline"><input  required type="radio" value="0" name="bFeMale" id="male"> පුරුෂ</label>

                                                        <%} else {%>
                                                        <label  class="radio-inline"><input  required type="radio" value="1" name="bFeMale" id="female" > ස්ත්‍රී</label>
                                                        <label class="radio-inline"><input checked required type="radio" value="0" name="bFeMale" id="male"> පුරුෂ</label>
                                                            <%}%>
                                                    </div>
                                                </div>                                                
                                            </div>
                                        </div>                                
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="row">
                                    <div class="col-md-12" style=" height:190px">
                                        <div class="box box-info bg-color" style=" height:180px">
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
                                    <div class="col-md-12">
                                        <div class="box box-info bg-color" style=" height:60px">
                                            <div class="box-body">
                                                <div class="row">
                                                    <!--<div class="col-md-12">-->
                                                    <div class="col-md-6">
                                                        <button class="btn btn-success btn-sm col-sm-12" onclick="$('#myCam').modal('show')" type="button"><span class="fa fa-camera">Upload</span></button><hr style="">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <input class="btn btn-success btn-sm col-sm-12" type="button" onclick="" value="Sign">
                                                    </div>
                                                    <!--                                                    <div class="col-md-4">
                                                                                                            <label class="col-sm-12 text-center">Athsana</label>
                                                                                                        </div>-->

                                                    <!--</div>-->
                                                </div>
                                            </div><!-- /.box-body -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="row">
                            <div class="col-md-6 bg-top bg-pad">
                                <div class="box box-info bg-color" style=" height:322px">
                                    <div class="box-header">
                                        <h4 class="box-title">හදුනාගැනීමේ තොරතුරු </h4>
                                    </div>
                                    <div class="box-body">
                                        <div class="form-group bg-top" >
                                            <label class="col-sm-3 input-sm text-right">ජා.හැ.අංකය :</label>
                                            <div class="col-md-3" style="padding-right: 10px;">
                                                <input class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="000000000V" type="text" name="cNICNo" id="cNICNo" value="<%= master.getCNICNo()%>" data="validate" data-type="birthday">
                                            </div>
                                            <label class="col-sm-2 input-sm text-right">උපන් දිනය:</label>
                                            <%
                                                String date = "";
                                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                                if (master.getDDateOfBirth() != null) {
                                                    if (!master.getDDateOfBirth().equals("")) {
                                                        date = sdf.format(master.getDDateOfBirth());

                                                    }
                                                }

                                            %>
                                            <div class="col-md-4">
                                                <input required type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dDateOfBirth" name="dDateOfBirth" value="<%= date%>" onclick="this.style.borderColor = ''">
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">නිකුත් කල දිනය :</label>

                                            <%
                                                String date1 = "";
                                                if (master.getDNICIssuedDate() != null) {
                                                    if (!master.getDNICIssuedDate().equals("")) {
                                                        date1 = sdf.format(master.getDNICIssuedDate());

                                                    }
                                                }
                                            %>
                                            <div class="col-md-9">
                                                <input class="form-control input-sm convertSinhalaIskolaPotha" type="date" name="issueddate" value="<%= date1%>" id="dNICIssuedDate" >
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">විවාහ/අවිවාහක :</label>
                                            <div class="col-md-9">
                                                <select required class="form-control input-sm convertSinhalaIskolaPotha convertSinhalaIskolaPotha" name="nCivilStatusID" id="nCivilStatusID">
                                                    <option value="" style="display:none;"></option>
                                                    <%
                                                        List<GenRefCivilStatus> al1 = (List<GenRefCivilStatus>) request.getSession().getAttribute("GenRefCivilStatus");
                                                        for (GenRefCivilStatus c1 : al1) {

                                                    %>
                                                    <%if (c1.getNCivilStatusID() == master.getNCivilStatusID()) {%>
                                                    <option selected value="<%=c1.getNCivilStatusID()%>"><label class="control-label"><%=c1.getCCivilStatus()%></label></option>

                                                    <%} else {%>

                                                    <option value="<%=c1.getNCivilStatusID()%>"><label class="control-label"><%=c1.getCCivilStatus()%></label></option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">ජාතිය :</label>
                                            <div class="col-md-9">
                                                <select required class="form-control input-sm convertSinhalaIskolaPotha" name="nNationalityID" id="nNationalityID">
                                                    <option value="" style="display:none;"></option>
                                                    <%
                                                        List<GenRefNationality> al2 = (List<GenRefNationality>) request.getSession().getAttribute("GenRefNationality");
                                                        for (GenRefNationality c2 : al2) {

                                                    %>
                                                    <%if (c2.getNNationalityID() == master.getNNationalityID()) {%>
                                                    <option selected value="<%=c2.getNNationalityID()%>"><label class="control-label"><%=c2.getCNationality()%></label></option>
                                                    <%} else {%>
                                                    <option  value="<%=c2.getNNationalityID()%>"><label class="control-label"><%=c2.getCNationality()%></label></option>

                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">ආගම :</label>
                                            <div class="col-md-9">
                                                <select required class="form-control input-sm convertSinhalaIskolaPotha" name="nReligionID" id="nReligionID">
                                                    <option value="" style="display:none;"></option>

                                                    <%
                                                        List<GenRefReligion> al21 = (List<GenRefReligion>) request.getSession().getAttribute("GenRefReligion");
                                                        for (GenRefReligion c2 : al21) {
                                                    %>
                                                    <%if (c2.getNReligionID() == master.getNReligionID()) {%>
                                                    <option selected value="<%=c2.getNReligionID()%>"><label class="control-label"><%=c2.getCReligionName()%></label></option>
                                                    <%} else {%> 
                                                    <option  value="<%=c2.getNReligionID()%>"><label class="control-label"><%=c2.getCReligionName()%></label></option>

                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right ">රැකියාව :</label>
                                            <div class="col-md-9">
                                                <input data="validate" data-type="letterS" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cOccupation" id="cOccupation" value="<%= master.getCOcupation()%>">
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right"> :</label>
                                            <div class="col-md-9">
                                                <input data="validate" data-type="letterS" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cMotherMadName" id="cMotherMadName" value="">
                                            </div>
                                        </div> 
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 bg-top">
                                <div class="nav-tabs-custom bg-color">
                                    <ul class="nav nav-tabs bg-color">
                                        <li class="active"><a href="#tab_1a" data-toggle="tab"><label class="control-label">ස්ථිර ලිපිනය</label></a></li>
                                        <li><a href="#tab_2a" data-toggle="tab"><label class="control-label">වෙනත් ලිපිනය</label></a></li>                                
                                        <li><a href="#tab_3a" data-toggle="tab"><label class="control-label">සාමාජික තොරතුරු</label> </a></li>    
                                    </ul>
                                    <div class="tab-content bg-color">
                                        <div class="tab-pane active bg-color" id="tab_1a">
                                            <table>
                                                <tr>
                                                    <td style="width: 175px"><label class="control-label input-sm ">ලිපිනය 1</label></td>
                                                    <td style="width: 650px"><input class="form-control input-sm convertSinhalaAmali" type="text" name="cPAddLine1" id="cPAddLine1" value="<%= master.getCPAddLine1()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 2</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaAmali" type="text" name="cPAddLine2" id="cPAddLine2" value="<%= master.getCPAddLine2()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 3</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaAmali" type="text" name="cPAddLine3" id="cPAddLine3" value="<%= master.getCBAddLine3()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 4</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaAmali" type="text" name="cPAddLine4" id="cPAddLine4" value="<%= master.getCPAddLine4()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">දුරකථන අංකය </label></td>
                                                    <td><input data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPTelNo1" id="cPTelNo1" value="<%= master.getCPTelNo1()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ඊ මේල් </label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="email" name="cPEmail" id="cPEmail" value="<%= master.getCPEmail()%>"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="tab-pane bg-color" id="tab_2a">
                                            <table>
                                                <tr>
                                                    <td style="width: 175px"><label class="control-label input-sm">ලිපිනය 1</label></td>
                                                    <td style="width: 650px"><input class="form-control input-sm convertSinhalaAmali" type="text" name="cBAddLine1" id="cBAddLine1" value="<%= master.getCBAddLine1()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 2</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaAmali" type="text" name="cBAddLine2" id="cBAddLine2" value="<%= master.getCBAddLine2()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 3</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaAmali" type="text" name="cBAddLine3" id="cBAddLine3" value="<%= master.getCBAddLine3()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 4</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaAmali" type="text" name="cBAddLine4" id="cBAddLine4" value="<%= master.getCBAddLine4()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">දුරකථන අංකය </label></td>
                                                    <td><input data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBTelNo1" id="cBTelNo1" value="<%= master.getCBTelNo1()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ඊ මේල් </label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="email" name="cBEmail" id="cBEmail" value="<%= master.getCBEmail()%>"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="tab-pane bg-color" id="tab_3a" > 

                                            <table>
                                                <tr>
                                                    <td style="width: 175px"><label class="control-label text-right input-sm" >පැරණි අංකය</label></td>
                                                    <td style="width: 650px"><input  data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="coldNum" id="coldNum" value="<%= master.getCMemberShipNo()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ප්‍රාදේශිකය</label></td>

                                                    <td><select required class="form-control input-sm convertSinhalaIskolaPotha" name="nMemAreaID" id="nMemAreaID">
                                                            <option value="" style="display:none;"></option>
                                                            <%
                                                                List<BnkRefMemberAreas> al4 = (List<BnkRefMemberAreas>) request.getSession().getAttribute("BnkRefMemberAreas");
                                                                for (BnkRefMemberAreas c4 : al4) {
                                                            %>
                                                            <%if (c4.getNMemAreaID() == master.getNMemAreaID()) {%>
                                                            <option selected value="<%=c4.getNMemAreaID()%>"><label class="control-label"><%=c4.getCMemAreaName()%></label></option>
                                                            <%} else {%>
                                                            <option  value="<%=c4.getNMemAreaID()%>"><label class="control-label"><%=c4.getCMemAreaName()%></label></option>

                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                        </select>  
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">තනතුර</label></td>
                                                    <td><select required class="form-control input-sm convertSinhalaIskolaPotha " name="nMemPositionID" id="nMemPositionID">
                                                            <option value="" style="display:none;"></option>
                                                            <%
                                                                List< BnkRefMemberPosition> al3 = (List< BnkRefMemberPosition>) request.getSession().getAttribute("BnkRefMemberPosition");
                                                                for (BnkRefMemberPosition c3 : al3) {
                                                            %>
                                                            <%if (c3.getNMemPositionID() == master.getNMemPositionID()) {%>
                                                            <option selected value="<%=c3.getNMemPositionID()%>"><label class="control-label"><%=c3.getCMemPosition()%></label></option>
                                                            <%} else {%>
                                                            <option value="<%=c3.getNMemPositionID()%>"><label class="control-label"><%=c3.getCMemPosition()%></label></option>

                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                        </select></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <%
                                                        String date2 = "";
                                                        if (master.getDAddDate() != null) {
                                                            if (!master.getDAddDate().equals("")) {
                                                                date2 = sdf.format(master.getDAddDate());

                                                            }
                                                        }
                                                    %>
                                                    <td><label class="control-label input-sm">සාමාජික දිනය</label></td>
                                                    <td>
                                                        <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" name="dMemberShipDate" id="dMemberShipDate" value="<%= date2%>">
                                                    </td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">සාමාජික මුදල </label></td>
                                                    <td><input  data="validate" data-type="decimal" class="form-control input-sm convertSinhalaIskolaPotha text-right" type="number" name="cMemberFee" id="cMemberFee" value="<%= master.getNMemberShipFee()%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">කොටස් </label></td>
                                                    <td><input  data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha text-right" type="number" name="cNumbers" id="cNumbers" value="<%= master.getNNoOfShares()%>"></td>
                                                </tr>
                                            </table>
                                        </div>                                             
                                    </div>                                                    
                                </div>
                            </div> 

                            <div class="col-md-6 pull-right bg-top">
                                <input type="submit" class="btn btn-success col-lg-4" value="Save"/>
                                <button type="submit" class="btn btn-warning col-lg-4" onclick="window.history">Back</button>
                                <button type="reset" class="btn btn-danger col-lg-4">Reset</button>

                            </div>
                        </div>
                    </form>
                </section>
                <!--..................................page content............-->
            </aside>
            <% session.removeAttribute("Searchedmember");%>
        </div>
        <input type="hidden" value="" id="custCatSet">
        <input type="hidden" value="" id="nTitleIDset">
        <input type="hidden" value="" id="civilSet">
        <input type="hidden" value="" id="nNationalityIDSet">
        <input type="hidden" value="" id="religionSet">
        <input type="hidden" value="" id="nMemPositionIDSet">
        <input type="hidden" value="" id="nMemStatusIDSet">
        <input type="hidden" value="" id="areaSet">
        <input type="hidden" value="" id="groupSet">
    </body>
    <script src="../js/custom/Validate.js" type="text/javascript"></script>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    <script src="../js/validate.js" type="text/javascript"></script>
    <script>
                                    var custCatSet = document.getElementById("custCatSet").value;
                                    var nTitleIDset = document.getElementById("nTitleIDset").value;
                                    var civilSet = document.getElementById("civilSet").value;
                                    var religionSet = document.getElementById("religionSet").value;
                                    var nNationalityIDSet = document.getElementById("nNationalityIDSet").value;
                                    var nMemStatusIDSet = document.getElementById("nMemStatusIDSet").value;
                                    var areaSet = document.getElementById("areaSet").value;
                                    var groupSet = document.getElementById("groupSet").value;
                                    var nMemPositionIDSet = document.getElementById("nMemPositionIDSet").value;

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
                                        });
                                    }, false);

                                    //---------------------------------
                                    function breakDownFullName() {

                                        e = event;
                                        if (!e) {
                                            e = widows.event;
                                        }

                                        if (e.keyCode !== 32) {
                                            var fullName = document.getElementById("cFullName").value;
                                            var iNSp = fullName.split(" ");
                                            if (iNSp.length > 0) {
                                                fullName = "";
                                                var i;
                                                for (i = 0; i < iNSp.length - 1; i++) {
                                                    fullName += iNSp[i].charAt(0) + " ";
                                                }
                                            }
                                            document.getElementById("cInitials").value = fullName;
                                            document.getElementById("cLastName").value = iNSp[iNSp.length - 1];
                                        }
                                    }
                                    //-----------------------------------


                                    //---------SUBMIT FUNCTION-----------
                                    //---------SUBMIT FUNCTION-----------

                                    //        ==================================================================
                                    function cMIFBtnAction() {
                                        window.location = "../LoadViewMemberComboServlet";
                                    }
                                    function send() {
                                        var canvasServer = document.getElementById("canvas");
                                        var context = canvasServer.getContext("2d");
                                        var imageDataURL = canvasServer.toDataURL('image/png');
                                        var ajax = new XMLHttpRequest();
                                        ajax.open("POST", "../saveImageServlet", false);
                                        ajax.send(imageDataURL);
                                        setTimeout(document.getElementById("userImage").setAttribute("src", "../images/customer/20180102.png"), 3000);
                                    }

    </script>
    <div id="myCam" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <strong style="font-size: 20px;">Take Picture</strong>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>                   
                </div>
                <div class="modal-body " style="padding: 5px;">
                    <div class="row">
                        <center><video id="video" height="240" width="325" autoplay style="margin: 0px ;border: 10px #333 solid;border-radius: 5px;"></video></center> 
                    </div>
                    <div class="row">
                        <center><canvas id="canvas" height="240" width="325" ></canvas></center> 
                    </div>
                    <div class="row" style="padding-right: 30px;">
                        <button type="button" class="btn btn-info" id="snap" style="float: right">Snap</button>
                    </div>
                </div>
                <div class="panel-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="send()" >save</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</html>