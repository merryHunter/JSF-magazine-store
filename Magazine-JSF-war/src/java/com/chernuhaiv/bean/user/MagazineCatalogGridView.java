/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.user;

import ejb.com.chernuhaiv.entity.Magazine;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Contained Magazines catalog.
 * @author chernuhaiv@gmail.com
 */
@ManagedBean
@ViewScoped
public class MagazineCatalogGridView implements Serializable{
    
    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;
    
   
    private List<Magazine> magazines;
      
    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
    
    @PostConstruct
    private void init(){
        magazines = userBean.getMagazineDao().findAll();
        magazines.stream().forEach((m) -> {
            System.out.println("magazine info:" + m.getMname());
        });
    }
    
    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<Magazine> magazines) {
        this.magazines = magazines;
    }
}
