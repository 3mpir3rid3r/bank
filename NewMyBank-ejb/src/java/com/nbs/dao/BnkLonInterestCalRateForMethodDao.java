/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkLonInterestMethod;
import com.nbs.model.BnkLonPenaltyIntCalFor;
import com.nbs.model.BnkLonPenaltyIntRateFor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkLonInterestCalRateForMethodDao implements BnkLonInterestCalRateForMethodDaoLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<BnkLonInterestMethod> getAllBnkLonInterestMethod() {
        return em.createNamedQuery("BnkLonInterestMethod.findAll").getResultList();
    }
    
    @Override
    public List<BnkLonPenaltyIntCalFor> getAllBnkLonPenaltyIntCalFor() {
        return em.createNamedQuery("BnkLonPenaltyIntCalFor.findAll").getResultList();
    }

    @Override
    public List<BnkLonPenaltyIntRateFor> getAllBnkLonPenaltyIntRateFor() {
        return em.createNamedQuery("BnkLonPenaltyIntRateFor.findAll").getResultList();
    }
    
    
}
