/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.BnkLonLoanCtegory;
import com.nbs.model.BnkLonLoanDeductType;
import com.nbs.model.BnkLonLoanDescriptions;
import com.nbs.model.BnkLonLoanFundSource;
import com.nbs.model.BnkLonLoanGroups;
import com.nbs.model.BnkLonLoanStatus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lasa
 */
@Stateless
public class BnkLonLoanCtegoryDao implements BnkLonLoanCtegoryDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BnkLonLoanCtegory> getAllBnkLonLoanCtegory() {
        return em.createNamedQuery("BnkLonLoanCtegory.findAll").getResultList();
    }

    //    BnkLonLoanGroups getAll details;
    @Override
    public List<BnkLonLoanGroups> getAllBnkLonLoanGroups() {
        return em.createNamedQuery("BnkLonLoanGroups.findAll").getResultList();
    }

    //    BnkLonLoanDeductType getAll details;
    @Override
    public List<BnkLonLoanDeductType> getAllBnkLonLoanDeductType() {
        return em.createNamedQuery("BnkLonLoanDeductType.findAll").getResultList();
    }

    //    BnkLonLoanFundSource getAll details;
    @Override
    public List<BnkLonLoanFundSource> getAllBnkLonLoanFundSource() {
        return em.createNamedQuery("BnkLonLoanFundSource.findAll").getResultList();
    }

    //    BnkLonLoanStatus getAll details;
    @Override
    public List<BnkLonLoanStatus> getAllBnkLonLoanStatus() {
        return em.createNamedQuery("BnkLonLoanStatus.findAll").getResultList();
    }

    //    BnkLonLoanDescriptions getAll details;
    @Override
    public List<BnkLonLoanDescriptions> getAllBnkLonLoanDescriptions() {
        return em.createNamedQuery("BnkLonLoanDescriptions.findAll").getResultList();
    }

}
