/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import ejb.com.chernuhaiv.entity.Magazine;
import java.util.List;

/**
 *
 * @author chernuhaiv@gmail.com
 */
public interface MagazineDao extends Dao<Magazine, Long>{
    
    /**
     * Looking for magazines with given parameters.
     * @param lowerBound minimum price
     * @param highBound maximum price
     * @return found magazines
     */
    List<Magazine> findAllPriceBound(int lowerBound, int highBound);

    
    List<Magazine> findAll();
    
}
