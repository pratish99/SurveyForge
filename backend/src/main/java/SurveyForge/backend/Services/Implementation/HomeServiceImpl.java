package SurveyForge.backend.Services.Implementation;

import SurveyForge.backend.Entities.User;
import SurveyForge.backend.Repositories.UserRepository;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private UserRepository userRepository;
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
}
