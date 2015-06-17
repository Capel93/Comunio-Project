package cat.udl.eps.softarch.hello.controller.html;

import cat.udl.eps.softarch.hello.controller.MarketController;
import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.CommunityRepository;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import cat.udl.eps.softarch.hello.service.TeamSquadPlayerService;
import cat.udl.eps.softarch.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmarc on 12/06/15.
 */
@Controller
@RequestMapping(value = "/market")
public class MarketControllerHTML {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    MarketController marketController;

    @Autowired
    UserService userService;

    @Autowired
    TeamSquadRepository teamSquadRepository;

    @Autowired
    TeamSquadPlayerService teamSquadPlayerService;

    @Autowired
    UserRepository userRepository;




    // LIST
    @RequestMapping(value="/{username}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listUserHTML(@PathVariable( "username" ) String username,
                                    @RequestParam(required=false, defaultValue="0") int page,
                                    @RequestParam(required=false, defaultValue="200") int size) {

        List<Player> players;
        if(playerRepository.findAll().size()>0){
            players = playerRepository.findAll();

        }else{
            players = marketController.list(page,size);
            for (Player p:players){
                System.out.println("player nick ::::: "+p.getNick());
            }
        }

        ModelAndView model = new ModelAndView("market", "players", players);

        User user = userService.getUser(username);

        model.addObject("user",user);


        return model;
    }

    // UPDATE
    @RequestMapping(value = "/{username}/{nick}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.OK)
    public String updateHTML(@PathVariable("username") String username, @PathVariable("nick") String nick) {



        Player p = playerRepository.findOne(nick);



        if(p!=null){
            teamSquadPlayerService.addTitularPlayer(username,p);

        }


        return "redirect:/teamSquads/"+username;

    }


    // LIST
    @RequestMapping(value="/{nick}", method = RequestMethod.GET, produces = "application/json")
    public Player retrivePlayerJSON(@PathVariable("nick") String nick,
            @RequestParam(required=false, defaultValue="0") int page,
                                     @RequestParam(required=false, defaultValue="200") int size) {

        Player player = playerRepository.findOne(nick);


        return player;
    }


    // LIST
    @RequestMapping(value="/", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Player> listJSON(@RequestParam(required=false, defaultValue="0") int page,
                                     @RequestParam(required=false, defaultValue="200") int size) {

        List<Player> players;
        if(playerRepository.findAll().size()>0){
            players = playerRepository.findAll();

        }else{
            players = marketController.list(page,size);
            for (Player p:players){
                System.out.println("player nick ::::: "+p.getNick());
            }
        }


        return players;
    }

}
