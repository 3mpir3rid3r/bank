<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.view.JRViewer"%>
<%@page import="com.nbs.model.common.JDBC"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="net.sf.jasperreports.j2ee.servlets.ImageServlet"%>
<%@page import="com.nbs.common.Report"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Connection"%>
<%--<%@ page language="java" import="net.sf.jasperreports.engine.*,net.sf.jasperreports.engine.export.*" %>--%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css"/>

        <link href="font/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>


        <title>Bootstrap video player</title>




    </head>
    <body>
    <center>  <div style="border-color: black;border-style: solid; width: 210mm; height: 297mm" id="print">
            <%
                response.setContentType("text/html;charset=UTF-8");
                Map map = new HashMap();

                String reportFile = getServletContext().getRealPath("/") + "reports/newReport.jrxml";
                out.write(reportFile);

                JasperPrint print = new Report().getJasperPrint(map, reportFile);
                JRHtmlExporter exporter = new JRHtmlExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);

                Map imagemap = new HashMap();
                request.getSession().setAttribute("IMAGES_MAP", imagemap);
                request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_LIST_SESSION_ATTRIBUTE, print);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagemap);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "servlets/image?image=");
                exporter.exportReport();
                    out.write("report Exported");
    //            JasperReport jReport = JasperManager.loadReport("/home/mmh/Documents/Kalana/EnterpriseApplication1/NewMyBank-war/web/reports/report1.jrxml");
    //        JasperReport jReport = null;
    //        JasperPrint jPrint = null;
    //        JasperDesign jDesign;
    //        jReport = JasperCompileManager.compileReport("/home/mmh/Documents/Kalana/EnterpriseApplication1/NewMyBank-war/web/reports/report1.jrxml");
    //        jPrint = JasperFillManager.fillReport(jReport, new HashMap(), new JDBC().getConnection());
    //        JasperViewer.viewReport(jPrint);


            %>
        </div><button type="button" onclick="printDiv()">Print</button></center>
    <script type="text/javascript">
        function printDiv() {
            var print = document.getElementById("print").innerHTML;
//                print.print();
            var popwin = open("", 'new_window', "width=970,height=700")
            popwin.document.write('<html><heade><title>Print Report</title></head>')
            popwin.document.write('<body><div align=center>')
            popwin.document.write(print);
            popwin.document.write('</div></body></html>')
            popwin.print();
        }
    </script>


    <script type="text/css">
        @header_background_color: #333;
        @header_text_color: #FDFDFD;
        @alternate_row_background_color: #DDD;

        @table_width: 750px;
        @table_body_height: 300px;
        @column_one_width: 200px;
        @column_two_width: 200px;
        @column_three_width: 350px;

        .fixed_headers {
            width: @table_width;
            table-layout: fixed;
            border-collapse: collapse;

            th { text-decoration: underline; }
            th, td {
                padding: 5px;
                text-align: left;
            }

            td:nth-child(1), th:nth-child(1) { min-width: @column_one_width; }
            td:nth-child(2), th:nth-child(2) { min-width: @column_two_width; }
            td:nth-child(3), th:nth-child(3) { width: @column_three_width; }

            thead {
                background-color: @header_background_color;
                color: @header_text_color;
                tr {
                    display: block;
                    position: relative;
                }
            }
            tbody {
                display: block;
                overflow: auto;
                width: 100%;
                height: @table_body_height;
                tr:nth-child(even) {
                    background-color: @alternate_row_background_color;
                }
            }
        }

        .old_ie_wrapper {
            height: @table_body_height;
            width: @table_width;
            overflow-x: hidden;
            overflow-y: auto;
            tbody { height: auto; }
        }
    </script>
</div>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>






