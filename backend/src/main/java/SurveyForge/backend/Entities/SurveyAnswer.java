package SurveyForge.backend.Entities;

import SurveyForge.backend.Models.Answer;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SurveyAnswer")
public class SurveyAnswer {
    String id;
    String surveyId;
    List<Answer> answerList;
}
