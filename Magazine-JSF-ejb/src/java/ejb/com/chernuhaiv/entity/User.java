/*

 */
package ejb.com.chernuhaiv.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "shop_user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByEmailPk", query = "SELECT u FROM User u WHERE u.emailPk = :emailPk"),
    @NamedQuery(name = "User.findByBanned", query = "SELECT u FROM User u WHERE u.banned = :banned"),
    @NamedQuery(name = "User.findByDiscount", query = "SELECT u FROM User u WHERE u.discount = :discount"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email_pk")
    private String emailPk;
    @Column(name = "banned")
    private Integer banned;
    @Column(name = "discount")
    private Integer discount;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "userFk")
    private List<ShopOrder> shopOrderList;

    public User() {
    }

    public User(String emailPk) {
        this.emailPk = emailPk;
    }

    public String getEmailPk() {
        return emailPk;
    }

    public void setEmailPk(String emailPk) {
        this.emailPk = emailPk;
    }

    public Integer getBanned() {
        return banned;
    }

    public void setBanned(Integer banned) {
        this.banned = banned;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ShopOrder> getShopOrderList() {
        return shopOrderList;
    }

    public void setShopOrderList(List<ShopOrder> shopOrderList) {
        this.shopOrderList = shopOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailPk != null ? emailPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.emailPk == null && other.emailPk != null) || (this.emailPk != null && !this.emailPk.equals(other.emailPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.com.chernuhaiv.entity.User[ emailPk=" + emailPk + " ]";
    }
    
}
