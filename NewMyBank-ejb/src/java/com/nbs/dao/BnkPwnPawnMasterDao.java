/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkPwnPawnReason;
import com.nbs.model.BnkPwnPawnTypes;
import com.nbs.model.BnkPwnRefArticls;
import com.nbs.model.BnkPwnRefCarateValues;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.common.JDBC;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkPwnPawnMasterDao implements BnkPwnPawnMasterDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;
    private final JDBC jdbc = new JDBC();

    @Override
    public List<BnkPwnPawnTypes> getBnkPwnPawnTypes() {
        List<BnkPwnPawnTypes> bppts = em.createNamedQuery("BnkPwnPawnTypes.findAll", BnkPwnPawnTypes.class).getResultList();
        return bppts;
    }

    @Override
    public void saveBnkPwnPawnMaster(BnkPwnPawnMaster bnkPwnPawnMaster) {
        em.persist(bnkPwnPawnMaster);
    }

    @Override
    public void updateBnkPwnPawnMaster(BnkPwnPawnMaster bnkPwnPawnMaster) {
        em.merge(bnkPwnPawnMaster);
    }

    /**
     *
     * @param cNicNo
     * @return
     * @throws NoResultException
     * @throws NullPointerException
     */
    @Override
    public BnkPwnPawnMaster getBnkPwnPawnMasterByNic(String cNicNo) {
        BnkPwnPawnMaster bppm = null;
        try {
            String jpql = "select bm from BnkPwnPawnMaster bm where bm.cIDNo=:cNicNo";
            Query createQuery = em.createQuery(jpql);
            createQuery.setParameter("cNicNo", cNicNo);
            createQuery.setMaxResults(1);
            bppm = (BnkPwnPawnMaster) createQuery.getSingleResult();
        } catch (NoResultException exception) {
            System.out.println("no data");
        }
        return bppm;
        // return em.createNamedQuery("BnkPwnPawnMaster.findByCIDNo", BnkPwnPawnMaster.class).setParameter("cIDNo", cNicNo).getSingleResult();

    }

    @Override
    public int saveBnkPwnPawnMasterSP(BnkPwnPawnMaster b) {
        int pk = 0;
        Connection connection = jdbc.getConnection();
        try {

            try {

                CallableStatement cs = connection.prepareCall("{call ssp_bnk_Insert_Pwn_PawnMaster(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,? )}");
//            CallableStatement cs = con.getConnection().prepareCall("{call ssp_bnk_Insert_Pwn_PawnMaster(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}");
                cs.setLong(1, 0L);

                if (b.getDPwnDate() != null) {
                    cs.setDate(2, new Date(b.getDPwnDate().getTime()));
                } else {
                    cs.setDate(2, null);
                }

                cs.setInt(3, b.getNPwnTypeID());
                cs.setInt(4, b.getNBankBranchID());
                cs.setBoolean(5, b.getBOldPawn());

                cs.setString(6, b.getCPwnTicketNo());
                cs.setString(7, b.getCReceiptNo());
                cs.setString(8, b.getCSerialNo());
                cs.setShort(9, b.getNLedgerBookNo());
                cs.setString(10, b.getCFullName());

                cs.setInt(11, b.getNIDType());
                cs.setString(12, b.getCIDNo());

                if (b.getDIssueDate() != null) {
                    cs.setDate(13, new Date(b.getDIssueDate().getTime()));
                } else {
                    cs.setDate(13, null);
                }

                cs.setDate(14, new Date(new java.util.Date().getTime()));
                cs.setString(15, b.getCPAddLine1());

                cs.setString(16, b.getCPAddLine2());
                cs.setString(17, b.getCPAddLine3());
                cs.setString(18, b.getCPAddLine4());
                cs.setString(19, b.getCPTelNo1());
                cs.setString(20, b.getCPTelNo2());

                cs.setInt(21, b.getNPwnDescriptionID());
                cs.setBigDecimal(22, b.getNTotWgtArt());
                cs.setBigDecimal(23, b.getNTotWgtGold());
                cs.setBigDecimal(24, b.getNTotMkrtValue());
                cs.setBigDecimal(25, b.getNOneGramAssessedValue());

                cs.setBigDecimal(26, b.getNTotAssessedValue());
                cs.setInt(27, b.getNPwnIntCatID());
                cs.setBigDecimal(28, b.getNActualInt());
                cs.setBigDecimal(29, b.getNEffectiveInt());
                cs.setInt(30, b.getNPwnPeriodTypeID());

                cs.setInt(31, b.getNPwnPeriod());

                if (b.getDMaturityDate() != null) {
                    cs.setDate(32, new Date(b.getDMaturityDate().getTime()));
                } else {
                    cs.setDate(32, null);
                }

                cs.setBigDecimal(33, b.getNPwnAdvancedIssued());
                cs.setBigDecimal(34, b.getNInsuredAmount());

                if (b.getDLastIntPayDate() != null) {
                    cs.setDate(35, new Date(b.getDLastIntPayDate().getTime()));
                } else {
                    cs.setDate(35, null);
                }

                cs.setBigDecimal(36, b.getNPwnBalanceAmount());
                cs.setString(37, b.getCRemrks());
                cs.setString(38, "");
                cs.setString(39, "");
                cs.setString(40, "");

                cs.setString(41, b.getCInputBy());
                cs.executeQuery();

                pk = cs.getInt(42);
                System.out.println(pk + "Save");
            } catch (SQLException ex) {
                Logger.getLogger(BnkPwnPawnMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return pk;
        } finally {
            if (connection != null) {

            }
        }
    }

    @Override
    public List<BnkPwnRefCarateValues> getBnkPwnRefCarateValues() {
        List<BnkPwnRefCarateValues> bprcvs = em.createNamedQuery("BnkPwnRefCarateValues.findAll", BnkPwnRefCarateValues.class).getResultList();
        return bprcvs;
    }

    @Override
    public List<BnkPwnRefArticls> getBnkPwnRefArticls() {
        List<BnkPwnRefArticls> bpras = em.createNamedQuery("BnkPwnRefArticls.findAll", BnkPwnRefArticls.class).getResultList();
        return bpras;
    }

    @Override
    public BnkPwnPawnMaster getBnkPwnPawnMasterBycReceiptNo(String cReceiptNo) {
        BnkPwnPawnMaster bppm = null;
        try {
            bppm = em.createNamedQuery("BnkPwnPawnMaster.findByCReceiptNo", BnkPwnPawnMaster.class).setParameter("cReceiptNo", cReceiptNo).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return bppm;
    }

    @Override
    public List<BnkPwnPawnMaster> getBnkPwnPawnMasterList(String key, int branchId, int status) {
        List<BnkPwnPawnMaster> bppms = null;

        Query query = em.createNativeQuery("{call ssp_bnk_FindData_Pwn_PawnMaster(?,?,?)}", BnkPwnPawnMaster.class);

        query.setParameter(1, branchId);
        query.setParameter(2, key);
        query.setParameter(3, status);
        bppms = query.getResultList();

        return bppms;
    }

    @Override
    public boolean saveBankPwnRefArticls(BnkPwnRefArticls bnkPwnRefArticls) {
        em.merge(bnkPwnRefArticls);
        return true;
    }

    @Override
    public List<BnkPwnPawnMaster> getPwnDataUsingName(String fullName) {
        String jpql = "select pw from BnkPwnPawnMaster pw where pw.cFullName=:fullNa";

        Query createQuery = em.createQuery(jpql);
        createQuery.setParameter("fullNa", fullName);
        System.out.println(fullName);

        List<BnkPwnPawnMaster> bppms = createQuery.getResultList();

        return bppms;
    }

    @Override
    public List<BnkPwnPawnMaster> getPwnDataUsingNic(String nicNo) {
        List<BnkPwnPawnMaster> bppms = null;
        try {
            String jpql = "select bm from BnkPwnPawnMaster bm where bm.cIDNo=:cNicNo";
            Query createQuery = em.createQuery(jpql);
            createQuery.setParameter("cNicNo", nicNo);

            bppms = createQuery.getResultList();

        } catch (NoResultException exception) {
            System.out.println("no data");
        }
        return bppms;
    }

    @Override
    public List<BnkPwnPawnReason> getallPwnReasons() {
        List<BnkPwnPawnReason> bnkPwnPawnReasons = null;
        try {
            String jpql = "select pr from BnkPwnPawnReason pr";
            Query createQuery = em.createQuery(jpql);
            bnkPwnPawnReasons = createQuery.getResultList();
        } catch (NoResultException exception) {
            System.out.println("no data");
        }
        return bnkPwnPawnReasons;
    }

    @Override
    public boolean savePwnReason(BnkPwnPawnReason reason) {
        em.merge(reason);
        return true;
    }

    @Override
    public boolean saveRePwn(BnkPwnPawnMaster bppm, double paymentValue) throws SQLException, NullPointerException, NoResultException {
        Connection connection = jdbc.getConnection();
        CallableStatement cs = connection.prepareCall("{call ssp_bnk_Insert_Pwn_PawnTransactions(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setBigDecimal(1, BigDecimal.ZERO);

        if (bppm.getDPwnDate() != null) {
            cs.setDate(2, new Date(bppm.getDPwnDate().getTime()));
        } else {
            cs.setDate(2, null);
        }

        cs.setLong(3, bppm.getNPwnMasterID());
        cs.setInt(4, bppm.getNBankBranchID());
        cs.setInt(5, 1);
        cs.setInt(6, 104);
        cs.setString(7, bppm.getCReceiptNo());
        cs.setBigDecimal(8, BigDecimal.valueOf(paymentValue));
        cs.setBigDecimal(9, bppm.getNToDateCapital());
        cs.setBigDecimal(10, bppm.getNActualInt());
        cs.setBigDecimal(11, bppm.getNToDatePostage());
        cs.setBigDecimal(12, bppm.getNToDateStationary());
        cs.setBigDecimal(13, bppm.getNToDateAuctionFee());
        cs.setBigDecimal(14, bppm.getNTotRecvInterest());

        cs.setString(15, bppm.getCInputBy());

        cs.executeQuery();
        return cs.getInt(16) > 0;
    }

    @Override
    public List<BnkPwnPawnMaster> getBnkPwnPawnMasterList(int branchId, int status, int typeId, String fromDate, String toDate) {
        List<BnkPwnPawnMaster> bppms = null;

        Query query = em.createNativeQuery("{call ssp_bnk_FindData_Pwn_PawnMaster2(?,?,?,?,?)}", BnkPwnPawnMaster.class);

        query.setParameter(1, branchId);
        query.setParameter(2, typeId);
        query.setParameter(3, fromDate);
        query.setParameter(4, toDate);
        query.setParameter(5, status);
        bppms = query.getResultList();

        return bppms;
    }

    @Override
    public List<BnkRefBankBranch> getBnkBranch() {
        String jpql = "select branch from BnkRefBankBranch branch";
        Query createQuery = em.createQuery(jpql);
        List<BnkRefBankBranch> bankBranchs = createQuery.getResultList();
        return bankBranchs;
    }

    @Override
    public int getId(String typeId) {
        System.out.println("AAAAAAAAAAA");
        return 0;
    }
}
