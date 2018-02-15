<%-- 
    Document   : newjsp1
    Created on : Jan 15, 2018, 3:17:13 PM
    Author     : mmh
--%>

<%@page import="com.nbs.dao.BnkPwnPawnMasterDao"%>
<%@page import="com.nbs.model.BnkPwnPawnTypes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<BnkPwnPawnTypes> bnkPwnPawnTypes = new BnkPwnPawnMasterDao().getBnkPwnPawnTypes();
            for (BnkPwnPawnTypes bnkPwnPawnType : bnkPwnPawnTypes) {
                System.out.println(bnkPwnPawnType.getCPawnType());
            }
        %>

    </body>
</html>
