/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkDepDepositTrnOthHD;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkDepDepositTrnOthHDDaoLocal {
    
    void saveBnkDepDepositTrnOthHD(BnkDepDepositTrnOthHD bddtohdd);
}
