package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SurveyVakDAO;
import mdx.gsd.data.model.SurveyVak;
import mdx.gsd.data.service.SurveyVakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SurveyVakServiceImpl implements SurveyVakService {

    private final SurveyVakDAO surveyVakDAO;

    @Autowired
    public SurveyVakServiceImpl(SurveyVakDAO surveyVakDAO) {
        this.surveyVakDAO = surveyVakDAO;
    }

    @Override
    @Transactional
    public void addSurveyVak(SurveyVak surveyVak) {
        this.surveyVakDAO.addSurveyVak(surveyVak);
    }

    @Override
    @Transactional
    public void updateSurveyVak(SurveyVak surveyVak) {
        this.surveyVakDAO.updateSurveyVak(surveyVak);
    }

    @Override
    @Transactional
    public SurveyVak getSurveyVakById(Integer id) {
        return this.surveyVakDAO.getSurveyVakById(id);
    }

    @Override
    @Transactional
    public List<SurveyVak> getAllSurveyVak() {
        return this.surveyVakDAO.getAllSurveyVak();
    }

    @Override
    @Transactional
    public List<SurveyVak> getUserSurveyVak(String id) {
        return this.surveyVakDAO.getUserSurveyVak(id);
    }

    @Override
    @Transactional
    public void removeSurveyVak(Integer id) {
        this.surveyVakDAO.removeSurveyVak(id);
    }
}
