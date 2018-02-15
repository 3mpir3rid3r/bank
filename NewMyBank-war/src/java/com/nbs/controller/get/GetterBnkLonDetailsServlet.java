/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkLonInterestCalRateForMethodDaoLocal;
import com.nbs.dao.BnkLonLoanCtegoryDaoLocal;
import com.nbs.dao.BnkLonLoanTypesDaoLocal;
import com.nbs.model.BnkDepDepositCategory;
import com.nbs.model.BnkLonInterestMethod;
import com.nbs.model.BnkLonLoanCtegory;
import com.nbs.model.BnkLonPenaltyIntCalFor;
import com.nbs.model.BnkLonPenaltyIntRateFor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasa
 */
public class GetterBnkLonDetailsServlet extends HttpServlet {

    @EJB
    private BnkLonInterestCalRateForMethodDaoLocal bnkLonInterestCalRateForMethodDao;

    @EJB
    private BnkLonLoanCtegoryDaoLocal bnkLonLoanCtegoryDao;

    @EJB
    private BnkLonLoanTypesDaoLocal bnkLonLoanTypesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ls = request.getParameter("ls");

        String select = request.getParameter("select");
        if (ls != null) {

            request.getSession().removeAttribute("acctL1");
            request.getSession().removeAttribute("acctL2");
            request.getSession().removeAttribute("acctL3");
            request.getSession().removeAttribute("acctL4");
            request.getSession().removeAttribute("acctL5");
                request.getSession().removeAttribute("acctL6");
            request.getSession().removeAttribute("acctL7");
            request.getSession().removeAttribute("acctL8");
            request.getSession().removeAttribute("acctL9");

            request.getSession().removeAttribute("nLonTypeID");
            request.getSession().removeAttribute("cp");
            request.getSession().removeAttribute("checkLoan");

        }

        List<BnkLonLoanCtegory> bllcs = bnkLonLoanCtegoryDao.getAllBnkLonLoanCtegory();
        Map<Integer, String> mapBnkBnkLonLoanCtegory = new HashMap<>();
        for (BnkLonLoanCtegory bllc : bllcs) {
            mapBnkBnkLonLoanCtegory.put(bllc.getNLonCatID(), bllc.getCLonCategory());
        }

        List<BnkLonInterestMethod> blims = bnkLonInterestCalRateForMethodDao.getAllBnkLonInterestMethod();
        Map<Short, String> mapBnkLonInterestMethod = new HashMap<>();
        for (BnkLonInterestMethod blim : blims) {
            mapBnkLonInterestMethod.put(blim.getNLonInterestMethodID(), blim.getCLoanInterstMethod());
        }

        List<BnkLonPenaltyIntCalFor> blpicfs = bnkLonInterestCalRateForMethodDao.getAllBnkLonPenaltyIntCalFor();
        Map<Short, String> mapBnkLonPenaltyIntCalFor = new HashMap<>();
        for (BnkLonPenaltyIntCalFor blpicf : blpicfs) {
            mapBnkLonPenaltyIntCalFor.put(blpicf.getNPIntCalForID(), blpicf.getCPIntCalFor());
        }

        List<BnkLonPenaltyIntRateFor> blpirfs = bnkLonInterestCalRateForMethodDao.getAllBnkLonPenaltyIntRateFor();
        Map<Short, String> mapBnkLonPenaltyIntRateFor = new HashMap<>();
        for (BnkLonPenaltyIntRateFor blpirf : blpirfs) {
            mapBnkLonPenaltyIntRateFor.put(blpirf.getNPIntRateForID(), blpirf.getCPIntRateFor());
        }

        request.getSession().setAttribute("bnkLonLoanTypesAll", bnkLonLoanTypesDao.getAllBnkLonLoanTypes());
        request.getSession().setAttribute("bnkLonLoanCtegoryAll", mapBnkBnkLonLoanCtegory);
        request.getSession().setAttribute("bnkLonInterestMethodAll", mapBnkLonInterestMethod);
        request.getSession().setAttribute("bnkLonPenaltyIntCalForAll", mapBnkLonPenaltyIntCalFor);
        request.getSession().setAttribute("bnkLonPenaltyIntRateForAll", mapBnkLonPenaltyIntRateFor);
        if (ls != null) {
            request.getSession().setAttribute("checkLoan", "on");
        }
        if (request.getParameter("selectId") == null) {
            request.getSession().setAttribute("leggerSelect", "on");
        } else {
            request.getSession().removeAttribute("leggerSelect");
        }

        response.sendRedirect("loan/loan_prototype.jsp");

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
