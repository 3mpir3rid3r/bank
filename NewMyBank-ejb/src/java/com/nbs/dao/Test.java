/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import javax.ejb.Stateless;

/**
 *
 * @author mmh
 */
@Stateless
public class Test implements TestLocal {
    
    private boolean bool;

    @Override
    public boolean log(String name, String pass) {
       if(name.equals("abc") && pass.equals("123")){
        bool = true;
        
       }else{
           bool = false;
       }
       return bool;
    }
}
