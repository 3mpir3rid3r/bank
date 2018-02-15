/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import com.nbs.dao.GenUserDaoLocal;
import com.nbs.model.ActSectionsSub;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.GenUser;
import com.nbs.model.GenUserActivities;
import com.nbs.model.GenUserSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class UserLoginServlet extends HttpServlet {

    @EJB
    private GenUserDaoLocal genUserDao;

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
            boolean foundCookie = false;
            Cookie cookie[] = request.getCookies();
            if (cookie != null) {
                for (int i = 0; i < cookie.length; i++) {
                    Cookie cookie1 = cookie[i];
                    if (cookie1.getName().equals("branch")) {
                        foundCookie = true;
                    }
                }
            }

            if (!foundCookie) {
                response.sendRedirect("SetBranchesCookieServlet");
            } else if (request.getParameter("username") == null || request.getParameter("password") == null) {
                response.sendRedirect("index.jsp");
            } else {
                String username = "";
                String password = "";
                String logDate = "";
                if (request.getParameter("username").isEmpty()) {
                    request.setAttribute("login_error", "Your UserName is incorrect");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else if (request.getParameter("password").isEmpty()) {
                    request.setAttribute("login_error", "Your password is incorrect");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else if (request.getParameter("logDate").isEmpty()) {
                    request.setAttribute("login_error", "Please Select the date");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    username = request.getParameter("username");
                    password = request.getParameter("password");
                    logDate = request.getParameter("logDate");
                    
//                    set Log date in to sesssion,
//                    this date access for Pawning jsp page 
                    
                    request.getSession().setAttribute("storeLoggedDate", logDate);
                    GenUserActivities activities = new GenUserActivities();
                    GenUser user = genUserDao.UserLogin(username, password);
                    
                    out.write(user + "");
                    if (user.getNUserID() == null) {
                        request.setAttribute("login_error", "Invalid Username or password");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    } else if (user.getNUserStatusID().getNUserStatusID() == 3) {
                        activities.setNUserID(user);
                        activities.setDDate(new Date());
                        activities.setCDescriptiom(user.getCUserName() + " is try to login to system as " + user.getNUserTypeID().getCUserType() + " but account is Disabled");
                        genUserDao.saveUserActivities(activities);
                        request.setAttribute("login_error", "Your Account is Disabled.Please Contact the admin");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    } else if (user.getNUserStatusID().getNUserStatusID() == 2) {
                        activities.setNUserID(user);
                        activities.setDDate(new Date());
                        activities.setCDescriptiom(user.getCUserName() + " is try to login to system as " + user.getNUserTypeID().getCUserType() + " but account is deactivated");
                        genUserDao.saveUserActivities(activities);
                        request.setAttribute("login_error", "Your Account is deactivated.Please Contact the admin");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    } else if (user.getNUserStatusID().getNUserStatusID() == 1) {
                        request.getSession().setAttribute("user", user);
                        System.out.println(logDate);
                        request.getSession().setAttribute("logDate", logDate);
                        String sid = request.getSession().getId();

                        activities.setNUserID(user);
                        activities.setDDate(new Date());
                        activities.setCDescriptiom(user.getCUserName() + " is loged to the system at that time as a " + user.getNUserTypeID().getCUserType());
                        genUserDao.saveUserActivities(activities);

                        GenUserSession genUserSession = new GenUserSession();
                        genUserSession.setNUserID(user);
                        genUserSession.setNSessionID(sid);
                        genUserSession.setDLogedTime(new Date());
                        genUserDao.saveUserSession(genUserSession);

                        int branchId = 0;
                        Cookie cookies[] = request.getCookies();
                        if (cookies != null) {
                            for (int i = 0; i < cookies.length; i++) {
                                Cookie cookie1 = cookies[i];
                                if (cookie1.getName().equals("branch")) {
//                        out.println("bgcolor = " + cookie1.getValue());
                                    branchId = Integer.parseInt(cookie1.getValue());
                                }
                            }
                        }
//                        BnkRefBankBranch bankBranch = genUserDao.getBranch(branchId);
                        ActSectionsSub bankBranch=genUserDao.getBranch(branchId);
                        
                        request.getSession().setAttribute("branch", bankBranch);
                        request.getSession().removeAttribute("branches");
                        response.sendRedirect("main.jsp");
                    }

                }
            }
        } catch (IOException | ServletException e) {
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
