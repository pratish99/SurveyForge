package SurveyForge.backend.Services.Implementation;


import SurveyForge.backend.Entities.SurveyAnswer;
import SurveyForge.backend.Models.AnswerModel;
import SurveyForge.backend.Models.SurveyAnswerModel;
import SurveyForge.backend.Repositories.SurveyAnswerRepository;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyAnswerServiceImpl implements SurveyAnswerService {

    @Autowired
    SurveyAnswerRepository surveyAnswerRepository;

    @Override
    public Response surveyAnswer(SurveyAnswerModel surveyAnswerModel, String surveyId) {
        surveyAnswerRepository.save(toEntity(surveyAnswerModel, surveyId));
        surveyAnswerModel.setSurveyId(surveyId);
        return new Response<>(surveyAnswerModel);
    }

    @Override
    public Response getAllAnswers(String surveyId) {
        List<SurveyAnswer> list = surveyAnswerRepository.findBySurveyId(surveyId);

        return new Response<>(list.stream().map(this::toModel).toList());
    }

    private SurveyAnswer toEntity(SurveyAnswerModel surveyAnswerModel, String surveyId){
        SurveyAnswer surveyAnswer = SurveyAnswer.builder()
                .answerList(surveyAnswerModel.getAnswerList())
                .surveyId(surveyId)
                .build();
        return surveyAnswer;
    }
    private SurveyAnswerModel toModel(SurveyAnswer surveyAnswer){
        return SurveyAnswerModel.builder()
                .id(surveyAnswer.getId())
                .surveyId(surveyAnswer.getSurveyId())
                .answerList(surveyAnswer.getAnswerList())
                .build();

    }
}
