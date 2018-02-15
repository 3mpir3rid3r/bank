/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.dao.BnkPwnPawnMasterArticlesDaoLocal;
import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkRefBankBranch;
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
public class RePwnMasterServlet extends HttpServlet {

    @EJB
    private BnkPwnPawnMasterArticlesDaoLocal bnkPwnPawnMasterArticlesDao;

    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            if (request.getParameter("key") != null) {

                String index = null;
                String key = request.getParameter("key");
                if (!key.equals("viewPage")) {
                    index = request.getSession().getAttribute("index").toString();
                }

                BnkRefBankBranch bankBranch = (BnkRefBankBranch) request.getSession().getAttribute("branch");

                if ("searchForm".equals(key)) {
                    String searchText = request.getParameter("search");
                    if ("".equals(searchText)) {
                        response.sendRedirect("pawning/view_pawning.jsp?key=");
                    } else {
                        BnkPwnPawnMaster bppm = bnkPwnPawnMasterDao.getBnkPwnPawnMasterBycReceiptNo(searchText);
                        if (bppm == null) {
                            response.sendRedirect("pawning/view_pawning.jsp?key=" + searchText);
                        } else {
                            request.getSession().setAttribute("BnkPwnPawnMasterArticles", bnkPwnPawnMasterArticlesDao.getBnkPwnPawnMasterArticlesList(bppm.getNPwnMasterID()));
                            request.getSession().setAttribute("BnkPwnPawnMaster", bppm);
                            response.sendRedirect("pawning/re_pawning.jsp?index=" + index + "&key=" + searchText);
                        }
                    }
                } else if ("searchPage".equals(key)) {
                    String searchText = request.getParameter("searchText");
                    if (bnkPwnPawnMasterDao.getBnkPwnPawnMasterList(searchText, bankBranch.getNBankBranchID(), 1) != null) {

                        request.getSession().setAttribute("BnkPwnPawnMasterList", bnkPwnPawnMasterDao.getBnkPwnPawnMasterList(searchText, bankBranch.getNBankBranchID(), 1));
                    }
                    response.sendRedirect("pawning/view_pawning.jsp?key=" + searchText);

                } else if ("searchedKey".equals(key)) {
                    String searchText = request.getParameter("receiptNo");
                    BnkPwnPawnMaster bppm = bnkPwnPawnMasterDao.getBnkPwnPawnMasterBycReceiptNo(searchText);
                    request.getSession().setAttribute("BnkPwnPawnMasterArticles", bnkPwnPawnMasterArticlesDao.getBnkPwnPawnMasterArticlesList(bppm.getNPwnMasterID()));
                    request.getSession().setAttribute("BnkPwnPawnMaster", bppm);
                    response.sendRedirect("pawning/re_pawning.jsp?index=" + index + "&key=" + searchText);
                } else if ("viewPage".equals(key)) {
                    //BnkPwnPawnMasterList

                    String bnkId = request.getParameter("branchCmb");
                    String pwnTypeId = request.getParameter("typeCmb");
                    String fromDate = request.getParameter("fromDate");
                    String toDate = request.getParameter("toDate");
                    
                    

                    int branchId = 0;
                    int typeId = 0;
                    if (bnkId.equals("0")) {
                       // response.sendRedirect("pawning/view_pawning_1.jsp");
                    } else {
                        branchId = Integer.parseInt(bnkId);
                    }

                    if (pwnTypeId.equals("0")) {
                       // response.sendRedirect("pawning/view_pawning_1.jsp");
                    } else {
                        typeId = Integer.parseInt(pwnTypeId);
                    }
//                    System.out.println(branchId+" " +typeId+" " +fromDate+ toDate);
                    List<BnkPwnPawnMaster> bnkPwnPawnMasterList = bnkPwnPawnMasterDao.getBnkPwnPawnMasterList(branchId, 1, typeId, fromDate, toDate);
                    if (bnkPwnPawnMasterList != null) {
                        request.getSession().setAttribute("BnkPwnPawnMasterList", bnkPwnPawnMasterList);
                        request.getSession().setAttribute("fromPwnDate", fromDate);
                        request.getSession().setAttribute("toPwnDate", toDate);
                        request.getSession().setAttribute("branchPwnId", branchId);
                        request.getSession().setAttribute("pwnTypePwnId", typeId);
   
                        response.sendRedirect("pawning/view_pawning_1.jsp");
                        
                    } else {
                        response.sendRedirect("pawning/view_pawning_1.jsp");
                    }

                }
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
