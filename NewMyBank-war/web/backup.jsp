<%-- 
    Document   : backup.jsp
    Created on : Apr 12, 2015, 8:46:46 AM
    Author     : mmh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link href="font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="./BackupDBServlet">
            <button class="btn btn-primary btn-sm" type="submit">Backup</button>
        </form>
    </body>
</html>
