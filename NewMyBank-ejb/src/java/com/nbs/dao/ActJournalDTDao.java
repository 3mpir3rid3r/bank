/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao;

import com.nbs.model.ActJournalDT;
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
public class ActJournalDTDao implements ActJournalDTDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ActJournalDT> getActJournalDT() {

        try {
            List<ActJournalDT> ajdts = new ArrayList<>();
            Query q = em.createNamedQuery("ActJournalDT.findAll", ActJournalDT.class);
            ajdts = q.getResultList();
            return ajdts;
        } finally {
            em.close();
        }

    }
}
