package models;

import lombok.Data;

import javax.persistence.*;

@Table(name = "vote")
@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long voteId;

    private boolean yesNo;

    @ManyToOne
    private PollUser user;

    @ManyToOne
    private Poll pool;




}