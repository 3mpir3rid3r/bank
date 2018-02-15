/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkLonLoanCtegory;
import com.nbs.model.BnkLonLoanDeductType;
import com.nbs.model.BnkLonLoanDescriptions;
import com.nbs.model.BnkLonLoanFundSource;
import com.nbs.model.BnkLonLoanGroups;
import com.nbs.model.BnkLonLoanStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lasa
 */
@Local
public interface BnkLonLoanCtegoryDaoLocal {

    List<BnkLonLoanCtegory> getAllBnkLonLoanCtegory();
    
    List<BnkLonLoanGroups> getAllBnkLonLoanGroups();
    
    List<BnkLonLoanDeductType> getAllBnkLonLoanDeductType();
    
    List<BnkLonLoanFundSource> getAllBnkLonLoanFundSource();
    
    List<BnkLonLoanStatus> getAllBnkLonLoanStatus();
    
    List<BnkLonLoanDescriptions> getAllBnkLonLoanDescriptions();
    
}
