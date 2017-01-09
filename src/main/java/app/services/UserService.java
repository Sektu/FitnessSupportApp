package app.services;

import app.models.User;
import app.repositories.UserRepository;
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
    
    public List<User> getUsers() {
        List<User> users;
        try {
            users = userRepository.findAll();
        } catch (Exception ex) {
            return null;
        }
        return users;
    }
    
    public User getUser(long id) {
        User user;
        try {
            user = userRepository.findById(id);
        } catch (Exception ex) {
            return null;
        }
        return user;
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
