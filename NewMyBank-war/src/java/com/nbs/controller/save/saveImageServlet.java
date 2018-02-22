/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author mmh
 */
public class saveImageServlet extends HttpServlet {

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
            String filename = new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()) + ".png";
            String result = getServletContext().getRealPath("/images/customer/") + "/" + filename;
            InputStream in = null;
            FileOutputStream fos = null;
            File f = new File(getServletContext().getRealPath("/images/customer/"));
            if (!f.exists()) {
                f.mkdirs();
            }
            try {
                HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper(request);
                InputStream is = wrappedRequest.getInputStream();
                StringWriter writer = new StringWriter();
                IOUtils.copy(is, writer, "UTF-8");
                String imageString = writer.toString();
                imageString = imageString.substring("data:image/png;base64,".length());
                byte[] contentData = imageString.getBytes();
                byte[] decodedData = Base64.getDecoder().decode(contentData);
                fos = new FileOutputStream(result);
                fos.write(decodedData);
                out.write(filename);
            } catch (IOException e) {
                out.write("fail");
                e.printStackTrace();
            } finally {
                if (in != null) {
                    in.close();
                }
                if (fos != null) {
                    fos.close();
                }
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
