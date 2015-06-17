package cat.udl.eps.softarch.hello.service;

import cat.udl.eps.softarch.hello.model.User;

import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by joanmarc on 21/05/15.
 */
public interface UserService {
    User getUser(String username);



    User addUser(User user) throws IOException, IllegalAccessException, XQException, JAXBException, InstantiationException, ClassNotFoundException;

    User updateUser(User teamSquad, String username);
}
