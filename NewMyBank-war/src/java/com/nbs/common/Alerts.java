/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.common;

/**
 *
 * @author KalanaSys
 */
public class Alerts {

    public static String warningAlert(String title, String msg, String link) {
        String alert = "<div class=\"alert alert-dismissable alert-danger\" id=\"alert\">\n"
                + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" onclick=\"hide()\">×</button>\n"
                + "  <strong>" + title + "!</strong> " + msg + ".\n"
                + "</div>";
        return alert;
    }

    public static String dangerAlert(String title, String msg) {
        return "";
    }

    public static String successAlert(String title, String msg) {
        String alert = "<div class=\"alert alert-success fade in\" id=\"alert\">\n"
                + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" onclick=\"hide()\">×</button>\n"
                + "                                <strong>" + title + "!</strong> " + msg + ".\n"
                + "                            </div>";
        return alert;
    }

    public static String weldoneAlert(String title, String msg) {
        String alert = "<div class=\"alert alert-info fade in\" id=\"alert\">\n"
                + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" onclick=\"hide()\">×</button>\n"
                + "                                <strong>" + title + "!</strong> " + msg + ".\n"
                + "                            </div>";
        return alert;
    }

    public static String alertBox_warning(String title, String msg, String btn_ok, String btn_cansel, String link1, String link2) {
        String alert = "<div class=\"alert alert-danger fade in\" id=\"alert\">\n"
                + "                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n"
                + "                    <h4>You got a " + title + "!</h4>\n"
                + "                    <p>" + msg + ".</p>\n"
                + "                    <p>\n"
                + "                        <a class=\"btn-u btn-u-red\" href=\"" + link1 + "\">" + btn_ok + "</a> \n"
                + "                        <a class=\"btn-u btn-u-sea\" href=\"" + link2 + "\">" + btn_cansel + "</a>\n"
                + "                    </p>\n"
                + "                </div>";
        return alert;
    }

    public static String alertBox_info(String title, String msg) {
        String alert = "<div class=\"alert alert-success fade in margin-bottom-40\" id=\"alert\">\n"
                + "                    <h4>Well done!</h4>\n"
                + "                    At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.\n"
                + "                </div>";
        return alert;
    }
}
