package restapi.controllers;

import DAO.PollDAO;
import DAO.PollUserDAO;
import models.Poll;
import models.PollUser;
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
     * @param id of poll
     * @return poll by id
     */
    @GetMapping("/{id}")
    public Poll getById(@PathVariable Long id) {
        return new PollDAO().findById(id);
    }

    @PostMapping("")
    public void postPoll(@RequestBody Poll poll) {
        new PollDAO().persist(poll);
    }

    @PutMapping("/{id}")
    public void updatePoll(@RequestBody Poll poll, @PathVariable Long id) {
        // Leaves fields as null if not present in JSON put message
        //

        PollDAO pollDAO = new PollDAO();
        Poll oldPoll = pollDAO.findById(id);

        if (poll.getPollCode() == null)
            poll.setPollCode(oldPoll.getPollCode());
        if (poll.getTitle() == null)
            poll.setTitle(oldPoll.getTitle());
        if (poll.getDescription() == null)
            poll.setDescription(oldPoll.getDescription());
        if (poll.getEndTime() == null)
            poll.setEndTime(oldPoll.getEndTime());
        if (poll.getStatus() == null)
            poll.setStatus(oldPoll.getStatus());
//        if (poll.getOnlyRegistered() == null)
//            poll.setOnlyRegistered(oldPoll.getOnlyRegistered());


        poll.setCountYes(oldPoll.getCountYes());
        poll.setCountNo(oldPoll.getCountNo());
        poll.setPollId(oldPoll.getPollId());

        pollDAO.update(poll);
    }

    // TODO update status

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
            pollDAO.remove(pollDAO.findById(poll.getPollId()));
        }

        // return some success / fail code??
    }
}
