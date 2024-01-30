package SurveyForge.backend.Entities;


import SurveyForge.backend.Models.Question;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Survey")
public class Survey {
    String id;
    String userId;
    String name;
    List<Question> questionList;
    LocalDateTime startTime;
    LocalDateTime endTime;
    List<User> collaborators;
}
