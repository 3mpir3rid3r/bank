/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.model.ActChartOfAcctL2;
import com.nbs.model.ActChartOfAcctL3;
import com.nbs.model.ActChartOfAcctL4;
import com.nbs.model.ActChartOfAcctL5;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLDecoder;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class SaveACTServlet extends HttpServlet {

    @EJB
    private BnkActDaoLocal bnkActDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            

            String act = request.getParameter("act");
            if ("1".equals(act)) {

                String cMainAcctNo = request.getParameter("act1Accno");
             //   request.setCharacterEncoding("UTF-8");
                String cSubAcctNo = request.getParameter("act1SubAcc");
                String des1 = request.getParameter("des1");
                
                //request.setCharacterEncoding("UTF-8");
               // System.out.println(request.getParameter("act1SubAcc"));
// parm = new String(param.getBytes("ASCII"), "UTF-8"); 
                String noteNo = request.getParameter("nnoteNo");
                String ntblOrder = request.getParameter("ntblOrder");
                String nplOrder = request.getParameter("nplOrder");
                String actId = request.getParameter("act1Id");

                double ntblNo = 0.0;
                double nplNo = 0.0;
                double noteN = 0.0;
                int act1Id = 0;
                String[] data = cMainAcctNo.split("-");
                if (ntblOrder != null && ntblOrder.length() > 0) {
                    ntblNo = Double.parseDouble(ntblOrder);

                }
                if (nplOrder != null && nplOrder.length() > 0) {
                    nplNo = Double.parseDouble(nplOrder);
                }
                if (noteNo != null && noteNo.length() > 0) {
                    noteN = Double.parseDouble(noteNo);
                }
                if (actId != null && actId.length() > 0) {
                    act1Id = Integer.parseInt(actId);
                }

                ActChartOfAcctL2 act2 = new ActChartOfAcctL2();

                act2.setCCAAcctNoL2(cMainAcctNo);
                act2.setCDescriptionSinL2(cSubAcctNo);
                act2.setCDescriptionUniL2(des1);
                act2.setNPNLOrderL2(BigDecimal.valueOf(nplNo));
                act2.setNTBLORderL2(BigDecimal.valueOf(ntblNo));
                act2.setNNoteNoL2(BigDecimal.valueOf(noteN));
                act2.setNAcctLevelID2(act1Id);
                act2.setNAcctLevelID1(Integer.parseInt(data[0]));

                if ("0".equals(actId)) {
                    bnkActDao.saveACT2(act2);
                } else {
                    bnkActDao.updateACT2(act2);
                }
                response.sendRedirect("teller/common_legger.jsp");
            } else if ("2".equals(act)) {
                String nAcctLevelID2 = request.getParameter("act2");
                String cMainAcctNo = request.getParameter("act2Acc");
                String cSubAcctNo = request.getParameter("act2SubAcc");
                String cMainAcctDes = request.getParameter("des2");
                String actId = request.getParameter("act2Id");

                String noteNo = request.getParameter("n2noteNo");
                String ntblOrder = request.getParameter("n2tblOrder");
                String nplOrder = request.getParameter("n2plOrder");

                double ntblNo = 0.0;
                double nplNo = 0.0;
                double noteN = 0.0;
                int act1Id = 0;
                String[] data = cMainAcctNo.split("-");
                if (ntblOrder != null && ntblOrder.length() > 0) {
                    ntblNo = Double.parseDouble(ntblOrder);

                }
                if (nplOrder != null && nplOrder.length() > 0) {
                    nplNo = Double.parseDouble(nplOrder);
                }
                if (noteNo != null && noteNo.length() > 0) {
                    noteN = Double.parseDouble(noteNo);
                }
                if (actId != null && actId.length() > 0) {
                    act1Id = Integer.parseInt(actId);
                }

                ActChartOfAcctL3 act3 = new ActChartOfAcctL3();

                act3.setCCAAcctNoL3(cMainAcctNo);
                act3.setCDescriptionSinL3(cSubAcctNo);
                
                act3.setCDescriptionUniL3(cMainAcctDes);
                act3.setNNoteNoL3(BigDecimal.valueOf(noteN));
                act3.setNPNLOrderL3(BigDecimal.valueOf(nplNo));
                act3.setNTBLORderL3(BigDecimal.valueOf(ntblNo));
                act3.setNAcctLevelID2(Integer.parseInt(data[1]));
                act3.setNAcctLevelID3(act1Id);
                if ("0".equals(actId)) {

                    bnkActDao.saveACT3(act3);
                } else {

                    bnkActDao.updateACT3(act3);
                }
                response.sendRedirect("teller/common_legger.jsp");
            } else if ("3".equals(act)) {

                String cMainAcctNo = request.getParameter("act3Acc");
                String cSubAcctNo = request.getParameter("act3SubAcc");
                String des3 = request.getParameter("des3");
                
                String actId = request.getParameter("act3Id");
                String noteNo = request.getParameter("n3noteNo");
                String ntblOrder = request.getParameter("n3tblOrder");
                String nplOrder = request.getParameter("n3plOrder");

                double ntblNo = 0.0;
                double nplNo = 0.0;
                double noteN = 0.0;
                int act1Id = 0;

                String[] data = cMainAcctNo.split("-");
               
                

                if (ntblOrder != null && ntblOrder.length() > 0) {
                    ntblNo = Double.parseDouble(ntblOrder);

                }
                if (nplOrder != null && nplOrder.length() > 0) {
                    nplNo = Double.parseDouble(nplOrder);
                }
                if (noteNo != null && noteNo.length() > 0) {
                    noteN = Double.parseDouble(noteNo);
                }
                if (actId != null && actId.length() > 0) {
                    act1Id = Integer.parseInt(actId);
                }

                ActChartOfAcctL4 act4 = new ActChartOfAcctL4();

                act4.setCCAAcctNoL4(cMainAcctNo);
                act4.setCDescriptionSinL4(cSubAcctNo);
                act4.setCDescriptionUniL4(des3);
                act4.setNNoteNoL4(BigDecimal.valueOf(noteN));
                act4.setNPNLOrderL4(BigDecimal.valueOf(nplNo));
                act4.setNTBLORderL4(BigDecimal.valueOf(ntblNo));
                act4.setNAcctLevelID3(Integer.parseInt(data[2]));
                act4.setNAcctLevelID4(act1Id);

                if ("0".equals(actId)) {

                    bnkActDao.saveACT4(act4);
                } else {

                    bnkActDao.updateACT4(act4);
                }
                response.sendRedirect("teller/common_legger.jsp");
            } else if ("4".equals(act)) {
                String cMainAcctNo = request.getParameter("act4Acc");
                String cSubAcctNo = request.getParameter("act4SubAcc");
                String des4 = request.getParameter("des4");
                
                String actId = request.getParameter("act4Id");
                String noteNo = request.getParameter("n4noteNo");
                String ntblOrder = request.getParameter("n4tblOrder");
                String nplOrder = request.getParameter("n4plOrder");

                double ntblNo = 0.0;
                double nplNo = 0.0;
                double noteN = 0.0;
                int act1Id = 0;

                String[] data = cMainAcctNo.split("-");

                int findId = Integer.parseInt(data[3]);
                if (ntblOrder != null && ntblOrder.length() > 0) {
                    ntblNo = Double.parseDouble(ntblOrder);

                }
                if (nplOrder != null && nplOrder.length() > 0) {
                    nplNo = Double.parseDouble(nplOrder);
                }
                if (noteNo != null && noteNo.length() > 0) {
                    noteN = Double.parseDouble(noteNo);
                }
                if (actId != null && actId.length() > 0) {
                    act1Id = Integer.parseInt(actId);
                }

                ActChartOfAcctL5 act5 = new ActChartOfAcctL5();

                act5.setCCAAcctNoL5(cMainAcctNo);
                act5.setCDescriptionSinL5(des4);
                act5.setCDescriptionUniL5(cSubAcctNo);
                act5.setNNoteNoL5(BigDecimal.valueOf(noteN));
                act5.setNPNLOrderL5(BigDecimal.valueOf(nplNo));
                act5.setNTBLORderL5(BigDecimal.valueOf(ntblNo));
                act5.setNAcctLevelID4(findId);
                act5.setNAcctLevelID5(act1Id);

                if ("0".equals(actId)) {

                    bnkActDao.saveACT5(act5);
                } else {

                    bnkActDao.updateACT5(act5);
                }
                response.sendRedirect("teller/common_legger.jsp");
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
