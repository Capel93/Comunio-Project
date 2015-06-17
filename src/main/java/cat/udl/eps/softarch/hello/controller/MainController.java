package cat.udl.eps.softarch.hello.controller;

import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import cat.udl.eps.softarch.hello.service.UserService;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.io.IOException;

/**
 * Created by joanmarc on 10/06/15.
 */

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    final Logger logger = LoggerFactory.getLogger(MainController.class);


    // LIST
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> list(@RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest request = new PageRequest(page, size);

        return userRepository.findAll(request).getContent();
    }

    // RETRIEVE
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User retrieve(@PathVariable("username") String username) {
        logger.info("Retrieving TeamSquad {}", username);
        Preconditions.checkNotNull(userRepository.findOne(username), "TeamSquad with id %s not found", username);
        return userRepository.findOne(username);
    }

    // CREATE
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@Valid @RequestBody User user, HttpServletResponse response) throws IllegalAccessException, XQException, IOException, JAXBException, InstantiationException, ClassNotFoundException {
        logger.info("User username:{}, email:{}, team:{}",user.getUsername(),user.getEmail(),user.getTeamSquad());
        //teamSquad.setManager(new User("vic","vv@vv.es"));
        User newUser = userService.addUser(user);
        logger.info("Created user with name'{}'", user.getUsername());
        return newUser;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User update(@PathVariable("username") String username, @Valid @RequestBody User user) {

        Preconditions.checkNotNull(userRepository.findOne(username), "user with id %s not found", username);
        return userRepository.save(user);
    }

}
