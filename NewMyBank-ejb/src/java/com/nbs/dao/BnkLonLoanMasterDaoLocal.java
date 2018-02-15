/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkLonLoanMaster;
import com.nbs.model.VFindDatabnkLonLoanMaster;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkLonLoanMasterDaoLocal {

    int insertBnkLonLoanMaster(BnkLonLoanMaster bllm);
    
    VFindDatabnkLonLoanMaster getAllBnkLonLoanMasterByNLonMFID(long nLonMFID);
    
    List<VFindDatabnkLonLoanMaster> getLoanMasterView(int branchId, String key);
    
    List<VFindDatabnkLonLoanMaster> getAllBnkLonLoanMaster(BigInteger nCustomerID);
    
    BigInteger getBnkLonLoanMasterCustID(String cLonAccountNo);
    
    long getBnkLonLoanMasterNLonMFID(String cLonAccountNo);
    
}
