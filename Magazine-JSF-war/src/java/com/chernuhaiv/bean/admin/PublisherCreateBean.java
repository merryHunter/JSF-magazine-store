/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.admin;

import ejb.com.chernuhaiv.entity.Publisher;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;

/**
 * Create new publisher, mapped to "create-publisher.xhtml".
 * 
 * @author chernuhaiv@gmail.com
 */
@ManagedBean
@RequestScoped
public class PublisherCreateBean implements Serializable{
    
    @ManagedProperty(value = "#{adminPublisherBean}")
    private AdminPublisherBean adminPublisherBean;
    
    private Publisher publisher;
    
    private Part fileIconPublisher;
    
    @PostConstruct
    private void init(){
        publisher  = new Publisher();
    }
    
    public String create(){
        System.out.println("created publisher");
        adminPublisherBean.getPublisherDao().persist(publisher);
        adminPublisherBean.getPublisherList().add(publisher);
        System.out.println("created publisher");
        return "createdPublisher";
    } 
    
    
    public void handleFileUpload() throws IOException {
        System.out.println("MY HANDLE");
        final long fileSize = fileIconPublisher.getSize();
        if(fileSize > Integer.MAX_VALUE) {
            return;
        }
        byte[] icon = new byte[(int)fileSize];
        fileIconPublisher.getInputStream().read(icon);
        System.out.println("file size: " + fileIconPublisher.getSize());
        System.out.println("file type: " + fileIconPublisher.getContentType());
        System.out.println("file info: " + fileIconPublisher.getHeader("Content-Disposition"));
    }

    public AdminPublisherBean getAdminPublisherBean() {
        return adminPublisherBean;
    }

    public void setAdminPublisherBean(AdminPublisherBean adminPublisherBean) {
        this.adminPublisherBean = adminPublisherBean;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Part getFileIconPublisher() {
        return fileIconPublisher;
    }

    public void setFileIconPublisher(Part fileIconPublisher) {
        this.fileIconPublisher = fileIconPublisher;
        try {
            handleFileUpload();
        } catch (IOException ex) {
            Logger.getLogger(PublisherCreateBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
