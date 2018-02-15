/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao.section;

import com.nbs.model.ActSectionsMain;
import com.nbs.model.ActSectionsSub;
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
public class SectionDao implements SectionDaoLocal {

    @PersistenceContext(unitName = "NewMyBank-ejbPU")
    private EntityManager em;

    @Override
    public List<ActSectionsMain> getAllSection() {
        String jpql = "select s from ActSectionsMain s";
        Query createQuery = em.createQuery(jpql);
        List<ActSectionsMain> actSectionsMains = createQuery.getResultList();
        return actSectionsMains;
    }

    @Override
    public boolean saveSection(ActSectionsMain sectionsMain) {
        em.merge(sectionsMain);
        return true;
    }

    

    @Override
    public List<ActSectionsSub> getSubSection(short id) {
        String jpql = "select s from ActSectionsSub s where s.nMainSectionID=:id";
        Query createQuery = em.createQuery(jpql);
        createQuery.setParameter("id", id);
        List<ActSectionsSub> actSectionsSubs = createQuery.getResultList();
        return actSectionsSubs;
    }

    @Override
    public boolean saveSubSection(ActSectionsSub sectionsSub) {
        em.merge(sectionsSub);
        return true;
    }
}
