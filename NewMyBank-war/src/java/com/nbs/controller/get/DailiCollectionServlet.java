/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.common.DailyCollection;
import com.nbs.dao.BnkDepDailyCollectionTempDaoLocal;
import com.nbs.model.BnkDepDailyCollectionTemp;
import com.nbs.model.BnkDepDepositMaster;
import com.nbs.model.GenUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class DailiCollectionServlet extends HttpServlet {

    @EJB
    private BnkDepDailyCollectionTempDaoLocal bnkDepDailyCollectionTempDao;

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
            GenUser genUser = (GenUser) request.getSession().getAttribute("user");
            if (request.getParameter("refresh") != null) {
                List<BnkDepDailyCollectionTemp> listSession2 = bnkDepDailyCollectionTempDao.getAll(genUser);
                request.getSession().setAttribute("daily_collection2", listSession2);
                response.sendRedirect("teller/daily_collection.jsp");
            } else if (request.getParameter("save") != null) {
                List<DailyCollection> listSession = (List<DailyCollection>) request.getSession().getAttribute("daily_collection");
                BnkDepDailyCollectionTemp bddct = null;
                List<BnkDepDailyCollectionTemp> bnkList = new ArrayList<>();
                for (int i = 0; i < listSession.size(); i++) {
                    DailyCollection d = listSession.get(i);
                    bddct = new BnkDepDailyCollectionTemp();
                    bddct.setNDepMFID(new BnkDepDepositMaster(d.getnDepMFID()));
                    bddct.setDTrnDate(d.getdTrnDate());
                    bddct.setNTrnStatusID(2);
                    bddct.setNDr(BigDecimal.ZERO);
                    bddct.setNCr(d.getnCr());
                    bddct.setCAddBy(genUser.getCUserName());
                    bddct.setCReceiptNo(d.getcReceiptNo());
                    bnkList.add(i, bddct);
                }
                bnkDepDailyCollectionTempDao.saveDailyCollection(bnkList);
                List<BnkDepDailyCollectionTemp> listSession2 = bnkDepDailyCollectionTempDao.getAll(genUser);
                request.getSession().setAttribute("daily_collection2", listSession2);
                response.sendRedirect("teller/daily_collection.jsp");
            } else {
                List<DailyCollection> list = new ArrayList<>();
                DailyCollection dc = null;
                if (request.getSession().getAttribute("daily_collection") != null && request.getParameter("remove").equals("0")) {
                    String accNumber = request.getParameter("accNumber");
                    String accName = request.getParameter("accName");
                    String bera = request.getParameter("bera");
                    String rno = request.getParameter("rno");
                    String nDepMFID = request.getParameter("nDepMFID");
                    List<DailyCollection> listSession = (List<DailyCollection>) request.getSession().getAttribute("daily_collection");
                    for (DailyCollection b : listSession) {
                        dc = new DailyCollection();
                        dc.setAccNumber(b.getAccNumber());
                        dc.setAccName(b.getAccName());
                        dc.setnDepMFID(b.getnDepMFID());
                        dc.setdTrnDate(b.getdTrnDate());
                        dc.setnCr(b.getnCr());
                        dc.setAddBy("");
                        dc.setcReceiptNo(b.getcReceiptNo());
                        list.add(dc);
                    }
                    dc = new DailyCollection();
                    dc.setnDepMFID(Long.parseLong(nDepMFID));
                    dc.setAccNumber(accNumber);
                    dc.setAccName(accName);
                    dc.setdTrnDate(new Date());
                    dc.setnCr(new BigDecimal(bera));
                    dc.setAddBy("");
                    dc.setcReceiptNo(rno);
                    list.add(dc);
                    request.getSession().setAttribute("daily_collection", list);
                    
                    response.sendRedirect("teller/daily_collection.jsp");
                } else if (request.getSession().getAttribute("daily_collection") == null && request.getParameter("remove").equals("0")) {
                    String accNumber = request.getParameter("accNumber");
                    String accName = request.getParameter("accName");
                    String bera = request.getParameter("bera");
                    String rno = request.getParameter("rno");
                    String nDepMFID = request.getParameter("nDepMFID");
                    dc = new DailyCollection();
                    dc.setnDepMFID(Long.parseLong(nDepMFID));
                    dc.setAccNumber(accNumber);
                    dc.setAccName(accName);
                    dc.setdTrnDate(new Date());
                    dc.setnCr(new BigDecimal(bera));
                    dc.setAddBy("");
                    dc.setcReceiptNo(rno);
                    list.add(dc);
                    request.getSession().setAttribute("daily_collection", list);
                    
                    response.sendRedirect("teller/daily_collection.jsp");
                }
                boolean bool = true;
                if (!request.getParameter("remove").equals("0")) {
                    Long nDepMFID = Long.parseLong(request.getParameter("remove"));
                    List<DailyCollection> listSession = (List<DailyCollection>) request.getSession().getAttribute("daily_collection");
                    if (listSession != null) {
                        for (int i = 0; i < listSession.size(); i++) {
                            if (Objects.equals(listSession.get(i).getnDepMFID(), nDepMFID)) {
                                listSession.remove(i);
                                bool = false;
                            }
                        }
                    }
                    if (bool) {
                        bnkDepDailyCollectionTempDao.remveCollection(nDepMFID);
                        List<BnkDepDailyCollectionTemp> listSession2 = bnkDepDailyCollectionTempDao.getAll(genUser);
                        request.getSession().setAttribute("daily_collection2", listSession2);
                    }
                    request.getSession().removeAttribute("daily_collection");
                    request.getSession().setAttribute("daily_collection", listSession);

                    response.sendRedirect("teller/daily_collection.jsp");
                }
                List<DailyCollection> listSession = (List<DailyCollection>) request.getSession().getAttribute("daily_collection");
                if (listSession != null) {
                    if (listSession.size() == 5) {
                        BnkDepDailyCollectionTemp bddct = null;
                        List<BnkDepDailyCollectionTemp> bnkList = new ArrayList<>();
                        for (int i = 0; i < listSession.size(); i++) {
                            DailyCollection d = listSession.get(i);
                            bddct = new BnkDepDailyCollectionTemp();
                            bddct.setNDepMFID(new BnkDepDepositMaster(d.getnDepMFID()));
                            bddct.setDTrnDate(d.getdTrnDate());
                            bddct.setNTrnStatusID(2);
                            bddct.setNDr(BigDecimal.ZERO);
                            bddct.setNCr(d.getnCr());
                            bddct.setCAddBy(genUser.getCUserName());
                            bddct.setCReceiptNo(d.getcReceiptNo());
                            bnkList.add(i, bddct);
                        }
                        bnkDepDailyCollectionTempDao.saveDailyCollection(bnkList);

//                        List<BnkDepDailyCollectionTemp> listSession2 = bnkDepDailyCollectionTempDao.getAll(genUser);
//                        List<DailyCollection> collections = new ArrayList<>();
//                        DailyCollection dc1 = null;
//                        for (BnkDepDailyCollectionTemp d : listSession2) {
//                            dc1.setnTempId(d.getNTempDailyID());
//                            dc1.setAccNumber(d.getNDepMFID().getCOurAccountNo());
//                            dc1.setAccName(d.getNDepMFID().getNCustomerID().getCFullName());
//                            dc1.setnCr(d.getNCr());
//                            dc1.setcReceiptNo(d.getCReceiptNo());
//                            collections.add(dc1);
//                        }
//                        
//                        request.getSession().setAttribute("daily_collection2", collections);
//
//                        request.getSession().removeAttribute("daily_collection");//    
                        response.sendRedirect("DailiCollectionServlet?refresh=refresh");
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
