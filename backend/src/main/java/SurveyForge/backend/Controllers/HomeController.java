package SurveyForge.backend.Controllers;

import SurveyForge.backend.Entities.User;
import SurveyForge.backend.Enumerators.PermissionType;
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
    public ResponseEntity<?> login(@RequestBody User user){
        Response response = homeService.login(user);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }

    @PostMapping("/invite-collaborator")
    public ResponseEntity<?> inviteCollaborator(@RequestParam(value = "email") String email, @RequestParam(value = "surveyId") String surveyId, @RequestParam(value = "permissionType")PermissionType permissionType){
        Response response = homeService.inviteCollaborator(email, surveyId, permissionType);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }

    @GetMapping("/get-collaborated-survey/{userId}")
    public ResponseEntity getCollaboratedSurvey(@PathVariable("userId") String userId){
        Response response = homeService.getCollaboratedSurvey(userId);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }

}
