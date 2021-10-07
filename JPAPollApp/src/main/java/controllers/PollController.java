package controllers;

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
    // /poll?id=3
   /* @GetMapping("/poll")
    public Poll getPoll(@RequestParam(value = "id") Long id) {
        return new PollDAO().findById(id);
    }*/


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


}
