/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkDepDepositTypesDaoLocal;
import com.nbs.model.BnkDepDepositTypes;
import com.nbs.model.GenUser;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasa
 */
public class NewDepDopositTypesServlet extends HttpServlet {

    @EJB
    private BnkDepDepositTypesDaoLocal bnkDepDepositTypesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<String> cp = new ArrayList<>();
        String error = "";

        int nDepTypeID = Integer.parseInt(request.getParameter("nDepTypeID"));

        boolean check = false;

        String sysCode = request.getParameter("sysCode");
        cp.add(sysCode);
        if (sysCode.isEmpty()) {
            check = true;
            error += "කේතය,";
        }

        String nDepCatIDString = request.getParameter("nDepCatID");
        cp.add(nDepCatIDString);
        int nDepCatID = 0;
        if (nDepCatIDString.equals("0")) {
            check = true;
            error += "තැම්පත් වර්ගය,";
        } else {
            nDepCatID = Integer.parseInt(nDepCatIDString);
        }

        String bActiveString = "off";
        if (request.getParameter("bActive") != null) {
            bActiveString = request.getParameter("bActive");
        }
        boolean bActive = false;
        if (bActiveString.equals("on")) {
            bActive = true;
        }
        cp.add(bActiveString);

        String cDepName = request.getParameter("cDepName");
        cp.add(cDepName);
        if (cDepName.isEmpty()) {
            check = true;
            error += "තැම්පතේ නම,";
        }

        String cDepNameSin = request.getParameter("cDepNameSin");
        cp.add(cDepNameSin);
        if (cDepNameSin.isEmpty()) {
            check = true;
            error += "තැම්පතේ නම(සිංහල),";
        }

        String cDepNameTamil = request.getParameter("cDepNameTamil");
        cp.add(cDepNameTamil);
//        if (cDepNameTamil.isEmpty()) {
//            check = true;
//            error += "තැම්පතේ නම(දෙමළ),";
//        }

        //------AccStart Advice--------------------
        String nMinParticipantString = request.getParameter("nMinParticipant");
        cp.add(nMinParticipantString);
        int nMinParticipant = 0;
        if ("".equals(nMinParticipantString)) {
            check = true;
        } else {
            nMinParticipant = Integer.parseInt(nMinParticipantString);
        }

        String nMaxParticipantString = request.getParameter("nMaxParticipant");
        cp.add(nMaxParticipantString);
        int nMaxParticipant = 0;
        if ("".equals(nMaxParticipantString)) {
            check = true;
        } else {
            nMaxParticipant = Integer.parseInt(nMaxParticipantString);
        }

        String nMinAgeString = request.getParameter("nMinAge");
        cp.add(nMinAgeString);
        int nMinAge = 0;
        if ("".equals(nMinAgeString)) {
            check = true;
        } else {
            nMinAge = Integer.parseInt(nMinAgeString);
        }

        String nMaxAgeString = request.getParameter("nMaxAge");
        cp.add(nMaxAgeString);
        int nMaxAge = 0;
        if ("".equals(nMaxAgeString)) {
            check = true;
        } else {
            nMaxAge = Integer.parseInt(nMaxAgeString);
        }

        String nOperatingGenderTypeString = request.getParameter("nOperatingGenderType");
        cp.add(nOperatingGenderTypeString);
        short nOperatingGenderType = Short.parseShort(nOperatingGenderTypeString);

        String nMinAmtStartString = request.getParameter("nMinAmtStart");
        cp.add(nMinAmtStartString);
        BigDecimal nMinAmtStart = BigDecimal.ZERO;
        if (nMinAmtStartString.isEmpty()) {
            check = true;
            error += "ගිනුමක් අරම්බයට අවම මුදල,";
        } else {
            nMinAmtStart = BigDecimal.valueOf(Double.parseDouble(nMinAmtStartString));
        }

        String nMinAmtContinueString = request.getParameter("nMinAmtContinue");
        cp.add(nMinAmtContinueString);
        BigDecimal nMinAmtContinue = BigDecimal.ZERO;
        if (nMinAmtContinueString.isEmpty()) {
            check = true;
            error += "ගිනුමක් නඩත්තුවට අවම මුදල,";
        } else {
            nMinAmtContinue = BigDecimal.valueOf(Double.parseDouble(nMinAmtContinueString));
        }

        String bInitialDepCashString = "off";
        if (request.getParameter("bInitialDepCash") != null) {
            bInitialDepCashString = request.getParameter("bInitialDepCash");
        }
        boolean bInitialDepCash = false;
        if (bInitialDepCashString.equals("on")) {
            bInitialDepCash = true;
        }
        cp.add(bInitialDepCashString);

