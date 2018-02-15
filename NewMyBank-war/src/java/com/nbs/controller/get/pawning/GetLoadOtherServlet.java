/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.BnkPwnPawnReason;
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
public class GetLoadOtherServlet extends HttpServlet {

    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<BnkPwnPawnReason> bnkPwnPawnReasons = bnkPwnPawnMasterDao.getallPwnReasons();
            request.getSession().setAttribute("pwnReasons", bnkPwnPawnReasons);

            String outs = "<div class=\"zTreeDemoBackground left\">\n"
                    + " <ul id=\"treeDemo\" class=\"ztree\" style=\"width: auto;height:200px;\">";

            String output = "<table  class=\"table table-bordered table-hover\" id=\"T1\">\n"
                    + "                                                    <tbody>\n"
                    + "                                                        <tr>\n"
                    + "                                                            <td width=\"10px\"></td>\n"
                    + "                                                            <th >වෙනත්</th>\n"
                    + "                                                            <th >වෙනත්</th>\n"
                    + "                                                            <th ></th>\n"
                    + "                                                        </tr> \n";

            for (BnkPwnPawnReason bnkPwnPawnReason : bnkPwnPawnReasons) {
                output += " <tr onclick='setDataIntoTable(this);'><td></td>\n"
                        + "           <td class=\"convertSinhalaAmali\">" + bnkPwnPawnReason.getCPwnReason() + "</td>\n"
                        + "           <td class=\"convertSinhalaIskolaPotha\">" + bnkPwnPawnReason.getCPwnReasonEng() + "</td>\n"
                        + "           <td class=\"convertSinhalaIskolaPotha\"><button  type='button'>Select</button></td></tr>";
            }
            out.print(outs + output + "</tbody></table></ul></div>");
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
