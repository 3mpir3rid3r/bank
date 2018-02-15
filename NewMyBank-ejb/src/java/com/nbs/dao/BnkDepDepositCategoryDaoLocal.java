/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbs.dao;

import com.nbs.model.BnkDepDepositCategory;
import com.nbs.model.BnkDepDepositTypes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lasa
 */
@Local
public interface BnkDepDepositCategoryDaoLocal {

    List<BnkDepDepositCategory> getAllBnkDepDepositCategory();
}
