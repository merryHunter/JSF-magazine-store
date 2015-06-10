/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import ejb.com.chernuhaiv.entity.User;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@Stateless
public class JpaUserDaoImpl extends JpaDao<User, String> implements UserDao{

    @Override
    public List<User> findRegisteredUsersSince(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findVisitedUsersSince(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
