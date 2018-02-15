/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.common.BnkLonLoanCtegoryTypes;
import com.nbs.model.BnkLonLoanTypes;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lasa
 */
@Local
public interface BnkLonLoanTypesDaoLocal {

    List<BnkLonLoanCtegoryTypes> getAllBnkLonLoanTypes() ;

    void insertBnkLonLoanTypes(BnkLonLoanTypes bllt,String userName) throws SQLException;

    BnkLonLoanTypes getAllBnkLonLoanTypes(int nLonTypeId);
    
    String getLonLoanCatogoryName(int nLonTypeID);
    
}
