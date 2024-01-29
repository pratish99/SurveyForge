package SurveyForge.backend.Services;

import SurveyForge.backend.Entities.SurveyAnswer;
import SurveyForge.backend.Models.SurveyAnswerModel;
import SurveyForge.backend.Responses.Response;

public interface SurveyAnswerService {
    Response surveyAnswer(SurveyAnswerModel surveyAnswerModel, String id);
    Response getAllAnswers(String id);

}
