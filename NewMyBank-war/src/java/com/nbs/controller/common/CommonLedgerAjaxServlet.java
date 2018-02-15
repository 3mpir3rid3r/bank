package com.nbs.controller.common;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.nbs.dao.BnkActDaoLocal;
import com.nbs.model.ActChartOfAcctL1;
import com.nbs.model.ActChartOfAcctL2;
import com.nbs.model.ActChartOfAcctL3;
import com.nbs.model.ActChartOfAcctL4;
import com.nbs.model.ActChartOfAcctL5;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KalaNa
 */
public class CommonLedgerAjaxServlet extends HttpServlet {

    @EJB
    private BnkActDaoLocal bnkActDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");

        try {
            int c = 1;
            String mid = request.getParameter("mid");
            String c1 = request.getParameter("c1");
            List<ActChartOfAcctL1> acctL1s = bnkActDao.getAct1();
            List<ActChartOfAcctL2> acctL2s = bnkActDao.getAct2();
            List<ActChartOfAcctL3> acctL3s = bnkActDao.getAct3();
            List<ActChartOfAcctL4> acctL4s = bnkActDao.getAct4();
            List<ActChartOfAcctL5> acctL5s = bnkActDao.getAct5();

            List<ActChartOfAcctL2> actt2 = null;
            List<ActChartOfAcctL3> actt3 = null;
            List<ActChartOfAcctL4> actt4 = null;
            List<ActChartOfAcctL5> actt5 = null;

            ActChartOfAcctL2 acc2 = null;
            ActChartOfAcctL3 acc3 = null;
            ActChartOfAcctL4 acc4 = null;
            ActChartOfAcctL5 acc5 = null;

            String cString = request.getParameter("c");

            if ("1".equals(mid)) {
                c = Integer.parseInt(cString);
                actt2 = new ArrayList<>();
                for (ActChartOfAcctL2 a2 : acctL2s) {

                    if (Integer.parseInt(c1) == a2.getNAcctLevelID1()) {
                        // System.out.println(c1);
                        acc2 = new ActChartOfAcctL2();
                        acc2.setNAcctLevelID2(a2.getNAcctLevelID2());
                        acc2.setCCAAcctNoL2(a2.getCCAAcctNoL2());
                        acc2.setCDescriptionUniL2(a2.getCDescriptionUniL2());
                        acc2.setCDescriptionSinL2(a2.getCDescriptionSinL2());
                        acc2.setNNoteNoL2(a2.getNNoteNoL2());
                        acc2.setNPNLOrderL2(a2.getNPNLOrderL2());
                        acc2.setNTBLORderL2(a2.getNTBLORderL2());
                        actt2.add(acc2);
                    }
                }
                request.getSession().setAttribute("actt2", actt2);
                request.getSession().setAttribute("actt3", actt3);
                request.getSession().setAttribute("actt4", actt4);
                request.getSession().setAttribute("actt5", actt5);

                response.sendRedirect("teller/common_legger.jsp?mid=1&c1=" + c1 + "&c=" + c);
            } else if ("2".equals(mid)) {
                String c2 = request.getParameter("c2");
                c = Integer.parseInt(cString);
                actt3 = new ArrayList<>();
                for (ActChartOfAcctL3 a3 : acctL3s) {
                    if (Integer.parseInt(c2) == a3.getNAcctLevelID2()) {
                        acc3 = new ActChartOfAcctL3();
                        acc3.setNAcctLevelID3(a3.getNAcctLevelID3());
                        acc3.setCCAAcctNoL3(a3.getCCAAcctNoL3());

                        acc3.setCDescriptionUniL3(a3.getCDescriptionUniL3());
                        acc3.setCDescriptionSinL3(a3.getCDescriptionSinL3());
                        acc3.setNNoteNoL3(a3.getNNoteNoL3());
                        acc3.setNPNLOrderL3(a3.getNPNLOrderL3());
                        acc3.setNTBLORderL3(a3.getNTBLORderL3());
                        actt3.add(acc3);

                    }
                }
                actt2 = new ArrayList<>();
                for (ActChartOfAcctL2 a2 : acctL2s) {
                    if (Integer.parseInt(c1) == a2.getNAcctLevelID1()) {
                        acc2 = new ActChartOfAcctL2();
                        acc2.setNAcctLevelID2(a2.getNAcctLevelID2());
                        acc2.setCCAAcctNoL2(a2.getCCAAcctNoL2());
                        acc2.setCDescriptionUniL2(a2.getCDescriptionUniL2());
                        acc2.setCDescriptionSinL2(a2.getCDescriptionSinL2());
                        acc2.setNNoteNoL2(a2.getNNoteNoL2());
                        acc2.setNPNLOrderL2(a2.getNPNLOrderL2());
                        acc2.setNTBLORderL2(a2.getNTBLORderL2());
                        actt2.add(acc2);
                    }
                }

                request.getSession().setAttribute("actt2", actt2);
                request.getSession().setAttribute("actt3", actt3);
                request.getSession().setAttribute("actt4", actt4);
                request.getSession().setAttribute("actt5", actt5);

                response.sendRedirect("teller/common_legger.jsp?mid=2&c1=" + c1 + "&c2=" + c2 + "&c=" + c);
            } else if ("3".equals(mid)) {
                c = Integer.parseInt(cString);
                String c2 = request.getParameter("c2");
                String c3 = request.getParameter("c3");
                actt4 = new ArrayList<>();
                for (ActChartOfAcctL4 a4 : acctL4s) {
                    if (Integer.parseInt(c3) == a4.getNAcctLevelID3()) {
                        acc4 = new ActChartOfAcctL4();
                        acc4.setNAcctLevelID4(a4.getNAcctLevelID4());
                        acc4.setCCAAcctNoL4(a4.getCCAAcctNoL4());
                        acc4.setCDescriptionSinL4(a4.getCDescriptionSinL4());
                        acc4.setCDescriptionUniL4(a4.getCDescriptionUniL4());
                        acc4.setNNoteNoL4(a4.getNNoteNoL4());
                        acc4.setNPNLOrderL4(a4.getNPNLOrderL4());
                        acc4.setNTBLORderL4(a4.getNTBLORderL4());
                        actt4.add(acc4);
                    }
                }
                actt3 = new ArrayList<>();
                for (ActChartOfAcctL3 a3 : acctL3s) {
                    if (Integer.parseInt(c2) == a3.getNAcctLevelID2()) {
                        acc3 = new ActChartOfAcctL3();
                        acc3.setNAcctLevelID3(a3.getNAcctLevelID3());
                        acc3.setCCAAcctNoL3(a3.getCCAAcctNoL3());
                        acc3.setCDescriptionSinL3(a3.getCDescriptionSinL3());
                        acc3.setCDescriptionUniL3(a3.getCDescriptionUniL3());
                        acc3.setNNoteNoL3(a3.getNNoteNoL3());
                        acc3.setNPNLOrderL3(a3.getNPNLOrderL3());
                        acc3.setNTBLORderL3(a3.getNTBLORderL3());
                        actt3.add(acc3);
                    }
                }
                actt2 = new ArrayList<>();
                for (ActChartOfAcctL2 a2 : acctL2s) {
                    if (Integer.parseInt(c1) == a2.getNAcctLevelID1()) {
                        acc2 = new ActChartOfAcctL2();
                        acc2.setNAcctLevelID2(a2.getNAcctLevelID2());
                        acc2.setCCAAcctNoL2(a2.getCCAAcctNoL2());
                        acc2.setCDescriptionUniL2(a2.getCDescriptionUniL2());
                        acc2.setCDescriptionSinL2(a2.getCDescriptionSinL2());
                        acc2.setNNoteNoL2(a2.getNNoteNoL2());
                        acc2.setNPNLOrderL2(a2.getNPNLOrderL2());
                        acc2.setNTBLORderL2(a2.getNTBLORderL2());
                        actt2.add(acc2);
                    }
                }
                request.getSession().setAttribute("actt2", actt2);
                request.getSession().setAttribute("actt3", actt3);
                request.getSession().setAttribute("actt4", actt4);
                request.getSession().setAttribute("actt5", actt5);

                response.sendRedirect("teller/common_legger.jsp?mid=3&c1=" + c1 + "&c2=" + c2 + "&c3=" + c3 + "&c=" + c);
            } else if ("4".equals(mid)) {
                String c2 = request.getParameter("c2");
                String c3 = request.getParameter("c3");
                String c4 = request.getParameter("c4");

                actt5 = new ArrayList<>();
                for (ActChartOfAcctL5 a5 : acctL5s) {

                    if (Integer.parseInt(c4) == a5.getNAcctLevelID4()) {

                        acc5 = new ActChartOfAcctL5();
                        acc5.setNAcctLevelID5(a5.getNAcctLevelID5());
                        acc5.setCCAAcctNoL5(a5.getCCAAcctNoL5());
//                        acc4.setCMainAcctNo(a4.getCMainAcctNo());
                        acc5.setCDescriptionUniL5(a5.getCDescriptionUniL5());
                        acc5.setCDescriptionSinL5(a5.getCDescriptionSinL5());
                        acc5.setNNoteNoL5(a5.getNNoteNoL5());
                        acc5.setNPNLOrderL5(a5.getNPNLOrderL5());
                        acc5.setNTBLORderL5(a5.getNTBLORderL5());
                        actt5.add(acc5);
                    }
                }

                actt4 = new ArrayList<>();
                for (ActChartOfAcctL4 a4 : acctL4s) {
                    if (Integer.parseInt(c3) == a4.getNAcctLevelID3()) {
                        acc4 = new ActChartOfAcctL4();
                        acc4.setNAcctLevelID4(a4.getNAcctLevelID4());
                        acc4.setCCAAcctNoL4(a4.getCCAAcctNoL4());
                        acc4.setCDescriptionSinL4(a4.getCDescriptionSinL4());
                        acc4.setCDescriptionUniL4(a4.getCDescriptionUniL4());
                        acc4.setNNoteNoL4(a4.getNNoteNoL4());
                        acc4.setNPNLOrderL4(a4.getNPNLOrderL4());
                        acc4.setNTBLORderL4(a4.getNTBLORderL4());
                        actt4.add(acc4);
                    }
                }
                actt3 = new ArrayList<>();
                for (ActChartOfAcctL3 a3 : acctL3s) {
                    if (Integer.parseInt(c2) == a3.getNAcctLevelID2()) {
                        acc3 = new ActChartOfAcctL3();
                        acc3.setNAcctLevelID3(a3.getNAcctLevelID3());
                        acc3.setCCAAcctNoL3(a3.getCCAAcctNoL3());
//                        acc3.setCSubAccNo(a3.getCSubAccNo());
                        acc3.setCDescriptionUniL3(a3.getCDescriptionUniL3());
                        acc3.setCDescriptionSinL3(a3.getCDescriptionSinL3());
                        acc3.setNNoteNoL3(a3.getNNoteNoL3());
                        acc3.setNPNLOrderL3(a3.getNPNLOrderL3());
                        acc3.setNTBLORderL3(a3.getNTBLORderL3());
                        actt3.add(acc3);
                    }
                }
                actt2 = new ArrayList<>();
                for (ActChartOfAcctL2 a2 : acctL2s) {
                    if (Integer.parseInt(c1) == a2.getNAcctLevelID1()) {
                        acc2 = new ActChartOfAcctL2();
                        acc2.setNAcctLevelID2(a2.getNAcctLevelID2());
                        acc2.setCCAAcctNoL2(a2.getCCAAcctNoL2());
                        acc2.setCDescriptionUniL2(a2.getCDescriptionUniL2());
                        // acc2.setCSubAcctNo(a2.getCSubAcctNo());
                        acc2.setCDescriptionSinL2(a2.getCDescriptionSinL2());
                        acc2.setNNoteNoL2(a2.getNNoteNoL2());
                        acc2.setNPNLOrderL2(a2.getNPNLOrderL2());
                        acc2.setNTBLORderL2(a2.getNTBLORderL2());
                        actt2.add(acc2);
                    }
                }

                request.getSession().setAttribute("actt2", actt2);
                request.getSession().setAttribute("actt3", actt3);
                request.getSession().setAttribute("actt4", actt4);
                request.getSession().setAttribute("actt5", actt5);

                response.sendRedirect("teller/common_legger.jsp?mid=4&c1=" + c1 + "&c2=" + c2 + "&c3=" + c3 + "&c4=" + c4 + "&c=" + c);
            }

        } catch (Exception e) {
            throw new ServletException(e);
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
