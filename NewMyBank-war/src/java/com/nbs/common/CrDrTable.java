/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.common;

/**
 *
 * @author mmh
 */
public class CrDrTable {

    private int id;
    private int id2;
    private String row1;
    private String row2;
    private String row3;
    private String row4;

    public CrDrTable() {
    }

    public CrDrTable(int id, int id2, String row1, String row2, String row3, String row4) {
        this.id = id;
        this.id2 = id2;
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
        this.row4 = row4;
    }
    

    public String getRow1() {
        return row1;
    }

    public void setRow1(String row1) {
        this.row1 = row1;
    }

    public String getRow2() {
        return row2;
    }

    public void setRow2(String row2) {
        this.row2 = row2;
    }

    public String getRow3() {
        return row3;
    }

    public void setRow3(String row3) {
        this.row3 = row3;
    }

    public String getRow4() {
        return row4;
    }

    public void setRow4(String row4) {
        this.row4 = row4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
}
