/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRProperties;

/**
 *
 * @author mmh
 */
public class ViewLeggerReportServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
//request.setCharacterEncoding("UTF-8");
            String repNo = request.getParameter("rep");
//SOeKGmxZuap
            if (repNo != null) {
                switch (repNo) {
                    case "1":
                        viewJasperReport(request, null, "reports/common_legger/Act_002_CA_L3.jrxml");
                        request.getSession().setAttribute("viewRep", true);
                        response.sendRedirect("teller/common_legger.jsp?viewRep");

                        break;
                    case "2":
                        viewJasperReport(request, null, "reports/common_legger/Act_002_CA_L3.jrxml");
                        request.getSession().setAttribute("viewRep", true);
                        response.sendRedirect("teller/common_legger.jsp?viewRep");
                        break;
                    case "3":
                        viewJasperReport(request, null, "reports/common_legger/Act_003_CA_L4.jrxml");
                        request.getSession().setAttribute("viewRep", true);
                        response.sendRedirect("teller/common_legger.jsp?viewRep");
                        break;
                    case "4":
                        viewJasperReport(request, null, "reports/common_legger/Act_004_CA_L5.jrxml");
                        request.getSession().setAttribute("viewRep", true);
                        response.sendRedirect("teller/common_legger.jsp?viewRep");
                        break;
                }
            } else {
                response.sendRedirect("teller/common_legger.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewLeggerReportServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void viewJasperReport(HttpServletRequest request, Map map, String reportName) throws  FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Map<String, String> parameters = new HashMap<>();

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbsERP_Dankotuwa?useUnicode=true&characterEncoding=utf-8", "root", "123");

        String reportFile = getServletContext().getRealPath(reportName);

        FileInputStream fis = new FileInputStream(new File(reportFile));
//        JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", "/home/mmh/Desktop/amali (2)/fonts/aa amali.ttf");
        // JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", "/home/mmh/Desktop/amali (2)/fonts/Iskoola Pota.ttf");
//        JasperReport jr = JasperCompileManager.compileReport(fis);
        // parameters.put("a", "Mwahhhhhhh fuck You Jasper  I Won");
//        JasperPrint print = JasperFillManager.fillReport(jr, parameters, connection);
//        request.getSession().setAttribute("printzz", print);

//     
//        String reportFile = getServletContext().getRealPath(reportName);
//        FileInputStream fis = new FileInputStream(new File(reportFile));
//        JasperReport jr = JasperCompileManager.compileReport(fis);
//        JasperPrint print = JasperFillManager.fillReport(jr, map);
//        request.getSession().setAttribute("printzz", parameters);
    }
}
