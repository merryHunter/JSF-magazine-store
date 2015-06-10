package ejb.com.chernuhaiv.entity;

import ejb.com.chernuhaiv.entity.Magazine;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-10T13:31:28")
@StaticMetamodel(Publisher.class)
public class Publisher_ { 

    public static volatile SingularAttribute<Publisher, String> country;
    public static volatile SingularAttribute<Publisher, String> pname;
    public static volatile ListAttribute<Publisher, Magazine> magazineList;
    public static volatile SingularAttribute<Publisher, Integer> id;
    public static volatile SingularAttribute<Publisher, Integer> yearFounded;

}