<%-- 
    Document   : customer_details
    Created on : Jan 26, 2015, 3:30:24 PM
    Author     : mmh
--%>

<%@page import="org.apache.poi.ss.usermodel.Picture"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>පාරිභෝගික තොරතුරු</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
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

        <script type="text/javascript">
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


            function conUperCase(com_name) {

                var str = document.getElementById(com_name).value;
                var res = str.toUpperCase();
                document.getElementById(com_name).value = res;
            }
        </script>
    </head>

    <%
        String alert = "";
        String pk = "0";
        boolean mf = false;
        if (request.getParameter("mg") != null) {
            String mg = request.getParameter("mg");
            if ("error".equals(mg)) {
                alert = Alerts.warningAlert("Something Wrong", "You miss some Fields", "");
            } else if ("saved".equals(mg)) {
                alert = Alerts.successAlert("success", "Customer Successfully saved");
            } else if ("updated".equals(mg)) {
                alert = Alerts.successAlert("success", "Customer Successfully updated");
            }
        }
        short custCatSet = 0, nTitleIDset = 0, civilSet = 0, nNationalityIDSet = 0, religionSet = 0, nMemPositionIDSet = 0, nMemStatusIDSet = 0, areaSet = 0;
        int groupSet = 0;
        String cifno = "00000000", issueDate = null, cUseName = "", cUseNameAma = "", cInitials = "", cLastName = "", cFullName = "";
        String dDateOfBirth = null, dJoineDate = null, dMemberShipDate = null;
        String cNICNo = "", cMotherMadName = "";
        String cPAddLine1 = "", cPAddLine2 = "", cPAddLine3 = "", cPAddLine4 = "", cPTelNo1 = "";
        String cBAddLine1 = "", cBAddLine2 = "", cBAddLine3 = "", cBAddLine4 = "", cBTelNo1 = "";
        String member_num = "";
        BigDecimal nMemberShipFee = BigDecimal.ZERO;
        String cPEmail = "", cBEmail = "", picture = "icon";

        if (request.getParameter("id") != null) {
            String custIdString = request.getParameter("id");
            int custId = Integer.parseInt(custIdString);
            pk = custId + "";
            BnkCustomerMaster b = null;
            if (request.getSession().getAttribute("aCustomer") != null) {
                b = (BnkCustomerMaster) request.getSession().getAttribute("aCustomer");
            }
            System.out.println(b.getDDateOfBirth() + "As");
            if (b != null) {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                mf = b.getBFeMale();
                cUseNameAma = b.getCFullNameAma();
                cifno = b.getCCIFNo();
                cUseName = b.getCUseName();
                cLastName = b.getCLastName();
                cFullName = b.getCFullName();
                cInitials = b.getCInitials();
                dDateOfBirth = sf.format(b.getDDateOfBirth());
                cNICNo = b.getCNICNo();
                cMotherMadName = b.getCMotherMadName();
                issueDate = sf.format(b.getDNICIssuedDate());
                dJoineDate = sf.format(b.getDJoineDate());
                cPAddLine1 = b.getCPAddLine1();
                cPAddLine2 = b.getCPAddLine2();
                cPAddLine3 = b.getCPAddLine3();
                cPAddLine4 = b.getCPAddLine4();
                cPTelNo1 = b.getCPTelNo1();
                cBAddLine1 = b.getCBAddLine1();
                cBAddLine2 = b.getCBAddLine2();
                cBAddLine3 = b.getCBAddLine3();
                cBAddLine4 = b.getCBAddLine4();
                cBTelNo1 = b.getCBTelNo1();
                dMemberShipDate = sf.format(b.getDMemberShipDate());
                nMemberShipFee = b.getNMemberShipFee();
                member_num = b.getCMemberShipNo();
                cPEmail = b.getCPEmail();
                cBEmail = b.getCBEmail();
                custCatSet = b.getNCustomerCategoryID();
                nTitleIDset = b.getNTitleID();
                civilSet = b.getNCivilStatusID();
                nNationalityIDSet = b.getNNationalityID();
                religionSet = b.getNReligionID();
                groupSet = b.getNMemAreaGroupID();
                nMemPositionIDSet = b.getNMemPositionID();
                nMemStatusIDSet = b.getNMemStatusID();
                areaSet = b.getNMemAreaID();
                picture = b.getCPictureFileName();
            }
        }

        System.out.println(
                "pkjsp" + pk);
        request.getSession()
                .removeAttribute("aCustomer");
    %>
    <body class="skin-blue  pace-done fixed">

        <!--./header-->
        <%@include file="teller_header.jsp" %>
        <!--./header-->

        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--./left-side-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- ./sidebar-->
                <%@include file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--./left-side-->

            <!--./right-side-->
            <aside id="content" class="right-side">
                <!-- ./Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        පාරිභෝගික තොරතුරු
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">පාරිභෝගික තොරතුරු</li>
                    </ol>
                </section>
                <!-- ./Content Header (Page header) -->
                <%=alert%>
                <!--./page content-->
                <section class="content">
                    <form class="form-horizontal" action="../NewCustomerServlet" method="post" name="customer" onsubmit="return send();">
                        <input type="hidden" value="<%=pk%>" name="pk">
                        <div class="row bg-top">
                            <div class="col-md-9 bg-pad" >
                                <div class="box box-info bg-color" style=" height:250px">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">පා.ලි අංකය :</label>
                                                    <div class="col-sm-4">
                                                        <div class="input-group">
                                                            <input type="text" class="form-control input-sm" disabled="" name="cifno" id="cifno" value="<%=cifno%>">
                                                            <!--<input type="hidden" value="<%=pk%>" name="pk">-->
                                                            <span class="input-group-btn">
                                                                <button class="btn btn-info btn-flat btn-sm" type="button" onclick="cMIFBtnAction()"><i class="fa fa-search"></i></button>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right">පාරි: වර්ගය :</label>
                                                    <div class="col-md-4">
                                                        <%
                                                            List<BnkRefCustomerCategory> list = (List<BnkRefCustomerCategory>) request.getSession().getAttribute("BnkRefCustomerCategory");
                                                        %>
                                                        <select required class="form-control input-sm convertSinhalaIskolaPotha" name="nCustomerCategoryID" id="nCustomerCategoryID" onchange="this.style.borderColor = ''">
                                                            <option value="0"><label class="control-label">-N/A-</label></option>
                                                            <%
                                                                for (BnkRefCustomerCategory cl : list) {
                                                            %>
                                                            <option class="" value="<%=cl.getNCustomerCategoryID()%>"><label class="control-label"><%=cl.getCCustomerCategory()%></label></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>

                                                        <script>
                                                            $("#nReligionID").select(<%= custCatSet%>);
                                                        </script>


                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">භාවිතා වන නම :</label>
                                                    <div class="col-md-2">
                                                        <%
                                                            List<GenRefCustomerTittle> al = (List<GenRefCustomerTittle>) request.getSession().getAttribute("GenRefCustomerTittle");
                                                        %>
                                                        <select required class="form-control input-sm convertSinhalaIskolaPotha" name="nTitleID" id="nTitleID" onchange="this.style.borderColor = ''">
                                                            <option value="0"><label class="control-label">-N/A-</label></option>
                                                            <%
                                                                for (GenRefCustomerTittle c : al) {
                                                            %>
                                                            <option class="" value="<%=c.getNTitleID()%>"><label class="control-label"><%=c.getCTitle()%></label></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>                                                        
                                                    <div class="col-md-8">
                                                        <input required type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="<%=cUseName%>" onclick="this.style.borderColor = ''" ata="validate" data-type="letterS">
                                                    </div>
                                                </div>   
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">සම්පූර්ණ නම :</label>
                                                    <div class="col-md-10">
                                                        <input required type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullName" id="cFullName" value="<%=cFullName%>" onclick="this.style.borderColor = ''"                                                                breakDownFullName(this);" data="validate" data-type="letterS">
                                                    </div> 
                                                </div> 
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">සම්පූර්ණ නම(සි) :</label>
                                                    <div class="col-md-10">
                                                        <input required type="text" class="form-control input-sm convertSinhalaAmali" name="cFullNameSin" id="cFullNameSin" value="<%=cUseNameAma%>" onclick="this.style.borderColor = ''" onkeyup="keyup1(event, 'cFullNameSin')" data="validate" data-type="letterSS">
                                                    </div>
                                                </div> 
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">මුලකුරු :</label>
                                                    <div class="col-md-2">
                                                        <input readonly  type="text" class="form-control input-sm bg-pad convertSinhalaIskolaPotha" name="cInitials" id="cInitials" value="<%=cInitials%>" onclick="this.style.borderColor = ''">
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right">අවසාන නම :</label>
                                                    <div class="col-md-3">
                                                        <input readonly type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cLastName" id="cLastName" value="<%=cLastName%>" onclick="this.style.borderColor = ''">
                                                    </div>
                                                    <!--<label class="col-sm-1 input-sm text-right">ස්ත්‍රී/පුරුෂ :</label>-->
                                                    <div class="col-md-3" style="margin-top: -5px">
                                                        <label class="radio-inline"><input type="radio" value="1" name="bFeMale" id="female" > ස්ත්‍රී</label>
                                                        <label class="radio-inline"><input type="radio" value="0" name="bFeMale" id="male"> පුරුෂ</label>

                                                        <script>
                                                            if (<%=mf%>) {
                                                                document.getElementById("male").checked = true;
                                                            } else {
                                                                document.getElementById("female").checked = true;
                                                            }
//                                                        document.getElementById("dMemberShipDate").value='<%= dMemberShipDate%>';
                                                        </script>
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
                                                            <input type="image" id="userImage" class="img-thumbnail" src="../images/customer/<%=picture%>.png" style="width: 170px;height: 150px">
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
                                                        <input class="btn btn-success btn-sm col-sm-12" type="button" onclick="alert(document.getElementById('canvas').value)" value="Sign">
                                                    </div>
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
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">ජා.හැ.අංකය :</label>
                                            <div class="col-md-3" style="padding-right: 5px;">
                                                <input required class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="000000000V" type="text" name="cNICNo" id="cNICNo" value="" a="validate" data-type="birthday">
                                            </div>
                                            <label class="col-sm-2 input-sm text-right" style="padding-left: 5px;">උපන් දිනය :</label>
                                            <div class="col-md-4">
                                                <input required type="date" class="form-control input-sm convertSinhalaIskolaPotha" id="dDateOfBirth" name="dDateOfBirth" value="<%=dDateOfBirth%>" onclick="this.style.borderColor = ''">
                                                <script>
                                                    document.getElementById("dDateOfBirth").value = '<%= dDateOfBirth%>';
                                                </script>
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">නිකුත් කල දිනය :</label>
                                            <div class="col-md-9">
                                                <input required class="form-control input-sm convertSinhalaIskolaPotha" type="date" name="issueddate" id="dNICIssuedDate" >
                                                <script>
                                                    document.getElementById("dNICIssuedDate").value = '<%= issueDate%>';
                                                </script>
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">විවාහ/අවිවාහක :</label>
                                            <div class="col-md-9">
                                                <select required class="form-control input-sm convertSinhalaIskolaPotha" name="nCivilStatusID" id="nCivilStatusID">
                                                    <option value="0"><label class="control-label">-N/A-</label></option>

                                                    <%
                                                        List<GenRefCivilStatus> al1 = (List<GenRefCivilStatus>) request.getSession().getAttribute("GenRefCivilStatus");
                                                        for (GenRefCivilStatus c1 : al1) {
                                                    %>
                                                    <option class="" value="<%=c1.getNCivilStatusID()%>"><label class="control-label"><%=c1.getCCivilStatus()%></label></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">ජාතිය :</label>
                                            <div class="col-md-9">
                                                <select required class="form-control input-sm convertSinhalaIskolaPotha" name="nNationalityID" id="nNationalityID">
                                                    <option value="0"><label class="control-label">-N/A-</label></option>
                                                    <%
                                                        List<GenRefNationality> al2 = (List<GenRefNationality>) request.getSession().getAttribute("GenRefNationality");
                                                        for (GenRefNationality c2 : al2) {
                                                    %>
                                                    <option class="" value="<%=c2.getNNationalityID()%>"><label class="control-label"><%=c2.getCNationality()%></label></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">ආගම :</label>
                                            <div class="col-md-9">
                                                <select required  class="form-control input-sm convertSinhalaIskolaPotha" name="nReligionID" id="nReligionID">
                                                    <option value="0"><label class="control-label">-N/A-</label></option>
                                                    <%
                                                        List<GenRefReligion> al21 = (List<GenRefReligion>) request.getSession().getAttribute("GenRefReligion");
                                                        for (GenRefReligion c2 : al21) {
                                                    %>
                                                    <option value="<%=c2.getNReligionID()%>"><label class="control-label"><%=c2.getCReligionName()%></label></option>
                                                    <%
                                                        }
                                                    %>

                                                </select>
                                                <script>
                                                    $("#nReligionID option:first").attr('selected', 'selected');
                                                </script>

                                            </div>
                                        </div>
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">අරම්භක දිනය :</label>
                                            <div class="col-md-9">
                                                <input required="" class="form-control input-sm convertSinhalaIskolaPotha" type="date" name="dJoineDate" id="dJoineDate" value="<%=dJoineDate%>">
                                                <script>
                                                    document.getElementById("dJoineDate").value = '<%= dJoineDate%>';
                                                </script>
                                            </div>
                                        </div> 
                                        <div class="form-group bg-top">
                                            <label class="col-sm-3 input-sm text-right">මවගේ වාසගම :</label>
                                            <div class="col-md-9">
                                                <input required class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cMotherMadName" id="cMotherMadName" value="<%=cMotherMadName%>"  data="validate" data-type="letterS">
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
                                                    <td style="width: 175px"><label class="control-label input-sm">ලිපිනය 1</label></td>
                                                    <td style="width: 650px"><input required class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPAddLine1" id="cPAddLine1" value="<%=cPAddLine1%>"  data="validate" data-type="address" data-line="line-1"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 2</label></td>
                                                    <td><input required class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPAddLine2" id="cPAddLine2" value="<%=cPAddLine2%>"  data="validate" data-type="address" data-line="line-2"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 3</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPAddLine3" id="cPAddLine3" value="<%=cPAddLine3%>"  data="validate" data-type="address" data-line="line-3"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 4</label></td> 
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPAddLine4" id="cPAddLine4" value="<%=cPAddLine4%>"  data="validate" data-type="address" data-line="line-4" ></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">දුරකථන අංකය </label></td>
                                                    <td><input required class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPTelNo1" id="cPTelNo1" value="<%=cPTelNo1%>" data="validate" data-type="number" maxlength="10"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ඊ මේල් </label></td>
                                                    <td><input required class="form-control input-sm convertSinhalaIskolaPotha" type="email" name="cPEmail" id="cPEmail" value="<%=cPEmail%>"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="tab-pane bg-color" id="tab_2a">
                                            <table>
                                                <tr>
                                                    <td style="width: 175px"><label class="control-label input-sm">ලිපිනය 1</label></td>
                                                    <td style="width: 650px"><input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBAddLine1" id="cBAddLine1" value="<%=cBAddLine1%>" data="validate" data-type="address" data-line="line-1"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 2</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBAddLine2" id="cBAddLine2" value="<%=cBAddLine2%>" data="validate" data-type="address" data-line="line-2"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 3</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBAddLine3" id="cBAddLine3" value="<%=cBAddLine3%>" data="validate" data-type="address" data-line="line-3"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ලිපිනය 4</label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBAddLine4" id="cBAddLine4" value="<%=cBAddLine4%>" data="validate" data-type="address" data-line="line-4"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">දුරකථන අංකය </label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBTelNo1" id="cBTelNo1" value="<%=cBTelNo1%>" data="validate" data-type="number" maxlength="10"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label input-sm">ඊ මේල් </label></td>
                                                    <td><input class="form-control input-sm convertSinhalaIskolaPotha" type="email" name="cBEmail" id="cBEmail" value="<%=cBEmail%>"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="tab-pane bg-color" id="tab_3a">                                           
                                            <div class="form-group  " style=";margin-left: 10px;margin-right: 10px" >
                                                <div class="row">
                                                    <label class="col-sm-3 input-sm">සාමාජික අංකය</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" name="cMemberShipNo" id="cMemberShipNo" value="<%=member_num%>" data="validate" data-type="number">
                                                    </div>                                                        
                                                </div>
                                            </div>
                                            <div class="form-group  " style=";margin-left: 10px;margin-right: 10px">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top input-sm">ප්‍රාදේශිකය</label>
                                                    <div class="col-md-9 bg-top">
                                                        <select class="form-control input-sm convertSinhalaIskolaPotha " name="nMemAreaID" id="nMemAreaID">
                                                            <option value="0"><label class="control-label">-N/A-</label></option>
                                                            <%
                                                                List<BnkRefMemberAreas> al4 = (List<BnkRefMemberAreas>) request.getSession().getAttribute("BnkRefMemberAreas");
                                                                for (BnkRefMemberAreas c4 : al4) {
                                                            %>
                                                            <option class=" input-sm" value="<%=c4.getNMemAreaID()%>"><label class="control-label"><%=c4.getCMemAreaName()%></label></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>                                                        
                                                    </div>                                                        
                                                </div>
                                            </div>
                                            <div class="form-group " style=";margin-left: 10px;margin-right: 10px"> 
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top input-sm">කණ්ඩායමේ නම</label>
                                                    <div class="col-md-9 bg-top">
                                                        <select class="form-control input-sm convertSinhalaIskolaPotha" id="nMemAreaGroupID" name="nMemAreaGroupID">
                                                            <option value="0"><label class="control-label">-N/A-</label></option>
                                                            <%
                                                                List<BnkRefMemberAreasGroups> al6 = (List<BnkRefMemberAreasGroups>) request.getSession().getAttribute("BnkRefMemberAreasGroups");
                                                                for (BnkRefMemberAreasGroups c6 : al6) {
                                                            %>
                                                            <option value="<%=c6.getNMemAreaGroupID()%>"><label class="control-label"><%=c6.getCGroupName()%></label></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>                                                        
                                                </div>
                                            </div>
                                            <div class="form-group " style=";margin-left: 10px;margin-right: 10px">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top input-sm">තනතුර</label>
                                                    <div class="col-md-9 bg-top">
                                                        <select class="form-control input-sm convertSinhalaIskolaPotha" name="nMemPositionID" id="nMemPositionID">
                                                            <option value="0"><label class="control-label">-N/A-</label></option>
                                                            <%
                                                                List<BnkRefMemberPosition> al3 = (List<BnkRefMemberPosition>) request.getSession().getAttribute("BnkRefMemberPosition");
                                                                for (BnkRefMemberPosition c3 : al3) {
                                                            %>
                                                            <option value="<%=c3.getNMemPositionID()%>"><label class="control-label"><%=c3.getCMemPosition()%></label></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>                                                        
                                                </div>
                                            </div>   
                                            <div class="form-group " style=";margin-left: 10px;margin-right: 10px">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top input-sm">තත්වය</label>
                                                    <div class="col-md-9 bg-top">
                                                        <select class="form-control input-sm convertSinhalaIskolaPotha" id="nMemStatusID" name="nMemStatusID">
                                                            <option value="0"><label class="control-label">-N/A-</label></option>
                                                            <%
                                                                List<BnkRefMemberStatus> al5 = (List<BnkRefMemberStatus>) request.getSession().getAttribute("BnkRefMemberStatus");
                                                                for (BnkRefMemberStatus c5 : al5) {
                                                            %>
                                                            <option value="<%=c5.getNMemStatusID()%>"><label class="control-label"><%=c5.getCMemStatus()%></label></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>                                                        
                                                </div>
                                            </div>
                                            <div class="form-group" style=";margin-left: 10px;margin-right: 10px">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top input-sm">සාමාජික දිනය</label>
                                                    <div class="col-md-4 bg-top">
                                                        <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" name="dMemberShipDate" id="dMemberShipDate" value="<%=dMemberShipDate%>">
                                                        <script>
                                                            document.getElementById("dMemberShipDate").value = '<%= dMemberShipDate%>';
                                                        </script>
                                                    </div>
                                                    <label class="col-sm-3 bg-top input-sm" >සාමාජික මුදල  </label>
                                                    <div class="col-md-2 bg-top" >
                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.00" name="nMemberShipFee" id="nMemberShipFee" value="<%=nMemberShipFee%>" data="validate" data-type="decimal">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>                                             
                                    </div>                                                    
                                </div>
                            </div> 

                            <div class="col-md-6 pull-right bg-top">
                                <button type="submit" class="btn btn-success col-lg-4" >Save</button>
                                <button type="submit" class="btn btn-warning col-lg-4" onclick="window.history">Back</button>
                                <button type="reset" class="btn btn-danger col-lg-4">Reset</button>
                            </div>
                        </div>
                        <input required type="hidden" value="" >
                        <input required type="hidden" value="" id="pic" name="userImage">
                    </form>
                </section>
                <!--..................................page content............-->
            </aside>

        </div>
        <input type="hidden" value="<%=custCatSet%>" id="custCatSet">
        <input type="hidden" value="<%=nTitleIDset%>" id="nTitleIDset">
        <input type="hidden" value="<%=civilSet%>" id="civilSet">
        <input type="hidden" value="<%=nNationalityIDSet%>" id="nNationalityIDSet">
        <input type="hidden" value="<%=religionSet%>" id="religionSet">
        <input type="hidden" value="<%=nMemPositionIDSet%>" id="nMemPositionIDSet">
        <input type="hidden" value="<%=nMemStatusIDSet%>" id="nMemStatusIDSet">
        <input type="hidden" value="<%=areaSet%>" id="areaSet">
        <input type="hidden" value="<%=groupSet%>" id="groupSet">

    </body>
    <script src="../js/custom/Validate.js" type="text/javascript"></script>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
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
                                    $(document).ready(function () {
                                        $('#nCustomerCategoryID').val(custCatSet);
                                        $('#nTitleID').val(nTitleIDset);
                                        $('#nCivilStatusID').val(civilSet);
                                        $('#nReligionID').val(religionSet);
                                        $('#nNationalityID').val(nNationalityIDSet);
                                        $('#nMemAreaID').val(groupSet);
                                        $('#nMemPositionID').val(nMemPositionIDSet);
                                        $('#nMemStatusID').val(nMemStatusIDSet);
                                        $('#nMemAreaGroupID').val(areaSet);
                                    });
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
                                    //---------------------------------
                                    function breakDownFullName(e) {
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
                                    //---------SUBMIT FUNCTION-----------
                                    function validateCustomer1(cForm) {
                                        var bool = new Boolean();
                                        bool = true;
                                        var nCustomerCategoryID = cForm['nCustomerCategoryID'].value;
                                        var nTitleID = cForm["nTitleID"].value;
                                        var cUseName = cForm["cUseName"].value;
                                        var cInitials = cForm["cInitials"].value;
                                        var cLastName = cForm["cLastName"].value;
                                        var cFullName = cForm["cFullName"].value;
                                        var gender = cForm["bFeMale"].value;
                                        var dDateOfBirth = cForm["dDateOfBirth"].value;
//                                                ......................
                                        var cNICNo = cForm["cNICNo"].value;
                                        var dNICIssuedDate = cForm["dNICIssuedDate"].value;
                                        var dDateOfBirth = cForm["dDateOfBirth"].value;
                                        var nCivilStatusID = cForm["nCivilStatusID"].value;
                                        var nNationalityID = cForm["nNationalityID"].value;
                                        var nReligionID = cForm["nReligionID"].value;
                                        var dJoineDate = cForm["dJoineDate"].value;
                                        var cMotherMadName = cForm["cMotherMadName"].value;
                                        var cPAddLine1 = cForm["cPAddLine1"].value;
                                        var cPAddLine2 = cForm["cPAddLine2"].value;
                                        var cPAddLine3 = cForm["cPAddLine3"].value;
                                        var cPAddLine4 = cForm["cPAddLine4"].value;
                                        var cPTelNo1 = cForm["cPTelNo1"].value;
                                        var cPEmail = cForm["cPEmail"].value;
                                        var cBAddLine1 = cForm["cBAddLine1"].value;
                                        var cBAddLine2 = cForm["cBAddLine2"].value;
                                        var cBAddLine3 = cForm["cBAddLine3"].value;
                                        var cBAddLine4 = cForm["cBAddLine4"].value;
                                        var cBTelNo1 = cForm["cBTelNo1"].value;
                                        var cBEmail = cForm["cBEmail"].value;
                                        var cMemberShipNo = cForm["cMemberShipNo"].value;
                                        var nMemAreaGroupID = cForm["nMemAreaGroupID"].value;
                                        var nMemPositionID = cForm["nMemPositionID"].value;
                                        var nMemStatusID = cForm["nMemStatusID"].value;
                                        var dMemberShipDate = cForm["dMemberShipDate"].value;
                                        var nMemberShipFee = cForm["nMemberShipFee"].value;
                                        var nMemAreaID = cForm["nMemAreaID"].value;
                                        if (nCustomerCategoryID === "0") {
                                            bool = false;
                                            document.getElementById('nCustomerCategoryID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nCustomerCategoryID').style.borderColor = "";
                                        }
                                        if (nTitleID === "0") {
                                            bool = false;
                                            document.getElementById('nTitleID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nTitleID').style.borderColor = "";
                                        }
                                        if (cUseName === "") {
                                            bool = false;
                                            document.getElementById('cUseName').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cUseName').style.borderColor = "";
                                        }
                                        if (cInitials === "") {
                                            bool = false;
                                            document.getElementById('cInitials').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cInitials').style.borderColor = "";
                                        }
                                        if (cLastName === "") {
                                            bool = false;
                                            document.getElementById('cLastName').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cLastName').style.borderColor = "";
                                        }
                                        if (cFullName === "") {
                                            bool = false;
                                            document.getElementById('cFullName').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cFullName').style.borderColor = "";
                                        }
                                        if (dDateOfBirth === "") {
                                            bool = false;
                                            document.getElementById('dDateOfBirth').style.borderColor = "red";
                                        } else {
                                            document.getElementById('dDateOfBirth').style.borderColor = "";
                                        }

                                        if (!(gender === "1" || gender === "0")) {
                                            bool = false;
                                            alert('Please Select the gender');
                                        }
                                        if (cNICNo === "") {
                                            bool = false;
                                            document.getElementById('cNICNo').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cNICNo').style.borderColor = "";
                                        }
                                        if (dNICIssuedDate === "") {
                                            bool = false;
                                            document.getElementById('dNICIssuedDate').style.borderColor = "red";
                                        } else {
                                            document.getElementById('dNICIssuedDate').style.borderColor = "";
                                        }
                                        if (nCivilStatusID === "0") {
                                            bool = false;
                                            document.getElementById('nCivilStatusID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nCivilStatusID').style.borderColor = "";
                                        }
                                        if (nNationalityID === "0") {
                                            bool = false;
                                            document.getElementById('nNationalityID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nNationalityID').style.borderColor = "";
                                        }
                                        if (nReligionID === "0") {
                                            bool = false;
                                            document.getElementById('nReligionID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nReligionID').style.borderColor = "";
                                        }

                                        if (dJoineDate === "0") {
                                            bool = false;
                                            document.getElementById('dJoineDate').style.borderColor = "red";
                                        } else {
                                            document.getElementById('dJoineDate').style.borderColor = "";
                                        }
                                        if (cMotherMadName === "") {
                                            bool = false;
                                            document.getElementById('cMotherMadName').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cMotherMadName').style.borderColor = "";
                                        }
                                        if (cPAddLine1 === "") {
                                            bool = false;
                                            document.getElementById('cPAddLine1').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cPAddLine1').style.borderColor = "";
                                        }
                                        if (cPAddLine2 === "") {
                                            bool = false;
                                            document.getElementById('cPAddLine2').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cPAddLine2').style.borderColor = "";
                                        }
                                        if (cPAddLine3 === "") {
                                            bool = false;
                                            document.getElementById('cPAddLine3').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cPAddLine3').style.borderColor = "";
                                        }
                                        if (cPAddLine4 === "") {
                                            bool = false;
                                            document.getElementById('cPAddLine4').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cPAddLine4').style.borderColor = "";
                                        }
                                        if (cPTelNo1 === "") {
                                            bool = false;
                                            document.getElementById('cPTelNo1').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cPTelNo1').style.borderColor = "";
                                        }
                                        if (cPEmail === "") {
                                            bool = false;
                                            document.getElementById('cPEmail').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cPEmail').style.borderColor = "";
                                        }

                                        if (cBAddLine1 === "") {
                                            bool = false;
                                            document.getElementById('cBAddLine1').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cBAddLine1').style.borderColor = "";
                                        }
                                        if (cBAddLine2 === "") {
                                            bool = false;
                                            document.getElementById('cBAddLine2').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cBAddLine2').style.borderColor = "";
                                        }
                                        if (cBAddLine3 === "") {
                                            bool = false;
                                            document.getElementById('cBAddLine3').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cBAddLine3').style.borderColor = "";
                                        }
                                        if (cBAddLine4 === "") {
                                            bool = false;
                                            document.getElementById('cBAddLine4').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cBAddLine4').style.borderColor = "";
                                        }
                                        if (cBTelNo1 === "") {
                                            bool = false;
                                            document.getElementById('cBTelNo1').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cBTelNo1').style.borderColor = "";
                                        }
                                        if (cBEmail === "") {
                                            bool = false;
                                            document.getElementById('cBEmail').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cBEmail').style.borderColor = "";
                                        }
                                        if (cMemberShipNo === "") {
                                            bool = false;
                                            document.getElementById('cMemberShipNo').style.borderColor = "red";
                                        } else {
                                            document.getElementById('cMemberShipNo').style.borderColor = "";
                                        }
                                        if (nMemAreaGroupID === "0") {
                                            bool = false;
                                            document.getElementById('nMemAreaGroupID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nMemAreaGroupID').style.borderColor = "";
                                        }

                                        if (nMemPositionID === "0") {
                                            bool = false;
                                            document.getElementById('nMemPositionID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nMemPositionID').style.borderColor = "";
                                        }
                                        if (nMemStatusID === "0") {
                                            bool = false;
                                            document.getElementById('nMemStatusID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nMemStatusID').style.borderColor = "";
                                        }
                                        if (dMemberShipDate === "") {
                                            bool = false;
                                            document.getElementById('dMemberShipDate').style.borderColor = "red";
                                        } else {
                                            document.getElementById('dMemberShipDate').style.borderColor = "";
                                        }
                                        if (nMemberShipFee === "") {
                                            bool = false;
                                            document.getElementById('nMemberShipFee').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nMemberShipFee').style.borderColor = "";
                                        }
                                        if (nMemAreaID === "0") {
                                            bool = false;
                                            document.getElementById('nMemAreaID').style.borderColor = "red";
                                        } else {
                                            document.getElementById('nMemAreaID').style.borderColor = "";
                                        }


                                        if (bool) {
                                            document.forms["cForm"].submit();
                                        }
                                    }
                                    //---------SUBMIT FUNCTION-----------

                                    //        ==================================================================
                                    function cMIFBtnAction() {
                                        window.location = "view_customers.jsp";
                                    }
//                                    var video = document.getElementById('video');
//                                    var canvas = document.getElementById('canvas');
//                                    var context = canvas.getContext('2d');

                                    function send() {

                                        var canvasServer = document.getElementById("canvas");
                                        var context = canvasServer.getContext("2d");
                                        var imageDataURL = canvasServer.toDataURL('image/png');
                                        if (imageDataURL !== null) {
                                            $.post('../saveImageServlet', imageDataURL, function (responseText) {
                                                document.getElementById('pic').value = responseText;
                                                return true;
                                            });
                                        } else {
                                            return false;
                                        }
                                    }
                                    $('[type="reset"]').on('click', function () {
                                        $($('*[type="text"]')).each(function () {
                                            $(this).val("");
                                        });
                                    });
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
                    <button type="button" class="btn btn-info" data-dismiss="modal"  >Close</button>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../uni_convert/unicode_converter.jsp" %>
    <script src="../js/validate.js" type="text/javascript"></script>
</html>
