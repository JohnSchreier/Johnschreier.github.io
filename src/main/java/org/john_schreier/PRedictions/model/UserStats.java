package org.john_schreier.PRedictions.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class UserStats implements Serializable {
    //    This class binds a user's personalized goals and history to an object to be saved in the db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String goals;
    @Column
    private String history;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id", referencedColumnName = "id")
    private Coach coach;

    @OneToOne
//    @JoinColumn(name="email")
    private User user;


    public UserStats() {
    }

    public UserStats(long id, String goals, String history, Coach coach, User user) {
        this.id = id;
        this.goals = goals;
        this.history = history;
        this.coach = coach;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

