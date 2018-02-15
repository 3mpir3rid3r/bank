<%-- 
    Document   : printReport
    Created on : Jun 26, 2015, 9:44:01 AM
    Author     : mmh
--%>

<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/my/setDefalutFont.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="convertSinhalaAmali ">
        <%
            JasperPrint print = (JasperPrint) session.getAttribute("printzz");
            
            response.setContentType("application/pdf");
            JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
            response.getOutputStream().flush();
            session.removeAttribute("printzz");
            response.getOutputStream().close();
        %>
    </body>
</html>
