/*

 */
package ejb.com.chernuhaiv.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@Entity
@Table(name = "shop_magazine")
@NamedQueries({
    @NamedQuery(name = "Magazine.findAll", query = "SELECT m FROM Magazine m"),
    @NamedQuery(name = "Magazine.findById", query = "SELECT m FROM Magazine m WHERE m.id = :id"),
    @NamedQuery(name = "Magazine.findByAvailable", query = "SELECT m FROM Magazine m WHERE m.available = :available"),
    @NamedQuery(name = "Magazine.findByDescription", query = "SELECT m FROM Magazine m WHERE m.description = :description"),
    @NamedQuery(name = "Magazine.findByDiscount", query = "SELECT m FROM Magazine m WHERE m.discount = :discount"),
    @NamedQuery(name = "Magazine.findByMname", query = "SELECT m FROM Magazine m WHERE m.mname = :mname"),
    @NamedQuery(name = "Magazine.findByNumberPerYear", query = "SELECT m FROM Magazine m WHERE m.numberPerYear = :numberPerYear"),
    @NamedQuery(name = "Magazine.findByPrice", query = "SELECT m FROM Magazine m WHERE m.price = :price")})
public class Magazine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "available")
    private Integer available;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "discount")
    private Integer discount;
    @Size(max = 255)
    @Column(name = "mname")
    private String mname;
    @Column(name = "number_per_year")
    private Integer numberPerYear;
    @Column(name = "price")
    private Integer price;
    @OneToMany(mappedBy = "magazineFk")
    private List<ShopOrder> shopOrderList;
    @JoinColumn(name = "publisher_fk", referencedColumnName = "id")
    @ManyToOne
    private Publisher publisherFk;

    public Magazine() {
    }

    public Magazine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Integer getNumberPerYear() {
        return numberPerYear;
    }

    public void setNumberPerYear(Integer numberPerYear) {
        this.numberPerYear = numberPerYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<ShopOrder> getShopOrderList() {
        return shopOrderList;
    }

    public void setShopOrderList(List<ShopOrder> shopOrderList) {
        this.shopOrderList = shopOrderList;
    }

    public Publisher getPublisherFk() {
        return publisherFk;
    }

    public void setPublisherFk(Publisher publisherFk) {
        this.publisherFk = publisherFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magazine)) {
            return false;
        }
        Magazine other = (Magazine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.com.chernuhaiv.entity.Magazine[ id=" + id + " ]";
    }
    
}
