package com.erdna.cycletrap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by André Nitzschke on 23/04/16.
 */
@Entity
public class Trap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;

    protected Trap() {
    }

    public Trap(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Trap[id=%d, name='%s']", id, name);
    }

}