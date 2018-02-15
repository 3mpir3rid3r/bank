/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkDepDepositCategory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkDepDepositCategoryDao implements BnkDepDepositCategoryDaoLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<BnkDepDepositCategory> getAllBnkDepDepositCategory() {
        return em.createNamedQuery("BnkDepDepositCategory.findAll").getResultList();
    }
    
   
}