        String bInitialDepChqueString = "off";
        if (request.getParameter("bInitialDepChque") != null) {
            bInitialDepChqueString = request.getParameter("bInitialDepChque");
        }
        boolean bInitialDepChque = false;
        if (bInitialDepChqueString.equals("on")) {
            bInitialDepChque = true;
        }
        cp.add(bInitialDepChqueString);

        String bInitialDepFTrnansString = "off";
        if (request.getParameter("bInitialDepFTrnans") != null) {
            bInitialDepFTrnansString = request.getParameter("bInitialDepFTrnans");
        }
        boolean bInitialDepFTrnans = false;
        if (bInitialDepFTrnansString.equals("on")) {
            bInitialDepFTrnans = true;
        }
        cp.add(bInitialDepFTrnansString);

        String bMultipleAcctString = "off";
        if (request.getParameter("bMultipleAcct") != null) {
            bMultipleAcctString = request.getParameter("bMultipleAcct");
        }
        boolean bMultipleAcct = false;
        if (bMultipleAcctString.equals("on")) {
            bMultipleAcct = true;
        }
        cp.add(bMultipleAcctString);

        //--------Deposit/withdrowal Advice----------
        String nMinMonthsString = request.getParameter("nMinMonths");
        cp.add(nMinMonthsString);
        int nMinMonths = 0;
        if ("".equals(nMinMonthsString)) {
            check = true;
        } else {
            nMinMonths = Integer.parseInt(nMinMonthsString);
        }

        String nMaxMonthsString = request.getParameter("nMaxMonths");
        cp.add(nMaxMonthsString);
        int nMaxMonths = 0;
        if ("".equals(nMaxMonthsString)) {
            check = true;
        } else {
            nMaxMonths = Integer.parseInt(nMaxMonthsString);
        }

        String nWithdrawlsAllowedString = request.getParameter("nWithdrawlsAllowed");
        boolean nWithdrawlsAllowed = false; // ගිනුම සම්පූර්න වනතුරු මුදල් අපසු ගනිමට නොහැක 
        if (nWithdrawlsAllowedString.equals("2")) {
            nWithdrawlsAllowed = true; //ආපසු ගැනිමට ඉඩදිම 
        }
        cp.add(nWithdrawlsAllowedString);

        String nNoOfDaysString = request.getParameter("nNoOfDays");
        cp.add(nNoOfDaysString);
        BigDecimal nNoOfDays = BigDecimal.ONE;
        if ("".equals(nNoOfDaysString)) {
            check = true;
        } else {
            nNoOfDays = BigDecimal.valueOf(Double.parseDouble(nNoOfDaysString));
        }

        String nNoOfTimesPerMonthString = request.getParameter("nNoOfTimesPerMonth");
        cp.add(nNoOfTimesPerMonthString);
        int nNoOfTimesPerMonth = 0;
        if ("".equals(nNoOfTimesPerMonthString)) {
            check = true;
        } else {
            nNoOfTimesPerMonth = Integer.parseInt(nNoOfTimesPerMonthString);
        }

        String nMinAgeLimitWithdrawlsString = request.getParameter("nMinAgeLimitWithdrawls");
        cp.add(nMinAgeLimitWithdrawlsString);
        short nMinAgeLimitWithdrawls = 0;
        if ("".equals(nMinAgeLimitWithdrawlsString)) {
            check = true;
        } else {
            nMinAgeLimitWithdrawls = Short.parseShort(nMinAgeLimitWithdrawlsString);
        }

        //-------Interest Calculation Advice----------
        String nCurrentIntRateString = request.getParameter("nCurrentIntRate");
        cp.add(nCurrentIntRateString);
        BigDecimal nCurrentIntRate = BigDecimal.ZERO;
        if (nCurrentIntRateString.isEmpty()) {
            check = true;
            error += "පොළී අනුපාතය,";
        } else {
            nCurrentIntRate = BigDecimal.valueOf(Double.parseDouble(nCurrentIntRateString));
        }

        String nIntCalMethodIDString = request.getParameter("nIntCalMethodID");
        cp.add(nIntCalMethodIDString);
        short nIntCalMethodID = Short.parseShort(request.getParameter("nIntCalMethodID"));

        String nIntCalIDString = request.getParameter("nIntCalID");
        cp.add(nIntCalIDString);
        int nIntCalID = 0;
        if ("0".equals(nIntCalIDString)) {
            check = true;
            error += "ගණනය සෑම,";
        } else {
            nIntCalID = Integer.parseInt(nIntCalIDString);
        }

        String nIntPayIDString = request.getParameter("nIntPayID");
        cp.add(nIntPayIDString);
        int nIntPayID = 0;
        if ("0".equals(nIntPayIDString)) {
            check = true;
            error += "ගිනුමට බැරවිම සෑම,";
        } else {
            nIntPayID = Integer.parseInt(nIntPayIDString);
        }

