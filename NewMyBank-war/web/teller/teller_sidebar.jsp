<%-- 
    Document   : teller_sidebar
    Created on : Apr 3, 2015, 8:44:23 AM
    Author     : mmh
--%>

<%@page import="com.nbs.common.Security"%>
<%@page import="com.nbs.model.GenUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String userNameRigthSideBar = "User";
    //String userType = "Developer";
    if (request.getSession().getAttribute("user") != null) {
        GenUser genUser = (GenUser) request.getSession().getAttribute("user");
        userNameRigthSideBar = genUser.getCUserName();
    }

%>
<section class="sidebar">
    <!-- Sidebar user panel -->
    <div class="user-panel">
        <div class="pull-left image">
            <img src="../images/icon-user-default.png" class="img-circle" alt="User Image" >
        </div>
        <div class="pull-left info">
            <p>Hello, <%=userNameRigthSideBar%></p>

            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
    </div>
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu">
        <!--./Money Deposit-->
        <input type="hidden" value="" name="nDepMFID" id="nDepMFID"/>
        <li style="background-color: #f9f9f9" id="moneyDepType1">
            <a href="../GetterMoneyTransactionServelet?moneyDepType=1" onclick="passMoneySaving(this)">
                <i class="fa fa-plus-circle small"></i><span  style="color: green;font-size: 13px;">මුදල් තැම්පත්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="moneyDepType2">
            <a href="../GetterMoneyTransactionServelet?moneyDepType=2" onclick="passMoneySaving(this)">
                <i class="fa fa-minus-circle small"></i><span style="color: green;font-size: 13px;">ආපසු ගැනීම</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="moneyDepType3">
            <a href="../teller/money_translate.jsp?moneyDepType=3">
                <i class="fa fa-exchange small"></i><span style="color: green;font-size: 13px;">මුදල් හුවමාරු</span>
            </a>
        </li>
        <!--./Money Deposit-->

        <!--./Loan Transaction-->
        <input type="hidden" value="" name="nLonMFID" id="nLonMFID"/>
        <li style="background-color: #f9f9f9" id="moneyLonType1">
            <a href="../GetterLoanTransactionServlet?moneyLonType=1" onclick="passMoneyLoan(this)">
                <i class="fa fa-plus-square small"></i><span style="color: green;font-size: 13px;">ණය අයකරගැනීම</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="moneyLonType2">
            <a href="../GetterLoanTransactionServlet?moneyLonType=2" onclick="passMoneyLoan(this)">
                <i class="fa fa-minus-square small"></i><span style="color: green;font-size: 13px;">ණය නිකුත් කිරීම</span>
            </a>
        </li>
        <!--./Loan Transaction-->

        <!--./Other Payment-->
        <li style="background-color: #f9f9f9" id="creditorDebtor114">
            <a href="../teller/creditor_debtor.jsp?index=<%=Security.encrypt("114")%>">
                <i class="fa fa-plus-square-o small"></i><span style="color: green;font-size: 13px;">වෙනත් ලැබීම්</span>
            </a>
        </li>
        <li style="background-color: #f9f9f9" id="creditorDebtor115">
            <a href="../teller/creditor_debtor.jsp?index=<%=Security.encrypt("115")%>">
                <i class="fa fa-minus-square-o small"></i><span style="color: green;font-size: 13px;">වෙනත් ගෙවීම්</span>
            </a>
        </li>
        <!--./Other Payment-->

        <!--./Pawning-->
        <li style="background-color: #f9f9f9" id="pawning">
            <a href="../PawningMasterServlet" target="_blank">
                <i class="fa fa-table small"></i><span style="color: green;font-size: 13px;">උකස්</span>
            </a>
        </li>
        <!--section-->
        <li style="background-color: #f9f9f9" id="section">
            <a href="../GetSectionTableServlet" >
                <i class="fa fa-plus-square small"></i><span style="color: green;font-size: 13px;">Section</span>
            </a>
        </li>
        <!--./Pawning-->

        <li class="treeview" id="custDetails">
            <a data="customer-index" href="#">
                <i class="fa fa-users small"></i> 
                <span style="font-size: 13px;">පාරිභෝගික තොරතුරු</span>
                <i class="fa fa-angle-left pull-right small"></i>
            </a>
            <ul class="treeview-menu" id="custDetailsUl">
                <li id="custDetails1"><a href="../LoadCustomerComboServlet" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>පුද්ගලික</a></li>
                <li id="custDetails2"><a href="../teller/company_details.jsp" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ආයතනික</a></li>
                <li id="custDetails2"><a href="../LoadMemberComboServlet" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>සාමාජික</a></li>
            </ul>
        </li>
        <li class="treeview" id="moneyDepTypeLi">
            <a href="#">
                <i class="fa fa-money small"></i>
                <span style="font-size: 13px;">තැම්පත් ගණුදෙණු</span>
                <i class="fa fa-angle-left pull-right small"></i>
            </a>
            <ul class="treeview-menu" id="moneyDepTypeUl">
                <li id="moneyDepType3"><a href="../SavingDetailsServlet?moneyDepType=5" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>තැම්පත් තොරතුරු</a></li>
                <li id="moneyDepType4"><a href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("121")%>" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ඉතුරුම් ගිණුම බැර</a></li>
                <li id="moneyDepType5"><a href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("151")%>" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ඉතුරුම් ගිණුම හර</a></li>
                <li id="moneyDepType6"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>චෙක්පත් තැම්පතු</a></li>
                <li id="moneyDepType7"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>චෙක්පත් නිකුත්කිරීම</a></li>
                <li id="moneyDepType8"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ගිණුමකින් හර කිරීම</a></li>
                <li id="moneyDepType9"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>පොළී ගණනය</a></li>
                <li id="moneyDepType10"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ගිණුම් වර්ගය මාරුකිරීම</a></li>
            </ul>
        </li>
        <li class="treeview" id="moneyLonTypeLi">
            <a href="#">
                <i class="fa fa-laptop small"></i>
                <span style="font-size: 13px;">ණය</span>
                <i class="fa fa-angle-left pull-right small"></i>
            </a>
            <ul class="treeview-menu" id="moneyLonType1Ul">
                <li id="moneyLonType3"><a href="../LoanDetailsServlet?loanType=3" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ණය තොරතුරු</a></li>
                <li id="moneyLonType4"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ණය ගිණුම බැර</a></li>
                <li id="moneyLonType5"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ණය ගිණුම හර</a></li>
                <li id="moneyLonType6"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>චෙක්පත් මඟින් නිකුත්කිරීම</a></li>
                <li id="moneyLonType7"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>චෙක්පත් මඟින් අයකිරීම</a></li>
                <li id="moneyLonType8"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ලෙජර් ගිණුමකින් නිකුත්කිරීම</a></li>
                <li id="moneyLonType9"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ලෙජර් ගිණුමකින් අයකිරීම </a></li>
                <li id="moneyLonType10"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ණය ගිණුමෙන් හරවීම</a></li>
                <li id="moneyLonType11"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ණය ගිණුම් බද්ධ කිරීම</a></li>
                <li id="moneyLonType12"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ණය වර්ගය වෙනස් කිරීම</a></li>
                <li id="moneyLonType13"><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>ණය අයවිය යුතු ආකාරය</a></li>
            </ul>
        </li>
        <li class="treeview" id="creditorDebtorLi">
            <a href="#">
                <i class="fa fa-laptop small"></i>
                <span style="font-size: 13px;">වෙනත්</span>
                <i class="fa fa-angle-left pull-right small"></i>
            </a>
            <ul class="treeview-menu" id="creditorDebtorUl">
                <li id="savingsCrdr121"><a href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("121")%>" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right small"></i>හර සටහන්</a></li>
                <li id="savingsCrdr151"><a href="../teller/savings_crdr.jsp?index=<%=Security.encrypt("151")%>" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right small"></i>බැර සටහන්</a></li>
            </ul>
        </li>
        <li id="commonLegger">
            <a href="../teller/common_legger.jsp">
                <i class="fa ffa fa-table small"></i><span style="font-size: 13px;">පොදු ලෙජරය</span>
            </a>
        </li>
        <li class="treeview">
            <a href="#">
                <i class="fa fa-print small"></i> <span style="font-size: 13px;">වාර්තා</span>
                <i class="fa fa-angle-left pull-right small"></i>
            </a>
            <ul class="treeview-menu">
                <li><a href="#" style="margin-left: 0px;font-size: 13px;"><i class="fa fa-angle-double-right"></i>දෛනික ගණුදෙණු</a></li>
            </ul>
        </li>
        <li id="commonLegger">
            <a href="./view_AllTransactions.jsp?tellerIndexKey=mTBR">
                <i class="fa fa-plus-circle small"></i></i><span style="font-size: 13px;">සියලුම ගණුදෙණු</span>
            </a>
        </li>

    </ul>
</section>

<script type="text/javascript" >
    //------------------------------------------------------
    function passMoneySaving(e) {
        e.href = e.href + "&nDepMFID=" + document.getElementById('nDepMFID').value;
    }
    function passMoneyLoan(e) {
        e.href = e.href + "&nLonMFID=" + document.getElementById('nLonMFID').value;
    }
    //------------------------------------------------------
</script>