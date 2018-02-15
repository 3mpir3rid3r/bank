/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.common.CrDrTable;
import com.nbs.common.Security;
import com.nbs.dao.BnkOtherTranDTDaoLocal;
import com.nbs.dao.BnkOtherTranHDDaoLocal;
import com.nbs.model.BnkOtherTranDT;
import com.nbs.model.BnkOtherTranHD;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.GenUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class SaveCredtorServlet extends HttpServlet {

    @EJB
    private BnkOtherTranHDDaoLocal bnkOtherTranHDDao;
    @EJB
    private BnkOtherTranDTDaoLocal bnkOtherTranDTDao;

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

            String index = request.getParameter("index");
            String act4 = request.getParameter("act4");
            String cReceiptNo = request.getParameter("cReceiptNo");
            String dTrnDate = "";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (request.getParameter("dTrnDate").isEmpty()) {
                dTrnDate = dateFormat.format(new Date());
            } else {
                dTrnDate = request.getParameter("dTrnDate");
            }
            String cChequeNo = request.getParameter("cChequeNo");
            String dChequeDate = "";
            if (request.getParameter("dChequeDate").isEmpty()) {
                dChequeDate = dateFormat.format(new Date());
            } else {
                dChequeDate = request.getParameter("dChequeDate");
            }
            String cCustomerName = request.getParameter("cCustomerName");
            String cRemarks = request.getParameter("cRemarks");
            String nAmount = "0";

            if (request.getSession().getAttribute("list") == null) {
                response.sendRedirect("teller/creditor_debtor.jsp?index=" + Security.encrypt(index) + "&alert=" + Security.encrypt("list"));
            } else {

                BnkOtherTranHD h = new BnkOtherTranHD();
                BnkRefBankBranch bankBranch = (BnkRefBankBranch) request.getSession().getAttribute("branch");
                h.setNBankBranchID(bankBranch.getNBankBranchID());
                h.setDTrnDate(dateFormat.parse(dTrnDate));
                h.setDDepositDate(new java.util.Date());
                h.setNGLTrnID(Integer.parseInt(index));
                h.setNTrnAcctLevelID4(Integer.parseInt(act4));
                h.setNOutsiderMFID(1);
                h.setNTrnStatusID(2);
                h.setCReceiptNo(cReceiptNo);
                h.setCCustomerName(cCustomerName);
                h.setCRemarks(cRemarks);
                h.setCAddTime(new java.util.Date());
                GenUser genUser = (GenUser) request.getSession().getAttribute("user");
                h.setCAddBy(genUser.getCUserName());
                h.setDAddDate(new java.util.Date());
                h.setCChequeNo(cChequeNo);
//            h.setDChequeDate(Date.valueOf(dChequeDate));
                h.setNJournalHDID(BigInteger.ZERO);
                h.setNTellerID(genUser.getNUserID());

//            String get1A[] = request.getParameterValues("get1");
//            String get2A[] = request.getParameterValues("get2");
//            String get3A[] = request.getParameterValues("get3");
//            String get4A[] = request.getParameterValues("get4");
//
//            String g1 = get1A[0];
//            String g2 = get2A[0];
//            String g3 = get3A[0];
//            String g4 = get4A[0];
//
//            String G1[] = g1.split(",");
//            String G2[] = g2.split(",");
//            String G3[] = g3.split(",");
//            String G4[] = g4.split(",");
                List<CrDrTable> crdrL = new ArrayList<>();
                List<CrDrTable> crdrGet = (List<CrDrTable>) request.getSession().getAttribute("list");
                CrDrTable cdt = null;
                double amount = 0;
                for (CrDrTable c : crdrGet) {
                    cdt = new CrDrTable();
                    cdt.setRow1(c.getRow1());
                    cdt.setRow2(c.getRow2());
                    cdt.setRow3(c.getRow3());
                    cdt.setRow4(c.getRow4());
                    crdrL.add(cdt);
                    amount += Double.parseDouble(c.getRow4());
                }
                nAmount = amount + "";

                h.setNAmount(new BigDecimal(nAmount));
                if ("114".equals(index)) {
                    h.setNCr(BigDecimal.ZERO);
                    h.setNDr(new BigDecimal(nAmount));
                } else if ("115".equals(index)) {
                    h.setNCr(new BigDecimal(nAmount));
                    h.setNDr(BigDecimal.ZERO);
                } else if ("116".equals(index)) {
                    h.setNCr(new BigDecimal(nAmount));
                    h.setNDr(BigDecimal.ZERO);
                } else if ("117".equals(index)) {
                    h.setNCr(BigDecimal.ZERO);
                    h.setNDr(new BigDecimal(nAmount));
                }

                bnkOtherTranHDDao.saveBnkOtherTranHD(h);
                Long NOthTrnHDID = h.getNOthTrnHDID();
                List<BnkOtherTranDT> bnkOtherTranDTs = new ArrayList<>();
                BnkOtherTranDT b = null;
                for (CrDrTable c : crdrL) {
                    b = new BnkOtherTranDT();
                    b.setNOthTrnHDID(NOthTrnHDID);
                    b.setNAcctLevelID4(Integer.parseInt(c.getRow1()));
                    b.setCDescription(c.getRow3());
                    b.setNJournalDTID(0);
                    b.setBPrint(false);
                    b.setBPosted(false);
                    b.setNPaymentVal(new BigDecimal(c.getRow4()));
                    if ("114".equals(index)) {
                        b.setNCr(new BigDecimal(c.getRow4()));
                        b.setNDr(BigDecimal.ZERO);
                    } else if ("115".equals(index)) {
                        b.setNCr(BigDecimal.ZERO);
                        b.setNDr(new BigDecimal(c.getRow4()));
                    } else if ("116".equals(index)) {
                        b.setNCr(BigDecimal.ZERO);
                        b.setNDr(new BigDecimal(c.getRow4()));
                    } else if ("117".equals(index)) {
                        b.setNCr(new BigDecimal(c.getRow4()));
                        b.setNDr(BigDecimal.ZERO);
                    }

                    b.setCAddBy(genUser.getCUserName());
                    b.setCAddDate(new java.util.Date());
                    b.setNGLTrnID(Integer.parseInt(index));
                    b.setNOutsiderMFID(1);
                    bnkOtherTranDTs.add(b);
                }
                System.out.print("saved..........." + h.getNOthTrnHDID());
                bnkOtherTranDTDao.saveBnkOtherTranTD(bnkOtherTranDTs, NOthTrnHDID);

                System.out.print("INDEX......" + index);
                request.getSession().removeAttribute("CrDr");
                request.getSession().removeAttribute("cDescription");
                request.getSession().removeAttribute("act4");
                request.getSession().removeAttribute("list");
                request.getSession().removeAttribute("indexenc");
                response.sendRedirect("teller/creditor_debtor.jsp?index=" + Security.encrypt(index) + "&alert=" + Security.encrypt("success"));
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
