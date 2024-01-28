package SurveyForge.backend.Services;

import SurveyForge.backend.Entities.Survey;
import org.springframework.http.ResponseEntity;

public interface SurveyService {
    ResponseEntity createSurvey(Survey survey);
}
