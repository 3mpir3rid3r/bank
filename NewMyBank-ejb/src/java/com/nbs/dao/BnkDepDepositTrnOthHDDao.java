/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkDepDepositTrnOthHD;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mmh
 */
@Stateless
public class BnkDepDepositTrnOthHDDao implements BnkDepDepositTrnOthHDDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveBnkDepDepositTrnOthHD(BnkDepDepositTrnOthHD bddtohdd) {
        em.persist(bddtohdd);
    }

}
