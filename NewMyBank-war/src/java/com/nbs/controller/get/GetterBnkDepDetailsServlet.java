/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkDepDepositCategoryDaoLocal;
import com.nbs.dao.BnkDepDepositTypesDaoLocal;
import com.nbs.dao.BnkDepIntCalByDaoLocal;
import com.nbs.dao.BnkDepIntPayByDaoLocal;
import com.nbs.model.BnkDepDepositCategory;
import com.nbs.model.BnkDepIntCalBy;
import com.nbs.model.BnkDepIntPayBy;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasa
 */
public class GetterBnkDepDetailsServlet extends HttpServlet {

    @EJB
    private BnkDepIntCalByDaoLocal bnkDepIntCalByDao;

    @EJB
    private BnkDepIntPayByDaoLocal bnkDepIntPayByDao;

    @EJB
    private BnkDepDepositCategoryDaoLocal bnkDepDepositCategoryDao;

    @EJB
    private BnkDepDepositTypesDaoLocal bnkDepDepositTypesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cs = request.getParameter("cs");
        String newOne = request.getParameter("new");
        if (newOne != null) {
            
            request.getSession().removeAttribute("cp");
            request.getSession().removeAttribute("actid");
            request.getSession().removeAttribute("nDepTypeID");
            request.getSession().removeAttribute("acctL10");
            request.getSession().removeAttribute("chartOfAccount5Data11");
            request.getSession().removeAttribute("acctL11");
            request.getSession().removeAttribute("chartOfAccount5Dat");
        }
        List<BnkDepDepositCategory> bddcs = bnkDepDepositCategoryDao.getAllBnkDepDepositCategory();
        Map<Short, String> mapBnkDepDepositCategory = new HashMap<>();
        for (BnkDepDepositCategory bddc : bddcs) {
            mapBnkDepDepositCategory.put(bddc.getNDepCatID(), bddc.getCDepCategory());
        }

        List<BnkDepIntPayBy> bdipbs = bnkDepIntPayByDao.getAllBnkDepIntPayBy();
        Map<Integer, String> mapBnkDepIntPayBy = new HashMap<>();
        for (BnkDepIntPayBy bdipb : bdipbs) {
            mapBnkDepIntPayBy.put(bdipb.getNIntPayID(), bdipb.getCIntPay());
        }

        List<BnkDepIntCalBy> bdicbs = bnkDepIntCalByDao.getAllBnkDepIntCalBy();
        Map<Integer, String> mapBnkDepIntCalBy = new HashMap<>();
        for (BnkDepIntCalBy bdicb : bdicbs) {
            mapBnkDepIntCalBy.put(bdicb.getNIntCalID(), bdicb.getCIntCal());
        }

        request.getSession().setAttribute("bnkDepDepositTypesAll", bnkDepDepositTypesDao.getAllBnkDepDepositTypes());
        request.getSession().setAttribute("bnkDepDepositCategoryAll", mapBnkDepDepositCategory);
        request.getSession().setAttribute("bnkDepIntPayByAll", mapBnkDepIntPayBy);
        request.getSession().setAttribute("bnkDepIntCalByAll", mapBnkDepIntCalBy);

        if (cs != null) {
            request.getSession().setAttribute("checkSaving", "on");
        }
        response.sendRedirect("saving/saving_prototype.jsp");
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