        String nMinAmtIntCalString = request.getParameter("nMinAmtIntCal");
        cp.add(nMinAmtIntCalString);
        BigDecimal nMinAmtIntCal = BigDecimal.ZERO;
        if (nMinAmtIntCalString.isEmpty()) {
            check = true;
            error += "පොළී ගණනයට අවම මුදල,";
        } else {
            nMinAmtIntCal = BigDecimal.valueOf(Double.parseDouble(nMinAmtIntCalString));
        }

        String nMinAmtIntCRString = request.getParameter("nMinAmtIntCR");
        cp.add(nMinAmtIntCRString);
        BigDecimal nMinAmtIntCR = BigDecimal.ZERO;
        if (nMinAmtIntCRString.isEmpty()) {
            check = true;
            error += "බැර කිරිමට අවම පොළී මුදල,";
        } else {
            nMinAmtIntCR = BigDecimal.valueOf(Double.parseDouble(nMinAmtIntCRString));
        }

        String nInterestRoundMethodString = request.getParameter("nInterestRoundMethod");
        cp.add(nInterestRoundMethodString);
        int nInterestRoundMethod = Integer.parseInt(nInterestRoundMethodString);//option

        //-------Lejar Relationship------------------
        String nDepAcctLevelID4String = request.getParameter("nDepAcctLevelID4");
        cp.add(nDepAcctLevelID4String);
        int nDepAcctLevelID4 = 0;
        if (nDepAcctLevelID4String.isEmpty()) {
            check = true;
            error += "DepAcctLevelID4,";
        } else {
            nDepAcctLevelID4 = Integer.parseInt(nDepAcctLevelID4String);
        }

        String nIntAcctLevelID4String = request.getParameter("nIntAcctLevelID4");
        cp.add(nIntAcctLevelID4String);
        int nIntAcctLevelID4 = 0;
        if (nIntAcctLevelID4String.isEmpty()) {
            check = true;
            error += "IntAcctLevelID4,";
        } else {
            nIntAcctLevelID4 = Integer.parseInt(nIntAcctLevelID4String);
        }

        //---------Other Details---------------------
        String bChangeToInactiveString = "off";
        if (request.getParameter("bChangeToInactive") != null) {
            bChangeToInactiveString = request.getParameter("bChangeToInactive");
        }
        boolean bChangeToInactive = false;
        if (bChangeToInactiveString.equals("on")) {
            bChangeToInactive = true;
        }
        cp.add(bChangeToInactiveString);

        String nInacPeriodString = request.getParameter("nInacPeriod");
        cp.add(nInacPeriodString);
        int nInacPeriod = 0;
        if ("".equals(nInacPeriodString)) {
            check = true;
        } else {
            nInacPeriod = Integer.parseInt(nInacPeriodString);
        }

        String cInacPeriodTypeString = request.getParameter("cInacPeriodType");//selection
        
        String cInacPeriodType = "";
        if (cInacPeriodTypeString != null) {
            switch (cInacPeriodTypeString) {
                case "0":
                    check = true;
                    error += "InacPeriodType,";
                    break;
                case "1":
                    cInacPeriodType = "Day";
                    break;
                case "2":
                    cInacPeriodType = "Month";
                    break;
                case "3":
                    cInacPeriodType = "Year";
                    break;
            }
        } else {
            check = true;
            error += "InacPeriodType,";
        }
        cp.add(cInacPeriodTypeString);

        String bChangeToHimiNopaString = "off";
        if (request.getParameter("bChangeToHimiNopa") != null) {
            bChangeToHimiNopaString = request.getParameter("bChangeToHimiNopa");
        }
        boolean bChangeToHimiNopa = false;
        if (bChangeToHimiNopaString.equals("on")) {
            bChangeToHimiNopa = true;
        }
        cp.add(bChangeToHimiNopaString);

        String nHimiPeriodString = request.getParameter("nHimiPeriod");
        cp.add(nHimiPeriodString);
        int nHimiPeriod = 0;
        if (nHimiPeriodString.isEmpty()) {
            check = true;
        } else {
            nHimiPeriod = Integer.parseInt(nHimiPeriodString);
        }

        String nHimiPeriodTypeSring = request.getParameter("nHimiPeriodType");//selection
        String nHimiPeriodType = "";
        if (nHimiPeriodTypeSring != null) {
            switch (nHimiPeriodTypeSring) {
                case "0":
                    check = true;
                    error += "nHimiPeriodType,";
                    break;
                case "1":
                    nHimiPeriodType = "Day";
                    break;
                case "2":
                    nHimiPeriodType = "Month";
                    break;
                case "3":
                    nHimiPeriodType = "Year";
                    break;
            }
        } else {
            check = true;
            error += "nHimiPeriodType,";
        }
        cp.add(nHimiPeriodTypeSring);

