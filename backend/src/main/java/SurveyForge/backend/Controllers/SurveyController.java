package SurveyForge.backend.Controllers;

import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;


    @PostMapping("/create-survey")
    public ResponseEntity createSurvey(@RequestBody SurveyModel surveyModel){
        Response response = surveyService.createSurvey(surveyModel);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }

    @GetMapping("/get-survey/{userId}")
    public ResponseEntity getSurvey(@PathVariable("userId") String userId){
        Response response = surveyService.getSurvey(userId);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }

    @GetMapping("/get-particular-survey/{surveyId}")
    public ResponseEntity getParticularSurvey(@PathVariable("surveyId") String surveyId){
        Response response = surveyService.getParticularSurvey(surveyId);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }



    @PutMapping("/edit-survey")
    public ResponseEntity editSurvey(@RequestBody SurveyModel surveyModel){
        Response response = surveyService.editSurvey(surveyModel);
        return new ResponseEntity<>(response.getReturnObject(),response.getHttpStatus());
    }
    @GetMapping("/report/{surveyId}")
    public ResponseEntity reportSurvey(@PathVariable("surveyId") String surveyId){
        Response response = surveyService.reportSurvey(surveyId);
        return new ResponseEntity<>(response.getReturnObject(),response.getHttpStatus());
    }

    @GetMapping("/active-surveys/{userId}")
    public ResponseEntity activeSurveys(@PathVariable("userId")String userID){
        Response response = surveyService.activeSurveys(userID);
        return new ResponseEntity(response.getReturnObject(),response.getHttpStatus());
    }

    @GetMapping("/completed-surveys/{userId}")
    public ResponseEntity completedSurveys(@PathVariable("userId")String userID){
        Response response = surveyService.completedSurveys(userID);
        return new ResponseEntity(response.getReturnObject(),response.getHttpStatus());
    }

}
