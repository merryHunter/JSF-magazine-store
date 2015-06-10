/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.admin;

import ejb.com.chernuhaiv.dao.MagazineDao;
import ejb.com.chernuhaiv.dao.PublisherDao;
import ejb.com.chernuhaiv.entity.Magazine;
import ejb.com.chernuhaiv.entity.Publisher;
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
@ManagedBean(name = "adminMagazineBean")
@SessionScoped
public class AdminMagazineBean implements Serializable{
    
    @EJB
    private MagazineDao magazineDao;
    
    @EJB
    private PublisherDao publisherDao;
//    
    private List<Magazine> magazineList;

    private Magazine magazine = new Magazine();
    
    

    /**
     * Retrieving magazine list from database.
     */
    @PostConstruct
    private void init(){
        magazineList = magazineDao.findAll();
        System.out.println("adminmagazine bean postconstruct");
        System.out.println(magazineList.size());
    }
    
    public List<Magazine> getMagazineList() {
        magazineList = magazineDao.findAll();
        return magazineList;
    }

    public void setMagazineList(List<Magazine> magazineList) {
        this.magazineList = magazineList;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine newMagazine) {
        this.magazine = newMagazine;
    }

    public MagazineDao getMagazineDao() {
        return magazineDao;
    }

    public PublisherDao getPublisherDao() {
        return publisherDao;
    }

    public void setMagazineDao(MagazineDao magazineDao) {
        this.magazineDao = magazineDao;
    }

    public void setPublisherDao(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

//    public static Logger getLog() {
//        return log;
//    }

    public String update(Magazine magazineUpdate){
        System.out.println("update magazine");
//        log.info("update magazine");
        magazine = magazineUpdate;
        System.out.println("update magazine set");
        return "goUpdateMagazine";
    }
    
    public String delete(Magazine magazineDelete){
        //log.info("deleted " + magazineDelete);
        System.out.println("deleted magazine");
        magazineDao.remove(magazineDelete);
        magazineList.remove(magazineDelete);
        return "deletedMagazine";
    }
}
