package mdx.gsd.dao;

import mdx.gsd.data.model.SurveyVak;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface SurveyVakDAO {

    void addSurveyVak(SurveyVak surveyVak);

    void updateSurveyVak(SurveyVak surveyVak);

    SurveyVak getSurveyVakById(Integer id);

    List<SurveyVak> getAllSurveyVak();

    List<SurveyVak> getUserSurveyVak(String id);

    void removeSurveyVak(Integer id);
}
