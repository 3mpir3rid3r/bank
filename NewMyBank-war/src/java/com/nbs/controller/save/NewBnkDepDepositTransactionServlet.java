/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkTransactionsDaoLocal;
import com.nbs.model.ActSectionsSub;
import com.nbs.model.BnkDepDepositTransaction;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.GenUser;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class NewBnkDepDepositTransactionServlet extends HttpServlet {

    @EJB
    private BnkTransactionsDaoLocal bnkTransactionsDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BnkDepDepositTransaction bddt = new BnkDepDepositTransaction();
        boolean check = false;

        String nDepTrnIDString = "0";
        Long nDepTrnID = Long.parseLong(nDepTrnIDString);
        bddt.setNDepTrnID(nDepTrnID);

        String nDepMFIDString = request.getParameter("nDepMFID");
        if (nDepMFIDString.isEmpty()) {
            check = true;
        } else {
            Long nDepMFID = Long.parseLong(nDepMFIDString);
            bddt.setNDepMFID(nDepMFID);
        }

        String nTellerIDString = "1";
        int nTellerID = Integer.parseInt(nTellerIDString);
        bddt.setNTellerID(nTellerID);

        ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
        if (request.getSession().getAttribute("branch") == null) {
            //
        } else {
            int nBankBranchIDTrn = bankBranch.getNSubSectionID();
            bddt.setNBankBranchIDTrn(nBankBranchIDTrn);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dTrnDateString = request.getSession().getAttribute("logDate").toString();
        if (dTrnDateString.isEmpty()) {
            check = true;
        } else {
            try {
                Date dTrnDate = formatter.parse(dTrnDateString);
                bddt.setDTrnDate(dTrnDate);
            } catch (ParseException ex) {
                check = true;
            }
        }

        String dDepositDateString = request.getParameter("dDepositDate");
        if (dDepositDateString.isEmpty()) {
            check = true;
        } else {
            try {
                Date dDepositDate = formatter.parse(dDepositDateString);
                bddt.setDDepositDate(dDepositDate);
            } catch (ParseException ex) {
                check = false;
            }
        }

        String cReceiptNo = request.getParameter("cReceiptNo");
        bddt.setCReceiptNo(cReceiptNo);
        if (cReceiptNo.isEmpty()) {
            check = true;
        }
        String cReceiptNo2 = request.getParameter("cReceiptNo2");
        if (cReceiptNo2.isEmpty()) {
            cReceiptNo2 = "0";
        }
        bddt.setCReceiptNo2(cReceiptNo2);

        BigDecimal nPaymentVal = null;
        String nPaymentValString = request.getParameter("nPaymentVal");
        if (nPaymentValString.isEmpty() || nPaymentValString.trim().equals("0")) {
            check = true;
        } else {
            nPaymentVal = BigDecimal.valueOf(Double.parseDouble(nPaymentValString.replaceAll(",", "")));
            bddt.setNPaymentVal(nPaymentVal);
        }
        String moneyDepType = request.getParameter("moneyDepType");
        if (moneyDepType.equals("1")) {
            String nGLTrnIDString = "100";
            int nGLTrnID = Integer.parseInt(nGLTrnIDString);
            bddt.setNGLTrnID(nGLTrnID);
            bddt.setNCr(nPaymentVal);
            bddt.setNDr(BigDecimal.ZERO);
        } else if (moneyDepType.equals("2")) {
            VFindDatabnkDepDepositMaster depDepositMaster = (VFindDatabnkDepDepositMaster) request.getSession().getAttribute("depDepositMaster");
            String nAvailableBalance = String.valueOf(depDepositMaster.getNAvailableBalance());
            if (Double.parseDouble(String.valueOf(nPaymentVal)) > Double.parseDouble(nAvailableBalance)) {
                response.sendRedirect("teller/money_saving.jsp?moneyDepType=2");
            } else {
                String nGLTrnIDString = "101";
                int nGLTrnID = Integer.parseInt(nGLTrnIDString);
                bddt.setNGLTrnID(nGLTrnID);
                bddt.setNCr(BigDecimal.ZERO);
                bddt.setNDr(nPaymentVal);
            }
        }

        String nDailyCollectionHDIDString = "0";
        Long nDailyCollectionHDID = Long.parseLong(nDailyCollectionHDIDString);
        bddt.setNDailyCollectionHDID(nTellerID);

        String userString;
        GenUser genUser = (GenUser) request.getSession().getAttribute("user");
        userString = genUser.getCUserName();
        bddt.setCAddBy(userString);
        bddt.setNTellerID(genUser.getNUserID());

        if (check) {
            request.getSession().setAttribute("bddt", bddt);
            response.sendRedirect("teller/money_saving.jsp?successMsg=0&moneyDepType" + moneyDepType);
        } else {

            int i = bnkTransactionsDao.insertBnkDepDepositTransaction(bddt);
            bddt.setNDepTrnID(Long.parseLong(i + ""));
            request.getSession().setAttribute("bddt", bddt);
//            request.getSession().removeAttribute("depDepositMaster");
            response.sendRedirect("teller/money_saving.jsp?successMsg=1&moneyDepType" + moneyDepType);
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
