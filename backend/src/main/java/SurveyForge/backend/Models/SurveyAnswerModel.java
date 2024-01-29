package SurveyForge.backend.Models;

import SurveyForge.backend.Entities.Answer;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyAnswerModel {
    String id;
    String surveyId;
    List<Answer> answerList;
}
