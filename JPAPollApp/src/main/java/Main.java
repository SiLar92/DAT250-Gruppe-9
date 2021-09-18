import DAO.PollDAO;
import DAO.PollUserDAO;
import models.Poll;
import models.PollUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        PollDAO pollDAO = new PollDAO();

        /**Poll poll = new Poll();

        PollUser user = new PollUser();
        user.setAdmin(false);
        user.setEmail("magnus.leira@gmail.com");
        user.setName("Magnus Leira");

        PollUserDAO pollUserDAO = new PollUserDAO();

        pollUserDAO.persist(user);


        poll.setUser(user);
        poll.setPollCode(5443);
        poll.setCountYes(12);

        pollDAO.persist(poll);**/

        List<Poll> pollList = pollDAO.getAll();
        System.out.println(pollList.size());







         //Poll p = pollDAO.findById((long)3);
        //System.out.println(p.getPollCode());
/**
        List<Poll> pollList = pollDAO.getOwnedPolls("magnus.leira@gmail.com");

        System.out.println(pollList.size());


        final String PERSISTENCE_UNIT_NAME = "poll";
        EntityManagerFactory factory;

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // read the existing entries
        //Query q = em.createQuery("select u from User u");
        // Persons should be empty

        // do we have entries?
       // boolean createNewEntries = (q.getResultList().size() == 0);

        // No, so lets create new entries
        //if (createNewEntries) {
            PollUser user = new PollUser();
            user.setName("Hare");
            user.setEmail("hare.pus@gmail.com");
            user.setPassword("Harepus1");
            user.setAdmin(false);

            List<Poll> pollList = new ArrayList<Poll>();
            for (int i = 0; i < 4; i++) {
                Poll poll = new Poll();
                poll.setTitle("poll"+i);
                poll.setDescription(i+". poll");
                poll.setCountYes(i+10);
                poll.setCountNo(i);
                poll.setCountNo(i*2+10);
                pollList.add(poll);
                em.persist(poll);
                // now persists the family person relationship


            }
            user.setPolls(pollList);
            em.persist(user);


        // Commit the transaction, which will cause the entity to
        // be stored in the database
        em.getTransaction().commit();

        // It is always good practice to close the EntityManager so that
        // resources are conserved.
        em.close();**/


    }
}
