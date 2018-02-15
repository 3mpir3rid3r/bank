/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.model.BnkCustomerMaster;
import com.nbs.model.BnkDepDepositMaster;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class NewDepDepositMasterServlet extends HttpServlet {

    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BnkDepDepositMaster bddm;
        if (request.getSession().getAttribute("insertDepositMaster") == null) {
            bddm = new BnkDepDepositMaster();
        } else {
            bddm = (BnkDepDepositMaster) request.getSession().getAttribute("insertDepositMaster");
        }

        boolean check = false;
        String saveType = request.getParameter("saveType");
        System.out.println(saveType + " 1");
        switch (saveType) {
            case "1":
                boolean insDepDetailsResult = insertDepositDetails(request, response, bddm, check);
                if (insDepDetailsResult) {
                    System.out.println("01");
                    request.getSession().setAttribute("insertDepositMaster", bddm);
                    response.sendRedirect("SavingDetailsServlet?nDepTypeID=" + bddm.getNDepTypeID());
                } else {
                    System.out.println("00");
                    int nRecID = bnkDepDepositMasterDao.insertBnkDepDepositMaster(bddm);
                    bddm.setNDepMFID(Long.parseLong(String.valueOf(nRecID)));
                    request.getSession().setAttribute("insertDepositMaster", bddm);
                    request.getSession().setAttribute("saveType", "1");
                    request.getSession().setAttribute("nextBtnCheck", "1");
                    if (request.getSession().getAttribute("depDetailsCheck") != null) {
                        request.getSession().removeAttribute("depDetailsCheck");
                    }

                    response.sendRedirect("SavingDetailsServlet?nDepTypeID=" + bddm.getNDepTypeID());
                }
                break;
            case "2":
                boolean insFixDetailsResult = insertFixAndCertificetDetails(request, response, bddm, check);
                if (insFixDetailsResult) {
                    request.getSession().setAttribute("insertDepositMaster", bddm);
                    response.sendRedirect("SavingDetailsServlet?nDepTypeID=" + bddm.getNDepTypeID());
                } else {
                    //int nRecID = bnkDepDepositMasterDao.insertBnkDepDepositMaster(bddm);
                    request.getSession().setAttribute("insertDepositMaster", bddm);
                    request.getSession().setAttribute("saveType", "2");
                    request.getSession().setAttribute("nextBtnCheck", "2");
                    response.sendRedirect("SavingDetailsServlet?nDepTypeID=" + bddm.getNDepTypeID());
                }
                break;
            case "3":
                boolean insAccControllResult = insertAccControll(request, response, bddm, check);
                if (insAccControllResult) {
                    request.getSession().setAttribute("insertDepositMaster", bddm);
                    response.sendRedirect("SavingDetailsServlet?nDepTypeID=" + bddm.getNDepTypeID());
                } else {
                    int nRecID = bnkDepDepositMasterDao.insertBnkDepDepositMaster(bddm);
                    request.getSession().setAttribute("insertDepositMaster", bddm);
                    request.getSession().setAttribute("saveType", "3");
                    request.getSession().setAttribute("nextBtnCheck", "3");
                    response.sendRedirect("SavingDetailsServlet?nDepTypeID=" + bddm.getNDepTypeID());
                }
                break;
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

    private boolean insertDepositDetails(HttpServletRequest request, HttpServletResponse response, BnkDepDepositMaster bddm, boolean check) {
        try {

            String nDepMFIDString = request.getParameter("nDepMFID");
            System.out.println(nDepMFIDString + " 2");

            Long nDepMFID = Long.parseLong(nDepMFIDString);
            bddm.setNDepMFID(nDepMFID);

            String nDepTypeIDString = request.getParameter("nDepTypeID");
            System.out.println(nDepTypeIDString + " 3");

            if (nDepTypeIDString == null) {
                nDepTypeIDString = (String) request.getSession().getAttribute("nDepTypeIDDataTest");
            }

            System.out.println(nDepTypeIDString);
            if (("0").equals(nDepTypeIDString)) {
                bddm.setNDepTypeID(0);
                check = true;
            } else {
                int nDepTypeID = Integer.parseInt(nDepTypeIDString);
                bddm.setNDepTypeID(nDepTypeID);
            }

            String nCustomerIDString = request.getParameter("nCustomerID");
            System.out.println(nCustomerIDString + " 4");

            bddm.setNCustomerID(new BnkCustomerMaster(Long.parseLong(nCustomerIDString)));

            String nBankBranchIDString = "0";
            int nBankBranchID = Integer.parseInt(nBankBranchIDString);
            bddm.setNBankBranchID(nBankBranchID);

            String cOurAccountNo = request.getParameter("cOurAccountNo");
            System.out.println(cOurAccountNo + " 5");

            if (cOurAccountNo.isEmpty()) {
                bddm.setCOurAccountNo("");
                check = true;
            } else {
                bddm.setCOurAccountNo(cOurAccountNo);
            }

            String cSerialNo = request.getParameter("cSerialNo");
            System.out.println(cSerialNo + " 6");

            if (cSerialNo.isEmpty()) {
                check = true;
            } else {
                bddm.setCSerialNo(cSerialNo);
            }

            String nLedgerBookNoString = request.getParameter("nLedgerBookNo");
            System.out.println(nLedgerBookNoString + " 7");

            if (nLedgerBookNoString.isEmpty()) {
                check = true;
            } else {
                int nLedgerBookNo = Integer.parseInt(nLedgerBookNoString);
                bddm.setNLedgerBookNo(nLedgerBookNo);
            }

            String nEffectiveIntString = request.getParameter("nEffectiveInt");
            System.out.println(nEffectiveIntString + " 8");

            if (nEffectiveIntString.isEmpty()) {
                check = true;
            } else {
                BigDecimal nEffectiveInt = BigDecimal.valueOf(Double.parseDouble(nEffectiveIntString));
                bddm.setNEffectiveInt(nEffectiveInt);
            }

            String bJointString = request.getParameter("bJoint");
            System.out.println(bJointString + " 9");

            boolean bJoint = false;
            if (bJointString.equals("1")) {
                bJoint = true;
            }
            bddm.setBJoint(bJoint);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            String dStartDateString = request.getParameter("dStartDate");
            System.out.println(dStartDateString + " 10");

            if (dStartDateString.isEmpty()) {
                check = true;
            } else {
                Date dStartDate = formatter.parse(dStartDateString);
                bddm.setDStartDate(dStartDate);
            }

            bddm.setNAcctStatusID(1);

            bddm.setNFDIntialiDeposit(BigDecimal.ZERO);
            bddm.setNFDPeriod(0);
            bddm.setNFDPeriodTypeID(Short.valueOf("0"));

            Date date = new Date();
            String dateString = formatter.format(date);

            bddm.setDFDMaturityDate(formatter.parse(dateString));
            bddm.setNFDMaturityValue(BigDecimal.ZERO);
            bddm.setCFDAgreementNo("");
            bddm.setNFDClosingMethodID(Short.valueOf("0"));
            bddm.setNFDIntCalMethodID(Short.valueOf("0"));
            bddm.setNFDIntCalMethodValue(0);

            bddm.setNFDIntCRMethodID(Short.valueOf("0"));
            bddm.setNFDIntCRMethodValue(0);
            bddm.setBIntCreditingDiffAcc(false);
            bddm.setNIntCRnDepMFID(BigInteger.ZERO);

            bddm.setBAmtHolded(false);
            bddm.setNHoldedAmount(BigDecimal.ZERO);
            bddm.setDHoldFromDate(formatter.parse(dateString));
            bddm.setDHoldToDate(formatter.parse(dateString));
            bddm.setBIntHolded(false);
            bddm.setNHoldedAmountInt(BigDecimal.ZERO);
            bddm.setDIntHoldFromDate(formatter.parse(dateString));
            bddm.setDIntHoldToDate(formatter.parse(dateString));
            bddm.setNInstDRnDepMFID(BigInteger.ZERO);
            bddm.setNInstDRValue(BigDecimal.ZERO);
            bddm.setNTDDepositPeriod(0);
            bddm.setNTDAgreedAmount(BigDecimal.ZERO);
            bddm.setNTDPaymentDay(0);

            String userName = request.getParameter("userName");
            System.out.println(userName + " 11");

            bddm.setCAddBy(userName);

            return check;

        } catch (ParseException ex) {
            Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
            return check;
        }
    }

    private boolean insertFixAndCertificetDetails(HttpServletRequest request, HttpServletResponse response, BnkDepDepositMaster bddm, boolean check) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String nFDIntialiDepositString = request.getParameter("nFDIntialiDeposit");
        System.out.println(nFDIntialiDepositString + " 12");

        if (nFDIntialiDepositString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nFDIntialiDeposit = BigDecimal.valueOf(Double.parseDouble(nFDIntialiDepositString));
            bddm.setNFDIntialiDeposit(nFDIntialiDeposit);
        }

        String nFDPeriodString = request.getParameter("nFDPeriod");
        System.out.println(nFDPeriodString + " 13");

        if (nFDPeriodString.isEmpty()) {
            check = true;
        } else {
            int nFDPeriod = Integer.parseInt(nFDPeriodString);
            bddm.setNFDPeriod(nFDPeriod);
        }

        String nFDPeriodTypeIDString = request.getParameter("nFDPeriodTypeID");
        System.out.println(nFDPeriodTypeIDString + " 14");

        if (nFDPeriodTypeIDString.equals("0")) {
            check = true;
        } else {
            short nFDPeriodTypeID = Short.parseShort(nFDPeriodTypeIDString);
            bddm.setNFDPeriodTypeID(nFDPeriodTypeID);
        }

        String dFDMaturityDateString = request.getParameter("dFDMaturityDate");
        System.out.println(dFDMaturityDateString + " 15");

        if (dFDMaturityDateString.isEmpty()) {
            check = true;
        } else {
            try {
                Date dFDMaturityDate = formatter.parse(dFDMaturityDateString);
                bddm.setDFDMaturityDate(dFDMaturityDate);
            } catch (ParseException ex) {
                check = true;
                //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String nFDMaturityValueString = request.getParameter("nFDMaturityValue");
        System.out.println(nFDMaturityValueString + " 16");

        if (nFDMaturityValueString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nFDMaturityValue = BigDecimal.valueOf(Double.parseDouble(nFDMaturityValueString));
            bddm.setNFDMaturityValue(nFDMaturityValue);
        }

        String cFDAgreementNo = request.getParameter("cFDAgreementNo");
        System.out.println(cFDAgreementNo + " 17");

        if (cFDAgreementNo.isEmpty()) {
            check = true;
        } else {
            bddm.setCFDAgreementNo(cFDAgreementNo);
        }

        short nFDClosingMethodID = Short.parseShort(request.getParameter("nFDClosingMethodID"));
        System.out.println(nFDClosingMethodID + " 18");

        bddm.setNFDClosingMethodID(nFDClosingMethodID);

        short nFDIntCalMethodID = Short.parseShort(request.getParameter("nFDIntCalMethodID"));
        System.out.println(nFDIntCalMethodID + " 19");

        bddm.setNFDIntCalMethodID(nFDIntCalMethodID);

        String nFDIntCalMethodValueString = request.getParameter("nFDIntCalMethodValue");
        System.out.println(nFDIntCalMethodValueString + " 20");

        if (nFDIntCalMethodValueString.isEmpty()) {
            check = true;
        } else {
            int nFDIntCalMethodValue = Integer.parseInt(nFDIntCalMethodValueString);
            bddm.setNFDIntCalMethodValue(nFDIntCalMethodValue);
        }

        short nFDIntCRMethodID = Short.parseShort(request.getParameter("nFDIntCRMethodID"));
        System.out.println(nFDIntCRMethodID + " 21");

        bddm.setNFDIntCRMethodID(nFDIntCRMethodID);

        String nFDIntCRMethodValueString = request.getParameter("nFDIntCRMethodValue");
        System.out.println(nFDIntCRMethodValueString + " 22");

        if (nFDIntCRMethodValueString.isEmpty()) {
            check = true;
        } else {
            int nFDIntCRMethodValue = Integer.parseInt(nFDIntCRMethodValueString);
            bddm.setNFDIntCRMethodValue(nFDIntCRMethodValue);
        }

        String bIntCreditingDiffAccString = request.getParameter("bIntCreditingDiffAcc");
        System.out.println(bIntCreditingDiffAccString + " 23");

        boolean bIntCreditingDiffAcc = false;
        if (bIntCreditingDiffAccString != null) {
            bIntCreditingDiffAcc = true;
        }
        bddm.setBIntCreditingDiffAcc(bIntCreditingDiffAcc);

        String nIntCRnDepMFIDString = request.getParameter("nIntCRnDepMFID");
        System.out.println(nIntCRnDepMFIDString + " 24");

        if (nIntCRnDepMFIDString.isEmpty()) {
            check = true;
        } else {
            BigInteger nIntCRnDepMFID = BigInteger.valueOf(Long.parseLong(nIntCRnDepMFIDString));
            bddm.setNIntCRnDepMFID(nIntCRnDepMFID);
        }
        return check;
    }

    private boolean insertAccControll(HttpServletRequest request, HttpServletResponse response, BnkDepDepositMaster bddm, boolean check) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String bAmtHoldedString = request.getParameter("bAmtHolded");
        System.out.println(bAmtHoldedString + " 25");

        boolean bAmtHolded = false;
        if (bAmtHoldedString != null) {
            bAmtHolded = true;
        }
        bddm.setBAmtHolded(bAmtHolded);

        String nHoldedAmountString = request.getParameter("nHoldedAmount");
        System.out.println(nHoldedAmountString + " 26");

        if (nHoldedAmountString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nHoldedAmount = BigDecimal.valueOf(Double.parseDouble(nHoldedAmountString));
            bddm.setNHoldedAmount(nHoldedAmount);
        }

        String dHoldFromDate = request.getParameter("dHoldFromDate");
        System.out.println(dHoldFromDate + " 27");

        if (dHoldFromDate.isEmpty()) {
            check = true;
        } else {
            try {
                bddm.setDHoldFromDate(formatter.parse(dHoldFromDate));
            } catch (ParseException ex) {
                check = true;
                //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String dHoldToDate = request.getParameter("dHoldToDate");
        System.out.println(dHoldToDate + " 28");

        if (dHoldFromDate.isEmpty()) {
            check = true;
        } else {
            try {
                bddm.setDHoldToDate(formatter.parse(dHoldToDate));
            } catch (ParseException ex) {
                check = true;
                //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String bIntHoldedString = request.getParameter("bIntHolded");
        System.out.println(bIntHoldedString + " 29");

        boolean bIntHolded = false;
        if (bIntHoldedString != null) {
            bIntHolded = true;
        }
        bddm.setBIntHolded(bIntHolded);

        String nHoldedAmountIntString = request.getParameter("nHoldedAmountInt");
        System.out.println(nHoldedAmountIntString + " 30");

        if (nHoldedAmountIntString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nHoldedAmountInt = BigDecimal.valueOf(Double.parseDouble(nHoldedAmountIntString));
            bddm.setNHoldedAmountInt(nHoldedAmountInt);
        }

        String dIntHoldFromDate = request.getParameter("dIntHoldFromDate");
        System.out.println(dIntHoldFromDate + " 31");

        if (dIntHoldFromDate.isEmpty()) {
            check = true;
        } else {
            try {
                bddm.setDIntHoldFromDate(formatter.parse(dIntHoldFromDate));
            } catch (ParseException ex) {
                check = true;
                //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String dIntHoldToDate = request.getParameter("dIntHoldToDate");
        System.out.println(dIntHoldToDate + " 32");

        if (dIntHoldToDate.isEmpty()) {
            check = true;
        } else {
            try {
                bddm.setDIntHoldToDate(formatter.parse(dIntHoldToDate));
            } catch (ParseException ex) {
                check = true;
                //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String nInstDRnDepMFIDString = request.getParameter("nInstDRnDepMFID");
        System.out.println(nInstDRnDepMFIDString + " 33");

        if (nInstDRnDepMFIDString.isEmpty()) {
            check = true;
        } else {
            BigInteger nInstDRnDepMFID = BigInteger.valueOf(Long.parseLong(nInstDRnDepMFIDString));
            bddm.setNInstDRnDepMFID(nInstDRnDepMFID);
        }

        String nInstDRValueString = request.getParameter("nInstDRValue");
        System.out.println(nInstDRValueString + " 34");

        if (nInstDRValueString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nInstDRValue = BigDecimal.valueOf(Double.parseDouble(nInstDRValueString));
            bddm.setNInstDRValue(nInstDRValue);
        }

        String nTDDepositPeriodString = request.getParameter("nTDDepositPeriod");
        System.out.println(nTDDepositPeriodString + " 35");

        if (nTDDepositPeriodString.isEmpty()) {
            check = true;
        } else {
            int nTDDepositPeriod = Integer.parseInt(nTDDepositPeriodString);
            bddm.setNTDDepositPeriod(nTDDepositPeriod);
        }

        String nTDAgreedAmountString = request.getParameter("nTDAgreedAmount");
        System.out.println(nTDAgreedAmountString + " 36");

        if (nTDAgreedAmountString.isEmpty()) {
            check = true;
        } else {
            BigDecimal nTDAgreedAmount = BigDecimal.valueOf(Double.parseDouble(nTDAgreedAmountString));
            bddm.setNTDAgreedAmount(nTDAgreedAmount);
        }

        String nTDPaymentDayString = request.getParameter("nTDPaymentDay");
        System.out.println(nTDPaymentDayString + " 37");

        if (nTDPaymentDayString.isEmpty()) {
            check = true;
        } else {
            int nTDPaymentDay = Integer.parseInt(nTDPaymentDayString);
            bddm.setNTDPaymentDay(nTDPaymentDay);
        }

        return check;
    }

}
