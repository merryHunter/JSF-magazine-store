/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import java.io.Serializable;

/**
 *
 * @author chernuhaiv@gmail.com
 */
public interface Dao<E, K > {
    
    void persist(E entity);
    
    void remove(E entity);
    
    E merge(E entity);
    
    E getReference(E entity, K id);
    
    E findById(K id);
    
    
    
}
