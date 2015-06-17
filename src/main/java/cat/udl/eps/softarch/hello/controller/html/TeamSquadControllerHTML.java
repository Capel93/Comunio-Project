package cat.udl.eps.softarch.hello.controller.html;


import cat.udl.eps.softarch.hello.controller.TeamSquadController;
import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.Team;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import cat.udl.eps.softarch.hello.service.UserTeamService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by joanmarc on 21/05/15.
 */
@Controller
@RequestMapping(value = "/teamSquads")
public class TeamSquadControllerHTML {

    @Autowired
    UserTeamService userTeamService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TeamSquadController teamSquadController;
    @Autowired
    TeamSquadRepository teamSquadRepository;

    @Autowired
    PlayerRepository playerRepository;


    // LIST
    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHTML(@RequestParam(required=false, defaultValue="0") int page,
                                 @RequestParam(required=false, defaultValue="10") int size) {
        return new ModelAndView("teamSquads", "teamSquads", teamSquadController.list(page, size));
    }

    // LIST
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<TeamSquad> listJSON(@RequestParam(required=false, defaultValue="0") int page,
                                 @RequestParam(required=false, defaultValue="10") int size) {
        return  teamSquadController.list(page, size);
    }

    // RETRIEVE
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHTML(@PathVariable( "username" ) String username) {

        List<Player> players = playerRepository.findAll();

        User user = userRepository.findOne(username);


        List<Player> teamPlayers = new ArrayList<>();

        for (Player p: players){
            if(p.getTeamSquad().equals(user.getTeamSquad())){
                teamPlayers.add(p);
            }
        }

        ModelAndView modelAndView = new ModelAndView("teamSquad", "players", teamPlayers);

        modelAndView.addObject("user",user);

        return modelAndView;
    }

    // RETRIEVE
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Player> retrieveJSON(@PathVariable( "username" ) String username) {

        List<Player> players = playerRepository.findAll();

        User user = userRepository.findOne(username);


        List<Player> teamPlayers = new ArrayList<>();

        for (Player p: players){
            if(p.getTeamSquad().equals(user.getTeamSquad())){
                teamPlayers.add(p);
            }
        }

        return teamPlayers;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces="text/html")
    public String createHTML(@Valid @ModelAttribute("teamSquad") TeamSquad teamSquad, BindingResult binding, HttpServletResponse response) {
        /*if (binding.hasErrors()) {

            return "teamSquadForm";
        }*/

        return "redirect:teamSquads/"+teamSquadController.create(teamSquad, response).getId();
    }

    // Create form
    @RequestMapping(value = "/teamSquadForm/{name}", method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/html")
    public ModelAndView createForm(@PathVariable("name") String name) {

        //TeamSquad emptyTeamSquad = setPlayerList();
        TeamSquad emptyTeamSquad=new TeamSquad();
        return new ModelAndView("teamSquadForm", "teamSquad", emptyTeamSquad);
    }

    // UPDATE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.OK)
    public String updateHTML(@PathVariable("id") Long id, @Valid @ModelAttribute("greeting") TeamSquad teamSquad, BindingResult binding) {
        /*if (binding.hasErrors()) {

            return "teamSquadForm";
        }*/
        return "redirect:"+teamSquadController.update(id,teamSquad);
    }
    // Update form
    /*@RequestMapping(value = "/{id}/teamSquadForm", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView updateForm(@PathVariable("id") Long id) {
        Preconditions.checkNotNull(teamSquadRepository.findOne(id), "teamSquad with id %s not found", id);
        return new ModelAndView("teamSquadForm", "teamSquad", teamSquadRepository.findOne(id));
    }*/
    @RequestMapping(value = "/{name}/teamSquadForm", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView updateForm(@PathVariable("name") String name) {
        Preconditions.checkNotNull(teamSquadRepository.findTeamSquadByName(name), "teamSquad with id %s not found", name);
        return new ModelAndView("teamSquadForm", "teamSquad", teamSquadRepository.findTeamSquadByName(name));
    }


    // RETRIEVE
    @RequestMapping(value = "/players/{name}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrievePlayersHTML(@PathVariable( "name" ) String name) {
        return new ModelAndView("teamSquad", "teamSquad", teamSquadController.retrieve(name));
    }


}
