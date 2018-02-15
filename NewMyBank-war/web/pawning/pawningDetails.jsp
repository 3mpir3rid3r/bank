<%-- 
    Document   : PawningDetails
    Created on : Dec 18, 2014, 9:19:03 AM
    Author     : kalana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/sb-admin-2.css" rel="stylesheet" type="text/css"/>
        <link href="../css/plugins/metisMenu/metisMenu.css" rel="stylesheet" type="text/css"/>
        <link href="../css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet" type="text/css"/>
        <link href="../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../font-awesome-4.1.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <script src="../js/Ajax.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/sb-admin-2.js" type="text/javascript"></script>
        <link href="../css/magicsuggest-min.css" rel="stylesheet" type="text/css"/>
        <script src="../js/magicsuggest-min.js" type="text/javascript"></script>
        <style>
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head>
    <!--avinishchitha ginuma haraha beru ukas wisthara-->
    <body>
        <div id="wrapper">
            <%@include file="pawning_header.jsp"%>    
            <%@include file="pawning_slidebar.jsp"%>  
        </div>
        <div id="page-wrapper">
            <div class="row ">
                <h3>අවිනිශ්චිත ගිණුම හරහා බේරූ උකස් විස්තර</h3>
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <center> <div class="panel-body">
                                <label class="radio-inline col-lg-3">
                                    <input type="radio" name="a"/>බැර වූ
                                </label>
                                <label class="radio-inline col-lg-3">
                                    <input type="radio" name="a"/>බැර නොවූ
                                </label>
                                <label class="radio-inline col-lg-3">
                                    <input type="radio" name="a"/>අවලංගු වූ
                                </label>                            
                            </div></center>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="checkbox col-lg-4">
                        <label>
                            <input type="checkbox">සියළු
                        </label>
                    </div>                            
                    <div class="col-lg-8">
                        <input type="date" class="form-control input-sm">
                    </div>                        
                </div>
                <div class="table-responsive col-lg-12">
                    <table class="table table-bordered table-hover table-condensed">
                        <thead>
                            <tr>
                                <td>TRN No</td>
                                <td>Ticket No</td>
                                <td>Receipt no</td>
                                <td>Name</td>
                                <td>NIC No</td>
                                <td>Balance</td>
                                <td>Capital</td>
                                <td>Interest</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>                                                  
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>                                                  
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>                                                  
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>                                                  
                            <tr>
                                <td></td>
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
            <div class="btn-group btn-group-justified">
                <a href="#" class="btn btn-default">වසන්න</a>
                <a href="#" class="btn btn-default">අවලංගු කරන්න</a>
                <a href="#" class="btn btn-default">බැර කරන්න</a>
            </div>
            <br>
        </div>
    </div>
</body>
</html>
