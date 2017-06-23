package mdx.gsd.dao.impl;

import mdx.gsd.dao.RoleDAO;
import mdx.gsd.data.model.Role;
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
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(role);
        logger.info("Role has been successfully inserted in database!!" + role.toString());
    }

    @Override
    public void updateRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        logger.info("Role has been successfully updated in database!!!" + role.toString());

    }

    @Override
    public Role getRoleByID(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role;
        try {
            role = session.load(Role.class, id);
            logger.info("Returned role: " + role.getRoleName() + "with id:" + role.getRoleId());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return role;
    }

    @Override
    public List<Role> listAllRole() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> RoleList = session.createQuery("from Role").getResultList();
        logger.info("Returned list with roles: " + RoleList.size());
        return RoleList;
    }

    @Override
    public void removeRole(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = session.load(Role.class, id);
        if (role != null) {
            session.delete(role);
            logger.info("Role " + role.getRoleId() + " successfully deleted.");
        } else
            logger.info("Something went completely wrong");
    }
}
