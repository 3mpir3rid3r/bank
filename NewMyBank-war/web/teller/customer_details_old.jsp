<%-- 
    Document   : customer_details
    Created on : Jan 26, 2015, 3:30:24 PM
    Author     : mmh
--%>

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
        </style>
    </head>

    <body class="skin-blue  pace-done fixed">

        <!--header-->
        <%@include file="teller_header.jsp" %>
        <!------------------------->

        <%
            String alert = "";
            String pk = "0";
            if (request.getParameter("mg") != null) {
                String mg = request.getParameter("mg");
                if ("error".equals(mg)) {
                    alert = Alerts.warningAlert("Something Wrong", "You miss some Fields", "");
                }
            }
            short custCatSet = 0, titleset = 0, civilSet = 0, nationalitySet = 0, religionSet = 0, positionSet = 0, stateSet = 0, areaSet = 0;
            int groupSet = 0;
            String cifno = "00000000", usedname = "", initials = "", lastname = "", fullname = "";
            Date birthday = null, issueDate = null, starting_date = null, member_date = null;
            String nic = "", mother_sername = "";
            String per_address1 = "", per_address2 = "", per_address3 = "", per_address4 = "", phone_no1 = "";
            String other_address1 = "", other_address2 = "", other_address3 = "", other_address4 = "", phone_no2 = "";
            String member_num = "";
            BigDecimal member_value = BigDecimal.ZERO;
            String email1 = "", email2 = "";
            if (request.getParameter("id") != null) {
                String custIdString = request.getParameter("id");

                int custId = Integer.parseInt(Security.decrypt(custIdString.replace(" ", "+")));
                pk = custId + "";
                GetViewCustomerServlet servlet = new GetViewCustomerServlet();
                com.nbs.model.BnkCustomerMaster b = servlet.getCustomer(custId);
                System.out.println(b + "As");
                cifno = b.getCCIFNo();
                usedname = b.getCUseName();
                lastname = b.getCLastName();
                fullname = b.getCFullName();
                initials = b.getCInitials();
                birthday = b.getDDateOfBirth();
                nic = b.getCNICNo();
                mother_sername = b.getCMotherMadName();
                issueDate = b.getDNICIssuedDate();
                starting_date = b.getDJoineDate();
                per_address1 = b.getCPAddLine1();
                per_address2 = b.getCPAddLine2();
                per_address3 = b.getCPAddLine3();
                per_address4 = b.getCPAddLine4();
                phone_no1 = b.getCPTelNo1();
                other_address1 = b.getCBAddLine1();
                other_address2 = b.getCBAddLine2();
                other_address3 = b.getCBAddLine3();
                other_address4 = b.getCBAddLine4();
                phone_no2 = b.getCBTelNo1();
                member_date = b.getDMemberShipDate();
                member_value = b.getNMemberShipFee();
                member_num = b.getCMemberShipNo();
                email1 = b.getCPEmail();
                email2 = b.getCBEmail();

                custCatSet = b.getNCustomerCategoryID();
                titleset = b.getNTitleID();
                civilSet = b.getNCivilStatusID();
                nationalitySet = b.getNNationalityID();
                religionSet = b.getNReligionID();
                groupSet = b.getNMemAreaGroupID();
                positionSet = b.getNMemPositionID();
                stateSet = b.getNMemStatusID();
                areaSet = b.getNMemAreaID();
            }
            System.out.println("pkjsp" + pk);

        %>
        <!--.............................header End......................-->
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
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
                <%=alert%>
                <!--..................................page content............-->
                <form action="../NewCustomerServlet" method="post" name="customer" onsubmit="validateCustomer(this);
                        return false;">
                    <input type="hidden" value="<%=pk%>" name="pk">
                    <section class="content">
                        <div class="row bg-searchheight bg-top">
                            <div class="col-md-9 bg-searchheight bg-pad" >
                                <div class="box box-info bg-color" style=" height:210px">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <div class="row">
                                                        <label class="col-sm-2 ">පා.ලි අංකය </label>
                                                        <div class="col-sm-4">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control input-sm" disabled="" name="cifno" id="cifno" value="<%=cifno%>">
                                                                <!--<input type="hidden" value="<%=pk%>" name="pk">-->
                                                                <span class="input-group-btn">
                                                                    <button class="btn btn-info btn-flat btn-sm" type="button" onclick="cMIFBtnAction()"><i class="fa fa-search"></i></button>
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <label class="col-sm-2 ">පාරි: වර්ගය  </label>
                                                        <div class="col-md-4">
                                                            <%
                                                                List<BnkRefCustomerCategory> list = (List<BnkRefCustomerCategory>)request.getSession().getAttribute("BnkRefCustomerCategory");
                                                            %>
                                                            <select class="form-control input-sm" name="custcat" id="custcat" onchange="this.style.borderColor = ''">
                                                                <option value="0"><label class="control-label">-තෝරන්න-</label></option>
                                                                <%
                                                                    for (BnkRefCustomerCategory cl : list) {
                                                                %>
                                                                <option value="<%=cl.getNCustomerCategoryID()%>"><label class="control-label"><%=cl.getCCustomerCategory()%></label></option>
                                                                <%
                                                                    }
                                                                %>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <div class="row">
                                                        <label class="col-sm-2 ">භාවිතා වන නම </label>
                                                        <div class="col-md-2">
                                                            <%
                                                                List<GenRefCustomerTittle> al = (List<GenRefCustomerTittle>)request.getSession().getAttribute("GenRefCustomerTittle");
                                                            %>
                                                            <select class="form-control input-sm" name="title" id="title" onchange="this.style.borderColor = ''">
                                                                <option value="0"><label class="control-label">-තෝරන්න-</label></option>
                                                                <%
                                                                    for (GenRefCustomerTittle c : al) {
                                                                %>
                                                                <option value="<%=c.getNTitleID()%>"><label class="control-label"><%=c.getCTitle()%></label></option>
                                                                <%
                                                                    }
                                                                %>
                                                            </select>
                                                        </div>                                                        
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control input-sm" name="usedname" id="usedname" value="<%=usedname%>" onclick="this.style.borderColor = ''">
                                                        </div>
                                                    </div>
                                                </div>                                               
                                                <div class="form-group bg-top">
                                                    <div class="row">
                                                        <label class="col-sm-2 ">මුලකුරු</label>
                                                        <div class="col-md-4">
                                                            <input type="text" class="form-control input-sm" name="initials" id="initials" value="<%=initials%>" onclick="this.style.borderColor = ''">
                                                        </div>
                                                        <label class="col-sm-2 ">අවසාන නම  </label>
                                                        <div class="col-md-4">
                                                            <input type="text" class="form-control input-sm" name="lastname" id="lastname" value="<%=lastname%>" onclick="this.style.borderColor = ''">
                                                        </div>
                                                    </div>
                                                </div>                                                
                                                <div class="form-group bg-top">
                                                    <div class="row">
                                                        <label class="col-sm-2 ">සම්පූර්ණ නම</label>
                                                        <div class="col-md-10">
                                                            <input type="text" class="form-control input-sm" name="fullname" id="fullname" value="<%=fullname%>" onclick="this.style.borderColor = ''">
                                                        </div>                                                        
                                                    </div>
                                                </div>                                                
                                                <div class="form-group bg-top">
                                                    <div class="row">
                                                        <label class="col-sm-2 ">ස්ත්‍රී /පුරුෂ භාවය</label>
                                                        <div class="col-md-2">
                                                            <label class="radio-inline control-label"><input type="radio" value="1" name="male" id="female" > ස්ත්‍රී</label>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <label class="radio-inline control-label"><input type="radio" value="0" name="male" id="male"> පුරුෂ</label>
                                                        </div>
                                                        <label class="col-sm-2 ">උපන් දිනය</label>
                                                        <div class="col-md-4">
                                                            <input type="date" class="form-control input-sm" id="birthday" name="birthday" value="<%=birthday%>" onclick="this.style.borderColor = ''">
                                                        </div>
                                                    </div>
                                                </div> 
                                            </div>
                                        </div>                                
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 bg-searchheight">
                                <div class="row">
                                    <div class="col-md-12" style=" height:150px">
                                        <div class="box box-info bg-color" style=" height:140px">
                                            <div class="box-body">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <!--<canvas id="canvas" style="width: 120px;height: 130px"></canvas>-->
                                                        <center>
                                                            <img class="img-thumbnail" src="../images/icon-user-default.png" style="width: 150px;height: 120px">

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
                                                        <input class="btn btn-success btn-sm col-sm-12" type="button" onclick="alert(document.getElementById('canvas').value; )" value="Sign">
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
                            <div class="col-md-6 bg-pad">
                                <div class="box box-info bg-color" style=" height:322px">
                                    <div class="box-header"><h4 class="box-title">හදුනාගැනීමේ තොරතුරු </h4></div>
                                    <div class="box-body">
                                        <table>
                                            <tr>
                                                <td style="width: 200px"><label class="control-label">ජා .හැ .අංකය</label></td>
                                                <td style="width: 480px"><input class="form-control input-sm text-right" placeholder="000000000V" type="text" name="nic" id="nic" value="<%=nic%>"></td>
                                            </tr>
                                            <tr style="height: 5px;"></tr>
                                            <tr>
                                                <td><label class="control-label">නිකුත් කල දිනය</label></td>
                                                <td><input class="form-control input-sm" type="date" name="issueddate" value="<%=issueDate%>" id="issuedate" ></td>
                                            </tr>
                                            <tr style="height: 5px;"></tr>
                                            <tr>
                                                <td><label class="control-label">විවාහක/අවිවාහක බව</label></td>
                                                <td>
                                                    <select class="form-control input-sm" name="civil_status" id="civil_status">
                                                        <option value="0"><label class="control-label">-තෝරන්න-</label></option>
                                                        <%
                                                            List<GenRefCivilStatus> al1 = (List<GenRefCivilStatus>)request.getSession().getAttribute("GenRefCivilStatus");
                                                            for (GenRefCivilStatus c1 : al1) {
                                                        %>
                                                        <option value="<%=c1.getNCivilStatusID()%>"><label class="control-label"><%=c1.getCCivilStatus()%></label></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr style="height: 5px;"></tr>
                                            <tr>
                                                <td><label class="control-label">ජාතිය</label></td>
                                                <td>
                                                    <select class="form-control input-sm" name="nationality" id="nationality">
                                                        <option value="0"><label class="control-label">-තෝරන්න-</label></option>
                                                        <%
                                                            List<GenRefNationality> al2 = (List<GenRefNationality>)request.getSession().getAttribute("GenRefNationality");
                                                            for (GenRefNationality c2 : al2) {
                                                        %>
                                                        <option value="<%=c2.getNNationalityID()%>"><label class="control-label"><%=c2.getCNationality()%></label></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr style="height: 5px;"></tr>
                                            <tr>
                                                <td><label class="control-label">ආගම</label></td>
                                                <td>
                                                    <select class="form-control input-sm" name="religon" id="religon">
                                                        <option value="0"><label class="control-label">-තෝරන්න-</label></option>
                                                        <%
                                                            List<GenRefReligion> al21 = (List<GenRefReligion>)request.getSession().getAttribute("GenRefReligion");
                                                            for (GenRefReligion c2 : al21) {
                                                        %>
                                                        <option value="<%=c2.getNReligionID()%>"><label class="control-label"><%=c2.getCReligionName()%></label></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr style="height: 5px;"></tr>
                                            <tr>
                                                <td><label class="control-label">අරම්භක දිනය</label></td>
                                                <td><input class="form-control input-sm" type="date" name="starting_date" id="starting_date" value="<%=starting_date%>"></td>
                                            </tr>
                                            <tr style="height: 5px;"></tr>
                                            <tr>
                                                <td><label class="control-label">මවගේ වාසගම </label></td>
                                                <td><input class="form-control input-sm" type="text" name="mother_sername" id="mother_sername" value="<%=mother_sername%>"></td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
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
                                                    <td style="width: 175px"><label class="control-label">ලිපිනය 1</label></td>
                                                    <td style="width: 650px"><input class="form-control input-sm" type="text" name="per_address1" id="per_address1" value="<%=per_address1%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ලිපිනය 2</label></td>
                                                    <td><input class="form-control input-sm" type="text" name="per_address2" id="per_address2" value="<%=per_address2%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ලිපිනය 3</label></td>
                                                    <td><input class="form-control input-sm" type="text" name="per_address3" id="per_address3" value="<%=per_address3%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ලිපිනය 4</label></td>
                                                    <td><input class="form-control input-sm" type="text" name="per_address4" id="per_address4" value="<%=per_address4%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">දුරකථන අංකය </label></td>
                                                    <td><input class="form-control input-sm" type="text" name="phone_no1" id="phone_no1" value="<%=phone_no1%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ඊ මේල් </label></td>
                                                    <td><input class="form-control input-sm" type="email" name="email1" id="email1" value="<%=email1%>"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="tab-pane bg-color" id="tab_2a">
                                            <table>
                                                <tr>
                                                    <td style="width: 175px"><label class="control-label">ලිපිනය 1</label></td>
                                                    <td style="width: 650px"><input class="form-control input-sm" type="text" name="other_address1" id="other_address1" value="<%=other_address1%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ලිපිනය 2</label></td>
                                                    <td><input class="form-control input-sm" type="text" name="other_address2" id="other_address2" value="<%=other_address2%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ලිපිනය 3</label></td>
                                                    <td><input class="form-control input-sm" type="text" name="other_address3" id="other_address3" value="<%=other_address3%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ලිපිනය 4</label></td>
                                                    <td><input class="form-control input-sm" type="text" name="other_address4" id="other_address4" value="<%=other_address4%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">දුරකථන අංකය </label></td>
                                                    <td><input class="form-control input-sm" type="text" name="phone_no2" id="phone_no2" value="<%=phone_no2%>"></td>
                                                </tr>
                                                <tr style="height: 5px;"></tr>
                                                <tr>
                                                    <td><label class="control-label">ඊ මේල් </label></td>
                                                    <td><input class="form-control input-sm" type="email" name="email2" id="email2" value="<%=email2%>"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="tab-pane bg-color" id="tab_3a">                                           
                                            <div class="form-group " style="margin-top: -5px">
                                                <div class="row">
                                                    <label class="col-sm-3 ">සාමාජික අංකය</label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control input-sm text-right" name="member_no" id="member_no" value="<%=member_num%>">
                                                    </div>                                                        
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top">කණ්ඩායමේ නම</label>
                                                    <div class="col-md-9 bg-top">
                                                        <select class="form-control input-sm" name="coop_name" id="coop_name">
                                                            <option value="0"><label class="control-label">-තෝරන්න-</label></option>
                                                            <%
                                                                List<BnkRefMemberAreas> al4 = (List<BnkRefMemberAreas>)request.getSession().getAttribute("BnkRefMemberAreas");
                                                                for (BnkRefMemberAreas c4 : al4) {
                                                            %>
                                                            <option value="<%=c4.getNMemAreaID()%>"><label class="control-label"><%=c4.getCMemAreaName()%></label></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>                                                        
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top">තනතුර</label>
                                                    <div class="col-md-9 bg-top">
                                                        <select class="form-control input-sm" name="position" id="position">
                                                            <option><label class="control-label">-තෝරන්න-</label></option>
                                                            <%
                                                                List<BnkRefMemberPosition> al3 = (List<BnkRefMemberPosition>)request.getSession().getAttribute("BnkRefMemberPosition");
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
                                            <div class="form-group " style="">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top">තත්වය</label>
                                                    <div class="col-md-9 bg-top">
                                                        <select class="form-control input-sm" id="state" name="state">
                                                            <option><label class="control-label">-තෝරන්න-</label></option>
                                                            <%
                                                                List<BnkRefMemberStatus> al5 = (List<BnkRefMemberStatus>)request.getSession().getAttribute("BnkRefMemberStatus");
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
                                            <div class="form-group " style="">
                                                <div class="row">
                                                    <label class="col-sm-3 bg-top">සාමාජික දිනය</label>
                                                    <div class="col-md-4 bg-top">
                                                        <input type="date" class="form-control input-sm" name="member_date" id="member_date" value="<%=member_date%>">
                                                    </div>
                                                    <label class="col-sm-3 bg-top" >සාමාජික මුදල  </label>
                                                    <div class="col-md-2 bg-top" >
                                                        <input type="text" class="form-control input-sm text-right" placeholder="0.00" name="member_value" id="member_value" value="<%=member_value%>">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <div class="row">
                                                    <label class="col-sm-5 bg-top">සමිතියේ නම/ ප්‍රාදේශිකය</label>
                                                    <div class="col-md-7 bg-top">
                                                        <select class="form-control input-sm" id="group_name" name="group_name">
                                                            <option value="0"><label class="control-label">-තෝරන්න-</label></option>
                                                            <%
                                                                List<BnkRefMemberAreasGroups> al6 = (List<BnkRefMemberAreasGroups>)request.getSession().getAttribute("BnkRefMemberAreasGroups");
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
                                        </div>                                             
                                    </div>                                                    
                                </div>
                            </div> 

                            <div class="col-md-6 pull-right bg-top">
                                <button type="submit" class="btn btn-success col-lg-4">Save</button>
                                <button type="submit" class="btn btn-warning col-lg-4" onclick="window.history">Back</button>
                                <button type="reset" class="btn btn-danger col-lg-4">Reset</button>
                            </div>
                        </div>
                    </section>
                </form>
                <!--..................................page content............-->
            </aside>

        </div>
        <input type="hidden" value="<%=custCatSet%>" id="custCatSet">
        <input type="hidden" value="<%=titleset%>" id="titleset">
        <input type="hidden" value="<%=civilSet%>" id="civilSet">
        <input type="hidden" value="<%=nationalitySet%>" id="nationalitySet">
        <input type="hidden" value="<%=religionSet%>" id="religionSet">
        <input type="hidden" value="<%=positionSet%>" id="positionSet">
        <input type="hidden" value="<%=stateSet%>" id="stateSet">
        <input type="hidden" value="<%=areaSet%>" id="areaSet">
        <input type="hidden" value="<%=groupSet%>" id="groupSet">
    </body>
    <script src="../js/custom/Validate.js" type="text/javascript"></script>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    <script>
                                    var custCatSet = document.getElementById("custCatSet").value;
                                    var titleset = document.getElementById("titleset").value;
                                    var civilSet = document.getElementById("civilSet").value;
                                    var religionSet = document.getElementById("religionSet").value;
                                    var nationalitySet = document.getElementById("nationalitySet").value;
                                    var stateSet = document.getElementById("stateSet").value;
                                    var areaSet = document.getElementById("areaSet").value;
                                    var groupSet = document.getElementById("groupSet").value;
                                    var positionSet = document.getElementById("positionSet").value;

                                    $(document).ready(function () {
                                        $('#custcat').val(custCatSet);
                                        $('#title').val(titleset);
                                        $('#civil_status').val(civilSet);
                                        $('#religon').val(religionSet);
                                        $('#nationality').val(nationalitySet);
                                        $('#coop_name').val(groupSet);
                                        $('#position').val(positionSet);
                                        $('#state').val(stateSet);
                                        $('#group_name').val(areaSet);
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
                                        });
                                    }, false);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    function validateCustomer(cForm) {
                                        var bool = new Boolean();
                                        bool = true;

                                        var custcat = cForm['custcat'].value;
                                        var title = cForm["title"].value;
                                        var usedname = cForm["usedname"].value;
                                        var initials = cForm["initials"].value;
                                        var lastname = cForm["lastname"].value;
                                        var fullname = cForm["fullname"].value;
                                        var gender = cForm["male"].value;
                                        var birthday = cForm["birthday"].value;
//                                                ......................


                                        if (custcat === "0") {
                                            bool = false;
                                            document.getElementById('custcat').style.borderColor = "red";
                                        } else {
                                            document.getElementById('custcat').style.borderColor = "";
                                        }
                                        if (title === "0") {
                                            bool = false;
                                            document.getElementById('title').style.borderColor = "red";
                                        } else {
                                            document.getElementById('title').style.borderColor = "";
                                        }
                                        if (usedname === "") {
                                            bool = false;
                                            document.getElementById('usedname').style.borderColor = "red";
                                        } else {
                                            document.getElementById('usedname').style.borderColor = "";
                                        }
                                        if (initials === "") {
                                            bool = false;
                                            document.getElementById('initials').style.borderColor = "red";
                                        } else {
                                            document.getElementById('initials').style.borderColor = "";
                                        }
                                        if (lastname === "") {
                                            bool = false;
                                            document.getElementById('lastname').style.borderColor = "red";
                                        } else {
                                            document.getElementById('lastname').style.borderColor = "";
                                        }
                                        if (fullname === "") {
                                            bool = false;
                                            document.getElementById('fullname').style.borderColor = "red";
                                        } else {
                                            document.getElementById('fullname').style.borderColor = "";
                                        }
                                        if (birthday === "") {
                                            bool = false;
                                            document.getElementById('birthday').style.borderColor = "red";
                                        } else {
                                            document.getElementById('birthday').style.borderColor = "";
                                        }
                                        if (!(gender === "1" || gender === "0")) {
                                            bool = false;
                                        } else {
                                            bool = true;
                                        }



                                        if (bool) {
                                            document.forms["cForm"].submit();
                                        }
                                    }

//        ==================================================================
                                    function cMIFBtnAction() {
                                        window.location = "view_customers.jsp";
                                    }

    </script>
    <div id="myCam" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>                   
                </div>
                <div class="modal-body ">
                    <video id="video" width="240" height="320" autoplay></video>  
                    <canvas id="canvas" width="240" height="320"></canvas>
                    <button type="button" class="btn btn-info" id="snap">Snap</button>
                </div>
                <div class="panel-footer">
                    <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</html>