/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.section;

import com.nbs.dao.section.SectionDaoLocal;
import com.nbs.model.ActSectionsSub;
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
public class GetSubsectionTableServlet extends HttpServlet {

    @EJB
    private SectionDaoLocal sectionDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String sectionId = request.getParameter("sectionId");
            List<ActSectionsSub> subSection = sectionDao.getSubSection(Short.parseShort(sectionId));

            String table = "  <ul id='treeDemo' class='ztree' style='width: auto;height:200px;'>"
                    + "<table class='table table-bordered table-hover' id='T1'>"
                    + "<tbody>"
                    + "<tr>"
                    + "<td width='10px'></td>"
                    + "<th >Section ID</th>"
                    + "<th >Sub Section ID</th>"
                    + "<th >Sub Section Name</th>"
                    + "<th >Sub Section Name(Eng)</th>"
                    + "</tr>";

            String endTable = " </tbody>"
                    + " </table>"
                    + " </ul>";
            String bodyTable = "";
            for (ActSectionsSub actSectionsSub : subSection) {
                String sectionNameSin = actSectionsSub.getCSubSectionNameUni();
                if (sectionNameSin == null) {
                    sectionNameSin = "";
                }
                String sectionNameEng = actSectionsSub.getCSubSectionNameUni();

                if (sectionNameEng == null) {
                    sectionNameEng = "";
                }

                bodyTable += "<tr>"
                        + "    <td></td>"
                        + "    <td class='convertSinhalaIskolaPotha'>" + actSectionsSub.getNMainSectionID() + "</td>"
                        + "    <td class='convertSinhalaIskolaPotha'>" + actSectionsSub.getNSubSectionID() + "</td>"
                        + "    <td class='convertSinhalaAmali'>" + sectionNameSin + "</td>"
                        + "    <td class='convertSinhalaIskolaPotha'>" + sectionNameEng + "</td>"
                        + "</tr>";

            }
            out.print(table + bodyTable + endTable);

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
