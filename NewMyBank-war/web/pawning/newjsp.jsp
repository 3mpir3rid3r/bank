<%-- 
    Document   : newjsp
    Created on : Dec 10, 2014, 5:58:44 PM
    Author     : nuwan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <Title>පාරිභෝගික තොරතුරු</Title>

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
            }.bg-top1{
                margin-top: -15px;     
            }
            /*   }
              .bg-searchheight{
                  height:222px;                
              }
              .bg-pad{
                  padding-right:0px;                
              }*/
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head> 
    <body class="skin-blue  pace-done fixed">

        <!--header-->
        <%@include file="../teller/teller_header.jsp" %>
        <!------------------------->

        <!--.............................header End......................-->
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="../teller/teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        උකස් අත්තිකරම්
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">උකස් අත්තිකරම්</li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-searchheight bg-top">
                        <div class="col-md-12 bg-searchheight bg-pad" >
                            <div class="box box-info bg-color" >
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <!--<h4>උකස් අත්තිකරම්</h4>-->
                                            <div class="panel panel-default">
                                                <div class="panel-body">
                                                    <div class="form-group bg-top">
                                                        <div class="col-lg-3">
                                                            <label  class="control-label" id="fontSize"></label>
                                                            <input class="form-control input-sm convertSinhalaIskolaPotha" placeholder="උකස් වර්ගය" type="text" style="height: 30px;">
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <label  class="control-label" id="fontSize"></label>
                                                            <input class="form-control input-sm convertSinhalaIskolaPotha" placeholder="උකස් කුයිතාන්සි අංකය" type="text" style="height: 30px;">
                                                        </div><div class="col-lg-3">
                                                            <label  class="control-label" id="fontSize"></label>
                                                            <input class="form-control input-sm convertSinhalaIskolaPotha" placeholder="ශාකාව" type="text" style="height: 30px;">
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <label  class="control-label" id="fontSize"></label>
                                                            <input class="form-control input-sm convertSinhalaIskolaPotha" placeholder="පොළි අනුපාතය" type="text" style="height: 30px;">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-------------------------------------->
                                            <div class="panel panel-default bg-top">
                                                <div class="panel-body">
                                                    <label class="col-lg-3">
                                                        <input type="text" class="form-control input-sm col-lg-3 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="ජා.හැ.අංකය/ගිණුම් අංකය"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="date" class="form-control input-sm col-lg-3" style="height: 30px;" placeholder="නිකුත් කළ දිනය"/>
                                                    </label>
                                                    <label class="col-lg-6">
                                                        <input type="text" class="form-control input-sm col-lg-6 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="සම්පූර්ණ නම"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="ලිපිනය 1"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="ලිපිනය 2"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="ලිපිනය 3"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="ලිපිනය 4"/>
                                                    </label>
                                                    <label class="col-lg-6">
                                                        <input type="text" class="form-control input-sm col-lg-6 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="දුරකතන අංකය 1"/>
                                                    </label>
                                                    <label class="col-lg-6">
                                                        <input type="text" class="form-control input-sm col-lg-6 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="දුරකතන අංකය 2"/>
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="panel panel-default bg-top">
                                                <div class="panel-body">
                                                    <table class="table-bordered col-lg-12">
                                                        <thead>
                                                            <tr>
                                                                <th class="text-center" style="font-size: 14px;">උකස් භාණ්ඩ</th>
                                                                <th class="text-center" style="font-size: 14px;">කැරට් අගය</th>
                                                                <th class="text-center" style="font-size: 14px;">ප්‍රමානය</th>
                                                                <th class="text-center" style="font-size: 14px;">වෙනත්</th>
                                                            </tr>
                                                        </thead>


                                                        <tr>
                                                            <th>
                                                                <select class="form-control" style="height: 30px;">
                                                                    <option></option>
                                                                    <option></option>
                                                                </select>
                                                            </th>
                                                            <th>
                                                                <select class="form-control" style="height: 30px;">
                                                                    <option></option>
                                                                    <option></option>
                                                                </select>
                                                            </th>
                                                            <th> <input type="text" class="form-control input-sm col-lg-6 convertSinhalaIskolaPotha" style="height: 30px;"/></th>
                                                            <th> <input type="text" class="form-control input-sm col-lg-6 convertSinhalaIskolaPotha" style="height: 30px;"/></th>
                                                        </tr>

                                                        <tbody>
                                                            <tr>
                                                                <td>sd</td>
                                                                <td>vsdv</td>
                                                                <td>sv</td>
                                                                <td>sdfsdf</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <input type="button" class="btn btn-default btn btn-sm" value="ඉවත් කරන්න"/>
                                            </div>
                                            <!--------------------------------------->
                                            <div class="panel panel-default bg-top">
                                                <div class="panel-body">
                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="භාණ්ඩ බර"/>
                                                    </label>
                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="තක්සේරු මුදල"/>
                                                    </label>
                                                    <label class="col-lg-4">
                                                        <input type="date" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="පොළි අනුපාතය"/>
                                                    </label>

                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="ශුද්ධ රන් බර"/>
                                                    </label>
                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="වෙළද අගය"/>
                                                    </label>
                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="අවසාන දිනය"/>
                                                    </label>

                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="1kg 1ක වටිනාකම"/>
                                                    </label>
                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="ණය මුදල"/>
                                                    </label>
                                                    <label class="col-lg-4">
                                                        <input type="text" class="form-control input-sm col-lg-4 convertSinhalaIskolaPotha" style="height: 30px;" placeholder="කුයිතාන්සි අංකය"/>
                                                    </label>

                                                    <label class="col-lg-3">
                                                        <input type="text" class="form-control input-sm col-lg-3 convertSinhalaIskolaPotha"  placeholder="වෙනත් විස්තර"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="button" value="Add Articles" class="form-control input-sm col-lg-3 btn btn-danger"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="button" value="Add Picture"class="form-control input-sm col-lg-3 btn btn-success"/>
                                                    </label>
                                                    <label class="col-lg-3">
                                                        <input type="button" value="ගෙවන්න/Pay"class="form-control input-sm col-lg-3 btn btn-info" />
                                                    </label>
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

        </div>
    </body>

</html>

