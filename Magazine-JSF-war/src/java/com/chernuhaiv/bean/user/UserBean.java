/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chernuhaiv.bean.user;

import ejb.com.chernuhaiv.dao.MagazineDao;
import ejb.com.chernuhaiv.dao.ShopOrderDao;
import ejb.com.chernuhaiv.dao.UserDao;
import ejb.com.chernuhaiv.entity.Magazine;
import ejb.com.chernuhaiv.entity.ShopOrder;
import ejb.com.chernuhaiv.entity.User;
import ejb.com.chernuhaiv.logic.PaymentSystemControllerBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Bean ensure connection between view and business logic.
 * Manipulate user's actions like pay selected magazine, view
 * subscriptions.
 * 
 * @author chernuhaiv@gmail.com
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserDao userDao;

    @EJB
    private MagazineDao magazineDao;

    @EJB
    private ShopOrderDao orderDao;

    @EJB
    private PaymentSystemControllerBean paymentSystem;

    /**
     * User's charts.
     */
    private List<ShopOrder> userOrders;

    private User user = new User();

    private String login;

    private String password;

    private boolean isLoggedInAsUser;

    private boolean isLoggedInAsAdmin;

    private long magazinesPrice;

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct userbean");
        user = new User();
        userOrders = new ArrayList();
        isLoggedInAsAdmin = false;
        isLoggedInAsUser = false;
    }

    public boolean isIsLoggedInAsUser() {
        return isLoggedInAsUser;
    }

    public void setIsLoggedInAsUser(boolean isLoggedInAsUser) {
        this.isLoggedInAsUser = isLoggedInAsUser;
    }

    public boolean isIsLoggedInAsAdmin() {
        return isLoggedInAsAdmin;
    }

    public void setIsLoggedInAsAdmin(boolean isLoggedInAsAdmin) {
        this.isLoggedInAsAdmin = isLoggedInAsAdmin;
    }

    public String addNewUser() {
        //if user already exist(redistered)
        System.out.println("user: " + user.getEmailPk());
        System.out.println("user: " + user.getPassword());
        User existedUser = (User) userDao.findById(user.getEmailPk());

        if (existedUser != null) {
            System.out.println("user: " + existedUser.getEmailPk());
            System.out.println("user: " + existedUser.getPassword());
            return "failure";
        }

        user.setDiscount(0);
        userDao.persist(user);
        System.out.println("added new user");
        isLoggedInAsUser = true;
        return "success";
    }

    public String loginUser() {

        System.out.println("user login " + login);
        System.out.println("user pass " + password);
        //admin entering
        if (login.equals("admin") && password.equals("admin")) {
            isLoggedInAsAdmin = true;
            return "admin/manage";
        }
        //find user in DB
        user = (User) userDao.findById(login);
        System.out.println("user  " + user);
        //if not found or mismatch entered password
        if (user == null || !user.getPassword().equals(password)) {
            return "failure";
        }
        isLoggedInAsUser = true;
        return "success";
    }

    public long getPriceSelectedMagazine() {
        magazinesPrice = paymentSystem.getPrice(userOrders);

        return magazinesPrice;
    }

    /**
     * Add selected magazine in chart <code>userOrders</code>,
     * but it's still only cash needed to be confirmed, only 
     * after it will be store in database.
     * 
     * @param event 
     */
    public void addInTote(ActionEvent event) {
        Magazine selected = (Magazine) event.getComponent()
                .getAttributes()
                .get("selectedMagazine");
        System.out.println("add in tote " + selected.getId());
        ShopOrder newOrder = new ShopOrder();
        newOrder.setMagazineFk(selected);
        newOrder.setUserFk(user);
        newOrder.setExpireDate(new Date());
        userOrders.add(newOrder);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Added!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        getPriceSelectedMagazine();
    }

    /**
     * Confirm selected magazines.
     * 
     * @return 
     */
    public String pay() {
        System.out.println("pay");

        for (ShopOrder o : userOrders) {
            orderDao.persist(o);
        }
        userOrders.clear();
        return "my-orders";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ShopOrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(ShopOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public PaymentSystemControllerBean getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystemControllerBean paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public MagazineDao getMagazineDao() {
        return magazineDao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ShopOrder> getOrder() {
        return userOrders;
    }

    public void setOrder(List<ShopOrder> order) {
        this.userOrders = order;
    }

    public long getMagazinesPrice() {
        return magazinesPrice;
    }

    public void setMagazinesPrice(long magazinesPrice) {
        this.magazinesPrice = magazinesPrice;
    }

}
