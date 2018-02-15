<%-- 
    Document   : view_depositmaster
    Created on : Mar 2, 2015, 8:28:37 PM
    Author     : Kalana
--%>

<%@page import="com.nbs.model.ActSectionsSub"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nbs.model.ActChartOfAcctL5"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="com.nbs.model.BnkDepDepositMaster"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pawning | View Depositors</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
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
            }.bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:120px;                
            }


            .overlay {
                visibility: hidden;
                position: absolute;
                left: 0px;
                top: 0px;
                width:100%;
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

        </style>
    </head>

    <body class="skin-blue  pace-done fixed">
        <%            String branchName = "";

            if (request.getSession().getAttribute("branch") == null) {
                // response.sendRedirect("../BranchSession?page=teller/view_acc4.jsp?tellerIndexKey=0");
            } else {
                ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
                branchName = bankBranch.getCSubSectionNameUni();

            }
        %>


        <!--........header.....-->
        <%@include file="pawning_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="pawning_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Accounts -
                        <small>Chart of account</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=""><i class="fa fa-home"></i> Chart of account</a></li>

                        <li class="active"></li>
                    </ol>
                </section>
                <section id="content" class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px">
                                <div class="box-body">
                                    <div class="row">
                                        <form action="../FindLeggerDetailsServlet" method="post">
                                            <div class="col-md-12">  
                                                <div class="form-group">
                                                    <!--<div class="input-group">-->
                                                    <div class="input-group col-lg-12">
                                                        <span class="input-group-addon"><input type="checkbox" checked id="allcustomers" name="allcustomers"> All </span>
                                                        <span class="input-group-addon"><%=branchName%></span>
                                                        <input type="text" class="form-control" name="key" id="key" >
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-default" type="submit"><span class="fa fa-search"></span>Search</button>
                                                        </span>
                                                    </div>
                                                    <!--</div>-->
                                                </div>
                                            </div>
                                        </form>
                                        <!--================================================================================-->
                                        <!--view Old Pawning Details Dialog-->
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
                                                            <button onclick="overlayHide()" class="">Back</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>   
                                        <!--End Of The Dialog box-->

                                        <div class="col-md-12 bg-top">
                                            <table class="table table-bordered table-hover">
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center" width="50px"> ID</th>
                                                    <th class="text-center" width="50px">Act4 ID</th>
                                                    <th class="text-center" width="80px">Acc No</th>
                                                    <th class="text-center" width="100px">Description</th>
                                                    <th class="text-center" width="100px">Description(Eng)</th>
                                                    <th class="text-center" width="10px"></th>
                                                    <th class="text-center" width="10px" ></th>
                                                    <th class="text-center" width="10px" >Note No</th>
                                                    <th class="text-center" width="5px" ></th>


                                                </tr>
                                                <tbody>
                                                    <%

                                                        List<ActChartOfAcctL5> acctL5s = new ArrayList<ActChartOfAcctL5>();

                                                        String keyNo = "";
                                                        if (request.getParameter("key2No") != null) {
                                                            keyNo = request.getParameter("key2No");
                                                        }

                                                        if (keyNo.equals("1")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data1");
                                                        } else if (keyNo.equals("2")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data2");
                                                        } else if (keyNo.equals("3")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data3");
                                                        } else if (keyNo.equals("4")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data4");
                                                        } else if (keyNo.equals("5")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data5");
                                                        } else if (keyNo.equals("6")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data6");
                                                        } else if (keyNo.equals("7")) {
                                                            acctL5s = (List<ActChartOfAcctL5>) session.getAttribute("chartOfAccount5Data7");
                                                        }

                                                        if (acctL5s != null) {

                                                            for (ActChartOfAcctL5 acctL5 : acctL5s) {

                                                    %>
                                                    <tr  >
                                                        <td style="font-size: 12px;"><%=acctL5.getNAcctLevelID5()%></td>
                                                        <td style="font-size: 12px;"><%=acctL5.getNAcctLevelID4()%></td>
                                                        <td style="font-size: 12px;"><%=acctL5.getCCAAcctNoL5()%></td>
                                                        <td class="convertSinhalaAmali" style="font-size: 12px;"><%=acctL5.getCDescriptionSinL5()%></td>
                                                        <td style="font-size: 12px;"><%=acctL5.getCDescriptionUniL5()%></td>

                                                        <td class="text-right" style="font-size: 12px;"><%=acctL5.getNPNLOrderL5()%></td>
                                                        <td class="text-right" style="font-size: 12px;"><%=acctL5.getNTBLORderL5()%></td>
                                                        <td class="text-right" style="font-size: 12px;"><%=acctL5.getNNoteNoL5()%></td>
                                                        <td>
                                                            <a  href="pawnType.jsp?actid=<%=acctL5.getNAcctLevelID5()%>" class="btn btn-info btn-xs">Select</a>
                                                        </td>
                                                    </tr>
                                                    <% }
                                                        }%>


                                                </tbody>
                                            </table>
                                        </div>
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

        <script type="text/javascript">

        </script>
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    </body>
</html>
