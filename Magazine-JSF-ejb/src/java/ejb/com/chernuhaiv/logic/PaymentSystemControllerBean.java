/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.logic;

import ejb.com.chernuhaiv.entity.ShopOrder;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Ensure simple business logic.
 * 
 * @author chernuhaiv@gmail.com
 */
@Stateless
public class PaymentSystemControllerBean {

    /**
     * Calculate price of order
     * (assuming user selected one year subscribing).
     * @param order
     * @return 
     */
    public long getPrice(List<ShopOrder> order) {
        long cost = 0;
         for(ShopOrder o : order){
            cost += o.getMagazineFk().getPrice() * 
                    o.getMagazineFk().getNumberPerYear();
         }
         return cost;
    }
    
    
    
}
