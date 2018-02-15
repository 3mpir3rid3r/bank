<%-- 
    Document   : newjsp1
    Created on : Jul 9, 2015, 12:44:27 PM
    Author     : mmh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%            boolean isView = false;
           System.out.print(request.getParameter("printCommonLeggerReport")+"eeeeeeeee");
               if (request.getParameter("printCommonLeggerReport") != null) {
                   isView = Boolean.parseBoolean(request.getParameter("printCommonLeggerReport"));

               }
        %>
        <%
            if (isView) {
        %>
        <a id="linkToClick" href="printCommonLegger.jsp" target="_blank"></a>
        <% }%>
    </body>
</html>
