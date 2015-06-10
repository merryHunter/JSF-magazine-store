/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import ejb.com.chernuhaiv.entity.Publisher;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@Stateless
public class JpaPublisherDaoImpl extends JpaDao<Publisher, Long> implements PublisherDao{

    @Override
    public List<Publisher> findAllPublisherFromCountry(String country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publisher> findAllPublisherSinceYear(int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publisher> findAllPublisher() { 
        return entityManager
                .createNamedQuery("Publisher.findAll", Publisher.class)
                .getResultList();
    }

    @Override
    public List<Publisher> findPublisherByName(String name) {
        return entityManager
                .createNamedQuery("Publisher.findByPname", Publisher.class)
                .setParameter("pname", name)
                .getResultList();
    }
    
}
