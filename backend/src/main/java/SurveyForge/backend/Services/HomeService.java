package SurveyForge.backend.Services;

import SurveyForge.backend.Entities.User;
import SurveyForge.backend.Enumerators.PermissionType;
import SurveyForge.backend.Responses.Response;

public interface HomeService {
    Response login(User user);
    Response inviteCollaborator(String email, String surveyId, PermissionType permissionType);
    Response getCollaboratedSurvey(String userId);
}
