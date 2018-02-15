/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.ActJournalHD;
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
public class ActJournalHDDao implements ActJournalHDDaoLocal {
@PersistenceContext
private EntityManager em;
    
    @Override
    public List<ActJournalHD> getActJournalHD() {
        List<ActJournalHD> ajhds = new ArrayList<>();
        Query q = em.createNamedQuery("ActJournalHD.findAll",ActJournalHD.class);
        ajhds = q.getResultList();
        return ajhds;
    }

}
