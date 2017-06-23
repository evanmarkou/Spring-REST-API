package mdx.gsd.dao.impl;

import mdx.gsd.dao.UserDAO;
import mdx.gsd.data.model.User;
import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@SuppressWarnings("unchecked")
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private Logger logger;

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User has been successfully inserted in db. " + user.toString());
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User has been successfully updated in db. " + user.toString());
    }

    @Override
    public User getUserById(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user;
        try {
            user = session.load(User.class, id);
            logger.info("Returned user " + user.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").getResultList();
        logger.info("Returned userList with size " + userList.size());
        return userList;
    }

    @Override
    public void removeUser(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
            logger.info("User " + user.getUserId() + " has been successfully deleted.");
        } else
            logger.info("Something went wrong!!");
    }
}
