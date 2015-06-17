package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanmarc on 20/05/15.
 */
@Entity
public class Community implements Serializable{

    @Id
    @NotBlank(message = "Role cannot be blank")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    //@NotBlank(message = "Role cannot be blank")
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private User admin;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Player> market = new ArrayList<>();

    public Community() {

        this.users = new ArrayList<>();
        this.market = new ArrayList<>();
    }

    public Community(List<User> users, String name, User admin) {
        this.users = users;
        this.name = name;
        this.admin = admin;
        this.market = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<Player> getMarket() {
        return market;
    }

    public void setMarket(List<Player> market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return "Community{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", admin=" + admin +
                '}';
    }
}
