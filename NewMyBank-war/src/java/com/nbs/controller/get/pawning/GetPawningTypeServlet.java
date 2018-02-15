/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.BnkPwnPawnTypes;
import com.nbs.model.BnkRefBankBranch;
import java.io.IOException;
import java.io.PrintWriter;
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
public class GetPawningTypeServlet extends HttpServlet {

    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

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

            String indexNo = request.getParameter("index");
            List<BnkPwnPawnTypes> list = bnkPwnPawnMasterDao.getBnkPwnPawnTypes();
            if (indexNo.equals("1")) {

                request.getSession().setAttribute("allpawnTypes", list);
                response.sendRedirect("pawning/pawnType.jsp");
            } else if (indexNo.equals("2")) {
                List<BnkRefBankBranch> bnkBranch = bnkPwnPawnMasterDao.getBnkBranch();
                request.getSession().setAttribute("allpawnTypes", list);
                request.getSession().setAttribute("allBnkBranches_b", bnkBranch);
                response.sendRedirect("pawning/view_pawning_1.jsp");
                
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
