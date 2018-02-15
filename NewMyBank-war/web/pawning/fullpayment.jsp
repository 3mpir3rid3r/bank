<%-- 
    Document   : fullpayment
    Created on : Dec 17, 2014, 2:55:12 PM
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
        <link href="../css/metisMenu.css" rel="stylesheet" type="text/css"/>
        <link href="../css/metisMenu.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/sb-admin-2.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style>
            #content *{
                font-size-adjust: 0.52;
            }
        </style>
    </head>
    <!--sampoornayen ukas berima-->
    <body>
        <div id="wrapper">
            <%@include file="header.jsp"%>    
            <%@include file="leftpane.jsp"%>  
        </div>
        <div id="page-wrapper">
            <div class="row">                
                <h3>   උකස් සම්පූර්ණයෙන් බේරීම </h3>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="input-group col-lg-5" >
                                <span class="input-group-addon">තුන්ඩු අංකය :</span>
                                <input type="text" class="form-control convertSinhalaIskolaPotha">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">Search</button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <ul class="list-group col-lg-12" id="fontSize">
                        <li class="list-group-item">
                            <span class="badge">0000/00/00</span>
                            උකස් දිනය
                        </li>
                        <li class="list-group-item">
                            <span class="badge">0000/00/00</span>
                            අවසන් ගෙවු දිනය
                        </li>
                        <li class="list-group-item">
                            <span class="badge">0000/00/00</span>
                            කල්පිරෙන දිනය
                        </li>
                        <li class="list-group-item">
                            <span class="badge">00</span>
                            කුයිතාන්සි අංකය
                        </li>
                        <li class="list-group-item">
                            <span class="badge">00</span>
                            දින ගණන
                        </li>
                    </ul> 
                    <ul class="list-group col-lg-12" id="fontSize">
                        <li class="list-group-item">
                        <center>උකස් භණ්ඩ පිළිබද විස්තර</center>
                        </li>
                        <!--<li class="list-group-item">-->
                        <table class="table table-bordered table-hover ">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>උකස් භාන්ඩ</th>
                                    <th>කැරට් අගය</th>
                                    <th>ප්‍රමාණය</th>
                                    <th>වෙනත්</th>
                                </tr>                                
                            </thead>
                            <tbody height="100px">
                                <tr>
                                    <td>1</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>                               
                            </tbody>
                        </table>
                        <!--</li>-->
                        <!--<li class="list-group-item">-->
                        <div class="col-lg-6">භාණ්ඩ බර :<span>රු : 0.00</span>kg</div>
                        <div class="col-lg-6">භාණ්ඩ බර :<span>රු : 0.00</span>kg</div>
                        <!--</li>-->
                    </ul>
                </div>
                <!--\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\-->

                <!--............................-->
                <div class="col-lg-6">
                    <ul class="list-group col-lg-12" id="fontSize">
                        <li class="list-group-item">
                            අත්තිකරම් මුදල
                            <b><span class="pull-right">රු : 0.00</span></b>
                        </li>
                        <li class="list-group-item">
                            ඉතිරි මුදල
                            <b><span class="pull-right">රු : 0.00</span></b>
                        </li>
                        <li class="list-group-item">
                            පොලි අනුපාතය
                            <b><span class="pull-right">0.00 %</span></b>
                        </li>
                        <li class="list-group-item">
                            දිනට පොලිය
                            <b><span class="pull-right">රු : 0.00</span></b>
                        </li>
                        <li class="list-group-item">
                            ලිපි ගාස්තු
                            <b><span class="pull-right">රු : 0.00</span></b>
                        </li>
                        <li class="list-group-item"">
                            තැපැල් ගාස්තු
                            <b><span class="pull-right">රු : 0.00</span></b>
                        </li>
                        <li class="list-group-item">
                            වෙන්දේසි වියදම්
                            <b><span class="pull-right">රු : 0.00</span></b>
                        </li>
                        <li class="list-group-item">
                            මුළු මුදල
                            <b><span class="pull-right">රු : 0.00</span></b><br><br>
                            ගෙවූ මුදල
                            <b><span class="pull-right">රු : 0.00</span></b><br><br>
                            <button class="btn btn-default" >ගෙවන්න</button>
                        </li>
                    </ul>                
                </div>
            </div>
        </div>
    </body>
    <style type="text/css">
        #fontSize{
            font-size: 14px;
            font-weight: bold;
        }        
    </style>
</html>
