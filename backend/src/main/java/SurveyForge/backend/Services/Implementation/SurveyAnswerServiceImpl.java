package SurveyForge.backend.Services.Implementation;


import SurveyForge.backend.Models.Question;
import SurveyForge.backend.Entities.SurveyAnswer;
import SurveyForge.backend.Models.SurveyAnswerModel;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Repositories.SurveyAnswerRepository;
import SurveyForge.backend.Responses.Report;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    public List<Report> reportSurvey(SurveyModel surveyModel) {
        List<SurveyAnswer> list = surveyAnswerRepository.findBySurveyId(surveyModel.getId());
        List <SurveyAnswerModel> listModel = list.stream().map(this::toModel).toList();
        List<Question> listOfQues = surveyModel.getQuestionList();
        List<Report> listOfReport = new ArrayList<>();
        for (int i =0 ; i<listOfQues.size(); i++){
            Question question = listOfQues.get(i);
            switch(question.getQuestionType()){
                case SingleSelect ->  listOfReport.add(singleSelectReport(question,listModel, i));
                case FivePointScale -> listOfReport.add(fivePointReport(question,listModel,i));
                case Subjective -> listOfReport.add(subjectiveReport(question,listModel,i));
            }
        }
        return listOfReport;
    }

    private Report singleSelectReport(Question question, List<SurveyAnswerModel> list, Integer count){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> listOfOptions = question.getOptions();
        Integer totalCount = 0;
        for(int i =0; i<listOfOptions.size(); i++){
            map.put(listOfOptions.get(i),0);
        }
        for(int i =0; i<list.size();i++){
            totalCount++;
            SurveyAnswerModel surveyAnswerModel = list.get(i);
            map.put(surveyAnswerModel.getAnswerList().get(count).getAnswer(),map.get(surveyAnswerModel.getAnswerList().get(count).getAnswer())+1);
            if(i==list.size()-1){
                map.put("Total Count", totalCount);
            }
        }
        return new Report<>(question.getQuestion(),map);
    }
    private Report fivePointReport(Question question,List<SurveyAnswerModel> list, Integer count){
        HashMap<String, Integer> map = new HashMap<>();
        Integer totalCount = 0;
        for(Integer i =1; i<=5; i++){
            map.put(i.toString(),0);
        }
        for(int i =0; i<list.size(); i++){
            totalCount++;
            SurveyAnswerModel surveyAnswerModel = list.get(i);
            map.put(surveyAnswerModel.getAnswerList().get(count).getAnswer(),map.get(surveyAnswerModel.getAnswerList().get(count).getAnswer())+1);
            if(i==list.size()-1){
                map.put("Total Count", totalCount);
            }
        }
        return new Report<>(question.getQuestion(),map);
    }

    private Report subjectiveReport(Question question,List<SurveyAnswerModel> list, Integer count){
        List<String> listOfAnswers = new ArrayList<>();
        Integer totalCount = 0;
        for (int i =0; i<list.size(); i++){
            totalCount++;
            SurveyAnswerModel surveyAnswerModel = list.get(i);
            listOfAnswers.add(surveyAnswerModel.getAnswerList().get(count).getAnswer());
        }
        return new Report<>(question.getQuestion(),listOfAnswers);
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
