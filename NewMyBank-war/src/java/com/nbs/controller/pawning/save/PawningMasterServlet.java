/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.pawning.save;

import com.nbs.common.CrDrTable;
import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.dao.BnkPwnPawnMasterArticlesDaoLocal;
import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.ActSectionsSub;
import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkPwnPawnMasterArticles;
import com.nbs.model.GenUser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author lasa
 */
public class PawningMasterServlet extends HttpServlet {

    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;

    @EJB
    private BnkPwnPawnMasterArticlesDaoLocal bnkPwnPawnMasterArticlesDao;

    @EJB
    private BnkCustomerMasterDaoLocalrLocal bnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int redirectorCount = 0;

            request.getSession().setAttribute("pawntypecombo", bnkPwnPawnMasterDao.getBnkPwnPawnTypes());
            request.getSession().setAttribute("RefArticlcombo", bnkPwnPawnMasterDao.getBnkPwnRefArticls());
            request.getSession().setAttribute("RefCarateValuescombo", bnkPwnPawnMasterDao.getBnkPwnRefCarateValues());
            if (request.getParameter("keySerch") != null) {
                if (request.getParameter("nic").equals("1")) {

                    String cNICNo = request.getParameter("keySerch");
                    BnkPwnPawnMaster pm = bnkPwnPawnMasterDao.getBnkPwnPawnMasterByNic(cNICNo);

//remove n use data/............
                    if (pm != null) {
                        pm.setNTotWgtArt(null);
                        pm.setNTotWgtGold(null);
                        pm.setCReceiptNo(null);
                        pm.setNPwnDescriptionID(null);
                        pm.setNPwnPeriodTypeID(null);
                        pm.setNPwnPeriod(null);
                        pm.setNTotMkrtValue(null);
                        pm.setNOneGramAssessedValue(null);
                        pm.setNEffectiveInt(null);
                        pm.setNPwnAdvancedIssued(null);
                        pm.setNActualInt(null);
                        pm.setNPwnBalanceAmount(null);
                        pm.setDLastIntPayDate(null);
                        pm.setDMaturityDate(null);
                        pm.setCRemrks(null);
                        pm.setBOldPawn(null);
                        pm.setNPwnTypeID(0);
                        pm.setNTotWgtGold(null);
                    }
                    //////////////////////////////////////         
                    if (pm == null) {
                        pm = new BnkPwnPawnMaster();

                        if (cNICNo.length() > 10) {
                            cNICNo = cNICNo.substring(0, 10);
                        }
                        pm.setCIDNo(cNICNo);
                        pm.setCPAddLine1("");
                        pm.setCPAddLine2("");
                        pm.setCPAddLine3("");
                        pm.setCPAddLine4("");
                        pm.setCFullName("");
                        pm.setCPTelNo1("");
                        pm.setCPTelNo2("");

                    }
                    request.getSession().setAttribute("iddetail", pm);

                    //request.getSession().setAttribute("tlist", cdts);
                } else {
                    redirectorCount = 1;
                    String deposiDetail = request.getParameter("keySerch");
                    response.sendRedirect("ViewDepositCustomerServlet?key=" + deposiDetail + "");

                }
            }

