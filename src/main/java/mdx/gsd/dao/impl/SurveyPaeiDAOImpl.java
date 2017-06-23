package mdx.gsd.dao.impl;

import mdx.gsd.dao.SurveyPaeiDAO;
import mdx.gsd.data.model.SurveyPaei;
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
public class SurveyPaeiDAOImpl implements SurveyPaeiDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSurveyPaei(SurveyPaei surveyPaei) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(surveyPaei);
        logger.info("SurveyPaei has been successfully inserted in db. " + surveyPaei.toString());
    }

    @Override
    public void updateSurveyPaei(SurveyPaei surveyPaei) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(surveyPaei);
        logger.info("SurveyPaei has been successfully updated in db. " + surveyPaei.toString());
    }

    @Override
    public SurveyPaei getSurveyPaeiById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyPaei surveyPaei;
        try {
            surveyPaei = session.load(SurveyPaei.class, id);
            logger.info("Returned surveyPaei " + surveyPaei.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return surveyPaei;
    }

    @Override
    public List<SurveyPaei> getAllSurveyPaei() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SurveyPaei> surveyPaeiList = session.createQuery("from SurveyPaei").getResultList();
        logger.info("Returned surveyPaeiList with size " + surveyPaeiList.size());
        return surveyPaeiList;
    }

    @Override
    public List<SurveyPaei> getUserSurveyPaei(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SurveyPaei pa where pa.surveyPaeiUser.userId = :userId";
        List<SurveyPaei> surveyPaeiList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with surveyPaei: " + surveyPaeiList.size());
        return surveyPaeiList;
    }

    @Override
    public void removeSurveyPaei(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyPaei surveyPaei = session.load(SurveyPaei.class, id);
        if (surveyPaei != null) {
            session.delete(surveyPaei);
            logger.info("SurveyPaei " + surveyPaei.getSurveyPaeiId() + " has been successfully deleted.");
        } else
            logger.info("Something went wrong!!");
    }
}
