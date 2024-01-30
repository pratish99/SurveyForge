package SurveyForge.backend.Models;


import SurveyForge.backend.Entities.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyModel {
    String id;
    String userId;
    String name;
    List<Question> questionList;
    LocalDateTime startTime;
    LocalDateTime endTime;
    List<User> collaborators;
}
