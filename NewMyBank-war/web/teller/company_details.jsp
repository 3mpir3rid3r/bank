<%-- 
    Document   : company_details
    Created on : Jan 26, 2015, 3:30:24 PM
    Author     : mmh
--%>

<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | Company Details</title>

        <!--<link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>-->
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-color2{
                background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1b9ce5);
            }.bg-top{
                margin-top: -10px;                
            }
            .bg-top2{
                margin-top: -20px;                
            }
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head>

    <body class="skin-blue  pace-done fixed">

        <!--header-->
        <%@include file="teller_header.jsp" %>
        <!--.............................header End......................-->

        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <aside id="content" class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        ආයතනයේ තොරතුරු
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">ආයතනයේ තොරතුරු</li>
                    </ol>
                </section>
                <!--..................................page content............-->
                <section class="content">
                    <div class="row">
                        <form action="index.jsp" class="form-horizontal">
                            <div class="col-md-9">
                                <div class="box box-info bg-color bg-top">                                
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-6">

                                                <div class="form-group">
                                                    <label class="control-label col-sm-5  ">ආයතන අංකය :</label>
                                                    <div class="col-sm-7">
                                                        <div class="input-group">
                                                            <input class="form-control input-sm" type="text" value="000000" disabled="">
                                                            <span class="input-group-btn">
                                                                <button class="btn btn-info btn-flat btn-sm" type="button" onclick="companyNumBtnAction()"><i class="fa fa-search"></i></button>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-5  ">ආයතනයේ නම :</label>
                                                    <div class="col-md-7">
                                                        <input data="validate" data-type="letterS" class="form-control input-sm convertSinhalaIskolaPotha" type="text" required="" name="cFullName" id="cFullName">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-5 ">ආයතනයේ ස්භාවය :</label>
                                                    <div class="col-md-7">
                                                        <select class="form-control input-sm convertSinhalaIskolaPotha" name="cCompanyNature" id="cCompanyNature" required="">
                                                            <option>-තෝරන්න-</option>
                                                            <option value="1">abc</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-5 ">ලියාපදිංචි අංකය :</label>
                                                    <div class="col-md-7">
                                                        <input data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="nRegisteredNo" id="nRegisteredNo" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-5 ">ලියාපදින්චි දිනය :</label>
                                                    <div class="col-md-7">
                                                        <input class="form-control input-sm convertSinhalaIskolaPotha" type="date" required="" name="dRegisteredDate" id="dRegisteredDate">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-5  ">වරිපනම් අංකය :</label>
                                                    <div class="col-md-7">
                                                        <input data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="nVat" id="nVat" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-5  ">ප්‍රධානියාගේ නම :</label>
                                                    <div class="col-md-7">
                                                        <input data="validate" data-type="letterS" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cMasterName" id="cMasterName" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-5  ">ජ : හැ : අංකය:</label>
                                                    <div class="col-md-7">
                                                        <input data="validate" data-type="birthday" class="form-control input-sm convertSinhalaIskolaPotha" type="text" id="nNicNo" name="nNicNo" required="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">                                            
                                                <div class="form-group">
                                                    <label class="control-label col-sm-4  ">ස්ථීර ලිපිනය 1 :</label>
                                                    <div class="col-md-8">
                                                        <input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPAddLine1" id="cPAddLine1" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-4  ">ස්ථීර ලිපිනය 2 :</label>
                                                    <div class="col-md-8">
                                                        <input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPAddLine2" id="cPAddLine2" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-4  ">ස්ථීර ලිපිනය 3 :</label>
                                                    <div class="col-md-8">
                                                        <input class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cPAddLine3" id="cPAddLine3" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-4  ">ස්ථීර ලිපිනය 4 :</label>
                                                    <div class="col-md-8">
                                                        <input class="form-control input-sm convertSinhalaIskolaPotha" type="text" id="cPAddLine4" name="cPAddLine4" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-4  ">දුරකථන අංකය 1 :</label>
                                                    <div class="col-md-8">
                                                        <input data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" id="cPTelNo1" name="cPTelNo1" required="" maxlength="10">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-4  ">දුරකථන අංකය 2 :</label>
                                                    <div class="col-md-8">
                                                        <input data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBTelNo1" id="cBTelNo1" required="" maxlength="10"  >
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-4 ">ෆැක්ස් අංකය :</label>
                                                    <div class="col-md-8">
                                                        <input data="validate" data-type="number" class="form-control input-sm convertSinhalaIskolaPotha" type="text" name="cBTelNo1" id="cBTelNo1" required="" maxlength="10">
                                                    </div>
                                                </div>
                                                <div class="form-group" style="margin-top: -10px;">
                                                    <label class="control-label col-sm-4  ">ඊ-මේල් :</label>
                                                    <div class="col-md-8">
                                                        <input class="form-control input-sm convertSinhalaIskolaPotha" type="email" name="cEmail" id="cEmail" required="">
                                                    </div>
                                                </div> 
                                            </div>
                                        </div>                                
                                    </div>
                                    <div class="box-footer">
                                        <fieldset>

                                            <div class="form-group">
                                                <div class="col-lg-10">
                                                    <input type="hidden" value="0" name="cus">
                                                    <input type="hidden" value="2" name="type">
                                                    <input class="btn btn-primary" id="" type="submit" value="ස්ථිර කරන්න">
                                                    <input class="btn btn-info" id="" type="reset" value="නැවත සැකසීම">
                                                    <input class="btn btn-danger" id="" type="button" value="ඉවත් වන්න">
                                                </div>
                                            </div>                                

                                        </fieldset>
                                    </div>
                                </div>
                            </div>   
                        </form>
                        <div class="col-md-3">
                            <div class="box box-info bg-color bg-top">
                                <div class="box-header"><h5 class="box-title">abc</h5></div>
                                <div class="box-body">

                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!--..................................page content............-->
            </aside>

        </div>
    </body>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    <script src="../js/validate.js" type="text/javascript"></script>
    <script type="text/javascript">
//            $("body").toggleClass("fixed");
                                                                    fix_sidebar();


                                                                    /*==================================*/
                                                                    function companyNumBtnAction() {
                                                                        window.location = "view_customers.jsp";
                                                                    }

    </script>
</html>
