package mdx.gsd.dao;

import mdx.gsd.data.model.SurveyBelbin;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface SurveyBelbinDAO {

    void addSurveyBelbin(SurveyBelbin surveyBelbin);

    void updateSurveyBelbin(SurveyBelbin surveyBelbin);

    SurveyBelbin getSurveyBelbinById(Integer id);

    List<SurveyBelbin> getAllSurveyBelbin();

    List<SurveyBelbin> getUserSurveyBelbin(String id);

    void removeSurveyBelbin(Integer id);

}
