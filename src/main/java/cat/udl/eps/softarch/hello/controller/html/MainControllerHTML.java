package cat.udl.eps.softarch.hello.controller.html;

import cat.udl.eps.softarch.hello.controller.MainController;
import cat.udl.eps.softarch.hello.controller.UserController;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import cat.udl.eps.softarch.hello.service.RepositoryUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class MainControllerHTML {

    final Logger logger = LoggerFactory.getLogger(MainControllerHTML.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    MainController mainController;

    @Autowired
    UserController userController;




    @RequestMapping(value = "/mainPage/{username}", method = {RequestMethod.GET}, produces = "text/html")
    public ModelAndView mainPageHTML(@PathVariable("username") String username) {

        User user = userRepository.findOne(username);

        return new ModelAndView("mainPage", "user", user);
    }


    // CREATE
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces="text/html")
    public String loginHTML( @ModelAttribute("user") User user, BindingResult binding, HttpServletResponse response) {

        logger.info("User username:{}, email:{} ",user.getUsername(),user.getEmail());
        User loggedUser = mainController.retrieve(user.getUsername());

        if(loggedUser==null){
            return "redirect:login";
        }

        if(loggedUser.getPassword().equals(user.getPassword())){
            return "redirect:mainPage/"+loggedUser.getUsername();
        }

        return "redirect:login";
    }


    // Create form
    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/html")
    public ModelAndView loginForm() {


        User emptyUser = new User();


        return new ModelAndView("login", "user", emptyUser);
    }

    // CREATE
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces="text/html")
    public String registerHTML(@Valid @ModelAttribute("user") User user, BindingResult binding, HttpServletResponse response) throws IllegalAccessException, XQException, IOException, JAXBException, InstantiationException, ClassNotFoundException {

        logger.info("User username:{}, email:{}, team:{}",user.getUsername(),user.getEmail(),user.getTeamSquad());
        //mainController.create(user,response).

        return "redirect:mainPage/"+mainController.create(user,response).getUsername();
    }


    // Create form
    @RequestMapping(value = "/register", method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/html")
    public ModelAndView registerForm() {

        User emptyUser = new User();

        return new ModelAndView("register", "user", emptyUser);
    }



}
