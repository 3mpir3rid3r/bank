/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.dao.BnkDepDepositTypesDaoLocal;
import com.nbs.model.ActChartOfAcctL5;
import com.nbs.model.BnkDepDepositTypes;
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
public class GetterBnkDepDepositTypesServlet extends HttpServlet {
    @EJB
    private BnkActDaoLocal bnkActDao;

    @EJB
    private BnkDepDepositTypesDaoLocal bnkDepDepositTypesDao;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nDepTypeIDString = request.getParameter("nDepTypeID");
        int nDepTypeID = Integer.parseInt(nDepTypeIDString);
        BnkDepDepositTypes bddt = bnkDepDepositTypesDao.getOneBnkDepDepositTypes(nDepTypeID);

        ArrayList<String> cp = new ArrayList<>();

        cp.add(bddt.getCSysCode());
        cp.add(String.valueOf(bddt.getNDepCatID()));
        cp.add(String.valueOf(bddt.getBActive()));
        cp.add(String.valueOf(bddt.getCDepName()));
        cp.add(String.valueOf(bddt.getCDepNameSin()));
        cp.add(String.valueOf(bddt.getCDepNameTamil()));
        //------------------------------------------------
        cp.add(String.valueOf(bddt.getNMinParticipant()));
        cp.add(String.valueOf(bddt.getNMaxParticipant()));
        cp.add(String.valueOf(bddt.getNMinAge()));
        cp.add(String.valueOf(bddt.getNMaxAge()));
        cp.add(String.valueOf(bddt.getNOperatingGenderType()));
        cp.add(String.valueOf(bddt.getNMinAmtStart()));
        cp.add(String.valueOf(bddt.getNMinAmtContinue()));
        cp.add(String.valueOf(bddt.getBInitialDepCash()));
        cp.add(String.valueOf(bddt.getBInitialDepChque()));
        cp.add(String.valueOf(bddt.getBInitialDepFTrnans()));
        cp.add(String.valueOf(bddt.getBMultipleAcct()));
        //--------------------------------------------------
        cp.add(String.valueOf(bddt.getNMinMonths()));
        cp.add(String.valueOf(bddt.getNMaxMonths()));
        cp.add(String.valueOf(bddt.getBWithdrawlsAllowed()));
        cp.add(String.valueOf(bddt.getNNoOfDays()));
        cp.add(String.valueOf(bddt.getNNoOfTimesPerMonth()));
        cp.add(String.valueOf(bddt.getNMinAgeLimitWithdrawls()));
        //--------------------------------------------------------
        cp.add(String.valueOf(bddt.getNCurrentIntRate()));
        cp.add(String.valueOf(bddt.getNIntCalMethodID()));
        cp.add(String.valueOf(bddt.getNIntCalID()));
        cp.add(String.valueOf(bddt.getNIntPayID()));
        cp.add(String.valueOf(bddt.getNMinAmtIntCal()));
        cp.add(String.valueOf(bddt.getNMinAmtIntCR()));
        cp.add(String.valueOf(bddt.getNInterestRoundMethod()));
        //------------------------------------------------------
        cp.add(String.valueOf(bddt.getNAcctLevelID5Capital()));
        cp.add(String.valueOf(bddt.getNAcctLevelID5Interest()));
        //----------------------------------------------------
        cp.add(String.valueOf(bddt.getBChangeToInactive()));
        cp.add(String.valueOf(bddt.getNInacPeriod()));
        cp.add(String.valueOf(bddt.getCInacPeriodType()));
        cp.add(String.valueOf(bddt.getBChangeToHimiNopa()));
        cp.add(String.valueOf(bddt.getNHimiPeriod()));
        cp.add(String.valueOf(bddt.getNHimiPeriodType()));
        cp.add(String.valueOf(bddt.getNBonusIntRate()));
        cp.add(String.valueOf(bddt.getNLoanAmount()));
        cp.add(nDepTypeIDString);
        
         ActChartOfAcctL5 act5Data = bnkActDao.getAct5Data(bddt.getNAcctLevelID5Capital());
        if(act5Data!=null){
           request.getSession().setAttribute("acctL10",act5Data ); 
        }
        ActChartOfAcctL5 act5Data1 = bnkActDao.getAct5Data(bddt.getNAcctLevelID5Interest());
        if(act5Data!=null){
           request.getSession().setAttribute("acctL11",act5Data1 ); 
        }
        
        
        request.getSession().setAttribute("nDepTypeID", String.valueOf(nDepTypeID));
        request.getSession().setAttribute("cp", cp);
        request.getSession().setAttribute("checkSaving", "on");
        response.sendRedirect("GetterBnkDepDetailsServlet");

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
