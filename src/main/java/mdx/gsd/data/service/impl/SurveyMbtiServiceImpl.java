package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SurveyMbtiDAO;
import mdx.gsd.data.model.SurveyMbti;
import mdx.gsd.data.service.SurveyMbtiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SurveyMbtiServiceImpl implements SurveyMbtiService {

    private final SurveyMbtiDAO surveyMbtiDAO;

    @Autowired
    public SurveyMbtiServiceImpl(SurveyMbtiDAO surveyMbtiDAO) {
        this.surveyMbtiDAO = surveyMbtiDAO;
    }

    @Override
    @Transactional
    public void addSurveyMbti(SurveyMbti surveyMbti) {
        this.surveyMbtiDAO.addSurveyMbti(surveyMbti);
    }

    @Override
    @Transactional
    public void updateSurveyMbti(SurveyMbti surveyMbti) {
        this.surveyMbtiDAO.updateSurveyMbti(surveyMbti);
    }

    @Override
    @Transactional
    public SurveyMbti getSurveyMbtiById(Integer id) {
        return this.surveyMbtiDAO.getSurveyMbtiById(id);
    }

    @Override
    @Transactional
    public List<SurveyMbti> getAllSurveyMbti() {
        return this.surveyMbtiDAO.getAllSurveyMbti();
    }

    @Override
    @Transactional
    public List<SurveyMbti> getUserSurveyMbti(String id) {
        return this.surveyMbtiDAO.getUserSurveyMbti(id);
    }

    @Override
    @Transactional
    public void removeSurveyMbti(Integer id) {
        this.surveyMbtiDAO.removeSurveyMbti(id);
    }
}
