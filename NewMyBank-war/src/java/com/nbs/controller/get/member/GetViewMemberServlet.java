/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.member;

import com.nbs.dao.member.BnkMemberMasterDao;
import com.nbs.dao.member.BnkMemberMasterDaoLocal;

import com.nbs.model.BnkCustomerMaster;
import com.nbs.model.MemMemberShipMaster;
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
public class GetViewMemberServlet extends HttpServlet {

    @EJB
    private BnkMemberMasterDaoLocal bnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String checkbox = request.getParameter("allAreas");
            String areaId = request.getParameter("areaID");
            String membrTip = request.getParameter("memberTip");

            long id = -1;
            if (areaId != null) {
                if (!areaId.equals("")) {
                    id = Long.parseLong(areaId);
                }
            }
            //      String tellerIndexKey = request.getParameter("tellerIndexKey");

            List<MemMemberShipMaster> viewAllMember = getViewAllMember(checkbox, id, membrTip);
            System.out.println(id+"this is the id");
            request.getSession().setAttribute("allMembers", viewAllMember);

            response.sendRedirect("member/view_members.jsp?chekOn="+checkbox+"&areaId="+id+"&tip="+membrTip+"");

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

    private List<MemMemberShipMaster> getViewAllMember(String on, long areaId, String memberTip) {
        List<MemMemberShipMaster> masters = null;
        if (bnkCustomerMasterDao == null) {
            bnkCustomerMasterDao = new BnkMemberMasterDao();
        }
        masters = bnkCustomerMasterDao.getMembersView(on, areaId, memberTip);
        return masters;
    }

}
