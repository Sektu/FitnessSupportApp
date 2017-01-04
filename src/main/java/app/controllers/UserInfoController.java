package app.controllers;

import app.constants.Mappings;
import app.models.User;
import app.models.UserInfo;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Siergus
 */
@RestController
@RequestMapping(Mappings.API + Mappings.USER_INFO)
public class UserInfoController {
        
    @Autowired
    private UserRepository userRepository;
       
    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_INFO_GET)
    public String getByUserId(@PathVariable("userId") long userId) {
        User user;
        try {
            user = userRepository.findById(userId);
        }
        catch (Exception ex) {
            return "Error getting userInfo by UserId";
        }
        return user.getUserInfo().toString() + " for id: " + userId;
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Mappings.USER_INFO_UPDATE)
    public String update(@PathVariable("userId") long userId, @RequestBody UserInfo userInfo) {
        try {
            User user = userRepository.findById(userId);
            user.setUserInfo(userInfo);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error updating the userInfo: " + ex.toString();
        }
        return "Successfully updated UserInfo for User with userId: " + userId;
    }  
}
