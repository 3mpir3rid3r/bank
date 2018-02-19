<%-- 
    Document   : money_saving1
    Created on : Jan 27, 2015, 7:42:42 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkDepDepositTransaction"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>මුදල් හුවමාරු</title>

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
            .bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:128px;                
            }.bg-mainheight{
                height:410px;                
            }.bg-subheight{
                height:413px;                
            }
            .bg-pad{
                padding-right:0px;                
            }
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head>

    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">
        <%
            if (request.getParameter("moneyDepType") != null) {
                request.getSession().removeAttribute("depDepositMasterCr");
                request.getSession().removeAttribute("depDepositMasterBr");
            }
            String cCIFNo = "පා.ලි. අංකය ";
            String cMemberShipNo = "සාමාජික අංකය";
            String cNICNo = " ජැ.හැ. අංකය";
            String cUseName = "භාවිත නම";
            String cFullName1 = "සම්පූර්ණ නම", cFullName2 = "සම්පූර්ණ නම";
            String cPAddLine1 = "----------ලිපිනය----------";
            String cOurAccountNo = "";

            String nCurBookBalance = "";
            String nNotCreditIntBalance = "";
            String nAvailableBalance = "";
            String nHoldedAmount = "";

            String nDepMFID = "";
            String crAccNo = "";
            String crAccNoLabel = "අංකය";
            String crCDepName = "වර්ගය";
            String crNCurBookBalance = "ශේෂය";

            if (request.getSession().getAttribute("depDepositMasterCr") != null) {
                VFindDatabnkDepDepositMaster depositMaster = (VFindDatabnkDepDepositMaster) request.getSession().getAttribute("depDepositMasterCr");
                crAccNo = depositMaster.getCOurAccountNo();

                if (crAccNo.length() > 5) {
                    crAccNo = crAccNo.substring(0, 2) + "-" + crAccNo.substring(2, 5) + "-" + crAccNo.substring(5);
                    System.out.println(crAccNo);
                } else if (crAccNo.length() <= 5 && crAccNo.length() > 2) {
                    crAccNo = crAccNo.substring(0, 2) + "-" + crAccNo.substring(2);
                    System.out.println(crAccNo);
                } else {
                    crAccNo = crAccNo.substring(0);
                    System.out.println(crAccNo);
                }

                crAccNoLabel = depositMaster.getCOurAccountNo();
                crCDepName = depositMaster.getCDepName();
                crNCurBookBalance = String.valueOf(depositMaster.getNCurBookBalance());
                cFullName1 = depositMaster.getCFullName();
                
            }
            String brAccNo = "";
            String brAccNoLabel = "අංකය";
            String brCDepName = "වර්ගය";
            String brNCurBookBalance = "ශේෂය";
            if (request.getSession().getAttribute("depDepositMasterBr") != null) {
                VFindDatabnkDepDepositMaster depositMaster = (VFindDatabnkDepDepositMaster) request.getSession().getAttribute("depDepositMasterBr");
                brAccNo = depositMaster.getCOurAccountNo();

                if (brAccNo.length() > 5) {
                    brAccNo = brAccNo.substring(0, 2) + "-" + brAccNo.substring(2, 5) + "-" + brAccNo.substring(5);
                    System.out.println(brAccNo);
                } else if (brAccNo.length() <= 5 && brAccNo.length() > 2) {
                    brAccNo = brAccNo.substring(0, 2) + "-" + brAccNo.substring(2);
                    System.out.println(brAccNo);
                } else {
                    brAccNo = crAccNo.substring(0);
                    System.out.println(brAccNo);
                }

                brAccNoLabel = depositMaster.getCOurAccountNo();
                brCDepName = depositMaster.getCDepName();
                brNCurBookBalance = String.valueOf(depositMaster.getNCurBookBalance());
                cCIFNo = depositMaster.getCCIFNo();
                cMemberShipNo = depositMaster.getCMemberShipNo();
                cNICNo = depositMaster.getCNICNo();
                cFullName2 = depositMaster.getCFullName();
                cUseName = depositMaster.getCUseName();
                cPAddLine1 = depositMaster.getCPAddLine1();
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
                        ගිනුම් අතර මුදල් හුවමාරුව -
                        <small>තැම්පත් ගනුදෙනු</small> 
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">තැම්පත් ගනුදෙනු</a></li>
                        <li class="active">ගිනුම් අතර මුදල් හුවමාරුව</li>
                    </ol>
                </section>

                <form action="../NewDepDopositTypesServlet" method="post" onsubmit="validateMoneyTranslate(this);
                        return false;">

                    <section class="content">
                        <div class="row bg-top">
                            <div class="col-md-9 bg-pad">
                                <div class="box box-info bg-color">
                                    <div class="box-body" style="padding: 0;padding-bottom: 5px;">
                                        <div class="row">
                                            <div class="col-md-8" style="margin-top: 30px;"> 
                                                <div class="form-group" >
                                                    <label class="control-label col-sm-4 input-sm" style="font-size: 14px;padding-left: 35px;">ගිණුම් අංකය  :</label>
                                                    <div class="col-md-7">
                                                        <div class="input-group">

                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size: 17px;" autocomplete="off" placeholder="ගිණුම් අංකය" maxlength="15" name="crAccNo" id="crAccNo" value="<%=crAccNo%>" onkeyup="changeAccountNumber1()">

                                                            <span class="input-group-btn">
                                                                <button class="btn btn-info btn-flat btn-sm" type="button" onclick="crBrAccountAcction()"><i class="fa fa-search"></i></button>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 bg-top" style="margin-bottom: 15px;margin-top: 10px;">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4  text-right">අංකය :</label>
                                                    <label class="control-label col-sm-8 "><%=crAccNoLabel%></label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4 text-right">වර්ගය :</label>
                                                    <label class="control-label col-sm-8 "><%=crCDepName%></label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4 text-right" style="padding-left: 10px;">ශේෂය :</label>
                                                    <label class="control-label col-sm-8 "><%=crNCurBookBalance%></label>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-sm-4 text-right">නම :</label>
                                                    <label class="control-label col-sm-7 "><%=cFullName1%></label>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.box-body -->
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="box box-info bg-color">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12 bg-top">
                                                <div class="form-group">
                                                    <label class="col-md-6 input-sm text-right" style="padding-left: 0px;" >ආරම්භක ශේෂය :</label>
                                                    <label class="col-md-6 input-sm" name="cCIFNo" id="cCIFNo" >පා.ලි. අංකය </label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-6 input-sm text-right" style="margin-top: -18px" > හර :</label>
                                                    <label class="col-md-6 input-sm" style="margin-top: -18px" name="cMemberShipNo" id="cMemberShipNo" >සාමාජික අංකය</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-6 input-sm text-right" style="margin-top: -18px" >බැර :</label>
                                                    <label class="col-md-6 input-sm" name="cNICNo" style="margin-top: -18px" id="cNICNo" > ජැ.හැ. අංකය</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-6 input-sm text-right" style="padding-left: 0px;margin-top: -18px" >අවසාන ශේෂය :</label>
                                                    <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -18px" id="cUseName" >භාවිත නම</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-6 input-sm text-right" style="margin-top: -18px;margin-bottom: -3px" > බැංකු ශේෂය :</label>
                                                    <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -18px;margin-bottom: -3px" id="cUseName" >භාවිත නම</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-9 bg-pad bg-top">
                                <div class="panel box box-info bg-color">
                                    <div class="box-body" style="margin-bottom: -20px">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading" style="height:30px;background-color: #367fa9;">
                                                        <h6 class="panel-title" style="color: #fff;font-weight: bold;margin-top: -5px;">
                                                            බැරවන ගිණුම
                                                        </h6>
                                                    </div>
                                                    <div class="panel-body" style="background-color:  #e7f0f7;">
                                                        <div class="row">
                                                            <div class="col-sm-8" style="margin-top: 25px;">
                                                                <div class="form-group">

                                                                    <!--<form action="../GetterMoneyTransactionServelet?searchingType=" method="post" name="accForm" onsubmit="validateGetAccountNo(this); return false;">-->

                                                                    <label class="control-label col-sm-4 input-sm" style="font-size: 14px" >බැරවන ගිණුම් අංකය:</label>
                                                                    <div class="col-md-7">
                                                                        <div class="input-group">
                                                                            <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" style="font-size: 17px;" autocomplete="off" placeholder="ගිණුම් අංකය" maxlength="15" name="brAccNo" id="brAccNo" value="<%=brAccNo%>" onkeyup="changeAccountNumber2()">

                                                                            <span class="input-group-btn">
                                                                                <button class="btn btn-info btn-flat btn-sm" type="button" onclick="brBrAccountAcction()"><i class="fa fa-search"></i></button>
                                                                            </span>
                                                                        </div>
                                                                    </div>

                                                                    <!--</form>-->

                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="control-label col-sm-4  text-right">අංකය:</label>
                                                                    <label class="control-label col-sm-8 "><%=brAccNoLabel%></label>
                                                                    <label class="control-label col-sm-4 text-right" style="padding-left: 5px;">වර්ගය :</label>
                                                                    <label class="control-label col-sm-8 "><%=brCDepName%></label>
                                                                    <label class="control-label col-sm-4 text-right" style="padding-left: 5px;">ශේෂය :</label>
                                                                    <label class="control-label col-sm-8 "><%=brNCurBookBalance%></label>
                                                                    <label class="control-label col-sm-4 text-right">නම :</label>
                                                                    <label class="control-label col-sm-8 "><%=cFullName2%></label>
                                                                </div>  


                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel panel-primary">
                                                    <div class="panel-body" style="background-color:  #e7f0f7;">
                                                        <div class="row">
                                                            <div class="col-sm-8">
                                                                <div class="form-group">
                                                                    <label class="control-label col-sm-4 input-sm" style="font-size: 14px">හුවමරුවන මුදල :</label>
                                                                    <div class="col-md-7">
                                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.00" style="font-size: 17px" name="nMinParticipant" data="validate" data-type="decimal">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer" style="background-color: #e7f0f7"> 
                                        <button style="font-weight: bold;" type="submit" class="btn btn-primary btn-sm">ගනුදෙනුව සිදු කරන්න</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 bg-top">
                                <div class="panel box box-info bg-color">
                                    <div class="box-body">
                                    </div>  
                                </div>
                            </div>
                        </div>
                    </section>

                </form>                                            

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

    <script type="text/javascript" >

                                                                                    //-----------Action Function-------------

                                                                                    function crBrAccountAcction() {
                                                                                        window.location = "view_depositmaster.jsp?tellerIndexKey=mTCR";
                                                                                    }

                                                                                    function brBrAccountAcction() {
                                                                                        window.location = "view_depositmaster.jsp?tellerIndexKey=mTBR";
                                                                                    }

                                                                                    //---------------------------------------


                                                                                    function validateMoneyTranslate(cForm) {
                                                                                        var bool = new Boolean();
                                                                                        bool = true;

                                                                                        var nCurrentIntRate = cForm["nCurrentIntRate"].value;
                                                                                        var nIntCalID = cForm["nIntCalID"].value;
                                                                                        var nIntPayID = cForm["nIntPayID"].value;

                                                                                        if (sysCode === "0" || sysCode === "") {
                                                                                            bool = false;
                                                                                            document.getElementById('sysCode').style.borderColor = "red";
                                                                                        } else {
                                                                                            document.getElementById('sysCode').style.borderColor = "";
                                                                                        }
//                                                  
                                                                                        if (bool) {
                                                                                            document.forms["cForm"].submit();
                                                                                        } else {
                                                                                            alert("ඇතුලත් කිරීමට අවශ්‍ය තොරතුරු නිවැරදිව ඇතුලත් වී නොමැත...");
                                                                                        }
                                                                                    }





                                                                                    function changeAccountNumber1() {
                                                                                        var aN = document.getElementById("crAccNo").value;

                                                                                        aN = setAccountNumber(aN);
                                                                                        if (!isNaN(aN)) {
                                                                                            document.getElementById("crAccNo").style.color = "black";

                                                                                            if (aN.length > 5) {
                                                                                                aN = aN.substring(0, 2) + "-" + aN.substring(2, 5) + "-" + aN.substring(5);
                                                                                            } else if (aN.length <= 5 && aN.length > 2) {
                                                                                                aN = aN.substring(0, 2) + "-" + aN.substring(2);
                                                                                            } else {
                                                                                                aN = aN.substring(0);
                                                                                            }
                                                                                        } else {
                                                                                            document.getElementById("crAccNo").style.color = "red";
                                                                                        }
                                                                                        document.getElementById("crAccNo").value = aN;

                                                                                    }

                                                                                    function changeAccountNumber2() {
                                                                                        var aN = document.getElementById("brAccNo").value;

                                                                                        aN = setAccountNumber(aN);
                                                                                        if (!isNaN(aN)) {
                                                                                            document.getElementById("brAccNo").style.color = "black";

                                                                                            if (aN.length > 5) {
                                                                                                aN = aN.substring(0, 2) + "-" + aN.substring(2, 5) + "-" + aN.substring(5);
                                                                                            } else if (aN.length <= 5 && aN.length > 2) {
                                                                                                aN = aN.substring(0, 2) + "-" + aN.substring(2);
                                                                                            } else {
                                                                                                aN = aN.substring(0);
                                                                                            }
                                                                                        } else {
                                                                                            document.getElementById("brAccNo").style.color = "red";
                                                                                        }
                                                                                        document.getElementById("brAccNo").value = aN;

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
    </script>
    <script src="../js/validate.js" type="text/javascript"></script>
</html>
