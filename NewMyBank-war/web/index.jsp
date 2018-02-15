<%-- 
    Document   : index
    Created on : Nov 18, 2014, 11:53:02 AM
    Author     : kalana
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nbs.common.Alerts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to system</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link href="font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js"></script>
    </head>
    <body style="background: url(./img/teller/login_background.jpg)">
        <%
            String msg = "";
            String alert = "";
            String username = "kalana";
            String password = "123";
            if (request.getSession().getAttribute("user") != null) {
                response.sendRedirect("main.jsp");
            } else {

                if (request.getParameter("branch") != null) {
                    String branch = request.getParameter("branch");
                    Cookie branchc = new Cookie("branch", branch);
                    branchc.setMaxAge(30 * 24 * 60 * 60);
                    response.addCookie(branchc);
                }

                if (request.getAttribute("login_error") != null) {
                    msg = request.getAttribute("login_error").toString();
                    alert = Alerts.warningAlert("Login error", msg, "");
                }
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String toDate = sdf.format(new Date());
        %>

        <div class="container content" >	

            <!--<div class="panel panel-info" style="margin-top: 50px;background-color: #e7f0f7">-->   
            <br><br><br><br><br><br>
            <div class="row">
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3" >
                    <form class="reg-page" action="UserLoginServlet" method="post">
                        <div class="reg-header">            
                            <h2 style="color: white">Login to your account</h2>
                        </div>
                        <%=alert%>
                        <div class="input-group margin-bottom-20">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" placeholder="Username" class="form-control" name="username" value="<%=username%>">
                        </div></br>  
                        <div class="input-group margin-bottom-20">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input type="password" placeholder="Password" class="form-control" name="password" value="<%=password%>">
                        </div> </br>                   
                        <div class="input-group margin-bottom-20">
                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                            <input type="date" class="form-control" name="logDate" id="logDate" value="<%=toDate%>">
                        </div> </br>                   

                        <div class="row">
                            <div class="col-md-6" style="padding-left: 30px;">
                                <label class="checkbox" style="color: white"><input type="checkbox" name="cook" checked="on"> Stay signed in</label>                        
                            </div></br>
                            <div class="col-md-6">
                                <button class="btn btn-primary pull-right" type="submit">Login</button>                        
                            </div>
                        </div>

                        <hr>

                        <h4 style="color: white">Forget your Password ?</h4>
                        <p style="color: white">no worries, <a class="color-green" href="forgetPassword.jsp?check=1">click here</a> to reset your password.</p>
                    </form>            
                </div>
            </div><!--/row-->
            <!--</div>-->
            <script type="text/javascript">
                function hide() {
                    $("#alert").hide();
                }
            </script>
    </body>

</html>
