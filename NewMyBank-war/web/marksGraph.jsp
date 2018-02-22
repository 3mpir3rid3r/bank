<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page contentType="application/pdf;charset=UTF-8" %>

<%@ page trimDirectiveWhitespaces="true"%>

<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>

<%
    Connection conn = null;
    int rep_id=0;
    String rep_name = null;
    Map params = null;
//            params.put("MPCSName", GeneralUserLogin.data.getBranchName());
//            params.put("dFromDate", jdtFrom.getDate());
//            params.put("dToDate", jdtTo.getDate());
    
    try {
        
        rep_id=Integer.parseInt(request.getParameter("rep_id").toString());
        
        
        
        if(rep_id==1){
            rep_name="Cash_Deposit_Slip.jrxml";
            params = new HashMap();
            params.put("DepTrnID", Integer.parseInt(request.getParameter("nDepTrnID").toString()));
        }else if(rep_id==2){
            rep_name="Cash_Withdrawal_Slip.jrxml";
            params = new HashMap();
            params.put("DepTrnID", Integer.parseInt(request.getParameter("nDepTrnID").toString()));
        }else if(rep_id==3){
            rep_name="Pawning_Ticket.jrxml";
            params = new HashMap();
            params.put("nPwnMasterID", Integer.parseInt(request.getParameter("nPwnMasterID").toString()));
            params.put("cCashValueString",request.getParameter("cCashValueString").toString());
        }
        
        
        Class.forName("com.mysql.jdbc.Driver");//nbsERP_Dankotuwa
        conn = DriverManager.getConnection("jdbc:mysql://192.168.1.250:3306/nbsERP_Bnk_Wariyapola?user=root&password=123");
//        conn = DriverManager.getConnection("jdbc:mysql://192.168.1.249:3306/nbsERP_Dankotuwa?user=root&password=123");

        //Loading Jasper Report File from Local file system
        
        String jrxmlFile = session.getServletContext().getRealPath("reports/"+rep_name) ;
        InputStream input = new FileInputStream(new File(jrxmlFile));

        //Generating the report
        JasperReport jasperReport = JasperCompileManager.compileReport(input);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

        //Exporting the report as a PDF
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (JRException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
%>
