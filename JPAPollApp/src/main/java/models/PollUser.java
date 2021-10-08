package models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "pollUser")
@Entity
@Data
public class PollUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String email;
    private String name;


    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private String password;
    private boolean admin;

    @OneToMany
    private List<Poll> polls;

    @OneToMany(mappedBy = "user")
    private List<Vote> votes;
}