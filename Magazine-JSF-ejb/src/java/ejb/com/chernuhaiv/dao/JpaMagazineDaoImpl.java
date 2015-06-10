/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import ejb.com.chernuhaiv.entity.Magazine;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@Stateless
public class JpaMagazineDaoImpl extends JpaDao<Magazine, Long> implements MagazineDao{

    @Override
    public List<Magazine> findAllPriceBound(int lowerBound, int highBound) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Magazine> findAll() {
        return entityManager
                .createNamedQuery("Magazine.findAll", Magazine.class)
                .getResultList();
    }
    
    
    
}
