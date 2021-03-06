package cat.udl.eps.softarch.hello.controller;

import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import cat.udl.eps.softarch.hello.service.UserService;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.io.IOException;

/**
 * Created by http://rhizomik.net/~roberto/
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired UserRepository       userRepository;



    @Autowired
    UserService userService;


    // LIST
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> list(@RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest request = new PageRequest(page, size);

        return userRepository.findAll(request).getContent();
    }

    // RETRIEVE
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User retrieve(@PathVariable("username") String username) {
        logger.info("Retrieving user {}", username);
        Preconditions.checkNotNull(userRepository.findOne(username), "User with id %s not found", username);
        return userService.getUser(username);
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@RequestBody User user, HttpServletResponse response) throws IllegalAccessException, XQException, IOException, JAXBException, InstantiationException, ClassNotFoundException {
        User u = userService.addUser(user);


        return u;
    }

    // RETRIEVE LOGGED USER
    @RequestMapping("/current")
    @ResponseBody
    public User user(@AuthenticationPrincipal User user) {
        logger.info("Retrieving current logged in user {}", user.getUsername());
        return userService.getUser(user.getUsername());
    }
}
