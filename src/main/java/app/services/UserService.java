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
    
    
}
