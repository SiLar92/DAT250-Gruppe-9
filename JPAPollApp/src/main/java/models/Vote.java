package models;

import lombok.Data;

import javax.persistence.*;

@Table(name = "vote")
@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Answer answer;

    @ManyToOne
    @JoinColumn(name="user_id")
    private PollUser user;

    @ManyToOne
    @JoinColumn(name="poll_id")
    private Poll poll;


}