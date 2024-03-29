package org.john_schreier.PRedictions.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Coach implements Serializable {
    //    Coach class which is binds a coach's first name, last name, and auto generated id to an object
//    Each User/UserStats gets one Coach, but a Coach can be connected to multiple UserStats/Users
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String coachFirstName;
    @Column
    private String coachLastName;

    @OneToMany(mappedBy = "coach")
    private Set<UserStats> stats = new HashSet<>();

    public Coach() {
    }

    public Coach(Long id, String coachFirstName, String coachLastName) {
        this.id = id;
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoachFirstName() {
        return coachFirstName;
    }

    public void setCoachFirstName(String coachFirstName) {
        this.coachFirstName = coachFirstName;
    }

    public String getCoachLastName() {
        return coachLastName;
    }

    public void setCoachLastName(String coachLastName) {
        this.coachLastName = coachLastName;
    }
}