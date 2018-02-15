<%-- 
    Document   : money_saving1
    Created on : Jan 27, 2015, 7:42:42 PM
    Author     : mmh
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="net.sf.jasperreports.engine.JRException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%--<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporter"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.nbs.model.common.JDBC"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkDepDepositTransaction"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%        String moneyDepType = "";
            if (request.getParameter("moneyDepType") != null) {
                moneyDepType = request.getParameter("moneyDepType");
            }

            String header = "";
            String moneyTypeName = "";
            int id = 0;
            if ("1".equals(moneyDepType)) {
                header = "මුදල් තැම්පත් කිරීම";
                moneyTypeName = "තැම්පත් මුදල";
                id = 1;
            } else if ("2".equals(moneyDepType)) {
                header = "මුදල් ආපසු ගැනීම";
                moneyTypeName = "ආපසු ගන්නා මුදල";
                id = 2;
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=header%></title>

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
        <input type="hidden" value="<%=id%>" id="mDepId" name="mDepId">
        <%
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dDepositDate = request.getSession().getAttribute("logDate").toString();
            String cReceiptNo = "";
            String cReceiptNo2 = "";
            String nPaymentVal = "";
            long nDepTrnID=0;

            String bankType = "";

            System.out.println("depooooosite transsss "+request.getSession().getAttribute("bddt"));
            if (request.getSession().getAttribute("bddt") != null) {

                BnkDepDepositTransaction bddt = (BnkDepDepositTransaction) request.getSession().getAttribute("bddt");
                nDepTrnID=bddt.getNDepTrnID();
                
                if (bddt.getDDepositDate() != null) {
                    dDepositDate = dateFormat.format(bddt.getDDepositDate());
                }
                if (bddt.getCReceiptNo() != null) {
                    cReceiptNo = String.valueOf(bddt.getCReceiptNo());
                }
                if (bddt.getCReceiptNo2() != null) {
                    cReceiptNo2 = String.valueOf(bddt.getCReceiptNo2());
                }
                if (bddt.getNPaymentVal() != null) {
                    nPaymentVal = String.valueOf(bddt.getNPaymentVal());
                }

                request.getSession().removeAttribute("bddt");
            }

            String successMsg = "";
            if (request.getParameter("successMsg") != null) {
                successMsg = request.getParameter("successMsg");
            }

            String cCIFNo = "පා.ලි. අංකය ";
            String cMemberShipNo = "සාමාජික අංකය";
            String cNICNo = " ජැ.හැ. අංකය";
            String cUseName = "භාවිත නම";
            String cFullName = "--------------------සම්පූර්ණ නම--------------------";
            String cPAddLine1 = "----------ලිපිනය----------";
            String cOurAccountNo = "";

            String nCurBookBalance = "";
            String nNotCreditIntBalance = "";
            String nAvailableBalance = "";
            String nHoldedAmount = "";

            String nDepMFID = "";

            
            if (request.getSession().getAttribute("depDepositMaster") != null) {
                VFindDatabnkDepDepositMaster depDepositMaster = (VFindDatabnkDepDepositMaster) request.getSession().getAttribute("depDepositMaster");
                cCIFNo = depDepositMaster.getCCIFNo();
                cMemberShipNo = depDepositMaster.getCMemberShipNo();
                cNICNo = depDepositMaster.getCNICNo();
                cFullName = depDepositMaster.getCFullName();
                cUseName = depDepositMaster.getCUseName();
                cPAddLine1 = depDepositMaster.getCPAddLine1();

                cOurAccountNo = depDepositMaster.getCOurAccountNo();

                if (cOurAccountNo.length() > 5) {
                    cOurAccountNo = cOurAccountNo.substring(0, 2) + "-" + cOurAccountNo.substring(2, 5) + "-" + cOurAccountNo.substring(5);
                    System.out.println(cOurAccountNo);
                } else if (cOurAccountNo.length() <= 5 && cOurAccountNo.length() > 2) {
                    cOurAccountNo = cOurAccountNo.substring(0, 2) + "-" + cOurAccountNo.substring(2);
                    System.out.println(cOurAccountNo);
                } else {
                    cOurAccountNo = cOurAccountNo.substring(0);
                    System.out.println(cOurAccountNo);
                }

                nCurBookBalance = String.valueOf(depDepositMaster.getNCurBookBalance());
                nHoldedAmount = String.valueOf(depDepositMaster.getNHoldedAmount());
                nNotCreditIntBalance = String.valueOf(depDepositMaster.getNNotCreditIntBalance());
                nAvailableBalance = String.valueOf(depDepositMaster.getNAvailableBalance());

                nDepMFID = String.valueOf(depDepositMaster.getNDepMFID());
            }

            String savingType = "";
            if (request.getParameter("savingType") != null) {
                savingType = request.getParameter("savingType");
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
                        <%=header%> -
                        <small>තැම්පත් ගනුදෙනු</small> 
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#">තැම්පත් ගනුදෙනු</a></li>
                        <li class="active">මුදල් තැම්පත්</li>
                    </ol>
                </section>

                <section class="content">
                    <div class="row bg-top">
                        <div class="col-md-9 bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-8">  
                                            <div class="form-group">
                                                <form action="../GetterMoneyTransactionServelet?searchingType=<%=moneyDepType%>" method="post" name="accForm" onsubmit="validateGetAccountNo(this);
                                                        return false;">
                                                    <label class="col-sm-4 control-label" id="accNumLabel" name="accNumLabel" ><h4><strong>ගිණුම් අංකය</strong></h4></label>
                                                    <div class="col-sm-8">
                                                        <div class="input-group">
                                                            <input type="hidden" name="accountValue" id="accountValue" value="1" />
                                                            
                                                            <input type="text" class="form-control text-right convertSinhalaIskolaPotha" style="font-size: larger;font-weight: bolder" autocomplete="off" placeholder="ගිණුම් අංකය" maxlength="15" onkeyup="changeAccountNumber()" name="accountNumber" id="accountNumber" value="<%=cOurAccountNo%>">
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
                                                <label class="col-md-6 input-sm" name="cCIFNo" id="cCIFNo" ><%=cCIFNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px" > හර :</label>
                                                <label class="col-md-6 input-sm" style="margin-top: -18px" name="cMemberShipNo" id="cMemberShipNo" ><%=cMemberShipNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px" >බැර :</label>
                                                <label class="col-md-6 input-sm" name="cNICNo" style="margin-top: -18px" id="cNICNo" ><%=cNICNo%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px ;padding-left: 0px;" >අවසාන ශේෂය :</label>
                                                <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -18px" id="cUseName" ><%=cUseName%></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-6 input-sm text-right" style="margin-top: -18px;margin-bottom: -3px" > බැංකු ශේෂය :</label>
                                                <label class="col-md-6 input-sm" name="cUseName" style="margin-top: -18px;margin-bottom: -3px" id="cUseName" ><%=cUseName%></label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Money saving./left-box-->
                    <div class="row">
                        <div id="moneySaving" class="col-md-9 bg-pad bg-top">
                            <!--Money saving-->
                            <div class="panel box box-info bg-color">
                                <!--./body-->
                                <form  class="form-horizontal" action="../NewBnkDepDepositTransactionServlet" method="post" name="depForm" onsubmit="validateNewDeposit(this);
                                        return false;">
                                    <div class="box-body">
                                        <!--./row-->
                                        <div class="row">
                                            <div class="col-md-7">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4 input-sm ">ගණුදෙණුව කල දිනය :</label>
                                                    <div class="col-md-8">
                                                        <input type="date" class="form-control input-sm text-center convertSinhalaIskolaPotha" style="font-size:15px;" name="dDepositDate" id="dDepositDate" value="<%=dDepositDate%>">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top:-10px">
                                                    <label class="control-label col-sm-4 input-sm">බිල් අංකය 1:</label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control input-sm text-left convertSinhalaIskolaPotha" placeholder="0" style="font-size:17px;" maxlength="25" name="cReceiptNo" id="cReceiptNo" value="<%=cReceiptNo%>" data="number" data-type="number">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top:-10px">
                                                    <label class="control-label col-sm-4 input-sm">බිල් අංකය 2:</label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control input-sm text-left convertSinhalaIskolaPotha" placeholder="0" style="font-size:17px;" maxlength="25" name="cReceiptNo2" id="cReceiptNo2" value="<%=cReceiptNo2%>" data="number" data-type="number">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top:-10px">
                                                    <label class="control-label col-sm-4 input-sm">ශේෂය :</label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" disabled placeholder="0.0" style="font-size:17px;" maxlength="25" name="nCurBookBalance" id="nCurBookBalance" value="<%=nCurBookBalance%>" data="number" data-type="decimal">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top:-10px">
                                                    <label class="control-label col-sm-4 input-sm"> රැදවු මුදල :</label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" disabled placeholder="0.0" style="font-size:17px;" maxlength="25" name="nHoldedAmount" id="nHoldedAmount" value="<%=nHoldedAmount%>" data="number" data-type="decimal">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top:-10px">
                                                    <label class="control-label col-sm-4 input-sm">බැර නොවු පොළිය :</label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" disabled placeholder="0.0" style="font-size:17px;" maxlength="25"  name="nNotCreditIntBalance" id="nNotCreditIntBalance" value="<%=nNotCreditIntBalance%>" data="number" data-type="decimal">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top:-10px">
                                                    <label class="control-label col-sm-4 input-sm"> ගත හැකි මුදල :</label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" disabled placeholder="0.0" style="font-size:17px;" maxlength="25" name="nAvailableBalance" id="nAvailableBalance" value="<%=nAvailableBalance%>" data="number" data-type="decimal">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4 input-sm"><b><%=moneyTypeName%> :</b></label>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control text-right convertSinhalaIskolaPotha" placeholder="0.00" style="font-size:large;color: blue" maxlength="30" name="nPaymentVal" id="nPaymentVal" value="<%=nPaymentVal%>" data="number" data-type="decimal">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-5" >
                                                <div class="callout callout-info" style="height: 290px">
                                                    <div class="form-group">
                                                        <div class="box box-solid">

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!--./row-->
                                    </div>
                                    <!--./body-->
                                    <div class="box-footer" style="background-color: #e7f0f7"> 
                                        <input type="hidden" name="nDepMFID" id="nDepMFID" value="<%=nDepMFID%>"/>
                                        <input type="hidden" name="moneyDepType" id="moneyDepType" value="<%=moneyDepType%>"/>
                                        <button type="submit" class="btn btn-primary btn-sm" style="font-weight: bold;">ගණුදෙණුව සිදුරන්න</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--Money saving-->

                        <!--./messageview money saving-->
                        <div id="msMessage" class="col-md-9 bg-pad bg-top">
                            <div class="panel box box-info bg-color bg-subheight">
                                <div class="box-body">
                                    <br/><br/>
                                    <div class="alert alert-success alert-dismissable">
                                        <i class="fa fa-check"></i>
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                        <h4><b>Alert!</b> Success alert preview.</h4>
                                    </div>
                                    <div class="callout callout-info">
                                        <h2>රිසිට් පතක් මුද්‍රණය කිරිමට අවශ්‍යද ?</h2>
                                        <div>
                                            <button type="submit" class="btn btn-warning" onclick="">No</button>
                                            <button type="submit" class="btn btn-primary" onclick="showRpriviwer()">Yes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--./messageview money saving-->

                        <!--./Risit previwer-->
                        
                        
                        <div id="risitPriviwer" class="col-md-9 bg-pad bg-top">
                            <div class="panel box box-info bg-color bg-subheight">
                                <div class="box-header">
                                    <h4 class="box-title">
                                        රිසිට් පත මුද්‍රණය
                                    </h4>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-lg-12" style="height: 272px;">
                                            <div class="box box-solid" style="height: 272px;background-color: black" id="savingsReport">
                                                <!--<embed width="100%" height="100%" name="plugin" src="http://localhost:8080/NewMyBank-war/TestServlet" type="application/pdf">-->
                                               
                                                <!--<embed width="100%" height="100%" name="plugin" src="../reports/savingsReport.pdf" type="application/pdf">-->
                                                
                                                <!--                                                                                                <object style="width:100%;" data="/home/mmh/savingsReport.pdf#zoom=85&scrollbar=0&toolbar=0&navpanes=0" type="application/pdf">
                                                                                                <embed src="/home/mmh/savingsReport.pdf?#zoom=85&scrollbar=0&toolbar=0&navpanes=0" type="application/pdf" />
                                                                                                </object>-->
                                                
                                                <iframe id="frm" src="../marksGraph.jsp?rep_id=1&nDepTrnID=<%= nDepTrnID%>" frameborder="0" width="100%" style="height: 272px;"></iframe>
                                                
                                                
                                                <!--                                                <object style="width:100%;" data="http://localhost:8080/NewMyBank-war/TestServlet" type="application/pdf">
                                                                                                    <embed src="http://localhost:8080/NewMyBank-war/TestServlet" type="application/pdf" />
                                                                                                </object>-->
                                                
                                                
                                                
                                                
                                                <%
                                              Connection conn = null;
    try {
        //Connecting to the MySQL database

//        Class.forName("com.mysql.jdbc.Driver");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbsERP_Kurunegala?user=root&password=123");
//
//        //Loading Jasper Report File from Local file system
//        
//        String jrxmlFile = session.getServletContext().getRealPath("newReport.jrxml") ;
//        InputStream input = new FileInputStream(new File(jrxmlFile));
//System.out.println("888888888888888  "+jrxmlFile);
//        //Generating the report
//        JasperReport jasperReport = JasperCompileManager.compileReport(input);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
//
//        //Exporting the report as a PDF
//        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

    
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
                                                %>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="box-footer" style="background-color: #e7f0f7"> 
                                    <!--style="background-color: #fbfbfb"-->
                                    <button type="submit" class="btn btn-primary" onclick="showRpMessage()()">Print</button>
                                    <!--show()-->
                                </div>
                            </div>
                        </div>
                        
                        
                        
                        <!--./Risit previwer-->

                        <!--./messageview risit printing-->
                        <div id="rpMessage" class="col-md-9 bg-pad bg-top">
                            <div class="panel box box-info bg-color bg-subheight">
                                <div class="box-body">
                                    <br/><br/>
                                    <div class="alert alert-success alert-dismissable">
                                        <i class="fa fa-check"></i>
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                        <h4><b>Alert!</b> Success alert preview. This alert is dismissable.</h4>
                                    </div>
                                    <div class="callout callout-info">
                                        <h2>Pass potha mudranaya kirimata Awashayada ?</h2>
                                        <div>
                                            <button type="submit" class="btn btn-warning" onclick="">No</button>
                                            <button type="submit" class="btn btn-primary" onclick="showPassBook()()">Yes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--./messageview risit printing-->

                        <!--pass book print-->
                        <div id="passPrint" class="col-md-9 bg-pad bg-top">
                            <div class="panel box box-info bg-color bg-subheight">
                                <div class="box-header">
                                    <h4 class="box-title">
                                        පාස් පොත මුද්‍රණය
                                    </h4>
                                </div>

                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="box box-solid">
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                                                    Mudranaya Kala
                                                                </label>
                                                            </div>
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                                                                    Mudranaya Nokala
                                                                </label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-9">
                                                            <div class="form-group">
                                                                <div class="col-md-6">
                                                                    <div class="checkbox">
                                                                        <label>
                                                                            <input type="checkbox" name="optionsRadios" id="optionsRadios2" value="option2">
                                                                            Arambaka Mudala Mudranayata
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha" placeholder="0.0" style="font-size:large;" maxlength="25">
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <button type="submit" class="btn btn-primary btn-sm" onclick="">Labaganna</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /.box-body -->
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="box box-solid" >
                                                <div class="box-body" >
                                                    <table class="table table-bordered">
                                                        <tbody>
                                                            <tr>
                                                                <th>අංකය</th>
                                                                <th>දිනය</th>
                                                                <th>ගනුදෙනු වර්ගය</th>
                                                                <th >හර</th>
                                                                <th >බැර</th>
                                                                <th >මුද්‍රණය</th>
                                                                <th >කැෂියර්</th>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td></td>
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
                                </div>
                                <div class="box-footer"> 
                                    <!--style="background-color: #f4f4f4"-->
                                    <button type="submit" class="btn btn-primary" onclick="show()">Print</button>
                                </div>
                            </div>
                        </div>
                        <!--pass book print-->

                        <!--./right-box-->
                        <div class="col-md-3" >
                            <div class="panel box box-info bg-color bg-top">
                                <!--./body-->
                                <div class="box-body">
                                    <!--./row-->
                                    <div class="row">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->
        <input type="hidden" name="successMsg" id="successMsg" value="<%=successMsg%>" />
        <input type="hidden" name="bankType" id="bankType" value="<%=bankType%>" />
    </body>

    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    <script src="../js/bootbox.js" type="text/javascript"></script>
    <script src="../js/bootbox.min.js" type="text/javascript"></script>

    <script type="text/javascript">

                                        $(document).ready(function () {
                                            $("#passPrint").hide();
                                            $("#msMessage").hide();
                                            $("#risitPriviwer").hide();
                                            $("#rpMessage").hide();

                                            if (document.getElementById("moneyDepType").value === "1") {
                                                document.getElementById("moneyDepType1").className = "active";
                                            } else {
                                                document.getElementById("moneyDepType2").className = "active";
                                            }

                                        });

                                        var successMsg = document.getElementById("successMsg").value;
                                        if (successMsg === "1") {
                                            $(document).ready(function () {
                                                $("#moneySaving").hide();
                                                $("#msMessage").show();
                                            });
                                        }

                                        function showRpriviwer() {
                                            $(document).ready(function () {
                                                $("#msMessage").hide();
                                                $("#risitPriviwer").show();
                                            });
                                        }
                                        function showRpMessage() {
                                            $(document).ready(function () {
                                                $("#risitPriviwer").hide();
                                                $("#rpMessage").show();
                                            });
                                        }
                                        function showPassBook() {
                                            $(document).ready(function () {
                                                $("#rpMessage").hide();
                                                $("#passPrint").show();
                                            });
                                        }

                                        //-------ONKEY UP----------------------
                                        function changeAccountNumber() {
                                            var aN = document.getElementById("accountNumber").value;
                                            aN = setAccountNumber(aN);
                                            if (!isNaN(aN)) {
                                                document.getElementById("accountNumber").style.color = "black";

                                                if (aN.length > 5) {
                                                    aN = aN.substring(0, 2) + "-" + aN.substring(2, 5) + "-" + aN.substring(5);
                                                } else if (aN.length <= 5 && aN.length > 2) {
                                                    aN = aN.substring(0, 2) + "-" + aN.substring(2);
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
                                        //-------ONKEY UP----------------------

                                        //-----------VALIDATION SUBMIT---------------------
                                        function validateGetAccountNo(accForm) {
                                            var aN = document.getElementById("accountNumber").value;
                                            aN = setAccountNumber(aN);
                                            if (!isNaN(aN)) {
                                                document.forms["accForm"].submit();
                                            } else {
                                                bootbox.alert("<b>ගිණුම් අංකය වැරදි.</b>", function () {
                                                });
                                            }
                                        }

                                        function validateNewDeposit(depForm) {
                                            var nAccountNo = document.getElementById("accountNumber").value;
                                            var cReceiptNo = document.getElementById("cReceiptNo");
                                            var nPaymentVal = document.getElementById("nPaymentVal");
                                            var nAvailableBalance = document.getElementById("nAvailableBalance");
                                            var mDepId = document.getElementById("mDepId").value;
                                            
                                            
                                            if(nAccountNo==""){
                                                bootbox.alert("<b>ගිණුම් අංකය ඇතුලත් කරන්න.</b>", function () {
                                                });
                                            } else if (cReceiptNo.value.length === 0) {
                                                bootbox.alert("<b>බිල් අංක 1 පුරවන්න</b>", function () {
                                                });
                                            } else if (nPaymentVal.value.length === 0) {
                                                bootbox.alert("<b>මුදල පුරවන්න</b>", function () {
                                                });
                                            } else if (mDepId === "2") {
                                                if (parseFloat(nPaymentVal.value) > parseFloat(nAvailableBalance.value)) {
                                                    bootbox.alert("<b>මෙම ගණුදෙණුව සිදු කිරීමට ප්‍රමාණවත් ශේෂයක් නොමැත.ගිණුම නැවත පරීක්ෂා කරන්න.</b>", function () {
                                                    });
                                                } else {
                                                    bootbox.confirm("<b>(" + nPaymentVal.value + ") ඔබ මේ ගණුදෙනුව කිරිමට සුදානම්ද ?</b>", function (result) {
                                                        if (result) {
                                                            document.forms["depForm"].submit();
                                                        }
                                                    });
                                                }
                                            } else {
                                                bootbox.confirm("<b>(" + nPaymentVal.value + ") ඔබ මේ ගණුදෙනුව කිරිමට සුදානම්ද ?</b>", function (result) {
                                                    if (result) {
                                                        document.forms["depForm"].submit();
                                                    }
                                                });
                                            }
                                        }
                                        //---------------------------------
    </script>
    <script src="../js/validate.js" type="text/javascript"></script>

</html>