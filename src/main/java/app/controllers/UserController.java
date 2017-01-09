package app.controllers;

import app.constants.Mappings;
import app.models.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_GET_ALL)
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_GET_BY_ID)
    @ResponseBody
    public User getUser( @PathVariable("id") long id) {
        return userService.getUser(id);
    }
        
    @RequestMapping(method = RequestMethod.POST, value = Mappings.USER_CREATE)
    @ResponseBody
    public String create(@RequestBody User user) {
        return userService.create(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = Mappings.USER_DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") long id) {
        return userService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = Mappings.USER_UPDATE)
    @ResponseBody
    public String update(@PathVariable("id") long id, @RequestBody User user) {
        return userService.update(id, user);
    }

}
