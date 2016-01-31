package com.test.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "userRoles")
@Table(name = "UserRole", schema = "assign")
public class UserRoles {

    @Id
    @Column(name = "roleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "roleName")
    private String roleName;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "userRoles")
    private List<Userdetails> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ROLE_APPLICATIONLINK", schema = "assign", joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "APPLICATIONLINK_ID", referencedColumnName = "linkId")}
    )
    private Set<ApplicationLinks> applicationLinks;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        return !(roleId != null ? !roleId.equals(userRoles.roleId) : userRoles.roleId != null);

    }

    @Override
    public int hashCode() {
        return roleId != null ? roleId.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRoles{");
        sb.append("roleId=").append(roleId);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Userdetails> getUsers() {
        return users;
    }

    public void setUsers(List<Userdetails> users) {
        this.users = users;
    }

    public Set<ApplicationLinks> getApplicationLinks() {
        return applicationLinks;
    }

    public void setApplicationLinks(Set<ApplicationLinks> applicationLinks) {
        this.applicationLinks = applicationLinks;
    }
}
