/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.model.ActChartOfAcctL5;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class FindLeggerDetailsServlet extends HttpServlet {

    @EJB
    private BnkActDaoLocal bnkActDao;

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

            String number = (String) request.getSession().getAttribute("keyNo");
            String number1 = (String) request.getSession().getAttribute("keyNo1");
            String number2 = (String) request.getSession().getAttribute("keyNo2");
            
            String key = request.getParameter("key");
            String allSelect = request.getParameter("allcustomers");
          

            if (number != null) {
                if (allSelect != null) {
                    List<ActChartOfAcctL5> act5Data = bnkActDao.getAct5();

                    switch (number) {
                        case "1":
                            request.getSession().setAttribute("chartOfAccount5Data1", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=1");
                            break;
                        case "2":
                            request.getSession().setAttribute("chartOfAccount5Data2", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=2");
                            break;
                        case "3":
                            request.getSession().setAttribute("chartOfAccount5Data3", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=3");
                            break;
                        case "4":
                            request.getSession().setAttribute("chartOfAccount5Data4", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=4");
                            break;
                        case "5":
                            request.getSession().setAttribute("chartOfAccount5Data5", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=5");
                            break;
                        case "6":
                            request.getSession().setAttribute("chartOfAccount5Data6", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=6");
                            break;
                        case "7":
                            request.getSession().setAttribute("chartOfAccount5Data7", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=7");
                            break;
                    }

                } else if (key != null) {
                   
                    List<ActChartOfAcctL5> act5Data = bnkActDao.getAct5SearchingData(key);
                    switch (number) {
                        case "1":
                            request.getSession().setAttribute("chartOfAccount5Data1", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=1");
                            break;
                        case "2":
                            request.getSession().setAttribute("chartOfAccount5Data2", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=2");
                            break;
                        case "3":
                            request.getSession().setAttribute("chartOfAccount5Data3", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=3");
                            break;
                        case "4":
                            request.getSession().setAttribute("chartOfAccount5Data4", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=4");
                            break;
                        case "5":
                            request.getSession().setAttribute("chartOfAccount5Data5", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=5");
                            break;
                        case "6":
                            request.getSession().setAttribute("chartOfAccount5Data6", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=6");
                            break;
                        case "7":
                            request.getSession().setAttribute("chartOfAccount5Data7", act5Data);
                            response.sendRedirect("pawning/view_commonLegger.jsp?key2No=7");
                            break;

                    }

                   // response.sendRedirect("pawning/view_commonLegger.jsp");
                } else {
                    response.sendRedirect("pawning/view_commonLegger.jsp");
                }

            } else if (number1 != null) {
               
                if (allSelect != null) {
                    List<ActChartOfAcctL5> act5Data = bnkActDao.getAct5();
                    switch (number1) {
                        case "1":
                            request.getSession().setAttribute("chartOfAccount5Data1", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=1");
                            break;
                        case "2":
                            request.getSession().setAttribute("chartOfAccount5Data2", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=2");
                            break;
                        case "3":
                            request.getSession().setAttribute("chartOfAccount5Data3", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=3");
                            break;
                        case "4":
                            request.getSession().setAttribute("chartOfAccount5Data4", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=4");
                            break;
                        case "5":
                            request.getSession().setAttribute("chartOfAccount5Data5", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=5");
                            break;
                        case "6":
                            request.getSession().setAttribute("chartOfAccount5Data6", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=6");
                            break;
                        case "7":
                            request.getSession().setAttribute("chartOfAccount5Data7", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=7");
                            break;
                        case "8":
                            request.getSession().setAttribute("chartOfAccount5Data8", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=8");
                            break;
                        case "9":
                            request.getSession().setAttribute("chartOfAccount5Data9", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=9");
                            break;
                    }

                } else if (key != null) {

                    List<ActChartOfAcctL5> act5Data = bnkActDao.getAct5SearchingData(key);
                    switch (number1) {
                        case "1":
                            request.getSession().setAttribute("chartOfAccount5Data1", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=1");
                            break;
                        case "2":
                            request.getSession().setAttribute("chartOfAccount5Data2", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=2");
                            break;
                        case "3":
                            request.getSession().setAttribute("chartOfAccount5Data3", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=3");
                            break;
                        case "4":
                            request.getSession().setAttribute("chartOfAccount5Data4", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=4");
                            break;
                        case "5":
                            request.getSession().setAttribute("chartOfAccount5Data5", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=5");
                            break;
                        case "6":
                            request.getSession().setAttribute("chartOfAccount5Data6", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=6");
                            break;
                        case "7":
                            request.getSession().setAttribute("chartOfAccount5Data7", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=7");
                            break;
                        case "8":
                            request.getSession().setAttribute("chartOfAccount5Data8", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=8");
                            break;
                        case "9":
                            request.getSession().setAttribute("chartOfAccount5Data9", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=9");
                            break;
                    }
                }
            }else if (number2 != null) {
                
                if (allSelect != null) {
                    List<ActChartOfAcctL5> act5Data = bnkActDao.getAct5();
                    switch (number2) {
                        case "10":
                            request.getSession().setAttribute("chartOfAccount5Data10", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=10");
                            break;
                        case "11":
                            request.getSession().setAttribute("chartOfAccount5Data11", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=11");
                            break;
                        
                    }

                } else if (key != null) {

                    List<ActChartOfAcctL5> act5Data = bnkActDao.getAct5SearchingData(key);
                    switch (number2) {
                        case "10":
                            request.getSession().setAttribute("chartOfAccount5Data10", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=10");
                            break;
                        case "11":
                            request.getSession().setAttribute("chartOfAccount5Data11", act5Data);
                            response.sendRedirect("loan/view_commonLegger.jsp?key2No=11");
                            break;
                        
                    }
                }
            }
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
