/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.model.BnkCustomerMaster;
import com.nbs.model.BnkDepDepositMaster;
import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class SelectCustomerDetailForPawningServlet extends HttpServlet {

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;
    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String custId = request.getParameter("custId");
            VFindDatabnkDepDepositMaster depositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(Long.parseLong(custId));
            long nCustomerID = depositMaster.getNCustomerID();

            BnkCustomerMaster customerDetailsUsingID = bnkCustomerMasterDao.getCustomerDetailsUsingID(nCustomerID);
            BnkPwnPawnMaster pawnMaster = new BnkPwnPawnMaster();

            pawnMaster.setCFullName(customerDetailsUsingID.getCFullName());
            pawnMaster.setCPAddLine1(customerDetailsUsingID.getCPAddLine1());
            pawnMaster.setCPAddLine2(customerDetailsUsingID.getCPAddLine2());
            pawnMaster.setCPAddLine3(customerDetailsUsingID.getCPAddLine3());
            pawnMaster.setCPAddLine4(customerDetailsUsingID.getCPAddLine4());
            pawnMaster.setCPTelNo1(customerDetailsUsingID.getCPTelNo1());
            pawnMaster.setCPTelNo2(customerDetailsUsingID.getCPTelNo2());
            pawnMaster.setCIDNo(customerDetailsUsingID.getCNICNo());
            pawnMaster.setDIssueDate(customerDetailsUsingID.getDNICIssuedDate());

            request.getSession().setAttribute("iddetail", pawnMaster);
            request.getSession().removeAttribute("tlist");
            request.getSession().removeAttribute("pawningAllCustomers");
            response.sendRedirect("pawning/pawning_master.jsp");

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
