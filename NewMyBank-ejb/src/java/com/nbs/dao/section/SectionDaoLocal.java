/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.dao.section;

import com.nbs.model.ActSectionsMain;
import com.nbs.model.ActSectionsSub;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmh
 */
@Local
public interface SectionDaoLocal {

    List<ActSectionsMain> getAllSection();

    boolean saveSection(ActSectionsMain sectionsMain);

    boolean saveSubSection(ActSectionsSub sectionsSub);

    List<ActSectionsSub> getSubSection(short id);

}