            if (request.getParameter("key") != null) {
                if ("addTable".equals(request.getParameter("key"))) {
                    if (request.getParameter("col1") != null && !"- Select -".equals(request.getParameter("col1")) && request.getParameter("col2") != null && !"- Select -".equals(request.getParameter("col2"))) {
                        String col1 = request.getParameter("col1");
                        String col2 = request.getParameter("col2");
                        String col3 = request.getParameter("col3");
                        String col4 = request.getParameter("col4");
                        String id1 = request.getParameter("id1");
                        String id2 = request.getParameter("id2");

                        if (request.getSession().getAttribute("tlist") == null) {
                            List<CrDrTable> cdts = new ArrayList<>();
                            CrDrTable cdt = new CrDrTable();
                            cdt.setRow1(col1);
                            cdt.setRow2(col2);
                            cdt.setRow3(col3);
                            cdt.setRow4(col4);
                            cdt.setId(Integer.parseInt(id1));
                            cdt.setId2(Integer.parseInt(id2));
                            cdts.add(cdt);

                            storeData(request);

                            request.getSession().setAttribute("tlist", cdts);
                        } else {
                            List<CrDrTable> cdts = (List<CrDrTable>) request.getSession().getAttribute("tlist");
                            CrDrTable cdt = new CrDrTable();
                            cdt.setRow1(col1);
                            cdt.setRow2(col2);
                            cdt.setRow3(col3);
                            cdt.setRow4(col4);
                            cdt.setId(Integer.parseInt(id1));
                            cdt.setId2(Integer.parseInt(id2));

                            cdts.add(cdt);
                            storeData(request);
                            request.getSession().setAttribute("tlist", cdts);
                        }
                    } else {
                        storeData(request);
                        // response.sendRedirect("pawning/pawning_master.jsp");
                    }
                } else if ("delete".equals(request.getParameter("key"))) {
                    List<CrDrTable> cdts = (List<CrDrTable>) request.getSession().getAttribute("tlist");

                    if (request.getParameter("deleteAll") != null) {
                        request.getSession().removeAttribute("iddetail");
                        request.getSession().removeAttribute("tlist");
                    }

                    if (cdts != null) {
                        if (request.getParameter("did") != null) {
                            for (int i = 0; i < cdts.size(); i++) {
                                CrDrTable cdt = cdts.get(i);
                                if (Integer.parseInt(request.getParameter("did")) == cdt.getId()) {
                                    cdts.remove(i);
                                }
                            }
                        }
                    }
                } else if ("0".equals(request.getParameter("key"))) {
                    if (request.getParameter("keySerch") == null) {

                        String BnkPwnPawnTypesID = request.getParameter("BnkPwnPawnTypesID");
                        boolean PWN = Boolean.getBoolean(request.getParameter("PWN"));
                        String nActualInt = request.getParameter("nActualInt").replaceAll(",", "");
                        String cNICNo = request.getParameter("cNICNo").replaceAll(",", "");
                        String dNICIssuedDate = request.getParameter("dNICIssuedDate").replaceAll(",", "");
                        String cFullName = request.getParameter("cFullName").replaceAll(",", "");
                        String cPAddLine1 = request.getParameter("cPAddLine1").replaceAll(",", "");
                        String cPAddLine2 = request.getParameter("cPAddLine2").replaceAll(",", "");
                        String cPAddLine3 = request.getParameter("cPAddLine3").replaceAll(",", "");
                        String cPAddLine4 = request.getParameter("cPAddLine4").replaceAll(",", "");
                        String cPTelNo1 = request.getParameter("cPTelNo1").replaceAll(",", "");
                        String cBTelNo1 = request.getParameter("cBTelNo1").replaceAll(",", "");
                        String cPictureFileName = request.getParameter("userImage");

                        double nOneGramAssessedValue = 0.0;
                        if (request.getParameter("nOneGramAssessedValue") != null && request.getParameter("nOneGramAssessedValue").length() > 0) {
                            nOneGramAssessedValue = Double.parseDouble(request.getParameter("nOneGramAssessedValue").replaceAll(",", ""));
                        }

                        String cReceiptNo = request.getParameter("cReceiptNo");

                        double nTotWgtArt = 0.0;

                        if (request.getParameter("nTotWgtArt") != null && request.getParameter("nTotWgtArt").length() > 0) {
                            nTotWgtArt = Double.parseDouble(request.getParameter("nTotWgtArt").replaceAll(",", ""));
                        }

                        double nTotWgtGold = 0.0;
                        if (request.getParameter("nTotWgtGold") != null && request.getParameter("nTotWgtGold").length() > 0) {
                            nTotWgtGold = Double.parseDouble(request.getParameter("nTotWgtGold").replaceAll(",", ""));
                        }

                        double nTotAdvAmount = 0.0;
                        if (request.getParameter("nTotAdvAmount") != null && request.getParameter("nTotAdvAmount").length() > 0) {
                            nTotAdvAmount = Double.parseDouble(request.getParameter("nTotAdvAmount").replaceAll(",", ""));
                        }
                        String cRemrks = request.getParameter("cRemrks");
                        double nTotMkrtValue = 0.0;
                        if (request.getParameter("nTotMkrtValue") != null && request.getParameter("nTotMkrtValue").length() > 0) {
                            nTotMkrtValue = Double.parseDouble(request.getParameter("nTotMkrtValue").replaceAll(",", ""));
                        }
                        double nAgreedInt = 0.0;
                        if (request.getParameter("nAgreedInt") != null && request.getParameter("nAgreedInt").length() > 0) {
                            nAgreedInt = Double.parseDouble(request.getParameter("nAgreedInt").replaceAll(",", ""));

                        }
                        short nPwnPeriodTypeID = 0;
                        if (request.getParameter("nPwnPeriodTypeID") != null && request.getParameter("nPwnPeriodTypeID").length() > 0) {
                            nPwnPeriodTypeID = Short.parseShort(request.getParameter("nPwnPeriodTypeID"));

                        }

                        int nPwnPeriod = 0;
                        if (!request.getParameter("nPwnPeriod").equals("NaN") && request.getParameter("nPwnPeriod") != null & request.getParameter("nPwnPeriod").length() > 0) {

                            nPwnPeriod = Integer.parseInt(request.getParameter("nPwnPeriod"));
                        }

                        String dMaturityDate = request.getParameter("dMaturityDate");

                        int nPwnDescriptionID = 1;

                        double nBalAmount = 0.0;
                        if (request.getParameter("nBalAmount") != null && request.getParameter("nBalAmount").length() > 0) {
                            nBalAmount = Double.parseDouble(request.getParameter("nBalAmount"));
                        }

                        String dLastPaymentDate = request.getParameter("dLastPaymentDate");

                        BnkPwnPawnMaster pm = new BnkPwnPawnMaster();
                        pm.setNPwnMasterID(0L);
                        double actualInt = 0.0;
                        if (nActualInt != null && nActualInt.length() > 0) {
                            actualInt = Double.parseDouble(nActualInt);
                        }
                        pm.setNActualInt(BigDecimal.valueOf(actualInt));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        Date loggedDate = null;
                        if (request.getParameter("currentDate") != null) {
                            String date1 = request.getParameter("currentDate");
                            loggedDate = dateFormat.parse(date1);
                        }

                        pm.setDPwnDate(loggedDate);

                        pm.setNPwnTypeID(Integer.parseInt(BnkPwnPawnTypesID));
                        ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");

                        int v_nBankBranchID = bankBranch.getNAppSectionID();

                        pm.setNBankBranchID(v_nBankBranchID);
                        String v_cPawnTicketNo = "0";
                        pm.setCPwnTicketNo(v_cPawnTicketNo);
                        String v_cSerialNo = "1";
                        pm.setCSerialNo(v_cSerialNo);
                        int v_nLedgerBookNo = 1;
                        pm.setNLedgerBookNo((short) v_nLedgerBookNo);
                        pm.setCFullName(cFullName);
                        int v_nIDType = 1;
                        pm.setNIDType(v_nIDType);
                        String v_cIDNo = cNICNo;
                        pm.setCIDNo(v_cIDNo);
                        Date v_dIssueDate = null;
                        if (dNICIssuedDate != null && dNICIssuedDate.length() > 0) {
                            v_dIssueDate = dateFormat.parse(dNICIssuedDate);
                        }

                        pm.setDIssueDate(v_dIssueDate);

                        pm.setDEditDate(v_dIssueDate);
                        pm.setCPAddLine1(cPAddLine1);
                        pm.setCPAddLine2(cPAddLine2);
                        pm.setCPAddLine3(cPAddLine3);
                        pm.setCPAddLine4(cPAddLine4);
                        pm.setCPTelNo1(cPTelNo1);
                        pm.setCPTelNo2(cBTelNo1);
                        pm.setBOldPawn(PWN);
                        pm.setCReceiptNo(cReceiptNo);
                        pm.setNPwnDescriptionID(nPwnDescriptionID);
                        pm.setNPwnPeriodTypeID(nPwnPeriodTypeID);
                        pm.setNPwnPeriod(nPwnPeriod);
                        Date v_dMaturityDate = null;

                        if (dMaturityDate != null && dMaturityDate.length() > 0) {

                            v_dMaturityDate = dateFormat.parse(dMaturityDate);
                        }
                        pm.setDMaturityDate(v_dMaturityDate);

                        pm.setNTotWgtArt(BigDecimal.valueOf(nTotWgtArt));
                        pm.setNTotWgtGold(BigDecimal.valueOf(nTotWgtGold));
                        pm.setNTotMkrtValue(BigDecimal.valueOf(nTotMkrtValue));
                        pm.setNEffectiveInt(BigDecimal.valueOf(nAgreedInt));
                        pm.setNOneGramAssessedValue(BigDecimal.valueOf(nOneGramAssessedValue));
                        pm.setNTotAssessedValue(BigDecimal.valueOf(nTotWgtGold * nOneGramAssessedValue));
                        pm.setNPwnAdvancedIssued(BigDecimal.valueOf(nTotAdvAmount));
                        pm.setCRemrks(cRemrks);
                        pm.setNPwnBalanceAmount(BigDecimal.valueOf(nBalAmount));

                        Date lastPayDate = null;
                        if (dLastPaymentDate != null && dLastPaymentDate.length() > 0) {
                            lastPayDate = dateFormat.parse(dLastPaymentDate);
                        }
                        pm.setDLastIntPayDate(lastPayDate);

                        GenUser genUser = (GenUser) request.getSession().getAttribute("user");
                        pm.setCInputBy(genUser.getCUserName());
                        pm.setNPwnIntCatID(1);
                        pm.setNInsuredAmount(BigDecimal.ZERO);
                        pm.setCPictureFileName(cPictureFileName);
//	String v_cPurpose 
//	String v_cValuer 
//	String v_cAuthOfficer 
//	String v_cInputBy                     
                        int pkOfMaster = bnkPwnPawnMasterDao.saveBnkPwnPawnMasterSP(pm);

                        List<CrDrTable> cdts = (List<CrDrTable>) request.getSession().getAttribute("tlist");
                        List<BnkPwnPawnMasterArticles> articleses = new ArrayList<>();
                        BnkPwnPawnMasterArticles articles;
                        if (cdts != null) {
                            for (CrDrTable c : cdts) {
                                articles = new BnkPwnPawnMasterArticles();
                                articles.setNPwnMasterID(pkOfMaster);
                                articles.setCPwnArticlName(c.getRow1());
                                articles.setCCaratType(c.getRow2());

                                if (c.getRow3() != null && c.getRow3().length() > 0) {
                                    articles.setNQty(Integer.parseInt(c.getRow3()));
                                } else {
                                    articles.setNQty(1);
                                }
                                articles.setCRemarks(c.getRow4());
                                articles.setNPwnRefArticlID(c.getId());
                                articles.setNPwnCaratValID(c.getId2());
                                articleses.add(articles);
                            }
                        }

                        bnkPwnPawnMasterArticlesDao.saveBnkPwnPawnMasterArticles(articleses, pm);
                        request.getSession().removeAttribute("tlist");
                        request.getSession().removeAttribute("iddetail");
                        if (pkOfMaster != 0) {
                            redirectorCount = 2;
                        }
                    }
                }
            }
            if (redirectorCount == 2) {
                response.sendRedirect("pawning/pawning_master.jsp?mg=saved");
                
            } else if (redirectorCount == 0) {
                response.sendRedirect("pawning/pawning_master.jsp");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void storeData(HttpServletRequest request) {
        try {
            String cNICNo = request.getParameter("cNICNo");
            String dNICIssuedDate = request.getParameter("dNICIssuedDate");
            String cFullName = request.getParameter("cFullName");
            String cPAddLine1 = request.getParameter("cPAddLine1");
            String cPAddLine2 = request.getParameter("cPAddLine2");
            String cPAddLine3 = request.getParameter("cPAddLine3");
            String cPAddLine4 = request.getParameter("cPAddLine4");
            String cPTelNo1 = request.getParameter("cPTelNo1");
            String cBTelNo1 = request.getParameter("cBTelNo1");
            String select = request.getParameter("isSelecet");
            String bnkPwnPawnTypesID = request.getParameter("bnkPwnPawnTypesID");

            boolean isSelected = false;
            if (select.equals("true")) {
                isSelected = true;
            } else {
                isSelected = false;
            }

            double nTotWgtArt = 0.0;

            if (request.getParameter("nTotWgtArt") != null && request.getParameter("nTotWgtArt").length() > 0) {
                nTotWgtArt = Double.parseDouble(request.getParameter("nTotWgtArt"));
            }

            double nTotWgtGold = 0.0;
            if (request.getParameter("nTotWgtGold") != null && request.getParameter("nTotWgtGold").length() > 0) {
                nTotWgtGold = Double.parseDouble(request.getParameter("nTotWgtGold"));
            }

            double nOneGramAssessedValue = 0.0;
            if (request.getParameter("nOneGramAssessedValue") != null && request.getParameter("nOneGramAssessedValue").length() > 0) {
                nOneGramAssessedValue = Double.parseDouble(request.getParameter("nOneGramAssessedValue"));
            }

            double nTotMkrtValue = 0.0;
            if (request.getParameter("nTotMkrtValue") != null && request.getParameter("nTotMkrtValue").length() > 0) {
                nTotMkrtValue = Double.parseDouble(request.getParameter("nTotMkrtValue"));
            }

            double nTotAdvAmount = 0.0;
            if (request.getParameter("nTotAdvAmount") != null && request.getParameter("nTotAdvAmount").length() > 0) {
                nTotAdvAmount = Double.parseDouble(request.getParameter("nTotAdvAmount"));
            }

            double nBalAmount = 0.0;
            if (request.getParameter("nBalAmount") != null && request.getParameter("nBalAmount").length() > 0) {
                nBalAmount = Double.parseDouble(request.getParameter("nBalAmount"));
            }

            double nAgreedInt = 0.0;
            if (request.getParameter("nAgreedInt") != null && request.getParameter("nAgreedInt").length() > 0) {
                nAgreedInt = Double.parseDouble(request.getParameter("nAgreedInt"));

            }

            short nPwnPeriodTypeID = 0;
            if (request.getParameter("nPwnPeriodTypeID") != null && request.getParameter("nPwnPeriodTypeID").length() > 0) {
                nPwnPeriodTypeID = Short.parseShort(request.getParameter("nPwnPeriodTypeID"));

            }

            int nPwnPeriod = 0;
            if (!request.getParameter("nPwnPeriod").equals("NaN") && request.getParameter("nPwnPeriod") != null & request.getParameter("nPwnPeriod").length() > 0) {
                nPwnPeriod = Integer.parseInt(request.getParameter("nPwnPeriod"));

            }

            String nActualInt = request.getParameter("nActualInt");
            String dMaturityDate = request.getParameter("dMaturityDate");
            String cReceiptNo = request.getParameter("cReceiptNo");
            int nPwnDescriptionID = 1;

            String dLastPaymentDate = request.getParameter("dLastPaymentDate");
            String cRemrks = request.getParameter("cRemrks");

            BnkPwnPawnMaster pm = new BnkPwnPawnMaster();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            pm.setCReceiptNo(cReceiptNo);
            pm.setNPwnDescriptionID(nPwnDescriptionID);
            pm.setNPwnPeriodTypeID(nPwnPeriodTypeID);
            pm.setNPwnPeriod(nPwnPeriod);

            pm.setNTotWgtArt(BigDecimal.valueOf(nTotWgtArt));
            pm.setNTotWgtGold(BigDecimal.valueOf(nTotWgtGold));
            pm.setNTotMkrtValue(BigDecimal.valueOf(nTotMkrtValue));
            pm.setNEffectiveInt(BigDecimal.valueOf(nAgreedInt));
            pm.setNOneGramAssessedValue(BigDecimal.valueOf(nOneGramAssessedValue));
            pm.setNTotAssessedValue(BigDecimal.valueOf(nTotWgtGold * nOneGramAssessedValue));
            pm.setNPwnAdvancedIssued(BigDecimal.valueOf(nTotAdvAmount));

            pm.setNActualInt(new BigDecimal(nActualInt));
            pm.setNPwnBalanceAmount(BigDecimal.valueOf(nBalAmount));

            pm.setCRemrks(cRemrks);

            GenUser genUser = (GenUser) request.getSession().getAttribute("user");
            pm.setCInputBy(genUser.getCUserName());
            pm.setNPwnIntCatID(1);
            pm.setNInsuredAmount(BigDecimal.ZERO);

            pm.setCIDNo(cNICNo);
            pm.setBOldPawn(isSelected);

            if (bnkPwnPawnTypesID != null && bnkPwnPawnTypesID.length() > 0) {
                pm.setNPwnTypeID(Integer.parseInt(bnkPwnPawnTypesID));
            }

            Date lastPayDate = null;
            if (dLastPaymentDate != null && dLastPaymentDate.length() > 0) {
                lastPayDate = dateFormat.parse(dLastPaymentDate);
            }
            pm.setDLastIntPayDate(lastPayDate);

            Date v_dMaturityDate = null;

            if (dMaturityDate != null && dMaturityDate.length() > 0) {

                v_dMaturityDate = dateFormat.parse(dMaturityDate);
            }
            pm.setDMaturityDate(v_dMaturityDate);

            Date v_dIssueDate = null;
            if (dNICIssuedDate != null && dNICIssuedDate.length() > 0) {
                v_dIssueDate = dateFormat.parse(dNICIssuedDate);
            }

            pm.setDIssueDate(v_dIssueDate);
            pm.setCFullName(cFullName);
            pm.setCPAddLine1(cPAddLine1);
            pm.setCPAddLine2(cPAddLine2);
            pm.setCPAddLine3(cPAddLine3);
            pm.setCPAddLine4(cPAddLine4);
            pm.setCPTelNo1(cPTelNo1);
            pm.setCPTelNo2(cBTelNo1);

            request.getSession().setAttribute("iddetail", pm);

        } catch (ParseException ex) {
            Logger.getLogger(PawningMasterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
