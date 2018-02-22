/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import ResponceEntity.CustomerSaveEntity;
import com.nbs.dao.BnkCustomerMasterDaoLocalrLocal;
import com.nbs.model.ActSectionsSub;
import com.nbs.model.BnkCustomerMaster;
import com.nbs.model.GenUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class NewCustomerServlet extends HttpServlet {

    @EJB
    private BnkCustomerMasterDaoLocalrLocal BnkCustomerMasterDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            String branch = "0";
//            Cookie cookies[] = request.getCookies();
//            if (cookies != null) {
//                for (int i = 0; i < cookies.length; i++) {
//                    Cookie cookie1 = cookies[i];
//                    if (cookie1.getName().equals("branch")) {
////                        out.println("bgcolor = " + cookie1.getValue());
//                        branch = cookie1.getValue();
//                    }
//                }
//            }
//            if (branch.equals("0")) {
//                request.getRequestDispatcher("signOut").forward(request, response);
//            }
//
//            String cifno = "0", custcat = "0", title = "0", usedname = "", initials = "", lastname = "",
//                    fullname = "", gender = "", birthday = "";
//
//            //handuna ganeeme thorathuru
//            String nic = "null", issueDate = "null", civil_status = "0", nationality = "0", religon = "0", starting_date = "null", mother_sername = "";
//
//            String per_address1 = "", per_address2 = "", per_address3 = "", per_address4 = "", phone_no1 = "";
//
//            String other_address1 = "", other_address2 = "", other_address3 = "", other_address4 = "", phone_no2 = "";
//
//            String member_num = "", group_name = "0", position = "0", state = "0", member_date = "null", member_value = "", coop_name = "";
//
//            String email1 = "", email2 = "";
//
//            custcat = request.getParameter("custcat") ;
//            title = request.getParameter("title") ;
//            usedname = request.getParameter("usedname") ;
//            initials = request.getParameter("initials") ;
//            lastname = request.getParameter("lastname") ;
//            fullname = request.getParameter("fullname") ;
//            gender = request.getParameter("male") ;
//            birthday = request.getParameter("birthday") ;
//
//            nic = request.getParameter("nic") ;
//            issueDate = request.getParameter("issueddate") ;
//            civil_status = request.getParameter("civil_status") ;
//            nationality = request.getParameter("nationality") ;
//            religon = request.getParameter("religon") ;
//            starting_date = request.getParameter("starting_date") ;
//            mother_sername = request.getParameter("mother_sername") ;
//
//            //per address
//            per_address1 = request.getParameter("per_address1") ;
//            per_address2 = request.getParameter("per_address2") ;
//            per_address3 = request.getParameter("per_address3") ;
//            per_address4 = request.getParameter("per_address4") ;
//            phone_no1 = request.getParameter("phone_no1") ;
//            email1 = request.getParameter("email1") ;
//
//            //other address
//            other_address1 = request.getParameter("other_address1") ;
//            other_address2 = request.getParameter("other_address2") ;
//            other_address3 = request.getParameter("other_address3") ;
//            other_address4 = request.getParameter("other_address4") ;
//            email2 = request.getParameter("email2") ;
//            phone_no2 = request.getParameter("phone_no2") ;
//
//            //saamajika thorathuru
//            member_num = request.getParameter("member_no") ;
//            group_name = request.getParameter("group_name") ;
//            position = request.getParameter("position") ;
//            state = request.getParameter("state") ;
//            member_date = request.getParameter("member_date") ;
//            member_value = request.getParameter("member_value") ;
//            coop_name = request.getParameter("coop_name") ;
//
//            CustomerSaveEntity cse = new CustomerSaveEntity();
//            System.out.println(coop_name + "cccccccccccc");
//            if ("0".equals(custcat)) {
//                cse.setCustcat("0");
//                request.setAttribute("error", cse);
//                RequestDispatcher rd = request.getRequestDispatcher("teller/customer_details.jsp");
//                rd.forward(request, response);
//            } else if ("0".equals(title)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title);
//            } else if ("".equals(usedname)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname=" + usedname);
//            } else if ("".equals(initials)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname=" + usedname + "&initials=" + initials);
//            } else if ("".equals(lastname)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname);
//            } else if ("".equals(fullname)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname);
//            } else if (!("0".equals(gender) || "1".equals(gender))) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender);
//            } else if ("".equals(birthday)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday);
//            } else if ("null".equals(nic)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic);
//            } else if ("null".equals(issueDate)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate);
//            } else if ("0".equals(civil_status)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status);
//            } else if ("0".equals(nationality)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality);
//            } else if ("0".equals(religon)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon);
//            } else if ("null".equals(starting_date)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date);
//            } else if ("".equals(mother_sername)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername);
//            } else if ("".equals(per_address1)) {
//                if ("".equals(per_address2)) {
//                    if ("".equals(per_address3)) {
//                        response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                                + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                                + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                                + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4);
//                    }
//                }
//            } else if ("".equals(phone_no1)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&phone_no1=" + phone_no1);
////            } else if ("".equals(other_address1)) {
////                if ("".equals(other_address2)) {
////                    if ("".equals(other_address3)) {
////                        response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
////                                + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
////                                + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
////                                + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4+"&other_address1="+other_address1+"&other_address2="+other_address2+"&other_address3="+other_address3+"&other_address4="+other_address4);
////                    }
////                }
//            } else if ("".equals(phone_no2)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4 + "&phone_no2=" + phone_no2);
//            } else if ("".equals(member_num)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4
//                        + "&phone_no2=" + phone_no2 + "&member_num=" + member_num);
//            } else if ("0".equals(group_name)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4
//                        + "&phone_no2=" + phone_no2 + "&member_num=" + member_num + "&group_name=" + group_name);
//            } else if ("0".equals(position)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4
//                        + "&phone_no2=" + phone_no2 + "&member_num=" + member_num + "&group_name=" + group_name + "&position=" + position);
//            } else if ("0".equals(state)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4
//                        + "&phone_no2=" + phone_no2 + "&member_num=" + member_num + "&group_name=" + group_name + "&position=" + position + "&state=" + state);
//            } else if ("null".equals(member_date)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4
//                        + "&phone_no2=" + phone_no2 + "&member_num=" + member_num + "&group_name=" + group_name + "&position=" + position + "&state=" + state + "&member_date=" + member_date);
//            } else if ("".equals(member_value)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4
//                        + "&phone_no2=" + phone_no2 + "&member_num=" + member_num + "&group_name=" + group_name + "&position=" + position + "&state=" + state + "&member_date=" + member_date + "&member_value=" + member_value);
//            } else if ("0".equals(coop_name)) {
//                response.sendRedirect("teller/customer_details.jsp?mg=error&custcat=" + custcat + "&title=" + title + "&usedname="
//                        + usedname + "&initials=" + initials + "&lastname=" + lastname + "&fullname=" + fullname + "&gender=" + gender + "&birthday=" + birthday + "&nic=" + nic + "&issueddate="
//                        + issueDate + "&civil_status=" + civil_status + "&nationality=" + nationality + "&religon=" + religon + "&starting_date=" + starting_date + "&mother_sername=" + mother_sername + "&per_address1="
//                        + per_address1 + "&per_address2=" + per_address2 + "&per_address3=" + per_address3 + "&per_address4=" + per_address4 + "&other_address1=" + other_address1 + "&other_address2=" + other_address2 + "&other_address3=" + other_address3 + "&other_address4=" + other_address4
//                        + "&phone_no2=" + phone_no2 + "&member_num=" + member_num + "&group_name=" + group_name + "&position=" + position + "&state=" + state + "&member_date=" + member_date + "&member_value=" + member_value + "&coop_name=" + coop_name);
//            } else {
//
//                String primaryKey =  request.getParameter("pk") ;
//                System.out.println("pk"+primaryKey);
//                int custId = Integer.parseInt(primaryKey);
//                if (custId == 0) {
//                    saveNewUser = new BnkCustomerMasterDao(cifno, custcat, title, usedname, initials, lastname, fullname, gender, birthday, nic, issueDate, civil_status, nationality, religon, starting_date, mother_sername, per_address1, per_address2, per_address3, per_address4, phone_no1, other_address1, other_address2, other_address3,
//                            other_address4, phone_no2, member_num, group_name, position, state, member_date, member_value, coop_name, email1, email2, branch, primaryKey);
//                    response.sendRedirect("teller/");
//                } else {
//                    saveNewUser = new BnkCustomerMasterDao(cifno, custcat, title, usedname, initials, lastname, fullname, gender, birthday, nic, issueDate, civil_status, nationality, religon, starting_date, mother_sername, per_address1, per_address2, per_address3, per_address4, phone_no1, other_address1, other_address2, other_address3,
//                            other_address4, phone_no2, member_num, group_name, position, state, member_date, member_value, coop_name, email1, email2, branch, primaryKey);
//                    response.sendRedirect("teller/view_customers.jsp");
//                }
////                BnkCustomerMaster bcm = new BnkCustomerMaster();
////                bcm.setCCIFNo(cifno);
////                bcm.setNCustomerCategoryID(Short.parseShort(custcat));
////                bcm.setNTitleID(Short.parseShort(title));
////                bcm.setCUseName(usedname);
////                bcm.setCInitials(initials);
////                bcm.setCLastName(lastname);
////                bcm.setCFullName(fullname);
////                if ("1".equals(gender)) {
////                    bcm.setBFeMale(true);
////                }else if ("0".equals(gender)) {
////                     bcm.setBFeMale(false);
////                }
//            }
//
//            // out.write(initials);
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
        BnkCustomerMaster bcmError = new BnkCustomerMaster();
        try (PrintWriter out = response.getWriter()) {
            String branch = "0";
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie1 = cookies[i];
                    if (cookie1.getName().equals("branch")) {
//                        out.println("bgcolor = " + cookie1.getValue());
                        branch = cookie1.getValue();
                    }
                }
            }
            if (branch.equals("0")) {
                request.getRequestDispatcher("signOut").forward(request, response);
            }

            String v_cCIFNo = "0", v_nCustomerCategoryID = "0", v_nTitleID = "0", v_cUseName = "", v_cInitials = "", v_cLastName = "",
                    v_cFullName = "", v_bFeMale = "", v_dDateOfBirth = "";

            //handuna ganeeme thorathuru
            String v_cNICNo = "null", v_dNICIssuedDate = "null", v_nCivilStatusID = "0", v_nNationalityID = "0", v_nReligionID = "0", v_dJoineDate = "null", v_cMotherMadName = "";

            String v_cPAddLine1 = "", v_cPAddLine2 = "", v_cPAddLine3 = "", v_cPAddLine4 = "", v_cPTelNo1 = "";

            String v_cBAddLine1 = "", v_cBAddLine2 = "", v_cBAddLine3 = "", v_cBAddLine4 = "", v_cBTelNo1 = "";

            String v_cMemberShipNo = "", v_nMemAreaGroupID = "0", v_nMemPositionID = "0", v_nMemStatusID = "0", v_dMemberShipDate = "null", v_nMemberShipFee = "", v_nMemAreaID = "";

            String v_cPEmail = "", v_cBEmail = "", v_cFullNameAma = "", v_cPictureFileName = "";

            v_nCustomerCategoryID = request.getParameter("nCustomerCategoryID");
            v_nTitleID = request.getParameter("nTitleID");
            v_cUseName = request.getParameter("cUseName");
            v_cInitials = request.getParameter("cInitials");
            v_cLastName = request.getParameter("cLastName");
            v_cFullName = request.getParameter("cFullName");
            v_cFullNameAma = request.getParameter("cFullNameSin");
            v_bFeMale = request.getParameter("bFeMale");
            v_dDateOfBirth = request.getParameter("dDateOfBirth");
            v_cPictureFileName = request.getParameter("userImage");
            v_cNICNo = request.getParameter("cNICNo");
            v_dNICIssuedDate = request.getParameter("issueddate");
            v_nCivilStatusID = request.getParameter("nCivilStatusID");
            v_nNationalityID = request.getParameter("nNationalityID");
            v_nReligionID = request.getParameter("nReligionID");
            v_dJoineDate = request.getParameter("dJoineDate");
            v_cMotherMadName = request.getParameter("cMotherMadName");

            //per address
            v_cPAddLine1 = request.getParameter("cPAddLine1");
            v_cPAddLine2 = request.getParameter("cPAddLine2");
            v_cPAddLine3 = request.getParameter("cPAddLine3");
            v_cPAddLine4 = request.getParameter("cPAddLine4");
            v_cPTelNo1 = request.getParameter("cPTelNo1");
            v_cPEmail = request.getParameter("cPEmail");

            //other address
            v_cBAddLine1 = request.getParameter("cBAddLine1");
            v_cBAddLine2 = request.getParameter("cBAddLine2");
            v_cBAddLine3 = request.getParameter("cBAddLine3");
            v_cBAddLine4 = request.getParameter("cBAddLine4");
            v_cBEmail = request.getParameter("cBEmail");
            v_cBTelNo1 = request.getParameter("cBTelNo1");

            //saamajika thorathuru
            v_cMemberShipNo = request.getParameter("cMemberShipNo");
            v_nMemAreaGroupID = request.getParameter("nMemAreaGroupID");
            v_nMemPositionID = request.getParameter("nMemPositionID");
            v_nMemStatusID = request.getParameter("nMemStatusID");
            v_dMemberShipDate = request.getParameter("dMemberShipDate");
            v_nMemberShipFee = request.getParameter("nMemberShipFee");
            v_nMemAreaID = request.getParameter("nMemAreaID");

            CustomerSaveEntity cse = new CustomerSaveEntity();
            if ("0".equals(v_nCustomerCategoryID)) {
                cse.setCustcat("0");
                request.setAttribute("error", cse);
                request.getRequestDispatcher("teller/customer_details.jsp").forward(request, response);
            } else if ("0".equals(v_nTitleID)
                    || "".equals(v_cUseName)
                    || "".equals(v_cInitials)
                    || "".equals(v_cLastName)
                    || "".equals(v_cFullName)
                    || !("0".equals(v_bFeMale) || "1".equals(v_bFeMale))
                    || "".equals(v_dDateOfBirth)
                    || "null".equals(v_cNICNo)
                    || "null".equals(v_dNICIssuedDate)
                    || "0".equals(v_nCivilStatusID)
                    || "0".equals(v_nNationalityID)
                    || "0".equals(v_nReligionID)
                    || "null".equals(v_dJoineDate)
                    || "".equals(v_cMotherMadName)
                    || ("".equals(v_cPAddLine1) && "".equals(v_cPAddLine2))
                    || "".equals(v_cPTelNo1)
                    || "".equals(v_cFullNameAma)) {
                bcmError.setNCustomerCategoryID(Short.valueOf(v_nCustomerCategoryID));
                bcmError.setNCustomerStatusID(Short.valueOf(v_nCustomerCategoryID));
                bcmError.setNTitleID(Short.valueOf(v_nTitleID));
                bcmError.setCCIFNo(v_cCIFNo);
                bcmError.setCCIFNoOld("");
                bcmError.setCInitials(v_cInitials);
                bcmError.setCFullName(v_cFullName);
                bcmError.setCFullNameAma(v_cFullNameAma);

                bcmError.setCLastName(v_cLastName);
                bcmError.setCUseName(v_cUseName);
                if ("1".equals(v_bFeMale)) {
                    bcmError.setBFeMale(true);
                } else if ("0".equals(v_bFeMale)) {
                    bcmError.setBFeMale(false);
                }
                bcmError.setCNICNo(v_cNICNo);
                bcmError.setDNICIssuedDate(format(v_dNICIssuedDate));
                bcmError.setDDateOfBirth(format(v_dDateOfBirth));
                bcmError.setDJoineDate(format(v_dJoineDate));
                bcmError.setCMotherMadName(v_cMotherMadName);
                bcmError.setNNationalityID(Short.valueOf(v_nNationalityID));
                bcmError.setNReligionID(Short.valueOf(v_nReligionID));
                bcmError.setNCivilStatusID(Short.valueOf(v_nCivilStatusID));
                bcmError.setCPAddLine1(v_cPAddLine1);
                bcmError.setCPAddLine2(v_cPAddLine2);
                bcmError.setCPAddLine3(v_cPAddLine3);
                bcmError.setCPAddLine4(v_cPAddLine4);
                bcmError.setCBAddLine1(v_cBAddLine1);
                bcmError.setCBAddLine2(v_cBAddLine2);
                bcmError.setCBAddLine3(v_cBAddLine3);
                bcmError.setCBAddLine4(v_cBAddLine4);
                bcmError.setCPTelNo1(v_cPTelNo1);
                bcmError.setCBTelNo1(v_cBTelNo1);
                bcmError.setCPEmail(v_cPEmail);
                bcmError.setCBEmail(v_cBEmail);
                bcmError.setCMemberShipNo(v_cMemberShipNo);
                bcmError.setDMemberShipDate(format(v_dMemberShipDate));
                bcmError.setNMemAreaID(Short.valueOf(v_nMemAreaID));
                bcmError.setNMemAreaGroupID(Integer.valueOf(v_nMemAreaGroupID));
                bcmError.setNMemStatusID(Short.valueOf(v_nMemStatusID));
                bcmError.setNMemPositionID(Short.valueOf(v_nMemPositionID));
                bcmError.setNMemberShipFee(BigDecimal.valueOf(Double.parseDouble(v_nMemberShipFee)));
                request.getSession().setAttribute("aCustomer", bcmError);
                response.sendRedirect("teller/customer_details.jsp?mg=error");
            } else {

                GenUser genUser = (GenUser) request.getSession().getAttribute("user");

                String primaryKey = request.getParameter("pk");
                Long custId = Long.parseLong(primaryKey);

                //repalce null date values
                String dateVareable[] = {v_dNICIssuedDate, v_dDateOfBirth, v_dJoineDate, v_dMemberShipDate};
                for (int i = 0; i < dateVareable.length; i++) {
                    if (dateVareable[i] == null || dateVareable[i].trim().equals("")) {
                        dateVareable[i] = "0001-01-01";
                    }
                }

                if (custId == 0) {
                    BnkCustomerMaster bcm = new BnkCustomerMaster(custId);
                    ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
                    bcm.setNSubSectionID(bankBranch.getNSubSectionID());
                    bcm.setNCustomerCategoryID(Short.valueOf(v_nCustomerCategoryID));
                    bcm.setNCustomerStatusID(Short.valueOf(v_nCustomerCategoryID));
                    bcm.setNTitleID(Short.valueOf(v_nTitleID));
                    bcm.setCCIFNo(v_cCIFNo);
                    bcm.setCCIFNoOld("");
                    bcm.setCInitials(v_cInitials);
                    bcm.setCFullName(v_cFullName);
                    bcm.setCFullNameAma(v_cFullNameAma);
                    bcm.setCLastName(v_cLastName);
                    bcm.setCUseName(v_cUseName);
                    if ("1".equals(v_bFeMale)) {
                        bcm.setBFeMale(true);
                    } else if ("0".equals(v_bFeMale)) {
                        bcm.setBFeMale(false);
                    }
                    bcm.setCNICNo(v_cNICNo);
                    bcm.setDNICIssuedDate(format(dateVareable[0]));
                    bcm.setDDateOfBirth(format(dateVareable[1]));
                    bcm.setDJoineDate(format(dateVareable[2]));
                    bcm.setCMotherMadName(v_cMotherMadName);
                    bcm.setNNationalityID(Short.valueOf(v_nNationalityID));
                    bcm.setNReligionID(Short.valueOf(v_nReligionID));
                    bcm.setNCivilStatusID(Short.valueOf(v_nCivilStatusID));
                    bcm.setCPAddLine1(v_cPAddLine1);
                    bcm.setCPAddLine2(v_cPAddLine2);
                    bcm.setCPAddLine3(v_cPAddLine3);
                    bcm.setCPAddLine4(v_cPAddLine4);
                    bcm.setCBAddLine1(v_cBAddLine1);
                    bcm.setCBAddLine2(v_cBAddLine2);
                    bcm.setCBAddLine3(v_cBAddLine3);
                    bcm.setCBAddLine4(v_cBAddLine4);
                    bcm.setCPTelNo1(v_cPTelNo1);
                    bcm.setCBTelNo1(v_cBTelNo1);
                    bcm.setCPEmail(v_cPEmail);
                    bcm.setCBEmail(v_cBEmail);
                    bcm.setCMemberShipNo(v_cMemberShipNo);
                    bcm.setDMemberShipDate(format(dateVareable[3]));
                    bcm.setNMemAreaID(Short.valueOf(v_nMemAreaID));
                    bcm.setNMemAreaGroupID(Integer.valueOf(v_nMemAreaGroupID));
                    bcm.setNMemStatusID(Short.valueOf(v_nMemStatusID));
                    bcm.setNMemPositionID(Short.valueOf(v_nMemPositionID));
                    bcm.setNMemberShipFee(BigDecimal.valueOf(Double.parseDouble(v_nMemberShipFee.replaceAll(",", ""))));
                    bcm.setCAddBy(genUser.getCUserName());
                    bcm.setCPictureFileName(v_cPictureFileName);
//	bcm.setcSignatureFileName		VARCHAR(50), 
//	bcm.setcSigPath2			VARCHAR(50), 
//	bcm.setcSigPath3			VARCHAR(50),  
//	bcm.setcUserName			VARCHAR(15), 

                    BnkCustomerMasterDao.saveNewCustomerMaster(bcm);
                    response.sendRedirect("teller/customer_details.jsp?mg=saved");
                } else {

                    BnkCustomerMaster bcm = new BnkCustomerMaster(custId);
                    ActSectionsSub bankBranch = (ActSectionsSub) request.getSession().getAttribute("branch");
                    bcm.setNSubSectionID(bankBranch.getNSubSectionID());
                    bcm.setNCustomerCategoryID(Short.valueOf(v_nCustomerCategoryID));
                    bcm.setNCustomerStatusID(Short.valueOf(v_nCustomerCategoryID));
                    bcm.setNTitleID(Short.valueOf(v_nTitleID));
                    bcm.setCCIFNo(v_cCIFNo);
                    bcm.setCCIFNoOld("");
                    bcm.setCInitials(v_cInitials);
                    bcm.setCFullName(v_cFullName);
                    bcm.setCFullNameAma(v_cFullNameAma);
                    bcm.setCLastName(v_cLastName);
                    bcm.setCUseName(v_cUseName);
                    if ("1".equals(v_bFeMale)) {
                        bcm.setBFeMale(true);
                    } else if ("0".equals(v_bFeMale)) {
                        bcm.setBFeMale(false);
                    }
                    bcm.setCNICNo(v_cNICNo);
                    bcm.setDNICIssuedDate(format(dateVareable[0]));
                    bcm.setDDateOfBirth(format(dateVareable[1]));
                    bcm.setDJoineDate(format(dateVareable[2]));
                    bcm.setCMotherMadName(v_cMotherMadName);
                    bcm.setNNationalityID(Short.valueOf(v_nNationalityID));
                    bcm.setNReligionID(Short.valueOf(v_nReligionID));
                    bcm.setNCivilStatusID(Short.valueOf(v_nCivilStatusID));
                    bcm.setCPAddLine1(v_cPAddLine1);
                    bcm.setCPAddLine2(v_cPAddLine2);
                    bcm.setCPAddLine3(v_cPAddLine3);
                    bcm.setCPAddLine4(v_cPAddLine4);
                    bcm.setCBAddLine1(v_cBAddLine1);
                    bcm.setCBAddLine2(v_cBAddLine2);
                    bcm.setCBAddLine3(v_cBAddLine3);
                    bcm.setCBAddLine4(v_cBAddLine4);
                    bcm.setCPTelNo1(v_cPTelNo1);
                    bcm.setCBTelNo1(v_cBTelNo1);
                    bcm.setCPEmail(v_cPEmail);
                    bcm.setCBEmail(v_cBEmail);
                    bcm.setCMemberShipNo(v_cMemberShipNo);
                    bcm.setDMemberShipDate(format(dateVareable[3]));
                    bcm.setNMemAreaID(Short.valueOf(v_nMemAreaID));
                    bcm.setNMemAreaGroupID(Integer.valueOf(v_nMemAreaGroupID));
                    bcm.setNMemStatusID(Short.valueOf(v_nMemStatusID));
                    bcm.setNMemPositionID(Short.valueOf(v_nMemPositionID));
                    bcm.setNMemberShipFee(BigDecimal.valueOf(Double.parseDouble(v_nMemberShipFee)));
                    bcm.setCAddBy(genUser.getCUserName());
                    bcm.setCPictureFileName(v_cPictureFileName);

                    BnkCustomerMasterDao.saveNewCustomerMaster(bcm);
                    response.sendRedirect("teller/customer_details.jsp?mg=updated");

                }
            }

            // out.write(v_cInitials);
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    Date format(String value) throws ParseException {
        return (Date) new Date(new SimpleDateFormat("yyyy-MM-dd").parse(value).getTime());
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
