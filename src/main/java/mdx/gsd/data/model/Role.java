package mdx.gsd.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Entity
@Table(name = "Role") //It's not mandatory since the Table name and the class spelled the same
public class Role implements Serializable {

    /* I have omitted to make the correlation between fields and attributes
    when they have the same spelling */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignRole")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<User> user;

    @NotEmpty
    @Column(length = 20, nullable = false)
    private String roleName;

    public Role(Collection<User> user, Integer roleId, String roleName) {
        this.user = user;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public Role() {
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "id: " + roleId + " " + roleName;
    }
}
