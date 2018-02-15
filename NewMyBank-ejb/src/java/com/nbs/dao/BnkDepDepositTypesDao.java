/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.common.BnkDepDepositCategoryTypes;
import com.nbs.model.BnkDepDepositTypes;
import java.sql.CallableStatement;
import java.sql.Connection;
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
import javax.sql.DataSource;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkDepDepositTypesDao implements BnkDepDepositTypesDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;

    @Override
    public int insertBnkDepDepositTypes(BnkDepDepositTypes bddt, String userName) {
        int output = 0;
        try {
            Connection connection = con.getConnection();
            CallableStatement createNativeQuery = connection.prepareCall("{call ssp_bnk_Insert_Dep_DepositTypes(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?)}");

            createNativeQuery.setInt(1, bddt.getNDepTypeID());
            createNativeQuery.setInt(2, bddt.getNDepCatID());
            createNativeQuery.setString(3, bddt.getCSysCode());
            createNativeQuery.setString(4, bddt.getCDepName());
            createNativeQuery.setString(5, bddt.getCDepNameSin());
            createNativeQuery.setString(6, bddt.getCDepNameTamil());
            createNativeQuery.setInt(7, bddt.getNMinParticipant());
            createNativeQuery.setInt(8, bddt.getNMaxParticipant());
            createNativeQuery.setInt(9, bddt.getNMinAge());
            createNativeQuery.setInt(10, bddt.getNMaxAge());
            createNativeQuery.setInt(11, bddt.getNOperatingGenderType());
            createNativeQuery.setBigDecimal(12, bddt.getNMinAmtStart());
            createNativeQuery.setBigDecimal(13, bddt.getNMinAmtContinue());
            createNativeQuery.setBoolean(14, bddt.getBInitialDepCash());
            createNativeQuery.setBoolean(15, bddt.getBInitialDepChque());
            createNativeQuery.setBoolean(16, bddt.getBInitialDepFTrnans());
            createNativeQuery.setBoolean(17, bddt.getBMultipleAcct());
            createNativeQuery.setInt(18, bddt.getNMinMonths());
            createNativeQuery.setInt(19, bddt.getNMaxMonths());
            createNativeQuery.setBoolean(20, bddt.getBWithdrawlsAllowed());
            createNativeQuery.setBigDecimal(21, bddt.getNNoOfDays());
            createNativeQuery.setInt(22, bddt.getNNoOfTimesPerMonth());
            createNativeQuery.setInt(23, bddt.getNMinAgeLimitWithdrawls());
            createNativeQuery.setBigDecimal(24, bddt.getNCurrentIntRate());
            createNativeQuery.setInt(25, bddt.getNIntCalMethodID());
            createNativeQuery.setInt(26, bddt.getNIntCalID());
            createNativeQuery.setInt(27, bddt.getNIntPayID());
            createNativeQuery.setBigDecimal(28, bddt.getNMinAmtIntCal());
            createNativeQuery.setBigDecimal(29, bddt.getNMinAmtIntCR());
            createNativeQuery.setInt(30, bddt.getNInterestRoundMethod());
            createNativeQuery.setBigDecimal(31, bddt.getNBonusIntRate());
            createNativeQuery.setBigDecimal(32, bddt.getNLoanAmount());
            createNativeQuery.setInt(33, bddt.getNAcctLevelID5Capital());
            createNativeQuery.setInt(34, bddt.getNAcctLevelID5Interest());
            createNativeQuery.setBoolean(35, bddt.getBChangeToInactive());
            createNativeQuery.setInt(36, bddt.getNInacPeriod());
            createNativeQuery.setString(37, bddt.getCInacPeriodType());
            createNativeQuery.setBoolean(38, bddt.getBChangeToHimiNopa());
            createNativeQuery.setInt(39, bddt.getNHimiPeriod());
            createNativeQuery.setString(40, bddt.getNHimiPeriodType());
            createNativeQuery.setString(41, bddt.getCRemarks());
            createNativeQuery.setBoolean(42, bddt.getBActive());
            createNativeQuery.setString(43, userName);

            createNativeQuery.executeQuery();

            output = createNativeQuery.getInt(44);

        } catch (SQLException ex) {
            Logger.getLogger(BnkLonLoanTypesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    public List<BnkDepDepositCategoryTypes> getAllBnkDepDepositTypes() {
        return em.createNativeQuery("{call ssp_bnk_DisplayData_Dep_DepositTypes}", BnkDepDepositCategoryTypes.class).getResultList();
    }

    @Override
    public BnkDepDepositTypes getOneBnkDepDepositTypes(int nDepTypeID) {
        BnkDepDepositTypes bddt = null;
        try {

            Connection connection = con.getConnection();
            Statement createStatement = connection.createStatement();
            String sql = "select * from bnk_Dep_DepositTypes where nDepTypeID=" + nDepTypeID + "";
            ResultSet rst = createStatement.executeQuery(sql);
            if (rst.next()) {
                
//                bddt= new BnkDepDepositTypes(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7),  rst.getInt(8), rst.getInt(9), rst.getInt(10), rst.getShort(11), rst.getBigDecimal(12),  rst.getBigDecimal(13), rst.getBoolean(14), rst.getBoolean(15), rst.getBoolean(16), rst.getBoolean(17), rst.getInt(18),rst.getInt(19), rst.getBoolean(20), rst.getBigDecimal(21), rst.getInt(22), rst.getShort(23), rst.getBigDecimal(24), rst.getShort(25), rst.getInt(26), rst.getInt(27), rst.getBigDecimal(28), rst.getBigDecimal(29),rst.getShort(30), rst.getBigDecimal(31), rst.getBigDecimal(32), rst.getInt(33), rst.getInt(34), rst.getBoolean(35), rst.getInt(36),rst.getString(37), rst.getBoolean(38), rst.getInt(39), rst.getString(40),rst.getString(41), rst.getBoolean(42), rst.getString(43), rst.getDate(44), rst.getString(45),rst.getDate(46),rst.getShort(47), rst.getString(48), rst.getDate(49));
                bddt= new BnkDepDepositTypes(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7),  rst.getInt(8), rst.getInt(9), rst.getInt(10), rst.getShort(11), rst.getBigDecimal(12),  rst.getBigDecimal(13), rst.getBoolean(14), rst.getBoolean(15), rst.getBoolean(16), rst.getBoolean(17), rst.getInt(18),rst.getInt(19), rst.getBoolean(20), rst.getBigDecimal(21), rst.getInt(22), rst.getShort(23), rst.getBigDecimal(24), rst.getShort(25), rst.getInt(26), rst.getInt(27), rst.getBigDecimal(28), rst.getBigDecimal(29),rst.getShort(30), rst.getBigDecimal(31), rst.getBigDecimal(32), rst.getInt(33), rst.getInt(34), rst.getBoolean(35), rst.getInt(36),rst.getDate(37), rst.getBoolean(38), rst.getInt(39), rst.getString(40),rst.getString(41), rst.getBoolean(42), rst.getString(43), rst.getString(44), rst.getDate(45),rst.getShort(46),rst.getString(47), rst.getDate(48), rst.getString(49));
                
//                bddt= new BnkDepDepositTypes(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7),  rst.getInt(8), rst.getInt(9), rst.getInt(10), rst.getShort(11), rst.getBigDecimal(12),  rst.getBigDecimal(13), rst.getBoolean(14), rst.getBoolean(15), rst.getBoolean(16), rst.getBoolean(17), rst.getInt(18),rst.getInt(19), rst.getBoolean(20), rst.getBigDecimal(21), rst.getInt(22), rst.getShort(23), rst.getBigDecimal(24), rst.getShort(25), rst.getInt(26), rst.getInt(27), rst.getBigDecimal(28), rst.getBigDecimal(29),rst.getShort(30), rst.getBigDecimal(31), rst.getBigDecimal(32), rst.getInt(33), rst.getInt(34), rst.getBoolean(35), rst.getInt(36),rst.getString(37), rst.getBoolean(38), rst.getInt(39), rst.getString(40),rst.getString(41), rst.getBoolean(42), rst.getString(43), rst.getDate(45), rst.getString(44),rst.getDate(46),rst.getShort(47), rst.getString(49), rst.getDate(48));
                
//                bddt= new BnkDepDepositTypes(rst.getInt(0), rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6),  rst.getInt(7), rst.getInt(8), rst.getInt(9), rst.getShort(10), rst.getBigDecimal(11),  rst.getBigDecimal(12), rst.getBoolean(13), rst.getBoolean(14), rst.getBoolean(15), rst.getBoolean(16), rst.getInt(17),rst.getInt(18), rst.getBoolean(19), rst.getBigDecimal(20), rst.getInt(21), rst.getShort(22), rst.getBigDecimal(23), rst.getShort(24), rst.getInt(25), rst.getInt(26), rst.getBigDecimal(27), rst.getBigDecimal(28),rst.getShort(29), rst.getBigDecimal(30), rst.getBigDecimal(31), rst.getInt(32), rst.getInt(33), rst.getBoolean(34), rst.getInt(35),rst.getString(36), rst.getBoolean(37), rst.getInt(38), rst.getString(39),rst.getString(40), rst.getBoolean(41), rst.getString(42), rst.getDate(43), rst.getString(44),rst.getDate(45),rst.getShort(46), rst.getString(47), rst.getDate(48));
            }
            // String sql ="select * from BnkDepDepositTypes bd where bd.nDepTypeID="+nDepTypeID+"";

            // BnkDepDepositTypes bddt = (BnkDepDepositTypes) em.createNamedQuery("BnkDepDepositTypes.findByNDepTypeID").setParameter("nDepTypeID", nDepTypeID).getSingleResult();
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositTypesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bddt;
    }

    @Override
    public String getDepDepositCatagoryName(int nDepTypeID) {
        try {
            Connection connection = con.getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet resultSet = createStatement.executeQuery("SELECT cDepCategory FROM \n"
                    + "bnk_Dep_DepositCategory AS dc, bnk_Dep_DepositTypes AS dt\n"
                    + "where dt.nDepTypeID = " + nDepTypeID + "\n"
                    + "and\n"
                    + "dt.nDepCatID = dc.nDepCatID;");

            if (resultSet.next()) {
                return resultSet.getString("cDepCategory");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
