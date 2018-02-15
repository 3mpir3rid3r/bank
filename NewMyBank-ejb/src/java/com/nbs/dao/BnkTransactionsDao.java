/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkDepDepositTransaction;
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
public class BnkTransactionsDao implements BnkTransactionsDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @Override
    public int insertBnkDepDepositTransaction(BnkDepDepositTransaction bddt) {

        try {
            System.out.println( "....start");
            Connection connection = con.getConnection();
            CallableStatement cs = connection.prepareCall("{call ssp_bnk_Insert_Dep_Deposit_Transaction(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?)}");
            cs.setInt(1, 0);     //bigint,
            cs.setLong(2, bddt.getNDepMFID());      //bigint,
            cs.setInt(3, bddt.getNTellerID());      //1 int,
            cs.setInt(4, bddt.getNBankBranchIDTrn());//int,   

            Date dTrnDate = new Date(bddt.getDTrnDate().getTime());
            cs.setDate(5, dTrnDate); //date,

            Date dDepositDate = new Date(bddt.getDDepositDate().getTime());
            cs.setDate(6, dDepositDate);//date,            

            cs.setString(7, bddt.getCReceiptNo());      //VARCHAR(50),
            cs.setString(8, bddt.getCReceiptNo2());     //VARCHAR(50),
            cs.setInt(9, bddt.getNGLTrnID());       // int,  deposit 100  if widtrowal 101 
            cs.setBigDecimal(10, bddt.getNPaymentVal());  //DECIMAL(18,2),
            cs.setBigDecimal(11, bddt.getNDr());
            cs.setBigDecimal(12, bddt.getNCr());
            cs.setInt(13, bddt.getNDailyCollectionHDID());//bigint,
            cs.setString(14, bddt.getCAddBy()); //

            cs.executeQuery();

            System.out.println(cs.getInt(15) + ".....zzzzzzzzzzzzzzzzzzzzzzsaved");
//            int csReturnId = cs.getInt(15);
//            System.out.println(csReturnId);
//            System.out.println("kalana");
//            
//            CallableStatement cs1 = con.getConnection().prepareCall("{call ssp_Act_Create_Journals_bnk_DepTrn(?,?)}");
//            cs1.setInt(1, csReturnId);
////
//            cs1.executeQuery();
//                        
//            
//            System.out.println("saved");
//            System.out.println(cs1.getInt(2) + ".....savedJournal");
//            
//            int intJournalHDID=cs1.getInt(2);
//            CallableStatement cs2 = con.getConnection().prepareCall("{call ssp_Act_Journal_Confirm(?)}");
//            cs2.setInt(1,intJournalHDID);
//            cs2.executeQuery();
            return cs.getInt(15);
        } catch (SQLException ex) {
            Logger.getLogger(BnkTransactionsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public long insertBnkLonLoanTransactions(BnkLonLoanTransactions bllt) {

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
            long loanTrnId = cs.getLong(29);
            
            cs = con.getConnection().prepareCall("{call ssp_Act_Create_Journals_bnk_LonTrn(?,?)}");
            cs.setLong(1, loanTrnId);
            cs.executeQuery();
            int intJournalHDID=cs.getInt(2);
            
            cs = con.getConnection().prepareCall("{call ssp_Act_Journal_Confirm(?)}");
            cs.setInt(1,intJournalHDID);
            cs.executeQuery();
            
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(BnkLonLoanTransactionsDao.class.getName()).log(Level.SEVERE, null, ex);
            return -1L;
        }

    }
}
