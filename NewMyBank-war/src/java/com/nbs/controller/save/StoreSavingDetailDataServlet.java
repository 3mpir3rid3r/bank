/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.model.BnkDepDepositMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class StoreSavingDetailDataServlet extends HttpServlet {

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
            //private boolean insertFixAndCertificetDetails(HttpServletRequest request, HttpServletResponse response, BnkDepDepositMaster bddm, boolean check) {

            BnkDepDepositMaster bddm = (BnkDepDepositMaster) request.getSession().getAttribute("insertDepositMaster");
            if (request.getParameter("removeCust") != null) {
                request.getSession().removeAttribute("inputCutomerDetails");
                response.sendRedirect("teller/saving_detail.jsp");
            } else if (("1").equals(request.getParameter("secNo"))) {

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                String bAmtHoldedString = request.getParameter("bAmtHolded");
                boolean bAmtHolded = false;
                if (bAmtHoldedString != null) {
                    bAmtHolded = true;
                }
                bddm.setBAmtHolded(bAmtHolded);

                String nHoldedAmountString = request.getParameter("nHoldedAmount");
                if (nHoldedAmountString.isEmpty()) {

                } else {
                    BigDecimal nHoldedAmount = BigDecimal.valueOf(Double.parseDouble(nHoldedAmountString));
                    bddm.setNHoldedAmount(nHoldedAmount);
                }

                String dHoldFromDate = request.getParameter("dHoldFromDate");
                if (dHoldFromDate.isEmpty()) {

                } else {
                    try {
                        bddm.setDHoldFromDate(formatter.parse(dHoldFromDate));
                    } catch (ParseException ex) {

                        //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                String dHoldToDate = request.getParameter("dHoldToDate");
                if (dHoldFromDate.isEmpty()) {

                } else {
                    try {
                        bddm.setDHoldToDate(formatter.parse(dHoldToDate));
                    } catch (ParseException ex) {

                        //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                String bIntHoldedString = request.getParameter("bIntHolded");
                boolean bIntHolded = false;
                if (bIntHoldedString != null) {
                    bIntHolded = true;
                }
                bddm.setBIntHolded(bIntHolded);

                String nHoldedAmountIntString = request.getParameter("nHoldedAmountInt");
                if (nHoldedAmountIntString.isEmpty()) {

                } else {
                    BigDecimal nHoldedAmountInt = BigDecimal.valueOf(Double.parseDouble(nHoldedAmountIntString));
                    bddm.setNHoldedAmountInt(nHoldedAmountInt);
                }

                String dIntHoldFromDate = request.getParameter("dIntHoldFromDate");
                if (dIntHoldFromDate.isEmpty()) {

                } else {
                    try {
                        bddm.setDIntHoldFromDate(formatter.parse(dIntHoldFromDate));
                    } catch (ParseException ex) {

                        //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                String dIntHoldToDate = request.getParameter("dIntHoldToDate");
                if (dIntHoldToDate.isEmpty()) {

                } else {
                    try {
                        bddm.setDIntHoldToDate(formatter.parse(dIntHoldToDate));
                    } catch (ParseException ex) {

                        //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                String nInstDRnDepMFIDString = request.getParameter("nInstDRnDepMFID");
                if (nInstDRnDepMFIDString == null) {

                } else {
                    BigInteger nInstDRnDepMFID = BigInteger.valueOf(Long.parseLong(nInstDRnDepMFIDString));
                    bddm.setNInstDRnDepMFID(nInstDRnDepMFID);
                }

                String nInstDRValueString = request.getParameter("nInstDRValue");
                if (nInstDRValueString.isEmpty()) {

                } else {
                    BigDecimal nInstDRValue = BigDecimal.valueOf(Double.parseDouble(nInstDRValueString));
                    bddm.setNInstDRValue(nInstDRValue);
                }

                String nTDDepositPeriodString = request.getParameter("nTDDepositPeriod");
                if (nTDDepositPeriodString.isEmpty()) {

                } else {
                    int nTDDepositPeriod = Integer.parseInt(nTDDepositPeriodString);
                    bddm.setNTDDepositPeriod(nTDDepositPeriod);
                }

                String nTDAgreedAmountString = request.getParameter("nTDAgreedAmount");
                if (nTDAgreedAmountString.isEmpty()) {

                } else {
                    BigDecimal nTDAgreedAmount = BigDecimal.valueOf(Double.parseDouble(nTDAgreedAmountString));
                    bddm.setNTDAgreedAmount(nTDAgreedAmount);
                }

                String nTDPaymentDayString = request.getParameter("nTDPaymentDay");
                if (nTDPaymentDayString.isEmpty()) {

                } else {
                    int nTDPaymentDay = Integer.parseInt(nTDPaymentDayString);
                    bddm.setNTDPaymentDay(nTDPaymentDay);
                }

                request.getSession().setAttribute("insertDepositMaster", bddm);
                response.sendRedirect("teller/view_depositmaster.jsp?tellerIndexKey=getSavingDetail1");

            } else {

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                String nFDIntialiDepositString = request.getParameter("nFDIntialiDeposit");
                if (nFDIntialiDepositString.isEmpty()) {

                } else {
                    BigDecimal nFDIntialiDeposit = BigDecimal.valueOf(Double.parseDouble(nFDIntialiDepositString));
                    bddm.setNFDIntialiDeposit(nFDIntialiDeposit);
                }

                String nFDPeriodString = request.getParameter("nFDPeriod");
                if (nFDPeriodString.isEmpty()) {

                } else {
                    int nFDPeriod = Integer.parseInt(nFDPeriodString);
                    bddm.setNFDPeriod(nFDPeriod);
                }

                String nFDPeriodTypeIDString = request.getParameter("nFDPeriodTypeID");
                if (nFDPeriodTypeIDString.equals("0")) {

                } else {
                    short nFDPeriodTypeID = Short.parseShort(nFDPeriodTypeIDString);
                    bddm.setNFDPeriodTypeID(nFDPeriodTypeID);
                }

                String dFDMaturityDateString = request.getParameter("dFDMaturityDate");
                if (dFDMaturityDateString.isEmpty()) {

                } else {
                    try {
                        Date dFDMaturityDate = formatter.parse(dFDMaturityDateString);
                        bddm.setDFDMaturityDate(dFDMaturityDate);
                    } catch (ParseException ex) {

                        //Logger.getLogger(NewDepDepositMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                String nFDMaturityValueString = request.getParameter("nFDMaturityValue");
                if (nFDMaturityValueString.isEmpty()) {

                } else {
                    BigDecimal nFDMaturityValue = BigDecimal.valueOf(Double.parseDouble(nFDMaturityValueString));
                    bddm.setNFDMaturityValue(nFDMaturityValue);
                }

                String cFDAgreementNo = request.getParameter("cFDAgreementNo");
                if (cFDAgreementNo.isEmpty()) {

                } else {
                    bddm.setCFDAgreementNo(cFDAgreementNo);
                }

                short nFDClosingMethodID = Short.parseShort(request.getParameter("nFDClosingMethodID"));
                bddm.setNFDClosingMethodID(nFDClosingMethodID);

                short nFDIntCalMethodID = Short.parseShort(request.getParameter("nFDIntCalMethodID"));
                bddm.setNFDIntCalMethodID(nFDIntCalMethodID);

                String nFDIntCalMethodValueString = request.getParameter("nFDIntCalMethodValue");
                if (nFDIntCalMethodValueString.isEmpty()) {

                } else {
                    int nFDIntCalMethodValue = Integer.parseInt(nFDIntCalMethodValueString);
                    bddm.setNFDIntCalMethodValue(nFDIntCalMethodValue);
                }

                short nFDIntCRMethodID = Short.parseShort(request.getParameter("nFDIntCRMethodID"));
                bddm.setNFDIntCRMethodID(nFDIntCRMethodID);

                String nFDIntCRMethodValueString = request.getParameter("nFDIntCRMethodValue");
                if (nFDIntCRMethodValueString.isEmpty()) {

                } else {
                    int nFDIntCRMethodValue = Integer.parseInt(nFDIntCRMethodValueString);
                    bddm.setNFDIntCRMethodValue(nFDIntCRMethodValue);
                }

                String bIntCreditingDiffAccString = request.getParameter("bIntCreditingDiffAcc");
                boolean bIntCreditingDiffAcc = false;
                if (bIntCreditingDiffAccString != null) {
                    bIntCreditingDiffAcc = true;
                }
                bddm.setBIntCreditingDiffAcc(bIntCreditingDiffAcc);

                String nIntCRnDepMFIDString = request.getParameter("nIntCRnDepMFID");
                if (nIntCRnDepMFIDString.isEmpty()) {

                } else {
                    BigInteger nIntCRnDepMFID = BigInteger.valueOf(Long.parseLong(nIntCRnDepMFIDString));
                    bddm.setNIntCRnDepMFID(nIntCRnDepMFID);
                }

                request.getSession().setAttribute("insertDepositMaster", bddm);

                response.sendRedirect("teller/view_depositmaster.jsp?tellerIndexKey=getSavingDetail");
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
