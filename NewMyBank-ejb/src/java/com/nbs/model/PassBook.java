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
@Table(name = "pass_book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PassBook.findAll", query = "SELECT p FROM PassBook p"),
    @NamedQuery(name = "PassBook.findByIdpassBook", query = "SELECT p FROM PassBook p WHERE p.idpassBook = :idpassBook"),
    @NamedQuery(name = "PassBook.findByColumn0", query = "SELECT p FROM PassBook p WHERE p.column0 = :column0"),
    @NamedQuery(name = "PassBook.findByColumn1", query = "SELECT p FROM PassBook p WHERE p.column1 = :column1"),
    @NamedQuery(name = "PassBook.findByColumn2", query = "SELECT p FROM PassBook p WHERE p.column2 = :column2"),
    @NamedQuery(name = "PassBook.findByColumn3", query = "SELECT p FROM PassBook p WHERE p.column3 = :column3"),
    @NamedQuery(name = "PassBook.findByColumn4", query = "SELECT p FROM PassBook p WHERE p.column4 = :column4"),
    @NamedQuery(name = "PassBook.findByColumn5", query = "SELECT p FROM PassBook p WHERE p.column5 = :column5"),
    @NamedQuery(name = "PassBook.findByColumn6", query = "SELECT p FROM PassBook p WHERE p.column6 = :column6"),
    @NamedQuery(name = "PassBook.findByColumn7", query = "SELECT p FROM PassBook p WHERE p.column7 = :column7"),
    @NamedQuery(name = "PassBook.findByColumn8", query = "SELECT p FROM PassBook p WHERE p.column8 = :column8"),
    @NamedQuery(name = "PassBook.findByColumn9", query = "SELECT p FROM PassBook p WHERE p.column9 = :column9")})
public class PassBook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpass_book")
    private Integer idpassBook;
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

    public PassBook() {
    }

    public PassBook(Integer idpassBook) {
        this.idpassBook = idpassBook;
    }

    public Integer getIdpassBook() {
        return idpassBook;
    }

    public void setIdpassBook(Integer idpassBook) {
        this.idpassBook = idpassBook;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpassBook != null ? idpassBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassBook)) {
            return false;
        }
        PassBook other = (PassBook) object;
        if ((this.idpassBook == null && other.idpassBook != null) || (this.idpassBook != null && !this.idpassBook.equals(other.idpassBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nbs.model.PassBook[ idpassBook=" + idpassBook + " ]";
    }
    
}
