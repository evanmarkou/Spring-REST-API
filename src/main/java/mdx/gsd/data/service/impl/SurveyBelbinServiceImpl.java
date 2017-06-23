package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SurveyBelbinDAO;
import mdx.gsd.data.model.SurveyBelbin;
import mdx.gsd.data.service.SurveyBelbinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SurveyBelbinServiceImpl implements SurveyBelbinService {

    private final SurveyBelbinDAO surveyBelbinDAO;

    @Autowired
    public SurveyBelbinServiceImpl(SurveyBelbinDAO surveyBelbinDAO) {
        this.surveyBelbinDAO = surveyBelbinDAO;
    }

    @Override
    @Transactional
    public void addSurveyBelbin(SurveyBelbin surveyBelbin) {
        this.surveyBelbinDAO.addSurveyBelbin(surveyBelbin);
    }

    @Override
    @Transactional
    public void updateSurveyBelbin(SurveyBelbin surveyBelbin) {
        this.surveyBelbinDAO.updateSurveyBelbin(surveyBelbin);
    }

    @Override
    @Transactional
    public SurveyBelbin getSurveyBelbinById(Integer id) {
        return this.surveyBelbinDAO.getSurveyBelbinById(id);
    }

    @Override
    @Transactional
    public List<SurveyBelbin> getAllSurveyBelbin() {
        return this.surveyBelbinDAO.getAllSurveyBelbin();
    }

    @Override
    @Transactional
    public List<SurveyBelbin> getUserSurveyBelbin(String id) {
        return this.surveyBelbinDAO.getUserSurveyBelbin(id);
    }

    @Override
    @Transactional
    public void removeSurveyBelbin(Integer id) {
        this.surveyBelbinDAO.removeSurveyBelbin(id);
    }
}
