/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.common;

import com.nbs.model.common.JDBC;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.export.JRXlsExporter;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author mmh
 */
public class TestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            Connection conn = null;

            JasperReport jasperReport;
            JasperPrint jasperPrint;
            JasperDesign jasperDesign;

            try {
                conn = new JDBC().getConnection();

                Map parameters = new HashMap();

                String reportFile = getServletContext().getRealPath("/") + "reports/newReport.jrxml";
                System.out.println("yyyyyyyyyyyyyyyyy    ===  " + reportFile);

                jasperDesign = JRXmlLoader.load(reportFile);
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
//
//                String pdfFile = getServletContext().getRealPath("/reports") + "/savingsReport.pdf";
                String pdfFile = "/home/mmh/savingsReport.pdf";
                
                
                
                JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFile);
                response.setContentType("application/pdf");
                

//for creating report in excel format
//                JRXlsExporter exporterXls = new JRXlsExporter();
//                exporterXls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//                exporterXls.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
//                        "/home/mmh/savingsReport.xls");
//                exporterXls.exportReport();
//                JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//                servletOutputStream.flush();
//                servletOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
// display stack trace in the browser
//                                                                StringWriter stringWriter = new StringWriter();
//                                                                PrintWriter printWriter = new PrintWriter(stringWriter);
//                                                                e.printStackTrace(printWriter);
//                                                                response.setContentType("text/plain");
//                                                                response.getOutputStream().print(stringWriter.toString());
            } finally {
//close the connection.
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Exception ignored) {
                    }
                }
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
