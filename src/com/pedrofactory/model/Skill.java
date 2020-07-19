package com.pedrofactory.model;

import java.io.Serializable;

public class Skill implements Serializable {
    static final long serialVersionUID = 2441964406473552L;

    Long id;
    String name;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
