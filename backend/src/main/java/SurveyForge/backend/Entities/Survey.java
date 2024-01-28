package SurveyForge.backend.Entities;

import java.time.LocalDateTime;
import java.util.List;

public class Survey {
    Integer id;
    Integer userId;
    String name;
    List<Question> questionList;
    LocalDateTime startTime;
    LocalDateTime endTime;
    List<User> collaborators;
}
