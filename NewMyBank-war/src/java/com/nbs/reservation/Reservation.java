/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.reservation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mmh
 */
public class Reservation {

    private final Map<String, Object> map = new HashMap<>();

    public boolean reserveObject(String id, Object object) {
        if (map.containsKey(id)) {
            return map.get(id) == object;
        } else {
            map.put(id, object);
            return true;
        }
    }

    public boolean releaseObject(String id, Object object) {
        if (map.get(id) == object) {
            map.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
