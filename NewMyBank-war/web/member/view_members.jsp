<%-- 
    Document   : view_members
    Created on : May 15, 2015, 10:59:44 AM
    Author     : mmh
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.model.BnkRefMemberAreas"%>
<%@page import="com.nbs.model.MemMemberShipMaster"%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="com.nbs.model.BnkCustomerMaster"%>
<%@page import="com.nbs.controller.get.GetViewCustomerServlet"%>
<%@page import="com.nbs.common.Security"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member | View Customers</title>

        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="../font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/> 
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/> 
        <link href="../css/newCss.css" rel="stylesheet" type="text/css"/>

    </head>

    <body class="skin-blue  pace-done fixed">


        <!--........header.....-->
        <%@include file="../teller/teller_header.jsp" %>
        <!--..............................-->

        <!--..........wrapper...........-->
        <div class="wrapper row-offcanvas row-offcanvas-left"> 
            <!--..............left-side.............-->
            <aside class="left-side sidebar-offcanvas" style="min-height: 2000px;">
                <!-- sidebar: style can be found in sidebar.less -->
                <%@include file="../teller/teller_sidebar.jsp" %>
                <!-- /.sidebar -->
            </aside>
            <!--................................-->

            <!--...........right-side.........-->
            <aside class="right-side">
                <section class="content-header" >
                    <h1>
                        Member -
                        <small>View Member</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.jsp"><i class="fa fa-home"></i> Member</a></li>
                        <li><a href="#">View Member</a></li>
                        <li class="active"></li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row bg-top" style="margin-bottom:-20px">
                        <div class="col-md-12">
                            <div class="box box-info bg-color" style="margin-bottom:10px;margin-top: -10px">
                                <div class="box-body"><div class="row" >
                                        <form action="../GetViewMemberServlet" method="post">
                                            <div class="col-md-12">  
                                                <div class="form-group">
                                                    <%        
                                                        String tip = "";
                                                        String checkBox = (String) request.getParameter("chekOn");
                                                        String areaId = (String) request.getParameter("areaId");

                                                        if (request.getParameter("tip") != null) {
                                                            tip = (String) request.getParameter("tip");
                                                        }
                                                        if (areaId == null) {
                                                            areaId = "-1";
                                                        }
                                                        if (checkBox != null) {
                                                            checkBox = "selected";
                                                        }
                                                    %>
                                                    <!--<div class="input-group">-->
                                                    <div class="input-group col-lg-12" style="margin-left: +15px;">
                                                        <span class="input-group-addon"><input   type="checkbox" name="allAreas"> All Area</span>
                                                        <span class="input-group-addon"></span>

                                                        <%
                                                            List<BnkRefMemberAreas> bnkRefMemberAreas = (List<BnkRefMemberAreas>) session.getAttribute("BnkRefMemberAreas");

                                                        %>
                                                        <div class="col-lg-12">

                                                            <div class="form-group bg-top">

                                                                <div class="col-md-3">
                                                                    <select class="form-control convertSinhalaIskolaPotha " name="nCivilStatusID" id="nCivilStatusID">
                                                                        <option  value="-1" style="display:none;"></option>

                                                                        <%if (bnkRefMemberAreas != null) {%>
                                                                        <% for (BnkRefMemberAreas areas : bnkRefMemberAreas) {%>

                                                                        <%if (Short.parseShort(areaId) == areas.getNMemAreaID()) {%>
                                                                        <option selected="true" value="<%= areas.getNMemAreaID()%>"><label class="control-label convertSinhalaIskolaPotha"><%= areas.getCMemAreaName()%>  </label></option>

                                                                        <%} else {%>
                                                                        <option value="<%= areas.getNMemAreaID()%>"><label class="control-label convertSinhalaIskolaPotha"><%= areas.getCMemAreaName()%>  </label></option>

                                                                        <% }
                                                                                }
                                                                            }%>
                                                                    </select>
                                                                </div>                                                        
                                                                <div class="col-md-7" >
                                                                    <input style="" type="text" class="form-control convertSinhalaIskolaPotha" name="memberTip" id="memberTip" value="<%= tip%>" onclick="this.style.borderColor = ''">
                                                                </div>
                                                                <div class="col-md-1 " >
                                                                    <button class="btn btn-default" type="submit"><span class="fa fa-search"></span>Search</button>
                                                                </div>
                                                            </div>                                                        
                                                            <span class="input-group-btn">
                                                            </span>
                                                        </div>
                                                        <!--</div>-->
                                                    </div>
                                                </div>
                                            </div>

                                        </form>
                                        <div class="col-md-12 bg-top" style="  ">
                                            <table  class="table table-bordered table-hover">
                                                <tr style="background-color: #5bc0de">
                                                    <th class="text-center" width="100px">ID</th>
                                                    <th class="text-center" width="50px">Mem. No</th>
                                                    <th class="text-center" width="100px">Add Date</th>
                                                    <th class="text-center" width="100px">NIC</th>
                                                    <th class="text-center" width="250px" >Full Name</th>
                                                    <th  class="text-center" >Address</th>
                                                    <th  class="text-center" width="50px" >No Of Shares</th>
                                                    <th class="text-center" width="100px">Telephone</th>
                                                    <th class="text-center" width="60px"></th>
                                                </tr>
                                                <tbody>
                                                    <%
                                                        if (request.getSession().getAttribute("allMembers") != null) {
                                                            List<MemMemberShipMaster> masters = (List<MemMemberShipMaster>) request.getSession().getAttribute("allMembers");
                                                            if (masters.size() > 0) {
                                                                for (MemMemberShipMaster master : masters) {
                                                    %>
                                                    <tr>
                                                        <%
                                                            String nicNo = "";
                                                            String addedDate = "";
                                                            String fullName = "";
                                                            String tpNp = "";

                                                            String add1 = "";
                                                            String add2 = "";
                                                            String add3 = "";
                                                            String add4 = "";
                                                            String memNo = "";
                                                            int noOfShere = 0;
                                                            if (master.getCNICNo() == null) {
                                                                nicNo = "";
                                                            } else {
                                                                nicNo = master.getCNICNo();
                                                            }

                                                            if (master.getDAddDate() == null) {
                                                                addedDate = "";
                                                            } else {
                                                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                                                addedDate = sdf.format(master.getDAddDate());

                                                            }

                                                            if (master.getCFullName() == null) {
                                                                fullName = "";
                                                            } else {
                                                                fullName = master.getCFullName();
                                                            }

                                                            if (master.getCPTelNo1() == null) {
                                                                tpNp = "";
                                                            } else {
                                                                tpNp = master.getCPTelNo1();
                                                            }

                                                            if (master.getCPAddLine1() == null) {
                                                                add1 = "";
                                                            } else {
                                                                add1 = master.getCPAddLine1();
                                                            }

                                                            if (master.getCPAddLine2() == null) {
                                                                add2 = "";
                                                            } else {
                                                                add2 = master.getCPAddLine2();
                                                            }

                                                            if (master.getCPAddLine3() == null) {
                                                                add3 = "";
                                                            } else {
                                                                add3 = master.getCPAddLine3();
                                                            }

                                                            if (master.getCPAddLine4() == null) {
                                                                add4 = "";
                                                            } else {
                                                                add4 = master.getCPAddLine4();
                                                            }
                                                            if (master.getNNoOfShares() == null) {
                                                                noOfShere = 0;
                                                            } else {
                                                                noOfShere = master.getNNoOfShares();
                                                            }
                                                            if (master.getCMemberShipNo() == null) {
                                                                memNo = "";
                                                            } else {
                                                                memNo = master.getCMemberShipNo();
                                                            }

                                                        %>
                                                        <td class="convertSinhalaIskolaPotha"><%=master.getNMemberID()%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%= memNo%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%= addedDate%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%= nicNo%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%= fullName%></td>
                                                        <td class="convertSinhalaAmali" ><%= add1 + " " + add2 + " " + add3 + " " + add4%></td>
                                                        <td class="text-right convertSinhalaIskolaPotha"><%= noOfShere%></td>
                                                        <td class="convertSinhalaIskolaPotha"><%= tpNp%></td>
                                                        <td align="center">
                                                            <a href="../LoadViewMemberServlet?memId=<%=master.getNMemberID()%>" class="btn btn-info btn-xs">Select</a>
                                                        </td>

                                                        <%
                                                                    }
                                                                }
                                                            }
                                                        %>
                                                        <!--<a href="../GetterDepositLoanDetailsServlet?identityEncript=1&accountValue=2&accountNumber" class="btn btn-default btn-sm">Select</a>-->


                                                    </tr>

                                                </tbody>
                                            </table>
                                            <!--</ul>-->
                                            <!--</div>-->
                                            <%
                                                session.removeAttribute(
                                                        "allMembers");
                                            %>
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
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>        
    </body>
</html>
