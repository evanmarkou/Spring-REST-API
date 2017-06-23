package mdx.gsd.dao.impl;

import mdx.gsd.dao.SensorAudioDAO;
import mdx.gsd.data.model.SensorAudio;
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
public class SensorAudioDAOImpl implements SensorAudioDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSensorAudio(SensorAudio sensorAudio) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(sensorAudio);
        logger.info("SensorAudio has been successfully inserted into database!!" + sensorAudio.toString());
    }

    @Override
    public void updateSensorAudio(SensorAudio sensorAudio) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(sensorAudio);
        logger.info("SensorAudio has been successfully updated in db!!" + sensorAudio.toString());
    }

    @Override
    public SensorAudio getSensorAudioById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorAudio sensorAudio;
        try {
            sensorAudio = session.load(SensorAudio.class, id);
            logger.info("Returned SensorAudio " + sensorAudio.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return sensorAudio;
    }

    @Override
    public List<SensorAudio> getUserSensorAudio(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SensorAudio aud where aud.sensorAudioUser.userId = :userId";
        List<SensorAudio> sensorAudioList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with sensorAudio: " + sensorAudioList.size());
        return sensorAudioList;
    }

    @Override
    public List<SensorAudio> getAllSensorAudio() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SensorAudio> sensorAudioList = session.createQuery("from SensorAudio").getResultList();
        logger.info("Returned list with sensorAudio: " + sensorAudioList.size());
        return sensorAudioList;
    }

    @Override
    public void removeSensorAudio(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SensorAudio sensorAudio = session.load(SensorAudio.class, id);
        if (sensorAudio != null) {
            session.delete(sensorAudio);
            logger.info("SensorAudio " + sensorAudio.getSensorAudioId() + " successfully deleted.");
        } else
            logger.info("Something bad went on");
    }
}
