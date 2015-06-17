package cat.udl.eps.softarch.hello.controller;

import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.service.UserTeamService;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.io.IOException;

/**
 * Created by joanmarc on 21/05/15.
 */
@Controller
@RequestMapping(value = "/teamSquad")
public class TeamSquadController {
    final Logger logger = LoggerFactory.getLogger(TeamSquadController.class);

    @Autowired
    TeamSquadRepository teamSquadRepository;
    @Autowired
    UserTeamService userTeamService;

    // LIST
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<TeamSquad> list(@RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest request = new PageRequest(page, size);

        return teamSquadRepository.findAll(request).getContent();
    }

    // RETRIEVE
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public TeamSquad retrieve(@PathVariable("name") String name) {
        logger.info("Retrieving TeamSquad {}", name);
        Preconditions.checkNotNull(teamSquadRepository.findTeamSquadByName(name), "TeamSquad with id %s not found", name);
        return teamSquadRepository.findTeamSquadByName(name);
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TeamSquad create(@Valid @RequestBody TeamSquad teamSquad, HttpServletResponse response) {
        logger.info("Creating teamSquad with name'{}'", teamSquad.getName());
        //teamSquad.setManager(new User("vic","vv@vv.es"));
        TeamSquad newTeamSquad = userTeamService.addTeamSquadToUser(teamSquad);
        logger.info("created teamSquad with name'{}'", teamSquad.getId());
        response.setHeader("Location", "teamSquad/" + newTeamSquad.getId());
        return newTeamSquad;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TeamSquad update(@PathVariable("id") Long id, @Valid @RequestBody TeamSquad teamSquad) {
        logger.info("Updating greeting {}, new content is '{}'", id, teamSquad.getName());
        Preconditions.checkNotNull(teamSquadRepository.findOne(id), "TeamSquad with id %s not found", id);
        return userTeamService.updateTeamSquad(teamSquad,id);
    }

}
