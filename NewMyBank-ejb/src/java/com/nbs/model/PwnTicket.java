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
@Table(name = "pwn_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PwnTicket.findAll", query = "SELECT p FROM PwnTicket p"),
    @NamedQuery(name = "PwnTicket.findByIdpwnTicket", query = "SELECT p FROM PwnTicket p WHERE p.idpwnTicket = :idpwnTicket"),
    @NamedQuery(name = "PwnTicket.findByColumn0", query = "SELECT p FROM PwnTicket p WHERE p.column0 = :column0"),
    @NamedQuery(name = "PwnTicket.findByColumn1", query = "SELECT p FROM PwnTicket p WHERE p.column1 = :column1"),
    @NamedQuery(name = "PwnTicket.findByColumn2", query = "SELECT p FROM PwnTicket p WHERE p.column2 = :column2"),
    @NamedQuery(name = "PwnTicket.findByColumn3", query = "SELECT p FROM PwnTicket p WHERE p.column3 = :column3"),
    @NamedQuery(name = "PwnTicket.findByColumn4", query = "SELECT p FROM PwnTicket p WHERE p.column4 = :column4"),
    @NamedQuery(name = "PwnTicket.findByColumn5", query = "SELECT p FROM PwnTicket p WHERE p.column5 = :column5"),
    @NamedQuery(name = "PwnTicket.findByColumn6", query = "SELECT p FROM PwnTicket p WHERE p.column6 = :column6"),
    @NamedQuery(name = "PwnTicket.findByColumn7", query = "SELECT p FROM PwnTicket p WHERE p.column7 = :column7"),
    @NamedQuery(name = "PwnTicket.findByColumn8", query = "SELECT p FROM PwnTicket p WHERE p.column8 = :column8"),
    @NamedQuery(name = "PwnTicket.findByColumn9", query = "SELECT p FROM PwnTicket p WHERE p.column9 = :column9"),
    @NamedQuery(name = "PwnTicket.findByColumn10", query = "SELECT p FROM PwnTicket p WHERE p.column10 = :column10"),
    @NamedQuery(name = "PwnTicket.findByColumn11", query = "SELECT p FROM PwnTicket p WHERE p.column11 = :column11"),
    @NamedQuery(name = "PwnTicket.findByColumn12", query = "SELECT p FROM PwnTicket p WHERE p.column12 = :column12"),
    @NamedQuery(name = "PwnTicket.findByColumn13", query = "SELECT p FROM PwnTicket p WHERE p.column13 = :column13"),
    @NamedQuery(name = "PwnTicket.findByColumn14", query = "SELECT p FROM PwnTicket p WHERE p.column14 = :column14"),
    @NamedQuery(name = "PwnTicket.findByColumn15", query = "SELECT p FROM PwnTicket p WHERE p.column15 = :column15"),
    @NamedQuery(name = "PwnTicket.findByColumn16", query = "SELECT p FROM PwnTicket p WHERE p.column16 = :column16"),
    @NamedQuery(name = "PwnTicket.findByColumn17", query = "SELECT p FROM PwnTicket p WHERE p.column17 = :column17"),
    @NamedQuery(name = "PwnTicket.findByColumn18", query = "SELECT p FROM PwnTicket p WHERE p.column18 = :column18"),
    @NamedQuery(name = "PwnTicket.findByColumn19", query = "SELECT p FROM PwnTicket p WHERE p.column19 = :column19"),
    @NamedQuery(name = "PwnTicket.findByColumn20", query = "SELECT p FROM PwnTicket p WHERE p.column20 = :column20"),
    @NamedQuery(name = "PwnTicket.findByColumn21", query = "SELECT p FROM PwnTicket p WHERE p.column21 = :column21"),
    @NamedQuery(name = "PwnTicket.findByColumn22", query = "SELECT p FROM PwnTicket p WHERE p.column22 = :column22")})
