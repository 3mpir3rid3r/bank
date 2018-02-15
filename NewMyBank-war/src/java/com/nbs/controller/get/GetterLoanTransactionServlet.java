/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.Security;
import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.dao.BnkLonLoanMasterDaoLocal;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import com.nbs.model.VFindDatabnkLonLoanMaster;
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
 * @author lasa
 */
public class GetterLoanTransactionServlet extends HttpServlet {

    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    @EJB
    private BnkLonLoanMasterDaoLocal bnkLonLoanMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchingType = request.getParameter("searchingType");

        if (searchingType == null) {
            String nLonMFIDString = request.getParameter("nLonMFID");

            String moneyLonType = request.getParameter("moneyLonType");

            if (nLonMFIDString.isEmpty()) {
                request.getSession().removeAttribute("lonLoanMaster");
                request.getSession().removeAttribute("depDepositMaster");
            } else {
                long nLonMFID = Long.parseLong(nLonMFIDString);
                VFindDatabnkLonLoanMaster lonLoanMaster = bnkLonLoanMasterDao.getAllBnkLonLoanMasterByNLonMFID(nLonMFID);
                if (moneyLonType.equals("1")) {
                    long nRecoverByDepMFID = lonLoanMaster.getNRecoverByDepMFID();
                   
                    if (nRecoverByDepMFID != 0) {
                        VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nRecoverByDepMFID);
                        request.getSession().setAttribute("depDepositMaster", depDepositMaster);
                    }
                } else {
                    long nIssueToDepMFID = lonLoanMaster.getNIssueToDepMFID();
                   
                    if (nIssueToDepMFID != 0) {
                        VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nIssueToDepMFID);
                        request.getSession().setAttribute("depDepositMaster", depDepositMaster);
                    }
                }
                request.getSession().setAttribute("lonLoanMaster", lonLoanMaster);
            }
            if (moneyLonType.equals("1")) {
                response.sendRedirect("teller/loan_payment.jsp");
            } else {
                response.sendRedirect("teller/loan_issue.jsp");
            }
        } else {
            if (searchingType.equals("1")) {
                searchAccountNo(request, response, "loanPayment", "1");
            } else {
                searchAccountNo(request, response, "loanIssue", "2");
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
                response.sendRedirect("teller/view_loanmaster.jsp?tellerIndexKey=" + tIndexKey);
            } else {
                String[] accSplit = accountNumber.split("-");
                long nLonMFID;
                if (accSplit.length == 0) {
                    nLonMFID = bnkLonLoanMasterDao.getBnkLonLoanMasterNLonMFID(accountNumber);
                } else {
                    accountNumber = "";
                    for (String s : accSplit) {
                        accountNumber = accountNumber + s;
                    }
                    nLonMFID = bnkLonLoanMasterDao.getBnkLonLoanMasterNLonMFID(accountNumber);
                   
                }
                if (nLonMFID != 0L) {
                    VFindDatabnkLonLoanMaster lonLoanMaster = bnkLonLoanMasterDao.getAllBnkLonLoanMasterByNLonMFID(nLonMFID);
                    if (request.getSession().getAttribute("lonLoanMaster") != null) {
                        request.getSession().removeAttribute("lonLoanMaster");
                    }
                    if (request.getSession().getAttribute("depDepositMaster") != null) {
                        request.getSession().removeAttribute("depDepositMaster");
                    }
                    request.getSession().setAttribute("lonLoanMaster", lonLoanMaster);
                    if (mDepType.equals("1")) {
                        long nRecoverByDepMFID = lonLoanMaster.getNRecoverByDepMFID();
                      
                        if (nRecoverByDepMFID != 0) {
                            VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nRecoverByDepMFID);
                            request.getSession().setAttribute("depDepositMaster", depDepositMaster);
                        }
                        response.sendRedirect("teller/loan_payment.jsp");
                    } else {
                        long nIssueToDepMFID = lonLoanMaster.getNIssueToDepMFID();
                       
                        if (nIssueToDepMFID != 0) {
                            VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nIssueToDepMFID);
                            request.getSession().setAttribute("depDepositMaster", depDepositMaster);
                        }
                        response.sendRedirect("teller/loan_issue.jsp");
                    }

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
