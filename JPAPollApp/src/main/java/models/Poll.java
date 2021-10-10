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
    private long id;

    private String pollCode;
    private String title;
    private String description;
    private Date endTime;
    // have start time too?
    private int countYes;
    private int countNo;
    private Status status;
    private boolean onlyRegistered;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private PollUser owner;

    @OneToMany(mappedBy = "poll")
    private List<Vote> votes;


}