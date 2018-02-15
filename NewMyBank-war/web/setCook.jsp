<%-- 
    Document   : setCook
    Created on : Mar 1, 2015, 7:11:55 PM
    Author     : mmh
--%>

<%@page import="com.nbs.model.ActSectionsSub"%>
<%@page import="java.util.List"%>
<%@page import="com.nbs.model.BnkRefBankBranch"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System | Set Branch</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background: url(./img/teller/login_background.jpg)">
        <form action="index.jsp" onsubmit="setCook(this);
                return false;" method="post">
            <center >
                <br><br><br><br><br>
                <br><br><br><br><br>
                <br><br>
                <table>
                    <tr>
                        <td><label style="color: white;font-size: 16px;">Select Your Branch</label></td>
                        <td>:</td>
                        <td>
                            <%
                                List<ActSectionsSub> list = (List<ActSectionsSub>) request.getSession().getAttribute("branches");

                            %>
                            <select id="branch" name="branch">
                                <option value="0"><label class="control-label">-Select Branch-</label></option>
                                <%     for (ActSectionsSub cl : list) {
                                %>
                                <option value="<%=cl.getNSubSectionID()%>"><label class="control-label"><%=cl.getCSubSectionNameUni()%></label></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr style="height: 10px;"></tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td align="right"><input type="submit" value="Go To System"></td>
                    </tr>
                </table>
            </center>
        </form>

    </body>
    <script type="text/javascript">
        function setCook(cform) {
            var id = cform["branch"].value;
            var bool = new Boolean();
            bool = true;
            if (id === "0") {
                alert("Select the Branch");
                bool = false;
            } else {
                bool = true;
            }
            if (bool) {
                document.forms[cform].submit();
            }
        }
    </script>
</html>
