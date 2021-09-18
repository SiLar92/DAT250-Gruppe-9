package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "poll")
@Entity
@Data
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pollId;

    private int pollCode;
    private String title;
    private String description;
    private Date endTime;
    private int countYes;
    private int countNo;
    private boolean published;

    @ManyToOne
    private PollUser user;

    @OneToMany(mappedBy = "pool")
    private List<Vote> votes;





}