/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkTransactionsDaoLocal;
import com.nbs.model.BnkLonLoanTransactions;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.GenUser;
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
public class NewBnkLonLoanTransactionsServlet extends HttpServlet {

    @EJB
    private BnkTransactionsDaoLocal transactionsDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        BnkLonLoanTransactions bllt = new BnkLonLoanTransactions();

        boolean check = false;

        long nLonTrnID = 0L;
        bllt.setNLonTrnID(nLonTrnID);

        String nLonMFIDString = request.getParameter("nLonMFID");
        if (nLonMFIDString.isEmpty()) {
            check = true;
        } else {
            Long nLonMFID = Long.parseLong(nLonMFIDString);
            bllt.setNLonMFID(nLonMFID);
        }

        String nTellerIDString = "1";
        int nTellerID = Integer.parseInt(nTellerIDString);
        bllt.setNTellerID(nTellerID);

        BnkRefBankBranch bankBranch = (BnkRefBankBranch) request.getSession().getAttribute("branch");
        if (request.getSession().getAttribute("branch") == null) {
            //
        } else {
            int nBankBranchIDTrn = bankBranch.getNBankBranchID();
            bllt.setNBankBranchIDTrn(nBankBranchIDTrn);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String toDate = request.getSession().getAttribute("logDate").toString();
        String dTrnDateString = toDate;
        if (dTrnDateString.isEmpty()) {
            check = true;
        } else {
            try {
                Date dTrnDate = formatter.parse(dTrnDateString);
                bllt.setDTrnDate(dTrnDate);
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
                bllt.setDDepositDate(dDepositDate);
            } catch (ParseException ex) {
                check = false;
            }
        }

        String cReceiptNo = request.getParameter("cReceiptNo");
        if (cReceiptNo.isEmpty()) {
            check = true;
        } else {
            bllt.setCReceiptNo(cReceiptNo);
        }

        String cReceiptNo2 = request.getParameter("cReceiptNo2");
        if (cReceiptNo2.isEmpty()) {
            check = true;
        } else {
            bllt.setCReceiptNo2(cReceiptNo2);
        }

        BigDecimal nPaymentVal = null;
        String nPaymentValString = request.getParameter("nPaymentVal");
        if (nPaymentValString.isEmpty()) {
            check = true;
        } else {
            nPaymentVal = BigDecimal.valueOf(Double.parseDouble(nPaymentValString));
            bllt.setNPaymentVal(nPaymentVal);
        }

        String nGLTrnIDString = "103";
        int nGLTrnID = Integer.parseInt(nGLTrnIDString);
        bllt.setNGLTrnID(nGLTrnID);
        bllt.setNCr(nPaymentVal);
        bllt.setNDr(BigDecimal.ZERO);

        String dPaidCapitalDateString = toDate;
        if (dPaidCapitalDateString.isEmpty()) {
            check = true;
        } else {
            try {
                Date dPaidCapitalDate = formatter.parse(dPaidCapitalDateString);
                bllt.setDPaidCapitalDate(dPaidCapitalDate);
            } catch (ParseException ex) {
                check = false;
            }
        }

        String dPaidIntDateString = toDate;
        if (dPaidIntDateString.isEmpty()) {
            check = true;
        } else {
            try {
                Date dPaidIntDate = formatter.parse(dPaidIntDateString);
                bllt.setDPaidIntDate(dPaidIntDate);
            } catch (ParseException ex) {
                check = false;
            }
        }

        bllt.setNPaidIntDays(0);
        bllt.setNPaidPenaltyIntDays(0);

        String nPaidCapitalValString = request.getParameter("nPaidCapitalVal");
        if (nPaidCapitalValString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nPaidCapitalVal = BigDecimal.valueOf(Double.parseDouble(nPaidCapitalValString));
            bllt.setNPaidCapitalVal(nPaidCapitalVal);
        }

        BigDecimal nPaidIntValue = BigDecimal.ZERO;
        String nPaidIntValueString = request.getParameter("nPaidIntValue");
        if (nPaidIntValueString.isEmpty()) {
            check = true;
        } else {
            nPaidIntValue = BigDecimal.valueOf(Double.parseDouble(nPaidIntValueString));
            bllt.setNPaidIntValue(nPaidIntValue);
        }

        BigDecimal nPaidPenaltyValue = BigDecimal.ZERO;
        String nPaidPenaltyValueString = request.getParameter("nPaidPenaltyValue");
        if (nPaidPenaltyValueString.isEmpty()) {
            check = true;
        } else {
            nPaidPenaltyValue = BigDecimal.valueOf(Double.parseDouble(nPaidPenaltyValueString));
            bllt.setNPaidPenaltyValue(nPaidPenaltyValue);
            if (nPaidPenaltyValue == BigDecimal.ZERO) {
                bllt.setDPaidPenaltyIntDate(null);
            } else {
                String dPaidPenaltyIntDateString = toDate;
                if (dPaidPenaltyIntDateString.isEmpty()) {
                    check = true;
                } else {
                    try {
                        Date dPaidPenaltyIntDate = formatter.parse(dPaidPenaltyIntDateString);
                        bllt.setDPaidPenaltyIntDate(dPaidPenaltyIntDate);
                    } catch (ParseException ex) {
                        check = false;
                    }
                }
            }
        }

        double nPaidTotalInt = Double.parseDouble(String.valueOf(nPaidIntValue)) + Double.parseDouble(String.valueOf(nPaidPenaltyValue));

        bllt.setNPaidTotalInt(BigDecimal.valueOf(nPaidTotalInt));

        String nPaidStationaryString = request.getParameter("nPaidStationary");
        if (nPaidStationaryString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nPaidStationary = BigDecimal.valueOf(Double.parseDouble(nPaidStationaryString));
            bllt.setNPaidStationary(nPaidStationary);
        }

        String nPaidPostageString = request.getParameter("nPaidPostage");
        if (nPaidPostageString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nPaidPostage = BigDecimal.valueOf(Double.parseDouble(nPaidPostageString));
            bllt.setNPaidPostage(nPaidPostage);
        }

        bllt.setNPaidOherCharges(BigDecimal.ZERO);

        String nPaidArbitrationFeesString = request.getParameter("nPaidArbitrationFees");
        if (nPaidArbitrationFeesString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nPaidArbitrationFees = BigDecimal.valueOf(Double.parseDouble(nPaidArbitrationFeesString));
            bllt.setNPaidArbitrationFees(nPaidArbitrationFees);
        }

        String nPaidCaurtFeesString = request.getParameter("nPaidCaurtFees");
        if (nPaidCaurtFeesString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nPaidCaurtFees = BigDecimal.valueOf(Double.parseDouble(nPaidCaurtFeesString));
            bllt.setNPaidCaurtFees(nPaidCaurtFees);
        }

        String userString;
        GenUser genUser = (GenUser) request.getSession().getAttribute("user");
        userString = genUser.getCUserName();
        bllt.setCAddBy(userString);

        if (check) {
            request.getSession().setAttribute("bllt", bllt);
            response.sendRedirect("teller/loan_payment.jsp?successMsg=0");
        } else {
            long loanTransactionsResult = transactionsDao.insertBnkLonLoanTransactions(bllt);
            if (loanTransactionsResult > 0) {
                request.getSession().removeAttribute("lonLoanMaster");
                response.sendRedirect("teller/loan_payment.jsp?successMsg=1");
            } else {
                request.getSession().setAttribute("bllt", bllt);
                response.sendRedirect("teller/loan_payment.jsp?successMsg=0");
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
