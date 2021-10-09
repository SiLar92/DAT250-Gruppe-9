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

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        VoteDAO vote_dao = new VoteDAO();
        vote_dao.remove(vote_dao.findById(id));

        // return some success / fail code??
    }

    @DeleteMapping("/delete/")
    public void deleteAll() {
        List<Vote> allVotes = new VoteDAO().getAll();
        VoteDAO vote_dao = new VoteDAO();
        for (Vote user : allVotes) {
            vote_dao.remove(vote_dao.findById(user.getId()));
        }

        // return some success / fail code??
    }


}