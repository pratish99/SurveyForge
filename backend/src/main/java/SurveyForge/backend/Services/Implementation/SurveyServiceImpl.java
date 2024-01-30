package SurveyForge.backend.Services.Implementation;

import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Entities.SurveyAnswer;
import SurveyForge.backend.Entities.User;
import SurveyForge.backend.Enumerators.PermissionType;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Models.UserModel;
import SurveyForge.backend.Repositories.SurveyRepository;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyAnswerService;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyAnswerService surveyAnswerService;

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

    @Override
    public Response editSurvey(SurveyModel surveyModel) {
        Optional<Survey> temp = surveyRepository.findById(surveyModel.getId());
        Survey survey = temp.get();
        survey.setName(surveyModel.getName());
        survey.setUserId(surveyModel.getUserId());
        survey.setQuestionList(surveyModel.getQuestionList());
        survey.setStartTime(surveyModel.getStartTime());
        survey.setEndTime(surveyModel.getEndTime());
        survey.setCollaborators(surveyModel.getCollaborators());
        surveyRepository.save(survey);
        return new Response<>(surveyModel);
    }

    @Override
    public Response reportSurvey(String surveyId) {
        Optional<Survey> temp = surveyRepository.findById(surveyId);
        Survey survey = temp.get();
        SurveyModel surveyModel = toModel(survey);
        return new Response(surveyAnswerService.reportSurvey(surveyModel));
    }

    @Override
    public void updateCollaborator(UserModel userModel, String surveyId, PermissionType permissionType){
        Survey survey = surveyRepository.findById(surveyId).get();
        List<User> userList = survey.getCollaborators();
        User user = User.builder().id(userModel.getId()).email(userModel.getEmail()).build();
        userList.add(user);
        survey.setCollaborators(userList);
        surveyRepository.save(survey);
    }

    @Override
    public SurveyModel getSurveyById(String surveyId) {
        return toModel(surveyRepository.findById(surveyId).get());
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
