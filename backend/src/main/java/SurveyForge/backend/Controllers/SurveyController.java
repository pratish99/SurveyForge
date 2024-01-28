package SurveyForge.backend.Controllers;

import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    /*@PostMapping("/create-survey")
    public ResponseEntity createSurvey(){
        Response response = surveyService.createSurvey(@RequestBody Survey survey)
    }*/
}
