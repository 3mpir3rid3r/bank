/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.dao.BnkLonLoanGurantorDaoLocal;
import com.nbs.model.BnkLonLoanGurantor;
import com.nbs.model.BnkLonLoanGurantorPK;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasa
 */
public class NewBnkLonLoanGurantorServlet extends HttpServlet {

    @EJB
    private BnkLonLoanGurantorDaoLocal bnkLonLoanGurantorDao;

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String indexNum = request.getParameter("indexNum");

        String aM = request.getParameter("aM");
        String lgn = request.getParameter("lgn");
        String type = request.getParameter("type");
        String rks = request.getParameter("rks");

        if (indexNum == null) {

            if (request.getSession().getAttribute("gareterList") != null) {

                String nLonMFIDString = request.getParameter("nLonMFID");
                Long nLonMFID = 0L;
                if (!nLonMFIDString.isEmpty()) {
                    nLonMFID = Long.parseLong(nLonMFIDString);
                }

                List<BnkLonLoanGurantor> bllgs = new ArrayList<>();

                List< List<String>> gareterList = (List< List<String>>) request.getSession().getAttribute("gareterList");
                for (List<String> list : gareterList) {

                    String cCIFNo = list.get(0);
                    Long custID = bnkCustomerMasterDao.getBnkCustomerMasterCustomerIDByCIFNo(cCIFNo);

                    BnkLonLoanGurantor bllg = new BnkLonLoanGurantor();
                    BnkLonLoanGurantorPK bllgpk = new BnkLonLoanGurantorPK(nLonMFID, custID);
                    bllg.setBnkLonLoanGurantorPK(bllgpk);

                    int gurantorTypeID = 0;
                    String sGarenterType[] = {"Garrenter1", "Garrenter2", "Garrenter3", "Garrenter4", "Garrenter5", "Garrenter6",
                        "Garrenter7", "Garrenter8", "Garrenter9", "Garrenter10", "Garrenter11", "Garrenter12", "Garrenter13", "Garrenter14", "Garrenter15",};
                    for (int i = 0; i < sGarenterType.length; i++) {
                        if (sGarenterType[i].equals(list.get(2))) {
                            gurantorTypeID = i + 1;
                            break;
                        }
                    }
                    bllg.setNGurantorTypeID(gurantorTypeID);
                    bllg.setCRemarks(list.get(3));

                    bllgs.add(bllg);

                }

                bnkLonLoanGurantorDao.insertBnkLonLoanGurantor(bllgs);
                response.sendRedirect("teller/loarn_details.jsp");
            }

        } else {
            if (!aM.isEmpty() && !lgn.isEmpty() && !rks.isEmpty()) {
                List<String> gList = new ArrayList<>();
                gList.add(aM);
                gList.add(lgn);
                gList.add(type);
                gList.add(rks);

                List< List<String>> gareterList = new ArrayList<>();
                if (request.getSession().getAttribute("gareterList") == null) {
                    gareterList.add(gList);
                    request.getSession().setAttribute("gareterList", gareterList);
                } else {
                    gareterList = (List< List<String>>) request.getSession().getAttribute("gareterList");
                    int index = Integer.parseInt(indexNum);
                    if (index != -100) {
                        gareterList.remove(index);
                    }
                    gareterList.add(gList);
                    request.getSession().setAttribute("gareterList", gareterList);
                }
                response.sendRedirect("teller/loarn_details.jsp");
            } else {
                response.sendRedirect("teller/loarn_details.jsp");
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
