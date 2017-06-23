package mdx.gsd.data.service;

import mdx.gsd.data.model.User;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    User getUserById(String id);

    List<User> getAllUsers();

    void removeUser(Integer id);

}
