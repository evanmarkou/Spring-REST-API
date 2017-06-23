package mdx.gsd.dao.impl;

import mdx.gsd.dao.SurveyMbtiDAO;
import mdx.gsd.data.model.SurveyMbti;
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
public class SurveyMbtiDAOImpl implements SurveyMbtiDAO {

    @Autowired
    private Logger logger;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSurveyMbti(SurveyMbti surveyMbti) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(surveyMbti);
        logger.info("SurveyMbti has been successfully inserted in db. " + surveyMbti.toString());
    }

    @Override
    public void updateSurveyMbti(SurveyMbti surveyMbti) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(surveyMbti);
        logger.info("SurveyMbti has been successfully updated in db. " + surveyMbti.toString());
    }

    @Override
    public SurveyMbti getSurveyMbtiById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyMbti surveyMbti;
        try {
            surveyMbti = session.load(SurveyMbti.class, id);
            logger.info("Returned surveyMbti " + surveyMbti.toString());
        } catch (ObjectNotFoundException ex) {
            return null;
        }
        return surveyMbti;
    }

    @Override
    public List<SurveyMbti> getAllSurveyMbti() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SurveyMbti> surveyMbtiList = session.createQuery("from SurveyMbti").getResultList();
        logger.info("Returned surveyMbtiList with size " + surveyMbtiList.size());
        return surveyMbtiList;
    }

    @Override
    public List<SurveyMbti> getUserSurveyMbti(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from SurveyMbti mbt where mbt.surveyMbtiUser.userId = :userId";
        List<SurveyMbti> surveyMbtiList = session.createQuery(hql).setParameter("userId", id).getResultList();
        logger.info("Returned list for user " + id + " with surveyMbti: " + surveyMbtiList.size());
        return surveyMbtiList;
    }

    @Override
    public void removeSurveyMbti(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        SurveyMbti surveyMbti = session.load(SurveyMbti.class, id);
        if (surveyMbti != null) {
            session.delete(surveyMbti);
            logger.info("SurveyMbti " + surveyMbti.getSurveyMbtiId() + " has been successfully deleted.");
        } else
            logger.info("Something went wrong!!");
    }
}
