package ejb.com.chernuhaiv.entity;

import ejb.com.chernuhaiv.entity.Magazine;
import ejb.com.chernuhaiv.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-10T13:31:28")
@StaticMetamodel(ShopOrder.class)
public class ShopOrder_ { 

    public static volatile SingularAttribute<ShopOrder, Date> expireDate;
    public static volatile SingularAttribute<ShopOrder, Magazine> magazineFk;
    public static volatile SingularAttribute<ShopOrder, Integer> id;
    public static volatile SingularAttribute<ShopOrder, User> userFk;

}