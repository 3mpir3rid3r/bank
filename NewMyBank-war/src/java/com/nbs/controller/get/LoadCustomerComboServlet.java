/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.model.BnkCustomerMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class LoadCustomerComboServlet extends HttpServlet {

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            if (request.getSession().getAttribute("BnkRefCustomerCategory") == null) {
                request.getSession().setAttribute("BnkRefCustomerCategory", bnkCustomerMasterDao.getBnkRefCustomerCategory());
                request.getSession().setAttribute("GenRefCustomerTittle", bnkCustomerMasterDao.getGenRefCustomerTittle());
                request.getSession().setAttribute("GenRefNationality", bnkCustomerMasterDao.getGenRefNationality());
                request.getSession().setAttribute("GenRefReligion", bnkCustomerMasterDao.getGenRefReligion());
                request.getSession().setAttribute("BnkRefMemberAreas", bnkCustomerMasterDao.getBnkRefMemberAreas());
                request.getSession().setAttribute("BnkRefMemberPosition", bnkCustomerMasterDao.getBnkRefMemberPosition());
                request.getSession().setAttribute("BnkRefMemberStatus", bnkCustomerMasterDao.getBnkRefMemberStatus());
                request.getSession().setAttribute("BnkRefMemberAreasGroups", bnkCustomerMasterDao.getBnkRefMemberAreasGroups());
                request.getSession().setAttribute("GenRefCivilStatus", bnkCustomerMasterDao.getGenRefCivilStatus());
            }
            String id = "";
            if (request.getParameter("id") != null) {
                id = request.getParameter("id");
                int nCustomerId = Integer.parseInt(id);
                BnkCustomerMaster l = bnkCustomerMasterDao.getCustomerDetails(nCustomerId);
                if (l.getDDateOfBirth() == null || "".equals(l.getDDateOfBirth().toString())) {
                    l.setDDateOfBirth(new Date());
                }
                request.getSession().setAttribute("aCustomer", l);
                response.sendRedirect("teller/customer_details.jsp?id=" + id);
            } else {
                response.sendRedirect("teller/customer_details.jsp");
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

}
