/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.admin;

import ejb.com.chernuhaiv.entity.Publisher;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@ManagedBean
@RequestScoped
public class PublisherEditBean implements Serializable{

    @ManagedProperty(value = "#{adminPublisherBean}")
    private AdminPublisherBean adminPublisherBean;

    private Publisher publisher;

    @PostConstruct
    private void init() {
        publisher = adminPublisherBean.getPublisher();
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public AdminPublisherBean getAdminPublisherBean() {
        return adminPublisherBean;
    }

    public void setAdminPublisherBean(AdminPublisherBean adminPublisherBean) {
        this.adminPublisherBean = adminPublisherBean;
    }

    public String update() {
        adminPublisherBean.getPublisherDao().merge(publisher);
        adminPublisherBean.getPublisherList().remove(publisher);
        adminPublisherBean.getPublisherList().add(publisher);
        adminPublisherBean.setPublisher(new Publisher());
        publisher = new Publisher();
        return "updatedPublisher";
    }

    
}
