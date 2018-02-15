
<%--  
    Document   : loanPayment
    Created on : May 9, 2015, 9:58:16 PM
    Author     : mmh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <link href="../css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>

        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.dataTables.min.js" type="text/javascript"></script>

        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-pad{
                padding-right:0px;                
            }
            .bg-searchheight{
                height:128px;                
            }

            th,td { white-space: nowrap; }
            div.dataTables_wrapper {
                width: auto;
                margin: 0 auto;
            }

        </style>
        <script type="text/javascript">
            function setTitle() {
                var payType = document.getElementById("cPaymentTypeId");
                var str = payType.options[payType.selectedIndex].text;
                $("#hedderMain").html(str);
            }

        </script>

    </head>


    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">
        <!--........header.....-->
        <%@include  file="../teller/teller_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="../teller/teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>

            <!--...........right-side.........-->
            <aside class="right-side">
                <!-- ./Content Header (Page header) -->
                <section class="content-header">
                    <h1 id="hedderMain">
                        ගෙවිම්
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=index.jsp><i class="fa fa-home"></i> Home</a></li>
                        <li class="active">ගෙවිම්</li>
                    </ol>
                </section>
                <!-- ./Content Header (Page header) -->

                <!--./page content-->
                <section class="content">
                    <form class="form-horizontal" action="" method="post" name="customer" onsubmit="validateCustomer(this);
                            return false;">
                        <div class="row bg-top" style="margin-right: 5px">
                            <div class="col-md-6 bg-pad" >
                                <div class="box box-info bg-color" style=" height:200px">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">දිනය : </label>
                                                    <div class="col-md-4" >
                                                        <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="" onclick="this.style.borderColor = ''">
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right">අංකය :</label>
                                                    <div class="col-md-4" >
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="" onclick="this.style.borderColor = ''">
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">අංශය :</label>
                                                    <div class="col-md-10" >
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="" onclick="this.style.borderColor = ''">
                                                    </div>                                                        
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">ආකාරය :</label>
                                                    <div class="col-md-10">

                                                        <select required class="form-control input-sm" name="cPaymentTypeId" id="cPaymentTypeId"  onclick="setTitle()" onkeypress ="setTitle()" onselect="setTitle()"> 
                                                            <option value="" style="display:none;"></option>

                                                            <option value="0"><label class="control-label">-1-</label></option>
                                                            <option value="0"><label class="control-label">-2-</label></option>


                                                        </select>                                                      
                                                    </div> 
                                                </div> 
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">නම :</label>
                                                    <div class="col-md-10">
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">
                                                    </div>
                                                </div>                                                 
                                            </div>
                                        </div>                                
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 bg-pad" >
                                <div class="box box-info bg-color" style=" height:200px">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12">

                                                <div class="form-group ">
                                                    <label class="col-sm-2 input-sm text-right">බැංකුව :</label>
                                                    <div class="col-md-10" >
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="" onclick="this.style.borderColor = ''">
                                                    </div>                                                        
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">අංකය :</label>
                                                    <div class="col-md-4">
                                                        <input  type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullName" id="cFullName" value="" onclick="this.style.borderColor = ''" onkeyup="breakDownFullName()">
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right">දිනය :</label>
                                                    <div class="col-md-4">
                                                        <input  type="date" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullName" id="cFullName" value="" onclick="this.style.borderColor = ''" onkeyup="breakDownFullName()">
                                                    </div>
                                                </div> 
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">වටිනාකම:</label>
                                                    <div class="col-md-4">
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">
                                                    </div> 
                                                    <label class="col-sm-2 input-sm text-right">අංකය :</label>
                                                    <div class="col-md-4">
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">
                                                    </div>

                                                </div>  
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">උපරිමය :</label>
                                                    <div class="col-md-4">
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">
                                                    </div> 
                                                    <label class="col-sm-2 input-sm text-right"></label>
                                                    <div class="col-md-4">
                                                        <input type="submit" class="btn btn-success" name="cFullNameSin" id="cFullNameSin" value="චෙක් උපරිමය" >
                                                    </div>

                                                </div>
                                            </div>
                                        </div>                                
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="row" style="margin-right: 5px">
                            <div class="col-md-12 bg-top bg-pad">
                                <div class="box box-info bg-color" style=" height:32px">
                                    <table>
                                        <tr  class="">

                                            <th style="width: 200px" class="text-center">
                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">
                                            </th>
                                            <th style="width: 200px" class="text-center">
                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">

                                            </th>
                                            <th style="width: 200px" class="text-center">
                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">

                                            </th>
                                            <th style="width: 100px" class="text-center">
                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">

                                            </th>
                                            <th style="width: 200px" class="text-center">
                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">

                                            </th>
                                            <th style="width: 100px" class="text-center">
                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">

                                            </th>
                                            <th style="width: 200px" class="text-center">
                                                <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cFullNameSin" id="cFullNameSin" value="" onclick="this.style.borderColor = ''">

                                            </th>
                                            <th>

                                            </th>
                                        </tr>
                                    </table>

                                </div>
                            </div>
                        </div>

                        <div class="row" style="margin-right: 5px">
                            <div class="col-md-12 bg-top bg-pad">
                                <div class="box box-info bg-color" style=" height:200px">



                                    <table id="depositTable" class="cell-border compact" cellspacing="0" width="100%">
                                        <thead>
                                            <tr style="background-color:  #dbc59e;" >

                                                <th style="width: 200px" class="text-center">අංශය</th>
                                                <th style="width: 200px" class="text-center">නම</th>
                                                <th style="width: 200px" class="text-center">කාරණය</th>
                                                <th style="width: 100px" class="text-center">වෙනත්</th>
                                                <th style="width: 200px" class="text-center">ගිනුම් අංකය</th>
                                                <th style="width: 100px" class="text-center">ගිනුම් විස්තරය</th>
                                                <th style="width: 200px" class="text-center">හර</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>

                                </div>


                            </div>
                        </div>
                        <div class="row bg-top" style="margin-right: 5px;margin-top: 0px">
                            <div class="col-md-6 bg-pad" >
                                <div class="box box-info bg-color" style=" height:50px">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="col-sm-2 input-sm text-right">දිනය : </label>
                                                    <div class="col-md-4" >
                                                        <input type="date" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="" onclick="this.style.borderColor = ''">
                                                    </div>

                                                </div>

                                            </div>
                                        </div>                                
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 bg-pad " >
                                <div class="box box-info bg-color" style=" height:50px">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-12">

                                                <div class="form-group" >
                                                    <label class="col-sm-8 input-sm text-right">Balance : </label>
                                                    <div class="col-md-4" >
                                                        <input type="text" class="form-control input-sm convertSinhalaIskolaPotha" name="cUseName" id="cUseName" value="" onclick="this.style.borderColor = ''">
                                                    </div>

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
                    </form>
                </section>
            </aside>
        </div>
    </body>
</html>
