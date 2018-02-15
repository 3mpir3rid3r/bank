/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.controller.common;

import com.nbs.dao.GenUserDaoLocal;
import com.nbs.model.ActSectionsSub;
import com.nbs.model.BnkRefBankBranch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class BranchSession extends HttpServlet {
    @EJB
    private GenUserDaoLocal genUserDao;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String page = request.getParameter("page");
                    int branchId = 0;
                    Cookie cookies[] = request.getCookies();
                    if (cookies != null) {
                        for (int i = 0; i < cookies.length; i++) {
                            Cookie cookie1 = cookies[i];
                            if (cookie1.getName().equals("branch")) {
//                        out.println("bgcolor = " + cookie1.getValue());
                                branchId = Integer.parseInt(cookie1.getValue());
                            }
                        }
                    }
//                    BnkRefBankBranch  bankBranch = genUserDao.getBranch(branchId);
                    ActSectionsSub  bankBranch = genUserDao.getBranch(branchId);
                   
                    request.getSession().setAttribute("branch", bankBranch);
                    response.sendRedirect(page);
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
