/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
public class GetPwningDetailsServlet extends HttpServlet {

    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String storeNumber = request.getParameter("storeRowNumber");
            List<VFindDatabnkDepDepositMaster> customersView = (List<VFindDatabnkDepDepositMaster>) request.getSession().getAttribute("pawningAllCustomers");

            VFindDatabnkDepDepositMaster depositMaster = customersView.get(Integer.parseInt(storeNumber) - 1);

            List<BnkPwnPawnMaster> pwnDataUsingName = bnkPwnPawnMasterDao.getPwnDataUsingName(depositMaster.getCFullName());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            request.getSession().setAttribute("alredyPawn", pwnDataUsingName);
            String allOut = "<table class='table table-bordered table-hover' >"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td width='10px'></td>\n"
                    + "<th>Account No</th>\n"
                    + "<th>Recipt No</th>\n"
                    + "<th>Name</th>\n"
                    + "<th >Date</th>\n"
                    + "<th>Advance</th>\n"
                    + "<th>Amount</th>\n"
                    + "<td width='100px'></td></tr> ";

            for (BnkPwnPawnMaster bnkPwnPawnMaster : pwnDataUsingName) {
                String date = "";
                if (bnkPwnPawnMaster.getDPwnDate() != null) {
                    date = sdf.format(bnkPwnPawnMaster.getDPwnDate());
                }
                allOut += "<tr onclick='getMoreDetails(this);'><td></td><td style='font-size: 12px;'width='100px'>" + depositMaster.getCOurAccountNo()+ " </td>"
                        + "<td style='font-size: 12px;'width='100px'>" +bnkPwnPawnMaster.getCReceiptNo() + " </td>"
                        + "<td style='font-size: 12px;'>" +bnkPwnPawnMaster.getCFullName() + " </td>"
                        + "<td style='font-size: 12px;' width='100px'>" +date + " </td>"
                        + "<td style='font-size: 12px;' width='100px'>" +bnkPwnPawnMaster.getNPwnAdvancedIssued() + " </td>"
                        + "<td style='font-size: 12px;' width='100px'>" +bnkPwnPawnMaster.getNAuctionReceivedAmount() + " </td>"
                        + "<td style='font-size: 12px;' width=100px><button  class='btn btn-default btn-sm'>View Pawning</button> </td>"
                        + "</tr>";
            }

            out.print(allOut + "</tbody></table>");

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
