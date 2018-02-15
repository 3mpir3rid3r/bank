/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkDepDepositTrnOthDT;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author mmh
 */
@Stateless
public class BnkDepDepositTrnOthDTDao implements BnkDepDepositTrnOthDTDaoLocal {
    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveBnkDepDepositTrnOthDT(List<BnkDepDepositTrnOthDT> bddtodts , Long nBnkDepDepositTrnOthHDId) {
        try {
//            for (BnkDepDepositTrnOthDT b : bddtodts) {
//                em.persist(b);
//            }
            String sql = "INSERT INTO bnk_Dep_Deposit_TrnOth_DT VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?)";
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);
            for (BnkDepDepositTrnOthDT b : bddtodts) {
             preparedStatement.setInt(1, 0);
             preparedStatement.setLong(2, nBnkDepDepositTrnOthHDId);
             preparedStatement.setInt(3, b.getNGLTrnID());
             preparedStatement.setInt(4, (int) b.getNDepMFID());
             preparedStatement.setDate(5, new Date(b.getDTrnDate().getTime()));
             preparedStatement.setInt(6, b.getNTrnStatusID());
             preparedStatement.setInt(7, b.getNJournalDTID());
             preparedStatement.setBigDecimal(8, b.getNPaymentVal());
             preparedStatement.setBigDecimal(9, b.getNDr());
             preparedStatement.setBigDecimal(10, b.getNCr());
             preparedStatement.setString(11, b.getCReceiptNo());
             preparedStatement.setString(12, b.getCAddBy());
             preparedStatement.executeUpdate();             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
