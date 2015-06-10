/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.admin;

import ejb.com.chernuhaiv.entity.Magazine;
import ejb.com.chernuhaiv.entity.Publisher;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@ManagedBean
@RequestScoped
public class MagazineEditBean {

    @ManagedProperty(value = "#{adminMagazineBean}")
    private AdminMagazineBean adminMagazineBean;

    private Magazine magazine;

    private List<Publisher> publisherAllList;

    private String selectedPublisher;

    @PostConstruct
    private void init() {
        magazine = adminMagazineBean.getMagazine();
        publisherAllList = adminMagazineBean
                .getPublisherDao()
                .findAllPublisher();
    }

    public String update() {
        System.out.println("selectrd " + selectedPublisher);
        for (Publisher p : publisherAllList) {
            if (p.getPname().equals(selectedPublisher)) {
                magazine.setPublisherFk(p);
                System.out.println("pname: " + p.getPname());
                break;
            }
        }
        adminMagazineBean.getMagazineDao().merge(magazine);
        adminMagazineBean.getMagazineList().remove(magazine);
        adminMagazineBean.getMagazineList().add(magazine);
        adminMagazineBean.setMagazine(new Magazine());
        magazine = new Magazine();
        return "list-magazine";
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

    public List<Publisher> getPublisherAllList() {
        return publisherAllList;
    }

    public void setPublisherAllList(List<Publisher> publisherAllList) {
        this.publisherAllList = publisherAllList;
    }

}
