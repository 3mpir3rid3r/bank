/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkLonLoanGurantor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkLonLoanGurantorDao implements BnkLonLoanGurantorDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertBnkLonLoanGurantor(List<BnkLonLoanGurantor> bllgs) {
       // EntityTransaction transaction = em.getTransaction();
        //transaction.begin();
        for (BnkLonLoanGurantor bllg : bllgs) {
            em.persist(bllg);
        }
        //transaction.commit();

    }

}
