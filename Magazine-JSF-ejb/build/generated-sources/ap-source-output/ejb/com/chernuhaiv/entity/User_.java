package ejb.com.chernuhaiv.entity;

import ejb.com.chernuhaiv.entity.ShopOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-10T13:31:28")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> discount;
    public static volatile SingularAttribute<User, String> emailPk;
    public static volatile SingularAttribute<User, Integer> banned;
    public static volatile ListAttribute<User, ShopOrder> shopOrderList;

}