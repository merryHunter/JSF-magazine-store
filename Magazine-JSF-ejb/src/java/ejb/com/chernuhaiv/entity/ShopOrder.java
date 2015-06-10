/*

 */
package ejb.com.chernuhaiv.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chernuhaiv@gmail.com
 */
@Entity
@Table(name = "shop_order")
@NamedQueries({
    @NamedQuery(name = "ShopOrder.findAll", query = "SELECT s FROM ShopOrder s"),
    @NamedQuery(name = "ShopOrder.findById", query = "SELECT s FROM ShopOrder s WHERE s.id = :id"),
    @NamedQuery(name = "ShopOrder.findByExpireDate", query = "SELECT s FROM ShopOrder s WHERE s.expireDate = :expireDate")})
public class ShopOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "expire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @JoinColumn(name = "magazine_fk", referencedColumnName = "id")
    @ManyToOne
    private Magazine magazineFk;
    @JoinColumn(name = "user_fk", referencedColumnName = "email_pk")
    @ManyToOne
    private User userFk;

    public ShopOrder() {
    }

    public ShopOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Magazine getMagazineFk() {
        return magazineFk;
    }

    public void setMagazineFk(Magazine magazineFk) {
        this.magazineFk = magazineFk;
    }

    public User getUserFk() {
        return userFk;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
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
        if (!(object instanceof ShopOrder)) {
            return false;
        }
        ShopOrder other = (ShopOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.com.chernuhaiv.entity.ShopOrder[ id=" + id + " ]";
    }
    
}
