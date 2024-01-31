package SurveyForge.backend.Services.Implementation;
import SurveyForge.backend.Entities.User;
import SurveyForge.backend.Enumerators.PermissionType;
import SurveyForge.backend.Models.CollaboratedSurveyModel;
import SurveyForge.backend.Models.SurveyModel;
import SurveyForge.backend.Models.UserModel;
import SurveyForge.backend.Repositories.UserRepository;
import SurveyForge.backend.Responses.Response;
import SurveyForge.backend.Services.HomeService;
import SurveyForge.backend.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SurveyService surveyService;
    @Override
    public Response login(User user) {
        User user1 =userRepository.findByEmail(user.getEmail());
        if(user1 != null){
            return new Response(user1);
        }
        user1 = user1.builder().email(user.getEmail()).collaboratedSurveyList(new ArrayList<>()).build();
        userRepository.save(user1);
        return new Response(user1);
    }

    @Override
    public Response inviteCollaborator(String email, String surveyId, PermissionType permissionType) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            return new Response("User Not Found!");
        }
        List<CollaboratedSurveyModel> list =  user.getCollaboratedSurveyList();
        for(CollaboratedSurveyModel model : list){
            if(model.getSurveyId().equals(surveyId)){
                return new Response("User Already Exist!");
            }
        }
        list.add(new CollaboratedSurveyModel(surveyId, permissionType));
        user.setCollaboratedSurveyList(list);
        userRepository.save(user);
        surveyService.updateCollaborator(toModel(user), surveyId, permissionType);
        return new Response("User Added");
    }

    @Override
    public Response getCollaboratedSurvey(String userId) {
        User user = userRepository.findById(userId).get();
        List<SurveyModel> surveyModelList = new ArrayList<>();
        for(CollaboratedSurveyModel survey : user.getCollaboratedSurveyList()){
            surveyModelList.add(surveyService.getSurveyById(survey.getSurveyId()));
        }
        return new Response<>(surveyModelList);
    }

    private UserModel toModel(User user){
        return UserModel.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
