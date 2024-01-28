package SurveyForge.backend.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Survey")
public class Survey {
    @Id
    Integer id;
    Integer userId;
    String name;
    List<Question> questionList;
    LocalDateTime startTime;
    LocalDateTime endTime;
    List<User> collaborators;
}
