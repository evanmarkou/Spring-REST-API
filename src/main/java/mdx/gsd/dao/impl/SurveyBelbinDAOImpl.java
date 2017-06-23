package mdx.gsd.dao.impl;

import mdx.gsd.dao.SurveyBelbinDAO;
import mdx.gsd.data.model.SurveyBelbin;
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
public class SurveyBelbinDAOImpl implements SurveyBelbinDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSurveyBelbin(SurveyBelbin surveyBelbin) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(surveyBelbin);
        logger.info("SurveyBelbin has been successfully inserted in db. " + surveyBelbin.toString());
    }

    @Override
    public void updateSurveyBelbin(SurveyBelbin surveyBelbin) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(surveyBelbin);
        logger.info("SurveyBelbin has been successfully updated in db. " + surveyBelbin.toString());
    }

    @Override
    public SurveyBelbin getSurveyBelbinById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyBelbin surveyBelbin;
        try {
            surveyBelbin = session.load(SurveyBelbin.class, id);
            logger.info("Returned SurveyBelbin " + surveyBelbin.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return surveyBelbin;
    }

    @Override
    public List<SurveyBelbin> getAllSurveyBelbin() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SurveyBelbin> surveyBelbinList = session.createQuery("from SurveyBelbin").getResultList();
        logger.info("Returned surveyBelbinList with size " + surveyBelbinList.size());
        return surveyBelbinList;
    }

    @Override
    public List<SurveyBelbin> getUserSurveyBelbin(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SurveyBelbin bel where bel.surveyBelbinUser.userId = :userId";
        List<SurveyBelbin> surveyBelbinList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with surveyBelbin: " + surveyBelbinList.size());
        return surveyBelbinList;
    }

    @Override
    public void removeSurveyBelbin(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyBelbin surveyBelbin = session.load(SurveyBelbin.class, id);
        if (surveyBelbin != null) {
            session.delete(surveyBelbin);
            logger.info("SurveyBelbin " + surveyBelbin.getSurveyBelbinId() + " has been deleted.");
        } else
            logger.info("Something went wrong!!");
    }
}
