package chelsea.firstone.social.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final IUserService userService;

    @Autowired
    UserController(IUserService userService) {

        this.userService = userService;

    }


    @RequestMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/delete")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

}


