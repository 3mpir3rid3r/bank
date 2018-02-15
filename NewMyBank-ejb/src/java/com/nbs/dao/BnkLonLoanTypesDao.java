/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.common.BnkLonLoanCtegoryTypes;
import com.nbs.model.BnkLonLoanTypes;
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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkLonLoanTypesDao implements BnkLonLoanTypesDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertBnkLonLoanTypes(BnkLonLoanTypes bllt, String userName) throws SQLException {
        Connection connection = null;
        try {
            connection = con.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call ssp_bnk_Insert_Lon_LoanTypes(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?)}");

            callableStatement.setInt(1, bllt.getNLonTypeID());
            callableStatement.setString(2, bllt.getCSysCode());
            callableStatement.setInt(3, bllt.getNLonCatID());
            callableStatement.setString(4, bllt.getCLonName());
            callableStatement.setString(5, bllt.getCLonNameSin());
            callableStatement.setString(6, bllt.getCLonNameTamil());
            callableStatement.setInt(7, bllt.getNMinParticipant());
            callableStatement.setInt(8, bllt.getNMaxParticipant());
            callableStatement.setInt(9, bllt.getNMinAge());
            callableStatement.setInt(10, bllt.getNMaxAge());
            callableStatement.setBigDecimal(11, bllt.getNMinLonAmt());
            callableStatement.setBigDecimal(12, bllt.getNMaxLonAmt());
            callableStatement.setInt(13, bllt.getNMinMonths());
            callableStatement.setInt(14, bllt.getNMaxMonths());
            callableStatement.setBoolean(15, bllt.getBMultipleAcct());
            callableStatement.setBigDecimal(16, bllt.getNCurrentInt());
            callableStatement.setShort(17, bllt.getNLonInterestMethodID());
            callableStatement.setShort(18, bllt.getNIntCalMethodID());
            callableStatement.setInt(19, bllt.getNLoanIntRoundID());
            callableStatement.setBigDecimal(20, bllt.getNPenaltyIntRate());
            callableStatement.setInt(21, bllt.getNPenaltyIntRateForID());
            callableStatement.setInt(22, bllt.getNPenaltyIntCalAfter());
            callableStatement.setInt(23, bllt.getNPenaltyIntCalAfterID());//
            callableStatement.setInt(24, bllt.getNPenaltyIntOP1());
            callableStatement.setInt(25, bllt.getNPenaltyIntOP2());
            callableStatement.setInt(26, bllt.getNAcctLevelID4LoanCapital());
            callableStatement.setInt(27, bllt.getNAcctLevelID4Interest());
            callableStatement.setInt(28, bllt.getNAcctLevelID4Postage());
            callableStatement.setInt(29, bllt.getNAcctLevelID4Stationary());
            callableStatement.setInt(30, bllt.getNAcctLevelID4ArbitrationFees());
            callableStatement.setInt(31, bllt.getNAcctLevelID4LawFees());
            callableStatement.setInt(32, bllt.getNAcctLevelID4PenaltyInterest());
//            callableStatement.setInt(33, bllt.getNAcctLevelID5FreeInterest());
            callableStatement.setString(33, userName);
            callableStatement.setString(34, "@ioio");

            callableStatement.executeUpdate();

//            System.out.println("result ------------- " + callableStatement.getInt(35));
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<BnkLonLoanCtegoryTypes> getAllBnkLonLoanTypes() {
        return em.createNativeQuery("{call ssp_bnk_DisplayData_Lon_LoanTypes}", BnkLonLoanCtegoryTypes.class).getResultList();
    }

    @Override
    public BnkLonLoanTypes getAllBnkLonLoanTypes(int nLonTypeId) {
        try {
            BnkLonLoanTypes bllt = (BnkLonLoanTypes) em.createNamedQuery("BnkLonLoanTypes.findByNLonTypeID").setParameter("nLonTypeID", nLonTypeId).getSingleResult();
            return bllt;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public String getLonLoanCatogoryName(int nLonTypeID) {
        try {
            Connection connection = con.getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet resultSet = createStatement.executeQuery("SELECT cLonCategory FROM \n"
                    + "bnk_Lon_LoanCtegory AS lc, bnk_Lon_LoanTypes AS lt\n"
                    + "where lt.nLonTypeID = " + nLonTypeID + "\n"
                    + "and\n"
                    + "lt.nLonCatID = lc.nLonCatID;");

            if (resultSet.next()) {
                return resultSet.getString("cLonCategory");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
