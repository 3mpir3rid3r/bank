/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkLonLoanTypesDaoLocal;
import com.nbs.model.BnkLonLoanTypes;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class NewBnkLonLoanTypesServlet extends HttpServlet {

    @EJB
    private BnkLonLoanTypesDaoLocal bnkLonLoanTypesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<String> cp = new ArrayList<>();
        String error = "";

        int nLonTypeID = Integer.parseInt(request.getParameter("nLonTypeID"));

        boolean check = false;

        String cSysCode = request.getParameter("cSysCode");
        cp.add(cSysCode);
        if (cSysCode.isEmpty()) {
            check = true;
            error += "කේතය,";
        }

        String nLonCatIDString = request.getParameter("nLonCatID");
        cp.add(nLonCatIDString);
        int nDepCatID = 0;
        if (nLonCatIDString.equals("0")) {
            check = true;
            error += "ණය වර්ගය,";
        } else {
            nDepCatID = Integer.parseInt(nLonCatIDString);
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

        String cLonName = request.getParameter("cLonName");
        cp.add(cLonName);
        if (cLonName.isEmpty()) {
            check = true;
            error += "ණය නම,";
        }

        String cLonNameSin = request.getParameter("cLonNameSin");
        cp.add(cLonNameSin);
        if (cLonNameSin.isEmpty()) {
            check = true;
            error += "ණය නම(සිංහල),";
        }

        String cLonNameTamil = request.getParameter("cLonNameTamil");
        cp.add(cLonNameTamil);
        if (cLonNameTamil.isEmpty()) {
            check = true;
            error += "ණය නම(දෙමළ),";
        }

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

        String nMinLonAmtString = request.getParameter("nMinLonAmt");
        cp.add(nMinLonAmtString);
        BigDecimal nMinLonAmt = BigDecimal.ONE;
        if ("".equals(nMinLonAmtString)) {
            check = true;
        } else {
            nMinLonAmt = BigDecimal.valueOf(Double.parseDouble(nMinLonAmtString));
        }

        String nMaxLonAmtString = request.getParameter("nMaxLonAmt");
        cp.add(nMaxLonAmtString);
        BigDecimal nMaxLonAmt = BigDecimal.ONE;
        if ("".equals(nMaxLonAmtString)) {
            check = true;
        } else {
            nMaxLonAmt = BigDecimal.valueOf(Double.parseDouble(nMaxLonAmtString));
        }

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

        String bMultipleAcctString = "off";
        if (request.getParameter("bMultipleAcct") != null) {
            bMultipleAcctString = request.getParameter("bMultipleAcct");
        }
        boolean bMultipleAcct = false;
        if (bMultipleAcctString.equals("on")) {
            bMultipleAcct = true;
        }
        cp.add(bMultipleAcctString);

        //--------Calculate Lone----------
        String nCurrentIntString = request.getParameter("nCurrentInt");
        cp.add(nCurrentIntString);
        BigDecimal nCurrentInt = BigDecimal.ONE;
        if ("".equals(nCurrentIntString)) {
            check = true;
        } else {
            nCurrentInt = BigDecimal.valueOf(Double.parseDouble(nCurrentIntString));
        }

        String nLonInterestMethodIDString = request.getParameter("nLonInterestMethodID");
        cp.add(nLonInterestMethodIDString);
        short nLonInterestMethodID = 0;
        if (nLonInterestMethodIDString.equals("0")) {
            check = true;
            error += "ගිනුමට බැරවිම සෑම,";
        } else {
            nLonInterestMethodID = Short.parseShort(nLonInterestMethodIDString);
        }

        String nIntCalMethodIDString = request.getParameter("nIntCalMethodID");
        cp.add(nIntCalMethodIDString);
        short nIntCalMethodID = Short.parseShort(nIntCalMethodIDString);

        String nLonIntRoundIDString = request.getParameter("nLonIntRoundID");
        cp.add(nLonIntRoundIDString);
        Integer nLonIntRoundID = Integer.parseInt(nLonIntRoundIDString);

        String nPenaltyIntRateString = request.getParameter("nPenaltyIntRate");
        cp.add(nPenaltyIntRateString);
        BigDecimal nPenaltyIntRate = BigDecimal.ONE;
        if ("".equals(nPenaltyIntRateString)) {
            check = true;
        } else {
            nCurrentInt = BigDecimal.valueOf(Double.parseDouble(nPenaltyIntRateString));
        }

        String nPIntRateForIDString = request.getParameter("nPIntRateForID");
        cp.add(nPIntRateForIDString);
        short nPIntRateForID = 0;
        if (nPIntRateForIDString.equals("0")) {
            check = true;
            error += "Per,";
        } else {
            nPIntRateForID = Short.parseShort(nPIntRateForIDString);
        }

        String nPenaltyIntCalString = request.getParameter("nPenaltyIntCal");
        cp.add(nPenaltyIntCalString);
        short nPenaltyIntCal = 0;
        if ("".equals(nPenaltyIntCalString)) {
            check = true;
        } else {
            nPenaltyIntCal = Short.parseShort(nPenaltyIntCalString);
        }

        String nPIntCalForIDString = request.getParameter("nPIntCalForID");

        cp.add(nPIntCalForIDString);
        short nPIntCalForID = 0;
        if (nPIntCalForIDString.equals("0")) {
            check = true;
            error += " ,";
        } else {
            nPIntCalForID = Short.parseShort(nPIntCalForIDString);
        }

        String nPenaltyIntOP1String = request.getParameter("nPenaltyIntOP1");
        cp.add(nPenaltyIntOP1String);
        
        short nPenaltyIntOP1 = 0;
        if (nPenaltyIntOP1String.equals("1")) {
            nPenaltyIntOP1 = 1;
        }

        String nPenaltyIntOP2String = "off";
        if (request.getParameter("nPenaltyIntOP2") != null) {
            nPenaltyIntOP2String = request.getParameter("nPenaltyIntOP2");
        }
        short nPenaltyIntOP2 = 0;
        if (nPenaltyIntOP2String.equals("on")) {
            nPenaltyIntOP2 = 1;
        }
        cp.add(nPenaltyIntOP2String);

        //-------Lejar Relationship------------------
        String nAcctLevelID4LoanCapitalString = request.getParameter("num1_1");
        cp.add(nAcctLevelID4LoanCapitalString);
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz    " + nAcctLevelID4LoanCapitalString);
        int nAcctLevelID4LoanCapital = 0;
//        if (nAcctLevelID4LoanCapitalString!=null ||nAcctLevelID4LoanCapitalString.length()>0) {

        if (nAcctLevelID4LoanCapitalString == null) {
            check = true;
            error += "nAcctLevelID4LoanCapital,";
        } else {
            nAcctLevelID4LoanCapital = Short.parseShort(nAcctLevelID4LoanCapitalString);
        }

        String nAcctLevelID4InterestString = request.getParameter("num1_2");
        cp.add(nAcctLevelID4InterestString);
        int nAcctLevelID4Interest = 0;
        if (nAcctLevelID4InterestString == null) {
            check = true;
            error += "nAcctLevelID4Interest,";
        } else {
            nAcctLevelID4Interest = Short.parseShort(nAcctLevelID4InterestString);
        }

        String nAcctLevelID4PostageString = request.getParameter("num1_3");
        cp.add(nAcctLevelID4PostageString);
        int nAcctLevelID4Postage = 0;
        if (nAcctLevelID4PostageString == null) {
            check = true;
            error += "nAcctLevelID4Postage,";
        } else {
            nAcctLevelID4Postage = Short.parseShort(nAcctLevelID4PostageString);
        }

        String nAcctLevelID4StationaryString = request.getParameter("num1_4");
        cp.add(nAcctLevelID4StationaryString);
        int nAcctLevelID4Stationary = 0;
        if (nAcctLevelID4StationaryString == null) {
            check = true;
            error += "nAcctLevelID4Stationary,";
        } else {
            nAcctLevelID4Stationary = Short.parseShort(nAcctLevelID4StationaryString);
        }

        String nAcctLevelID4ArbitrationFeesString = request.getParameter("num1_6");
        cp.add(nAcctLevelID4ArbitrationFeesString);
        int nAcctLevelID4ArbitrationFees = 0;
        if (nAcctLevelID4ArbitrationFeesString == null) {
            check = true;
            error += "nAcctLevelID4ArbitrationFees,";
        } else {
            nAcctLevelID4ArbitrationFees = Short.parseShort(nAcctLevelID4ArbitrationFeesString);
        }

        String nAcctLevelID4LawFeesString = request.getParameter("num1_8");
        cp.add(nAcctLevelID4LawFeesString);
        int nAcctLevelID4LawFees = 0;
        if (nAcctLevelID4LawFeesString == null) {
            check = true;
            error += "nAcctLevelID4LawFees,";
        } else {
            nAcctLevelID4LawFees = Short.parseShort(nAcctLevelID4LawFeesString);
        }

        String nAcctLevelID4PenaltyInterestString = request.getParameter("num1_7");
        cp.add(nAcctLevelID4PenaltyInterestString);
        int nAcctLevelID4PenaltyInterest = 0;
        if (nAcctLevelID4PenaltyInterestString == null) {
            check = true;
            error += "nAcctLevelID4PenaltyInterest,";
        } else {
            nAcctLevelID4PenaltyInterest = Short.parseShort(nAcctLevelID4PenaltyInterestString);
        }

        String nAcctLevelID4FreeInt = request.getParameter("num1_9");
        cp.add(nAcctLevelID4FreeInt);
        int nAcctLevelID4FreeInterest = 0;
        if (nAcctLevelID4PenaltyInterestString == null) {
            check = true;
            error += "nAcctLevelID4FreeInterest,";
        } else {
            nAcctLevelID4PenaltyInterest = Short.parseShort(nAcctLevelID4PenaltyInterestString);
        }

        String userName = request.getParameter("userName");

        //--------------------------------------------
        if (check) {
            request.getSession().setAttribute("cp", cp);
            request.getSession().setAttribute("checkLoan", "on");
            request.getSession().setAttribute("mg", error);
            response.sendRedirect("GetterBnkLonDetailsServlet");
        } else {
            try {
                BnkLonLoanTypes bllt = new BnkLonLoanTypes(nLonTypeID);

                bllt.setCSysCode(cSysCode);
                bllt.setNLonCatID(nDepCatID);
                bllt.setCLonName(cLonName);
                bllt.setCLonNameSin(cLonNameSin);
                bllt.setCLonNameTamil(cLonNameTamil);
                bllt.setNMinParticipant(nMinParticipant);
                bllt.setNMaxParticipant(nMaxParticipant);
                bllt.setNMinAge(nMinAge);
                bllt.setNMaxAge(nMaxAge);
                bllt.setNMinLonAmt(nMinLonAmt);
                bllt.setNMaxLonAmt(nMaxLonAmt);
                bllt.setNMinMonths(nMinMonths);
                bllt.setNMaxMonths(nMaxMonths);
                bllt.setBMultipleAcct(bMultipleAcct);
                bllt.setNCurrentInt(nCurrentInt);
                bllt.setNLonInterestMethodID(nLonInterestMethodID);
                bllt.setNIntCalMethodID(nIntCalMethodID);
                bllt.setNLoanIntRoundID(nLonIntRoundID);
                bllt.setNPenaltyIntRate(nPenaltyIntRate);
                bllt.setNPenaltyIntRateForID(nPIntRateForID);
                bllt.setNIntCalMethodID(nIntCalMethodID);
                bllt.setNPenaltyIntCalAfter(nPenaltyIntCal);
                bllt.setNPenaltyIntCalAfterID(nPIntCalForID);//
                 bllt.setNPenaltyIntOP1(nPenaltyIntOP1);
                 bllt.setNPenaltyIntOP2(nPenaltyIntOP2);
                bllt.setNAcctLevelID4LoanCapital(nAcctLevelID4LoanCapital);
                bllt.setNAcctLevelID4Interest(nAcctLevelID4Interest);
                bllt.setNAcctLevelID4Postage(nAcctLevelID4Postage);
                bllt.setNAcctLevelID4Stationary(nAcctLevelID4Stationary);
                bllt.setNAcctLevelID4ArbitrationFees(nAcctLevelID4ArbitrationFees);
                bllt.setNAcctLevelID4LawFees(nAcctLevelID4LawFees);
                bllt.setNAcctLevelID4PenaltyInterest(nAcctLevelID4PenaltyInterest);
                bllt.setNAcctLevelID4FreeInterest(nAcctLevelID4FreeInterest);

                bnkLonLoanTypesDao.insertBnkLonLoanTypes(bllt, userName);
                String succes = "Updated";
                if (nLonTypeID == 0) {
                    succes = "Added";
                }

                request.getSession().removeAttribute("acctL1");
                request.getSession().removeAttribute("acctL2");
                request.getSession().removeAttribute("acctL3");
                request.getSession().removeAttribute("acctL4");
                request.getSession().removeAttribute("acctL5");
                request.getSession().removeAttribute("acctL6");
                request.getSession().removeAttribute("acctL7");
                request.getSession().removeAttribute("acctL8");
                request.getSession().removeAttribute("acctL9");

                request.getSession().removeAttribute("nLonTypeID");
                request.getSession().removeAttribute("cp");
                request.getSession().removeAttribute("checkLoan");

                response.sendRedirect("loan/?mg=" + succes);
            } catch (SQLException ex) {
                Logger.getLogger(NewBnkLonLoanTypesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
