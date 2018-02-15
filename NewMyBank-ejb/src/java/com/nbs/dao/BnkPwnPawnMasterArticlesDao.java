/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkPwnPawnMasterArticles;
import com.nbs.model.common.JDBC;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author mmh
 */
@Stateless
public class BnkPwnPawnMasterArticlesDao implements BnkPwnPawnMasterArticlesDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;
    private final JDBC jdbc = new JDBC();

    @Override
    public void saveBnkPwnPawnMasterArticles(List<BnkPwnPawnMasterArticles> articleses, BnkPwnPawnMaster bppm) throws SQLException {

        for (BnkPwnPawnMasterArticles bnkPwnPawnMasterArticles : articleses) {
            em.persist(bnkPwnPawnMasterArticles);

        }
        Connection connection = jdbc.getConnection();
        CallableStatement cs = connection.prepareCall("{call ssp_bnk_Insert_Pwn_PawnTransactions(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setBigDecimal(1, BigDecimal.ZERO);

        if (bppm.getDPwnDate() != null) {
            cs.setDate(2, new Date(bppm.getDPwnDate().getTime()));
        } else {
            cs.setDate(2, null);
        }

        cs.setLong(3, articleses.get(0).getNPwnMasterID());
        cs.setInt(4, bppm.getNBankBranchID());
        cs.setInt(5, 1);
        cs.setInt(6, 500);
        cs.setString(7, bppm.getCReceiptNo());
        cs.setBigDecimal(8, bppm.getNPwnAdvancedIssued());
        cs.setDouble(9, 0);
        cs.setDouble(10, 0);
        cs.setDouble(11, 0);
        cs.setDouble(12, 0);
        cs.setDouble(13, 0);
        cs.setDouble(14, 0);
        cs.setString(15, bppm.getCInputBy());
        System.out.println(cs.toString());
        cs.executeQuery();
        cs.getInt(16);
    }

    @Override
    public List<BnkPwnPawnMasterArticles> getBnkPwnPawnMasterArticlesList(long nPwnMasterID) {
        List<BnkPwnPawnMasterArticles> articleses = null;
        try {
            articleses = em.createNamedQuery("BnkPwnPawnMasterArticles.findByNPwnMasterID", BnkPwnPawnMasterArticles.class).setParameter("nPwnMasterID", nPwnMasterID).getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return articleses;
    }
}
