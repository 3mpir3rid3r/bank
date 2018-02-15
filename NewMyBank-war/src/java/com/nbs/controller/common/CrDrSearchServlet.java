/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.common;

import com.nbs.common.CrDrTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class CrDrSearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String cReceiptNo = "";
            String dTrnDate = "";
            String cChequeNo = "";
            String dChequeDate = "";
            String cCustomerName = "";
            String cRemarks = "";
            String redirect = "";
            String pageId = "";
            if (request.getParameter("pageId") != null) {
                pageId = request.getParameter("pageId");
                if ("1".equals(request.getParameter("pageId"))) {
                    redirect = "teller/creditor_debtor.jsp";
                } else if ("2".equals(request.getParameter("pageId"))) {
                    redirect = "teller/savings_crdr.jsp";
                }
            }
            System.out.println(request.getParameter("pageId"));
            if (request.getParameter("cReceiptNo") != null) {
                cReceiptNo = request.getParameter("cReceiptNo");
            }
            if (request.getParameter("dTrnDate") != null) {
                dTrnDate = request.getParameter("dTrnDate");
            }
            if (request.getParameter("cChequeNo") != null) {
                cChequeNo = request.getParameter("cChequeNo");
            }
            if (request.getParameter("dChequeDate") != null) {
                dChequeDate = request.getParameter("dChequeDate");
            }
            if (request.getParameter("cCustomerName") != null) {
                cCustomerName = request.getParameter("cCustomerName");
            }
            if (request.getParameter("cRemarks") != null) {
                cRemarks = request.getParameter("cRemarks");
            }
            System.out.println(cReceiptNo);
            if (request.getParameter("view") != null) {
                if ("viewacc1".equals(request.getParameter("view"))) {
                    response.sendRedirect("teller/view_acc4.jsp?tellerIndexNo=1&pageId=" + pageId);

                } else if ("viewacc2".equals(request.getParameter("view"))) {
                    Map<Integer, String> m = new HashMap<>();
                    m.put(2, cReceiptNo);
                    m.put(3, dTrnDate);
                    m.put(4, cChequeNo);
                    m.put(5, dChequeDate);
                    m.put(6, cCustomerName);
                    m.put(7, cRemarks);

                    System.out.println((String) m.get(6) + "......00");
                    request.getSession().setAttribute("CrDr", m);
                    response.sendRedirect("teller/view_acc4.jsp?tellerIndexNo=2&pageId=" + pageId);
                } else if ("addRow".equals(request.getParameter("view"))) {
                    String cell2 = request.getParameter("cell2");
                    String cell3 = request.getParameter("cell3");
                    String cell4 = request.getSession().getAttribute("sub").toString();
                    String cell5 = request.getParameter("cell5");
                    request.getSession().removeAttribute("sub");
                    if (request.getSession().getAttribute("list") == null) {
                        List<CrDrTable> crdr = new ArrayList<>();
                        CrDrTable cdt = new CrDrTable();
                        cdt.setRow1(cell2);
                        cdt.setRow2(cell3);
                        cdt.setRow3(cell4);
                        cdt.setRow4(cell5);
                        crdr.add(cdt);
                        request.getSession().setAttribute("list", crdr);
                        response.sendRedirect(redirect);
                    } else {
                        List<CrDrTable> crdr = (List<CrDrTable>) request.getSession().getAttribute("list");
                        CrDrTable cdt = new CrDrTable();
                        cdt.setRow1(cell2);
                        cdt.setRow2(cell3);
                        cdt.setRow3(cell4);
                        cdt.setRow4(cell5);
                        crdr.add(cdt);
                        request.getSession().setAttribute("list", crdr);
                        response.sendRedirect(redirect);
                    }
                } else if ("delete".equals(request.getParameter("view"))) {
                    String id = request.getParameter("id");
                    out.write(id);
                    List<CrDrTable> crdr = (List<CrDrTable>) request.getSession().getAttribute("list");
                    for (int i = 0; i < crdr.size(); i++) {
                        CrDrTable cdt = crdr.get(i);
                        if (Integer.parseInt(cdt.getRow1()) == Integer.parseInt(id)) {
                            crdr.remove(i);
                        }
                    }
                    request.getSession().setAttribute("list", crdr);
                    response.sendRedirect(redirect);
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
