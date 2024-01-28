package SurveyForge.backend.Models;

import SurveyForge.backend.Entities.Question;
import SurveyForge.backend.Entities.User;

import java.time.LocalDateTime;
import java.util.List;

public class SurveyModel {
    Integer id;
    Integer userId;
    String name;
    List<Question> questionList;
    LocalDateTime startTime;
    LocalDateTime endTime;
    List<User> collaborators;
}
