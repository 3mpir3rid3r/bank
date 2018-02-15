/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.Security;
import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
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
public class GetterOneDepositDetailServlet extends HttpServlet {
    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String tellerIndexKey = request.getParameter("tellerIndexKey");
            
            if (tellerIndexKey.equals("mTCR")) {
                String nDepMFIDString = Security.decrypt(request.getParameter("nDepMFID").replace(" ", "+"));
                Long nDepMFID = Long.parseLong(nDepMFIDString);
                VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nDepMFID);
                request.getSession().setAttribute("depDepositMasterCr", depDepositMaster);
                response.sendRedirect("teller/money_translate.jsp");
            }else if(tellerIndexKey.equals("mTBR")){
                String nDepMFIDString = Security.decrypt(request.getParameter("nDepMFID").replace(" ", "+"));
                Long nDepMFID = Long.parseLong(nDepMFIDString);
                VFindDatabnkDepDepositMaster depDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMasterByNDepMFID(nDepMFID);
                request.getSession().setAttribute("depDepositMasterBr", depDepositMaster);
                response.sendRedirect("teller/money_translate.jsp");
            }else{
                
            }
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(GetterOneDepositDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
