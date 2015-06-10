/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.admin;

import ejb.com.chernuhaiv.dao.PublisherDao;
import ejb.com.chernuhaiv.entity.Magazine;
import ejb.com.chernuhaiv.entity.Publisher;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@ManagedBean
@RequestScoped
public class MagazineCreateBean implements Serializable{
    
    @ManagedProperty(value = "#{adminMagazineBean}")
    private AdminMagazineBean adminMagazineBean;
    
     @EJB
    private PublisherDao publisherDao;
     
    private Magazine magazine = new Magazine();
    
    private UploadedFile fileIconMagazine;
    
    private String selectedPublisher;
    
    private List<Publisher> publisherAllList;
    
    private List<String> publisherAllListName = new ArrayList<>();
    
    /**
     * Retrieving available publisher list.
     * Populate <code>publisherAllListName</code with publishers names.
     * 
     * TODO: publisher name is not unique!
     */
    @PostConstruct
    private void init(){
//        publisherAllList = adminMagazineBean
//                .getPublisherDao()
//                .findAllPublisher();
         magazine = new Magazine();
        publisherAllList = publisherDao.findAllPublisher();
        System.out.println("found publishers: ");
        System.out.println(publisherAllList.size());
        for(int i = 0; i < publisherAllList.size(); ++i) {
            publisherAllListName.add(publisherAllList.get(i).getPname());
        }
    }
    
    
    public String addMagazine(){
        //looking for selected publisher object
        for(Publisher p : publisherAllList){
            if( p.getPname().equals(selectedPublisher)){
               magazine.setPublisherFk(p);
               break;
            }
        }
        System.out.println("magazine:" + magazine.toString());
        System.out.println( magazine.getAvailable());
         System.out.println( magazine.getDescription());
          System.out.println( magazine.getMname());
        adminMagazineBean.getMagazineDao().persist(magazine);
        adminMagazineBean.getMagazineList().add(magazine);
        return "createdMagazine";
    } 

  
    public List<String> getPublisherAllListName() {
        return publisherAllListName;
    }

    public void setPublisherAllListName(List<String> publisherAllListName) {
        this.publisherAllListName = publisherAllListName;
    }


    public PublisherDao getPublisherDao() {
        return publisherDao;
    }

    public void setPublisherDao(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public String getSelectedPublisher() {
        return selectedPublisher;
    }

    public void setSelectedPublisher(String selectedPublisher) {
        this.selectedPublisher = selectedPublisher;
    }

    public AdminMagazineBean getAdminMagazineBean() {
        return adminMagazineBean;
    }

    public void setAdminMagazineBean(AdminMagazineBean adminMagazineBean) {
        this.adminMagazineBean = adminMagazineBean;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public UploadedFile getFileIconMagazine() {
        return fileIconMagazine;
    }

    public void setFileIconMagazine(UploadedFile fileIconMagazine) {
        this.fileIconMagazine = fileIconMagazine;
    }

    public List<Publisher> getPublisherAllList() {
        return publisherAllList;
    }

    public void setPublisherAllList(List<Publisher> publisherAllList) {
        this.publisherAllList = publisherAllList;
    }
    
    public void handleFileUpload() throws IOException {
        System.out.println("MY HANDLE");
        //fileIconMagazine = e.getFile();
        final long fileSize =fileIconMagazine.getSize();
        if(fileSize > Integer.MAX_VALUE) {
            return;
        }
    }
    
}
