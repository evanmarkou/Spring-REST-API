package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SurveyPaeiDAO;
import mdx.gsd.data.model.SurveyPaei;
import mdx.gsd.data.service.SurveyPaeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SurveyPaeiServiceImpl implements SurveyPaeiService {

    private final SurveyPaeiDAO surveyPaeiDAO;

    @Autowired
    public SurveyPaeiServiceImpl(SurveyPaeiDAO surveyPaeiDAO) {
        this.surveyPaeiDAO = surveyPaeiDAO;
    }

    @Override
    @Transactional
    public void addSurveyPaei(SurveyPaei surveyPaei) {
        this.surveyPaeiDAO.addSurveyPaei(surveyPaei);
    }

    @Override
    @Transactional
    public void updateSurveyPaei(SurveyPaei surveyPaei) {
        this.surveyPaeiDAO.updateSurveyPaei(surveyPaei);
    }

    @Override
    @Transactional
    public SurveyPaei getSurveyPaeiById(Integer id) {
        return this.surveyPaeiDAO.getSurveyPaeiById(id);
    }

    @Override
    @Transactional
    public List<SurveyPaei> getAllSurveyPaei() {
        return this.surveyPaeiDAO.getAllSurveyPaei();
    }

    @Override
    @Transactional
    public List<SurveyPaei> getUserSurveyPaei(String id) {
        return this.surveyPaeiDAO.getUserSurveyPaei(id);
    }

    @Override
    @Transactional
    public void removeSurveyPaei(Integer id) {
        this.surveyPaeiDAO.removeSurveyPaei(id);
    }
}
