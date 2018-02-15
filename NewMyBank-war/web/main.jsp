<%-- 
    Document   : index
    Created on : Jan 11, 2015, 12:58:30 PM
    Author     : Kalana
--%>

<%@page import="com.nbs.model.ActSectionsSub"%>
<%@page import="com.nbs.model.GenUser"%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/screen.css" rel="stylesheet" type="text/css"/>

        <title>Home Page</title>
    </head>
    <body style="background: url(./img/teller/login_background.jpg)">
        <br>
        <% ActSectionsSub bankBranch = (ActSectionsSub) session.getAttribute("branch");%>
        <% GenUser user = (GenUser) session.getAttribute("user");%>
        <table>
            <tr>
                <td style="padding-left: 100px;"><label style="color: white; font-family: sans-serif;font-size: 50px;font-style: italic;">nbsERP-Banking Module</label></td>
                <td style="padding-left: 200px;">
                    <div style="margin-right:">
                        <label style="color: white">Date :<%= session.getAttribute("storeLoggedDate")%></label><br>
                        <label style="color: white">Branch : <%= bankBranch.getCSubSectionNameUni() + " - ( " + bankBranch.getNSubSectionID() + " )"%></label><br> 
                        <label style="color: white">User Name : <%= user.getCUserName()%></label><br>
                    </div>
                </td>
            </tr>
        </table>
        <div class="body_wrap">
            <!-- header -->
            <div class="header" >
                <div class="header_inner">
                    <div class="container">
                        <div class="grid_gallery clearfix">
                            <div class="box box-1">
                                <a href="teller/"  style="outline: none;"><img src="images/temp/tellerGirl.jpg" width="306" height="391" alt=""><span>Teller</span></a>
                            </div>
                            <div class="box box-2">
                                <a href="saving/"  style="outline: none;"><img src="images/temp/saving.jpg" width="306" height="370" alt=""><span>Saving</span></a>
                            </div>
                            <div class="box box-2">
                                <a href="pawning/index.jsp" style="outline: none; "><img src="images/temp/pawning.png" width="306" height="391" alt=""><span>Pawn</span></a>
                            </div>
                            <div class="box box-2">
                                <a href="loan/"  style="outline: none;"><img src="images/temp/loan.jpg" width="306" height="391" alt=""><span>Loan</span></a>
                            </div>
                            <div class="box box-2">
                                <a href="#"  style="outline: none;"><img src="images/temp/more1.jpg" width="306" height="391" alt=""><span>more</span></a>
                            </div>
                            <div class="box box-2">
                                <a href="#"  style="outline: none;"><img src="images/temp/more2.jpg" width="306" height="391" alt=""><span>more</span></a>
                            </div>
                            <div class="box box-2">
                                <a href="manager_/manager_home.jsp"  style="outline: none;"><img src="images/temp/manager.jpg" width="306" height="391" alt=""><span>Manager</span></a>
                            </div>
                        </div>
                        <h1 align="right" style="  color: white; font-size: 20px; font-style: italic">Namal Business Solutions(Pvt)Ltd. </h1>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
