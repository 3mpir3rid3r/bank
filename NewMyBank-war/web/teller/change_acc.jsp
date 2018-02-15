<%-- 
    Document   : change_acc
    Created on : Apr 8, 2015, 10:16:52 PM
    Author     : mmh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | තැම්පත් ගිණුමේ වර්ගය වෙනස් කිරීම </title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>

        <style type="text/css">
            /*---------------------------------------------------------------------*/
            div.zTreeDemoBackground {width:auto;height:auto;text-align:left;}
            /*
            */ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;}
            ul.log {border: 1px solid #617775;background: #f0f6e4;width:300px;height:170px;overflow: hidden;}
            ul.log.small {height:45px;}
            ul.log li {color: #666666;list-style: none;padding-left: 10px;}
            ul.log li.dark {background-color: #E3E3E3;}
            /*------------------------------------------------------------------------*/
            .bg-color{
                background-color: #e7f0f7;
            }.bg-color2{
                background-color: #317eac;
            }.bg-top{
                margin-top: -10px;                
            }
            .bg-pad{
                padding-right:0px;                
            }
        </style>
    </head>
    <body class="skin-blue fixed pace-done">

        <div class="pace  pace-inactive"><div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
                <div class="pace-progress-inner"></div>
            </div>
            <div class="pace-activity"></div>
        </div>

        <!--........header.....-->
        <%@include file="teller_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include  file="teller_sidebar.jsp"%>
                <!-- /.sidebar -->
            </aside>
        </div>
        <aside class="right-side">
            <section class="content-header" >
                <h1>
                    තැම්පත් ගිණුමේ වර්ගය වෙනස් කිරීම 
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                    <li class="active">තැම්පත් ගිණුමේ වර්ගය වෙනස් කිරීම </li>
                </ol>
            </section>
            <section class="content">
                <div class="row bg-searchheight bg-top">
                    <div class="col-md-9 bg-searchheight bg-pad" >
                        <div class="box box-info bg-color" style=" height:210px">
                            <div class="box-body">
                                <div class="row">

                                </div>
                            </div>
                        </div>                                
                    </div>
                </div>
            </section>
        </aside>

    </body>
</html>
