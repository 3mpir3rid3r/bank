/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.VFindDatabnkDepDepositMaster;
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
public class ViewDepositCustomerServlet extends HttpServlet {

    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String key = request.getParameter("key");
            String on = request.getParameter("allcustomers");
            BnkRefBankBranch bankBranch = (BnkRefBankBranch) request.getSession().getAttribute("branch");
          
            List<VFindDatabnkDepDepositMaster> customersView = null;
            
            if ("on".equals(on)) {
                customersView = bnkDepDepositMasterDao.getBnkDepositMasterView(bankBranch.getNBankBranchID(), "");

            } else {
                customersView = bnkDepDepositMasterDao.getBnkDepositMasterView(bankBranch.getNBankBranchID(), key);

            }
            request.getSession().setAttribute("pawningAllCustomers", customersView);
        
            response.sendRedirect("pawning/view_depositCustomer.jsp?key=" + key + "");
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
