/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkLonLoanTransactions;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkLonLoanTransactionsDaoLocal {
    
    void insertBnkLonLoanTransactions(BnkLonLoanTransactions bllt);
    
}
