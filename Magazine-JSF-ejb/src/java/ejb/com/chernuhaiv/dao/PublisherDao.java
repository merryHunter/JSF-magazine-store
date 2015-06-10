/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import ejb.com.chernuhaiv.entity.Publisher;
import java.util.List;

/**
 *
 * @author chernuhaiv@gmail.com
 */
public interface PublisherDao extends Dao<Publisher, Long>{
    
    List<Publisher> findPublisherByName(String name);
    
    List<Publisher> findAllPublisherFromCountry(String country);
    
    List<Publisher> findAllPublisherSinceYear(int year);

    List<Publisher> findAllPublisher();
}
