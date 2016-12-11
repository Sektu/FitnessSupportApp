package app.controllers;

import app.constants.Mappings;
import app.models.User;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import app.repositories.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(Mappings.USER_CREATE_BY_EMAIL_AND_PASSWORD)
    @ResponseBody
    public String create(String email, String password) {
        User user = null;
        try {
            user = new User(email, password);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    @RequestMapping(Mappings.USER_DELETE_BY_ID)
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userRepository.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }
    
    @RequestMapping(Mappings.USER_GET_BY_ID)
    @ResponseBody
    public String getByEmail(long id) {
        String userId;
        try {
            User user = userRepository.findById(id);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }
    
    @RequestMapping(Mappings.USER_GET_BY_EMAIL)
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User user = userRepository.findByEmail(email);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    @RequestMapping(Mappings.USER_UPDATE_EMAIL_AND_PASSWORD_BY_ID)
    @ResponseBody
    public String updateUser(long id, String email, String password) {
        try {
            User user = userRepository.findOne(id);
            user.setEmail(email);
            user.setPassword(password);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
    
    @RequestMapping(Mappings.USER_UPDATE_PASSWORD_BY_EMAIL)
    @ResponseBody
    public String updateUser(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            user.setPassword(password);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @RequestMapping(Mappings.USER_GET_ALL_EMAILS)
    @ResponseBody
    public List<String> getAllUsersEmails() {
        List<String> response = new ArrayList<String>();
        List<User> users = userRepository.findAll();

        try {
            for (User u : users) {
                response.add(u.getEmail());
            }
        } catch (Exception ex) {
            response.clear();
            response.add("Error getting all users' names");
            return response;
        }
        return response;
    }

}
