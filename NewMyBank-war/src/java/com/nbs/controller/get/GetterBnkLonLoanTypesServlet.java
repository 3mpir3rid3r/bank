/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.dao.BnkLonLoanTypesDaoLocal;
import com.nbs.model.ActChartOfAcctL5;
import com.nbs.model.BnkLonLoanTypes;
import java.io.IOException;
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
public class GetterBnkLonLoanTypesServlet extends HttpServlet {

    @EJB
    private BnkActDaoLocal bnkActDao;

    @EJB
    private BnkLonLoanTypesDaoLocal bnkLonLoanTypesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nLonTypeIDString = request.getParameter("nLonTypeID");
        int nLonTypeID = Integer.parseInt(nLonTypeIDString);

        BnkLonLoanTypes allBnkLonLoanTypes = bnkLonLoanTypesDao.getAllBnkLonLoanTypes(nLonTypeID);

        ArrayList<String> cp = new ArrayList<>();

        cp.add(allBnkLonLoanTypes.getCSysCode());
        cp.add(String.valueOf(allBnkLonLoanTypes.getNLonCatID()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getBActive()));
        cp.add(allBnkLonLoanTypes.getCLonName());
        cp.add(allBnkLonLoanTypes.getCLonNameSin());
        cp.add(allBnkLonLoanTypes.getCLonNameTamil());
        //---------------------------
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMinParticipant()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMaxParticipant()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMinAge()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMaxAge()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMinLonAmt()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMaxLonAmt()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMinMonths()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNMaxMonths()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getBMultipleAcct()));
        //------------------------
        cp.add(String.valueOf(allBnkLonLoanTypes.getNCurrentInt()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNLonInterestMethodID()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNIntCalMethodID()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNLoanIntRoundID()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNPenaltyIntRate()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNPenaltyIntRateForID()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNPenaltyIntCalAfter()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNPenaltyIntCalAfterID()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNPenaltyIntOP1()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNPenaltyIntOP2()));
        //--------------------------------
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4LoanCapital()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4Interest()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4Postage()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4Stationary()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4ArbitrationFees()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4LawFees()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4PenaltyInterest()));
        cp.add(String.valueOf(allBnkLonLoanTypes.getNAcctLevelID4FreeInterest()));

        ActChartOfAcctL5 act5Data = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4LoanCapital());
        if (act5Data != null) {
            request.getSession().setAttribute("acctL1", act5Data);
        }
        ActChartOfAcctL5 act5Data1 = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4Interest());
        if (act5Data != null) {
            request.getSession().setAttribute("acctL2", act5Data1);
        }
        ActChartOfAcctL5 act5Data2 = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4Postage());
        if (act5Data != null) {
            request.getSession().setAttribute("acctL3", act5Data2);
        }
        ActChartOfAcctL5 act5Data3 = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4Stationary());
        if (act5Data != null) {
            request.getSession().setAttribute("acctL4", act5Data3);
        }

        if (allBnkLonLoanTypes.getNAcctLevelID4FreeInterest() != null) {
            ActChartOfAcctL5 act5Data4 = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4FreeInterest());
            if (act5Data != null) {
                request.getSession().setAttribute("acctL16", act5Data4);
            }
        }

        ActChartOfAcctL5 act5Data5 = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4LawFees());
        if (act5Data != null) {
            request.getSession().setAttribute("acctL7", act5Data5);
        }
        ActChartOfAcctL5 act5Data6 = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4PenaltyInterest());
        if (act5Data != null) {
            request.getSession().setAttribute("acctL8", act5Data6);
        }
        ActChartOfAcctL5 act5Data7 = bnkActDao.getAct5Data(allBnkLonLoanTypes.getNAcctLevelID4ArbitrationFees());
        if (act5Data != null) {
            request.getSession().setAttribute("acctL9", act5Data7);
        }

        request.getSession().setAttribute("nLonTypeID", String.valueOf(nLonTypeID));
        request.getSession().setAttribute("cp", cp);
        request.getSession().setAttribute("checkLoan", "on");
        response.sendRedirect("GetterBnkLonDetailsServlet?select=on");
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
