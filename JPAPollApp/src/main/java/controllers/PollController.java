package controllers;

import DAO.PollDAO;
import models.Poll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PollController {


    @GetMapping("/polls")
    public List<Poll> getPolls() {
        return new PollDAO().getAll();
    }

    @GetMapping("/poll")
    public Poll getPoll(@RequestParam(value = "id") Long id) {
        return new PollDAO().findById(id);
    }


}
