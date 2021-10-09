package restapi.controllers;

import DAO.PollDAO;
import DAO.PollUserDAO;
import DAO.VoteDAO;
import models.Poll;
import models.Vote;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/poll")
public class PollController {


    @GetMapping("")
    public List<Poll> getPolls() {
        return new PollDAO().getAll();
    }

    /**
     * returns specific polls by id
     * example where id is 3:  /poll/3
     *
     * @param poll_id of poll
     * @return poll by id
     */
    @GetMapping("/{poll_id}")
    public Poll getById(@PathVariable Long poll_id) {
        return new PollDAO().findById(poll_id);
    }


    /**
     * Create/POST method
     *
     * @param poll the new poll
     * @param user_id The user_id of the poll owner
     */
    @PostMapping("/create/{user_id}")
    public void postPoll(@RequestBody Poll poll,@PathVariable Long user_id) {
        PollUserDAO user_dao = new PollUserDAO();
        poll.setOwner(user_dao.findById(user_id));
        new PollDAO().persist(poll);
    }

//    /**
//     * TODO
//     * A somewhat problematic update method.
//     * Are not able to get if the pole is only for registered.
//     * Which makes the status false by default,
//     * so remember to give correct status.
//     * @param poll
//     * @param id
//     */
//
//    @PutMapping("/{id}")
//    public void updatePoll(@RequestBody Poll poll, @PathVariable Long id) {
//        // Leaves fields as null if not present in JSON put message
//        //
//
//        PollDAO pollDAO = new PollDAO();
//        Poll oldPoll = pollDAO.findById(id);
//
//        if (poll.getPollCode() == null)
//            poll.setPollCode(oldPoll.getPollCode());
//        if (poll.getTitle() == null)
//            poll.setTitle(oldPoll.getTitle());
//        if (poll.getDescription() == null)
//            poll.setDescription(oldPoll.getDescription());
//        if (poll.getEndTime() == null)
//            poll.setEndTime(oldPoll.getEndTime());
//        if (poll.getStatus() == null)
//            poll.setStatus(oldPoll.getStatus());
//        if (poll.getUser()==null)
//            poll.setUser(oldPoll.getUser());
////        if (poll.getOnlyRegistered() == null)
////            poll.setOnlyRegistered(oldPoll.getOnlyRegistered());
//
//
//
//        poll.setCountYes(oldPoll.getCountYes());
//        poll.setCountNo(oldPoll.getCountNo());
//        poll.setId(oldPoll.getId());
//
//        pollDAO.update(poll);
//    }


    // TODO update status

    @PutMapping(value = "/{poll_id}/{user_id}/vote")
    public void createVote(@RequestBody Vote vote, @PathVariable final Long poll_id, @PathVariable final Long user_id){
        VoteDAO vote_dao = new VoteDAO();
        PollUserDAO user_dao = new PollUserDAO();
        PollDAO poll_dao = new PollDAO();
        vote.setUser(user_dao.findById(user_id));
        vote.setPoll(poll_dao.findById(poll_id));
        vote_dao.persist(vote);
    }



















































    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Long id) {
        PollDAO pollDAO = new PollDAO();
        Poll poll = pollDAO.findById(id);
        pollDAO.remove(poll);
    }

    /**
     * Method to easily clear db of polls for testing
     */
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        List<Poll> allPolls = new PollDAO().getAll();
        PollDAO pollDAO = new PollDAO();
        for (Poll poll : allPolls) {
            pollDAO.remove(pollDAO.findById(poll.getId()));
        }

        // return some success / fail code??
    }
}
