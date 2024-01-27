package SurveyForge.backend.Controllers;

import SurveyForge.backend.Responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Hello";
    }
    @GetMapping("/login")
    public String login(){
        return "Logged In";
    }
}
