/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkLonLoanTransactions;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author mmh
 */
@Stateless
public class BnkLonLoanTransactionsDao implements BnkLonLoanTransactionsDaoLocal {
    
    @Resource(name = "con")
    private DataSource con;
    
    @Override
    public void insertBnkLonLoanTransactions(BnkLonLoanTransactions bllt) {
        
        try {
            System.out.println( "....start");
            Connection connection = con.getConnection();
            CallableStatement cs = connection.prepareCall("{call ssp_bnk_Insert_Lon_Loan_Transaction(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?)}");
            cs.setLong(1, 0);     //nLonTrnID
            cs.setLong(2, bllt.getNLonMFID()); 
            cs.setInt(3, bllt.getNTellerID()); 
            cs.setInt(4, bllt.getNBankBranchIDTrn());
            
            Date dTrnDate = new Date(bllt.getDTrnDate().getTime());
            cs.setDate(5, dTrnDate); //date,
            
            Date dDepositDate = new Date(bllt.getDDepositDate().getTime());
            cs.setDate(6, dDepositDate);//date,            
            cs.setInt(7, bllt.getNGLTrnID());     // int,  deposit 100  if widtrowal 101       
                      
            cs.setString(8, bllt.getCReceiptNo()); 
            cs.setString(9, bllt.getCReceiptNo2());
            cs.setBigDecimal(10, bllt.getNPaymentVal());
            cs.setBigDecimal(11, bllt.getNDr());
            cs.setBigDecimal(12, bllt.getNCr());
            cs.setLong(13, bllt.getNTrnDepMFID());
            
            Date dPaidCapitalDate = new Date(bllt.getDPaidCapitalDate().getTime());
            cs.setDate(14, dPaidCapitalDate);
            
            Date dPaidIntDate = new Date(bllt.getDPaidIntDate().getTime());
            cs.setDate(15, dPaidIntDate);
            
            Date dPaidPenaltyIntDate = new Date(bllt.getDPaidPenaltyIntDate().getTime());
            cs.setDate(16, dPaidPenaltyIntDate);
            
            cs.setInt(17, bllt.getNPaidIntDays()); 
            cs.setInt(18, bllt.getNPaidPenaltyIntDays());
            
            cs.setBigDecimal(19, bllt.getNPaidCapitalVal()); 
            cs.setBigDecimal(20, bllt.getNPaidIntValue()); 
            cs.setBigDecimal(21, bllt.getNPaidPenaltyValue()); 
            cs.setBigDecimal(22, bllt.getNPaidTotalInt()); 
            cs.setBigDecimal(23, bllt.getNPaidPostage()); 
            cs.setBigDecimal(24, bllt.getNPaidStationary()); 
            cs.setBigDecimal(25, bllt.getNPaidOherCharges()); 
            cs.setBigDecimal(26, bllt.getNPaidArbitrationFees()); 
            cs.setBigDecimal(27, bllt.getNPaidCaurtFees());
    
            cs.setString(28, bllt.getCAddBy()); 
            
            cs.executeQuery();

            System.out.println(cs.getInt(29)+".....saved");
            
        } catch (SQLException ex) {
            Logger.getLogger(BnkLonLoanTransactionsDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
