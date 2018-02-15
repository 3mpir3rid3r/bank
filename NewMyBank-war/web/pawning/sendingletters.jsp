<%-- 
    Document   : newjsp1
    Created on : Dec 18, 2014, 10:59:37 AM
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
    <body>
        <div id="wrapper">
            <%@include file="header.jsp"%>    
            <%@include file="leftpane.jsp"%>  
        </div>
        <div id="page-wrapper">
            <div class="row ">
                <h3>Sending Letters To Over Pawning Customers</h3>
                <ul class="list-inline col-lg-12">  
                    <li class="col-lg-4">
                        <label>Pawn Types</label>
                        <div class="input-group">
                            <span class="input-group-addon"><input type="checkbox"/>All</span>
                            <select class="form-control input-sm">
                                <option>-Select-</option>
                                <option></option>
                            </select>                            
                        </div>
                    </li>
                    <li class="col-lg-4">
                        <label>Letter Types</label>
                        <div class="input-group col-lg-12">
                            <select class="form-control input-sm">
                                <option>-Select-</option>
                                <option></option>
                            </select>  
                        </div>                        
                    </li>                    
                    <li class="col-lg-4">
                        <label>Letter Sent Days</label>
                        <div class="input-group col-lg-12">
                            <select class="form-control input-sm">
                                <option>-Select-</option>
                                <option></option>
                            </select> 
                        </div>
                    </li>

                    <li>
                        <br>
                        <div class="btn-group btn-group-sm">
                            <a href="#" class="btn btn-default">Proceed</a>
                            <a href="#" class="btn btn-default">Settings</a>
                            <a href="#" class="btn btn-default">Print List</a>                        
                            <a href="#" class="btn btn-default">Print Letter</a> 
                        </div>
                    </li>
                </ul>
                <br>
                <div class="table-responsive col-lg-12">
                    <table class="table table-bordered table-hover table-condensed">
                        <thead>
                            <tr>
                                <td>pawn MFID</td>
                                <td>Ticket No</td>
                                <td>Name</td>
                                <td>Due Amount</td>
                                <td>Pawn Date</td>
                                <td>Last Pay Date</td>
                                <td>Letter 1</td>
                                <td>Letter 1 Date</td>
                                <td>Post</td>
                                <td>Stat:</td>
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
                                <td><center><input type="checkbox"></center></td>
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
</body>
</html>
