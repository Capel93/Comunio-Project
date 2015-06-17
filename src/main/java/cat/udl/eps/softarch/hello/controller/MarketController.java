package cat.udl.eps.softarch.hello.controller;

import cat.udl.eps.softarch.hello.model.Player;
import cat.udl.eps.softarch.hello.repository.PlayerRepository;
import cat.udl.eps.softarch.hello.service.UserPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by joanmarc on 12/06/15.
 */
@Controller
@RequestMapping(value = "/market")
public class MarketController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    UserPlayerService userPlayerService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Player> list(@RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest request = new PageRequest(page, size);

        return userPlayerService.getPlayers();
    }


}
