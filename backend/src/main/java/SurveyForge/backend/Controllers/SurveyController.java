package SurveyForge.backend.Controllers;

import SurveyForge.backend.Entities.Answer;
import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @PostMapping("/create-survey")
    public ResponseEntity createSurvey(@RequestBody SurveyModel surveyModel){
        Response response = surveyService.createSurvey(surveyModel);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }
}
