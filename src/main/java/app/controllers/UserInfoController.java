package app.controllers;

import app.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Siergus
 */
@Controller
public class UserInfoController {
    
    @Autowired
    private UserInfoRepository userInfoRepository;
    
    
}
