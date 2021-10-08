import DAO.PollDAO;
import DAO.PollUserDAO;
import DAO.VoteDAO;
import models.*;
import java.util.*;




public class fillDB {
    /**
     * Populates the db with some test entries
     */

    public static void main(String[] args) {

        PollUserDAO dao_user = new PollUserDAO();
        PollDAO dao_poll = new PollDAO();
        VoteDAO dao_vote = new VoteDAO();

        List<PollUser> testUsers = new ArrayList<>();
        PollUser test_user = new PollUser();
        Poll test_poll = new Poll();
        Vote test_vote = new Vote();

//        test_user.setUserId(0);
        test_user.setName("Test Testesen");
        test_user.setEmail("Test@ikkel.no");
        test_user.setPassword("test");
        test_user.setAdmin(true);

//        test_poll.setPollId(0);
        test_poll.setPollCode("Bl1M3D");
        test_poll.setTitle("Hva kom først");
        test_poll.setDescription("Kyllingen eller egget");
        test_poll.setEndTime(new Date(2077, Calendar.SEPTEMBER, 18, 4, 20));
        test_poll.setCountYes(40);
        test_poll.setCountNo(20);
        test_poll.setStatus(Status.CREATED);
        test_poll.setOnlyRegistered(true);

//        test_vote.setVoteId(0);
        test_vote.setAnswer(Answer.YES);
        test_vote.setUser(dao_user.findById(1L));
        test_vote.setPool(dao_poll.findById(1L));

        dao_user.persist(test_user);

        dao_poll.persist(test_poll);

        dao_vote.persist(test_vote);

    }
}
