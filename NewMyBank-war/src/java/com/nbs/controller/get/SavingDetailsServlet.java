/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkDepDepositTypesDaoLocal;
import com.nbs.model.common.BnkDepDepositCategoryTypes;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasa
 */
public class SavingDetailsServlet extends HttpServlet {

    @EJB
    private BnkDepDepositTypesDaoLocal bnkDepDepositTypesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nDepTypeIDString = request.getParameter("nDepTypeID");
        System.out.println(nDepTypeIDString + "nDepTypeID");
        String moneyDepType = request.getParameter("moneyDepType");

        List<BnkDepDepositCategoryTypes> bddcts = bnkDepDepositTypesDao.getAllBnkDepDepositTypes();
        request.getSession().setAttribute("bddcts", bddcts);

        if (moneyDepType != null) {
            if (request.getSession().getAttribute("cutomerDetailsForCIF") != null) {
                request.getSession().removeAttribute("cutomerDetailsForCIF");
            }
            if (request.getSession().getAttribute("insertDepositMaster") != null) {
                request.getSession().removeAttribute("insertDepositMaster");
            }
            if (request.getSession().getAttribute("depDetailsCheck") != null) {
                request.getSession().removeAttribute("depDetailsCheck");
            }
            if (request.getSession().getAttribute("nextBtnCheck") != null) {
                request.getSession().removeAttribute("nextBtnCheck");
            }
        }
        request.getSession().removeAttribute("accN");
        request.getSession().removeAttribute("accN1");

        if (nDepTypeIDString == null) {
            response.sendRedirect("teller/saving_detail.jsp");
        } else {
            int nDepTypeID = Integer.parseInt(nDepTypeIDString);
            if (nDepTypeID == 0) {
                response.sendRedirect("teller/saving_detail.jsp?");
            } else {
                String cDepName = bnkDepDepositTypesDao.getDepDepositCatagoryName(nDepTypeID);
                if (cDepName == null) {
                    response.sendRedirect("teller/saving_detail.jsp?error=Please check database");
                } else {
                    response.sendRedirect("teller/saving_detail.jsp?nDepTypeID=" + nDepTypeID + "&cDepName=" + cDepName);
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
