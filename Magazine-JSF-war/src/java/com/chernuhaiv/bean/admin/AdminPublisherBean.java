/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.admin;

import ejb.com.chernuhaiv.dao.MagazineDao;
import ejb.com.chernuhaiv.dao.PublisherDao;
import ejb.com.chernuhaiv.entity.Publisher;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@ManagedBean(name = "adminPublisherBean")
@SessionScoped
public class AdminPublisherBean implements Serializable{
    
    @EJB
    private PublisherDao publisherDao;

    private Publisher publisher = new Publisher();
    
    private List<Publisher> publisherList;

    
    @PostConstruct
    private void init(){
        publisherList = publisherDao.findAllPublisher();
    }
    
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Publisher> getPublisherList() {
        
        return publisherList;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        this.publisherList = publisherList;
    }

    public PublisherDao getPublisherDao() {
        return publisherDao;
    }

    
    public void setPublisherDao(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }
    
    public String delete(Publisher publisherDelete){
        System.out.println("delete publisher");
        publisherDao.remove(publisherDelete);
        publisherList.remove(publisherDelete);
        return "deletedPublisher";
    }
    public String update(Publisher publisherUpdate){
        System.out.println("update publisher");
        publisher = publisherUpdate;
        return "goUpdatePublisher";
    }
    
    
   
}
