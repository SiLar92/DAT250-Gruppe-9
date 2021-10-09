package restapi.controllers;

import DAO.PollUserDAO;
import models.PollUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    /**
     * Read all users
     * @return List of all users
     */
    @GetMapping("")
    public List<PollUser> getAll() {
        return new PollUserDAO().getAll();
    }


    /**
     * Get a user by user ID
     * @param id the id of the user to get
     * @return the user matching the id
     */
    @GetMapping("/{id}")
    public PollUser getById(@PathVariable Long id) {
        return new PollUserDAO().findById(id);
    }


    /**
     * Create User
     * @param newUser the new user as JSON
     */
    @PostMapping("")
    public void create(@RequestBody PollUser newUser) {
        PollUserDAO user_dao = new PollUserDAO();
        user_dao.persist(newUser);

        // return some success / fail code??
    }

    /**
     * Update user record
     * @param newUser JSON of the new user details
     * @param id not needed if user contains id?
     */
    @PutMapping("/{id}")
    public void update(@RequestBody PollUser newUser, @PathVariable Long id) {
        PollUserDAO user_dao = new PollUserDAO();
        PollUser current = user_dao.findById(id);

        // updates individual fields if specified
        if(newUser.getName() == null)
            newUser.setName(current.getName());
        if(newUser.getEmail()== null)
            newUser.setEmail(current.getEmail());
        if(newUser.getPassword()==null)
            newUser.setPassword(current.getPassword());
        if(newUser.getPolls()==null)
            newUser.setPolls(current.getPolls());
        if(newUser.getVotes()==null)
            newUser.setVotes(current.getVotes());

        newUser.setId(current.getId());
        // ensures poll id does not get changed even if specified in PUT
        // could change this to allow userID change, but we really should not

        user_dao.update(newUser);
    }


    /**
     *
     * @param id of the user to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        PollUserDAO user_dao = new PollUserDAO();
        user_dao.remove(user_dao.findById(id));

        // return some success / fail code??
    }

    /**
     * Method to easily clear db of users for testing
     */
    @DeleteMapping("")
    public void deleteAll() {
        List<PollUser> allUsers = new PollUserDAO().getAll();
        PollUserDAO user_dao = new PollUserDAO();
        for (PollUser user : allUsers) {
            user_dao.remove(user_dao.findById(user.getId()));
        }

        // return some success / fail code??
    }
}