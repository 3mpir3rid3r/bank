/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.pawning.save;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.ActChartOfAcctL5;
import com.nbs.model.BnkPwnPawnTypes;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class SavePawnTypeServlet extends HttpServlet {
    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

    @EJB
    private BnkActDaoLocal bnkActDao;

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

            String pwnTypeName = request.getParameter("newPawnTypeName");
            String syscode = request.getParameter("systemCode");
            String intRate = request.getParameter("intRate");
            String monthsDate = request.getParameter("monthsDate");
            String intData = request.getParameter("interestData");
            String round = request.getParameter("round");

            ActChartOfAcctL5 acctL1 = (ActChartOfAcctL5) request.getSession().getAttribute("acctL1");
            ActChartOfAcctL5 acctL2 = (ActChartOfAcctL5) request.getSession().getAttribute("acctL2");
            ActChartOfAcctL5 acctL3 = (ActChartOfAcctL5) request.getSession().getAttribute("acctL3");
            ActChartOfAcctL5 acctL4 = (ActChartOfAcctL5) request.getSession().getAttribute("acctL4");
            ActChartOfAcctL5 acctL5 = (ActChartOfAcctL5) request.getSession().getAttribute("acctL5");
            ActChartOfAcctL5 acctL6 = (ActChartOfAcctL5) request.getSession().getAttribute("acctL6");

            String userName = (String) request.getAttribute("user");

            // if (pwnTypeName != null & syscode!=null & intRate!=null & monthsDate!=null &intData!=null &round!=null ) {
            //   if(acctL1!=null & acctL2!=null &acctL3!=null & acctL4!=null &acctL5!=null &acctL6!=null ){
            BnkPwnPawnTypes pawnTypes = new BnkPwnPawnTypes();
            pawnTypes.setCPawnType(pwnTypeName);
            pawnTypes.setCSysCode(syscode);
            pawnTypes.setNIntRate(BigDecimal.valueOf(Double.parseDouble(intRate)));
            pawnTypes.setNPwnMonthsDays(Integer.parseInt(monthsDate));
            pawnTypes.setNIntCalMethod(Integer.parseInt(intData));
            pawnTypes.setNIntRoundMethodID(Integer.parseInt(round));
            pawnTypes.setNAcctLevelID5PawnCapital(acctL1.getNAcctLevelID5());
            pawnTypes.setNAcctLevelID5PawnInterest(acctL2.getNAcctLevelID5());
            pawnTypes.setNAcctLevelID5PawnPostage(acctL3.getNAcctLevelID5());
            pawnTypes.setNAcctLevelID5PawnStationary(acctL4.getNAcctLevelID5());
            pawnTypes.setNAcctLevelID5PawnAuction(acctL5.getNAcctLevelID5());
            pawnTypes.setNAcctLevelID5InterestFree(acctL6.getNAcctLevelID5());

            pawnTypes.setCAddBy(userName);

            boolean isAdded = bnkActDao.savePawnType(pawnTypes);

            if (isAdded) {
                request.getSession().removeAttribute("acctL1");
                request.getSession().removeAttribute("acctL2");
                request.getSession().removeAttribute("acctL3");
                request.getSession().removeAttribute("acctL4");
                request.getSession().removeAttribute("acctL5");
                request.getSession().removeAttribute("acctL6");

                request.getSession().removeAttribute("pwnTypeName");
                request.getSession().removeAttribute("syscode");
                request.getSession().removeAttribute("intRate");
                request.getSession().removeAttribute("monthsDate");
                request.getSession().removeAttribute("intData");
                request.getSession().removeAttribute("round");
                request.getSession().removeAttribute("setComboSeleect");
            }
            
            List<BnkPwnPawnTypes> list =  bnkPwnPawnMasterDao.getBnkPwnPawnTypes();
            request.getSession().setAttribute("allpawnTypes", list);
            
            response.sendRedirect("pawning/pawnType.jsp");

            //pawnTypes.set
            //   }
            //}
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
