package restapi.controllers;

import DAO.PollDAO;
import models.Poll;
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
        PollDAO pollDAO = new PollDAO();
        Poll oldPoll = pollDAO.findById(id);
        poll.setPollId(oldPoll.getPollId());
        pollDAO.update(poll);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Long id) {
        PollDAO pollDAO = new PollDAO();
        Poll poll = pollDAO.findById(id);
        pollDAO.remove(poll);
    }
}
