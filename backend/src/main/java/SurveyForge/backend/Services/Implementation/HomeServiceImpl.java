package SurveyForge.backend.Services.Implementation;

import SurveyForge.backend.Entities.User;
import SurveyForge.backend.Models.UserModel;
import SurveyForge.backend.Repositories.UserRepository;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.HomeService;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SurveyService surveyService;
    @Override
    public Response login(String email) {
        User user =userRepository.findByEmail(email);
        if(user != null){
            return new Response(user);
        }
        user = user.builder().email(email).build();
        userRepository.save(user);
        return new Response(user);
    }

    @Override
    public Response inviteCollaborator(String email, String surveyId) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            return new Response("User Not Found! ", HttpStatus.NOT_FOUND);
        }
        surveyService.updateCollaborator(toModel(user), surveyId);
        return new Response("User Added");
    }
    private UserModel toModel(User user){
        return UserModel.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
