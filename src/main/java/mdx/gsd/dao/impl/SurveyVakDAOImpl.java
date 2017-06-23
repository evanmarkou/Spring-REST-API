package mdx.gsd.dao.impl;

import mdx.gsd.dao.SurveyVakDAO;
import mdx.gsd.data.model.SurveyVak;
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
public class SurveyVakDAOImpl implements SurveyVakDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSurveyVak(SurveyVak surveyVak) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(surveyVak);
        logger.info("SurveyVak has been successfully inserted in db. " + surveyVak.toString());
    }

    @Override
    public void updateSurveyVak(SurveyVak surveyVak) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(surveyVak);
        logger.info("SurveyVak has been successfully updated in db. " + surveyVak.toString());
    }

    @Override
    public SurveyVak getSurveyVakById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyVak surveyVak;
        try {
            surveyVak = session.load(SurveyVak.class, id);
            logger.info("Returned surveyVak " + surveyVak.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return surveyVak;
    }

    @Override
    public List<SurveyVak> getAllSurveyVak() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SurveyVak> surveyVakList = session.createQuery("from SurveyVak").getResultList();
        logger.info("Returned surveyVakList with size " + surveyVakList.size());
        return surveyVakList;
    }

    @Override
    public List<SurveyVak> getUserSurveyVak(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SurveyVak v where v.surveyVakUser.userId = :userId";
        List<SurveyVak> surveyVakList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with surveyVak: " + surveyVakList.size());
        return surveyVakList;
    }

    @Override
    public void removeSurveyVak(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyVak surveyVak = session.load(SurveyVak.class, id);
        if (surveyVak != null) {
            session.delete(surveyVak);
            logger.info("SurveyVak " + surveyVak.getSurveyVakId() + " has been successfully deleted.");
        } else
            logger.info("Something went wrong!!");
    }
}
