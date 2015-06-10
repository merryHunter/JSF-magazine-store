package ejb.com.chernuhaiv.entity;

import ejb.com.chernuhaiv.entity.Publisher;
import ejb.com.chernuhaiv.entity.ShopOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-10T13:31:28")
@StaticMetamodel(Magazine.class)
public class Magazine_ { 

    public static volatile SingularAttribute<Magazine, Publisher> publisherFk;
    public static volatile SingularAttribute<Magazine, Integer> price;
    public static volatile SingularAttribute<Magazine, Integer> available;
    public static volatile SingularAttribute<Magazine, String> description;
    public static volatile SingularAttribute<Magazine, Integer> discount;
    public static volatile SingularAttribute<Magazine, Integer> id;
    public static volatile SingularAttribute<Magazine, String> mname;
    public static volatile SingularAttribute<Magazine, Integer> numberPerYear;
    public static volatile ListAttribute<Magazine, ShopOrder> shopOrderList;

}