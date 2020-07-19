package com.pedrofactory.model;

import java.io.Serializable;
import java.util.Set;

public class Developer  implements Serializable {
    static final long serialVersionUID = 244196440647355245L;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private Long id;
    private Set<Skill> skills;
    private Account account;

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", skills=" + skills +
                ", account=" + account +
                '}';
    }
}
