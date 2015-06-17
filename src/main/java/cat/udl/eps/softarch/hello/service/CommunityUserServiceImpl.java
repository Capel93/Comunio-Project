package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Community;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.User;
import cat.udl.eps.softarch.hello.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by joanmarc on 10/06/15.
 */
public class CommunityUserServiceImpl implements CommunityUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamSquadRepository teamSquadRepository;

    @Autowired
    TeamRepository teamRepository;


    @Autowired
    CommunityRepository communityRepository;


    @Override
    public Community getCommunitybyUser(String email) {

        return communityRepository.findOne(userRepository.findUserByEmail(email).getCommunity());

    }

    @Override
    public List<Player> getMarketByCommunityName(String name) {
        return communityRepository.findOne(name).getMarket();
    }

    @Override
    public List<User> getUsersCommunity(String name) {
        return communityRepository.findOne(name).getUsers();
    }
}
