package restapi.controllers;

import DAO.VoteDAO;
import models.Vote;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vote")
public class VoteController {
    @GetMapping("")
    public List<Vote> getAll() {
        return new VoteDAO().getAll();
    }


    @GetMapping("/{id}")
    public Vote getById(@PathVariable Long id) {
        return new VoteDAO().findById(id);
    }

    @PutMapping("")
    public void create(@RequestBody Vote newVote) {
        VoteDAO vote_dao = new VoteDAO();
        vote_dao.persist(newVote);
        // return some success / fail code??
    }

    /**
     *
     * @param id of the user to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        VoteDAO vote_dao = new VoteDAO();
        vote_dao.remove(vote_dao.findById(id));

        // return some success / fail code??
    }

    /**
     * Method to easily clear db of users for testing
     */
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        List<Vote> allVotes = new VoteDAO().getAll();
        VoteDAO vote_dao = new VoteDAO();
        for (Vote user : allVotes) {
            vote_dao.remove(vote_dao.findById(user.getVoteId()));
        }

        // return some success / fail code??
    }
}
