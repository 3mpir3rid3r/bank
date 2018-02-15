<%-- 
    Document   : fullpayment
    Created on : Dec 17, 2014, 2:55:12 PM
    Author     : kalana
--%>

<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="com.nbs.common.Alerts"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.BnkPwnPawnMasterArticles"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkPwnPawnMaster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>උකස් තොරතුරු </title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">

            .bg-color{
                background-color: #e7f0f7;
            }

            .bg-top{
                margin-top: -10px;                
            }.bg-top1{
                margin-top: -15px;     
            }
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
        <script type="text/javascript">
            var call = 0;
        </script>
    </head> 
    <!--sampoornayen ukas berima-->
    <body class="skin-blue  pace-done fixed"  onload="autoClick()">
        <%  String alert = "";

            if (request.getParameter("mg") != null) {
                String mg = request.getParameter("mg");
                if ("error".equals(mg)) {
                    alert = Alerts.warningAlert("Something Wrong", "You miss some Fields", "");
                } else if ("saved".equals(mg)) {
                    alert = Alerts.successAlert("success", "Successfully saved");
                } else if ("updated".equals(mg)) {
                    alert = Alerts.successAlert("success", " Successfully updated");
                }
            }
        %>
        <!--header-->
        <%@include file="pawning_header.jsp" %>
        <!------------------------->
        <%            String title = "";
            String index = request.getParameter("index");

            if ("1001".equals(index)) {
                title = "උකස් සම්පූර්ණයෙන් බේරීම";
            } else if ("1002".equals(index)) {
                title = "කොටසක් බේරීම";
            } else if ("1003".equals(index)) {
                title = "නැවත තබීම";
            }
            request.getSession().setAttribute("index", index);

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
            }
            long nPwnMasterID = 0;
            String cFullName = ".............";
            String cReceiptNo = "0000000000";
            String cAddress = "................";
            String dMaturityDate = "0000/00/00";
            BigDecimal nActualInt = BigDecimal.ZERO;
            BigDecimal nToDate_Capital = BigDecimal.ZERO;
            BigDecimal nToDate_Stationary = BigDecimal.ZERO;
            BigDecimal nToDate_Postage = BigDecimal.ZERO;
            BigDecimal nToDate_AuctionFee = BigDecimal.ZERO;
            BigDecimal nPwnAdvancedIssued = BigDecimal.ZERO;

            BigDecimal nInterestForToday = BigDecimal.ZERO;
            BigDecimal nTotCapital = BigDecimal.ZERO;

            BigDecimal nTotWeight = BigDecimal.ZERO;
            BigDecimal nTotWeightGold = BigDecimal.ZERO;

            int nToDateDue_Days = 0;

            String pwnDay = "0000/00/00";
            String lastDay = "0000/00/00";
            String idN = "";
            if (request.getSession().getAttribute("BnkPwnPawnMaster") != null) {
                BnkPwnPawnMaster bppm = (BnkPwnPawnMaster) request.getSession().getAttribute("BnkPwnPawnMaster");
                nPwnMasterID = bppm.getNPwnMasterID();
                cFullName = bppm.getCFullName();
                idN = bppm.getCIDNo();
                if (idN == null) {
                    idN = "";
                }
                cReceiptNo = bppm.getCReceiptNo();
                cAddress = bppm.getCPAddLine1() + "," + bppm.getCPAddLine2() + "," + bppm.getCPAddLine3() + "," + bppm.getCPAddLine4();

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                if (dMaturityDate != null & !dMaturityDate.equals("0000/00/00")) {
                    dMaturityDate = format.format(bppm.getDMaturityDate());
                }
                nActualInt = bppm.getNActualInt();

                Date pwnDate = bppm.getDPwnDate();
                Date lastDate = bppm.getDLastCapitalPayDate();

                if (pwnDate != null & !pwnDate.equals("0000/00/00")) {
                    pwnDay = format.format(pwnDate);
                }
                if (lastDate != null & !lastDate.equals("0000/00/00")) {
                    lastDay = format.format(lastDate);
                }

                nToDate_AuctionFee = bppm.getNToDateAuctionFee();
                //bppm.getN
                nToDate_Capital = bppm.getNToDateCapital();
                nToDate_Postage = bppm.getNToDatePostage();
                nToDate_Stationary = bppm.getNToDateStationary();
                nPwnAdvancedIssued = bppm.getNPwnAdvancedIssued();
                nTotWeight = bppm.getNTotWgtArt();
                nTotWeightGold = bppm.getNTotWgtGold();
                nInterestForToday = bppm.getNToDateIntValue();

                nTotCapital = BigDecimal.valueOf(nToDate_Capital.doubleValue() + nInterestForToday.doubleValue() + nToDate_Stationary.doubleValue() + nToDate_AuctionFee.doubleValue() + nToDate_Postage.doubleValue());

            }

        %>
        <!--.............................header End......................-->


        <%            boolean isView = false;
            if (request.getParameter("viewRep") != null) {
                isView = Boolean.parseBoolean(request.getParameter("viewRep"));

            }
        %>
        <%
            if (isView) {
        %>
        <a id="linkToClick" href="printReport.jsp" target="_blank"></a>
        <% }%>


        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="pawning_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->
            <aside id="content" class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        <%=title%>
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active"><%=title%></li>
                    </ol>
                </section>
                <%= alert%>
                <section class="content">
                    <div class="row bg-searchheight bg-top">
                        <div class="col-md-12 bg-searchheight bg-pad" >
                            <div class="row"> 
                                <form action="../RePwnMasterServlet?key=searchForm" method="post">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default" style="margin-right:  +15px">
                                            <div class="panel-body" >
                                                <div class="input-group col-lg-12" >
                                                    <div class="input-group col-lg-5" >
                                                        <span class="input-group-addon">කුයිතාන්සි අංකය :</span>
                                                        <input type="text" style="width: 250px" class="  form-control text-right convertSinhalaIskolaPotha "  name="search" id="search" value="<%=key%>">
                                                        <span class="input-group-btn">
                                                            <button  class="  btn btn-default"  type="submit">Search</button>
                                                        </span>
                                                        <span class="input-group-addon"><%=cFullName%></span>
                                                        <span class="input-group-addon"><%=idN%></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>   
                                    </div>
                                </form>
                                <div class="col-lg-6">
                                    <ul class="list-group col-lg-12" id="fontSize">
                                        <li class="list-group-item">
                                            <span class="badge" style="background-color: white;color: #555555;"><%= pwnDay%></span>
                                            උකස් දිනය
                                        </li>
                                        <li class="list-group-item">
                                            <span class="badge" style="background-color: white;color: #555555;"><%= lastDay%></span>
                                            අවසන් ගෙවු දිනය
                                        </li>
                                        <li class="list-group-item">
                                            <span class="badge" style="background-color: white;color: #555555;"><%=dMaturityDate%></span>
                                            කල්පිරෙන දිනය
                                        </li>
                                        <li class="list-group-item">
                                            <span class="badge" style="background-color: white;color: #555555;"><%=cReceiptNo%></span>
                                            කුයිතාන්සි අංකය
                                        </li>
                                        <li class="list-group-item">
                                            <span class="badge" style="background-color: white;color: #555555;"><%=nToDateDue_Days%></span>
                                            දින ගණන
                                        </li>
                                    </ul> 
                                    <ul class="list-group col-lg-12" id="fontSize">
                                        <li class="list-group-item">
                                        <center>උකස් භණ්ඩ පිළිබද විස්තර</center>
                                        </li>
                                        <!--<li class="list-group-item">-->
                                        <table class="table table-bordered table-hover ">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>උකස් භාන්ඩ</th>
                                                    <th>කැරට් අගය</th>
                                                    <th>ප්‍රමාණය</th>
                                                    <th>වෙනත්</th>
                                                </tr>                                
                                            </thead>
                                            <tbody height="100px">
                                                <%  int i = 0;

                                                    if (request.getSession()
                                                            .getAttribute("BnkPwnPawnMasterArticles") != null) {
                                                        List<BnkPwnPawnMasterArticles> articles = (List<BnkPwnPawnMasterArticles>) request.getSession().getAttribute("BnkPwnPawnMasterArticles");
                                                        for (BnkPwnPawnMasterArticles a : articles) {
                                                            i++;
                                                %>
                                                <tr>
                                                    <td><%=i%></td>
                                                    <td><%=a.getCPwnArticlName()%></td>
                                                    <td><%=a.getCCaratType()%></td>
                                                    <td><%=a.getNQty()%></td>
                                                    <td><%=a.getCRemarks()%></td>
                                                </tr>
                                                <%
                                                        }
                                                    }
                                                %>

                                            </tbody>
                                        </table>
                                        <!--</li>-->
                                        <!--<li class="list-group-item">-->
                                        <div class="col-lg-6"> <ul class="list-group col-lg-12" id="fontSize"><li class="list-group-item">භාණ්ඩ බර : <span><%= nTotWeight%></span> g</li></ul></div>
                                        <div class="col-lg-6"><ul class="list-group col-lg-12" id="fontSize"><li class="list-group-item">රන් බර : <span><%= nTotWeightGold%></span> g</li></ul></div>
                                        <!--</li>-->
                                    </ul>
                                </div>
                                <div class="col-lg-6">
                                    <ul class="list-group col-lg-12" id="fontSize">
                                        <li class="list-group-item">
                                            අත්තිකරම් මුදල
                                            <b><span class="pull-right">රු : <%=nPwnAdvancedIssued%></span></b>
                                        </li>
                                        <li class="list-group-item">
                                            ඉතිරි මුදල
                                            <b><span class="pull-right">රු : <%=nToDate_Capital%></span></b>
                                        </li>
                                        <li class="list-group-item">
                                            පොලි අනුපාතය
                                            <b><span class="pull-right"><%=nActualInt%> %</span></b>
                                        </li>
                                        <li class="list-group-item">
                                            දිනට පොලිය
                                            <b><span class="pull-right">රු :<%=nInterestForToday%></span></b>
                                        </li>
                                        <li class="list-group-item">
                                            ලිපි ගාස්තු
                                            <b><span class="pull-right">රු : <%=nToDate_Stationary%></span></b>
                                        </li>
                                        <li class="list-group-item"">
                                            තැපැල් ගාස්තු
                                            <b><span class="pull-right">රු : <%=nToDate_Postage%></span></b>
                                        </li>
                                        <li class="list-group-item">
                                            වෙන්දේසි වියදම්
                                            <b><span class="pull-right">රු : <%=nToDate_AuctionFee%></span></b>
                                        </li>


                                        <li class="list-group-item">
                                            පොළී සහනය
                                            <b><span class="pull-right"><input id="nPaid_FreeInterest" style="color: red;height: 22px;" class="text-right" name="nPaid_FreeInterest" type="text" /></span></b>
                                        </li>

                                        <li class="list-group-item">
                                            මුළු මුදල
                                            <b><span class="pull-right">රු : <%= nTotCapital%> </span></b><br><br>


                                            <% if (("1001".equals(index)) || "1003".equals(index)) {%>

                                            ගෙවූ මුදල  <b><span  class="pull-right">රු : <%=nTotCapital%> </span></b>
                                            <input type="hidden" id="totCap" value="<%=nTotCapital%>"/>
                                            <%} else if ("1002".equals(index)) { %>

                                            <input type="text" placeholder="ගෙවූ මුදල" class="form-control col-sm-1 text-right" style="color: #0072b1" maxlength="30"  name="paiedPrice" id="paiedPrice">

                                            <br>
                                            <%}%>
                                            <br><br>
                                            <input id="repwn" name="repwn" type="hidden" value="<%= index%>"/>

                                            <button onclick="saveRepowning()" class="btn btn-info btn-sm" >ගෙවන්න</button>
                                        </li>

                                    </ul>                
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </aside>
        </div>

        <script type="text/javascript">

            function saveRepowning() {
                var freeInt = document.getElementById("nPaid_FreeInterest").value;
                var repwn = document.getElementById("repwn").value;

                if (document.getElementById("paiedPrice") !== null) {
                    var price = document.getElementById("paiedPrice").value;
                    if (price !== "") {

                        window.location = '../RepawningServlet?price=' + price + '&freeInt=' + freeInt + '';
                    } else {
                        document.getElementById("paiedPrice").style.borderColor = "red";
                    }
                } else {
                    if (document.getElementById("totCap") !== null) {
                        var price = document.getElementById("totCap").value;
                        window.location = '../RepawningServlet?nTotCap=' + price + '&freeInt=' + freeInt + '';
                    }
                }



            }

            function autoClick() {
                document.getElementById('linkToClick').click();
            }
        </script>

    </body>

</html>
