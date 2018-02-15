/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.controller.get;

import com.nbs.dao.BnkActDaoLocal;
import com.nbs.model.ActChartOfAcctL4;
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
public class GetViewACT4Servlet extends HttpServlet {
    @EJB
    private BnkActDaoLocal bnkActDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String checkbox = request.getParameter("allcustomers");
            String textKey = request.getParameter("searchText"); 
            String tellerIndexNo = "";
            if(!request.getParameter("tellerIndexNo").isEmpty()){
                tellerIndexNo = request.getParameter("tellerIndexNo");
            }
            
            if ("on".equals(checkbox) && "".equals(textKey)) {
                List<ActChartOfAcctL4> acctL4s = bnkActDao.getAct4View(textKey);
                request.getSession().setAttribute("viewAct", acctL4s);
                response.sendRedirect("teller/view_acc4.jsp?key=" + textKey+"&tellerIndexNo="+tellerIndexNo);
            } else if ("on".equals(checkbox) && !"".equals(textKey)) {
                List<ActChartOfAcctL4> acctL4s = bnkActDao.getAct4View(textKey);
                request.getSession().setAttribute("viewAct", acctL4s);
                response.sendRedirect("teller/view_acc4.jsp?key=" + textKey+"&tellerIndexNo="+tellerIndexNo);
            } else if (!"on".equals(checkbox) && "".equals(textKey)) {
               List<ActChartOfAcctL4> acctL4s = bnkActDao.getAct4View(textKey);
                request.getSession().setAttribute("viewAct", acctL4s);
                response.sendRedirect("teller/view_acc4.jsp?key=" + textKey+"&tellerIndexNo="+tellerIndexNo);
            } else if (!"on".equals(checkbox) && !"".equals(textKey)) {
               List<ActChartOfAcctL4> acctL4s = bnkActDao.getAct4View(textKey);
                request.getSession().setAttribute("viewAct", acctL4s);
                response.sendRedirect("teller/view_acc4.jsp?key=" + textKey+"&tellerIndexNo="+tellerIndexNo);
            }
        }catch(Exception e){
            throw new ServletException(e);
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
