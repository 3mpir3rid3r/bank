<%-- 
    Document   : findPawnDetails
    Created on : Dec 19, 2014, 10:32:47 AM
    Author     : nuwan
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
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <script src="../js/Ajax.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/sb-admin-2.js" type="text/javascript"></script>
        <link href="../css/magicsuggest-min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <script src="../js/magicsuggest-min.js" type="text/javascript"></script>
        <style>
            .row-heght{
                height: 30px;

            }
            .my-input{
                /*                      color:red;*/
                height:25px;
            } 
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="pawning_header.jsp"%>    
            <%@include file="pawning_slidebar.jsp"%>  
        </div>
        <div id="page-wrapper" style="background-color: #f8cc71">
            <div class="row" >                
                <h3>   උකස් විස්තර සොයන්න </h3>
                <div class="col-lg-12">
                    <div class="panel panel-default my-panel" style="background-color: #f8cc71">
                        <div class="panel-body">
                            <div class="col-lg-12" style="padding-left: 25px">
                                <ul class="list-group col-lg-12" id="fontSize" style="height: 300px">
                                    <!--<li class="list-group-item">-->
                                    <table class="table table-bordered table-hover ">
                                        <thead>
                                            <tr>
                                                <th>උකස් භාන්ඩ</th>
                                                <th>උකස් භාන්ඩ</th>
                                            </tr>                                
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td></td>
                                            </tr> 
                                            <tr>
                                                <td>6</td>
                                                <td></td>
                                            </tr> 
                                            <tr>
                                                <td>7</td>
                                                <td></td>
                                            </tr> 
                                            <tr>
                                                <td>8</td>
                                                <td></td>
                                            </tr> 
                                        </tbody>
                                    </table>
                                </ul>
                            </div>


                            <div class="col-lg-12" style="padding-left: 0px;">
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="inputPassword3" class="col-sm-2 control-label">නම(English)</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control my-input convertSinhalaIskolaPotha" id="inputPassword3" placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword3" class="col-sm-2 control-label">නම(සිංහල)</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control my-input convertSinhalaIskolaPotha" id="inputPassword3" placeholder="නම">  
                                        </div>
                                        <button type="button" class="btn btn-default" style="margin-top: -14px">ඇතුලත් කරන්න</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
