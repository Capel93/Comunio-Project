package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
@Table
public class Player implements Serializable{
    @Id
    @NotBlank(message = "Nick cannot be blank")
    private String nick;

    private String role;

    private String team;

    private String teamSquad;

    private int totalPoints;

    private int currentPoints;

    private int price;

    public Player() {
        this.totalPoints = 0;
        this.currentPoints = 0;
        this.price = 0;
    }

    public Player(String nick, String role, String teamSquad, String team) {
        this.nick = nick;
        this.role = role;
        this.teamSquad = teamSquad;
        this.team = team;
        this.totalPoints = 0;
        this.currentPoints = 0;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamSquad() {
        return teamSquad;
    }

    public void setTeamSquad(String teamSquad) {
        this.teamSquad = teamSquad;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }
}
