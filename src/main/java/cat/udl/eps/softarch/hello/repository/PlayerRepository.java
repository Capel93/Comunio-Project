package cat.udl.eps.softarch.hello.repository;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joanmarc on 10/06/15.
 */
public interface PlayerRepository extends JpaRepository<Player, String> {



}
