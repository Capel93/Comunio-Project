package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Community;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.User;

import java.util.List;

/**
 * Created by joanmarc on 10/06/15.
 */
public interface CommunityUserService {

    Community getCommunitybyUser(String username);

    List<Player> getMarketByCommunityName(String name);

    List<User> getUsersCommunity(String name);

}
