package SurveyForge.backend.Services;

import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Enumerators.PermissionType;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Models.UserModel;
import SurveyForge.backend.Repositories.UserRepository;
import SurveyForge.backend.Responses.Response;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface SurveyService {
    Response createSurvey(SurveyModel surveyModel);
    Response getSurvey(String userId);
    Response getParticularSurvey(String surveyId);
    Response editSurvey(SurveyModel surveyModel);
    Response reportSurvey(String surveyId);
    Response activeSurveys(String userId);
    void updateCollaborator(UserModel userModel, String surveyId, PermissionType permissionType);
    SurveyModel getSurveyById(String surveyId);
    Response completedSurveys(String userID);


}