        String nBonusIntRateString = request.getParameter("nBonusIntRate");
        cp.add(nBonusIntRateString);
        BigDecimal nBonusIntRate = BigDecimal.ZERO;
        if (nBonusIntRateString.isEmpty()) {
            check = true;
            error += "බෝනස් පොළිය,";
        } else {
            nBonusIntRate = BigDecimal.valueOf(Double.parseDouble(nBonusIntRateString));
        }

        String nLoanAmountString = request.getParameter("nLoanAmount");
        cp.add(nLoanAmountString);
        cp.add("");
        BigDecimal nLoanAmount = BigDecimal.ZERO;
        if (nLoanAmountString.isEmpty()) {
            check = true;
            error += "ණය මුදල,";
        } else {
            nLoanAmount = BigDecimal.valueOf(Double.parseDouble(nLoanAmountString));
        }

//        String userName = request.getParameter("userName");
        GenUser user = (GenUser) request.getSession().getAttribute("user");

        //--------------------------------------------
        if (check) {
            // request.getSession().setAttribute("cp", cp);
            request.getSession().setAttribute("checkSaving", "on");
            request.getSession().setAttribute("mg", error);
            response.sendRedirect("GetterBnkDepDetailsServlet");
        } else {
            BnkDepDepositTypes bddt = new BnkDepDepositTypes();
            bddt.setNDepTypeID(nDepTypeID);
            bddt.setNDepCatID(nDepCatID);
            bddt.setCSysCode(sysCode);
            bddt.setCDepName(cDepName);
            bddt.setCDepNameSin(cDepNameSin);
            bddt.setCDepNameTamil(cDepNameTamil);
            bddt.setNMinParticipant(nMinParticipant);
            bddt.setNMaxParticipant(nMaxParticipant);
            bddt.setNMinAge(nMinAge);
            bddt.setNMaxAge(nMaxAge);
            bddt.setNOperatingGenderType(nOperatingGenderType);
            bddt.setNMinAmtStart(nMinAmtStart);
            bddt.setNMinAmtContinue(nMinAmtContinue);
            bddt.setBInitialDepCash(bInitialDepCash);
            bddt.setBInitialDepChque(bInitialDepChque);
            bddt.setBInitialDepFTrnans(bInitialDepFTrnans);
            bddt.setBMultipleAcct(bMultipleAcct);
            bddt.setNMinMonths(nMinMonths);
            bddt.setNMaxMonths(nMaxMonths);
            bddt.setBWithdrawlsAllowed(nWithdrawlsAllowed);
            bddt.setNNoOfDays(nNoOfDays);
            bddt.setNNoOfTimesPerMonth(nNoOfTimesPerMonth);
            bddt.setNMinAgeLimitWithdrawls(nMinAgeLimitWithdrawls);
            bddt.setNCurrentIntRate(nCurrentIntRate);
            bddt.setNIntCalMethodID(nIntCalMethodID);
            bddt.setNIntCalID(nIntCalID);
            bddt.setNIntPayID(nIntPayID);
            bddt.setNMinAmtIntCal(nMinAmtIntCal);
            bddt.setNMinAmtIntCR(nMinAmtIntCR);
            bddt.setNInterestRoundMethod(nIntCalMethodID);
            bddt.setNAcctLevelID5Capital(nDepAcctLevelID4);
            bddt.setNAcctLevelID5Interest(nIntAcctLevelID4);
            bddt.setBChangeToInactive(bChangeToInactive);
            bddt.setNInacPeriod(nInacPeriod);
            bddt.setCInacPeriodType(cInacPeriodType);
            bddt.setBChangeToHimiNopa(bChangeToHimiNopa);
            bddt.setNHimiPeriod(nHimiPeriod);
            bddt.setNHimiPeriodType(nHimiPeriodType);
            bddt.setCRemarks("");
            bddt.setBActive(bActive);
            bddt.setNBonusIntRate(nBonusIntRate);
            bddt.setNLoanAmount(nLoanAmount);
            
            int insertBnkDepDepositTypes = bnkDepDepositTypesDao.insertBnkDepDepositTypes(bddt, user.getCUserName());
            
            request.getSession().removeAttribute("cp");
            request.getSession().removeAttribute("actid");
            request.getSession().removeAttribute("nDepTypeID");
            request.getSession().removeAttribute("acctL10");
            request.getSession().removeAttribute("chartOfAccount5Data11");
            request.getSession().removeAttribute("acctL11");
            request.getSession().removeAttribute("chartOfAccount5Data10");
            if (insertBnkDepDepositTypes > 0) {
                if (nDepTypeID > 0) {
                    response.sendRedirect("saving/index.jsp?mg=Updated ");
                    request.getSession().removeAttribute("cp");
                } else {
                    response.sendRedirect("saving/index.jsp?mg=Added ");
                    request.getSession().removeAttribute("cp");
                }
            } else {
                response.sendRedirect("saving/index.jsp");
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
