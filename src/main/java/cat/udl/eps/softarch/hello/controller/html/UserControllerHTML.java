package cat.udl.eps.softarch.hello.controller.html;

import cat.udl.eps.softarch.hello.controller.TeamSquadController;
import cat.udl.eps.softarch.hello.controller.UserController;
import cat.udl.eps.softarch.hello.model.*;
import cat.udl.eps.softarch.hello.repository.CommunityRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.io.IOException;
import java.util.List;

/**
 * Created by http://rhizomik.net/~roberto/
 */

@Controller
@RequestMapping(value = "/users")
public class UserControllerHTML {
    final Logger logger = LoggerFactory.getLogger(UserControllerHTML.class);

    @Autowired
    UserRepository       userRepository;

    @Autowired
    UserController       userController;
    @Autowired
    TeamSquadRepository teamSquadRepository;
    @Autowired
    TeamSquadController teamSquadController;
    @Autowired
    CommunityRepository communityRepository;

    // LIST
    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHTML(@RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        return new ModelAndView("users", "users", userController.list(page, size));
    }

    // LIST
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<User> listJSON(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int size) {
        return userController.list(page, size);
    }

    // RETRIEVE
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHTML(@PathVariable("username") String username) {
        return new ModelAndView("user", "user", userController.retrieve(username));
    }
    // RETRIEVE
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "application/json")
    public User retrieveJSON(@PathVariable("username") String username) {
        return userController.retrieve(username);
    }





    // CREATE
    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces="text/html")
    public String createHTML(@ModelAttribute("user") User user, BindingResult binding, HttpServletResponse response) throws IllegalAccessException, XQException, IOException, JAXBException, InstantiationException, ClassNotFoundException {

        logger.info("User username:{}, email:{}, community:{}, team:{} ",user.getUsername(),user.getEmail(),user.getCommunity(),user.getTeamSquad());
        return "redirect:users/"+userController.create(user, response).getUsername();
    }

    // Create form
    @RequestMapping(value = "/userForm", method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/html")
    public ModelAndView createForm() {

        User emptyUser = new User();

        return new ModelAndView("userForm", "user", emptyUser);
    }
}


