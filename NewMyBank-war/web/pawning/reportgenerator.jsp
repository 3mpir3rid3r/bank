<%-- 
    Document   : reportgenerator
    Created on : Dec 18, 2014, 11:57:18 AM
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
            <div class="row">
                <h3><span class="glyphicon glyphicon-print active"></span>Report Generator</h3>
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <select class="form-control">
                                <option>Select</option>
                                <option></option>
                            </select>
                            <br>
                            <div class="list-group"><b>
                                    <a href="#" class="list-group-item">* |Cras justo odio</a>
                                    <a href="#" class="list-group-item">* |Dapibus ac facilisis in</a>
                                    <a href="#" class="list-group-item">* |Morbi leo risus</a>
                                    <a href="#" class="list-group-item">* |Morbi leo risus</a>
                                    <a href="#" class="list-group-item">* |Morbi leo risus</a>
                                    <a href="#" class="list-group-item">* |Morbi leo risus</a>
                                    <a href="#" class="list-group-item">* |Morbi leo risus</a>
                                    <a href="#" class="list-group-item">* |Morbi leo risus</a>
                                </b>
                            </div>                            
                        </div>
                    </div>
                </div>
                <!--..........................-->  
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <label class="text-success">Report Type</label>
                                    <center>                                        
                                        <label class="radio-inline col-lg-4">
                                            <input type="radio" name="a"/>Detail Report
                                        </label>
                                        <label class="radio-inline col-lg-3">
                                            <input type="radio" name="a"/>Summary Report
                                        </label>
                                        <label class="radio-inline col-lg-3">
                                            <input type="radio" name="a"/>Audit Report
                                        </label>
                                    </center>
                                </div>
                            </div>
                            <!--.....................................-->
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <label class="text-success">Customer Category</label>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon"><input type="checkbox"/>All</span>
                                                <select class="form-control input-sm">
                                                    <option>-Select-</option>
                                                    <option></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <input class="form-control input-sm" type="text" placeholder="Type Customer Name">                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--.............................-->
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <label class="text-success">Report Selection Category</label>
                                            <div class="input-group">
                                                <span class="input-group-addon"><input type="checkbox"/>All</span>
                                                <select class="form-control input-sm">
                                                    <option>-Select-</option>
                                                    <option></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <label class="text-success">Society Name</label>
                                            <div class="input-group">
                                                <span class="input-group-addon"><input type="checkbox"/>All</span>
                                                <select class="form-control input-sm">
                                                    <option>-Select-</option>
                                                    <option></option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>                                    
                            </div>
                            <!--..................................-->
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="col-lg-5">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="b" value="option1">
                                                No Data Range
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="b" value="option1">
                                                With Data Range   
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="b" value="option1">
                                                Selected Month and Year Only
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="b" value="option1">
                                                Selected Month and Day Only
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-5">
                                        <div class="form-group">
                                            <div>
                                                <input class="form-control input-sm" id="fulName"  type="date" >
                                            </div><br>
                                            <div>
                                                <input class="form-control input-sm" type="date">
                                            </div>
                                        </div> 
                                    </div>
                                </div>
                            </div>
                            <!-------------------------------->
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <label class="text-success">Periodic Reports</label>
                                    <center>
                                        <label class="radio-inline col-lg-4">
                                            <input type="radio" name="c">Amount
                                        </label>
                                        <label class="radio-inline col-lg-4">
                                            <input type="radio" name="c">Time
                                        </label>
                                    </center>
                                </div>
                            </div>
                            <!------------------------------------>
                        </div> 
                        <div class="panel-footer">
                            <div class="btn-group btn-group-justified">
                                <a href="#" class="btn btn-default">Report Manager</a>
                                <a href="#" class="btn btn-default">Print</a>
                                <a href="#" class="btn btn-default">Close</a>
                            </div>                            
                        </div>                        
                    </div>
                </div>
            </div>            
        </div>
    </body>
</html>
