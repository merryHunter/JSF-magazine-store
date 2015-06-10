/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.admin;

import ejb.com.chernuhaiv.dao.ShopOrderDao;
import ejb.com.chernuhaiv.entity.ShopOrder;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@ManagedBean
@SessionScoped
public class AdminOrderBean implements Serializable{
    
    @EJB
    private ShopOrderDao orderDao;
    
    private List<ShopOrder> orders;

    
    @PostConstruct
    private void init(){
        orders = orderDao.findAll();
    }
    
    public ShopOrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(ShopOrderDao orderDao) {
        this.orderDao = orderDao;
    }
  
    public List<ShopOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ShopOrder> orders) {
        this.orders = orders;
    }
    
}
