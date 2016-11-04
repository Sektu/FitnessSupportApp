package app.controllers;

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
  @RequestMapping("/create")
  @ResponseBody
  public String create(String email, String name) {
    User user = null;
    try {
      user = new User(email, name);
      userRepository.save(user);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created! (id = " + user.getId() + ")";
  }
  
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userRepository.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userRepository.findByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }
  
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(long id, String email, String name) {
    try {
      User user = userRepository.findOne(id);
      user.setEmail(email);
      user.setName(name);
      userRepository.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }
  
  @RequestMapping("/get-all-users-names")
  @ResponseBody
  public List<String> getAllUsersNames() {
      List<String> response = new ArrayList<String>();
      List<User> users = userRepository.findAll();
      
      try {
          for(User u : users) {
          response.add(u.getName());
            }
      }
      catch(Exception ex) {
          response.clear();
          response.add("Error getting all users' names");
          return response;
      }
      return response;
  }
  
  @Autowired
  private UserRepository userRepository;
  
}
