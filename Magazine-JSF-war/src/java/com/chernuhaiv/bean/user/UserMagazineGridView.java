/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.user;

import ejb.com.chernuhaiv.dao.ShopOrderDao;
import ejb.com.chernuhaiv.entity.Magazine;
import ejb.com.chernuhaiv.entity.ShopOrder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.Query;

/**
 * Controlling dataGrid at "my-orders.xhtml".
 * Represents magazines user is subscribed on.
 * @author chernuhaiv@gmail.com
 */
@ManagedBean
@ViewScoped
public class UserMagazineGridView implements Serializable{
    
    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;
    
    private List<Magazine> magazines = new ArrayList();
      
    private List<ShopOrder> userOrder = new ArrayList();
    
    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
    
    /**
     * Retrieving user's previous orders.
     */
    @PostConstruct
    private void init(){
        userOrder =
                userBean
                .getOrderDao()
                .findUserOrdersByEmailId(userBean.getUser().getEmailPk());
        System.out.println("size:");
        System.out.println(userOrder.size());
    }

    public List<ShopOrder> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(List<ShopOrder> userOrder) {
        this.userOrder = userOrder;
    }
    
    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<Magazine> magazines) {
        this.magazines = magazines;
    }
}
