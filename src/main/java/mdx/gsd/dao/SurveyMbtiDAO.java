package mdx.gsd.dao;

import mdx.gsd.data.model.SurveyMbti;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface SurveyMbtiDAO {

    void addSurveyMbti(SurveyMbti surveyMbti);

    void updateSurveyMbti(SurveyMbti surveyMbti);

    SurveyMbti getSurveyMbtiById(Integer id);

    List<SurveyMbti> getAllSurveyMbti();

    List<SurveyMbti> getUserSurveyMbti(String id);

    void removeSurveyMbti(Integer id);
}
