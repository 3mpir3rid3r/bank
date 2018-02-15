<%-- 
    Document   : customerDashbord
    Created on : Jan 25, 2018, 8:18:43 AM
    Author     : mmh
--%>

<%@page import="com.nbs.common.Alerts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller</title>

        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bower_components/Ionicons/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bower_components/Ionicons/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:120px;                
            }
            a > div {
                width: 300px; 
            }
            a > div:hover {
                transition: width 0.1s, height 0.1s;
                width: 330px;
            }
            .info-box:hover {
                box-shadow: 5px 0px 40px rgba(0,0,0, .5);
            }
            .info-box:hover >.info-box-content{
                transition: padding-top 1s;
                padding-top: 28px;
            }
            .info-box-number:hover {
                color: #005983 !important;
            }
            .info-box-number{
                font-size: 15px ;
            }
            h4{
                margin-bottom: 06px;
                margin-top: 3px;
            }
            hr{
                height: 1px;
                background-color: black;
                margin-top: 0px;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include  file="teller_header.jsp" %>
        <!--..............................-->
        <%
            String alert = "";
            if (request.getParameter("mg") != null) {
                String mg = (String) request.getParameter("mg");
                if (!("".equals(mg))) {
                    alert = Alerts.successAlert("Successfull", mg);
                }
            }
        %>
        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Teller -
                        <small>Dashbord</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Home</a></li>
                    </ol>
                </section>
                <%=alert%>
                <section id="content" class="content">
                    <div class="row bg-top">
                        <div class="col-md-12 bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 ><strong>පාරිභෝගික තොරතුරු</strong></h4>
                                            <hr>
                                            <a class="dash" href="../LoadCustomerComboServlet">
                                                <div class="col-md-3 col-sm-6 col-xs-12">
                                                    <div class="info-box">
                                                        <span class="info-box-icon bg-blue-gradient"><i class="fa fa-user"></i></span>
                                                        <div class="info-box-content">
                                                            <span class="info-box-number text-black h6">පුද්ගලික</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="dash" href="../teller/company_details.jsp">
                                                <div class="col-md-3 col-sm-6 col-xs-12">
                                                    <div class="info-box">
                                                        <span class="info-box-icon bg-green-gradient"><i class="fa fa-bank"></i></span>
                                                        <div class="info-box-content">
                                                            <span class="info-box-number text-black">ආයතනික</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="dash" href="../LoadMemberComboServlet">
                                                <div class="col-md-3 col-sm-6 col-xs-12">
                                                    <div class="info-box">
                                                        <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                        <div class="info-box-content">
                                                            <span class="info-box-number text-black">සාමාජික</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>







                    <div class="row bg-top">
                        <div class="col-md-12 bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 ><strong>තැම්පත් ගණුදෙණු</strong></h4>
                                            <hr>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="../SavingDetailsServlet?moneyDepType=5">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-blue-gradient"><i class="fa fa-money"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">තැම්පත් තොරතුරු</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("121")%>">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-green-gradient"><i class="fa fa-download"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ඉතුරුම් ගිණුම බැර</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("151")%>">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-upload"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ඉතුරුම් ගිණුම හර</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-green-gradient"><i class="fa fa-credit-card"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">චෙක්පත් තැම්පතු</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-credit-card"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">චෙක්පත් නිකුත්කිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-copy"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ගිණුමකින් හර කිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-percent"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">පොළී ගණනය</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-exchange"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ගිණුම් වර්ගය මාරුකිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>






                    <div class="row bg-top">
                        <div class="col-md-12 bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 ><strong>ණය ගණුදෙණු</strong></h4>
                                            <hr>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="../LoanDetailsServlet?loanType=3">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-blue-gradient"><i class="fa fa-user"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ණය තොරතුරු</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-green-gradient"><i class="fa fa-building-o"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ණය ගිණුම බැර</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ණය ගිණුම හර</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">චෙක්පත් මඟින් නිකුත්කිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">චෙක්පත් මඟින් අයකිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ලෙජර් ගිණුමකින් නිකුත්කිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ලෙජර් ගිණුමකින් අයකිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ණය ගිණුමෙන් හරවීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ණය ගිණුම් බද්ධ කිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ණය වර්ගය වෙනස් කිරීම</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="#">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-red-gradient"><i class="fa fa-users"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">ණය අයවිය යුතු ආකාරය</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>





                    <div class="row bg-top">
                        <div class="col-md-12 bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 ><strong>වෙනත්</strong></h4>
                                            <hr>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("121")%>">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-blue-gradient"><i class="fa fa-user"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">හර සටහන්</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a class="dash" href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("151")%>">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-green-gradient"><i class="fa fa-building-o"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">බැර සටහන්</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>




                    <div class="row bg-top">
                        <div class="col-md-12 bg-pad">
                            <div class="box box-info bg-color">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 ><strong>වාර්තා</strong></h4>
                                            <hr>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <a class="dash" href="../LoanDetailsServlet?loanType=3">
                                                        <div class="col-md-3 col-sm-6 col-xs-12">
                                                            <div class="info-box">
                                                                <span class="info-box-icon bg-blue-gradient"><i class="fa fa-user"></i></span>
                                                                <div class="info-box-content">
                                                                    <span class="info-box-number text-black">දෛනික ගණුදෙණු</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
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
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

    </body>
</html>
