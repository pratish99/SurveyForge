package SurveyForge.backend.Controllers;

import SurveyForge.backend.Models.UserModel;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/login/{email}")
    public ResponseEntity<?> login(@PathVariable("email") String email){
        Response response = homeService.login(email);
        return new ResponseEntity<>(response.getReturnObject(), response.getHttpStatus());
    }

}
