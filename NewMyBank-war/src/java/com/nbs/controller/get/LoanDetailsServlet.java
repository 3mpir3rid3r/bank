/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.Security;
import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.dao.BnkLonLoanCtegoryDaoLocal;
import com.nbs.dao.BnkLonLoanTypesDaoLocal;
import com.nbs.model.BnkLonLoanDeductType;
import com.nbs.model.BnkLonLoanDescriptions;
import com.nbs.model.BnkLonLoanFundSource;
import com.nbs.model.BnkLonLoanGroups;
import com.nbs.model.BnkLonLoanStatus;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import com.nbs.model.common.BnkLonLoanCtegoryTypes;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class LoanDetailsServlet extends HttpServlet {

    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    @EJB
    private BnkLonLoanCtegoryDaoLocal bnkLonLoanCtegoryDao;

    @EJB
    private BnkLonLoanTypesDaoLocal bnkLonLoanTypesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nLonTypeIDString = request.getParameter("nLonTypeID");

        String loanType = request.getParameter("loanType");
        String accMifNumer = request.getParameter("accMifNumer");
        String loanGarnterName = request.getParameter("loanGarnterName");
        String checkGarenterType = request.getParameter("checkGarenterType");

        if (loanType != null) {
            if (request.getSession().getAttribute("cutomerDetailsForCIF") != null) {
                request.getSession().removeAttribute("cutomerDetailsForCIF");
            }
            if (request.getSession().getAttribute("gareterList") != null) {
                request.getSession().removeAttribute("gareterList");
            }

        }

        List<BnkLonLoanCtegoryTypes> bllcts = bnkLonLoanTypesDao.getAllBnkLonLoanTypes();
        request.getSession().setAttribute("bllcts", bllcts);

        List<BnkLonLoanDeductType> blldt = bnkLonLoanCtegoryDao.getAllBnkLonLoanDeductType();
        request.getSession().setAttribute("blldt", blldt);

        List<BnkLonLoanGroups> bllgs = bnkLonLoanCtegoryDao.getAllBnkLonLoanGroups();
        request.getSession().setAttribute("bllgs", bllgs);

        List<BnkLonLoanFundSource> bllfs = bnkLonLoanCtegoryDao.getAllBnkLonLoanFundSource();
        request.getSession().setAttribute("bllfs", bllfs);

        List<BnkLonLoanStatus> bllses = bnkLonLoanCtegoryDao.getAllBnkLonLoanStatus();
        request.getSession().setAttribute("bllses", bllses);

        List<BnkLonLoanDescriptions> bllds = bnkLonLoanCtegoryDao.getAllBnkLonLoanDescriptions();
        request.getSession().setAttribute("bllds", bllds);

        if (accMifNumer != null) {
            List<String> garenterDetails = new ArrayList<>();
            if (checkGarenterType.equals("customer")) {
                garenterDetails.add(accMifNumer);
                garenterDetails.add(loanGarnterName);
            } else {
                try {
                    Long nDepMFID = Long.parseLong(Security.decrypt(accMifNumer.replace(" ", "+")));
                    VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nDepMFID);
                    garenterDetails.add(depDepositMaster.getCSysCode());
                    garenterDetails.add(depDepositMaster.getCFullName());
                } catch (GeneralSecurityException ex) {
                    Logger.getLogger(LoanDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getSession().setAttribute("garenterDetails", garenterDetails);
        }

        if (nLonTypeIDString != null) {
            int nLonTypeID = Integer.parseInt(nLonTypeIDString);
            if (nLonTypeID == 0) {
                response.sendRedirect("teller/loarn_details.jsp");
            } else {
                String cLoanName = bnkLonLoanTypesDao.getLonLoanCatogoryName(nLonTypeID);
                System.out.println(cLoanName);
                if (cLoanName == null) {
                    response.sendRedirect("teller/loarn_details.jsp?error=Please check database");
                } else {
                    response.sendRedirect("teller/loarn_details.jsp?nLonTypeID=" + nLonTypeID + "&cLoanName=" + cLoanName);
                }
            }
        } else {
            response.sendRedirect("teller/loarn_details.jsp");
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
