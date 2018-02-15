/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_User_Module_Type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUserModuleType.findAll", query = "SELECT g FROM GenUserModuleType g"),
    @NamedQuery(name = "GenUserModuleType.findByNGenUserModuleTypeID", query = "SELECT g FROM GenUserModuleType g WHERE g.nGenUserModuleTypeID = :nGenUserModuleTypeID"),
    @NamedQuery(name = "GenUserModuleType.findByCGenUserModuleName", query = "SELECT g FROM GenUserModuleType g WHERE g.cGenUserModuleName = :cGenUserModuleName")})
public class GenUserModuleType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nGenUserModuleTypeID")
    private Integer nGenUserModuleTypeID;
    @Size(max = 45)
    @Column(name = "cGenUserModuleName")
    private String cGenUserModuleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nGenUserModuleTypeID")
    private Collection<GenUserPages> genUserPagesCollection;

    public GenUserModuleType() {
    }

    public GenUserModuleType(Integer nGenUserModuleTypeID) {
        this.nGenUserModuleTypeID = nGenUserModuleTypeID;
    }

    public Integer getNGenUserModuleTypeID() {
        return nGenUserModuleTypeID;
    }

    public void setNGenUserModuleTypeID(Integer nGenUserModuleTypeID) {
        this.nGenUserModuleTypeID = nGenUserModuleTypeID;
    }

    public String getCGenUserModuleName() {
        return cGenUserModuleName;
    }

    public void setCGenUserModuleName(String cGenUserModuleName) {
        this.cGenUserModuleName = cGenUserModuleName;
    }

    @XmlTransient
    public Collection<GenUserPages> getGenUserPagesCollection() {
        return genUserPagesCollection;
    }

    public void setGenUserPagesCollection(Collection<GenUserPages> genUserPagesCollection) {
        this.genUserPagesCollection = genUserPagesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nGenUserModuleTypeID != null ? nGenUserModuleTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUserModuleType)) {
            return false;
        }
        GenUserModuleType other = (GenUserModuleType) object;
        if ((this.nGenUserModuleTypeID == null && other.nGenUserModuleTypeID != null) || (this.nGenUserModuleTypeID != null && !this.nGenUserModuleTypeID.equals(other.nGenUserModuleTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUserModuleType[ nGenUserModuleTypeID=" + nGenUserModuleTypeID + " ]";
    }
    
}
