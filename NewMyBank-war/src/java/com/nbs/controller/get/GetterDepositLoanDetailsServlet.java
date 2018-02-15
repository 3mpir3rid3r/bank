/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.Security;
import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.dao.BnkDepDepositMasterDaoLocal;
import com.nbs.dao.BnkLonLoanMasterDaoLocal;
import com.nbs.model.BnkCustomerMaster;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import com.nbs.model.VFindDatabnkLonLoanMaster;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasa
 */
public class GetterDepositLoanDetailsServlet extends HttpServlet {

    @EJB
    private BnkLonLoanMasterDaoLocal bnkLonLoanMasterDao;

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

    @EJB
    private BnkDepDepositMasterDaoLocal bnkDepDepositMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String identityEncript = request.getParameter("identityEncript");

            String enterNumber;
            if (identityEncript == null) {
                enterNumber = request.getParameter("accountNumber");
                String splitString[] = enterNumber.split("-");
                switch (splitString.length) {
                    case 3:
                        enterNumber = splitString[0] + splitString[1] + splitString[2];
                        break;
                    case 2:
                        enterNumber = splitString[0] + splitString[1];
                        break;
                    default:
                        enterNumber = request.getParameter("accountNumber");
                        break;
                }
            } else {
                enterNumber = Security.decrypt(request.getParameter("accountNumber").replace(" ", "+"));
            }

            String accountValue = request.getParameter("accountValue");
            
            String error = "";

            if (enterNumber.isEmpty()) {
                switch (accountValue) {
                    case "1":
                        response.sendRedirect("teller/view_depositmaster.jsp?tellerIndexKey=1");
                        break;
                    case "2":
                        response.sendRedirect("teller/view_customers.jsp?tellerIndexKey=2");
                        break;
                    case "3":
                        response.sendRedirect("teller/view_customers.jsp?tellerIndexKey=3");
                        break;
                    case "4":
                        response.sendRedirect("teller/view_loanmaster.jsp?tellerIndexKey=4");
                        break;
                   default:
                        response.sendRedirect("teller/view_customers.jsp?tellerIndexKey=5");
                }
            } else {
                BigInteger custID;
                BnkCustomerMaster bnkCustomerMaster = new BnkCustomerMaster();
                switch (accountValue) {
                    case "1":
                        custID = bnkDepDepositMasterDao.getBnkDepDepositMasterCustID(enterNumber);
                        if(enterNumber.length() >  5 ){
                            enterNumber = enterNumber.substring(0, 2) + "-" + enterNumber.substring(2, 5) + "-" + enterNumber.substring(5);
                            System.out.println(enterNumber);
                        }else if(enterNumber.length() <=  5 && enterNumber.length() >  2){
                            enterNumber = enterNumber.substring(0, 2) + "-" + enterNumber.substring(2);
                            System.out.println(enterNumber);
                        }else{
                            enterNumber = enterNumber.substring(0);
                            System.out.println(enterNumber);
                        }
                        error = "ගිණුම් අංකය වැරදි";
                        break;
                    case "2":
                        custID = BigInteger.valueOf(bnkCustomerMasterDao.getBnkCustomerMasterCustomerIDByCIFNo(enterNumber));
                        if(enterNumber.length() > 3){
                            enterNumber = enterNumber.substring(0, 3) + "-" + enterNumber.substring(3);
                            System.out.println(enterNumber);
                        }else{
                            enterNumber = enterNumber.substring(0);
                            System.out.println(enterNumber);
                        }
                        error = "පා.ලි අංකය වැරදි";
                        break;
                    case "3":
                        custID = BigInteger.valueOf(bnkCustomerMasterDao.getBnkCustomerMasterCustomerIDByNICNo(enterNumber));
                        error = "ජැ.හැ. අංකය වැරදි";
                        break;
                    case "4":
                        custID = bnkLonLoanMasterDao.getBnkLonLoanMasterCustID(enterNumber);
                        if(enterNumber.length() >  5 ){
                            enterNumber = enterNumber.substring(0, 2) + "-" + enterNumber.substring(2, 5) + "-" + enterNumber.substring(5);
                        }else if(enterNumber.length() <=  5 && enterNumber.length() >  2){
                            enterNumber = enterNumber.substring(0, 2) + "-" + enterNumber.substring(2);
                        }else{
                            enterNumber = enterNumber.substring(0);
                        }
                        error = "ණය අංකය වැරදි";
                        break;
                    case "5":
                        custID = BigInteger.valueOf(bnkCustomerMasterDao.getBnkCustomerMasterCustomerIDByMemShipNo(enterNumber));
                        error = "සාමාජික අංකය වැරදි";
                        break;
                    default:
                        custID = BigInteger.ZERO;
                        System.out.println("EROOR......................");
                }

                if (custID != BigInteger.ZERO) {

                    List<VFindDatabnkDepDepositMaster> allBnkDepDepositMaster = bnkDepDepositMasterDao.getAllBnkDepDepositMaster(custID);
                    if (allBnkDepDepositMaster.size() > 0) {
                        bnkCustomerMaster.setCCIFNo(allBnkDepDepositMaster.get(0).getCCIFNo());
                        bnkCustomerMaster.setCFullName(allBnkDepDepositMaster.get(0).getCFullName());
                        bnkCustomerMaster.setCNICNo(allBnkDepDepositMaster.get(0).getCNICNo());
                        bnkCustomerMaster.setCMemberShipNo(allBnkDepDepositMaster.get(0).getCMemberShipNo());
                        bnkCustomerMaster.setCUseName(allBnkDepDepositMaster.get(0).getCUseName());
                        bnkCustomerMaster.setCPAddLine1(allBnkDepDepositMaster.get(0).getCPAddLine1());
                    }
                    List<VFindDatabnkLonLoanMaster> allBnkLonLoanMaster = bnkLonLoanMasterDao.getAllBnkLonLoanMaster(custID);
                    if (allBnkLonLoanMaster.size() > 0) {
                        bnkCustomerMaster.setCCIFNo(allBnkLonLoanMaster.get(0).getCCIFNo());
                        bnkCustomerMaster.setCFullName(allBnkLonLoanMaster.get(0).getCFullName());
                        bnkCustomerMaster.setCNICNo(allBnkLonLoanMaster.get(0).getCNICNo());
                        bnkCustomerMaster.setCMemberShipNo(allBnkLonLoanMaster.get(0).getCMemberShipNo());
                        bnkCustomerMaster.setCUseName(allBnkLonLoanMaster.get(0).getCUseName());
                        bnkCustomerMaster.setCPAddLine1(allBnkLonLoanMaster.get(0).getCPAddLine1());
                    }
                    
                    request.getSession().setAttribute("allBnkDepDepositMaster", allBnkDepDepositMaster);
                    request.getSession().setAttribute("allBnkLonLoanMaster", allBnkLonLoanMaster);
                    request.getSession().setAttribute("allBnkCustomerMaster", bnkCustomerMaster);
                    response.sendRedirect("teller/?accountValue=" + accountValue + "&accountNumber="+ Security.encrypt(enterNumber));

                } else {
                    request.getSession().setAttribute("error", error);
                    response.sendRedirect("teller/");
                }

            }
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(GetterDepositLoanDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
