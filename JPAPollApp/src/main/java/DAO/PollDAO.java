package DAO;

import models.Poll;
import models.PollUser;

import javax.persistence.Query;
import java.util.List;

public class PollDAO extends JpaDao<Poll, Long>{

    public PollDAO(){
        super();
    }

    public List<Poll> getOwnedPolls(String email){
        super.em.getTransaction().begin();
        Query query = super.em.createQuery(
                "SELECT p from Poll p WHERE p.user.email = :cemail"
        );

        List<Poll> pollList = query.setParameter("cemail", email).getResultList();

        return pollList;
    }


}
