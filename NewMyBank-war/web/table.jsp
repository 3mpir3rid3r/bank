<%-- 
    Document   : table
    Created on : Apr 3, 2015, 11:31:59 AM
    Author     : mmh
--%>


<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>

        <%
            response.reset();
            response.setContentType("application/pdf");
            File file = new File("/home/mmh/savingsReport.pdf");
            response.setHeader("Content-Type", "application/pdf");
            response.setHeader("Content-Disposition",
                    "inline;filename=Saba_PhBill.pdf");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Type",
                    getServletContext().getMimeType(file.getName()));
            response.setHeader("Content-Length", String.valueOf(file.length()));
            //OPen an input stream to the file and post the file contents thru the
            //servlet output stream to the browser
            FileInputStream in = new FileInputStream(file);
            ServletOutputStream outs = response.getOutputStream();
            response.setContentLength(in.available());
            byte[] buf = new byte[8192];
            int c = 0;
            try {
                while ((c = in.read(buf, 0, buf.length)) > 0) {
                    //System.out.println("size:"+c);
                    outs.write(buf, 0, c);
                    out.write(outs.toString());
                }

            } catch (IOException ioe) {
                ioe.printStackTrace(System.out);
            } finally {
                outs.flush();
                outs.close();
                in.close();
            }
        %>
    </body>




</html>
