/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao.member;

import com.nbs.dao.*;
import com.nbs.model.BnkCustomerMaster;
import com.nbs.model.BnkRefCustomerCategory;
import com.nbs.model.BnkRefMemberAreas;
import com.nbs.model.BnkRefMemberAreasGroups;
import com.nbs.model.BnkRefMemberPosition;
import com.nbs.model.BnkRefMemberStatus;
import com.nbs.model.GenRefCivilStatus;
import com.nbs.model.GenRefCustomerTittle;
import com.nbs.model.GenRefNationality;
import com.nbs.model.GenRefReligion;
import com.nbs.model.MemMemberShipMaster;
import com.nbs.model.MemRefMemberShipStatus;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.nbs.model.common.JDBC;
import java.sql.Date;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author mmh
 */
@Stateless
public class BnkMemberMasterDao implements BnkMemberMasterDaoLocal {

    @Resource(name = "con")
    private DataSource con;

    @PersistenceContext
    private EntityManager em;

    private JDBC jdbc = new JDBC();

    @Override
    public List<BnkCustomerMaster> getCustomersView(int branchId, String key) {
        List<BnkCustomerMaster> bcms = new ArrayList<>();
        try {
            Query q = em.createNativeQuery("{call ssp_bnk_FindData_CustomerMaster(?,?)}", BnkCustomerMaster.class);
            q.setParameter(1, branchId);
            q.setParameter(2, key);
            bcms = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bcms;
    }

    //  @Override
    public BnkCustomerMaster getBnkCustomerMaster(int customerId) throws ClassNotFoundException, SQLException {
      
        BnkCustomerMaster bcm = new BnkCustomerMaster();
        Connection connection = jdbc.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call ssp_bnk_DisplayData_CustomerMaster(?)}");
            callableStatement.setInt(1, customerId);
            callableStatement.executeQuery();
            ResultSet rs = callableStatement.getResultSet();
            if (rs.next()) {
                bcm.setNCustomerID(rs.getLong(1));
                bcm.setNSubSectionID(rs.getInt(2));
                bcm.setNCustomerCategoryID(rs.getShort(3));
                bcm.setNCustomerStatusID(rs.getShort(4));
                bcm.setNTitleID(rs.getShort(5));
                bcm.setCCIFNo(rs.getString(6));
                bcm.setCCIFNoOld(rs.getString(7));
                bcm.setCInitials(rs.getString(8));
                bcm.setCFullName(rs.getString(9));
                bcm.setCFullNameAma(rs.getString(10));
                bcm.setCLastName(rs.getString(11));
                bcm.setCUseName(rs.getString(12));
                bcm.setBFeMale(rs.getBoolean(13));
                bcm.setNIDTypeID(rs.getShort(14));
                bcm.setCNICNo(rs.getString(15));
                bcm.setDNICIssuedDate(rs.getDate(16));
                bcm.setDDateOfBirth(rs.getDate(17));
                bcm.setDJoineDate(rs.getDate(18));
                bcm.setCMotherMadName(rs.getString(19));
                bcm.setNNationalityID(rs.getShort(20));
                bcm.setNReligionID(rs.getShort(21));
                bcm.setNCivilStatusID(rs.getShort(22));
                bcm.setCPAddLine1(rs.getString(23));
                bcm.setCPAddLine2(rs.getString(24));
                bcm.setCPAddLine3(rs.getString(25));
                bcm.setCPAddLine4(rs.getString(26));
                bcm.setCBAddLine1(rs.getString(27));
                bcm.setCBAddLine2(rs.getString(28));
                bcm.setCBAddLine3(rs.getString(29));
                bcm.setCBAddLine4(rs.getString(30));
                bcm.setCPTelNo1(rs.getString(31));
                bcm.setCPTelNo2(rs.getString(32));
                bcm.setCBTelNo1(rs.getString(33));
                bcm.setCBTelNo2(rs.getString(34));
                bcm.setCPEmail(rs.getString(35));
                bcm.setCBEmail(rs.getString(36));
                bcm.setCMemberShipNo(rs.getString(37));
                bcm.setDMemberShipDate(rs.getDate(38));
                bcm.setNMemAreaID(rs.getShort(39));
                bcm.setNMemAreaGroupID(rs.getShort(40));
                bcm.setNMemStatusID(rs.getShort(41));
                bcm.setNMemPositionID(rs.getShort(42));
                bcm.setNMemberShipFee(rs.getBigDecimal(43));
                bcm.setCPictureFileName(rs.getString(44));
                bcm.setCSignatureFileName(rs.getString(45));
                bcm.setCSigPath2(rs.getString(46));
                bcm.setCSigPath3(rs.getString(47));

//                0720742372
//                Query q = em.createNamedQuery("BnkCustomerMaster.findByNBankBranchID",BnkCustomerMaster.class);
//                q.setParameter("nBankBranchID", customerId);
//                List l =  q.getResultList();
//                System.out.println(l+"]]]]]]]]]]]]]]]]]]]]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkMemberMasterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bcm;
    }

    @Override
    public BnkCustomerMaster getBnkCustomerMaster(BigInteger nCustomerID) {
        BnkCustomerMaster bnkCustomerMaster = (BnkCustomerMaster) em.createNamedQuery("BnkCustomerMaster.findByNCustomerID").setParameter("nCustomerID", nCustomerID).getSingleResult();
        return bnkCustomerMaster;
    }

    @Override
    public Long getBnkCustomerMasterCustomerIDByCIFNo(String cCIFNo) {
        try {
            Connection connection = con.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nCustomerID FROM bnk_CustomerMaster WHERE cCIFNo =" + cCIFNo);
            if (rs.next()) {
                Long l = rs.getLong("nCustomerID");
                return l;
            } else {
                return 0L;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0L;
        }
    }

    @Override
    public Long getBnkCustomerMasterCustomerIDByNICNo(String cNICNo) {
        try {
            Connection connection = con.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nCustomerID FROM bnk_CustomerMaster WHERE cNICNo =" + cNICNo);
            if (rs.next()) {
                Long l = rs.getLong("nCustomerID");
                return l;
            } else {
                return 0L;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0L;
        }
    }

    @Override
    public Long getBnkCustomerMasterCustomerIDByMemShipNo(String cMemberShipNo) {
        try {
            Connection connection = con.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nCustomerID FROM bnk_CustomerMaster WHERE cNICNo =" + cMemberShipNo);
            if (rs.next()) {
                Long l = rs.getLong("nCustomerID");
                return l;
            } else {
                return 0L;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BnkDepDepositMasterDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0L;
        }
    }

    @Override
    public List<BnkRefCustomerCategory> getBnkRefCustomerCategory() {
        return em.createNamedQuery("BnkRefCustomerCategory.findByCCode", BnkRefCustomerCategory.class).setParameter("cCode", "p").getResultList();
    }

    @Override
    public List<GenRefCustomerTittle> getGenRefCustomerTittle() {
        return em.createNamedQuery("GenRefCustomerTittle.findAll", GenRefCustomerTittle.class).getResultList();
    }

    @Override
    public List<GenRefNationality> getGenRefNationality() {
        return em.createNamedQuery("GenRefNationality.findAll", GenRefNationality.class).getResultList();
    }

    @Override
    public List<GenRefReligion> getGenRefReligion() {
        return em.createNamedQuery("GenRefReligion.findAll", GenRefReligion.class).getResultList();
    }

    @Override
    public List<BnkRefMemberAreas> getBnkRefMemberAreas() {
        return em.createNamedQuery("BnkRefMemberAreas.findAll", BnkRefMemberAreas.class).getResultList();
    }

    @Override
    public List<BnkRefMemberPosition> getBnkRefMemberPosition() {
        return em.createNamedQuery("BnkRefMemberPosition.findAll", BnkRefMemberPosition.class).getResultList();
    }

    @Override
    public List<BnkRefMemberStatus> getBnkRefMemberStatus() {
        return em.createNamedQuery("BnkRefMemberStatus.findAll", BnkRefMemberStatus.class).getResultList();
    }

    @Override
    public List<BnkRefMemberAreasGroups> getBnkRefMemberAreasGroups() {
        return em.createNamedQuery("BnkRefMemberAreasGroups.findAll", BnkRefMemberAreasGroups.class).getResultList();
    }

    @Override
    public List<GenRefCivilStatus> getGenRefCivilStatus() {
        return em.createNamedQuery("GenRefCivilStatus.findAll", GenRefCivilStatus.class).getResultList();
    }

    @Override
    public void saveNewCustomerMaster(BnkCustomerMaster bcm) {
        System.out.println(bcm.getNMemPositionID()+"id");
        try {
            CallableStatement callableStatement = con.getConnection().prepareCall("{call ssp_bnk_Insert_CustomerMaster(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?)}");

            callableStatement.setLong(1, bcm.getNCustomerID());
            callableStatement.setInt(2, bcm.getNSubSectionID());
            callableStatement.setShort(3, bcm.getNCustomerCategoryID());
//        callableStatement.setString(3, "1");
            callableStatement.setShort(4, bcm.getNCustomerStatusID());
//        callableStatement.setString(4, "1");
            callableStatement.setShort(5, bcm.getNTitleID());
//        callableStatement.setString(5, "1");
            callableStatement.setString(6, bcm.getCCIFNo());
            callableStatement.setString(7, "");
            callableStatement.setString(8, bcm.getCInitials());
            callableStatement.setString(9, bcm.getCFullName());
            callableStatement.setString(10, bcm.getCFullName());

            callableStatement.setString(11, bcm.getCLastName());
            callableStatement.setString(12, bcm.getCUseName());
            callableStatement.setBoolean(13, bcm.getBFeMale());
//        callableStatement.setString(13, "1");
            callableStatement.setString(14, "1");
            callableStatement.setString(15, bcm.getCNICNo());
            callableStatement.setDate(16, (Date) bcm.getDNICIssuedDate());
            callableStatement.setDate(17, (Date) bcm.getDDateOfBirth());
            callableStatement.setDate(18, (Date) bcm.getDJoineDate());
//        callableStatement.setString(16, "2012-10-10");
//        callableStatement.setString(17, "2012-10-10");
//        callableStatement.setString(18, "2012-10-10");
            callableStatement.setString(19, bcm.getCMotherMadName());
            callableStatement.setInt(20, bcm.getNNationalityID());
//        callableStatement.setString(20, "1");

            callableStatement.setInt(21, bcm.getNReligionID());
//        callableStatement.setString(21, "1");
            callableStatement.setInt(22, bcm.getNCivilStatusID());
//        callableStatement.setString(22, "1");
            callableStatement.setString(23, bcm.getCPAddLine1());
            callableStatement.setString(24, bcm.getCPAddLine2());
            callableStatement.setString(25, bcm.getCPAddLine3());
            callableStatement.setString(26, bcm.getCPAddLine4());
            callableStatement.setString(27, bcm.getCBAddLine1());
            callableStatement.setString(28, bcm.getCBAddLine2());
            callableStatement.setString(29, bcm.getCBAddLine3());
            callableStatement.setString(30, bcm.getCBAddLine4());

            callableStatement.setString(31, bcm.getCPTelNo1());
            callableStatement.setString(32, "");
            callableStatement.setString(33, bcm.getCBTelNo1());
            callableStatement.setString(34, "");
            callableStatement.setString(35, bcm.getCPEmail());
            callableStatement.setString(36, bcm.getCBEmail());
            callableStatement.setString(37, bcm.getCMemberShipNo());
            //callableStatement.setString(38, member_date);
            callableStatement.setDate(38, (Date) bcm.getDMemberShipDate());
            callableStatement.setShort(39, bcm.getNMemAreaID());
//        callableStatement.setString(39, "1");
            callableStatement.setInt(40, bcm.getNMemAreaGroupID());
//        callableStatement.setString(40, "1");

            callableStatement.setShort(41, bcm.getNMemStatusID());
//        callableStatement.setString(41, "1");
            callableStatement.setShort(42, bcm.getNMemPositionID());
//        callableStatement.setString(42, "1");
            callableStatement.setBigDecimal(43, bcm.getNMemberShipFee());
            callableStatement.setString(44, "");
            callableStatement.setString(45, "");
            callableStatement.setString(46, "");
            callableStatement.setString(47, "");
            callableStatement.setString(48, "");

            callableStatement.executeQuery();
            System.out.println("result -------------" + callableStatement.getInt(49));
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public List<MemRefMemberShipStatus> getMemberShipPossition() {

        List<MemRefMemberShipStatus> mrmsses = null;

        String jpql = "select ms from MemRefMemberShipStatus ms";
        Query createQuery = em.createQuery(jpql);
        mrmsses = createQuery.getResultList();

        return mrmsses;
    }

    @Override
    public boolean saveNewMember(MemMemberShipMaster shipMaster) {
   
        // String out="@out";
        // String spq ="{call ssp_bnk_Insert_MemberMaster("+shipMaster.getNMemberID()+","+shipMaster.getNTitleID()+",'"+shipMaster.getCInitials()+"','"+shipMaster.getCFullName()+"','"+shipMaster.getCFullNameAma()+"','"+shipMaster.getCLastName()+"','"+shipMaster.getCUseName()+"','"+shipMaster.getBFeMale()+"',"+shipMaster.getNIDTypeID()+",'"+shipMaster.getCNICNo()+"',"+shipMaster.getDNICIssuedDate()+","+shipMaster.getDDateOfBirth()+","+shipMaster.getDJoineDate()+",'"+shipMaster.getCMotherMadName()+"',"+shipMaster.getNNationalityID()+","+shipMaster.getNReligionID()+","+shipMaster.getNCivilStatusID()+",'"+shipMaster.getCPAddLine1()+"','"+shipMaster.getCPAddLine2()+"','"+shipMaster.getCPAddLine3()+"','"+shipMaster.getCPAddLine4()+"','"+shipMaster.getCBAddLine1()+"','"+shipMaster.getCBAddLine2()+"','"+shipMaster.getCBAddLine3()+"','"+shipMaster.getCBAddLine4()+"','"+shipMaster.getCPTelNo1()+"','"+shipMaster.getCPTelNo2()+"','"+shipMaster.getCBTelNo1()+"','"+shipMaster.getCBTelNo2()+"','"+shipMaster.getCPTelNo1()+"','"+shipMaster.getCBTelNo2()+"','"+shipMaster.getCMemberShipNo()+"',"+shipMaster.getDMemberShipDate()+","+shipMaster.getNMemAreaID()+","+shipMaster.getNMemAreaGroupID()+","+shipMaster.getNCivilStatusID()+","+shipMaster.getNMemPositionID()+","+shipMaster.getNMemberShipFee()+",'"+shipMaster.getCPictureFileName()+"','"+shipMaster.getCSignatureFileName()+"','"+shipMaster.getCSigPath2()+"','"+shipMaster.getCSigPath3()+"','"+shipMaster.getCUseName()+"',&Out)}";
        String spq = "{call ssp_mem_Insert_MemberMaster(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //"{call ssp_bnk_Insert_CustomerMaster(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?)}
        if (shipMaster.getNMemberID() == 0) {
            shipMaster.setNMemberID(getLAstId());
        }
        long returnNo = 0;
        Connection connection = jdbc.getConnection();
        try {
            CallableStatement prepareCall = connection.prepareCall(spq);
            prepareCall.setLong(1, shipMaster.getNMemberID());
            prepareCall.setInt(2, shipMaster.getNTitleID());
            prepareCall.setString(3, shipMaster.getCInitials());
            prepareCall.setString(4, shipMaster.getCFullName());
            prepareCall.setString(5, shipMaster.getCFullNameAma());
            prepareCall.setString(6, shipMaster.getCLastName());
            prepareCall.setString(7, shipMaster.getCUseName());
            prepareCall.setBoolean(8, shipMaster.getBFeMale());
            prepareCall.setInt(9, shipMaster.getNIDTypeID());
            prepareCall.setString(10, shipMaster.getCNICNo());
            prepareCall.setDate(11, (Date) shipMaster.getDNICIssuedDate());
            prepareCall.setDate(12, (Date) shipMaster.getDDateOfBirth());
            prepareCall.setDate(13, (Date) shipMaster.getDJoineDate());
            prepareCall.setString(14, shipMaster.getCMotherMadName());
            prepareCall.setInt(15, shipMaster.getNNationalityID());
            prepareCall.setInt(16, shipMaster.getNReligionID());
            prepareCall.setInt(17, shipMaster.getNCivilStatusID());
            prepareCall.setString(18, shipMaster.getCPAddLine1());
            prepareCall.setString(19, shipMaster.getCPAddLine2());
            prepareCall.setString(20, shipMaster.getCPAddLine3());
            prepareCall.setString(21, shipMaster.getCPAddLine4());
            prepareCall.setString(22, shipMaster.getCBAddLine1());
            prepareCall.setString(23, shipMaster.getCBAddLine2());
            prepareCall.setString(24, shipMaster.getCBAddLine3());
            prepareCall.setString(25, shipMaster.getCBAddLine4());
            prepareCall.setString(26, shipMaster.getCPTelNo1());
            prepareCall.setString(27, shipMaster.getCPTelNo2());
            prepareCall.setString(28, shipMaster.getCBTelNo1());
            prepareCall.setString(29, shipMaster.getCBTelNo2());
            prepareCall.setString(30, shipMaster.getCPEmail());
            prepareCall.setString(31, shipMaster.getCBEmail());
            prepareCall.setString(32, shipMaster.getCMemberShipNo());

            prepareCall.setDate(33, (Date) shipMaster.getDMemberShipDate());
            prepareCall.setShort(34, shipMaster.getNMemAreaID());
            prepareCall.setInt(35, shipMaster.getNMemAreaGroupID());
            prepareCall.setShort(36, shipMaster.getNCivilStatusID());
            prepareCall.setShort(37, shipMaster.getNMemPositionID());
            prepareCall.setBigDecimal(38, shipMaster.getNMemberShipFee());
            prepareCall.setString(39, shipMaster.getCPictureFileName());
            prepareCall.setString(40, shipMaster.getCSignatureFileName());
            prepareCall.setString(41, shipMaster.getCSigPath2());
            prepareCall.setString(42, shipMaster.getCSigPath3());
            prepareCall.setString(43, shipMaster.getCUseName());
            prepareCall.setString(44, shipMaster.getCOcupation());
            prepareCall.setInt(45, shipMaster.getNNoOfShares());
            
            //prepareCall.setString(44, );
            prepareCall.executeQuery();
            returnNo = prepareCall.getInt(46);

        } catch (SQLException ex) {
            Logger.getLogger(BnkMemberMasterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    @Override
    public long getLAstId() {

        Query createQuery = em.createQuery("select m.nMemberID from MemMemberShipMaster m order by m.nMemberID desc");
        // createQuery.setMaxResults(100);
        Query setMaxResults = createQuery.setMaxResults(1);
        long id = (long) setMaxResults.getSingleResult();

        ++id;
    
        return id;
    }

    @Override
    public List<MemMemberShipMaster> getMembersView(String on, long areaId, String tip) {
     
        List<MemMemberShipMaster> masters = new ArrayList<>();
        Connection connection = jdbc.getConnection();
        try {

            if ("on".equals(on) & tip.length() > 0 & areaId > -1) {
           
                String ssp = "{call ssp_bnk_FindData_MemberMaster(?,?)}";
                CallableStatement prepareCall = connection.prepareCall(ssp);

                prepareCall.setShort(1, (short) -1);
                prepareCall.setString(2, tip);
                prepareCall.executeQuery();

                ResultSet resultSet = prepareCall.getResultSet();
                while (resultSet.next()) {
                    
                    MemMemberShipMaster master = new MemMemberShipMaster();

                    master.setNMemberID(resultSet.getLong(1));
                    master.setCFullName(resultSet.getString(2));
                    master.setCFullNameAma(resultSet.getString(3));
                    master.setCPAddLine1(resultSet.getString(4));
                    master.setCPAddLine2(resultSet.getString(5));
                    master.setCPAddLine3(resultSet.getString(6));
                    master.setCPAddLine4(resultSet.getString(7));
                    master.setCNICNo(resultSet.getString(8));
                    masters.add(master);

                }

            } else if ("on".equals(on) & tip.length() == 0 & areaId > -1) {
                
                String jpql = "select m from MemMemberShipMaster m where m.nMemAreaID=:areaId";
                Query createQuery = em.createQuery(jpql);
                createQuery.setParameter("areaId", areaId);
                masters = createQuery.getResultList();

            } else if ("on".equals(on) & tip.length() > 0 & areaId == -1) {
            
                String ssp = "{call ssp_bnk_FindData_MemberMaster(?,?)}";
                CallableStatement prepareCall = connection.prepareCall(ssp);

                prepareCall.setShort(1, (short) -1);
                prepareCall.setString(2, tip);
                prepareCall.executeQuery();

                ResultSet resultSet = prepareCall.getResultSet();
                while (resultSet.next()) {
                  
                    MemMemberShipMaster master = new MemMemberShipMaster();

                    master.setNMemberID(resultSet.getLong(1));
                    master.setCFullName(resultSet.getString(2));
                    master.setCFullNameAma(resultSet.getString(3));
                    master.setCPAddLine1(resultSet.getString(4));
                    master.setCPAddLine2(resultSet.getString(5));
                    master.setCPAddLine3(resultSet.getString(6));
                    master.setCPAddLine4(resultSet.getString(7));
                    master.setCNICNo(resultSet.getString(8));
                    masters.add(master);
                }

            } else if ("on".equals(on) & tip.length() == 0 & areaId == -1) {
           
                String jpql = "select m from MemMemberShipMaster m";
                Query createQuery = em.createQuery(jpql);
                masters = createQuery.getResultList();

            } else if (!"on".equals(on) & tip.length() > 0 & areaId > -1) {

              
                String ssp = "{call ssp_bnk_FindData_MemberMaster(?,?)}";
                CallableStatement prepareCall = connection.prepareCall(ssp);

                prepareCall.setShort(1, (short) areaId);
                prepareCall.setString(2, tip);
                prepareCall.executeQuery();

                ResultSet resultSet = prepareCall.getResultSet();
                while (resultSet.next()) {
                   
                    MemMemberShipMaster master = new MemMemberShipMaster();

                    master.setNMemberID(resultSet.getLong(1));
                    master.setCFullName(resultSet.getString(2));
                    master.setCFullNameAma(resultSet.getString(3));
                    master.setCPAddLine1(resultSet.getString(4));
                    master.setCPAddLine2(resultSet.getString(5));
                    master.setCPAddLine3(resultSet.getString(6));
                    master.setCPAddLine4(resultSet.getString(7));
                    master.setCNICNo(resultSet.getString(8));
                    masters.add(master);

                }

            } else if (!"on".equals(on) & tip.length() > 0 & areaId == -1) {
                

                CallableStatement prepareCall = connection.prepareCall("{call ssp_bnk_FindData_MemberMaster(?,?)}");

                prepareCall.setShort(1, (short) -1);
                prepareCall.setString(2, tip);
                prepareCall.executeQuery();

                ResultSet resultSet = prepareCall.getResultSet();
                while (resultSet.next()) {
                
                    MemMemberShipMaster master = new MemMemberShipMaster();

                    master.setNMemberID(resultSet.getLong(1));
                    master.setCFullName(resultSet.getString(2));
                    master.setCFullNameAma(resultSet.getString(3));
                    master.setCPAddLine1(resultSet.getString(4));
                    master.setCPAddLine2(resultSet.getString(5));
                    master.setCPAddLine3(resultSet.getString(6));
                    master.setCPAddLine4(resultSet.getString(7));
                    master.setCNICNo(resultSet.getString(8));
                    masters.add(master);
                }
            } else if (!"on".equals(on) & tip.length() == 0 & areaId > -1) {
              
                String ssp = "{call ssp_bnk_FindData_MemberMaster(?,?)}";
                CallableStatement prepareCall = connection.prepareCall(ssp);

                prepareCall.setShort(1, (short) areaId);
                prepareCall.setString(2, tip);
                prepareCall.executeQuery();

                ResultSet resultSet = prepareCall.getResultSet();
                while (resultSet.next()) {
                 
                    MemMemberShipMaster master = new MemMemberShipMaster();

                    master.setNMemberID(resultSet.getLong(1));
                    master.setCFullName(resultSet.getString(2));
                    master.setCFullNameAma(resultSet.getString(3));
                    master.setCPAddLine1(resultSet.getString(4));
                    master.setCPAddLine2(resultSet.getString(5));
                    master.setCPAddLine3(resultSet.getString(6));
                    master.setCPAddLine4(resultSet.getString(7));
                    master.setCNICNo(resultSet.getString(8));
                    masters.add(master);
                }
            } else if (!"on".equals(on) & tip.length() == 0 & areaId == -1) {
               
                String jpql = "select m from MemMemberShipMaster m";
                Query createQuery = em.createQuery(jpql);
                masters = createQuery.getResultList();
            } else {
             
                String jpql = "select m from MemMemberShipMaster m";
                Query createQuery = em.createQuery(jpql);
                masters = createQuery.getResultList();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BnkMemberMasterDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return masters;
    }

    @Override
    public MemMemberShipMaster searchMember(long id) {

        return em.find(MemMemberShipMaster.class, id);
    }

}
