<%-- 
    Document   : FindPawnDetailsPri
    Created on : Dec 19, 2014, 11:44:08 AM
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
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <link href="../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../font-awesome-4.1.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <script src="../js/Ajax.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/sb-admin-2.js" type="text/javascript"></script>
        <link href="../css/magicsuggest-min.css" rel="stylesheet" type="text/css"/>
        <script src="../js/magicsuggest-min.js" type="text/javascript"></script>
        <style type="text/css"> 
            .my-input{
                /*                      color:red;*/
                height:25px;
            } 

            .my-panel{

                height: 130px;
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
        <div id="page-wrapper" >
            <div class="row">                
                <h3><strong>   Find Pawn Details </strong></h3>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label pull-left">Pawn Ticket No</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control my-input convertSinhalaIskolaPotha" id="inputPassword3" placeholder="New Pawn Type">
                                    </div>
                                    <div class="col-sm-1">
                                        <input type="submit" id="inputPassword3" placeholder="New Pawn Type" value="Get Details">
                                    </div>
                                    <div class="col-sm-1 pull-right">
                                        <input type="submit"  id="inputPassword3" placeholder="New Pawn Type" value="Print">
                                    </div>
                                </div>
                            </form>

                            <div class="col-lg-12">
                                <ul class="list-group col-lg-12" id="fontSize" style="height: 200px;border: 1px solid #d7dddd">
                                    <li class="list-group-item" ></li>

                                </ul> 

                            </div>
                            <div class="col-lg-12">
                                <ul class="list-group col-lg-12" id="fontSize" style="height: 200px;border: 1px solid #d7dddd">
                                    <li class="list-group-item" ></li>

                                </ul> 

                            </div>
                        </div>
                    </div>
                </div>



            </div>
        </div>
    </body>
</html>
