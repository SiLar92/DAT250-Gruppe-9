package restapi.controllers;

import DAO.PollDAO;
import DAO.PollUserDAO;
import DAO.VoteDAO;
import models.Vote;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vote")
public class VoteController {


    @PutMapping(value = "/{poll_id}/{user_id}")
    public void createVote(@RequestBody Vote vote, @PathVariable final Long poll_id, @PathVariable final Long user_id) {
        VoteDAO vote_dao = new VoteDAO();
        PollUserDAO user_dao = new PollUserDAO();
        PollDAO poll_dao = new PollDAO();
        vote.setUser(user_dao.findById(user_id));
        vote.setPoll(poll_dao.findById(poll_id));
        vote_dao.persist(vote);
    }

    @GetMapping("")
    public List<Vote> getAll() {
        return new VoteDAO().getAll();
    }

    @GetMapping("/{vote_id}")
    public Vote getById(@PathVariable Long vote_id) {
        return new VoteDAO().findById(vote_id);
    }

    @DeleteMapping("/{vote_id}")
    public void delete(@PathVariable Long vote_id) {
        VoteDAO vote_dao = new VoteDAO();
        vote_dao.remove(vote_dao.findById(vote_id));

        // return some success / fail code??
    }



    @DeleteMapping("")
    public void deleteAll() {
        List<Vote> allVotes = new VoteDAO().getAll();
        VoteDAO vote_dao = new VoteDAO();
        for (Vote user : allVotes) {
            vote_dao.remove(vote_dao.findById(user.getId()));
        }

        // return some success / fail code??
    }


}