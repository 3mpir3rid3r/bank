/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.model.ActChartOfAcctL1;
import com.nbs.model.ActChartOfAcctL2;
import com.nbs.model.ActChartOfAcctL3;
import com.nbs.model.ActChartOfAcctL4;
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
public class GetViewCommonLeggerServlet extends HttpServlet {

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
            request.getSession().setAttribute("act1", getAct1Servlet());
            request.getSession().setAttribute("act2", getAct2Servlet());
            request.getSession().setAttribute("act3", getAct3Servlet());
            request.getSession().setAttribute("act4", getAct4Servlet());
            request.getSession().setAttribute("act5", getAct5Servlet());
            response.sendRedirect("teller/common_legger.jsp");
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

    public List<ActChartOfAcctL1> getAct1Servlet() {
        List<ActChartOfAcctL1> acctL1s = bnkActDao.getAct1();

        return acctL1s;
    }

    public List<ActChartOfAcctL2> getAct2Servlet() {
        List<ActChartOfAcctL2> acctL2s = bnkActDao.getAct2();

        return acctL2s;
    }

    public List<ActChartOfAcctL3> getAct3Servlet() {
        List<ActChartOfAcctL3> acctL3s = bnkActDao.getAct3();

        return acctL3s;
    }

    public List<ActChartOfAcctL4> getAct4Servlet() {
        List<ActChartOfAcctL4> acctL4s = bnkActDao.getAct4();

        return acctL4s;
    }

    public List<ActChartOfAcctL5> getAct5Servlet() {
        List<ActChartOfAcctL5> acctL5s = bnkActDao.getAct5();

        return acctL5s;
    }
}
