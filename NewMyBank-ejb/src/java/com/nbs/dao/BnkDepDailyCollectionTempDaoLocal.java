/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkDepDailyCollectionTemp;
import java.util.List;
import javax.ejb.Local;
import com.nbs.model.GenUser;

/**
 *
 * @author mmh
 */
@Local
public interface BnkDepDailyCollectionTempDaoLocal {

    void saveDailyCollection(List<BnkDepDailyCollectionTemp> BnkDepDailyCollectionTemp);
    
    List<BnkDepDailyCollectionTemp> getAll(GenUser genUser);
    
    void remveCollection(Long nTempDailiId);
}
