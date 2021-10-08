package restapi.controllers;

import DAO.PollDAO;
import DAO.PollUserDAO;
import models.Poll;
import models.PollUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @GetMapping("")
    public List<PollUser> getAll() {
        return new PollUserDAO().getAll();
    }

    @GetMapping("/{id}")
    public PollUser getById(@PathVariable Long id) {
        return new PollUserDAO().findById(id);
    }

//    @PostMapping("")
//    public void postUser(@RequestBody Poll poll) {
//        new PollDAO().persist(poll);
//    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody Poll poll, @PathVariable Long id) {
//        PollDAO pollDAO = new PollDAO();
//        Poll oldPoll = pollDAO.findById(id);
//        poll.setPollId(oldPoll.getPollId());
//        pollDAO.update(poll);
//

        // finn gammel? oppdater verdien?
        PollUserDAO user_dao = new PollUserDAO();
        user_dao.update(user_dao.findById(id));




    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        PollUserDAO user_dao = new PollUserDAO();
        user_dao.remove(user_dao.findById(id));
    }
}