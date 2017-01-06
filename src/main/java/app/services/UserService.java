package app.services;

import app.models.User;
import app.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Siergus
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<String> getAllUsers() {
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
    
    public String getById(long id) {
        String userEmail;
        try {
            User user = userRepository.findById(id);
            userEmail = String.valueOf(user.getEmail());
        } catch (Exception ex) {
            return "User not found";
        }
        return "The user is: " + userEmail;
    }
    
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
    
    public String create(User user) {
        try {
            userRepository.save(user);
        } 
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }
    
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
    
    public String update(long id, User user) {
        try {
            User tempUser = userRepository.findOne(id);
            tempUser.setEmail(user.getEmail());
            tempUser.setPassword(user.getPassword());
            userRepository.save(tempUser);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
    
}
