/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;


import com.nbs.dao.member.BnkMemberMasterDaoLocal;
import com.nbs.model.MemMemberShipMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class NewMember extends HttpServlet {

    @EJB
    private BnkMemberMasterDaoLocal BnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String branch = "0";
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie1 = cookies[i];
                    if (cookie1.getName().equals("branch")) {
                        branch = cookie1.getValue();
                    }
                }
            }
            if (branch.equals("0")) {
                request.getRequestDispatcher("signOut").forward(request, response);
            }

            long n_memberNo;
            short nTitleID, nIDTypeID, nCivilStatusID, nReligionID, nMemberPossitionId, nNationalityID, nMemAreaID, nMemPositionID;
            String cUseName, cFullName, cFullNameSin, cInitials, cLastName;
            boolean bFeMale;
            String cNICNo, dDateOfBirth, issueddate, cJob;
            String cPAddLine1, cPAddLine2, cPAddLine3, cPAddLine4, cPTelNo1, cPEmail, cBAddLine1, cBAddLine2, cBAddLine3, cBAddLine4, cBTelNo1, cBEmail = null, coldNum;
            int cNumbers;
            String dMemberShipDate;
            double cMemberFee;

            String id = request.getParameter("nTitleID");

            if (id.length() > 0) {
                nTitleID = Short.parseShort(id);

                cUseName = request.getParameter("cUseName");
                cInitials = request.getParameter("cInitials");
                cLastName = request.getParameter("cLastName");
                cFullName = request.getParameter("cFullName");
                cFullNameSin = request.getParameter("cFullNameSin");
                bFeMale = Boolean.parseBoolean(request.getParameter("bFeMale"));
                dDateOfBirth = request.getParameter("dDateOfBirth");

                cNICNo = request.getParameter("cNICNo");

                issueddate = request.getParameter("issueddate");
                id = "";

                id = request.getParameter("nCivilStatusID");
                if (id.length() > 0) {
                    nCivilStatusID = Short.parseShort(id);
                    id = "";

                    id = request.getParameter("nNationalityID");
                    if (id.length() > 0) {
                        nNationalityID = Short.parseShort(id);
                        id = "";

                        id = request.getParameter("nReligionID");
                        if (id.length() > 0) {
                            nReligionID = Short.parseShort(id);

                            cJob = request.getParameter("cOccupation");

                            cPAddLine1 = request.getParameter("cPAddLine1");
                            cPAddLine2 = request.getParameter("cPAddLine2");
                            cPAddLine3 = request.getParameter("cPAddLine3");
                            cPAddLine4 = request.getParameter("cPAddLine4");
                            cPTelNo1 = request.getParameter("cPTelNo1");
                            cPEmail = request.getParameter("cPEmail");

                            cBAddLine1 = request.getParameter("cBAddLine1");
                            cBAddLine2 = request.getParameter("cBAddLine2");
                            cBAddLine3 = request.getParameter("cBAddLine3");
                            cBAddLine4 = request.getParameter("cBAddLine4");
                            String fMale = request.getParameter("bFeMale");
                          
                            if(fMale.equals("1")){
                                bFeMale = true;
                            }else{
                                bFeMale = false;
                            }
                            cBTelNo1 = request.getParameter("cBTelNo1");

                            coldNum = request.getParameter("coldNum");
                            //kotas ganana
                            cNumbers = Integer.parseInt(request.getParameter("cNumbers"));
                            id = "";
                            id = request.getParameter("memberNo1");
                            if (id != null) {
                                n_memberNo = Long.parseLong(id);

                                id = "";

                                id = request.getParameter("nMemberPossition");
                                if (id.length() > 0) {
                                    nMemPositionID = Short.parseShort(id);

                                    dMemberShipDate = request.getParameter("dMemberShipDate");
                                    cMemberFee = Double.parseDouble(request.getParameter("cMemberFee"));
                                    id = "";

                                    id = request.getParameter("nMemAreaID");
                                    if (id.length() > 0) {
                                        nMemAreaID = Short.parseShort(id);
                                        MemMemberShipMaster master = new MemMemberShipMaster();

                                        master.setBFeMale(bFeMale);
                                        master.setCBAddLine1(cBAddLine1);
                                        master.setCBAddLine2(cBAddLine1);
                                        master.setCBAddLine3(cBAddLine1);
                                        master.setCBAddLine4(cBAddLine1);
                                        master.setCBEmail(cBEmail);
                                        master.setCBTelNo1(cBTelNo1);
                                        master.setCBTelNo2(cBTelNo1);
                                        master.setCFullName(cFullName);
                                        master.setCFullNameAma(cFullNameSin);
                                        master.setCInitials(cInitials);
                                        master.setCLastName(cLastName);
                                        master.setCMemberShipNo(coldNum);
                                        master.setCMotherMadName("");
                                        master.setCNICNo(cNICNo);
                                        master.setCPAddLine1(cPAddLine1);
                                        master.setCPAddLine2(cPAddLine2);
                                        master.setCPAddLine3(cPAddLine3);
                                        master.setCPAddLine4(cPAddLine4);
                                        master.setCPEmail(cPEmail);
                                        master.setCPTelNo1(cPTelNo1);
                                        master.setCPTelNo2(cPTelNo1);
                                        master.setCUseName(cUseName);

                                        master.setDAddDate(new java.util.Date());

                                        master.setDDateOfBirth(Date.valueOf(dDateOfBirth));
                                        master.setDMemberShipDate(Date.valueOf(dMemberShipDate));
                                        master.setDNICIssuedDate(Date.valueOf(issueddate));
                                        master.setNCivilStatusID(nCivilStatusID);
                                        master.setNIDTypeID((short) 1);
                                        master.setNMemAreaID(nMemAreaID);
                                        master.setNMemPositionID(nMemPositionID);
                                        master.setNMemStatusID(nMemPositionID);
                                        master.setNMemberID(n_memberNo);
                                        master.setNMemberShipFee(BigDecimal.valueOf((cMemberFee)));
                                        master.setNNationalityID(nNationalityID);
                                        master.setNReligionID(nReligionID);
                                        master.setNTitleID(nTitleID);
                                        master.setCOcupation(cJob);
                                        master.setNNoOfShares(cNumbers);

                                       boolean isAdded =  BnkCustomerMasterDao.saveNewMember(master);
                                       if(isAdded){
                                        response.sendRedirect("member/member_details.jsp?mg=saved");
                                       }else{
                                           response.sendRedirect("member/member_details.jsp?mg=error");
                                       }
                                    } else {
                                        response.sendRedirect("member/member_details.jsp?mg=error");
                                    }
                                } else {
                                    response.sendRedirect("member/member_details.jsp?mg=error");
                                }
                            } else {
                                response.sendRedirect("member/member_details.jsp?mg=error");
                            }
                        } else {
                            response.sendRedirect("member/member_details.jsp?mg=error");
                        }
                    } else {
                        response.sendRedirect("member/member_details.jsp?mg=error");
                    }
                } else {
                    response.sendRedirect("member/member_details.jsp?mg=error");
                }
            } else {
                response.sendRedirect("member/member_details.jsp?mg=error");
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
