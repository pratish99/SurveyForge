package SurveyForge.backend.Controllers;

import SurveyForge.backend.Entities.SurveyAnswer;
import SurveyForge.backend.Models.SurveyAnswerModel;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyAnswerController {
    @Autowired
    SurveyAnswerService surveyAnswerService;
    @PostMapping("/answer/{surveyId}")
    public ResponseEntity answerSurvey(@RequestBody SurveyAnswerModel surveyAnswerModel, @PathVariable("surveyId") String surveyId){
        Response response = surveyAnswerService.surveyAnswer(surveyAnswerModel, surveyId);
        return new ResponseEntity<>(response.getReturnObject(),response.getHttpStatus());
    }

    @GetMapping("/all/{surveyId}")
    public ResponseEntity getAllAnswers(@PathVariable("surveyId") String surveyId){
        Response response = surveyAnswerService.getAllAnswers(surveyId);
        return new ResponseEntity<>(response.getReturnObject(),response.getHttpStatus());
    }
}
