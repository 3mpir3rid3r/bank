/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkOtherTranDT;
import com.nbs.model.BnkOtherTranHD;
import com.nbs.model.common.JDBC;
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
public class BnkOtherTranDTDao implements BnkOtherTranDTDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveBnkOtherTranTD(List<BnkOtherTranDT> list,Long NOthTrnDTID) {
        try {
            
//            em.persist(list.get(1));
//            for (BnkOtherTranDT b : list) {
//                em.persist(b);
//            }
           
            String sql = "INSERT INTO bnk_Other_Tran_DT VALUES(?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?, ?,?,?)";
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);
            for (BnkOtherTranDT b : list) {
                System.out.println(b.getCDescription()+"des");
                preparedStatement.setInt(1, 0);
                preparedStatement.setLong(2,NOthTrnDTID);
                preparedStatement.setInt(3, b.getNAcctLevelID4());
                preparedStatement.setString(4, b.getCDescription());
                preparedStatement.setInt(5, (int) b.getNJournalDTID());
                preparedStatement.setBoolean(6, false);
                preparedStatement.setBoolean(7, false);
                preparedStatement.setBigDecimal(8, b.getNPaymentVal());
                preparedStatement.setBigDecimal(9, b.getNDr());
                preparedStatement.setBigDecimal(10, b.getNCr());
                preparedStatement.setString(11, b.getCAddBy());
                preparedStatement.setDate(12, new Date(b.getCAddDate().getTime()));
                preparedStatement.setString(13, b.getCAppRejBy());
                preparedStatement.setDate(14, new Date(new java.util.Date().getTime()));
                preparedStatement.setString(15, b.getCPostedBy());
                preparedStatement.setDate(16, new Date(new java.util.Date().getTime()));
                preparedStatement.setInt(17, b.getNGLTrnID());
                preparedStatement.setInt(18, b.getNOutsiderMFID());

                preparedStatement.executeUpdate();
                System.out.println("saved");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
