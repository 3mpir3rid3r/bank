/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.Security;
import com.nbs.dao.BnkCustomerMasterDao;
import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.model.BnkCustomerMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
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
public class LoanPatnerDetailsServlet extends HttpServlet {

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

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
            /* TODO output your page here. You may use following sample code. */
            String cifno = request.getParameter("id");
            String cifnoDel = request.getParameter("delete");

            List patner = null;
            BnkCustomerMaster customerDetails;

            if (cifno != null) {
                customerDetails = bnkCustomerMasterDao.getCustomerDetails(Integer.parseInt(cifno));

                if (request.getSession().getAttribute("aPatner") == null) {
                    patner = new ArrayList();
                } else {
                    patner = (List) request.getSession().getAttribute("aPatner");
                }
                patner.add(customerDetails);
                request.getSession().setAttribute("aPatner", patner);
                response.sendRedirect("teller/loarn_details.jsp");
            } else if (cifnoDel != null) {
                patner = (List) request.getSession().getAttribute("aPatner");
                patner.remove(Integer.parseInt(cifnoDel));
                request.getSession().setAttribute("aPatner", patner);
                out.print("සාර්ථකයි");
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
