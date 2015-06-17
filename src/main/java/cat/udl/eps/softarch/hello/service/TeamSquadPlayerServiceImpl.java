package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joanmarc on 11/06/15.
 */
@Service
public class TeamSquadPlayerServiceImpl implements TeamSquadPlayerService{

    @Autowired
    TeamSquadRepository teamSquadRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    UserRepository userRepository;

    final Logger logger = LoggerFactory.getLogger(TeamSquadPlayerServiceImpl.class);

    @Transactional
    @Override
    public TeamSquad addTitularPlayer(String username, Player player) {

        logger.info("find team squad");

        User user = userRepository.findOne(username);

        TeamSquad team = teamSquadRepository.findTeamSquadByName(user.getTeamSquad());
        logger.info(" founded");

        team.addTitularPlayer(player);
        player.setTeamSquad(user.getTeamSquad());

        user.setMoney(user.getMoney()-player.getPrice());
        user.setPoints(user.getPoints()+player.getCurrentPoints());
        team.setPoints(team.getPoints()+player.getCurrentPoints());

        userRepository.save(user);
        playerRepository.save(player);
        logger.info("player saved");
        return teamSquadRepository.save(team);
    }



    @Transactional
    @Override
    public void removePlayer(Player player) {

    }
}
