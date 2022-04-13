package gcDemo.controller;


import gcDemo.model.User;
import gcDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getById/{userId}")
    public User getById(@PathVariable("userId") Long id){
        return userService.getById(id);
    }


}
