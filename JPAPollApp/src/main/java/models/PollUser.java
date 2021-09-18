package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "pollUser")
@Entity
@Data
public class PollUser {

    @Id
    private String email;

    private String name;
    private String password;
    private boolean admin;

    @OneToMany
    private List<Poll> polls;

    @OneToMany(mappedBy = "user")
    private List<Vote> votes;
}