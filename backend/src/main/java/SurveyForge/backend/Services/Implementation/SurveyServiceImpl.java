package SurveyForge.backend.Services.Implementation;

import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Repositories.SurveyRepository;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Response createSurvey(SurveyModel surveyModel) {
        surveyRepository.save(toEntity(surveyModel));
        return new Response<>(surveyModel);
    }

    @Override
    public Response getSurvey(String userId) {
        List<Survey> surveyList = surveyRepository.findByUserId(userId);
        return new Response<>(surveyList.stream().map(this::toModel).toList());
    }

    private Survey toEntity(SurveyModel surveyModel){
        return Survey.builder()
                .name(surveyModel.getName())
                .userId(surveyModel.getUserId())
                .questionList(surveyModel.getQuestionList())
                .startTime(surveyModel.getStartTime())
                .endTime(surveyModel.getEndTime())
                .collaborators(surveyModel.getCollaborators())
                .build();
    }

    private SurveyModel toModel(Survey survey){
        return SurveyModel.builder()
                .id(survey.getId())
                .name(survey.getName())
                .userId(survey.getUserId())
                .questionList(survey.getQuestionList())
                .startTime(survey.getStartTime())
                .endTime(survey.getEndTime())
                .collaborators(survey.getCollaborators())
                .build();

    }
}
