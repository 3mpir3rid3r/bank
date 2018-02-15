/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

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
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkCustomerMasterDaoLocalrLocal {

    List<BnkCustomerMaster> getCustomersView(int branchId, String Key);

    BnkCustomerMaster getCustomerDetails(int customerId);

    BnkCustomerMaster getBnkCustomerMaster(BigInteger nCustomerID);

    Long getBnkCustomerMasterCustomerIDByCIFNo(String cCIFNo);

    Long getBnkCustomerMasterCustomerIDByNICNo(String cNICNo);

    Long getBnkCustomerMasterCustomerIDByMemShipNo(String cMemberShipNo);

    List<BnkRefCustomerCategory> getBnkRefCustomerCategory();

    List<GenRefCustomerTittle> getGenRefCustomerTittle();

    List<GenRefNationality> getGenRefNationality();

    List<GenRefReligion> getGenRefReligion();

    List<BnkRefMemberAreas> getBnkRefMemberAreas();

    List<BnkRefMemberPosition> getBnkRefMemberPosition();

    List<BnkRefMemberStatus> getBnkRefMemberStatus();

    List<BnkRefMemberAreasGroups> getBnkRefMemberAreasGroups();

    List<GenRefCivilStatus> getGenRefCivilStatus();

    void saveNewCustomerMaster(BnkCustomerMaster bcm);

    BnkCustomerMaster getCustomerDetailsUsingID(long custId);

}
