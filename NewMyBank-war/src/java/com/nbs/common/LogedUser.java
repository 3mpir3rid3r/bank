/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.common;

/**
 *
 * @author kalana
 */
public class LogedUser {

    private static int userId;
    private static String userName;
    private static String userType;
    private static String tpNumber;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int aUserId) {
        userId = aUserId;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String aUserName) {
        userName = aUserName;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String aUserType) {
        userType = aUserType;
    }

    public static String getTpNumber() {
        return tpNumber;
    }

    public static void setTpNumber(String aTpNumber) {
        tpNumber = aTpNumber;
    }

    public LogedUser(int userId, String userName, String userType, String tpNumber) {
        LogedUser.userId = userId;
        LogedUser.userName = userName;
        LogedUser.userType = userType;
        LogedUser.tpNumber = tpNumber;
    }

    public LogedUser() {
    }

}
