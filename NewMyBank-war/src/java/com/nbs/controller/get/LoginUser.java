/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.controller.get;

import com.nbs.model.common.JDBC;
import com.nbs.common.LogedUser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kalana
 */
public class LoginUser {

    private final String userName;
    private final String userPassword;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    public static LogedUser logedUser;
    public static int userId;

    JDBC jdbc = new JDBC();

    public LoginUser(String userName, String userPassword, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.userName = userName;
        this.userPassword = userPassword;
        this.request = request;
        this.response = response;

        boolean bool = false;
        int userId = 0;
        try {
            Statement s = jdbc.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM gen_User where cUserName = '" + userName + "' and cPassword = '" + userPassword + "' ");
            if (rs.next()) {
                bool = true;
                userId = rs.getInt("nUserTypeId");
            }
            if (bool) {
                if(userId==1){
                    System.out.println("/////////////////////////////////////////////////////////main.jsp");
                    response.sendRedirect("main.jsp");
                }else if(userId==2){
                    response.sendRedirect("pawning/index.jsp");
                }
                ResultSet rs1 = s.executeQuery("SELECT cUserType FROM gen_UserType where nUserTypeId = '" + userId + "'");
                //response.sendRedirect("main.jsp");
                LogedUser logedUser = new LogedUser();
                logedUser.setUserName(userName);
                if (rs1.next()) {
                    logedUser.setUserType(rs1.getString(1));
                }
                request.getSession().setAttribute("LogedUser", logedUser);
                //writeToFile(userName);
            } else {
                request.setAttribute("login_error", "Your UserName or password incorrect");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    private void writeToFile(String userName) throws IOException {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date1 = simpleDateFormat.format(date);

        File file = new File("/home/wdf/user_login.text");

        if (!file.exists()) {

            file.createNewFile();
        }
        System.out.println("file ------------ " + file.getPath());

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write("Date = " + date1);
        bw.newLine();
        bw.write("user = " + userName);

        bw.close();
    }

}
