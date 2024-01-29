package SurveyForge.backend.Services.Implementation;

import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Repositories.SurveyRepository;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Response createSurvey(SurveyModel surveyModel) {
        surveyRepository.save(toEntity(surveyModel));
        return new Response<>(surveyModel);
    }

    private Survey toEntity(SurveyModel surveyModel){
        Survey survey = Survey.builder()
                .name(surveyModel.getName())
                .userId(surveyModel.getUserId())
                .questionList(surveyModel.getQuestionList())
                .startTime(surveyModel.getStartTime())
                .endTime(surveyModel.getEndTime())
                .collaborators(surveyModel.getCollaborators())
                .build();
        return survey;
    }
}
