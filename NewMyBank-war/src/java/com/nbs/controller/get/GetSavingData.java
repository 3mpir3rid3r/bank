/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.dao.BnkDepDepositTypesDaoLocal;
import com.nbs.model.BnkCustomerMaster;
import com.nbs.model.BnkDepDepositMaster;
import static com.nbs.model.BnkDepDepositMaster_.nDepTypeID;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class GetSavingData extends HttpServlet {

    @EJB
    private BnkDepDepositTypesDaoLocal bnkDepDepositTypesDao;

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

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
            String id = request.getParameter("nDepMFID");
            BnkDepDepositMaster bnkDepDepositMasterByNDepMFID = bnkDepDepositMasterDao.getBnkDepDepositMasterByNDepMFID(Long.parseLong(id));
            BnkCustomerMaster bnkCustomerMaster = bnkCustomerMasterDao.getBnkCustomerMaster(BigInteger.valueOf(Long.parseLong(bnkDepDepositMasterByNDepMFID.getNCustomerID().getNCustomerID().toString())));
            String cDepName = bnkDepDepositTypesDao.getDepDepositCatagoryName(bnkDepDepositMasterByNDepMFID.getNDepTypeID());
            
            request.getSession().setAttribute("cutomerDetailsForCIF", bnkCustomerMaster);
            request.getSession().setAttribute("view", bnkDepDepositMasterByNDepMFID);
            response.sendRedirect("teller/saving_detail.jsp?nDepMFID=" + id + "&cDepName=" + cDepName);
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
