package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.*;
import cat.udl.eps.softarch.hello.repository.*;
import cat.udl.eps.softarch.hello.xQuery.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmarc on 21/05/15.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    TeamSquadRepository teamSquadRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamSquadPlayerService teamSquadPlayerService;

    @Autowired
    TeamRepository teamRepository;

    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Transactional
    @Override
    public User getUser(String username) {
        return userRepository.findOne(username);
    }


    @Transactional
    @Override
    public User addUser(User user) {



        TeamSquad teamSquad = new TeamSquad();
        teamSquad.setName(user.getTeamSquad());
        teamSquad.setManager(user.getUsername());




            //players = xQueryHelperPlayers.getPlayers();

        TeamSquad savedTeam = teamSquadRepository.save(teamSquad);
        logger.info("teamSquad save");

        List<Player> players = playerRepository.findAll();
        //teamSquadPlayerService.addTitularPlayer(savedTeam.getName(), playerRepository.findOne("Joan"));
        //teamSquadPlayerService.addTitularPlayer(savedTeam.getName(), playerRepository.findOne("Victor"));
        //teamSquadPlayerService.addSuplentPlayer(savedTeam.getName(), playerRepository.findOne("Guille"));
        //teamSquadPlayerService.addSuplentPlayer(savedTeam.getName(), playerRepository.findOne("Sergi"));
        logger.info("players added save");

        user.setMoney(10000000); //10.000.000
        User u = userRepository.save(user);
        return u;


    }

    @Override
    public User updateUser(User user, String username) {
        User oldUser = userRepository.findOne(username);
        oldUser.setTeamSquad(user.getTeamSquad());
        oldUser.setEmail(user.getEmail());
        oldUser.setCommunity(user.getCommunity());
        oldUser.setUsername(user.getUsername());
        return oldUser;
    }

    /*private TeamSquad setPlayerList(){
        TeamSquad teamSquad = new TeamSquad();
        List<Player> titularPlayers = new ArrayList<>();
        titularPlayers.add(new Player("Joan","DC","JoanTeam","FCB"));
        titularPlayers.add(new Player("Victor","DF","JoanTeam","AND"));
        teamSquad.setTitularPlayers(titularPlayers);
        List<Player> suplentPlayers = new ArrayList<>();
        suplentPlayers.add(new Player("Guille","LD","JoanTeam","UEL"));
        suplentPlayers.add(new Player("Sergi","LI","JoanTeam","UEL"));
        teamSquad.setSuplentPlayers(suplentPlayers);
        return teamSquad;
    }*/
}
