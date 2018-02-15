/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.pawning.save;

import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.BnkPwnRefArticls;
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
public class PawningArticleServlet extends HttpServlet {

    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String articleNameEng = request.getParameter("articlenameEng");
            String articleNameSin = request.getParameter("articleNameSin");

            if (articleNameSin != null || articleNameEng != null) {
                BnkPwnRefArticls bnkPwnRefnArticls = new BnkPwnRefArticls();
                bnkPwnRefnArticls.setCPwnArticlName(articleNameEng);
                bnkPwnRefnArticls.setCPwnArticlNameSin(articleNameSin);

                boolean saveBankPwnRefArticls = bnkPwnPawnMasterDao.saveBankPwnRefArticls(bnkPwnRefnArticls);

                if (saveBankPwnRefArticls) {
                    request.getSession().removeAttribute("RefArticlcombo");

                    List<BnkPwnRefArticls> articlses = bnkPwnPawnMasterDao.getBnkPwnRefArticls();
                    request.getSession().setAttribute("RefArticlcombo", articlses);
                    
                    String output = " <option>- Select -</option>";
                    for (BnkPwnRefArticls bnkPwnRefArticls : articlses) {

                        output += "<option class='convertSinhalaIskolaPotha' value=" + bnkPwnRefArticls.getNPwnRefArticlID() + ">" + bnkPwnRefArticls.getCPwnArticlName() + "</option>";

                    }
                    out.print(output);
                } else {
                    out.print("Failed!");
                }

            } else {
                out.print("Failed!");
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