public class PwnTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpwn_ticket")
    private Integer idpwnTicket;
    @Size(max = 45)
    @Column(name = "COLUMN_0")
    private String column0;
    @Size(max = 45)
    @Column(name = "COLUMN_1")
    private String column1;
    @Size(max = 45)
    @Column(name = "COLUMN_2")
    private String column2;
    @Size(max = 45)
    @Column(name = "COLUMN_3")
    private String column3;
    @Size(max = 45)
    @Column(name = "COLUMN_4")
    private String column4;
    @Size(max = 45)
    @Column(name = "COLUMN_5")
    private String column5;
    @Size(max = 45)
    @Column(name = "COLUMN_6")
    private String column6;
    @Size(max = 45)
    @Column(name = "COLUMN_7")
    private String column7;
    @Size(max = 45)
    @Column(name = "COLUMN_8")
    private String column8;
    @Size(max = 45)
    @Column(name = "COLUMN_9")
    private String column9;
    @Size(max = 45)
    @Column(name = "COLUMN_10")
    private String column10;
    @Size(max = 45)
    @Column(name = "COLUMN_11")
    private String column11;
    @Size(max = 45)
    @Column(name = "COLUMN_12")
    private String column12;
    @Size(max = 45)
    @Column(name = "COLUMN_13")
    private String column13;
    @Size(max = 45)
    @Column(name = "COLUMN_14")
    private String column14;
    @Size(max = 45)
    @Column(name = "COLUMN_15")
    private String column15;
    @Size(max = 45)
    @Column(name = "COLUMN_16")
    private String column16;
    @Size(max = 45)
    @Column(name = "COLUMN_17")
    private String column17;
    @Size(max = 45)
    @Column(name = "COLUMN_18")
    private String column18;
    @Size(max = 45)
    @Column(name = "COLUMN_19")
    private String column19;
    @Size(max = 45)
    @Column(name = "COLUMN_20")
    private String column20;
    @Size(max = 45)
    @Column(name = "COLUMN_21")
    private String column21;
    @Size(max = 45)
    @Column(name = "COLUMN_22")
    private String column22;

    public PwnTicket() {
    }

    public PwnTicket(Integer idpwnTicket) {
        this.idpwnTicket = idpwnTicket;
    }

    public Integer getIdpwnTicket() {
        return idpwnTicket;
    }

    public void setIdpwnTicket(Integer idpwnTicket) {
        this.idpwnTicket = idpwnTicket;
    }

    public String getColumn0() {
        return column0;
    }

    public void setColumn0(String column0) {
        this.column0 = column0;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    public String getColumn7() {
        return column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    public String getColumn8() {
        return column8;
    }

    public void setColumn8(String column8) {
        this.column8 = column8;
    }

    public String getColumn9() {
        return column9;
    }

    public void setColumn9(String column9) {
        this.column9 = column9;
    }

    public String getColumn10() {
        return column10;
    }

    public void setColumn10(String column10) {
        this.column10 = column10;
    }

    public String getColumn11() {
        return column11;
    }

    public void setColumn11(String column11) {
        this.column11 = column11;
    }

    public String getColumn12() {
        return column12;
    }

    public void setColumn12(String column12) {
        this.column12 = column12;
    }

    public String getColumn13() {
        return column13;
    }

    public void setColumn13(String column13) {
        this.column13 = column13;
    }

    public String getColumn14() {
        return column14;
    }

    public void setColumn14(String column14) {
        this.column14 = column14;
    }

    public String getColumn15() {
        return column15;
    }

    public void setColumn15(String column15) {
        this.column15 = column15;
    }

    public String getColumn16() {
        return column16;
    }

    public void setColumn16(String column16) {
        this.column16 = column16;
    }

    public String getColumn17() {
        return column17;
    }

    public void setColumn17(String column17) {
        this.column17 = column17;
    }

    public String getColumn18() {
        return column18;
    }

    public void setColumn18(String column18) {
        this.column18 = column18;
    }

    public String getColumn19() {
        return column19;
    }

    public void setColumn19(String column19) {
        this.column19 = column19;
    }

    public String getColumn20() {
        return column20;
    }

    public void setColumn20(String column20) {
        this.column20 = column20;
    }

    public String getColumn21() {
        return column21;
    }

    public void setColumn21(String column21) {
        this.column21 = column21;
    }

    public String getColumn22() {
        return column22;
    }

    public void setColumn22(String column22) {
        this.column22 = column22;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpwnTicket != null ? idpwnTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PwnTicket)) {
            return false;
        }
        PwnTicket other = (PwnTicket) object;
        if ((this.idpwnTicket == null && other.idpwnTicket != null) || (this.idpwnTicket != null && !this.idpwnTicket.equals(other.idpwnTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.PwnTicket[ idpwnTicket=" + idpwnTicket + " ]";
    }
    
}
