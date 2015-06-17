package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.TeamSquadRepository;
import cat.udl.eps.softarch.hello.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joanmarc on 20/05/15.
 */
@Service
public class UserTeamServiceImpl implements UserTeamService{

    final Logger logger = LoggerFactory.getLogger(UserTeamServiceImpl.class);



    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamSquadRepository teamSquadRepository;

    @Transactional
    @Override
    public TeamSquad getUserTeam(String name) {

        TeamSquad teamSquad = teamSquadRepository.findTeamSquadByName(name);
        return teamSquad;
    }

    @Transactional
    @Override
    public TeamSquad getUserTeamById(Long id) {

        TeamSquad teamSquad = teamSquadRepository.findTeamSquadById(id);
        return teamSquad;
    }

    @Transactional
    @Override
    public TeamSquad addTeamSquadToUser(TeamSquad teamSquad) {
        User user = userRepository.findOne(teamSquad.getManager());
        teamSquadRepository.save(teamSquad);
        user.setTeamSquad(teamSquad.getName());
        userRepository.save(user);
        return teamSquad;
    }

    @Transactional
    @Override
    public TeamSquad updateTeamSquad(TeamSquad teamSquad, Long teamSquadId) {
        TeamSquad oldTeamSquad = teamSquadRepository.findTeamSquadById(teamSquadId);
        oldTeamSquad.setName(teamSquad.getName());

        oldTeamSquad.setTitularPlayers(teamSquad.getTitularPlayers());

        return teamSquadRepository.save(oldTeamSquad);
    }

}
