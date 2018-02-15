/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkDepDepositMaster;
import com.nbs.model.VFindDatabnkDepDepositMaster;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkDepDepositMasterDaoLocal {

    int insertBnkDepDepositMaster(BnkDepDepositMaster bddm);

    List<VFindDatabnkDepDepositMaster> getBnkDepositMasterView(int branchId, String key);

    List<VFindDatabnkDepDepositMaster> getAllBnkDepDepositMaster(BigInteger nCustomerID);

    BigInteger getBnkDepDepositMasterCustID(String cOurAccountNo);

    long getBnkDepDepositMasterNDepMFID(String cOurAccountNo);

    VFindDatabnkDepDepositMaster getAllBnkDepDepositMasterByNDepMFID(long nDepMFID);

    BnkDepDepositMaster getBnkDepDepositMasterByNDepMFID(long nDepMFID);

}
