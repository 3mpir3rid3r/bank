<%-- 
    Document   : money_saving1
    Created on : Jan 27, 2015, 7:42:42 PM
    Author     : mmh
--%>

<%@page import="com.nbs.common.Alerts"%>
<%@page import="com.nbs.model.ActSectionsSub"%>
<%@page import="com.nbs.model.ActSectionsMain"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.VFindDatabnkDepDepositMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkDepDepositTransaction"%>
<%@page import="com.nbs.common.LogedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Section</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }
            .bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:128px;                
            }.bg-mainheight{
                height:410px;                
            }.bg-subheight{
                height:413px;                
            }
            .bg-pad{
                padding-right:0px;                
            }
        </style>
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
    <%    String alert = "";

        if (request.getParameter("mg") != null) {
            String mg = request.getParameter("mg");
            if ("error".equals(mg)) {
                alert = Alerts.warningAlert("Something Wrong", "You miss some Fields", "");
            } else if ("saved".equals(mg)) {
                alert = Alerts.successAlert("success", "Customer Successfully saved");
            } else if ("updated".equals(mg)) {
                alert = Alerts.successAlert("success", "Customer Successfully updated");
            }
        }
    %>
    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include file="../teller/teller_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include  file="../teller/teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>


            <%                    List<ActSectionsMain> allSection = null;
                if (session.getAttribute("allSection") != null) {
                    allSection = (List<ActSectionsMain>) session.getAttribute("allSection");

                }
            %>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Section
                        <small>Section</small> 
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i>Section</a></li>
                    </ol>
                </section>
                <%=alert%>
                <section class="content">
                    <div class="row bg-top">
                        <div class="col-md-9 bg-pad" >
                            <!--Section-->
                            <div class="box box-info bg-color" style="height: 420px">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="box-header">
                                            <h4 class="box-title">Section </h4>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="zTreeDemoBackground left">
                                                <ul id="treeDemo" class="ztree" style="width: auto;height:200px;">
                                                    <table class="table table-bordered table-hover" id="T1">
                                                        <tbody>
                                                            <tr>
                                                                <td width="10px"></td>
                                                                <th >Section ID</th>
                                                                <th >Section Name</th>
                                                                <th >Section Name(Eng)</th>

                                                            </tr> 
                                                            <%for (ActSectionsMain asm : allSection) {
                                                                    short id = asm.getNMainSectionID();
                                                                    String namesin = asm.getCMainSectionNameSin();
                                                                    String nameEng = asm.getCMainSectionNameUni();

                                                                    if (namesin == null) {
                                                                        namesin = "";
                                                                    }
                                                                    if (nameEng == null) {
                                                                        nameEng = "";
                                                                    }
                                                            %>
                                                            <tr>
                                                                <td></td>
                                                                <td class="convertSinhalaIskolaPotha"><%= id%></td>
                                                                <td class="convertSinhalaAmali"><%= namesin%></td>
                                                                <td class="convertSinhalaIskolaPotha"><%= nameEng%></td>

                                                            </tr>
                                                            <%}%>
                                                        </tbody>
                                                    </table>
                                                </ul>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <br>
                                            <form class="form-horizontal " method="post" action="../NewMainSectionServlet" >
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right ">Section name :</label>
                                                    <div class="col-md-10">
                                                        <input onkeyup="removeTags('csectionName')" autocomplete="off" required disabled class="form-control input-sm convertSinhalaAmali" type="text" name="csectionName" id="csectionName" value="">
                                                    </div>
                                                </div> 

                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right">Section Name(Eng) :</label>
                                                    <div class="col-md-10">
                                                        <input onkeyup="removeTags('csectionNameEng')"  autocomplete="off" required  disabled class="form-control input-sm convertSinhalaIskolaPotha"  type="text" name="csectionNameEng" id="csectionNameEng" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top " align="right"> 
                                                    <div class="col-lg-9" ></div>
                                                    <div class="col-md-3" >
                                                        <input onclick="activeTextField1();" type="button" class="btn btn-success " value="New"/>
                                                        <input onclick="removeTags('csectionName');removeTags('csectionNameEng');"id="btn1" disabled type="submit" class="btn btn-success " value="Save"/>
                                                    </div>
                                                </div> 
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--Sub Section-->
                            <form class="form-horizontal " method="post" action="../NewSubSectionServlet">
                                <div class="box box-info bg-color " style=" height:auto;max-height: 500px">
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="box-header">
                                                <h4 class="box-title">Sub Section </h4>
                                            </div>
                                            <div class="col-md-12">
                                                <br>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right ">Section Name :</label>
                                                    <div class="col-md-10">

                                                        <select   required class="form-control input-sm a convertSinhalaAmali" name="sectionID" id="sectionID" onclick="fillTable();" onkeypress="fillTable();" onchange="fillTable();" >
                                                            <option value="" style="display:none;"></option>
                                                            <%for (ActSectionsMain asm : allSection) {

                                                            %>
                                                            <option class="" value="<%= asm.getNMainSectionID()%>" ><%= asm.getCMainSectionNameSin()%></option>
                                                            <%}%>
                                                        </select>

                                                    </div>
                                                </div> 

                                                <div class="zTreeDemoBackground left" id="subSectionTable">

                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right ">Sub Section :</label>
                                                    <div class="col-md-10">
                                                        <input onkeyup="removeTags('csubSectionName')" autocomplete="off" required disabled class="form-control input-sm convertSinhalaAmali"  type="text" name="csubSectionName" id="csubSectionName" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right ">Sub Section(Eng) :</label>
                                                    <div class="col-md-10">
                                                        <input onkeyup="removeTags('csubSectionNameEng')" autocomplete="off" required disabled class="form-control input-sm convertSinhalaIskolaPotha"  type="text" name="csubSectionNameEng" id="csubSectionNameEng" value="">
                                                    </div>
                                                </div>


                                                <div class="form-group bg-top " align="right"> 
                                                    <div class="col-lg-9" ></div>
                                                    <div class="col-md-3" >
                                                        <input onclick="activeTextField2();" type="button" class="btn btn-success " value="New"/>
                                                        <input onclick="removeTags('csubSectionName');removeTags('csubSectionNameEng')" id="btn2" disabled type="submit" class="btn btn-success " value="Save"/>
                                                    </div>
                                                </div> 
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!--./right-box-->
                        <div class="col-md-3 " style="margin-top: 10px;height: 400px" >
                            <div class="panel box box-info bg-color bg-top">
                                <!--./body-->
                                <div class="box-body">
                                    <!--./row-->
                                    <div class="row">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>


                </section>
            </aside>

            <!--..............................-->
        </div>
        <!--.......wrapper end...................-->

    </body>

    <script type="text/javascript">
        function activeTextField1() {
            document.getElementById('csectionName').value = "";
            document.getElementById('csectionNameEng').value = "";
            document.getElementById('csectionName').removeAttribute("disabled");
            document.getElementById('csectionNameEng').removeAttribute("disabled");
            document.getElementById('btn1').removeAttribute("disabled");


        }
        function activeTextField2() {
            document.getElementById('csubSectionName').value = "";
            document.getElementById('csubSectionNameEng').value = "";
            document.getElementById('csubSectionName').removeAttribute("disabled");
            document.getElementById('csubSectionNameEng').removeAttribute("disabled");
            document.getElementById('btn2').removeAttribute("disabled");
        }
    </script>
    <script type="text/javascript">
        function fillTable() {
            var sectionId = document.getElementById('sectionID').value;

            url = "../GetSubsectionTableServlet";
            $.post(url,
                    {sectionId: sectionId},
                    function (result) {

                        $("#subSectionTable").html(result + "<br>");
                    }

            );
        }

    </script>
    <script src = "../js/jquery.min.js" type = "text/javascript" ></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
    <script src="../js/bootbox.js" type="text/javascript"></script>
    <script src="../js/bootbox.min.js" type="text/javascript"></script>
    <script src="../js/bootbox.min.js" type="text/javascript"></script>
    <script src="../js/my.js" type="text/javascript"></script>


</html>