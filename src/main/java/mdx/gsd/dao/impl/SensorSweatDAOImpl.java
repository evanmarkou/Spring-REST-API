package mdx.gsd.dao.impl;

import mdx.gsd.dao.SensorSweatDAO;
import mdx.gsd.data.model.SensorSweat;
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
public class SensorSweatDAOImpl implements SensorSweatDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSensorSweat(SensorSweat sensorSweat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(sensorSweat);
        logger.info("SensorSweat has been successfully inserted in db. " + sensorSweat.toString());
    }

    @Override
    public void updateSensorSweat(SensorSweat sensorSweat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(sensorSweat);
        logger.info("SensorSweat has been successfully updated in db. " + sensorSweat.toString());
    }

    @Override
    public SensorSweat getSensorSweatById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorSweat sensorSweat;
        try {
            sensorSweat = session.load(SensorSweat.class, id);
            logger.info("Returned sensorSweat " + sensorSweat.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return sensorSweat;
    }

    @Override
    public List<SensorSweat> getAllSensorSweat() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SensorSweat> sensorSweatList = session.createQuery("from SensorSweat").getResultList();
        logger.info("Returned sensorSweatList with size " + sensorSweatList.size());
        return sensorSweatList;
    }

    @Override
    public List<SensorSweat> getUserSensorSweat(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SensorSweat sw where sw.sensorSweatUser.userId = :userId";
        List<SensorSweat> sensorSweatList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with sensorSweat: " + sensorSweatList.size());
        return sensorSweatList;
    }

    @Override
    public void removeSensorSweat(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorSweat sensorSweat = session.load(SensorSweat.class, id);
        if (sensorSweat != null) {
            session.delete(sensorSweat);
            logger.info("SensorSweat " + sensorSweat.getSensorSweatId() + " successfully deleted.");
        } else
            logger.info("Something went wrong!!");
    }
}
