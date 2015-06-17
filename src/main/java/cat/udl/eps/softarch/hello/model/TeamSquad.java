package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
@Table
public class TeamSquad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    //@NotBlank(message = "Nick cannot be blank")
    private String name;

    //@NotBlank(message = "Nick cannot be blank")
    //@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private String manager;

    private int points;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Player> titularPlayers;




    public TeamSquad() {
        this.titularPlayers = new ArrayList<>();

        this.points = 0;
    }

    public TeamSquad(String name, String manager, List<Player> titularPlayers, List<Player> suplentPlayers) {
        this.name = name;
        this.manager = manager;
        this.titularPlayers = titularPlayers;

        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int calcPoints(){
        int total = 0;
        for (Player p:this.titularPlayers){
            total = total + p.getCurrentPoints();
        }
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<Player> getTitularPlayers() {
        return titularPlayers;
    }

    public void setTitularPlayers(List<Player> titularPlayers) {
        this.titularPlayers = titularPlayers;
    }


    public void addTitularPlayer(Player player) {

        this.titularPlayers.add(player);
        //player.setTeamSquad(this.name);

    }


    public void removePlayer(String player) {
        for (Player p:getTitularPlayers()){
            if(p.getNick().equals(player)){
                titularPlayers.remove(p);
                p.setTeamSquad("System");
            }
        }

    }

    public List<Player> getAllPLayers() {
        List<Player> players = new ArrayList<>();
        players.addAll(this.getTitularPlayers());

        return players;
    }

}
