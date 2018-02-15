/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save.section;

import com.nbs.dao.section.SectionDaoLocal;
import com.nbs.model.ActSectionsSub;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class NewSubSectionServlet extends HttpServlet {

    @EJB
    private SectionDaoLocal sectionDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String subSectionName = request.getParameter("csubSectionName");
            String subSectionNameEng = request.getParameter("csubSectionNameEng");
            String sectionID = request.getParameter("sectionID");
            ActSectionsSub actSectionsSub = new ActSectionsSub();

//            actSectionsSub.setCSubSectionName(subSectionName);
//            actSectionsSub.setCSubSectionNameEng(subSectionNameEng);
            actSectionsSub.setNMainSectionID(Short.parseShort(sectionID));
            boolean saveSubSection = sectionDao.saveSubSection(actSectionsSub);
            if (saveSubSection) {
                response.sendRedirect("section/section_main.jsp?mg=saved");
            } else {
                response.sendRedirect("section/section_main.jsp?mg=error");
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
