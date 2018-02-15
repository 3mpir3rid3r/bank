/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import com.nbs.common.CrDrTable;
import com.nbs.dao.BnkPwnPawnMasterArticlesDaoLocal;
import com.nbs.dao.BnkPwnPawnMasterDaoLocal;
import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkPwnPawnMasterArticles;
import com.nbs.model.BnkPwnPawnTypes;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class GetPwningMoreDetailServlet extends HttpServlet {
    
    @EJB
    private BnkPwnPawnMasterArticlesDaoLocal bnkPwnPawnMasterArticlesDao;
    @EJB
    private BnkPwnPawnMasterDaoLocal bnkPwnPawnMasterDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String storeNumber = request.getParameter("storeRowNumber");
            List<BnkPwnPawnMaster> pwnDataUsingName = (List<BnkPwnPawnMaster>) request.getSession().getAttribute("alredyPawn");
            BnkPwnPawnMaster bppm = pwnDataUsingName.get(Integer.parseInt(storeNumber) - 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = "";
            if (bppm.getDIssueDate() != null) {
                date = sdf.format(bppm.getDIssueDate());
            }

            //get pawn type
            short periodId = bppm.getNPwnPeriodTypeID();
            String pwnType = "";
            List<BnkPwnPawnTypes> bnkPwnPawnTypes = bnkPwnPawnMasterDao.getBnkPwnPawnTypes();
            for (BnkPwnPawnTypes bnkPwnPawnTypes1 : bnkPwnPawnTypes) {
                if (periodId == bnkPwnPawnTypes1.getNPawnTypeID()) {
                    pwnType = bnkPwnPawnTypes1.getCPawnType();
                }
            }
            
            String matDate = "";
            if (bppm.getDMaturityDate() != null) {
                matDate = sdf.format(bppm.getDMaturityDate());
            }
            
            String payDate = "";
            if (bppm.getDLastIntPayDate() != null) {
                payDate = sdf.format(bppm.getDLastIntPayDate());
            }
            
            String outData = "  <div class=\"box-body\" style=\"background-color: #D2E4E8\">\n"
                    + "                                                            <div class=\"row\">\n"
                    + "                                                                <!--<div class=\"col-md-9\">-->\n"
                    + "                                                                <div class=\"form-group\">\n"
                    + "                                                                    <label  id=\"lbl\" class=\"col-sm-2 input-sm text-right\"  >ජා.හැ.අංකය :</label>\n"
                    + "\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input  disabled type=\"text\" class=\"form-control input-sm convertSinhalaIskolaPotha\" id=\"cFullName\" name=\"cFullName\"  value='" + bppm.getCIDNo() + "'/>\n"
                    + "                                                                    </div>\n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">නිකුත්කළ දිනය :</label>\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input disabled type=\"date\" class=\"form-control input-sm convertSinhalaIskolaPotha\" name=\"dNICIssuedDate\" id=\"dNICIssuedDate\"  value='" + date + "'/>\n"
                    + "                                                                    </div>\n"
                    + "                                                                </div><br>\n"
                    + "                                                                <div class=\"form-group\">\n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">සම්පූර්ණ නම :</label>                                                                                                                           \n"
                    + "                                                                    <div class=\"col-md-10\">\n"
                    + "                                                                        <input disabled type=\"text\" class=\"form-control input-sm convertSinhalaIskolaPotha\" id=\"cFullName\" name=\"cFullName\" value='" + bppm.getCFullName() + "' />\n"
                    + "                                                                    </div>\n"
                    + "                                                                </div><br>  \n"
                    + "                                                                <div class=\"form-group\">\n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">ලිපිනය 1 :</label>\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha\" id=\"cPAddLine1\" name=\"cPAddLine1\" value='" + bppm.getCPAddLine1() + "' />\n"
                    + "                                                                    </div> \n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">ලිපිනය 2 :</label>\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha\" id=\"cPAddLine2\" name=\"cPAddLine2\"  value='" + bppm.getCPAddLine2() + "'/>\n"
                    + "                                                                    </div> \n"
                    + "                                                                </div> <br> \n"
                    + "                                                                <div class=\"form-group\">\n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">ලිපිනය 3 :</label>\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha\" id=\"cPAddLine3\" name=\"cPAddLine3\"  value='" + bppm.getCPAddLine3() + "'/>\n"
                    + "                                                                    </div> \n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">ලිපිනය 4 :</label>\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha\" id=\"cPAddLine4\" name=\"cPAddLine4\"  value='" + bppm.getCPAddLine4() + "'/>\n"
                    + "                                                                    </div> \n"
                    + "                                                                </div> <br> \n"
                    + "                                                                <div class=\"form-group\">\n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">දුරකතන අංකය 1 :</label>\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-6 convertSinhalaIskolaPotha \" id=\"cPTelNo1\"  value='" + bppm.getCPTelNo1() + "'/>\n"
                    + "                                                                    </div> \n"
                    + "                                                                    <label class=\"col-sm-2 input-sm text-right\">දුරකතන අංකය 2 :</label>\n"
                    + "                                                                    <div class=\"col-md-4\">\n"
                    + "                                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-6 convertSinhalaIskolaPotha\" id=\"cBTelNo1\" value='" + bppm.getCPTelNo2() + "'  />\n"
                    + "                                                                    </div> \n"
                    + "                                                                </div> \n"
                    + "                                                            </div>\n"
                    + "                                                        </div>   ";
            
            String outData1 = "            \n"
                    + "                                    <div class=\"box box-info \" style=\"background-color: #D2E4E8\">\n"
                    + "                                        <div class=\"box-body\" id=\"setSizeDiv\">\n"
                    + "                                            <div class=\"row\">\n"
                    + "\n"
                    + "                                                <div id=\"hiddenDataDiv1\" class=\"form-group\">\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">භාණ්ඩ බර :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled  type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right\" value='" + bppm.getNTotWgtArt() + "'  name=\"nTotWgtArt\"  id=\"nTotWgtArt\"  />\n"
                    + "                                                    </div> \n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">ශුද්ධ රන් බර :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled  type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right\"  value='" + bppm.getNTotWgtGold() + "' name=\"nTotWgtGold\" id=\"nTotWgtGold\" />\n"
                    + "                                                    </div> \n"
                    + "                                                </div><div id=\"hiddenBrDiv1\"> <br></div>\n"
                    + "                                                <div id=\"hiddenDataDiv2\" class=\"form-group\">\n"
                    + "\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">1g 1ක වටිනාකම :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right \"  value='" + bppm.getNOneGramAssessedValue() + "'  name=\"nOneGramAssessedValue\" id=\"nOneGramAssessedValue\"  />\n"
                    + "                                                    </div> \n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">වෙළදපල වටිනාකම :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right \" value='" + bppm.getNTotMkrtValue() + "'  name=\"nTotMkrtValue\" id=\"nTotMkrtValue\" maxlength=\"10\" />\n"
                    + "                                                    </div>\n"
                    + "                                                </div><div id=\"hiddenBrDiv2\"> <br></div>\n"
                    + "                                                <div id=\"hiddenDataDiv3\" class=\"form-group\">\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">තක්සේරු මුදල :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right \"  value='" + bppm.getNTotAssessedValue() + "' name=\"nTotAssessedValue\"  id=\"nTotAssessedValue\"/>\n"
                    + "                                                    </div> \n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">නිකුත්කල ණය මුදල :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right\" value='" + bppm.getNPwnAdvancedIssued() + "'  name=\"nTotAdvAmount\" id=\"nTotAdvAmount\" maxlength=\"10\" />\n"
                    + "                                                    </div> \n"
                    + "                                                </div> <div id=\"hiddenBrDiv3\"> <br></div>\n"
                    + "                                                <div id=\"hiddenDataDiv4\" class=\"form-group\">\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">පොළි අනුපාතය :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right\"   value='" + bppm.getNActualInt() + "' name=\"nActualInt\" id=\"nActualInt\"/>\n"
                    + "                                                    </div> \n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">එකග වූ පොළි අනුපාතය :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right\"  value='" + bppm.getNEffectiveInt() + "' name=\"nAgreedInt\" id=\"nAgreedInt\"/>                                                        \n"
                    + "                                                    </div> \n"
                    + "                                                </div> <div id=\"hiddenBrDiv4\"> <br></div>\n"
                    + "                                                <div id=\"hiddenDataDiv5\" class=\"form-group\">\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\" style=\"font-size: 13px\">අපසු ගෙවීම :</label>\n"
                    + "                                                    <div class=\"col-md-2 bg-pad\">\n"
                    + "                                                    <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right\"  value='" + pwnType + "' name=\"nAgreedInt\" id=\"nAgreedInt\"/>                                                        \n"
                    + "                                                    </div>\n"
                    + "                                                    <div class=\"col-md-1 bg-pad\">\n"
                    + "                                                        <input disabled type=\"number\" class=\"form-control input-sm\" id=\"nPwnPeriod\"  value='" + bppm.getNPwnPeriod() + "' name=\"nPwnPeriod\"  min=\"1\">                                                                                 \n"
                    + "                                                    </div>\n"
                    + "                                                    <label class=\"col-sm-1 input-sm text-left\" id=\"nLPTypeIDLabel\">දින 364 ක්</label>\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">කල් පිරෙන දිනය :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"date\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha\"  value='" + matDate + "' name=\"dMaturityDate\" id=\"dMaturityDate\" />\n"
                    + "                                                    </div>\n"
                    + "                                                </div><br>\n"
                    + "                                                <div  id=\"hiddenDataDiv6\" class=\"form-group\" >\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">කුයිතාන්සි අංකය :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha\" value='" + bppm.getCReceiptNo() + "' name=\"cReceiptNo\" id=\"cReceiptNo\"/>\n"
                    + "                                                    </div> \n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">කාරණාව :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <select class=\"form-control input-sm \" id=\"nPwnDescriptionID\" name=\"nPwnDescriptionID\" disabled=\"\">\n"
                    + "                                                            <option value=\"1\">-N/A-</option>                                                            \n"
                    + "                                                        </select>  \n"
                    + "                                                    </div> \n"
                    + "                                                </div><br>\n"
                    + "                                                <div id=\"hiddenDataDiv7\" class=\"form-group\">                                                    \n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">අවසාන ගණුදෙනු දිනය :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"date\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha\"  value='" + payDate + "' name=\"dLastPaymentDate\" id=\"dLastPaymentDate\"/>\n"
                    + "                                                    </div> \n"
                    + "\n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">දැනට ශේෂය :</label>\n"
                    + "                                                    <div class=\"col-md-4\">\n"
                    + "                                                        <input disabled type=\"text\" class=\"form-control input-sm col-lg-4 convertSinhalaIskolaPotha text-right\"  value='" + bppm.getNPwnBalanceAmount() + "' name=\"nBalAmount\" id=\"nBalAmount\"/>\n"
                    + "                                                    </div> \n"
                    + "                                                </div><div id=\"hiddenBrDiv7\"> <br></div>\n"
                    + "                                                <div id=\"hiddenDataDiv8\" class=\"form-group\"> \n"
                    + "                                                    <label class=\"col-sm-2 input-sm text-right\">වෙනත් විස්තර :</label>\n"
                    + "                                                    <div class=\"col-md-10\">\n"
                    + "                                                        <!--<input type=\"text\" class=\"form-control input-sm col-lg-3\"  placeholder=\"වෙනත් විස්තර\" name=\"cRemrks \" id=\"cRemrks \"/>-->\n"
                    + "                                                        <textarea disabled placeholder=\"වෙනත් විස්තර\" name=\"cRemrks \" id=\"cRemrks\" class=\"form-control input-sm col-lg-3 convertSinhalaIskolaPotha\">" + bppm.getCRemrks() + " </textarea>\n"
                    + "                                                    </div> \n"
                    + "                                                </div>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                               ";
            
            String outdataTable = "<table class='table table-bordered table-hover' style=\"background-color: #ffff\">"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td width='10px' ></td>\n"
                    + "<th>උකස් භාණ්ඩ</th>\n"
                    + "<th >කැරට් අගය</th>\n"
                    + "<th width='10px'>ප්‍රමානය</th> "
                    + "<th >වෙනත්</th></tr> ";
            
            if (bppm != null) {
                List<BnkPwnPawnMasterArticles> bnkPwnPawnMasterArticlesList = bnkPwnPawnMasterArticlesDao.getBnkPwnPawnMasterArticlesList(bppm.getNPwnMasterID());
                for (BnkPwnPawnMasterArticles bnkPwnPawnMasterArticles : bnkPwnPawnMasterArticlesList) {
                    
                    String cPwnArticlName = bnkPwnPawnMasterArticles.getCPwnArticlName();
                    String cCaratType = bnkPwnPawnMasterArticles.getCCaratType();
                    int nQty = bnkPwnPawnMasterArticles.getNQty();
                    String cRemarks = bnkPwnPawnMasterArticles.getCRemarks();
                    
                    outdataTable += "<tr ><td></td><td style='font-size: 12px;'>" + cPwnArticlName + " </td>"
                            + "<td style='font-size: 12px;'>" + cCaratType + " </td>"
                            + "<td style='font-size: 12px;' width=100px>" + nQty + " </td>"
                            + "<td style='font-size: 12px;' width=100px>" + cRemarks + " </td>"
                            + "</tr>";
                }
            }
            
            out.print(outdataTable + "</tbody></table><br>");
            out.print(outData);
            out.print(outData1);
            
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
