<%-- 
    Document   : creditor_debtor
    Created on : Jan 26, 2015, 10:01:21 AM
    Author     : Kalana
--%>
<%@page import="com.nbs.common.Alerts"%>
<%@page import="com.nbs.common.CrDrTable"%>
<%@page import="java.util.AbstractMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller | Journal CrDr</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>
        <link href="../css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .bg-color{
                background-color: #e7f0f7;
            }
            .bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:120px;                
            }
            .bg-top2{
                margin-top: -20px;                
            }
            .bg-panel{
                margin-bottom: -5px;
                background:#367fa9;
            }
            .bg-pad{
                padding-right: 0px;
            }
            /*---------------------------------------------------------------------*/
            div.zTreeDemoBackground {width:auto;height:auto;text-align:left;}
            ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;}
            ul.log {border: 1px solid #617775;background: #f0f6e4;width:300px;height:170px;overflow: hidden;}
            ul.log.small {height:45px;}
            ul.log li {color: #666666;list-style: none;padding-left: 10px;}
            ul.log li.dark {background-color: #E3E3E3;}
            /*------------------------------------------------------------------------*/
            .bg-color{
                background-color: #e7f0f7;
            }.bg-top{
                margin-top: -10px;
            }
            .bg-searchheight{
                height:128px;                
            }
        </style>
    </head>
    <body class="skin-blue  pace-done fixed" style="background-image: linear-gradient(#54b4eb, #2fa4e7 60%, #1d9ce5)">

        <!--........header.....-->
        <%@include  file="teller_header.jsp" %>

        <%
            request.getSession().removeAttribute("pageId");
            String title = "";
            String subHead = "Journal CrDr";
            String indexEnc = "";
            String index = "";
            String tHead = "";
            if (request.getParameter("index") != null) {
                indexEnc = request.getParameter("index");
                request.getSession().setAttribute("indexenc", indexEnc);
                index = Security.decrypt(indexEnc).replace(" ", "+");
                if ("114".equals(index)) {
                    title = "වෙනත් ලැබීම්";
                    tHead = "බැර";
                } else if ("115".equals(index)) {
                    title = "වෙනත් ගෙවීම්";
                    tHead = "හර";
                } else if ("116".equals(index)) {
                    title = "හර සටහන්";
                    tHead = "හර";
                } else if ("117".equals(index)) {
                    title = "බැර සටහන්";
                    tHead = "බැර";
                }
            } else if (request.getSession().getAttribute("indexenc") != null) {
                index = Security.decrypt(request.getSession().getAttribute("indexenc").toString().replace(" ", "+"));
                if ("114".equals(index)) {
                    title = "වෙනත් ලැබීම්";
                } else if ("115".equals(index)) {
                    title = "වෙනත් ගෙවීම්";
                } else if ("116".equals(index)) {
                    title = "හර සටහන්";
                } else if ("117".equals(index)) {
                    title = "බැර සටහන්";
                }
            }
            if (request.getParameter("index") == null && request.getSession().getAttribute("indexenc") == null) {
                response.sendRedirect("index.jsp");

            }
            String alert = "";
            if (request.getParameter("alert") != null) {
                if ("success".equals(Security.decrypt(request.getParameter("alert").replace(" ", "+")))) {
                    alert = Alerts.successAlert("Success !", "It's saved successfully");
                } else if ("list".equals(Security.decrypt(request.getParameter("alert").replace(" ", "+")))) {
                    alert = Alerts.warningAlert("Error", "The creditor table is empty", "");
                }
            }
        %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside id="content" class="right-side">
                <section class="content-header" >
                    <h1>
                        Teller -
                        <small><%=subHead%></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Teller</a></li>
                        <li><a href="#"><%=subHead%></a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <%
                    String branchName = "";
                    String cDescription = "";
                    String cReceiptNo = "";
                    String dTrnDate = "";
                    String cChequeNo = "";
                    String dChequeDate = "";
                    String cCustomerName = "";
                    String cRemarks = "";
                    String cFullName = "";
                    String acc = "";
                    String sub = "";
                    int pkOfAcc4Id = 0;
                    int pkOfAcc4 = 0;
                    int pkOfCusMaster = 0;

                    if (request.getSession().getAttribute("branch") == null) {
                        response.sendRedirect("../BranchSession?page=creditor_debtor.jsp");
                    } else {
                        ActSectionsSub bankBranch1 = (ActSectionsSub) request.getSession().getAttribute("branch");
                        branchName = bankBranch1.getCSubSectionNameUni();
                    }

                    if (request.getParameter("act4") != null) {
                        pkOfAcc4 = Integer.parseInt(Security.decrypt(request.getParameter("act4").replace(" ", "+")));
                        request.getSession().setAttribute("act4", pkOfAcc4);
                    }
                    if (request.getParameter("des") != null) {
                        //System.out.println(cDescription);
                        cDescription = Security.decrypt(request.getParameter("des").replace(" ", "+"));
                        request.getSession().setAttribute("cDescription", cDescription);
                    }
                    if (request.getSession().getAttribute("cDescription") != null) {
                        cDescription = request.getSession().getAttribute("cDescription").toString();
                    }
//                    if (request.getSession().getAttribute("act4") != null) {
//                        pkOfAcc4 = Integer.parseInt(request.getSession().getAttribute("act4").toString());
//                    }

                    if (request.getParameter("cid") != null) {
                        pkOfCusMaster = Integer.parseInt(Security.decrypt(request.getParameter("cid").replace(" ", "+")));
                    }

                    if (request.getParameter("cname") != null) {
                        cFullName = Security.decrypt(request.getParameter("cname").replace(" ", "+"));
                    }
                    if (request.getParameter("act4Id") != null) {
                        pkOfAcc4Id = Integer.parseInt(Security.decrypt(request.getParameter("act4Id").replace(" ", "+")));
                    }
                    if (request.getParameter("sub") != null) {
                        sub = Security.decrypt(request.getParameter("sub").replace(" ", "+"));
                        request.getSession().setAttribute("sub", sub);
                    }
                    if (request.getParameter("acc") != null) {
                        acc = Security.decrypt(request.getParameter("acc").replace(" ", "+"));
                    }
                    if (request.getSession().getAttribute("CrDr") != null) {
                        Map<Integer, String> m = (Map<Integer, String>) request.getSession().getAttribute("CrDr");

                        cReceiptNo = (String) m.get(2);
                        dTrnDate = (String) m.get(3);
                        cChequeNo = (String) m.get(4);
                        dChequeDate = (String) m.get(5);
                        cCustomerName = (String) m.get(6);
                        cRemarks = (String) m.get(7);
                    }

                %>
                <!--akasaye dura gimhanaye-->
                <%=alert%>
                <section class="content">
                    <div class="row bg-top">
                        <div class="col-md-12">
                            <div class="panel box box-info bg-color">
                                <!--./body-->
                                <div class="box-body bg-mainheight">
                                    <div class="panel panel-default bg-color">
                                        <div class="panel-heading" style="font-size: 18px;">
                                            මූලික තොරතුරු - <%=title%>
                                        </div>
                                        <form class="form-horizontal bg-top" method="get" action="../SaveCredtorServlet" onsubmit="create(this);
                                                return false;">
                                            <input type="hidden" value="<%=index%>" id="index" name="index">
                                            <div class="panel-body" style="margin-bottom: 0px;padding-top: 30px;">
                                                <div class="form-group">
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">අංශය  :</label>
                                                    <div class="col-md-4">
                                                        <input type="text" name="branch" class="form-control input-sm" value="<%=branchName%>" disabled="">                                                                                    
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">ගනුදෙනු අංකය :</label>
                                                    <div class="col-md-4">
                                                        <input type="text" disabled="" class="form-control input-sm" >                                                                             
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">හර ගිණුම :</label>
                                                    <div class="col-md-4">
                                                        <div class="input-group">
                                                            <input type="hidden" value="<%=pkOfAcc4%>" id="act4" name="act4">
                                                            <input type="text" class="form-control input-sm" value="<%=cDescription%>" id="cDescription" name="cDescription">
                                                            <span class="input-group-addon input-sm" ><a href="#" class="btn-block" onclick="goCrDr('1')">Search</a></span>
                                                        </div>                                                                                
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px" >ලදුපත් අංකය  :</label>
                                                    <div class="col-md-4">
                                                        <input type="text" name="cReceiptNo" id="cReceiptNo" class="form-control input-sm" value="<%=cReceiptNo%>">                                                                                                                                                             
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">ගණුදෙණු දිනය :</label>
                                                    <div class="col-md-2">
                                                        <input type="date" name="dTrnDate" id="dTrnDate" class="form-control input-sm" value="<%=dTrnDate%>">                                                                             
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">චෙක්පත් අංකය :</label>
                                                    <div class="col-md-2">
                                                        <input type="text" name="cChequeNo" id="cChequeNo" class="form-control input-sm" value="<%=cChequeNo%>">                                                                             
                                                    </div>
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">චෙක්පත් දිනය  :</label>
                                                    <div class="col-md-2">
                                                        <input type="date" name="dChequeDate" id="dChequeDate" class="form-control input-sm" value="<%=dChequeDate%>">                                                                                                                                                             
                                                    </div>
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px">ගනුදෙනුකරුගේ නම :</label>
                                                    <div class="col-md-10">
                                                        <input type="text" class="form-control input-sm" value="<%=cCustomerName%>" id="cCustomerName" name="cCustomerName">
                                                    </div>                                                    
                                                </div>
                                                <div class="form-group bg-top">
                                                    <label class="col-sm-2 input-sm text-right" style="font-size: 13px"> සටහන  :</label>
                                                    <div class="col-md-10">
                                                        <textarea style="min-width: 870px;max-width: 870px; min-height: 140px;" class="form-control input-sm" name="cRemarks" id="cRemarks"><%=cRemarks%></textarea>
                                                    </div>                                                    
                                                </div>
                                                <div class="panel panel-default bg-color" style="margin-left: -15px;margin-right: -15px;">
                                                    <div class="panel-heading" style="font-size: 18px;">
                                                        බැර ගිණුම් විස්තර
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group" style="margin-bottom: 40px;">
                                                        <input type="hidden" value="<%=pkOfAcc4Id%>" id="pkOfAcc4Id" name="pkOfAcc4Id">                                                        
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control input-sm" value="<%=acc%>" id="acc">
                                                                <span class="input-group-addon input-sm"><a class="btn-block" href="#" onclick="goCrDr('2')">Search</a></span>
                                                            </div>                                                     
                                                        </div>                                                     
                                                        <div class="col-md-4">
                                                            <input type="text" class="form-control input-sm" value="<%=sub%>" id="sub">
                                                        </div>                                                    
                                                        <div class="col-md-3">
                                                            <input type="text" class="form-control input-sm" placeholder="0.00" id="bera">
                                                        </div>                                                    
                                                        <div class="col-md-1">
                                                            <input type="button" class="btn btn-primary btn-sm" value="Add" onclick="addRow('T')">
                                                        </div>                                                    
                                                    </div>
                                                    <div class="zTreeDemoBackground left" style="margin-top: -30px;">
                                                        <ul id="treeDemo" class="ztree" style="width: auto;height:200px;">
                                                            <table class="table table-bordered table-hover" id="T">
                                                                <tbody>
                                                                    <tr>
                                                                        <td width="10px"></td>
                                                                        <th>ID</th>
                                                                        <th>ගිණුම් කේතය</th>
                                                                        <th>විස්තරය </th>
                                                                        <th><%=tHead%> </th>
                                                                    </tr> 
                                                                    <%
                                                                        if (request.getSession().getAttribute("list") != null) {
                                                                            List<CrDrTable> cdtl = (List<CrDrTable>) request.getSession().getAttribute("list");
                                                                            if (cdtl != null) {
                                                                                for (CrDrTable cdt : cdtl) {
                                                                    %>
                                                                    <tr>
                                                                        <td><a  class="btn btn-danger btn-sm" href="../CrDrSearchServlet?view=delete&id=<%=cdt.getRow1()%>&pageId=1">Delete</a></td>
                                                                        <td><%=cdt.getRow1()%></td>
                                                                        <td><%=cdt.getRow2()%></td>
                                                                        <td><%=cdt.getRow3()%></td>
                                                                        <td><%=cdt.getRow4()%></td>
                                                                    </tr>
                                                                    <%
                                                                                }
                                                                            }
                                                                        }
                                                                    %>
                                                                </tbody>
                                                            </table>
                                                        </ul>
                                                    </div> 
                                                </div>
                                            </div>
                                            <div class="panel-footer" style="height: 50px;">                                            
                                                <div class="pull-right">
                                                    <button type="button" class="btn btn-info btn-sm">New</button>
                                                    <button type="submit" class="btn btn-success btn-sm">Save</button>
                                                    <button type="reset" class="btn btn-warning btn-sm ">Change</button>
                                                </div>
                                            </div>
                                        </form>
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

        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script> 


        <script type="text/javascript">
//                                                                function searchText(e, text) {
//                                                                if (e.keyCode == 1') { 
//                                                                        alert("asdasd");
//                                                                        window.location.href = "teller/view_acc4.jsp";
//                                                                }
//                                                                }

                                                                function addRow(tableID) {

                                                                    var cell2 = document.getElementById('pkOfAcc4Id').value;
                                                                    var cell3 = document.getElementById('acc').value;
                                                                    var cell4 = document.getElementById('sub').value;
                                                                    var cell5 = document.getElementById('bera').value;
                                                                    window.location = '../CrDrSearchServlet?view=addRow&cell2=' + cell2 + '&cell3=' + cell3 + '&cell4=' + cell4 + '&cell5=' + cell5 + '&pageId=1';
                                                                }
                                                                function deleteRow(tableID) {
                                                                    try {
                                                                        var table = document.getElementById(tableID);
                                                                        var rowCount = table.rows.length;
                                                                        for (var i = 0; i < rowCount; i++) {
                                                                            var row = table.rows[i];
                                                                            var chkbox = row.cells[0].childNodes[0];
                                                                            if (null != chkbox && true == chkbox.checked) {
                                                                                table.deleteRow(i);
                                                                                rowCount--;
                                                                                i--;
                                                                            }
                                                                        }
                                                                    } catch (e) {
                                                                        alert(e);
                                                                    }
                                                                }
                                                                function create(f) {

                                                                    var bool = new Boolean();
                                                                    bool = true;
                                                                    if (event.keyCode === 13) {
                                                                        alert("ev");
                                                                    }
//                                                            var get1A = new Array();
//                                                            var get2A = new Array();
//                                                            var get3A = new Array();
//                                                            var get4A = new Array();
//                                                            var t = document.getElementById('T');
//                                                            var r = t.rows.length - 1;
//                                                            for (var i = 1; i < r + 1; i++) {
//                                                                var text = t.rows.item(i).cells;
//                                                                get1A.push(text[1].firstChild.data);
//                                                                get2A.push(text[2].firstChild.data);
//                                                                get3A.push(text[3].firstChild.data);
//                                                                get4A.push(text[4].firstChild.data);
//                                                            }
//                                                            alert(get2A);
//                                                            $("#get1").val(get1A);
//                                                            $("#get2").val(get2A);
//                                                            $("#get3").val(get3A);
//                                                            $("#get4").val(get4A);
////                                                            bool = false;
                                                                    if (bool) {
                                                                        document.forms["f"].submit();
                                                                    }
                                                                }

                                                                function goCrDr(go) {
                                                                    var cDescription = document.getElementById('cDescription').value;
                                                                    var cReceiptNo = document.getElementById('cReceiptNo').value;
                                                                    var dTrnDate = document.getElementById('dTrnDate').value;
                                                                    var cChequeNo = document.getElementById('cChequeNo').value;
                                                                    var dChequeDate = document.getElementById('dChequeDate').value;
                                                                    var cCustomerName = document.getElementById('cCustomerName').value;
                                                                    var cRemarks = document.getElementById('cRemarks').value;
                                                                    if (go === '1') {
                                                                        window.location = '../CrDrSearchServlet?view=viewacc1&pageId=1';
                                                                        ;
                                                                    }
                                                                    if (go === '2') {
                                                                        window.location = '../CrDrSearchServlet?view=viewacc2&cDescription=' + cDescription + '&cReceiptNo=' + cReceiptNo + '&dTrnDate=' + dTrnDate + '&cChequeNo=' + cChequeNo + '&dChequeDate=' + dChequeDate + '&cCustomerName=' + cCustomerName + '&cRemarks=' + cRemarks + '&pageId=1';
                                                                    }

                                                                }

        </script>
    </body>
</html>
