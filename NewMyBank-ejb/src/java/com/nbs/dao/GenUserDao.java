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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mmh
 */
@Stateless
public class GenUserDao implements GenUserDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public GenUser UserLogin(String userName, String password) throws javax.persistence.NoResultException {
        GenUser user = new GenUser();
        try {
            Query q = em.createNativeQuery("SELECT * FROM gen_User WHERE cUserName = ? AND cPassword = ?", GenUser.class);
            q.setParameter("1", userName);
            q.setParameter("2", password);
            q.setMaxResults(1);
            if (q != null) {
                
                System.out.println(q.getSingleResult()+"Hi Single result");
                user = (GenUser) q.getSingleResult();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public void saveUserActivities(GenUserActivities activities) {
        em.persist(activities);
    }

    @Override
    public void saveUserSession(GenUserSession genUserSession) {
        em.persist(genUserSession);
    }

    @Override
    public void updateUserSession(String sessionID) {
       Query q = em.createNativeQuery("UPDATE gen_User_Session SET dLogOutTime = NOW() where nSessionID = '"+sessionID+"'");
       q.executeUpdate();
       
    }

    @Override
    public ActSectionsSub getBranch(int branchId) {
        ActSectionsSub bankBranch =  em.find(ActSectionsSub.class, branchId);
        return bankBranch;
    }

    @Override
    public List<ActSectionsSub> getAllBranches() {
//        return em.createNamedQuery("BnkRefBankBranch.findAll",BnkRefBankBranch.class).getResultList();
    
        List<ActSectionsSub> br = new ArrayList<>();
        Query q = em.createNativeQuery("{call ssp_bnk_LoadCombo_ViewBranch(?,?)}", ActSectionsSub.class);
        q.setParameter(1, 1);
        q.setParameter(2, 0);
        
        br = q.getResultList();
        return br;
    
    }

}
