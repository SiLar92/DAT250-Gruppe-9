package DAO;

import models.Poll;
import models.PollUser;

import javax.persistence.Query;
import java.util.List;

public class PollDAO extends JpaDao<Poll, Long>{

    public PollDAO(){
        super();
    }
}
