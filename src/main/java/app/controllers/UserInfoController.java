package app.controllers;

import app.constants.Mappings;
import app.models.UserInfo;
import app.services.UserInfoService;
import java.util.List;
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
    private UserInfoService userInfoService;
    
    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_INFO_GET)
    public String getByUserId(@PathVariable("userId") long userId) {
        return userInfoService.getByUserId(userId);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Mappings.USER_INFO_UPDATE)
    public String update(@PathVariable("userId") long userId, @RequestBody UserInfo userInfo) {
        return userInfoService.update(userId, userInfo);
    }  

    @RequestMapping(method = RequestMethod.GET, value = Mappings.USER_INFO_GET_ALL)
    public List<String> getAll() {
        return userInfoService.getAll();
    }
}
