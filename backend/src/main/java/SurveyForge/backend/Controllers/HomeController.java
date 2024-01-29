package SurveyForge.backend.Controllers;

import SurveyForge.backend.Models.UserModel;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

   /* @GetMapping("/")
    public String home(){
        return "Hello";
    }
    @GetMapping("/login")
    public String login(){
        return "Logged In";
    }*/

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String email){
        Response response = homeService.login(email);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }

    @PostMapping("/invite-collaborator")
    public ResponseEntity<?> inviteCollaborator(@RequestParam(value = "email") String email, @RequestParam(value = "surveyId") String surveyId){
        Response response = homeService.inviteCollaborator(email, surveyId);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }



}
