package SurveyForge.backend.Models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerModel {
    Integer quesId;
    String answer;
}
