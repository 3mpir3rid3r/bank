/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.ActSectionsSub;
import com.nbs.model.BnkRefBankBranch;
import com.nbs.model.GenUser;
import com.nbs.model.GenUserActivities;
import com.nbs.model.GenUserSession;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface GenUserDaoLocal {

    GenUser UserLogin(String userName, String password);
    
    void saveUserActivities(GenUserActivities activities);
    
    void saveUserSession(GenUserSession genUserSession);
    
    void updateUserSession(String sessionId);
    
    ActSectionsSub getBranch(int branchId);

    List<ActSectionsSub> getAllBranches();
}
