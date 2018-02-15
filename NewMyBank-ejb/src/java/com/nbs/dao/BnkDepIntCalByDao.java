/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkDepIntCalBy;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkDepIntCalByDao implements BnkDepIntCalByDaoLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<BnkDepIntCalBy> getAllBnkDepIntCalBy() {
        return em.createNamedQuery("BnkDepIntCalBy.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
