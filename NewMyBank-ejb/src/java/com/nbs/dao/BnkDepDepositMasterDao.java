/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkDepDepositMaster;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author mmh
 */
@Stateless
public class BnkDepDepositMasterDao implements BnkDepDepositMasterDaoLocal {
    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;

    @Override
    public int insertBnkDepDepositMaster(BnkDepDepositMaster bddm) {

        try {
            Connection connection = con.getConnection();
            CallableStatement cs = connection.prepareCall("{call ssp_bnk_Insert_Dep_Deposit_Master(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?)}");

            cs.setLong(1, bddm.getNDepMFID());
            cs.setInt(2, bddm.getNDepTypeID());
            cs.setLong(3, bddm.getNCustomerID().getNCustomerID());
            cs.setInt(4, bddm.getNBankBranchID());
            cs.setString(5, bddm.getCOurAccountNo());
            cs.setString(6, bddm.getCSerialNo());
            cs.setInt(7, bddm.getNLedgerBookNo());
            cs.setBigDecimal(8, bddm.getNEffectiveInt());
            cs.setBoolean(9, bddm.getBJoint());
            cs.setDate(10, new Date(bddm.getDStartDate().getTime()));
            cs.setInt(11, bddm.getNAcctStatusID());

            cs.setBigDecimal(12, bddm.getNFDIntialiDeposit());
            cs.setInt(13, bddm.getNFDPeriod());
            cs.setShort(14, bddm.getNFDPeriodTypeID());
            cs.setDate(15, new Date(bddm.getDFDMaturityDate().getTime()));
            cs.setBigDecimal(16, bddm.getNFDMaturityValue());
            cs.setString(17, bddm.getCFDAgreementNo());
            cs.setShort(18, bddm.getNFDClosingMethodID());
            cs.setShort(19, bddm.getNFDIntCalMethodID());
            cs.setInt(20, bddm.getNFDIntCalMethodValue());
            cs.setShort(21, bddm.getNFDIntCRMethodID());
            cs.setInt(22, bddm.getNFDIntCRMethodValue());

            cs.setBoolean(23, bddm.getBIntCreditingDiffAcc());
            cs.setLong(24, Long.parseLong(String.valueOf(bddm.getNIntCRnDepMFID())));

            cs.setBoolean(25, bddm.getBAmtHolded());
            cs.setBigDecimal(26, bddm.getNHoldedAmount());
            cs.setDate(27, new Date(bddm.getDHoldFromDate().getTime()));
            cs.setDate(28, new Date(bddm.getDHoldToDate().getTime()));

            cs.setBoolean(29, bddm.getBIntHolded());
            cs.setBigDecimal(30, bddm.getNHoldedAmountInt());
            cs.setDate(31, new Date(bddm.getDIntHoldFromDate().getTime()));
            cs.setDate(32, new Date(bddm.getDIntHoldToDate().getTime()));
            cs.setLong(33, Long.parseLong(String.valueOf(bddm.getNInstDRnDepMFID())));
            cs.setBigDecimal(34, bddm.getNInstDRValue());
            cs.setInt(35, bddm.getNTDDepositPeriod());
            cs.setBigDecimal(36, bddm.getNTDAgreedAmount());
            cs.setInt(37, bddm.getNTDPaymentDay());
            cs.setString(38, bddm.getCAddBy());

            cs.executeQuery();

            return cs.getInt(39);

        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<VFindDatabnkDepDepositMaster> getBnkDepositMasterView(int branchId, String key) {
        List<VFindDatabnkDepDepositMaster> bddms = null;
        try {
            Query q = em.createNativeQuery("{call ssp_bnk_FindData_Dep_Deposit_Master(?,?)}", VFindDatabnkDepDepositMaster.class);
            q.setParameter(1, 1);
//            q.setParameter(1, branchId);
//            q.setParameter(2, 0);
            q.setParameter(2, key);
            bddms = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bddms;
    }

    @Override
    public List<VFindDatabnkDepDepositMaster> getAllBnkDepDepositMaster(BigInteger nCustomerID) {
        return em.createNamedQuery("VFindDatabnkDepDepositMaster.findByNCustomerID").setParameter("nCustomerID", nCustomerID).getResultList();
    }

    @Override
    public BigInteger getBnkDepDepositMasterCustID(String cOurAccountNo) {
        try {
            Connection connection = con.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nCustomerID FROM bnk_Dep_Deposit_Master WHERE cOurAccountNo =" + cOurAccountNo);
            if (rs.next()) {
                BigInteger bd = BigInteger.valueOf(rs.getLong("nCustomerID"));
                return bd;
            }else{
                return BigInteger.ZERO;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return BigInteger.ZERO;
        }
    }
    
    @Override
    public long getBnkDepDepositMasterNDepMFID(String cOurAccountNo) {
        try {
            Connection connection = con.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nDepMFID FROM bnk_Dep_Deposit_Master WHERE cOurAccountNo =" + cOurAccountNo);
            if (rs.next()) {
                long l =rs.getLong("nDepMFID");
                return l;
            }else{
                return 0L;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0L;
        }
    }
    
//    @Override
//    public VFindDatabnkDepDepositMaster getNameBalanceBnkDepDepositMasterByNDepMFID(long nRecoverByDepMFID) {
//        try {
//            Connection connection = con.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT cDepName,nCurBookBalance,cFullName FROM VFindDatabnkDepDepositMaster WHERE nRecoverByDepMFID =" + nRecoverByDepMFID);
//            if (rs.next()) {
//                long l =rs.getLong("nDepMFID");
//                return l;
//            }else{
//                return 0L;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
//            return 0L;
//        }
//    }

    @Override
    public VFindDatabnkDepDepositMaster getAllBnkDepDepositMasterByNDepMFID(long nDepMFID) {
        return (VFindDatabnkDepDepositMaster) em.createNamedQuery("VFindDatabnkDepDepositMaster.findByNDepMFID").setParameter("nDepMFID", nDepMFID).getSingleResult();
    }

    @Override
    public BnkDepDepositMaster getBnkDepDepositMasterByNDepMFID(long nDepMFID) {
        return em.find(BnkDepDepositMaster.class, nDepMFID);
    }

}
