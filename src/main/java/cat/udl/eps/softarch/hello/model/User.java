package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by http://rhizomik.net/~roberto/
 */
@Entity
@Table(name = "ComunioUser")
public class User implements UserDetails {
    @Id
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Email(message = "E-mail should be valid")
    private String email;

    private String teamSquad;

    private String password;

    private String community;

    private int money;

    private int points;



    public int getPoints() {
        return points;
    }

    public void addPoints(int p) {
        this.points = this.points + p;
    }

    @URL
    private String imageUrl;

    public User() {
        this.points = 0;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.points = 0;
        this.money = 0;
    }

    public User(String username,String password, String email,String teamSquad) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.teamSquad = teamSquad;
        this.points = 0;
        this.money = 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
    }
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
         return true;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getTeamSquad() {
        return teamSquad;
    }

    public void setTeamSquad(String teamSquad) {
        this.teamSquad = teamSquad;
    }

    /*public List<Player> getAllPLayers(){
        return this.teamSquad.getAllPLayers();
    }

    public void addPlayerToTeam(Player player){
        this.teamSquad.addPlayer(player);
    }

    public void sellPlayer(String nick){
        this.teamSquad.removePlayer(nick);
    }*/
}
