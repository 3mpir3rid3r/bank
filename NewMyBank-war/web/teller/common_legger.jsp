<%@page import="com.nbs.model.ActChartOfAcctL5"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : common_legger
    Created on : Feb 3, 2015, 1:46:03 PM
    Author     : lasantha
--%>

<%@page import="com.nbs.model.ActChartOfAcctL4"%>
<%@page import="com.nbs.model.ActChartOfAcctL3"%>
<%@page import="com.nbs.model.ActChartOfAcctL2"%>
<%@page import="java.util.AbstractList"%>
<%@page import="com.nbs.controller.get.GetViewCommonLeggerServlet"%>
<%@page import="com.nbs.model.ActChartOfAcctL1"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | Common Legger </title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <!--<link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>-->
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
        </style>
        <script type="text/javascript">
            var act1Id = 0;
            var act2Id = 0;
            var act3Id = 0;
            var act4Id = 0;

            <%                if (request.getSession().getAttribute("act1") == null) {

            %>

            window.location = "../GetViewCommonLeggerServlet";
            <%}%>


        </script>
    </head>

    <body class="skin-blue fixed pace-done" onload=" autoClick()" >

        <div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
                <div class="pace-progress-inner"></div>
            </div>
            <div class="pace-activity"></div>
        </div>

        <!--........header.....-->
        <%@include file="teller_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include  file="teller_sidebar.jsp"%>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->
            <!--Report Printig-->
            <%            boolean isView = false;
                if (session.getAttribute("viewRep") != null) {
                    String view = String.valueOf(session.getAttribute("viewRep"));
                    isView = Boolean.parseBoolean(view);
                    session.removeAttribute("viewRep");

                }
            %>
            <%
                if (isView) {
            %>
            <a id="linkToClick" href="printCommonLegger.jsp" target="_blank"></a>
            <% }%>

            <!--rep print over-->

            <%

                List<ActChartOfAcctL1> acctL1s = (AbstractList<ActChartOfAcctL1>) request.getSession().getAttribute("act1");
                List<ActChartOfAcctL2> acctL2s = (AbstractList<ActChartOfAcctL2>) request.getSession().getAttribute("act2");
                List<ActChartOfAcctL3> acctL3s = (AbstractList<ActChartOfAcctL3>) request.getSession().getAttribute("act3");
                List<ActChartOfAcctL4> acctL4s = (AbstractList<ActChartOfAcctL4>) request.getSession().getAttribute("act4");
                List<ActChartOfAcctL5> acctL5s = (AbstractList<ActChartOfAcctL5>) request.getSession().getAttribute("act5");

                List<ActChartOfAcctL2> actt2 = new ArrayList<ActChartOfAcctL2>();
                List<ActChartOfAcctL3> actt3 = new ArrayList<ActChartOfAcctL3>();
                List<ActChartOfAcctL4> actt4 = new ArrayList<ActChartOfAcctL4>();
                List<ActChartOfAcctL5> actt5 = new ArrayList<ActChartOfAcctL5>();

                if (request.getParameter("mid") != null) {
                    if (request.getSession().getAttribute("actt2") != null) {

                        actt2 = (List<ActChartOfAcctL2>) request.getSession().getAttribute("actt2");

                    }
                    if (request.getSession().getAttribute("actt3") != null) {
                        actt3 = (AbstractList<ActChartOfAcctL3>) request.getSession().getAttribute("actt3");
                    }
                    if (request.getSession().getAttribute("actt4") != null) {
                        actt4 = (AbstractList<ActChartOfAcctL4>) request.getSession().getAttribute("actt4");
                    }
                    if (request.getSession().getAttribute("actt5") != null) {

                        actt5 = (AbstractList<ActChartOfAcctL5>) request.getSession().getAttribute("actt5");
                    }

                }
            %>
            <!--...........right-side.........-->
            <aside id="content" class="right-side">
                <section class="content-header" >
                    <h1>
                        පොදු ලෙජරය
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li class="active">පොදු ලෙජරය</li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-searchheight bg-top">
                        <div id="main" class="col-md-5 bg-searchheight  bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-8 bg-pad">
                                            <div class="zTreeDemoBackground left">
                                                <ul id="treeDemo" class="ztree " style="width: auto;height: 585px;font-size: 12px;"></ul>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <br/>
                                            <input type="hidden" value="0" id="storeClickedButton"/>
                                            <input type="hidden" value="<%=acctL2s.get(acctL2s.size() - 1).getCCAAcctNoL2()%>" id="storeAct5LstNo"/>
                                            <input type="hidden" value="<%=acctL2s.get(acctL2s.size() - 1).getCCAAcctNoL2()%>" id="storeAct2LstNo"/>
                                            <input type="hidden" value="0" id="storeAct3LstNo"/>
                                            <input type="hidden" value="0" id="storeAct4LstNon"/>

                                            <button type="submit" class="btn btn-success btn-sm btn-block" onclick="showOne();
                                                    setRightDivSize(1)">මුලික ශීර්ෂය</button>


                                            <button type="submit" class="btn btn-success btn-sm btn-block" onclick="showTwo();
                                                    setRightDivSize(2)">උප ශීර්ෂය</button>
                                            <button type="submit" class="btn btn-success btn-sm btn-block" onclick="showThree();
                                                    setRightDivSize(3)">ශීර්ෂය</button>
                                            <button type="submit" class="btn btn-success btn-sm btn-block" onclick="showSeven();
                                                    setRightDivSize(4)" >ශීර්ෂය 2</button>

                                            <br><br>
                                            <button type="submit" class="btn btn-warning btn-sm btn-block" onclick="showFour();
                                                    setRightDivSize(5)">ගිණුම්</button>
                                            <button type="submit" class="btn btn-warning btn-sm btn-block" onclick="showFive();
                                                    setRightDivSize(6)">වෙනස් කිරීම</button>
                                            <button type="submit" class="btn btn-warning btn-sm btn-block" onclick="showSix();
                                                    setRightDivSize(7)">වාර්ථාව</button>

                                            <br><br>

                                            <form style="margin-bottom: 5px" action="../ViewLeggerReportServlet">
                                                <input type="hidden" value="1" name="rep"/>
                                                <button type="submit" class="btn btn-primary btn-sm btn-block" onclick="">Reports</button>
                                            </form>

                                            <form style="margin-bottom: 5px" action="../ViewLeggerReportServlet">
                                                <input type="hidden" value="2" name="rep"/>
                                                <button type="submit" class="btn btn-primary btn-sm btn-block" onclick="">Reports</button>
                                            </form>
                                            <form style="margin-bottom: 5px" action="../ViewLeggerReportServlet">
                                                <input type="hidden" value="3" name="rep"/>
                                                <button type="submit" class="btn btn-primary btn-sm btn-block" onclick="">Reports</button>
                                            </form>
                                            <form style="margin-bottom: 5px" action="../ViewLeggerReportServlet">
                                                <input type="hidden" value="4" name="rep"/>
                                                <button type="submit" class="btn btn-primary btn-sm btn-block" onclick="">Reports</button>
                                            </form>
                                            <!--<button type="submit" class="btn btn-success btn-sm btn-block" onclick="showMsMessage()">කරන්න</button>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="one" class="col-md-7 bg-searchheight">

                            <div id="dynamicDiv" class="box box-info bg-color" style="height:auto">
                                <div class="box-header">
                                    <h4 class="box-title" style="color: blue">මුලික ශිර්ෂ ලේජර සම්බන්ධතා</h4>
                                </div>
                                <div class="box-body">
                                    <form  class="form-horizontal" method="post" action="../SaveACTServlet?act=1" onsubmit="validate(this, '1');
                                            return false;">
                                        <div class="row">

                                            <div class="col-md-12">
                                                <div class="form-group" style="margin-bottom: 0px">
                                                    <label class="control-label col-sm-3 input-sm ">මුලික ශීර්ෂයන් :</label>
                                                    <div class="col-md-9">



                                                        <select class="form-control " id="act1" onchange="sendReq(1)" name="act1">   
                                                            <option value="0">-Select-</option>
                                                            <%
                                                                for (ActChartOfAcctL1 a1 : acctL1s) {
                                                            %>
                                                            <option class="convertSinhalaAmali12px" value="<%=a1.getNAcctLevelID1()%>"><%=a1.getCCAAcctNoL1()%>- <%=a1.getCDescriptionSinL1()%></option>
                                                            <%
                                                                }
                                                            %>                                                         
                                                        </select>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="zTreeDemoBackground left">
                                                    <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">
                                                        <table class="table table-bordered table-hover" id="T1">
                                                            <tbody>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>ගිණුම් අංකය</th>

                                                                    <th>උප ගිණුම් විස්තරය</th>
                                                                    <th></th>
                                                                </tr> 
                                                                <%
                                                                    int i1 = 1;
                                                                    if (actt2 != null) {
                                                                        for (ActChartOfAcctL2 a2 : actt2) {

                                                                %>
                                                                <tr >
                                                                    <td><%=a2.getNAcctLevelID2()%></td>
                                                                    <td ><%=a2.getCCAAcctNoL2()%></td>

                                                                    <td class="convertSinhalaAmali "><%=a2.getCDescriptionSinL2()%></td>
                                                                    <td class="hidden"><%=a2.getCDescriptionUniL2()%></td>
                                                                    <td class="hidden"><%=a2.getNNoteNoL2()%></td>
                                                                    <td class="hidden"><%=a2.getNPNLOrderL2()%></td>

                                                                    <td class="hidden"><%=a2.getNTBLORderL2()%></td>



                                                                    <td><button onclick="selectRow(<%=i1%>, 'T1')" class="btn btn-default btn-sm btn-block" type="button">Select</button></td>
                                                                </tr>
                                                                <%i1++;
                                                                        }
                                                                    }
                                                                    request.getSession().removeAttribute("actt2");
                                                                %>
                                                            </tbody>
                                                        </table>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <br/>
                                                <input type="hidden" name="act1Id" id="act1Id" value="0">
                                                <div class="form-group" style="margin-top: -9px">                                               
                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් අංකය :</label>
                                                    <div class="col-md-4" >
                                                        <input required data="validate" data-type="number" id="act1Accno" name="act1Accno" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                    <label class="control-label col-sm-2 input-sm ">සටහන් අංකය :</label>
                                                    <div class="col-md-3" >
                                                        <input required data="validate" data-type="number" id="nnoteNo" name="nnoteNo" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -9px">

                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් විස්තරය :</label>
                                                    <div class="col-md-9">
                                                        <input onkeyup="" data="validate" data-type="letterSS" required type="text" class=" convertSinhalaAmali form-control input-sm" placeholder="" style="font-size:medium;" name="act1SubAcc" id="act1SubAcc">
                                                    </div>

                                                </div>
                                                <div class="form-group" style="margin-top: -9px">
                                                    <label class="control-label col-sm-3 input-sm  ">ගිණුම් විස්තරය(Eng) :</label>
                                                    <div class="col-md-9">
                                                        <input onkeyup="" data="validate" data-type="letterS"required type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="" style="font-size:small;" name="des1" id="des1">
                                                    </div>
                                                </div>

                                                <div class="form-group" style="margin-top: -9px">

                                                    <label class="control-label col-sm-3 input-sm ">ශේෂ පත්‍රයේ පිලිවෙල :</label>
                                                    <div class="col-md-3" >
                                                        <input required id="ntblOrder" name="ntblOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                    <label class="control-label col-sm-3 input-sm ">ශේෂ පිරික්සුමේ පිලිවෙල :</label>
                                                    <div class="col-md-3" >
                                                        <input required id="nplOrder" name="nplOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div style="margin-top: 12px"class="pull-right">

                                                        <button type="button" class="btn btn-info btn-sm " onclick=" createNewAccountNo(1)">New</button>
                                                        <button type="submit" class="btn btn-success btn-sm">Save</button>
                                                        <button type="button" class="btn btn-primary btn-sm">Print</button>
                                                        <button type="reset" class="btn btn-warning btn-sm ">Reset</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="two" class="col-md-7 bg-searchheight" st>
                            <div class="box box-info bg-color" style="height: auto">
                                <div class="box-header">
                                    <h4 class="box-title" style="color: blue">උප ශිර්ෂ ලේජර සම්බන්ධතා</h4>
                                </div>
                                <div class="box-body">
                                    <form class="form-horizontal" method="post" action="../SaveACTServlet?act=2" onsubmit="validate(this, '2');
                                            return false;">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-3 input-sm ">මුලික ශීර්ෂයන් :</label>
                                                    <div class="col-md-9">
                                                        <select class="form-control " id="act1_2" onchange="sendReq2(1)" name="act1_2">
                                                            <option value="0">-Select-</option>
                                                            <%
                                                                for (ActChartOfAcctL1 a1 : acctL1s) {
                                                            %>
                                                            <option class="convertSinhalaAmali12px" value="<%=a1.getNAcctLevelID1()%>"><%=a1.getCCAAcctNoL1()%>-0000 <%=a1.getCDescriptionSinL1()%></option>
                                                            <%
                                                                }
                                                            %> 
                                                        </select>

                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -9px;margin-bottom: 0px">
                                                    <label class="control-label col-sm-3 input-sm ">උප ශීර්ෂයන් :</label>
                                                    <div class="col-md-9">
                                                        <select class="form-control " id="act2" onchange="sendReq(2)" name="act2">
                                                            <option value="0">-Select-</option>
                                                            <%
                                                                for (ActChartOfAcctL2 a2 : actt2) {
                                                            %>
                                                            <option class="convertSinhalaAmali12px" value="<%=a2.getNAcctLevelID2()%>"><%=a2.getCCAAcctNoL2()%>- <%=a2.getCDescriptionSinL2()%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="zTreeDemoBackground left">
                                                    <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">

                                                        <table class="table table-bordered" id="T2">
                                                            <tbody>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>ගිණුම් අංකය</th>

                                                                    <th>උප ගිණුම් විස්තරය</th>
                                                                    <th></th>
                                                                </tr>
                                                                <%
                                                                    int i3 = 1;
                                                                    for (ActChartOfAcctL3 a3 : actt3) {
                                                                %>
                                                                <tr>
                                                                    <td><%=a3.getNAcctLevelID3()%></td>
                                                                    <td class=""><%=a3.getCCAAcctNoL3()%></td>

                                                                    <td class=" convertSinhalaAmali "><%=a3.getCDescriptionSinL3()%></td>
                                                                    <td class="hidden"><%=a3.getCDescriptionUniL3()%></td>
                                                                    <td class="hidden"><%=a3.getNNoteNoL3()%></td>
                                                                    <td class="hidden"><%=a3.getNPNLOrderL3()%></td>

                                                                    <td class="hidden"><%=a3.getNTBLORderL3()%></td>
                                                                    <td><button  onclick="selectRow(<%=i3%>, 'T2')" class="btn btn-default btn-sm btn-block" type="button">Select</button></td>

                                                                </tr>
                                                                <%i3++;
                                                                    }
                                                                    request.getSession().removeAttribute("actt3");
                                                                %>
                                                            </tbody>
                                                        </table>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <input type="hidden" name="act2Id" id="act2Id" value="0">
                                                <br>
                                                <div class="form-group" style="margin-top: -9px">                                               
                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් අංකය :</label>
                                                    <div class="col-md-4" >
                                                        <input required data="validate" data-type="number" id="act2Acc" name="act2Acc" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                    <label class="control-label col-sm-2 input-sm ">සටහන් අංකය :</label>
                                                    <div class="col-md-3" >
                                                        <input required data="validate" data-type="number" id="n2noteNo" name="n2noteNo" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -9px">

                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් විස්තරය :</label>
                                                    <div class="col-md-9">
                                                        <input onkeyup="" data="validate" data-type="letterSS" required type="text" class=" convertSinhalaAmali form-control input-sm" placeholder="" style="font-size:medium;" name="act2SubAcc" id="act2SubAcc">
                                                    </div>

                                                </div>
                                                <div class="form-group" style="margin-top: -9px">
                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් විස්තරය(Eng) :</label>
                                                    <div class="col-md-9">
                                                        <input onkeyup="" required data="validate" data-type="letterS"type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="" style="font-size:small;" name="des2" id="des2">
                                                    </div>
                                                </div>

                                                <div class="form-group" style="margin-top: -9px">

                                                    <label class="control-label col-sm-3 input-sm ">ශේෂ පත්‍රයේ පිලිවෙල :</label>
                                                    <div class="col-md-3" >
                                                        <input required id="n2tblOrder" name="n2tblOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                    <label class="control-label col-sm-3 input-sm ">ශේෂ පිරික්සුමේ පිලිවෙල :</label>
                                                    <div class="col-md-3" >
                                                        <input required id="n2plOrder" name="n2plOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="pull-right">
                                                    <button type="button" class="btn btn-info btn-sm " onclick="getT1('T2', 'act2Acc', 'act2SubAcc', '1000', 'des2')">New</button>
                                                    <button type="submit" class="btn btn-success btn-sm">Save</button>
                                                    <button type="button" class="btn btn-primary btn-sm">Print</button>
                                                    <button type="reset" class="btn btn-warning btn-sm">Reset</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="three" class="col-md-7 bg-searchheight">
                            <div class="box box-info bg-color" style="height: auto">
                                <div class="box-header">
                                    <h4 class="box-title" style="color: blue">ශිර්ෂ ලේජර සම්බන්ධතා</h4>
                                </div>
                                <div class="box-body">
                                    <form class="form-horizontal" method="post" action="../SaveACTServlet?act=3" onsubmit="validate(this, '3');
                                            return false;">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-3 input-sm ">මුලික ශීර්ෂයන් :</label>
                                                    <div class="col-md-9">
                                                        <select class="form-control " id="act1_3" onchange="sendReq2(2)">
                                                            <option value="0">-Select-</option>
                                                            <%
                                                                for (ActChartOfAcctL1 a1 : acctL1s) {
                                                            %>
                                                            <option class="convertSinhalaAmali12px" value="<%=a1.getNAcctLevelID1()%>"><%=a1.getCCAAcctNoL1()%>-0000 <%=a1.getCDescriptionSinL1()%></option>
                                                            <%
                                                                }
                                                            %> 
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -9px;">
                                                    <label class="control-label col-sm-3 input-sm ">උප ශීර්ෂයන් :</label>
                                                    <div class="col-md-9">
                                                        <select class="form-control " id="act2_1" onchange="sendReq2(3)">
                                                            <option value="0">-Select-</option>
                                                            <%
                                                                for (ActChartOfAcctL2 a2 : actt2) {
                                                            %>
                                                            <option class="convertSinhalaAmali convertSinhalaAmali12px" value="<%=a2.getNAcctLevelID2()%>"><%=a2.getCCAAcctNoL2()%>- <%=a2.getCDescriptionSinL2()%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -9px;">
                                                    <label class="control-label col-sm-3 input-sm ">ශීර්ෂයන් :</label>
                                                    <div class="col-md-9">
                                                        <select class="form-control " id="act3" onchange="sendReq(3)" name="act3">
                                                            <option value="0">-Select-</option>
                                                            <%
                                                                for (ActChartOfAcctL3 a3 : actt3) {
                                                            %>
                                                            <option class="convertSinhalaAmali convertSinhalaAmali12px" value="<%=a3.getNAcctLevelID3()%>"><%=a3.getCCAAcctNoL3()%>- <%=a3.getCDescriptionSinL3()%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="zTreeDemoBackground left">
                                                    <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">
                                                        <table class="table table-bordered" id="T3">
                                                            <tbody>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>ගිණුම් අංකය</th>

                                                                    <th>උප ගිණුම් විස්තරය</th>
                                                                    <th></th>
                                                                </tr>
                                                                <%
                                                                    int i4 = 1;
                                                                    for (ActChartOfAcctL4 a4 : actt4) {
                                                                %>
                                                                <tr id="<%=a4.getNAcctLevelID4()%>">
                                                                    <td><%=a4.getNAcctLevelID4()%></td>
                                                                    <td><%=a4.getCCAAcctNoL4()%></td>

                                                                    <td class="convertSinhalaAmali"><%=a4.getCDescriptionSinL4()%></td>
                                                                    <td class="hidden"><%=a4.getCDescriptionUniL4()%></td>
                                                                    <td class="hidden"><%=a4.getNNoteNoL4()%></td>
                                                                    <td class="hidden"><%=a4.getNPNLOrderL4()%></td>

                                                                    <td class="hidden"><%=a4.getNTBLORderL4()%></td>
                                                                    <td><button onclick="selectRow(<%=i4%>, 'T3')" class="btn btn-default btn-sm btn-block" type="button">Select</button></td>
                                                                </tr>  
                                                                <%i4++;
                                                                    }
                                                                    request.getSession().removeAttribute("actt4");
                                                                %>
                                                            </tbody>
                                                        </table>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <input type="hidden" name="act3Id" id="act3Id" value="0">
                                                <br/>
                                                <div class="form-group" style="margin-top: -9px">                                               
                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් අංකය :</label>
                                                    <div class="col-md-4" >
                                                        <input required data="validate" data-type="number" id="act3Acc" name="act3Acc" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                    <label class="control-label col-sm-2 input-sm ">සටහන් අංකය :</label>
                                                    <div class="col-md-3" >
                                                        <input required data="validate" data-type="number" id="n3noteNo" name="n3noteNo" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -9px">

                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් විස්තරය :</label>
                                                    <div class="col-md-9">
                                                        <input onkeyup="" required data="validate" data-type="letterSS" type="text" class=" convertSinhalaAmali form-control input-sm" placeholder="" style="font-size:medium;" name="act3SubAcc" id="act3SubAcc">
                                                    </div>

                                                </div>
                                                <div class="form-group" style="margin-top: -9px">
                                                    <label class="control-label col-sm-3 input-sm ">ගිණුම් විස්තරය(Eng) :</label>
                                                    <div class="col-md-9">
                                                        <input onkeyup="" required data="validate" data-type="letterS" type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="" style="font-size:small;" name="des3" id="des3">
                                                    </div>
                                                </div>

                                                <div class="form-group" style="margin-top: -9px">

                                                    <label class="control-label col-sm-3 input-sm ">ශේෂ පත්‍රයේ පිලිවෙල :</label>
                                                    <div class="col-md-3" >
                                                        <input required id="n3tblOrder" name="n3tblOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                    <label class="control-label col-sm-3 input-sm ">ශේෂ පිරික්සුමේ පිලිවෙල :</label>
                                                    <div class="col-md-3" >
                                                        <input required id="n3plOrder" name="n3plOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="pull-right">
                                                        <button type="button" class="btn btn-info btn-sm " onclick="getT1('T3', 'act3Acc', 'act3SubAcc', '1', 'des3')">New</button>
                                                        <button type="submit" class="btn btn-success btn-sm" >Save</button>
                                                        <button type="reset" class="btn btn-warning btn-sm ">Change</button>
                                                    </div>
                                                </div>
                                            </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div id="four" class="col-md-12 bg-searchheight">
                        <div class="box box-info bg-color" style="height: 530px">
                            <div class="box-header">
                                <div class="row" style="padding-left: 30px;padding-top: 10px;">
                                    <a href="#"><i class="fa fa-reply" aria-hidden="true"  onclick="showBack('#four')"></i></a>
                                    <h4 id="back" class="box-title" style="color: blue">ගිණුම් ශිර්ෂයන්ගේ විස්තර</h4>
                                </div>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table table-bordered" style="margin-bottom: -9px">
                                            <tbody>
                                                <tr style="background-color: #00c0ef">
                                                    <th>ගිණුම් අංකය</th>
                                                    <th>උප ගිණුම් අංකය</th>
                                                    <th>උප ගිණුම් විස්තරය</th>
                                                    <th>උප ගිණුම් විස්තරය</th>
                                                    <th>උප ගිණුම් විස්තරය</th>
                                                    <th>උප ගිණුම් විස්තරය</th>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" data="validate" data-type="number" class="form-control input-sm" placeholder="" style="font-size:large;"></td>
                                                    <td><input type="text" data="validate" data-type="number" class="form-control input-sm" placeholder="" style="font-size:large;"></td>
                                                    <td><input type="text" data="validate" data-type="letterS" class="form-control input-sm" placeholder="" style="font-size:large;"></td>
                                                    <td><input type="text" data="validate" data-type="letterS" data="validate" data-type="letterS" class="form-control input-sm" placeholder="" style="font-size:large;"></td>
                                                    <td><input type="text" data="validate" data-type="letterS" class="form-control input-sm" placeholder="" style="font-size:large;"></td>
                                                    <td><input type="text" data="validate" data-type="letterS" class="form-control input-sm" placeholder="" style="font-size:large;"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <div class="zTreeDemoBackground left">
                                            <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">
                                                <table class="table table-bordered">
                                                    <tbody>
                                                        <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>

                                                    </tbody>
                                                </table>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <form class="form-horizontal">
                                            <br/>
                                            <div class="form-group" style="margin-top: -9px">
                                                <div class="col-md-4">

                                                </div>
                                                <div class="col-md-3">
                                                    <input type="text" class="form-control input-sm" placeholder="" style="font-size:large;">
                                                </div>
                                                <div class="col-md-3">
                                                    <input type="text" class="form-control input-sm" placeholder="" style="font-size:large;">
                                                </div>
                                                <div class="col-md-2">

                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="col-md-12">                                            
                                        <div class="pull-right">
                                            <button type="submit" class="btn btn-success btn-sm" onclick="">Save</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="five" class="col-md-12 bg-searchheight">
                        <div class="box box-info bg-color" style="height: 530px">
                            <div class="box-header">
                                <div class="row" style="padding-left: 30px;padding-top: 10px;">
                                    <a href="#"><i class="fa fa-reply" aria-hidden="true"  onclick="showBack('#five')"></i></a>
                                    <h4 class="box-title" style="color: blue">ගිණුම් ශිර්ෂයන්ගේ විස්තර</h4>
                                </div>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="form-horizontal">
                                            <div class="form-group">
                                                <label class="control-label col-sm-3 input-sm ">මුලික ශීර්ෂයන් :</label>
                                                <div class="col-md-9">
                                                    <select class="form-control">
                                                        <option>option 1</option>
                                                        <option>option 2</option>
                                                        <option>option 3</option>
                                                        <option>option 4</option>
                                                        <option>option 5</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-top: -9px;">
                                                <label class="control-label col-sm-3 input-sm ">උප ශීර්ෂයන් :</label>
                                                <div class="col-md-9">
                                                    <select class="form-control">
                                                        <option>option 1</option>
                                                        <option>option 2</option>
                                                        <option>option 3</option>
                                                        <option>option 4</option>
                                                        <option>option 5</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-top: -9px;">
                                                <label class="control-label col-sm-3 input-sm ">ශීර්ෂයන් :</label>
                                                <div class="col-md-9">
                                                    <select class="form-control">
                                                        <option>option 1</option>
                                                        <option>option 2</option>
                                                        <option>option 3</option>
                                                        <option>option 4</option>
                                                        <option>option 5</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-top: -9px;margin-bottom: -9px">
                                                <div class="col-md-3" style="padding-right:0px">
                                                    <input type="text" class="form-control input-sm" placeholder="" style="font-size:large;">
                                                </div>
                                                <div class="col-md-4" style="padding-right:0px;padding-left:0px">
                                                    <input type="text" class="form-control input-sm" placeholder="" style="font-size:large;">
                                                </div>
                                                <div class="col-md-5" style="padding-left:0px">
                                                    <input type="text" class="form-control input-sm" placeholder="" style="font-size:large;">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="col-lg-5">

                                            </div>
                                            <div class="col-lg-2">

                                            </div>
                                            <div class="col-lg-5">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <div style="background-color: " id="six" class="col-md-12 bg-searchheight">
                        <div class="box box-info bg-color" style="height: 530px">
                            <div class="box-header">
                                <div class="row" style="padding-left: 30px;padding-top: 10px;">
                                    <a href="#"><i class="fa fa-reply" aria-hidden="true"  onclick="showBack('#six')"></i></a>
                                </div> 
                                <div class="row">
                                    <div class="col-md-12">
                                        FFFFFFFFFFFFFFFFFFF
                                    </div>  
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="seven" class="col-md-7 bg-searchheight">
                        <div class="box box-info bg-color" style="height: auto">
                            <div class="box-header">
                                <h4 class="box-title" style="color: blue">ශිර්ෂ ලේජර සම්බන්ධතා2</h4>
                            </div>
                            <div class="box-body">
                                <form class="form-horizontal" method="post" action="../SaveACTServlet?act=4" >
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="control-label col-sm-3 input-sm ">මුලික ශීර්ෂයන් :</label>
                                                <div class="col-md-9">
                                                    <select class="form-control " id="act1_4" onchange="sendReq2(4)">
                                                        <option value="0">-Select-</option>
                                                        <%
                                                            for (ActChartOfAcctL1 a1 : acctL1s) {
                                                        %>
                                                        <option class="convertSinhalaAmali12px" value="<%=a1.getNAcctLevelID1()%>"><%=a1.getCCAAcctNoL1()%>- <%=a1.getCDescriptionSinL1()%></option>
                                                        <%
                                                            }
                                                        %> 
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-top: -9px;">
                                                <label class="control-label col-sm-3 input-sm ">උප ශීර්ෂයන් :</label>
                                                <div class="col-md-9">
                                                    <select class="form-control " id="act2_2" onchange="sendReq2(5)">
                                                        <option value="0">-Select-</option>
                                                        <%
                                                            for (ActChartOfAcctL2 a2 : actt2) {
                                                        %>
                                                        <option class="convertSinhalaAmali convertSinhalaAmali12px" value="<%=a2.getNAcctLevelID2()%>"><%=a2.getCCAAcctNoL2()%>- <%=a2.getCDescriptionSinL2()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-top: -9px;">
                                                <label class="control-label col-sm-3 input-sm ">ශීර්ෂයන් :</label>
                                                <div class="col-md-9">
                                                    <select class="form-control" id="act4" onchange="sendReq(4)" name="act4">
                                                        <option value="0">-Select-</option>
                                                        <%
                                                            for (ActChartOfAcctL3 a3 : actt3) {
                                                        %>
                                                        <option class="convertSinhalaAmali convertSinhalaAmali12px" value="<%=a3.getNAcctLevelID3()%>"><%=a3.getCCAAcctNoL3()%>- <%=a3.getCDescriptionSinL3()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-top: -9px;">
                                                <label class="control-label col-sm-3 input-sm ">ශීර්ෂයන් :</label>
                                                <div class="col-md-9">
                                                    <select class="form-control " id="act5" onchange="sendReq(5)" name="act5">
                                                        <option value="0" class="">-Select-</option>
                                                        <%
                                                            for (ActChartOfAcctL4 a4 : actt4) {
                                                        %>
                                                        <option class="convertSinhalaAmali12px" value="<%=a4.getNAcctLevelID4()%>"><%=a4.getCCAAcctNoL4()%>- <%=a4.getCDescriptionSinL4()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>        
                                        </div>
                                        <div class="col-md-12">
                                            <div class="zTreeDemoBackground left">
                                                <ul id="treeDemo" class="ztree" style="width: auto;height:300px;">
                                                    <table class="table table-bordered" id="T4">
                                                        <tbody>
                                                            <tr>
                                                                <th>ID</th>
                                                                <th>ගිණුම් අංකය</th>

                                                                <th>උප ගිණුම් විස්තරය</th>
                                                                <th></th>
                                                            </tr>
                                                            <%
                                                                int i5 = 1;

                                                                for (ActChartOfAcctL5 a5 : actt5) {

                                                            %>
                                                            <tr id="<%=a5.getNAcctLevelID5()%>">
                                                                <td><%=a5.getNAcctLevelID5()%></td>
                                                                <td><%=a5.getCCAAcctNoL5()%></td>

                                                                <td class="convertSinhalaAmali"><%=a5.getCDescriptionSinL5()%></td>
                                                                <td class="hidden"><%=a5.getCDescriptionUniL5()%></td>
                                                                <td class="hidden"><%=a5.getNNoteNoL5()%></td>
                                                                <td class="hidden"><%=a5.getNPNLOrderL5()%></td>

                                                                <td class="hidden"><%=a5.getNTBLORderL5()%></td>
                                                                <td><button onclick="selectRow(<%=i5%>, 'T4')" class="btn btn-default btn-sm btn-block" type="button">Select</button></td>
                                                            </tr>  
                                                            <%i5++;
                                                                }
                                                                request.getSession().removeAttribute("actt5");
                                                            %>
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <input type="hidden" name="act4Id" id="act4Id" value="0">
                                            <br/>
                                            <div class="form-group" style="margin-top: -9px">                                               
                                                <label class="control-label col-sm-3 input-sm ">ගිණුම් අංකය :</label>
                                                <div class="col-md-4" >
                                                    <input required data="validate" data-type="number" id="act4Acc" name="act4Acc" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                </div>
                                                <label class="control-label col-sm-2 input-sm ">සටහන් අංකය :</label>
                                                <div class="col-md-3" >
                                                    <input required data="validate" data-type="number" id="n4noteNo" name="n4noteNo" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-top: -9px">

                                                <label class="control-label col-sm-3 input-sm ">ගිණුම් විස්තරය :</label>
                                                <div class="col-md-9">
                                                    <input onkeyup="" data="validate" data-type="letterSS" required type="text" class=" convertSinhalaAmali form-control input-sm" placeholder="" style="font-size:medium;" name="act4SubAcc" id="act4SubAcc">
                                                </div>

                                            </div>
                                            <div class="form-group" style="margin-top: -9px">
                                                <label class="control-label col-sm-3 input-sm ">ගිණුම් විස්තරය(Eng) :</label>
                                                <div class="col-md-9">
                                                    <input onkeyup="" required data="validate" data-type="letterS" type="text" class="form-control input-sm convertSinhalaIskolaPotha" placeholder="" style="font-size:small;" name="des4" id="des4">
                                                </div>
                                            </div>

                                            <div class="form-group" style="margin-top: -9px">

                                                <label class="control-label col-sm-3 input-sm ">ශේෂ පත්‍රයේ පිලිවෙල :</label>
                                                <div class="col-md-3" >
                                                    <input required id="n4tblOrder" name="n4tblOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                </div>
                                                <label class="control-label col-sm-3 input-sm ">ශේෂ පිරික්සුමේ පිලිවෙල :</label>
                                                <div class="col-md-3" >
                                                    <input required id="n4plOrder" name="n4plOrder" type="text" class="form-control input-sm" placeholder="" style="font-size:small;">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="pull-right">
                                                <button type="button" class="btn btn-info btn-sm " onclick="getT1('T4', 'act4Acc', 'act4SubAcc', '1', 'des3')">New</button>
                                                <button type="submit" class="btn btn-success btn-sm" >Save</button>
                                                <button type="reset" class="btn btn-warning btn-sm ">Reset</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>                                                       






                    </div>
                </section>
            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

        <script src="../js/jquery.ztree.core-3.5.js" type="text/javascript"></script>

        <script type="text/javascript">
     <!--
    
                                                    //    -------------------------------------------------------------------
                                                    var setting = {
                                                        view: {
                                                            fontCss: getFont,
                                                            nameIsHTML: true
                                                    }
                                                };
                                                var zNodes = [
                                                {name: "ගිනුම් වර්ගීකරනය", font: {'font-weight': 'bold'}, open: true,
                                                        children: [
            <%                int act1 = 1, act2 = 1, act3 = 1, act4 = 1;
                int i2 = 0, k2 = 0, l2 = 0, m2 = 0;
                if (acctL1s != null && acctL1s.size() > 0) {
                    for (int i = 0; i < acctL1s.size(); i++) {
                        ActChartOfAcctL1 a1 = acctL1s.get(i);

            %>
                                                            {name: "<%=a1.getCCAAcctNoL1()%>- <%=a1.getCDescriptionSinL1()%>", font: {'color': 'blue'},
                                                                                children: [
            <%
                if (acctL2s != null && acctL2s.size() > 0) {
                    for (int j = 0; j < acctL2s.size(); j++) {
                        ActChartOfAcctL2 a2 = acctL2s.get(j);
                        if (i == i2 && a2.getNAcctLevelID1() == act1) {
            %>
                                                                                {name: "<%=a2.getCCAAcctNoL2()%>- <%=a2.getCDescriptionUniL2()%>", font: {'color': '#f39c12'},
                                                                                                            children: [
            <%
                if (acctL3s != null && acctL3s.size() > 0) {
                    for (int k = 0; k < acctL3s.size(); k++) {
                        ActChartOfAcctL3 a3 = acctL3s.get(k);
                        if (j == k2 && a3.getNAcctLevelID2() == act2) {
            %>
                                                                                                            {name: "<%=a3.getCCAAcctNoL3()%>- <%=a3.getCDescriptionUniL3()%>", font: {'color': 'brown'},
                                                                                                                                                children: [
            <%
                if (acctL4s != null && acctL4s.size() > 0) {
                    for (int l = 0; l < acctL4s.size(); l++) {
                        ActChartOfAcctL4 a4 = acctL4s.get(l);
                        if (k == l2 && a4.getNAcctLevelID3() == act3) {
            %>
                                                                                                                                                {name: "<%=a4.getCCAAcctNoL4()%>- <%=a4.getCDescriptionUniL4()%>", font: {'color': 'green'},
                                                                                                                                                                                            children: [
            <%
                for (int m = 0; m < acctL5s.size(); m++) {
                    ActChartOfAcctL5 a5 = acctL5s.get(m);
                    if (l == m2 && a5.getNAcctLevelID4() == act4) {
            %>
                                                                                                                                                                                            {
                                                                                                                                                                                            name: "<%=a5.getCCAAcctNoL5()%>- <%=a5.getCDescriptionUniL5()%>"
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        ,
            <%   } %>


            <%}%>

                                                                                                                                                                                                                                        ]}
                                                                                                                                                                                                                                ,
            <%

                }%>
            <%}
                }%>
                                                                                                                                                                                                                                ]}
                                                                                                                                                                                                                        ,
                                                                                                                                                                                                                        //    <%
                                                                                                                                                                                                                            }%>    
                                                                                                                                                                                                                        //     <%}
                                                                                                                                                                                                                            }

                                                                                                                                                                                                                            act4++;
                                                                                                                                                                                                                            m2++;
                                                                                                                                                                                                                            act3++;
                                                                                                                                                                                                                            act2++;
                                                                                                                                                                                                                            l2++;

            %>    ........................
                                                                                                                                                                                                                        ]}
                                                                                                                                                                                                                ,
            <%k2++;
                }%>
            <% }
                }%>

                                                                                                                                                                                                                ]}
                                                                                                                                                                                                        ,
            <%i2++;
                        act1++;
                    }
                }%>
                                                                                                                                                                                                        ]}
                                                                                                                                                                                                ,
                                                                                                                                                                                                ]
                                                                                                                                                                                                ;
                                                                                                                                                                                                function getFont(treeId, node) {
                                                                                                                                                                                                    return node.font ? node.font : {};
                                                                                                                                                                                                }

                                                                                                                                                                                                $(document).ready(function () {
                                                                                                                                                                                                    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                                                                                                                                                                                                });
//            ----------------------------------------------------------

                                                                                                                                                                                                $(document).ready(function () {
                                                                                                                                                                                                    $("#two").hide();
                                                                                                                                                                                                    $("#three").hide();
                                                                                                                                                                                                    $("#four").hide();
                                                                                                                                                                                                    $("#five").hide();
                                                                                                                                                                                                    $("#six").hide();
                                                                                                                                                                                                    $("#seven").hide();
                                                                                                                                                                                                });
                                                                                                                                                                                                function showOne() {
                                                                                                                                                                                                    $(document).ready(function () {
                                                                                                                                                                                                        ;
                                                                                                                                                                                                        $("#two").hide();
                                                                                                                                                                                                        $("#three").hide();
                                                                                                                                                                                                        $("#four").hide();
                                                                                                                                                                                                        $("#five").hide();
                                                                                                                                                                                                        $("#six").hide();
                                                                                                                                                                                                        $("#seven").hide();
                                                                                                                                                                                                        $("#one").show();

                                                                                                                                                                                                        setRightDivSize(1);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }
                                                                                                                                                                                                function showTwo() {

                                                                                                                                                                                                    $(document).ready(function () {

                                                                                                                                                                                                        $("#one").hide();
                                                                                                                                                                                                        $("#three").hide();
                                                                                                                                                                                                        $("#four").hide();
                                                                                                                                                                                                        $("#five").hide();
                                                                                                                                                                                                        $("#six").hide();
                                                                                                                                                                                                        $("#seven").hide();
                                                                                                                                                                                                        $("#two").show();
                                                                                                                                                                                                        setRightDivSize(2);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }
                                                                                                                                                                                                function showThree() {
                                                                                                                                                                                                    $(document).ready(function () {
                                                                                                                                                                                                        ;
                                                                                                                                                                                                        $("#one").hide();
                                                                                                                                                                                                        $("#two").hide();
                                                                                                                                                                                                        $("#four").hide();
                                                                                                                                                                                                        $("#five").hide();
                                                                                                                                                                                                        $("#six").hide();
                                                                                                                                                                                                        $("#seven").hide();
                                                                                                                                                                                                        $("#three").show();

                                                                                                                                                                                                        setRightDivSize(3);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }
                                                                                                                                                                                                function showFour() {
                                                                                                                                                                                                    $(document).ready(function () {
                                                                                                                                                                                                        ;
                                                                                                                                                                                                        $("#one").hide();
                                                                                                                                                                                                        $("#two").hide();
                                                                                                                                                                                                        $("#three").hide();
                                                                                                                                                                                                        $("#five").hide();
                                                                                                                                                                                                        $("#six").hide();
                                                                                                                                                                                                        $("#seven").hide();
                                                                                                                                                                                                        $("#main").hide();
                                                                                                                                                                                                        $("#four").show();
                                                                                                                                                                                                        setRightDivSize(4);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }
                                                                                                                                                                                                function showFive() {
                                                                                                                                                                                                    $(document).ready(function () {
                                                                                                                                                                                                        ;
                                                                                                                                                                                                        $("#one").hide();
                                                                                                                                                                                                        $("#two").hide();
                                                                                                                                                                                                        $("#three").hide();
                                                                                                                                                                                                        $("#four").hide();
                                                                                                                                                                                                        $("#six").hide();
                                                                                                                                                                                                        $("#seven").hide();
                                                                                                                                                                                                        $("#main").hide();
                                                                                                                                                                                                        $("#five").show();
                                                                                                                                                                                                        setRightDivSize(5);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }
                                                                                                                                                                                                function showSix() {
                                                                                                                                                                                                    $(document).ready(function () {
                                                                                                                                                                                                        ;
                                                                                                                                                                                                        $("#one").hide();
                                                                                                                                                                                                        $("#two").hide();
                                                                                                                                                                                                        $("#three").hide();
                                                                                                                                                                                                        $("#four").hide();
                                                                                                                                                                                                        $("#five").hide();
                                                                                                                                                                                                        $("#seven").hide();
                                                                                                                                                                                                        $("#main").hide();
                                                                                                                                                                                                        $("#six").show();
                                                                                                                                                                                                        setRightDivSize(6);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }
                                                                                                                                                                                                function showSeven() {
                                                                                                                                                                                                    $(document).ready(function () {
                                                                                                                                                                                                        ;
                                                                                                                                                                                                        $("#one").hide();
                                                                                                                                                                                                        $("#two").hide();
                                                                                                                                                                                                        $("#three").hide();
                                                                                                                                                                                                        $("#four").hide();
                                                                                                                                                                                                        $("#five").hide();
                                                                                                                                                                                                        $("#six").hide();
                                                                                                                                                                                                        $("#seven").show();

                                                                                                                                                                                                        setRightDivSize(7);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }
                                                                                                                                                                                                function showBack(id) {
                                                                                                                                                                                                    $(document).ready(function () {

                                                                                                                                                                                                        $(id).hide();
                                                                                                                                                                                                        $("#main").show();
                                                                                                                                                                                                        $("#one").show();
                                                                                                                                                                                                        setRightDivSize(1);
                                                                                                                                                                                                    });
                                                                                                                                                                                                }

            <%
                String c1 = "0", c2 = "0", c3 = "0", c4 = "0";
                if (request.getParameter("mid") != null) {
                    if ("1".equals(request.getParameter("mid").toString())) {
                        c1 = request.getParameter("c1");

                        if (Integer.parseInt(request.getParameter("c")) == 0) {
            %>


                                                                                                                                                                                                showOne();
            <%
            } else if (Integer.parseInt(request.getParameter("c")) == 1) {
            %>
                                                                                                                                                                                                showTwo();
            <%
            } else if (Integer.parseInt(request.getParameter("c")) == 2) {
            %>
                                                                                                                                                                                                showThree();
            <%
            } else if (Integer.parseInt(request.getParameter("c")) == 3) {
            %>
                                                                                                                                                                                                showSeven();
            <%
                    }

                }
                if ("2".equals(request.getParameter("mid").toString())) {

                    c1 = request.getParameter("c1");
                    c2 = request.getParameter("c2");
                    if (Integer.parseInt(request.getParameter("c")) == 0) {
            %>

                                                                                                                                                                                                showTwo();
            <%
            } else if (Integer.parseInt(request.getParameter("c")) == 2) {
            %>
                                                                                                                                                                                                showThree();
            <%
            } else if (Integer.parseInt(request.getParameter("c")) == 4) {
            %>
                                                                                                                                                                                                showSeven();
            <%
                    }
                }
                if ("3".equals(request.getParameter("mid").toString())) {
                    c1 = request.getParameter("c1");
                    c2 = request.getParameter("c2");
                    c3 = request.getParameter("c3");
                    if (Integer.parseInt(request.getParameter("c")) == 1) {
            %>
                                                                                                                                                                                                showSeven();
            <% } else {%>
                                                                                                                                                                                                showThree();
            <%}%>
            <%
                }
                if ("4".equals(request.getParameter("mid").toString())) {
                    c1 = request.getParameter("c1");
                    c2 = request.getParameter("c2");
                    c3 = request.getParameter("c3");
                    c4 = request.getParameter("c4");
            %>
                                                                                                                                                                                                showSeven();
            <%
                    }

                }
            %>//-->





        </script>
    <input type="hidden" value="<%=c1%>" id="c1"> 
    <input type="hidden" value="<%=c2%>" id="c2"> 
    <input type="hidden" value="<%=c3%>" id="c3">  
    <input type="hidden" value="<%=c4%>" id="c4"> 
</body>
<script type="text/javascript">

                                                                                                                                                                                                var c1 = document.getElementById("c1").value;
                                                                                                                                                                                                var c2 = document.getElementById("c2").value;
                                                                                                                                                                                                var c3 = document.getElementById("c3").value;
                                                                                                                                                                                                var c4 = document.getElementById("c4").value;
                                                                                                                                                                                                $(document).ready(function () {
                                                                                                                                                                                                    $('#act1').val(c1);
                                                                                                                                                                                                    $('#act1_2').val(c1);
                                                                                                                                                                                                    $('#act1_3').val(c1);
                                                                                                                                                                                                    $('#act1_4').val(c1);
                                                                                                                                                                                                    $('#act2').val(c2);
                                                                                                                                                                                                    $('#act2_1').val(c2);
                                                                                                                                                                                                    $('#act2_2').val(c2);
                                                                                                                                                                                                    $('#act3').val(c3);
                                                                                                                                                                                                    $('#act4').val(c3);
                                                                                                                                                                                                    $('#act5').val(c4);
                                                                                                                                                                                                });
    function sendReq(mid) {
                                                                                                                                                                                                    var c1, c2, c3, c4;
                                                                                                                                                                                                    if (mid == '1') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + mid + "&c1=" + c1 + "&c=0"
    } else if (mid == '2') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_2').value;
                                                                                                                                                                                                        var c2 = document.getElementById('act2').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + mid + "&c1=" + c1 + "&c2=" + c2 + "&c=0"
    } else if (mid == '3') {

                                                                                                                                                                                                        var c1 = document.getElementById('act1_3').value;
                                                                                                                                                                                                        var c2 = document.getElementById('act2_1').value;
                                                                                                                                                                                                        var c3 = document.getElementById('act3').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + mid + "&c1=" + c1 + "&c2=" + c2 + "&c3=" + c3 + "&c=0"
    } else if (mid == '4') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_4').value;
                                                                                                                                                                                                        var c2 = document.getElementById('act2_2').value;
                                                                                                                                                                                                        var c3 = document.getElementById('act4').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=3&c1=" + c1 + "&c2=" + c2 + "&c3=" + c3 + "&c=1"
    } else if (mid == '5') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_4').value;
                                                                                                                                                                                                        var c2 = document.getElementById('act2_2').value;
                                                                                                                                                                                                        var c3 = document.getElementById('act4').value;
                                                                                                                                                                                                        var c4 = document.getElementById('act5').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=4&c1=" + c1 + "&c2=" + c2 + "&c3=" + c3 + "&c4=" + c4 + "&c=0"
    }
    }
    function sendReq2(mid) {

                                                                                                                                                                                                    if (mid == '1') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_2').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + mid + "&c1=" + c1 + "&c=1"
    } else if (mid == '2') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_3').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + 1 + "&c1=" + c1 + "&c=2"
    } else if (mid == '3') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_3').value;
                                                                                                                                                                                                        var c2 = document.getElementById('act2_1').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + 2 + "&c2=" + c2 + "&c=2&c1=" + c1
    } else if (mid == '4') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_4').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + 1 + "&c1=" + c1 + "&c=3"
    } else if (mid == '5') {
                                                                                                                                                                                                        var c1 = document.getElementById('act1_4').value;
                                                                                                                                                                                                        var c2 = document.getElementById('act2_2').value;
                                                                                                                                                                                                        window.location = "../CommonLedgerAjaxServlet?mid=" + 2 + "&c2=" + c2 + "&c=4&c1=" + c1
    }
    }
    function getT1(t, acc, subacc, val, des) {
                                                                                                                                                                                                    act1Id = 0;
                                                                                                                                                                                                    act2Id = 0;
                                                                                                                                                                                                    act3Id = 0;
                                                                                                                                                                                                    act4Id = 0;
                                                                                                                                                                                                    act5Id = 0;
                                                                                                                                                                                                    var t = document.getElementById(t);
                                                                                                                                                                                                    var r = t.rows.length;
                                                                                                                                                                                                    var maxSubAcc = 0;
                                                                                                                                                                                                    for (var i = 1; i < r; i++) {
                                                                                                                                                                                                        var text = t.rows.item(i).cells;
                                                                                                                                                                                                        var subAcc = text[2].firstChild.data;
                                                                                                                                                                                                        if (maxSubAcc < subAcc) {
                                                                                                                                                                                                            var mainAcc = text[1].firstChild.data;
                                                                                                                                                                                                            var dec = text[3].firstChild.data;
                                                                                                                                                                                                            var maxSubAcc = subAcc;
    }
    }
    if (r === 1) {
                                                                                                                                                                                                        alert("Please select");
    } else {
                                                                                                                                                                                                        var set = parseInt(maxSubAcc) + parseInt(val);
                                                                                                                                                                                                        document.getElementById(subacc).value = set;
                                                                                                                                                                                                        document.getElementById(acc).value = mainAcc;
                                                                                                                                                                                                        document.getElementById(des).value = "";
    }

    }

    function selectRow(pk, t) {
                                                                                                                                                                                                    var table = document.getElementById(t);
                                                                                                                                                                                                    var row = table.rows.item(pk).cells;
                                                                                                                                                                                                    var acc = row[1].firstChild.data;
                                                                                                                                                                                                    var subAcc = row[2].firstChild.data;
                                                                                                                                                                                                    var des = row[3].firstChild.data;
                                                                                                                                                                                                    var noteNo = row[4].firstChild.data;

                                                                                                                                                                                                    var nplOrder = row[5].firstChild.data;
                                                                                                                                                                                                    var ntblOrder = row[6].firstChild.data;

                                                                                                                                                                                                    if (t === 'T1') {
                                                                                                                                                                                                        act1Id = row[0].firstChild.data;
                                                                                                                                                                                                        document.getElementById('act1Id').value = act1Id;
                                                                                                                                                                                                        document.getElementById('act1Accno').value = acc;
                                                                                                                                                                                                        document.getElementById('act1SubAcc').value = subAcc;
                                                                                                                                                                                                        document.getElementById('des1').value = des;
                                                                                                                                                                                                        document.getElementById('nnoteNo').value = noteNo;
                                                                                                                                                                                                        document.getElementById('nplOrder').value = nplOrder;
                                                                                                                                                                                                        document.getElementById('ntblOrder').value = ntblOrder;



    } else if (t === 'T2') {
                                                                                                                                                                                                        act2Id = row[0].firstChild.data;
                                                                                                                                                                                                        document.getElementById('act2Acc').value = acc;
                                                                                                                                                                                                        document.getElementById('act2SubAcc').value = subAcc;
                                                                                                                                                                                                        document.getElementById('des2').value = des;
                                                                                                                                                                                                        document.getElementById('act2Id').value = act2Id;
                                                                                                                                                                                                        document.getElementById('n2noteNo').value = noteNo;
                                                                                                                                                                                                        document.getElementById('n2plOrder').value = nplOrder;
                                                                                                                                                                                                        document.getElementById('n2tblOrder').value = ntblOrder;
    } else if (t === 'T3') {
                                                                                                                                                                                                        act3Id = row[0].firstChild.data;
                                                                                                                                                                                                        document.getElementById('act3Acc').value = acc;
                                                                                                                                                                                                        document.getElementById('act3SubAcc').value = subAcc;
                                                                                                                                                                                                        document.getElementById('des3').value = des;
                                                                                                                                                                                                        document.getElementById('act3Id').value = act3Id;
                                                                                                                                                                                                        document.getElementById('n3noteNo').value = noteNo;
                                                                                                                                                                                                        document.getElementById('n3plOrder').value = nplOrder;
                                                                                                                                                                                                        document.getElementById('n3tblOrder').value = ntblOrder;
    } else if (t === 'T4') {

                                                                                                                                                                                                        act4Id = row[0].firstChild.data;
                                                                                                                                                                                                        document.getElementById('act4Acc').value = acc;
                                                                                                                                                                                                        document.getElementById('act4SubAcc').value = subAcc;
                                                                                                                                                                                                        document.getElementById('des4').value = des;

                                                                                                                                                                                                        document.getElementById('act4Id').value = act4Id;
                                                                                                                                                                                                        document.getElementById('n4noteNo').value = noteNo;
                                                                                                                                                                                                        document.getElementById('n4plOrder').value = nplOrder;
                                                                                                                                                                                                        document.getElementById('n4tblOrder').value = ntblOrder;
    }

    }

    </script>
    <script type="text/javascript" content="charset=UTF-8">
    function createNewAccountNo(num) {
            var selectNo = document.getElementById("storeClickedButton").value;

            if (num === 0) {
    } else if (num === 1) {
                var lastAccNo = document.getElementById("storeAct2LstNo").value;
                var getNo = lastAccNo.split("-");
                //alert(getNo[1]);

    } else if (num === 2) {

    } else if (num === 3) {

    } else if (num === 4) {

    }
    }

    function autoClick() {
            document.getElementById('linkToClick').click();
    }

    function setRightDivSize(num) {
            if (num === 1) {
                document.getElementById("storeClickedButton").value = "1";
                document.getElementById("treeDemo").style.height = "585px";
    } else if (num === 2) {
                document.getElementById("storeClickedButton").value = "2";
                document.getElementById("treeDemo").style.height = "620px";
    } else if (num === 3) {
                document.getElementById("storeClickedButton").value = "3";
                document.getElementById("treeDemo").style.height = "678px";
    } else if (num === 4) {
                document.getElementById("storeClickedButton").value = "4";
                document.getElementById("treeDemo").style.height = "720px";
    } else if (num === 5) {
                // document.getElementById("treeDemo").style.height="689px";
    } else if (num === 6) {
                // document.getElementById("treeDemo").style.height="689px";
    } else if (num === 7) {
                // document.getElementById("treeDemo").style.height="689px";
    }
    }


    function validate(f, id) {
            var bool = new Boolean();
            bool = true;
            if (id === '1') {
                var e = f['act1'].value;
                var a = f['act1Accno'].value;
                var b = f['act1SubAcc'].value;
                var c = f['des1'].value;
                if (e === '0') {
                    bool = false;
                    alert("මුලික ශිර්ෂය තෝරන්න");
    } else if (a === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    } else if (b === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    } else if (c === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    }
    if (bool) {
                    document.forms['f'].submit();
    }
    } else if (id === '2') {
                var a = f['act1_2'].value;
                var b = f['act2'].value;
                var c = f['act2Acc'].value;
                var d = f['act2SubAcc'].value;
                var e = f['des2'].value;
                if (a === '0') {
                    bool = false;
                    alert("මුලික ශිර්ෂය තෝරන්න");
    } else if (b === '0') {
                    bool = false;
                    alert("උප ශිර්ෂය තෝරන්න");
    } else if (c === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    } else if (d === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    } else if (e === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    }
    if (bool) {
                    document.forms['f'].submit();
    }
    } else if (id === '3') {
                var a = f['act1_3'].value;
                var b = f['act2_1'].value;
                var c = f['act3'].value;
                var d = f['act3Acc'].value;
                var e = f['act3SubAcc'].value;
                var f = f['des3'].value;
                if (a === '0') {
                    bool = false;
                    alert("මුලික ශිර්ෂය තෝරන්න");
    } else if (b === '0') {
                    bool = false;
                    alert("උප ශිර්ෂය තෝරන්න");
    } else if (c === '0') {
                    bool = false;
                    alert("ශිර්ෂය තෝරන්න");
    } else if (d === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    } else if (e === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    } else if (f === '') {
                    bool = false;
                    alert("නිවැරදිව දත්ත පුරවා නොමැත");
    }
    if (bool) {
                    document.forms['f'].submit();
                }
            }
        }


    </script>
<script src="../js/validate.js" type="text/javascript"></script>
</html>
