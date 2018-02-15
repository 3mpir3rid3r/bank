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
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.NoResultException;

/**
 *
 * @author mmh
 */
@Local
public interface BnkMemberMasterDaoLocal {

    List<BnkCustomerMaster> getCustomersView(int branchId, String Key) throws SQLException;

    BnkCustomerMaster getBnkCustomerMaster(BigInteger nCustomerID) throws SQLException;

    Long getBnkCustomerMasterCustomerIDByCIFNo(String cCIFNo) throws SQLException;

    Long getBnkCustomerMasterCustomerIDByNICNo(String cNICNo) throws SQLException;

    Long getBnkCustomerMasterCustomerIDByMemShipNo(String cMemberShipNo) throws SQLException;

    List<BnkRefCustomerCategory> getBnkRefCustomerCategory() throws SQLException;

    List<GenRefCustomerTittle> getGenRefCustomerTittle() throws SQLException;

    List<GenRefNationality> getGenRefNationality() throws SQLException;

    List<GenRefReligion> getGenRefReligion() throws SQLException;

    List<BnkRefMemberAreas> getBnkRefMemberAreas() throws SQLException;

    List<BnkRefMemberPosition> getBnkRefMemberPosition() throws SQLException;

    List<BnkRefMemberStatus> getBnkRefMemberStatus() throws SQLException;

    List<BnkRefMemberAreasGroups> getBnkRefMemberAreasGroups() throws SQLException;

    List<GenRefCivilStatus> getGenRefCivilStatus() throws SQLException;

    void saveNewCustomerMaster(BnkCustomerMaster bcm) throws SQLException;

    List<MemRefMemberShipStatus> getMemberShipPossition();

    long getLAstId();

    boolean saveNewMember(MemMemberShipMaster shipMaster);

    List<MemMemberShipMaster> getMembersView(String on, long areaId, String tip);
    MemMemberShipMaster searchMember(long id);

}
 