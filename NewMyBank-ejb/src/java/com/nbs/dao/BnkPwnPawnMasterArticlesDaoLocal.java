/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkPwnPawnMaster;
import com.nbs.model.BnkPwnPawnMasterArticles;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface BnkPwnPawnMasterArticlesDaoLocal  {

    void saveBnkPwnPawnMasterArticles(List<BnkPwnPawnMasterArticles> articleses,BnkPwnPawnMaster bppm)throws SQLException,NullPointerException;
    
    List<BnkPwnPawnMasterArticles> getBnkPwnPawnMasterArticlesList(long nPwnMasterID);
}
