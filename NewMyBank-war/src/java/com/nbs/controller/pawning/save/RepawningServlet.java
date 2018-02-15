/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.pawning.save;

import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.GenUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author mmh
 */
public class RepawningServlet extends HttpServlet {

    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getSession().getAttribute("BnkPwnPawnMaster") != null) {

//                get Data and set data into bo....
                BnkPwnPawnMaster bppm = (BnkPwnPawnMaster) request.getSession().getAttribute("BnkPwnPawnMaster");

                Date loggedDate = null;
                if (request.getSession().getAttribute("storeLoggedDate") != null) {
                    String logged = (String) request.getSession().getAttribute("storeLoggedDate");

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {

                        loggedDate = sdf.parse(logged);
                    } catch (ParseException ex) {
                        Logger.getLogger(RepawningServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                BnkRefBankBranch bankBranch = (BnkRefBankBranch) request.getSession().getAttribute("branch");

                String userNameRigthSideBar = "";
                if (request.getSession().getAttribute("user") != null) {
                    GenUser genUser = (GenUser) request.getSession().getAttribute("user");
                    userNameRigthSideBar = genUser.getCUserName();
                }

                bppm.setCInputBy(userNameRigthSideBar);
                bppm.setDPwnDate(loggedDate);
                bppm.setNBankBranchID(bankBranch.getNBankBranchID());
                String freeInt = request.getParameter("freeInt");

                if (freeInt != null & freeInt.length() > 0) {

                    double nfreeInt = Double.parseDouble(freeInt);
                    bppm.setNTotRecvInterest(BigDecimal.valueOf(nfreeInt));
                    
                } else {
                    
                    bppm.setNTotRecvInterest(BigDecimal.ZERO);
                    
                }

                boolean isAdded = false;
                try {
                    if (request.getParameter("price") != null) {
                        String price = request.getParameter("price");

                        isAdded = bnkPwnPawnMasterDao.saveRePwn(bppm, Double.parseDouble(price));
                        response.sendRedirect("pawning/re_pawning.jsp?mg=saved&&index=1002");
                    } else {

                        if (request.getParameter("nTotCap") != null) {
                            String price = request.getParameter("nTotCap");
                            isAdded = bnkPwnPawnMasterDao.saveRePwn(bppm, Double.parseDouble(price));
                            response.sendRedirect("pawning/re_pawning.jsp?mg=saved&index=1001&viewRep=true");

                            //  viewJasperReport(request,  null);
                        } else {
                            response.sendRedirect("pawning/re_pawning.jsp?mg=error&index=1001");
                        }
                    }

                    request.getSession().removeAttribute("BnkPwnPawnMaster");
                    request.getSession().removeAttribute("BnkPwnPawnMasterArticles");

                } catch (SQLException | NullPointerException | FileNotFoundException ex) {
                    Logger.getLogger(RepawningServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                if (request.getParameter("price") != null) {
                    response.sendRedirect("pawning/re_pawning.jsp?index=1002");
                } else {

                    response.sendRedirect("pawning/re_pawning.jsp?index=1001");
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

    private void viewJasperReport(HttpServletRequest request, Map map) throws FileNotFoundException {
        String reportFile = getServletContext().getRealPath("reports/rep.jrxml");
        FileInputStream fis = new FileInputStream(new File(reportFile));
//        JasperReport jr = JasperCompileManager.compileReport(fis);
//        JasperPrint print = JasperFillManager.fillReport(jr, map);
//        request.getSession().setAttribute("printz", print);
    }
}
