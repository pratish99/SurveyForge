package SurveyForge.backend.Services;

import SurveyForge.backend.Models.SurveyAnswerModel;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Responses.Response;

import java.util.List;

public interface SurveyAnswerService {
    Response surveyAnswer(SurveyAnswerModel surveyAnswerModel, String id);
    Response getAllAnswers(String surveyId);
    List reportSurvey(SurveyModel surveyModel);
}
