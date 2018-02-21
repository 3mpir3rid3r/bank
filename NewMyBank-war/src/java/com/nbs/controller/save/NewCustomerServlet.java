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
import java.io.File;
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
import org.apache.commons.io.FileUtils;

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
//            custcat = request.getParameter("custcat").replaceAll(",", "") ;
//            title = request.getParameter("title").replaceAll(",", "") ;
//            usedname = request.getParameter("usedname").replaceAll(",", "") ;
//            initials = request.getParameter("initials").replaceAll(",", "") ;
//            lastname = request.getParameter("lastname").replaceAll(",", "") ;
//            fullname = request.getParameter("fullname").replaceAll(",", "") ;
//            gender = request.getParameter("male").replaceAll(",", "") ;
//            birthday = request.getParameter("birthday").replaceAll(",", "") ;
//
//            nic = request.getParameter("nic").replaceAll(",", "") ;
//            issueDate = request.getParameter("issueddate").replaceAll(",", "") ;
//            civil_status = request.getParameter("civil_status").replaceAll(",", "") ;
//            nationality = request.getParameter("nationality").replaceAll(",", "") ;
//            religon = request.getParameter("religon").replaceAll(",", "") ;
//            starting_date = request.getParameter("starting_date").replaceAll(",", "") ;
//            mother_sername = request.getParameter("mother_sername").replaceAll(",", "") ;
//
//            //per address
//            per_address1 = request.getParameter("per_address1").replaceAll(",", "") ;
//            per_address2 = request.getParameter("per_address2").replaceAll(",", "") ;
//            per_address3 = request.getParameter("per_address3").replaceAll(",", "") ;
//            per_address4 = request.getParameter("per_address4").replaceAll(",", "") ;
//            phone_no1 = request.getParameter("phone_no1").replaceAll(",", "") ;
//            email1 = request.getParameter("email1").replaceAll(",", "") ;
//
//            //other address
//            other_address1 = request.getParameter("other_address1").replaceAll(",", "") ;
//            other_address2 = request.getParameter("other_address2").replaceAll(",", "") ;
//            other_address3 = request.getParameter("other_address3").replaceAll(",", "") ;
//            other_address4 = request.getParameter("other_address4").replaceAll(",", "") ;
//            email2 = request.getParameter("email2").replaceAll(",", "") ;
//            phone_no2 = request.getParameter("phone_no2").replaceAll(",", "") ;
//
//            //saamajika thorathuru
//            member_num = request.getParameter("member_no").replaceAll(",", "") ;
//            group_name = request.getParameter("group_name").replaceAll(",", "") ;
//            position = request.getParameter("position").replaceAll(",", "") ;
//            state = request.getParameter("state").replaceAll(",", "") ;
//            member_date = request.getParameter("member_date").replaceAll(",", "") ;
//            member_value = request.getParameter("member_value").replaceAll(",", "") ;
//            coop_name = request.getParameter("coop_name").replaceAll(",", "") ;
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
//                String primaryKey =  request.getParameter("pk").replaceAll(",", "") ;
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

            v_nCustomerCategoryID = request.getParameter("nCustomerCategoryID").replaceAll(",", "");
            v_nTitleID = request.getParameter("nTitleID").replaceAll(",", "");
            v_cUseName = request.getParameter("cUseName").replaceAll(",", "");
            v_cInitials = request.getParameter("cInitials").replaceAll(",", "");
            v_cLastName = request.getParameter("cLastName").replaceAll(",", "");
            v_cFullName = request.getParameter("cFullName").replaceAll(",", "");
            v_cFullNameAma = request.getParameter("cFullNameSin").replaceAll(",", "");
            v_bFeMale = request.getParameter("bFeMale").replaceAll(",", "");
            v_dDateOfBirth = request.getParameter("dDateOfBirth").replaceAll(",", "");
            v_cPictureFileName = request.getParameter("userImage").replaceAll(",", "");
            v_cNICNo = request.getParameter("cNICNo").replaceAll(",", "");
            v_dNICIssuedDate = request.getParameter("issueddate").replaceAll(",", "");
            v_nCivilStatusID = request.getParameter("nCivilStatusID").replaceAll(",", "");
            v_nNationalityID = request.getParameter("nNationalityID").replaceAll(",", "");
            v_nReligionID = request.getParameter("nReligionID").replaceAll(",", "");
            v_dJoineDate = request.getParameter("dJoineDate").replaceAll(",", "");
            v_cMotherMadName = request.getParameter("cMotherMadName").replaceAll(",", "");

            //per address
            v_cPAddLine1 = request.getParameter("cPAddLine1").replaceAll(",", "");
            v_cPAddLine2 = request.getParameter("cPAddLine2").replaceAll(",", "");
            v_cPAddLine3 = request.getParameter("cPAddLine3").replaceAll(",", "");
            v_cPAddLine4 = request.getParameter("cPAddLine4").replaceAll(",", "");
            v_cPTelNo1 = request.getParameter("cPTelNo1").replaceAll(",", "");
            v_cPEmail = request.getParameter("cPEmail").replaceAll(",", "");

            //other address
            v_cBAddLine1 = request.getParameter("cBAddLine1").replaceAll(",", "");
            v_cBAddLine2 = request.getParameter("cBAddLine2").replaceAll(",", "");
            v_cBAddLine3 = request.getParameter("cBAddLine3").replaceAll(",", "");
            v_cBAddLine4 = request.getParameter("cBAddLine4").replaceAll(",", "");
            v_cBEmail = request.getParameter("cBEmail").replaceAll(",", "");
            v_cBTelNo1 = request.getParameter("cBTelNo1").replaceAll(",", "");

            //saamajika thorathuru
            v_cMemberShipNo = request.getParameter("cMemberShipNo").replaceAll(",", "");
            v_nMemAreaGroupID = request.getParameter("nMemAreaGroupID").replaceAll(",", "");
            v_nMemPositionID = request.getParameter("nMemPositionID").replaceAll(",", "");
            v_nMemStatusID = request.getParameter("nMemStatusID").replaceAll(",", "");
            v_dMemberShipDate = request.getParameter("dMemberShipDate").replaceAll(",", "");
            v_nMemberShipFee = request.getParameter("nMemberShipFee").replaceAll(",", "");
            v_nMemAreaID = request.getParameter("nMemAreaID").replaceAll(",", "");

            CustomerSaveEntity cse = new CustomerSaveEntity();
            if ("0".equals(v_nCustomerCategoryID)) {
                cse.setCustcat("0");
                request.setAttribute("error", cse);
                request.getRequestDispatcher("teller/customer_details.jsp").forward(request, response);
            } else if ("0".equals(v_nTitleID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_cUseName)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName=" + v_cUseName + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_cInitials)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName=" + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_cLastName)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_cFullName)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if (!("0".equals(v_bFeMale) || "1".equals(v_bFeMale))) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_dDateOfBirth)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("null".equals(v_cNICNo)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("null".equals(v_dNICIssuedDate)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("0".equals(v_nCivilStatusID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("0".equals(v_nNationalityID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("0".equals(v_nReligionID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("null".equals(v_dJoineDate)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_cMotherMadName)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_cPAddLine1)) {
                if ("".equals(v_cPAddLine2)) {
                    if ("".equals(v_cPAddLine3)) {
                        response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                                + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                                + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                                + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cPictureFileName=" + v_cPictureFileName);
                    }
                }
            } else if ("".equals(v_cPTelNo1)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cPTelNo1=" + v_cPTelNo1 + "&v_cPictureFileName=" + v_cPictureFileName);
//            } else if ("".equals(v_cBAddLine1)) {
//                if ("".equals(v_cBAddLine2)) {
//                    if ("".equals(v_cBAddLine3)) {
//                        response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
//                                + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
//                                + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
//                                + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4+"&v_cBAddLine1="+v_cBAddLine1+"&v_cBAddLine2="+v_cBAddLine2+"&v_cBAddLine3="+v_cBAddLine3+"&v_cBAddLine4="+v_cBAddLine4 + "&v_cPictureFileName=" + v_cPictureFileName);
//                    }
//                }
            } else if ("".equals(v_cBTelNo1)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4 + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_cMemberShipNo)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4
                        + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cMemberShipNo=" + v_cMemberShipNo + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("0".equals(v_nMemAreaGroupID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4
                        + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cMemberShipNo=" + v_cMemberShipNo + "&v_nMemAreaGroupID=" + v_nMemAreaGroupID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("0".equals(v_nMemPositionID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4
                        + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cMemberShipNo=" + v_cMemberShipNo + "&v_nMemAreaGroupID=" + v_nMemAreaGroupID + "&v_nMemPositionID=" + v_nMemPositionID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("0".equals(v_nMemStatusID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4
                        + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cMemberShipNo=" + v_cMemberShipNo + "&v_nMemAreaGroupID=" + v_nMemAreaGroupID + "&v_nMemPositionID=" + v_nMemPositionID + "&v_nMemStatusID=" + v_nMemStatusID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("null".equals(v_dMemberShipDate)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4
                        + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cMemberShipNo=" + v_cMemberShipNo + "&v_nMemAreaGroupID=" + v_nMemAreaGroupID + "&v_nMemPositionID=" + v_nMemPositionID + "&v_nMemStatusID=" + v_nMemStatusID + "&v_dMemberShipDate=" + v_dMemberShipDate + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("".equals(v_nMemberShipFee)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4
                        + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cMemberShipNo=" + v_cMemberShipNo + "&v_nMemAreaGroupID=" + v_nMemAreaGroupID + "&v_nMemPositionID=" + v_nMemPositionID + "&v_nMemStatusID=" + v_nMemStatusID + "&v_dMemberShipDate=" + v_dMemberShipDate + "&v_nMemberShipFee=" + v_nMemberShipFee + "&v_cPictureFileName=" + v_cPictureFileName);
            } else if ("0".equals(v_nMemAreaID)) {
                response.sendRedirect("teller/customer_details.jsp?mg=error&v_nCustomerCategoryID=" + v_nCustomerCategoryID + "&v_nTitleID=" + v_nTitleID + "&v_cUseName="
                        + v_cUseName + "&v_cInitials=" + v_cInitials + "&v_cLastName=" + v_cLastName + "&v_cFullName=" + v_cFullName + "&v_bFeMale=" + v_bFeMale + "&v_dDateOfBirth=" + v_dDateOfBirth + "&v_cNICNo=" + v_cNICNo + "&issueddate="
                        + v_dNICIssuedDate + "&v_nCivilStatusID=" + v_nCivilStatusID + "&v_nNationalityID=" + v_nNationalityID + "&v_nReligionID=" + v_nReligionID + "&v_dJoineDate=" + v_dJoineDate + "&v_cMotherMadName=" + v_cMotherMadName + "&v_cPAddLine1="
                        + v_cPAddLine1 + "&v_cPAddLine2=" + v_cPAddLine2 + "&v_cPAddLine3=" + v_cPAddLine3 + "&v_cPAddLine4=" + v_cPAddLine4 + "&v_cBAddLine1=" + v_cBAddLine1 + "&v_cBAddLine2=" + v_cBAddLine2 + "&v_cBAddLine3=" + v_cBAddLine3 + "&v_cBAddLine4=" + v_cBAddLine4
                        + "&v_cBTelNo1=" + v_cBTelNo1 + "&v_cMemberShipNo=" + v_cMemberShipNo + "&v_nMemAreaGroupID=" + v_nMemAreaGroupID + "&v_nMemPositionID=" + v_nMemPositionID + "&v_nMemStatusID=" + v_nMemStatusID + "&v_dMemberShipDate=" + v_dMemberShipDate + "&v_nMemberShipFee=" + v_nMemberShipFee + "&v_nMemAreaID=" + v_nMemAreaID + "&v_cPictureFileName=" + v_cPictureFileName);
            } else {

                GenUser genUser = (GenUser) request.getSession().getAttribute("user");

                String primaryKey = request.getParameter("pk").replaceAll(",", "");
                System.out.println("pk" + v_dJoineDate);
                Long custId = Long.parseLong(primaryKey);
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
                    bcm.setDNICIssuedDate(Date.valueOf(v_dNICIssuedDate));
                    bcm.setDDateOfBirth(Date.valueOf(v_dDateOfBirth));
                    bcm.setDJoineDate(Date.valueOf(v_dJoineDate));
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
                    bcm.setDMemberShipDate(Date.valueOf(v_dMemberShipDate));
                    bcm.setNMemAreaID(Short.valueOf(v_nMemAreaID));
                    bcm.setNMemAreaGroupID(Integer.valueOf(v_nMemAreaGroupID));
                    bcm.setNMemStatusID(Short.valueOf(v_nMemStatusID));
                    bcm.setNMemPositionID(Short.valueOf(v_nMemPositionID));
                    bcm.setNMemberShipFee(BigDecimal.valueOf(Double.parseDouble(v_nMemberShipFee)));
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
                    bcm.setDNICIssuedDate(Date.valueOf(v_dNICIssuedDate));
                    bcm.setDDateOfBirth(Date.valueOf(v_dDateOfBirth));
                    bcm.setDJoineDate(Date.valueOf(v_dJoineDate));
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
                    bcm.setDMemberShipDate(Date.valueOf(v_dMemberShipDate));
                    bcm.setNMemAreaID(Short.valueOf(v_nMemAreaID));
                    bcm.setNMemAreaGroupID(Integer.valueOf(v_nMemAreaGroupID));
                    bcm.setNMemStatusID(Short.valueOf(v_nMemStatusID));
                    bcm.setNMemPositionID(Short.valueOf(v_nMemPositionID));
                    bcm.setNMemberShipFee(BigDecimal.valueOf(Double.parseDouble(v_nMemberShipFee)));
                    bcm.setCAddBy(genUser.getCUserName());
                    bcm.setCPictureFileName(v_cPictureFileName);

                    BnkCustomerMasterDao.saveNewCustomerMaster(bcm);
                    System.out.println(v_cNICNo);
                    response.sendRedirect("teller/customer_details.jsp?mg=updated");

                }
            }

            // out.write(v_cInitials);
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
