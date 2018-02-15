/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.ActChartOfAcctL1;
import com.nbs.model.ActChartOfAcctL2;
import com.nbs.model.ActChartOfAcctL3;
import com.nbs.model.ActChartOfAcctL4;
import com.nbs.model.ActChartOfAcctL5;
import com.nbs.model.BnkPwnPawnTypes;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
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
public class BnkActDao implements BnkActDaoLocal {

    @Resource(name = "con")
    private DataSource con;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ActChartOfAcctL1> getAct1() {
        List<ActChartOfAcctL1> acctL1s = new ArrayList<>();
        Query q = em.createNamedQuery("ActChartOfAcctL1.findAll");
        acctL1s = q.getResultList();

        return acctL1s;
    }

    @Override
    public List<ActChartOfAcctL2> getAct2() {
        List<ActChartOfAcctL2> acctL2s = new ArrayList<>();
        Query q = em.createNamedQuery("ActChartOfAcctL2.findAll");
        acctL2s = q.getResultList();

        return acctL2s;
    }

    @Override
    public List<ActChartOfAcctL3> getAct3() {
        List<ActChartOfAcctL3> acctL3s = new ArrayList<>();
        Query q = em.createNamedQuery("ActChartOfAcctL3.findAll");
        acctL3s = q.getResultList();
        return acctL3s;
    }

    @Override
    public List<ActChartOfAcctL4> getAct4() {
        List<ActChartOfAcctL4> acctL4s = new ArrayList<>();
        Query q = em.createNamedQuery("ActChartOfAcctL4.findAll");
        acctL4s = q.getResultList();
        return acctL4s;
    }

    @Override
    public List<ActChartOfAcctL5> getAct5() {
        List<ActChartOfAcctL5> acctL5s = new ArrayList<>();
        Query q = em.createNamedQuery("ActChartOfAcctL5.findAll");
        acctL5s = q.getResultList();
        return acctL5s;
    }

    @Override
    public List<ActChartOfAcctL4> getAct4View(String key) {
        List<ActChartOfAcctL4> acctL4s = new ArrayList<>();
        Query q = em.createNativeQuery("{call ssp_bnk_FindData_Act_ChartOfAcctL4(?)}", ActChartOfAcctL4.class);
        q.setParameter(1, key);
        acctL4s = q.getResultList();
        return acctL4s;
    }

    @Override
    public void saveACT2(ActChartOfAcctL2 act2) {
        em.merge(act2);
//        try {
//            Connection connection =    con.getConnection();
//          CallableStatement callableStatement =  connection.prepareCall("call");
//          callableStatement.setString(null, null);
//           callableStatement.executeQuery();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(BnkActDao.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @Override
    public void saveACT3(ActChartOfAcctL3 act3) {
        em.persist(act3);
    }

    @Override
    public void saveACT4(ActChartOfAcctL4 act4) {
        em.persist(act4);
    }

    @Override
    public void updateACT2(ActChartOfAcctL2 act2) {
//        try {
//            System.out.println("ok");
//            Connection connection = con.getConnection();
//            CallableStatement callableStatement = connection.prepareCall("{call ssp_Act_Insert_Act_ChartOfAcctL2(?,?)}");
//            callableStatement.setInt(1, act2.getNAcctLevelID2());
//            callableStatement.setString(2, act2.getCDescriptionUniL2());
//            callableStatement.executeQuery();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(BnkActDao.class.getName()).log(Level.SEVERE, null, ex);
//        }

        em.merge(act2);
    }

    @Override
    public void updateACT3(ActChartOfAcctL3 act3) {
        em.merge(act3);
    }

    @Override
    public void updateACT4(ActChartOfAcctL4 act4) {
        em.merge(act4);
    }

    @Override
    public void saveACT5(ActChartOfAcctL5 act5) {
        em.persist(act5);
    }

    @Override
    public void updateACT5(ActChartOfAcctL5 act5) {
        em.merge(act5);
        
    }

    @Override
    public List<ActChartOfAcctL5> getAct5SearchingData(String tip) {
        List<ActChartOfAcctL5> acct = null;

        Query q = em.createNativeQuery("{call ssp_bnk_FindData_Act_ChartOfAcctL5(?)}", ActChartOfAcctL5.class);
        q.setParameter(1, tip);
        acct = q.getResultList();

        return acct;
    }

    @Override
    public boolean savePawnType(BnkPwnPawnTypes bnkPwnPawnTypes) {

        boolean isOk = false;
        try {

            Connection connection = con.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call ssp_bnk_Insert_Pwn_PawnTypes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            callableStatement.setBigDecimal(1, BigDecimal.ZERO);
            callableStatement.setInt(2, bnkPwnPawnTypes.getNPawnTypeID());
            callableStatement.setString(3, bnkPwnPawnTypes.getCSysCode());
            callableStatement.setBigDecimal(4, bnkPwnPawnTypes.getNIntRate());
            callableStatement.setInt(5, bnkPwnPawnTypes.getNPwnMonthsDays());
            callableStatement.setInt(6, bnkPwnPawnTypes.getNIntCalMethod());
            callableStatement.setInt(7, bnkPwnPawnTypes.getNIntCalMethod());
            callableStatement.setInt(8, bnkPwnPawnTypes.getNAcctLevelID5PawnCapital());
            callableStatement.setInt(9, bnkPwnPawnTypes.getNAcctLevelID5PawnInterest());
            callableStatement.setInt(10, bnkPwnPawnTypes.getNAcctLevelID5PawnPostage());
            callableStatement.setInt(11, bnkPwnPawnTypes.getNAcctLevelID5PawnStationary());
            callableStatement.setInt(12, bnkPwnPawnTypes.getNAcctLevelID5PawnAuction());
            callableStatement.setInt(13, bnkPwnPawnTypes.getNAcctLevelID5InterestFree());
            callableStatement.setString(14, bnkPwnPawnTypes.getCAddBy());
            callableStatement.executeQuery();
            isOk = callableStatement.getInt(15) > 0;

        } catch (SQLException ex) {
            Logger.getLogger(BnkActDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isOk;
    }

    @Override
    public ActChartOfAcctL5 getAct5Data(int id) {
        
        ActChartOfAcctL5 acctL5 = null;
        try {
            String jpql = "select act from ActChartOfAcctL5 act where act.nAcctLevelID5=:id";
            Query createQuery = em.createQuery(jpql);
            createQuery.setParameter("id", id);
            acctL5 = (ActChartOfAcctL5) createQuery.getSingleResult();
        } catch (Exception exception) {

        }
        return acctL5;
    }

}
