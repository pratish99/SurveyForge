package SurveyForge.backend.Services;

import SurveyForge.backend.Responses.Response;

public interface HomeService {
    Response login(String email);
    Response inviteCollaborator(String email, String surveyId);
}
