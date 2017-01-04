package app.controllers;

import app.constants.Mappings;
import app.models.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import app.repositories.UserRepository;
import app.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Mappings.API + Mappings.USERS)
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_GET_ALL)
    @ResponseBody
    public List<String> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_GET_BY_ID)
    @ResponseBody
    public String getById( @PathVariable("id") long id) {
        return userService.getById(id);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_GET_BY_EMAIL)
    @ResponseBody
    public String getByEmail(@PathVariable("email") String email) {
        String userId;
        try {
            User user = userRepository.findByEmail(email);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = Mappings.USER_CREATE)
    @ResponseBody
    public String create(@RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = Mappings.USER_DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") long id) {
        try {
            User user = new User(id);
            userRepository.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @RequestMapping(method = RequestMethod.PUT, value = Mappings.USER_UPDATE)
    @ResponseBody
    public String updateUser(@PathVariable("id") long id, @RequestBody User user) {
        try {
            User updatedUser = userRepository.findOne(id);
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            userRepository.save(updatedUser);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

}
