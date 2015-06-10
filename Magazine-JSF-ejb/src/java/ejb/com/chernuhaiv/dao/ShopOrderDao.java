/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import ejb.com.chernuhaiv.entity.ShopOrder;
import ejb.com.chernuhaiv.entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chernuhaiv@gmail.com
 */
public interface ShopOrderDao extends Dao<ShopOrder, Long>{
    
    List<ShopOrder> findUserOrders(User user);
    
    List<User> findMagazineSubscribers(Long magazineId);
    
    List<ShopOrder> findAll();
    
    List<ShopOrder> findOrders(Date begin, Date end);

    public List<ShopOrder> findUserOrdersByEmailId(String email);
}
