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
import org.apache.commons.io.IOUtils;

/**
 *
 * @author mmh
 */
public class saveImageServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

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
            String result = "/home/mmh/NetBeansProjects/bank/NewMyBank-war/web/images/customer/" + filename;
            InputStream in = null;
            FileOutputStream fos = null;

//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            factory.setRepository(new File("/home/mmh/NetBeansProjects/bankOriginal/NewMyBank-war/web/images/customer/"));
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            upload.setSizeMax(maxFileSize);
//
//            isMultipart = ServletFileUpload.isMultipartContent(request);
//
//            System.out.println("A");
//            if (!isMultipart) {
//
//                List fileItems;
//                try {
//                    fileItems = upload.parseRequest(request);
//                    Iterator i = fileItems.iterator();
//                    System.out.println("A");
//
//                    while (i.hasNext()) {
//                        System.out.println("A");
//                        FileItem fi = (FileItem) i.next();
//                        if (!fi.isFormField()) {
//                            // Get the uploaded file parameters
//                            String fieldName = fi.getFieldName();
//                            String fileName = fi.getName();
//                            String contentType = fi.getContentType();
//                            boolean isInMemory = fi.isInMemory();
//                            long sizeInBytes = fi.getSize();
//
//                            // Write the file
//                            if (fileName.lastIndexOf("\\") >= 0) {
//                                file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
//                            } else {
//                                file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
//                            }
//                            fi.write(file);
//                            out.print("Done");
//                        }
//                        System.out.println("A");
//
//                    }
//                } catch (Exception ex) {
//                    Logger.getLogger(saveNic.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
            System.out.println(result);
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
