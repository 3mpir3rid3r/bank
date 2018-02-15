/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.Security;
import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class GetterMoneyTransactionServelet extends HttpServlet {

    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchingType = request.getParameter("searchingType");

        if (searchingType == null) {
            String nDepMFIDString = request.getParameter("nDepMFID");

            String moneyDepType = request.getParameter("moneyDepType");

            if (nDepMFIDString.isEmpty()) {
                request.getSession().removeAttribute("depDepositMaster");
                response.sendRedirect("teller/money_saving.jsp?moneyDepType=" + moneyDepType);
            } else {
                long nDepMFID = Long.parseLong(nDepMFIDString);
                System.out.println(nDepMFID);
                VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nDepMFID);

                request.getSession().setAttribute("depDepositMaster", depDepositMaster);
                response.sendRedirect("teller/money_saving.jsp?moneyDepType=" + moneyDepType);
            }
        } else {
            if (searchingType.equals("1")) {
                searchAccountNo(request, response, "moneySaving", "1");
            } else {
                searchAccountNo(request, response, "moneyWidth", "2");
            }
        }
    }

    private void searchAccountNo(HttpServletRequest request, HttpServletResponse response, String tIndexKey, String mDepType) throws IOException {
        try {

            String identityEncript = request.getParameter("identityEncript");
            String accountNumber;
            if (identityEncript == null) {
                accountNumber = request.getParameter("accountNumber");
            } else {
                accountNumber = Security.decrypt(request.getParameter("accountNumber").replace(" ", "+"));
            }

            if (accountNumber.isEmpty()) {
                response.sendRedirect("teller/view_depositmaster.jsp?tellerIndexKey="+tIndexKey);
            } else {
                String[] accSplit = accountNumber.split("-");
                long nDepMFID;
                if (accSplit.length == 0) {
                    nDepMFID = bnkDepDepositMasterDao.getBnkDepDepositMasterNDepMFID(accountNumber);
                } else {
                    accountNumber = "";
                    for (String s : accSplit) {
                        accountNumber = accountNumber + s;
                    }
                    nDepMFID = bnkDepDepositMasterDao.getBnkDepDepositMasterNDepMFID(accountNumber);
                }
                if (nDepMFID != 0L) {
                    VFindDatabnkDepDepositMaster allBnkDepDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nDepMFID);
                    if (request.getSession().getAttribute("depDepositMaster") != null) {
                        request.getSession().removeAttribute("depDepositMaster");
                    }
                    request.getSession().setAttribute("depDepositMaster", allBnkDepDepositMaster);
                    response.sendRedirect("teller/money_saving.jsp?moneyDepType="+mDepType);
                } else {
                    PrintWriter printWriter = response.getWriter();
                    printWriter.print("NotResult............");
                }
            }
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(GetterMoneyTransactionServelet.class.getName()).log(Level.SEVERE, null, ex);
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
