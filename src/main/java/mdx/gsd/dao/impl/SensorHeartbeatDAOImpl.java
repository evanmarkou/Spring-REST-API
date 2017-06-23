package mdx.gsd.dao.impl;

import mdx.gsd.dao.SensorHeartbeatDAO;
import mdx.gsd.data.model.SensorHeartbeat;
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
public class SensorHeartbeatDAOImpl implements SensorHeartbeatDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSensorHeartbeat(SensorHeartbeat sensorHeartbeat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(sensorHeartbeat);
        logger.info("SensorHeartbeat has been successfully inserted in db. " + sensorHeartbeat.toString());
    }

    @Override
    public void updateSensorHeartbeat(SensorHeartbeat sensorHeartbeat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(sensorHeartbeat);
        logger.info("SensorHeartbeat has been successfully updated in db. " + sensorHeartbeat.toString());
    }

    @Override
    public SensorHeartbeat getSensorHeartbeatById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorHeartbeat sensorHeartbeat;
        try {
            sensorHeartbeat = session.load(SensorHeartbeat.class, id);
            logger.info("Returned SensorHeartbeat " + sensorHeartbeat.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return sensorHeartbeat;
    }

    @Override
    public List<SensorHeartbeat> getAllSensorHeartbeat() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SensorHeartbeat> sensorHeartbeatList = session.createQuery("from SensorHeartbeat").getResultList();
        logger.info("Returned sensorHeartbeatList with size " + sensorHeartbeatList.size());
        return sensorHeartbeatList;
    }

    @Override
    public List<SensorHeartbeat> getUserSensorHeartbeat(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SensorHeartbeat htbt where htbt.sensorHeartbeatUser.userId = :userId";
        List<SensorHeartbeat> sensorHeartbeatList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with sensorHeartbeat: " + sensorHeartbeatList.size());
        return sensorHeartbeatList;
    }

    @Override
    public void removeSensorHeartbeat(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorHeartbeat sensorHeartbeat = session.load(SensorHeartbeat.class, id);
        if (sensorHeartbeat != null) {
            session.delete(sensorHeartbeat);
            logger.info("SensorHeartbeat " + sensorHeartbeat.getSensorHeartbeatId() + " successfully deleted.");
        } else
            logger.info("Something went wrong");
    }
}
