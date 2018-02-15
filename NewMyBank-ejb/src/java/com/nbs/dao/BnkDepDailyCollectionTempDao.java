/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkDepDailyCollectionTemp;
import com.nbs.model.GenUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mmh
 */
@Stateless
public class BnkDepDailyCollectionTempDao implements BnkDepDailyCollectionTempDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveDailyCollection(List<BnkDepDailyCollectionTemp> BnkDepDailyCollectionTemp) {
        try {
            for (int i = 0; i < BnkDepDailyCollectionTemp.size(); i++) {
                em.persist(BnkDepDailyCollectionTemp.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<BnkDepDailyCollectionTemp> getAll(GenUser genUser) {
        String userName = genUser.getCUserName();
        return em.createNativeQuery("SELECT * FROM bnk_Dep_DailyCollection_Temp  where cAddBy = ? ORDER BY dTrnDate ASC", BnkDepDailyCollectionTemp.class).setParameter(1, genUser.getCUserName()).getResultList();
        
    }

    @Override
    public void remveCollection(Long nTempDailiId) {
        BnkDepDailyCollectionTemp bddct1  = em.find(BnkDepDailyCollectionTemp.class, nTempDailiId);
        em.remove(bddct1);
    }   
}
