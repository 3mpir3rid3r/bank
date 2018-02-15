/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "Act_Sections_Main")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActSectionsMain.findAll", query = "SELECT a FROM ActSectionsMain a"),
    @NamedQuery(name = "ActSectionsMain.findByNMainSectionID", query = "SELECT a FROM ActSectionsMain a WHERE a.nMainSectionID = :nMainSectionID"),
    @NamedQuery(name = "ActSectionsMain.findByCMainSectionName", query = "SELECT a FROM ActSectionsMain a WHERE a.cMainSectionName = :cMainSectionName"),
    @NamedQuery(name = "ActSectionsMain.findByNSupperGroupID", query = "SELECT a FROM ActSectionsMain a WHERE a.nSupperGroupID = :nSupperGroupID"),
    @NamedQuery(name = "ActSectionsMain.findByCSupperGroupName", query = "SELECT a FROM ActSectionsMain a WHERE a.cSupperGroupName = :cSupperGroupName"),
    @NamedQuery(name = "ActSectionsMain.findByCMainSectionNameEng", query = "SELECT a FROM ActSectionsMain a WHERE a.cMainSectionNameEng = :cMainSectionNameEng")})
public class ActSectionsMain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nMainSectionID")
    private Short nMainSectionID;
    @Size(max = 50)
    @Column(name = "cMainSectionName")
    private String cMainSectionName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nSupperGroupID")
    private short nSupperGroupID;
    @Size(max = 50)
    @Column(name = "cSupperGroupName")
    private String cSupperGroupName;
    @Size(max = 50)
    @Column(name = "cMainSectionNameEng")
    private String cMainSectionNameEng;

    public ActSectionsMain() {
    }

    public ActSectionsMain(Short nMainSectionID) {
        this.nMainSectionID = nMainSectionID;
    }

    public ActSectionsMain(Short nMainSectionID, short nSupperGroupID) {
        this.nMainSectionID = nMainSectionID;
        this.nSupperGroupID = nSupperGroupID;
    }

    public Short getNMainSectionID() {
        return nMainSectionID;
    }

    public void setNMainSectionID(Short nMainSectionID) {
        this.nMainSectionID = nMainSectionID;
    }

    public String getCMainSectionName() {
        return cMainSectionName;
    }

    public void setCMainSectionName(String cMainSectionName) {
        this.cMainSectionName = cMainSectionName;
    }

    public short getNSupperGroupID() {
        return nSupperGroupID;
    }

    public void setNSupperGroupID(short nSupperGroupID) {
        this.nSupperGroupID = nSupperGroupID;
    }

    public String getCSupperGroupName() {
        return cSupperGroupName;
    }

    public void setCSupperGroupName(String cSupperGroupName) {
        this.cSupperGroupName = cSupperGroupName;
    }

    public String getCMainSectionNameEng() {
        return cMainSectionNameEng;
    }

    public void setCMainSectionNameEng(String cMainSectionNameEng) {
        this.cMainSectionNameEng = cMainSectionNameEng;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMainSectionID != null ? nMainSectionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActSectionsMain)) {
            return false;
        }
        ActSectionsMain other = (ActSectionsMain) object;
        if ((this.nMainSectionID == null && other.nMainSectionID != null) || (this.nMainSectionID != null && !this.nMainSectionID.equals(other.nMainSectionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActSectionsMain[ nMainSectionID=" + nMainSectionID + " ]";
    }
    
}
