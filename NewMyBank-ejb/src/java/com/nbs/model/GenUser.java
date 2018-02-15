/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmh
 */
@Entity
@Table(name = "gen_User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUser.findAll", query = "SELECT g FROM GenUser g")
    , @NamedQuery(name = "GenUser.findByNUserID", query = "SELECT g FROM GenUser g WHERE g.nUserID = :nUserID")
    , @NamedQuery(name = "GenUser.findByCUserName", query = "SELECT g FROM GenUser g WHERE g.cUserName = :cUserName")
    , @NamedQuery(name = "GenUser.findByCUserCode", query = "SELECT g FROM GenUser g WHERE g.cUserCode = :cUserCode")
    , @NamedQuery(name = "GenUser.findByCPassword", query = "SELECT g FROM GenUser g WHERE g.cPassword = :cPassword")
    , @NamedQuery(name = "GenUser.findByDCreatedDate", query = "SELECT g FROM GenUser g WHERE g.dCreatedDate = :dCreatedDate")
    , @NamedQuery(name = "GenUser.findByCEmail", query = "SELECT g FROM GenUser g WHERE g.cEmail = :cEmail")
    , @NamedQuery(name = "GenUser.findByGenUsercol", query = "SELECT g FROM GenUser g WHERE g.genUsercol = :genUsercol")})
public class GenUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nUserID")
    private Integer nUserID;
    @Size(max = 20)
    @Column(name = "cUserName")
    private String cUserName;
    @Size(max = 200)
    @Column(name = "cUserCode")
    private String cUserCode;
    @Size(max = 45)
    @Column(name = "cPassword")
    private String cPassword;
    @Column(name = "dCreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dCreatedDate;
    @Size(max = 100)
    @Column(name = "cEmail")
    private String cEmail;
    @Size(max = 45)
    @Column(name = "gen_Usercol")
    private String genUsercol;
    @JoinColumn(name = "nUserTypeID", referencedColumnName = "nUserTypeID")
    @ManyToOne(optional = false)
    private GenUserType nUserTypeID;
    @JoinColumn(name = "nUserStatusID", referencedColumnName = "nUserStatusID")
    @ManyToOne(optional = false)
    private GenUserStatus nUserStatusID;

    public GenUser() {
    }

    public GenUser(Integer nUserID) {
        this.nUserID = nUserID;
    }

    public Integer getNUserID() {
        return nUserID;
    }

    public void setNUserID(Integer nUserID) {
        this.nUserID = nUserID;
    }

    public String getCUserName() {
        return cUserName;
    }

    public void setCUserName(String cUserName) {
        this.cUserName = cUserName;
    }

    public String getCUserCode() {
        return cUserCode;
    }

    public void setCUserCode(String cUserCode) {
        this.cUserCode = cUserCode;
    }

    public String getCPassword() {
        return cPassword;
    }

    public void setCPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public Date getDCreatedDate() {
        return dCreatedDate;
    }

    public void setDCreatedDate(Date dCreatedDate) {
        this.dCreatedDate = dCreatedDate;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getGenUsercol() {
        return genUsercol;
    }

    public void setGenUsercol(String genUsercol) {
        this.genUsercol = genUsercol;
    }

    public GenUserType getNUserTypeID() {
        return nUserTypeID;
    }

    public void setNUserTypeID(GenUserType nUserTypeID) {
        this.nUserTypeID = nUserTypeID;
    }

    public GenUserStatus getNUserStatusID() {
        return nUserStatusID;
    }

    public void setNUserStatusID(GenUserStatus nUserStatusID) {
        this.nUserStatusID = nUserStatusID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nUserID != null ? nUserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUser)) {
            return false;
        }
        GenUser other = (GenUser) object;
        if ((this.nUserID == null && other.nUserID != null) || (this.nUserID != null && !this.nUserID.equals(other.nUserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.GenUser[ nUserID=" + nUserID + " ]";
    }
    
}
