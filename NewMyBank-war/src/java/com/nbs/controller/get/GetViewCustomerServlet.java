/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkCustomerMasterDao;
import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.model.BnkCustomerMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;
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
public class GetViewCustomerServlet extends HttpServlet {

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String checkbox = request.getParameter("allcustomers");
            String textKey = request.getParameter("searchText");
            
            String tellerIndexKey = request.getParameter("tellerIndexKey");
            
//            out.write(checkbox);
//            out.write(textKey);
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
            if ("on".equals(checkbox) && "".equals(textKey)) {
                List<BnkCustomerMaster> bcms = getViewAllCustomer(branchId, textKey);
                request.getSession().setAttribute("view1", bcms);
                response.sendRedirect("teller/view_customers.jsp?key=" + textKey+"&tellerIndexKey="+tellerIndexKey);
            } else if ("on".equals(checkbox) && !"".equals(textKey)) {
                List<BnkCustomerMaster> bcms = getViewAllCustomer(branchId, textKey);
                request.getSession().setAttribute("view1", bcms);
                response.sendRedirect("teller/view_customers.jsp?key=" + textKey+"&tellerIndexKey="+tellerIndexKey);
            } else if (!"on".equals(checkbox) && "".equals(textKey)) {
                List<BnkCustomerMaster> bcms = getViewAllCustomer(branchId, textKey);
                request.getSession().setAttribute("view1", bcms);
                response.sendRedirect("teller/view_customers.jsp?key=" + textKey+"&tellerIndexKey="+tellerIndexKey);
            } else if (!"on".equals(checkbox) && !"".equals(textKey)) {
                List<BnkCustomerMaster> bcms = getViewAllCustomer(branchId, textKey);
                request.getSession().setAttribute("view1", bcms);
                response.sendRedirect("teller/view_customers.jsp?key=" + textKey+"&tellerIndexKey="+tellerIndexKey);
            }

        } catch (Exception e) {
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

    private List<BnkCustomerMaster> getViewAllCustomer(int branchId, String key) {
        List<BnkCustomerMaster> bcms = null;
        try {
            if (bnkCustomerMasterDao == null) {
                bnkCustomerMasterDao = new BnkCustomerMasterDao();
            }
            bcms = bnkCustomerMasterDao.getCustomersView(branchId, key);
        } catch (Exception e) {
        }
        return bcms;
    }

}
