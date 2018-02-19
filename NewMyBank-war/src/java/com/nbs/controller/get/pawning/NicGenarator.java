/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get.pawning;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mmh
 */
public class NicGenarator extends HttpServlet {

    private String id;
    private final int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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

            String nicNo = request.getParameter("nicNo");
            id = nicNo;
            int year = getYear();
            String monthAndDate = getMonth();
            String sex = getSex();

            //get Age
            String[] dateMonth = monthAndDate.split("-");
            byte monthNo = Byte.parseByte(dateMonth[0]);
            byte dayNo = Byte.parseByte(dateMonth[1]);

            String age = getAge(year, monthNo, dayNo);
            if (monthAndDate.equals("00-00")) {
                monthAndDate = "<label style=\"color: red\">" + monthAndDate + "</label>";
            }
            out.print("<div class=\"row\">B'Day : " + year + "-" + monthAndDate + "<br>" + "Sex : " + sex + "<br>" + "Age : " + age + "</div>");

        } catch (ParseException ex) {
            Logger.getLogger(NicGenarator.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     *
     * @author ACHCHUTHAN
     * @return
     */
//    http://www.achchuthan.org/
//    these methods are written by  Achchuthan Yogarajah
    public int getYear() {

        if (Integer.parseInt(id.substring(0, 2)) <= 25) {
            return (2000 + Integer.parseInt(id.substring(0, 2)));
        } else {
            return (1900 + Integer.parseInt(id.substring(0, 2)));
        }
    }

    public int setDays() {
        int d = Integer.parseInt(id.substring(2, 5));
        if (d > 500) {
            return (d - 500);
        } else {
            return d;
        }
    }

    public String getMonth() {
        int mo = 0;
        int da = 0;
        int days = setDays();

        for (int i = 0; i < month.length; i++) {
            if (days < month[i]) {
                mo = i + 1;
                da = days;
                break;
            } else {
                days = days - month[i];
            }
        }

        String month = "";
        if (Integer.toString(mo).length() == 1) {
            month = "0" + Integer.toString(mo);
        } else {
            month = Integer.toString(mo);
        }
        String day = "";
        if (Integer.toString(da).length() == 1) {
            day = "0" + Integer.toString(da);
        } else {
            day = Integer.toString(da);
        }
        return month + "-" + day;

    }

    public String getSex() {
        String m = "Male", f = "Female";
        int d = Integer.parseInt(id.substring(2, 5));
        if (d > 500) {
            return f;
        } else {
            return m;
        }
    }

    /**
     *
     * @author ACHCHUTHAN end this other methods
     */
    private String getAge(int year, byte month, byte day) throws ParseException {
        String birthDay = year + "-" + month + "-" + day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDay1 = sdf.parse(birthDay);

        Calendar sDate = Calendar.getInstance();
        Calendar eDate = Calendar.getInstance();

        sDate.setTime(birthDay1);
        eDate.setTime(new Date());

        int difInYears = eDate.get(Calendar.YEAR) - sDate.get(Calendar.YEAR);
        int difInMonths = eDate.get(Calendar.MONTH) - sDate.get(Calendar.MONTH);
        int difInDays = eDate.get(Calendar.DATE) - sDate.get(Calendar.DATE);

        return difInYears + "  Years  " + difInMonths + "  Months  " + difInDays + "  Days  ";
    }

}
