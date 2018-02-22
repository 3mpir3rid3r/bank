/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkLonLoanMaster;
import com.nbs.model.VFindDatabnkLonLoanMaster;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class BnkLonLoanMasterDao implements BnkLonLoanMasterDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;

    @Override
    public int insertBnkLonLoanMaster(BnkLonLoanMaster bllm) {

        try {
            Connection connection = con.getConnection();
            CallableStatement cs = connection.prepareCall("{call ssp_bnk_Insert_Lon_Loan_Master(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?)}");

            cs.setLong(1, bllm.getNLonMFID());
            cs.setInt(2, bllm.getNBankBranchID());
            cs.setInt(3, bllm.getNLonTypeID());
            cs.setLong(4, bllm.getNCustomerID());
            cs.setInt(5, bllm.getNLonDescriptionID());

            cs.setInt(6, bllm.getNLonFundSourceID());
            cs.setBoolean(7, bllm.getBJoint());
            cs.setInt(8, bllm.getNLonStatusID());
            cs.setString(9, bllm.getCLonAccountNo());
            cs.setString(10, bllm.getNLedgerBookNo());

            cs.setString(11, bllm.getCSerialNo());
            cs.setDate(12, new Date(bllm.getDApplyedDate().getTime()));
            cs.setDate(13, new Date(bllm.getDApprovedDate().getTime()));
            cs.setBigDecimal(14, bllm.getNApplyedAmount());

            cs.setBigDecimal(15, bllm.getNApprovedAmount());
            cs.setBigDecimal(16, bllm.getNInsuredAmount());
            cs.setBigDecimal(17, bllm.getNReservedAmount());
            cs.setBigDecimal(18, bllm.getNEffectiveInt());
            cs.setBigDecimal(19, bllm.getNPanaltyInt());

            cs.setString(20, bllm.getCBoardApprovalNo());
            cs.setDate(21, new Date(bllm.getDBoardApprovalDate().getTime()));
            cs.setShort(22, bllm.getNLonPeriodTypeID());
            cs.setInt(23, bllm.getNLonPeriod());
            cs.setShort(24, bllm.getNLonPaymentFreeTypeID());

            cs.setInt(25, bllm.getNLonPaymentFreeTime());
            cs.setDate(26, new Date(bllm.getDFirstInstallmentDate().getTime()));
            cs.setDate(27, new Date(bllm.getDMaturityDate().getTime()));
            cs.setShort(28, bllm.getNLonDeductTypeID());
            cs.setInt(29, bllm.getNLonGrpID());

            cs.setBigDecimal(30, bllm.getNFixedInterestValue());
            cs.setShort(31, bllm.getNLonInstallmentPayTypeID());
            cs.setInt(32, bllm.getNLonInstallmentPayTime());
            cs.setBigDecimal(33, bllm.getNInstallmentAmount());
            cs.setBigDecimal(34, bllm.getNInstallmentAmountAdj());

            cs.setBigDecimal(35, bllm.getNInstallmentAmountLast());
            cs.setInt(36, bllm.getNDueDaysAfter());
            cs.setInt(37, bllm.getNDeductDay());

            cs.setBigDecimal(38, bllm.getNIssuedAmount());
            cs.setBigDecimal(39, bllm.getNBalanceToIssue());
            cs.setBigDecimal(40, bllm.getNTotRecvCapital());
            cs.setBigDecimal(41, bllm.getNTotRecvInstallment());
            cs.setBigDecimal(42, bllm.getNShouldRecvCapital());
            cs.setBigDecimal(43, bllm.getNShouldRecvInstallment());
            cs.setBigDecimal(44, bllm.getNTotRecvInterest());
            cs.setBigDecimal(45, bllm.getNShouldRecvInterest());
            cs.setBigDecimal(46, bllm.getNLonBalanceAmount());
            cs.setBigDecimal(47, bllm.getNLonBalanceInstallment());
            cs.setDate(48, new Date(bllm.getDLastCapitalPayDate().getTime()));
            cs.setDate(49, new Date(bllm.getDLastIntPayDate().getTime()));
            cs.setBigDecimal(50, bllm.getNToDateDueCapital());
            cs.setBigDecimal(51, bllm.getNToDateDueInstallment());
            cs.setBigDecimal(52, bllm.getNToDateIntValueRound());
//            cs.setBigDecimal(52, bllm.getNToDateDueDays());
            cs.setBigDecimal(53, bllm.getNToDateTotIntersest());
            System.out.println(cs);
            cs.executeQuery();

            return cs.getInt(54);

        } catch (SQLException ex) {
            Logger.getLogger(BnkLonLoanMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public VFindDatabnkLonLoanMaster getAllBnkLonLoanMasterByNLonMFID(long nLonMFID) {
        return (VFindDatabnkLonLoanMaster) em.createNamedQuery("VFindDatabnkLonLoanMaster.findByNLonMFID").setParameter("nLonMFID", nLonMFID).getSingleResult();
    }

    @Override
    public List<VFindDatabnkLonLoanMaster> getLoanMasterView(int branchId, String key) {
        List<VFindDatabnkLonLoanMaster> vfdllms = new ArrayList<>();
        Query q = em.createNativeQuery("{call ssp_bnk_FindData_Lon_Loan_Master(?,?)}", VFindDatabnkLonLoanMaster.class);
        q.setParameter(1, branchId);
        q.setParameter(2, key);
        vfdllms = q.getResultList();
        return vfdllms;
    }

    @Override
    public List<VFindDatabnkLonLoanMaster> getAllBnkLonLoanMaster(BigInteger nCustomerID) {
        return em.createNamedQuery("VFindDatabnkLonLoanMaster.findByNCustomerID").setParameter("nCustomerID", nCustomerID).getResultList();
    }

    @Override
    public BigInteger getBnkLonLoanMasterCustID(String cLonAccountNo) {
        try {
            Connection connection = con.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nCustomerID FROM bnk_Lon_Loan_Master WHERE cLonAccountNo =" + cLonAccountNo);
            if (rs.next()) {
                BigInteger bi = BigInteger.valueOf(rs.getLong("nCustomerID"));
                return bi;
            } else {
                return BigInteger.ZERO;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return BigInteger.ZERO;
        }
    }

    @Override
    public long getBnkLonLoanMasterNLonMFID(String cLonAccountNo) {
        try {
            Connection connection = con.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nLonMFID FROM bnk_Lon_Loan_Master WHERE cLonAccountNo =" + cLonAccountNo);
            if (rs.next()) {
                long bi = rs.getLong("nLonMFID");
                return bi;
            } else {
                return 0L;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0L;
        }
    }

}
