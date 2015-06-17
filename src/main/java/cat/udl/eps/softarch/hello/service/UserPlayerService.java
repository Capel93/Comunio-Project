package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.User;

import java.util.List;

/**
 * Created by joanmarc on 20/05/15.
 */
public interface UserPlayerService {

    User getUserAndPlayers(String username);

    Player addPlayerToUser(String username,Player player);

    void removePlayerFromUser(String username,String playerName);

    List<Player> getPlayers();


    }
