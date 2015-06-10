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
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@Stateless
public class JpaShopOrderDaoImpl extends JpaDao<ShopOrder, Long> 
                                implements ShopOrderDao{

    /**
     * Looking for all orders of specified user.
     * @param user user id from table "SHOP_USER" (foreign key here)
     * @return list of orders.
     */
    @Override
    public List<ShopOrder> findUserOrders(User user) {
        return entityManager
                .createNamedQuery("ShopOrder.findUserOrders", ShopOrder.class)
                .setParameter("userFk", user)
                .getResultList();
    }

    @Override
    public List<ShopOrder> findAll() {
        return entityManager
                .createNamedQuery("ShopOrder.findAll", ShopOrder.class)
                .getResultList();
    }

    @Override
    public List<ShopOrder> findOrders(Date begin, Date end) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
 }

    @Override
    public List<User> findMagazineSubscribers(Long magazineId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ShopOrder> findUserOrdersByEmailId(String email) {
        return entityManager
                .createQuery("SELECT s FROM ShopOrder s WHERE s.userFk.emailPk = :emailPk")
                .setParameter("emailPk", email).getResultList();
    }
    
}
