package mdx.gsd.dao.impl;

import mdx.gsd.dao.SensorEmotionDAO;
import mdx.gsd.data.model.SensorEmotion;
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
public class SensorEmotionDAOImpl implements SensorEmotionDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSensorEmotion(SensorEmotion sensorEmotion) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(sensorEmotion);
        logger.info("SensorEmotion has been successfully inserted db. " + sensorEmotion.toString());
    }

    @Override
    public void updateSensorEmotion(SensorEmotion sensorEmotion) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(sensorEmotion);
        logger.info("SensorEmotion has been successfully updated db. " + sensorEmotion.toString());
    }

    @Override
    public SensorEmotion getSensorEmotionById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorEmotion sensorEmotion;
        try {
            sensorEmotion = session.load(SensorEmotion.class, id);
            logger.info("Returned sensorEmotion " + sensorEmotion.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return sensorEmotion;
    }

    @Override
    public List<SensorEmotion> getAllSensorEmotion() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SensorEmotion> sensorEmotionList = session.createQuery("from SensorEmotion").getResultList();
        logger.info("Returned sensorEmotionList with size " + sensorEmotionList.size());
        return sensorEmotionList;
    }

    @Override
    public List<SensorEmotion> getUserSensorEmotion(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SensorEmotion em where em.sensorEmotionUser.userId = :userId";
        List<SensorEmotion> sensorEmotionList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with sensorAudio: " + sensorEmotionList.size());
        return sensorEmotionList;
    }

    @Override
    public void removeSensorEmotion(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorEmotion sensorEmotion = session.load(SensorEmotion.class, id);
        if (sensorEmotion != null) {
            session.delete(sensorEmotion);
            logger.info("SensorEmotion " + sensorEmotion.getSensorEmotionId() + " successfully deleted.");
        } else
            logger.info("Something bad went on!!!");

    }
}
