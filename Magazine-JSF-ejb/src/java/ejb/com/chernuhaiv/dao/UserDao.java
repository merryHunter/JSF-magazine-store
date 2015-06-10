/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import ejb.com.chernuhaiv.entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chernuhaiv@gmail.com
 */
public interface UserDao extends Dao<User, String>{
    
    List<User> findRegisteredUsersSince(Date date);
    
    List<User> findVisitedUsersSince(Date date);
}
