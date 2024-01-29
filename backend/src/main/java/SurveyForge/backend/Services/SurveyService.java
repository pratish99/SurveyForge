package SurveyForge.backend.Services;

import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Responses.Response;
import org.springframework.http.ResponseEntity;

public interface SurveyService {
    Response createSurvey(SurveyModel surveyModel);
}
