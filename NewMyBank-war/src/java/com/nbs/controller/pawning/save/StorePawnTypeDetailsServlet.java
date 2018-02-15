/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.pawning.save;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.model.ActChartOfAcctL5;
import com.nbs.model.BnkPwnPawnTypes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class StorePawnTypeDetailsServlet extends HttpServlet {

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

            String id = request.getParameter("id");
            String reset = request.getParameter("reset");

            
            if (id != null) {
                id = id.replaceAll(" ", "");
                List<BnkPwnPawnTypes> lists = (List<BnkPwnPawnTypes>) request.getSession().getAttribute("allpawnTypes");
                for (BnkPwnPawnTypes list : lists) {

                    if (list.getNPawnTypeID() == Integer.parseInt(id)) {

                        List<ActChartOfAcctL5> act5Data = bnkActDao.getAct5();

                        for (ActChartOfAcctL5 act5Data1 : act5Data) {
                            boolean acc1 = false, acc2 = false, acc3 = false, acc4 = false, acc5 = false, acc6 = false;
                            if (act5Data1.getNAcctLevelID5() == list.getNAcctLevelID5PawnCapital()) {
                                request.getSession().setAttribute("acctL1", act5Data1);
                                acc1 = true;
                            }
                            if (act5Data1.getNAcctLevelID5() == list.getNAcctLevelID5PawnInterest()) {
                                request.getSession().setAttribute("acctL2", act5Data1);
                                acc2 = true;
                            }
                            if (act5Data1.getNAcctLevelID5() == list.getNAcctLevelID5PawnPostage()) {
                                request.getSession().setAttribute("acctL3", act5Data1);
                                acc3 = true;
                            }
                            if (act5Data1.getNAcctLevelID5() == list.getNAcctLevelID5PawnStationary()) {
                                request.getSession().setAttribute("acctL4", act5Data1);
                                acc4 = true;
                            }
                            if (act5Data1.getNAcctLevelID5() == list.getNAcctLevelID5PawnAuction()) {
                                request.getSession().setAttribute("acctL5", act5Data1);
                                acc5 = true;
                            }
                            if (Objects.equals(act5Data1.getNAcctLevelID5(), list.getNAcctLevelID5InterestFree())) {
                                request.getSession().setAttribute("acctL6", act5Data1);
                                acc6 = true;
                            }

                        }

                        request.getSession().setAttribute("pwnTypeName", list.getCPawnType());
                        request.getSession().setAttribute("syscode", list.getCSysCode());
                        request.getSession().setAttribute("intRate", list.getNIntRate());
                        request.getSession().setAttribute("monthsDate", list.getNPwnMonthsDays());

                        request.getSession().setAttribute("intData", list.getNIntCalMethod());
                        request.getSession().setAttribute("round", list.getNIntRoundMethodID());
                        request.getSession().setAttribute("setComboSeleect", id);
                        response.sendRedirect("pawning/pawnType.jsp");
                    }
                }

            } else if (reset != null) {
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

                response.sendRedirect("pawning/pawnType.jsp");

            } else if (request.getParameter("depos") != null) {

                String iid = request.getParameter("iid");
                request.getSession().setAttribute("keyNo2", iid);
                request.getSession().removeAttribute("keyNo1");

                String cSysCode = request.getParameter("cSysCode");
                String nDepCatID = request.getParameter("nDepCatID");
                String bActive = request.getParameter("bActive");

                String cDepName = request.getParameter("cDepName");
                String cDepNameSin = request.getParameter("cDepNameSin");
                String cDepNameTamil = request.getParameter("cDepNameTamil");

                String nMinParticipant = request.getParameter("nMinParticipant");
                String nMaxParticipant = request.getParameter("nMaxParticipant");
                String nMinAge = request.getParameter("nMinAge");
                String nMaxAge = request.getParameter("nMaxAge");
                String nOperatingGenderType = request.getParameter("nOperatingGenderType");
                String nMinAmtStart = request.getParameter("nMinAmtStart");
                String nMinAmtContinue = request.getParameter("nMinAmtContinue");
                String bInitialDepCash = request.getParameter("bInitialDepCash");
                String bInitialDepChque = request.getParameter("bInitialDepChque");
                String bMultipleAcct = request.getParameter("bMultipleAcct");
                String bInitialDepFTrnans = request.getParameter("bInitialDepFTrnans");

                String optionsDepTypes = request.getParameter("optionsDepTypes");
                String nMaxMonths = request.getParameter("nMaxMonths");
                String nMinMonths = request.getParameter("nMinMonths");
                String nWithdrawlsAllowed = request.getParameter("nWithdrawlsAllowed");
                String nNoOfDays = request.getParameter("nNoOfDays");
                String nNoOfTimesPerMonth = request.getParameter("nNoOfTimesPerMonth");
                String nMinAgeLimitWithdrawls = request.getParameter("nMinAgeLimitWithdrawls");

                String nIntCalMethodID = request.getParameter("nIntCalMethodID");
                String nCurrentIntRate = request.getParameter("nCurrentIntRate");
                String nIntCalID = request.getParameter("nIntCalID");
                String nIntPayID = request.getParameter("nIntPayID");
                String nMinAmtIntCal = request.getParameter("nMinAmtIntCal");
                String nMinAmtIntCR = request.getParameter("nMinAmtIntCR");
                String nInterestRoundMethod = request.getParameter("nInterestRoundMethod");

                String bChangeToInactive = request.getParameter("bChangeToInactive");
                String nInacPeriod = request.getParameter("nInacPeriod");
                String cInacPeriodType = request.getParameter("cInacPeriodType");
                String bChangeToHimiNopa = request.getParameter("bChangeToHimiNopa");
                String nHimiPeriodType = request.getParameter("nHimiPeriodType");
                String nBonusIntRate = request.getParameter("nBonusIntRate");
                String nLoanAmount = request.getParameter("nLoanAmount");
                String nHimiPeriod = request.getParameter("nHimiPeriod");
                String depTypeId = request.getParameter("nDepTypeID");
                ArrayList<String> cp = new ArrayList<>();

                cp.add(cSysCode);
                cp.add(nDepCatID);
                cp.add(bActive);
                cp.add(cDepName);
                cp.add(cDepNameSin);
                cp.add(cDepNameTamil);
                //---------------------------
                cp.add(nMinParticipant);
                cp.add(nMaxParticipant);
                cp.add(nMinAge);
                cp.add(nMaxAge);
                cp.add(nOperatingGenderType);
                cp.add(nMinAmtStart);
                cp.add(nMinAmtContinue);
                cp.add(bInitialDepCash);
                cp.add(bInitialDepChque);
                cp.add(bInitialDepFTrnans);
                cp.add(bMultipleAcct);
                //------------------------
                cp.add(nMinMonths);
                cp.add(nMaxMonths);
                cp.add(nWithdrawlsAllowed);
                cp.add(nNoOfDays);
                cp.add(nNoOfTimesPerMonth);
                cp.add(nMinAgeLimitWithdrawls);
                //--------------------------------
                cp.add(nCurrentIntRate);
                cp.add(nIntCalMethodID);
                cp.add(nIntCalID);
                cp.add(nIntPayID);
                cp.add(nMinAmtIntCal);
                cp.add(nMinAmtIntCR);
                cp.add(nInterestRoundMethod);
                //--------------------------------
                cp.add("");
                cp.add("");
                //----------------------------
                cp.add(bChangeToInactive);
                cp.add(nInacPeriod);
                cp.add(cInacPeriodType);
                cp.add(bChangeToHimiNopa);
                cp.add(nHimiPeriod);
                cp.add(nHimiPeriodType);
                cp.add(nBonusIntRate);
                cp.add(nLoanAmount);
                cp.add(optionsDepTypes);

                request.getSession().setAttribute("cp", cp);

                request.getSession().setAttribute("moveToGL", "1");
                
                response.sendRedirect("loan/view_commonLegger.jsp");

            } else {

                if (request.getParameter("type") != null) {

                    String iid = request.getParameter("iid");
                    request.getSession().setAttribute("keyNo1", iid);
                    request.getSession().removeAttribute("keyNo2");

                    String cSysCode = request.getParameter("cSysCode");
                    String nLonCatID = request.getParameter("nLonCatID");
                    String bActive = request.getParameter("bActive");

                    String cLonName = request.getParameter("cLonName");
                    String cLonNameSin = request.getParameter("cLonNameSin");
                    String cLonNameTamil = request.getParameter("cLonNameTamil");

                    String nMinParticipant = request.getParameter("nMinParticipant");
                    String nMinAge = request.getParameter("nMinAge");
                    String nMinLonAmtl = request.getParameter("nMinLonAmt");
                    String nMinMonths = request.getParameter("nMinMonths");
                    String nMaxParticipant = request.getParameter("nMaxParticipant");
                    String nMaxAge = request.getParameter("nMaxAge");
                    String nMaxLonAmt = request.getParameter("nMaxLonAmt");
                    String nMaxMonths = request.getParameter("nMaxMonths");
                    String bMultipleAcct = request.getParameter("bMultipleAcct");

                    String nPenaltyIntRate = request.getParameter("nPenaltyIntRate");
                    String nPIntRateForID = request.getParameter("nPIntRateForID");
                    String nCurrentInt = request.getParameter("nCurrentInt");
                    String nLonInterestMethodID = request.getParameter("nLonInterestMethodID");
                    String nPenaltyIntCal = request.getParameter("nPenaltyIntCal");
                    String nPIntCalForID = request.getParameter("nPIntCalForID");
                    String nPenaltyIntOP2 = request.getParameter("nPenaltyIntOP2");
                    String intRadio = request.getParameter("intRadio");
                    String roundRadio = request.getParameter("roundRadio");
                    String intRadio1 = request.getParameter("intRadio1");

                    ArrayList<String> cp = new ArrayList<>();

                    cp.add(cSysCode);
                    cp.add(nLonCatID);
                    cp.add(bActive);
                    cp.add(cLonName);
                    cp.add(cLonNameSin);
                    cp.add(cLonNameTamil);
                    cp.add(nMinParticipant);
                    cp.add(nMaxParticipant);
                    cp.add(nMinAge);
                    cp.add(nMaxAge);
                    cp.add(nMinLonAmtl);
                    cp.add(nMaxLonAmt);
                    cp.add(nMinMonths);
                    cp.add(nMaxMonths);
                    cp.add(bMultipleAcct);
                    //------------------------
                    cp.add(nCurrentInt);
                    cp.add(nLonInterestMethodID);
                    cp.add(intRadio);
                    cp.add(roundRadio);
                    cp.add(nPenaltyIntRate);
                    cp.add(nPIntRateForID);
                    cp.add(intRadio1);
                    cp.add(nPenaltyIntCal);
                    cp.add(nPIntCalForID);

                    cp.add(nPenaltyIntOP2);
                    //-----n--------------------------
                    request.getSession().setAttribute("cp", cp);
                    request.getSession().setAttribute("moveToGL", "1");
                    
                    System.out.println("awaaaaaaaaaaaaaaaaaaaaaaaa11111111118888888  ="+request.getSession().getAttribute("moveToGL"));
                    response.sendRedirect("loan/view_commonLegger.jsp");
                } else {

                    String pwnTypeName = request.getParameter("newPawnTypeName");

                    String syscode = request.getParameter("systemCode");
                    String intRate = request.getParameter("intRate");
                    String monthsDate = request.getParameter("monthsDate");
                    monthsDate = monthsDate.replaceAll(" ", "");
                    String intData = request.getParameter("intData");
                    String round = request.getParameter("round");

                    request.getSession().setAttribute("pwnTypeName", pwnTypeName);
                    request.getSession().setAttribute("syscode", syscode);
                    request.getSession().setAttribute("intRate", intRate);
                    request.getSession().setAttribute("monthsDate", monthsDate);

                    request.getSession().setAttribute("intData", intData);
                    request.getSession().setAttribute("round", round);
                    String iid = request.getParameter("iid");

                    request.getSession().setAttribute("keyNo", iid);

                    response.sendRedirect("pawning/view_commonLegger.jsp");
                }
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
