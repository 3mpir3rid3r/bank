/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkLonLoanMasterDaoLocal;
import com.nbs.model.ActSectionsMain;
import com.nbs.model.ActSectionsSub;
import com.nbs.model.BnkDepDepositMaster;
import com.nbs.model.BnkLonLoanMaster;
import com.nbs.model.BnkRefBankBranch;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class NewLonLoanMasterServlet extends HttpServlet {

    @EJB
    private BnkLonLoanMasterDaoLocal bnkLonLoanMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            BnkLonLoanMaster bllm;
            if (request.getSession().getAttribute("insertLoanMaster") == null) {
                bllm = new BnkLonLoanMaster();
            } else {
                bllm = (BnkLonLoanMaster) request.getSession().getAttribute("insertLoanMaster");
            }

            String saveType = request.getParameter("saveType");

            switch (saveType) {
                case "1":
                    basicInformation(request, response, bllm);
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
            }
        } catch (ParseException ex) {
            Logger.getLogger(NewLonLoanMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void basicInformation(HttpServletRequest request, HttpServletResponse response, BnkLonLoanMaster bllm) throws IOException, ParseException {

        boolean check = false;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String nLonMFIDString = "0";
        Long nLonMFID = Long.parseLong(nLonMFIDString);
        bllm.setNLonMFID(nLonMFID);

        if (request.getSession().getAttribute("branch") == null) {
            response.sendRedirect("SetBranchesCookieServlet");
        }
        ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
        int nBankBranchID = bankBranch.getNSubSectionID();
        bllm.setNBankBranchID(0);

        String nLonTypeIDString = request.getParameter("nLonTypeID");
        if (nLonTypeIDString.equals("0")) {
            check = true;
            System.out.println("a1");
            
        } else {
            int nLonTypeID = Integer.parseInt(nLonTypeIDString);
            bllm.setNLonTypeID(nLonTypeID);
        }

        String nCustomerIDString = request.getParameter("nCustomerID");
        if (nCustomerIDString.isEmpty()) {
            check = true;
            System.out.println("a1");
        } else {
            Long nCustomerID = Long.parseLong(nCustomerIDString);
            bllm.setNCustomerID(nCustomerID);
        }

        String nLonDescriptionIDString = request.getParameter("nLonDescriptionID");
        int nLonDescriptionID = Integer.parseInt(nLonDescriptionIDString);
        bllm.setNLonDescriptionID(nLonDescriptionID);

        String nLonFundSourceIDString = request.getParameter("nLonFundSourceID");
        int nLonFundSourceID = Integer.parseInt(nLonFundSourceIDString);
        bllm.setNLonFundSourceID(nLonFundSourceID);

        String bJointString = request.getParameter("bJoint");
        boolean bJoint = false;
        if (bJointString.equals("1")) {
            bJoint = true;
        }
        bllm.setBJoint(bJoint);

        String nLonStatusIDString = request.getParameter("nLonStatusID");
        int nLonStatusID = Integer.parseInt(nLonStatusIDString);
        bllm.setNLonStatusID(nLonStatusID);

        String cLonAccountNoString = request.getParameter("cLonAccountNo");
        if (cLonAccountNoString == null) {
            check = true;
            System.out.println("a1");
        } else {
            bllm.setCLonAccountNo(cLonAccountNoString);
        }

        bllm.setCOldLonAccountNo(cLonAccountNoString);

        String nLedgerBookNoString = request.getParameter("nLedgerBookNo");
        if (nLedgerBookNoString == null) {
            check = true;
            System.out.println("a2");
        } else {
            bllm.setNLedgerBookNo(nLedgerBookNoString);
        }

        String cSerialNoString = request.getParameter("cSerialNo");
        if (cSerialNoString == null) {
            check = true;
            System.out.println("a3");
        } else {
            bllm.setCSerialNo(cSerialNoString);
        }

        String dLoanDateString = "2000-01-01";
        if (dLoanDateString.isEmpty()) {
            check = true;
            System.out.println("a4");
        } else {

            Date dLoanDate = dateFormat.parse(dLoanDateString);
            bllm.setDLoanDate(dLoanDate);

        }

        String dApplyedDateString = request.getParameter("dApplyedDate");
        if (dApplyedDateString.isEmpty()) {
            check = true;
            System.out.println("a5");
        } else {

            Date dApplyedDate = dateFormat.parse(dApplyedDateString);
            bllm.setDApplyedDate(dApplyedDate);

        }

        String dApprovedDateString = request.getParameter("dApprovedDate");
        if (dApprovedDateString.isEmpty()) {
            check = true;
            System.out.println("a6");
        } else {
            Date dApprovedDate = dateFormat.parse(dApprovedDateString);
            bllm.setDApprovedDate(dApprovedDate);

        }

        String nApplyedAmountString = request.getParameter("nApplyedAmount");
        if (nApplyedAmountString.isEmpty()) {
            check = true;
            System.out.println("a7");
        } else {
            BigDecimal nApplyedAmount = BigDecimal.valueOf(Double.parseDouble(nApplyedAmountString));
            bllm.setNApplyedAmount(nApplyedAmount);
        }

        String nApprovedAmountString = request.getParameter("nApprovedAmount");
        if (nApprovedAmountString.isEmpty()) {
            check = true;
            System.out.println("a8");
        } else {
            BigDecimal nApprovedAmount = BigDecimal.valueOf(Double.parseDouble(nApprovedAmountString));
            bllm.setNApprovedAmount(nApprovedAmount);
        }

        String nInsuredAmountString = request.getParameter("nInsuredAmount");
        if (nInsuredAmountString.isEmpty()) {
            check = true;
            System.out.println("a9");
        } else {
            BigDecimal nInsuredAmount = BigDecimal.valueOf(Double.parseDouble(nInsuredAmountString));
            bllm.setNInsuredAmount(nInsuredAmount);
        }

        String nReservedAmountString = request.getParameter("nReservedAmount");
        if (nReservedAmountString.isEmpty()) {
            check = true;
            System.out.println("a0");
        } else {
            BigDecimal nReservedAmount = BigDecimal.valueOf(Double.parseDouble(nReservedAmountString));
            bllm.setNReservedAmount(nReservedAmount);
        }

        String nEffectiveIntString = request.getParameter("nEffectiveInt");
        if (nEffectiveIntString.isEmpty()) {
            check = true;
            System.out.println("a00");
        } else {
            BigDecimal nEffectiveInt = BigDecimal.valueOf(Double.parseDouble(nEffectiveIntString));
            bllm.setNEffectiveInt(nEffectiveInt);
        }

        String nPanaltyIntString = request.getParameter("nPanaltyInt");
        if (nPanaltyIntString.isEmpty()) {
            check = true;
            System.out.println("a99");
        } else {
            BigDecimal nPanaltyInt = BigDecimal.valueOf(Double.parseDouble(nPanaltyIntString));
            bllm.setNPanaltyInt(nPanaltyInt);
        }

        String cBoardApprovalNoString = request.getParameter("cBoardApprovalNo");
        bllm.setCBoardApprovalNo(cBoardApprovalNoString);
        String dBoardApprovalDateString = request.getParameter("dBoardApprovalDate");
        if (dBoardApprovalDateString.isEmpty()) {
            check = true;
            System.out.println("a88");
        } else {

            Date dBoardApprovalDate = dateFormat.parse(dBoardApprovalDateString);
            bllm.setDBoardApprovalDate(dBoardApprovalDate);

        }

        String nLonPeriodTypeIDString = request.getParameter("nLonPeriodTypeID");
        bllm.setNLonPeriodTypeID(Short.parseShort(nLonPeriodTypeIDString));

        String nLonPeriodString = request.getParameter("nLonPeriod");
        if (nLonPeriodString.isEmpty()) {
            check = true;
            System.out.println("a77");
        } else {
            int nLonPeriod = Integer.parseInt(nLonPeriodString);
            bllm.setNLonPeriod(nLonPeriod);
        }

        String nLonPaymentFreeTypeIDString = request.getParameter("nLonPaymentFreeTypeID");
        bllm.setNLonPaymentFreeTypeID(Short.parseShort(nLonPaymentFreeTypeIDString));

        String nLonPaymentFreeTimeString = request.getParameter("nLonPaymentFreeTime");
        if (nLonPaymentFreeTimeString.isEmpty()) {
            check = true;
            System.out.println("a66");
        } else {
            int nLonPaymentFreeTime = Integer.parseInt(nLonPaymentFreeTimeString);
            bllm.setNLonPaymentFreeTime(nLonPaymentFreeTime);
        }

        String dFirstInstallmentDateString = request.getParameter("dFirstInstallmentDate");
        if (dFirstInstallmentDateString.isEmpty()) {
            check = true;
            System.out.println("a55");
        } else {
            Date dFirstInstallmentDate = dateFormat.parse(dFirstInstallmentDateString);
            bllm.setDFirstInstallmentDate(dFirstInstallmentDate);
        }

        String dMaturityDateString = request.getParameter("dMaturityDate");
        if (dMaturityDateString.isEmpty()) {
            check = true;
            System.out.println("a44");
        } else {
            Date dMaturityDate = dateFormat.parse(dMaturityDateString);
            bllm.setDMaturityDate(dMaturityDate);
        }

        String nLonDeductTypeIDString = request.getParameter("nLonDeductTypeID");
        bllm.setNLonDeductTypeID(Short.parseShort(nLonDeductTypeIDString));

        String nLonGrpIDString = request.getParameter("nLonGrpID");
        bllm.setNLonGrpID(Short.parseShort(nLonGrpIDString));

        String nFixedInterestValueString = request.getParameter("nFixedInterestValue");
        if (nFixedInterestValueString.isEmpty()) {
            check = true;
            System.out.println("a33");
        } else {
            BigDecimal nFixedInterestValue = BigDecimal.valueOf(Double.parseDouble(nFixedInterestValueString));
            bllm.setNFixedInterestValue(nFixedInterestValue);
        }

        String nLonInstallmentPayTypeIDString = request.getParameter("nLonInstallmentPayTypeID");
        bllm.setNLonInstallmentPayTypeID(Short.parseShort(nLonInstallmentPayTypeIDString));

        String nLonInstallmentPayTimeString = request.getParameter("nLonInstallmentPayTime");
        if (nLonInstallmentPayTimeString.isEmpty()) {
            check = true;
            System.out.println("a22");
        } else {
            int nLonInstallmentPayTime = Integer.parseInt(nLonInstallmentPayTimeString);
            bllm.setNLonInstallmentPayTime(nLonInstallmentPayTime);
        }

        String nInstallmentAmountString = request.getParameter("nInstallmentAmount");
        if (nInstallmentAmountString.isEmpty()) {
            check = true;
            System.out.println("a11");
        } else {
            BigDecimal nInstallmentAmount = BigDecimal.valueOf(Double.parseDouble(nInstallmentAmountString));
            bllm.setNInstallmentAmount(nInstallmentAmount);
        }

        String nInstallmentAmountAdjString = request.getParameter("nInstallmentAmountAdj");
        if (nInstallmentAmountAdjString.isEmpty()) {
            check = true;
            System.out.println("a111");
        } else {
            BigDecimal nInstallmentAmountAdj = BigDecimal.valueOf(Double.parseDouble(nInstallmentAmountAdjString));
            bllm.setNInstallmentAmountAdj(nInstallmentAmountAdj);
        }

        String nInstallmentAmountLastString = request.getParameter("nInstallmentAmountLast");
        if (nInstallmentAmountLastString.isEmpty()) {
            check = true;
            System.out.println("a222");
        } else {
            BigDecimal nInstallmentAmountLast = BigDecimal.valueOf(Double.parseDouble(nInstallmentAmountLastString));
            bllm.setNInstallmentAmountLast(nInstallmentAmountLast);
        }

        String nDueDaysAfterString = request.getParameter("nDueDaysAfter");
        if (nDueDaysAfterString.isEmpty()) {
            check = true;
            System.out.println("a333");
        } else {
            int nDueDaysAfter = Integer.parseInt(nDueDaysAfterString);
            bllm.setNDueDaysAfter(nDueDaysAfter);
        }

        String nDeductDayString = request.getParameter("nDeductDay");
        if (nDeductDayString.isEmpty()) {
            check = true;
            System.out.println("a444");
        } else {
            short nDeductDay = Short.parseShort(nDeductDayString);
            bllm.setNDeductDay(nDeductDay);
        }

        String nIssuedAmountString = request.getParameter("nIssuedAmount");
        if (nIssuedAmountString.isEmpty()) {
            check = true;
            System.out.println("a555");
        } else {
            BigDecimal nIssuedAmount = BigDecimal.valueOf(Double.parseDouble(nIssuedAmountString));
            bllm.setNIssuedAmount(nIssuedAmount);
        }

        String nBalanceToIssueString = request.getParameter("nBalanceToIssue");
        if (nBalanceToIssueString.isEmpty()) {
            check = true;
            System.out.println("a666");
        } else {
            BigDecimal nBalanceToIssue = BigDecimal.valueOf(Double.parseDouble(nBalanceToIssueString));
            bllm.setNBalanceToIssue(nBalanceToIssue);
        }

        String nTotRecvCapitalString = request.getParameter("nTotRecvCapital");
        if (nTotRecvCapitalString.isEmpty()) {
            check = true;
            System.out.println("a777");
        } else {
            BigDecimal nTotRecvCapital = BigDecimal.valueOf(Double.parseDouble(nTotRecvCapitalString));
            bllm.setNTotRecvCapital(nTotRecvCapital);
        }

        String nTotRecvInstallmentString = request.getParameter("nTotRecvInstallment");
        if (nTotRecvInstallmentString.isEmpty()) {
            check = true;
            System.out.println("a888");
        } else {
            BigDecimal nTotRecvInstallment = BigDecimal.valueOf(Double.parseDouble(nTotRecvInstallmentString));
            bllm.setNTotRecvInstallment(nTotRecvInstallment);
        }

        String nShouldRecvCapitalString = request.getParameter("nShouldRecvCapital");
        if (nShouldRecvCapitalString.isEmpty()) {
            check = true;
            System.out.println("a999");
        } else {
            BigDecimal nShouldRecvCapital = BigDecimal.valueOf(Double.parseDouble(nShouldRecvCapitalString));
            bllm.setNShouldRecvCapital(nShouldRecvCapital);
        }

        String nShouldRecvInstallmentString = request.getParameter("nShouldRecvInstallment");
        if (nShouldRecvInstallmentString.isEmpty()) {
            check = true;
            System.out.println("a000");
        } else {
            BigDecimal nShouldRecvInstallment = BigDecimal.valueOf(Double.parseDouble(nShouldRecvInstallmentString));
            bllm.setNShouldRecvInstallment(nShouldRecvInstallment);
        }

        String nTotRecvInterestString = request.getParameter("nTotRecvInterest");
        if (nTotRecvInterestString.isEmpty()) {
            check = true;
            System.out.println("a0000");
        } else {
            BigDecimal nTotRecvInterest = BigDecimal.valueOf(Double.parseDouble(nTotRecvInterestString));
            bllm.setNTotRecvInterest(nTotRecvInterest);
        }

        String nShouldRecvInterestString = request.getParameter("nShouldRecvInterest");
        if (nShouldRecvInterestString.isEmpty()) {
            check = true;
            System.out.println("a9999");
        } else {
            BigDecimal nShouldRecvInterest = BigDecimal.valueOf(Double.parseDouble(nShouldRecvInterestString));
            bllm.setNShouldRecvInterest(nShouldRecvInterest);
        }

        String nLonBalanceAmountString = request.getParameter("nLonBalanceAmount");
        if (nLonBalanceAmountString.isEmpty()) {
            check = true;
            System.out.println("a8888");
        } else {
            BigDecimal nLonBalanceAmount = BigDecimal.valueOf(Double.parseDouble(nLonBalanceAmountString));
            bllm.setNLonBalanceAmount(nLonBalanceAmount);
        }

        String nLonBalanceInstallmentString = request.getParameter("nLonBalanceInstallment");
        if (nLonBalanceInstallmentString.isEmpty()) {
            check = true;
            System.out.println("a7777");
        } else {
            BigDecimal nLonBalanceInstallment = BigDecimal.valueOf(Double.parseDouble(nLonBalanceInstallmentString));
            bllm.setNLonBalanceInstallment(nLonBalanceInstallment);
        }

        String dLastCapitalPayDateString = request.getParameter("dLastCapitalPayDate");
        if (dLastCapitalPayDateString.isEmpty()) {
            check = true;
            System.out.println("a6666");
        } else {
            Date dLastCapitalPayDate = dateFormat.parse(dLastCapitalPayDateString);
            bllm.setDLastCapitalPayDate(dLastCapitalPayDate);
        }

        String dLastIntPayDateString = request.getParameter("dLastIntPayDate");
        if (dLastIntPayDateString.isEmpty()) {
            check = true;
            System.out.println("a5555");
        } else {
            Date dLastIntPayDate = dateFormat.parse(dLastIntPayDateString);
            bllm.setDLastIntPayDate(dLastIntPayDate);
        }

        String nToDateDueCapitalString = request.getParameter("nToDateDueCapital");
        if (nToDateDueCapitalString.isEmpty()) {
            check = true;
            System.out.println("a4444");
        } else {
            BigDecimal nToDateDueCapital = BigDecimal.valueOf(Double.parseDouble(nToDateDueCapitalString));
            bllm.setNToDateDueCapital(nToDateDueCapital);
        }

        String nToDateDueInstallmentString = request.getParameter("nToDateDueInstallment");
        if (nToDateDueInstallmentString.isEmpty()) {
            check = true;
            System.out.println("a3333");
        } else {
            BigDecimal nToDateDueInstallment = BigDecimal.valueOf(Double.parseDouble(nToDateDueInstallmentString));
            bllm.setNToDateDueInstallment(nToDateDueInstallment);
        }

        String nToDateIntValueRoundString = request.getParameter("nToDateIntValueRound");
        if (nToDateIntValueRoundString.isEmpty()) {
            check = true;
            System.out.println("a2222");
        } else {
            BigDecimal nToDateIntValueRound = BigDecimal.valueOf(Double.parseDouble(nToDateIntValueRoundString));
            bllm.setNToDateIntValueRound(nToDateIntValueRound);
        }

        String nToDateTotIntersestString = request.getParameter("nToDateTotIntersest");
        if (nToDateTotIntersestString.isEmpty()) {
            check = true;
            System.out.println("a1111");
        } else {
            BigDecimal nToDateTotIntersest = BigDecimal.valueOf(Double.parseDouble(nToDateTotIntersestString));
            bllm.setNToDateTotIntersest(nToDateTotIntersest);
        }

        if (check) {
            System.out.println("Error");
            response.sendRedirect("teller/loarn_details.jsp");
        } else {
            int lastLonMFID = bnkLonLoanMasterDao.insertBnkLonLoanMaster(bllm);
            bllm.setNLonMFID(nLonMFID);
            if (request.getSession().getAttribute("saveType") != null) {
                request.getSession().removeAttribute("saveType");
            }
            request.getSession().setAttribute("saveType", "2");
            request.getSession().setAttribute("mainInfroBllm", bllm);
            response.sendRedirect("teller/loarn_details.jsp");
        }
    }

    private void saveLoanApplication(HttpServletRequest request, HttpServletResponse response, BnkLonLoanMaster bllm) throws IOException, ParseException {
        //Not define
    }

    private void saveLoanIssueAndRecover(HttpServletRequest request, HttpServletResponse response, BnkLonLoanMaster bllm) throws IOException, ParseException {
        //Not define
    }

    private void saveDocument(HttpServletRequest request, HttpServletResponse response, BnkLonLoanMaster bllm) throws IOException, ParseException {
        //Not define
    }

    private void savePrivateGuranter(HttpServletRequest request, HttpServletResponse response, BnkLonLoanMaster bllm) throws IOException, ParseException {
        //Not define
    }

    private void saveOtherGurant(HttpServletRequest request, HttpServletResponse response, BnkLonLoanMaster bllm) throws IOException, ParseException {
        //Not define
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
