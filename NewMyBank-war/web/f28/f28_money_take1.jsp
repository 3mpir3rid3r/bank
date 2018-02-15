<%-- 
    Document   : index
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : mmh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>මුදල් ලැබීම්2</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <link href="../css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-pad{
                padding-right:0px;                
            }

        </style>

        <!--script-->
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/jquery.dataTables.min.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#depositTable').dataTable({
                    "scrollY": 360,
                    "scrollX": true,
                    "paging": false,
                    "ordering": false,
                    "info": false,
                    "searching": false
                });
            });
        </script>
    </head>

    <body class="skin-blue fixed" style="height: auto;background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include file="f28_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="f28_slidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        මුදල් ලැබීම්2
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i>F-28</a></li>
                        <li><a href="#">මුදල් ලැබීම්2</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <%@include file="f28_money_header.jsp" %>

                    <div class="row">
                        <div class="col-md-2 bg-pad" >
                            <div class="panel box box-info bg-color bg-top" style="height: 500px">
                                <!--./body-->
                                <div class="box-body">
                                    <div style="height: 320px">
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>16B ගැනුම්</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>16B ගැනුම් අත්තිකාරම්</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>16B ගබඩා ලැබීම්</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>14C/9B විකුණුම්</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>F 17</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>F 18</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>F 19</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>බඩු අඩු වැඩිය</label></button>
                                    </div>
                                    <div style="height: 40px">

                                    </div>
                                    <div style="height: 120px">
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>ගණුදෙණුකරුවන්</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>Report</label></button>
                                        <button type="button" class="btn btn-sm btn-block" onclick="" style="background-color: #1F9DE5;color: white"><label>BackUp</label></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10 bg-top">
                            <!--Money saving-->
                            <div class="panel box box-info bg-color">
                                <!--./body-->
                                <form  class="form-horizontal" action="../NewBnkDepDepositTransactionServlet" method="post" name="depForm" onsubmit="validateNewDeposit(this);
                                        return false;">
                                    <div class="box-body">
                                        <div class="form-group" style=";margin-bottom: -10px">
                                            <label class="col-sm-1 bg-pad text-right input-sm">From Date :</label>
                                            <div class="col-md-2 bg-pad">
                                                <input type="date" class="form-control input-sm text-right convertSinhalaIskolaPotha">
                                            </div>
                                            <label class="col-sm-1 text-right input-sm">To Date :</label>
                                            <div class="col-md-2 bg-pad">
                                                <input type="date" class="form-control input-sm text-right convertSinhalaIskolaPotha"> 
                                            </div>
                                            <!--<div class="col-sm-1 checkbox">-->
                                            <label class="col-sm-1">
                                                <input type="checkbox" id="bIntCreditingDiffAcc" name="bIntCreditingDiffAcc" >
                                                All
                                            </label>
                                            <!--</div>-->
                                            <label class="col-sm-1 bg-pad text-right input-sm">මූලික අංශය:</label>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control input-sm text-right convertSinhalaIskolaPotha">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12" style="margin-top: 5px">
                                                <table id="depositTable" class="cell-border compact" cellspacing="0" width="100%">
                                                    <thead>
                                                        <tr style="background-color:  #1F9DE5;" >
                                                            <!--<th width="0px">nLoanMPId</th>-->
                                                            <th class="text-center">HDID</th>
                                                            <th class="text-center">Date</th>
                                                            <th class="text-center">F 10 N0</th>
                                                            <th class="text-center">Section</th>
                                                            <th class="text-center">Customer</th>
                                                            <th class="text-center">Complete</th>
                                                            <th class="text-center">Amount</th>
                                                            <th class="text-center">JouHDID</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr class="odd">
                                                            <!--<td valign="top" colspan="8" class="dataTables_empty">No data available in table</td>-->
                                                            <td class="text-center"></td>
                                                            <td class="text-center"></td>
                                                            <td class="text-center"></td>
                                                            <td class="text-center"></td>
                                                            <td class="text-center"></td>
                                                            <td class="text-center"></td>
                                                            <td class="text-center"></td>
                                                            <td class="text-center"></td>
                                                        </tr>  
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="col-md-12" style="margin-top: 5px">
                                                <div class="col-md-3">
                                                    <button type="button" class="btn btn-sm" onclick="" style="background-color: #1F9DE5;color: white">New</button>
                                                    <button type="button" class="btn btn-sm" onclick="" style="background-color: #1F9DE5;color: white">Open</button>
                                                    <button type="button" class="btn btn-sm btn-warning" onclick="" style="color: red">J</button>
                                                    <button type="button" class="btn btn-sm btn-warning" onclick="" style="color: red">R</button>
                                                </div>    
                                                <div class="col-md-9" style="margin-bottom: -30px">
                                                    <div class="form-group">
                                                        <label class="col-md-1 input-sm text-right"  >මුදලට</label>
                                                        <label class="col-md-2 input-sm" name="cCIFNo" id="cCIFNo" >1234567891.00</label>
                                                        <label class="col-md-1 bg-pad input-sm text-right">තැ.ණයට</label>
                                                        <label class="col-md-1 input-sm" name="cCIFNo" id="cCIFNo" >1234567891.00</label>
                                                        <label class="col-md-2 bg-pad input-sm text-right" name="cCIFNo" id="cCIFNo" >පෝ.මුද්දර</label>
                                                        <label class="col-md-1 input-sm" name="cCIFNo" id="cCIFNo" >1234567.00</label>
                                                        <label class="col-md-2 bg-pad input-sm bg-pad text-right" name="cCIFNo" id="cCIFNo" >මරු යැවීම්</label>
                                                        <label class="col-md-2 input-sm" name="cCIFNo" id="cCIFNo" >1234567891.00</label>
                                                    </div>
                                                    <div class="form-group st-label">
                                                        <label class="col-md-1 input-sm text-right st-label"  >ණයට</label>
                                                        <label class="col-md-2 input-sm st-label" name="cCIFNo" id="cCIFNo" >1234567891.00</label>
                                                        <label class="col-md-1 bg-pad input-sm text-right st-label" style="padding-left: 0px">සමෘ මුද්දර</label>
                                                        <label class="col-md-1 input-sm st-label" name="cCIFNo" id="cCIFNo" >1234567891.00</label>
                                                        <label class="col-md-2 bg-pad input-sm text-right st-label" name="cCIFNo" id="cCIFNo" >වියළි සලාක</label>
                                                        <label class="col-md-1 input-sm st-label" name="cCIFNo" id="cCIFNo" >1234567.00</label>
                                                        <label class="col-md-2 input-sm bg-pad text-right st-label" name="cCIFNo" id="cCIFNo" >වෙළඳාම්</label>
                                                        <label class="col-md-2 input-sm st-label" name="cCIFNo" id="cCIFNo" >1234567891.00</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--Money saving-->
                    </div>
                </section>
            </aside>
            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>

    </body>
</html>
