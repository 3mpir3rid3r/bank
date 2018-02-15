/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.Security;
import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.model.BnkCustomerMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
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
public class SavingDetailsGetMasterDetilsServlet extends HttpServlet {

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String tellerIndexKey = request.getParameter("tellerIndexKey");

            String masterIDString = Security.decrypt(request.getParameter("masterID").replace(" ", "+"));
            if (request.getSession().getAttribute("cutomerDetailsForCIF") != null) {
                request.getSession().removeAttribute("cutomerDetailsForCIF");
            }
            if (request.getSession().getAttribute("insertDepositMaster") != null) {
                request.getSession().removeAttribute("insertDepositMaster");
            }

            if (request.getSession().getAttribute("nextBtnCheck") != null) {
                request.getSession().removeAttribute("nextBtnCheck");
            }

            request.getSession().removeAttribute("accN");
            request.getSession().removeAttribute("accN1");
            request.getSession().removeAttribute("inputCutomerDetails");

            switch (tellerIndexKey) {
                case "custCIFID":
                    BigInteger nCustIDForCIF = BigInteger.valueOf(Long.parseLong(masterIDString));
                    BnkCustomerMaster custMasterForCIF = bnkCustomerMasterDao.getBnkCustomerMaster(nCustIDForCIF);
                    request.getSession().setAttribute("cutomerDetailsForCIF", custMasterForCIF);
                    request.getSession().setAttribute("depDetailsCheck", "on");
                    response.sendRedirect("SavingDetailsServlet");
                    break;
                case "sDInputCust":
                    BigInteger nCustIDForInput = BigInteger.valueOf(Long.parseLong(masterIDString));
                    BnkCustomerMaster custMasterForInput = bnkCustomerMasterDao.getBnkCustomerMaster(nCustIDForInput);
                    List<BnkCustomerMaster> bcms = new ArrayList<>();
                    if (request.getSession().getAttribute("inputCutomerDetails") == null) {
                        bcms.add(custMasterForInput);
                    } else {
                        bcms = (List<BnkCustomerMaster>) request.getSession().getAttribute("inputCutomerDetails");
                        bcms.add(custMasterForInput);
                    }

                    request.getSession().setAttribute("inputCutomerDetails", bcms);
                    response.sendRedirect("SavingDetailsServlet");
                    break;
            }

        } catch (GeneralSecurityException ex) {
            Logger.getLogger(SavingDetailsGetMasterDetilsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
