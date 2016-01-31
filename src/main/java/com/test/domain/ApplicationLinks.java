package com.test.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ApplicationLinks", schema = "assign")
public class ApplicationLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer linkId;
    @Column(name = "link")
    private String link;

    @Column(name = "linkDescription")
    private String linkDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationLinks that = (ApplicationLinks) o;

        if (linkId != null ? !linkId.equals(that.linkId) : that.linkId != null) return false;
        return !(link != null ? !link.equals(that.link) : that.link != null);

    }

    @Override
    public int hashCode() {
        int result = linkId != null ? linkId.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public List<UserRoles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<UserRoles> rolesList) {
        this.rolesList = rolesList;
    }

    @ManyToMany(mappedBy = "applicationLinks", fetch = FetchType.EAGER)
    private List<UserRoles> rolesList = new ArrayList<>();

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }
}
