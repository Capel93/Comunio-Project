package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.TeamSquad;

/**
 * Created by joanmarc on 11/06/15.
 */
public interface TeamSquadPlayerService {


    TeamSquad addTitularPlayer(String teamSquadName, Player player);


    void removePlayer(Player player);

}
