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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "Act_GL_Trnasactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActGLTrnasactions.findAll", query = "SELECT a FROM ActGLTrnasactions a"),
    @NamedQuery(name = "ActGLTrnasactions.findByNGLTrnID", query = "SELECT a FROM ActGLTrnasactions a WHERE a.nGLTrnID = :nGLTrnID"),
    @NamedQuery(name = "ActGLTrnasactions.findByCGLTrnDescription", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cGLTrnDescription = :cGLTrnDescription"),
    @NamedQuery(name = "ActGLTrnasactions.findByCGLTrnDescriptionSin", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cGLTrnDescriptionSin = :cGLTrnDescriptionSin"),
    @NamedQuery(name = "ActGLTrnasactions.findByCGLTrnCode", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cGLTrnCode = :cGLTrnCode"),
    @NamedQuery(name = "ActGLTrnasactions.findByNGLTrnEffectID", query = "SELECT a FROM ActGLTrnasactions a WHERE a.nGLTrnEffectID = :nGLTrnEffectID"),
    @NamedQuery(name = "ActGLTrnasactions.findByCPlusSide", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cPlusSide = :cPlusSide"),
    @NamedQuery(name = "ActGLTrnasactions.findByCGroupCode1", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cGroupCode1 = :cGroupCode1"),
    @NamedQuery(name = "ActGLTrnasactions.findByCGroupOrder", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cGroupOrder = :cGroupOrder"),
    @NamedQuery(name = "ActGLTrnasactions.findByCMainGroupOrder", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cMainGroupOrder = :cMainGroupOrder"),
    @NamedQuery(name = "ActGLTrnasactions.findByCGroupOrder2", query = "SELECT a FROM ActGLTrnasactions a WHERE a.cGroupOrder2 = :cGroupOrder2"),
    @NamedQuery(name = "ActGLTrnasactions.findByBBank", query = "SELECT a FROM ActGLTrnasactions a WHERE a.bBank = :bBank")})
public class ActGLTrnasactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nGLTrnID")
    private Integer nGLTrnID;
    @Size(max = 100)
    @Column(name = "cGLTrnDescription")
    private String cGLTrnDescription;
    @Size(max = 150)
    @Column(name = "cGLTrnDescription_Sin")
    private String cGLTrnDescriptionSin;
    @Size(max = 7)
    @Column(name = "cGLTrnCode")
    private String cGLTrnCode;
    @Column(name = "nGLTrnEffectID")
    private Integer nGLTrnEffectID;
    @Size(max = 2)
    @Column(name = "cPlusSide")
    private String cPlusSide;
    @Size(max = 50)
    @Column(name = "cGroupCode1")
    private String cGroupCode1;
    @Column(name = "cGroupOrder")
    private Integer cGroupOrder;
    @Column(name = "cMainGroupOrder")
    private Integer cMainGroupOrder;
    @Column(name = "cGroupOrder2")
    private Integer cGroupOrder2;
    @Column(name = "bBank")
    private Boolean bBank;

    public ActGLTrnasactions() {
    }

    public ActGLTrnasactions(Integer nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
    }

    public Integer getNGLTrnID() {
        return nGLTrnID;
    }

    public void setNGLTrnID(Integer nGLTrnID) {
        this.nGLTrnID = nGLTrnID;
    }

    public String getCGLTrnDescription() {
        return cGLTrnDescription;
    }

    public void setCGLTrnDescription(String cGLTrnDescription) {
        this.cGLTrnDescription = cGLTrnDescription;
    }

    public String getCGLTrnDescriptionSin() {
        return cGLTrnDescriptionSin;
    }

    public void setCGLTrnDescriptionSin(String cGLTrnDescriptionSin) {
        this.cGLTrnDescriptionSin = cGLTrnDescriptionSin;
    }

    public String getCGLTrnCode() {
        return cGLTrnCode;
    }

    public void setCGLTrnCode(String cGLTrnCode) {
        this.cGLTrnCode = cGLTrnCode;
    }

    public Integer getNGLTrnEffectID() {
        return nGLTrnEffectID;
    }

    public void setNGLTrnEffectID(Integer nGLTrnEffectID) {
        this.nGLTrnEffectID = nGLTrnEffectID;
    }

    public String getCPlusSide() {
        return cPlusSide;
    }

    public void setCPlusSide(String cPlusSide) {
        this.cPlusSide = cPlusSide;
    }

    public String getCGroupCode1() {
        return cGroupCode1;
    }

    public void setCGroupCode1(String cGroupCode1) {
        this.cGroupCode1 = cGroupCode1;
    }

    public Integer getCGroupOrder() {
        return cGroupOrder;
    }

    public void setCGroupOrder(Integer cGroupOrder) {
        this.cGroupOrder = cGroupOrder;
    }

    public Integer getCMainGroupOrder() {
        return cMainGroupOrder;
    }

    public void setCMainGroupOrder(Integer cMainGroupOrder) {
        this.cMainGroupOrder = cMainGroupOrder;
    }

    public Integer getCGroupOrder2() {
        return cGroupOrder2;
    }

    public void setCGroupOrder2(Integer cGroupOrder2) {
        this.cGroupOrder2 = cGroupOrder2;
    }

    public Boolean getBBank() {
        return bBank;
    }

    public void setBBank(Boolean bBank) {
        this.bBank = bBank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nGLTrnID != null ? nGLTrnID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActGLTrnasactions)) {
            return false;
        }
        ActGLTrnasactions other = (ActGLTrnasactions) object;
        if ((this.nGLTrnID == null && other.nGLTrnID != null) || (this.nGLTrnID != null && !this.nGLTrnID.equals(other.nGLTrnID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.ActGLTrnasactions[ nGLTrnID=" + nGLTrnID + " ]";
    }
    
}
