package SurveyForge.backend.Models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerModel {
    Integer id;
    Integer quesId;
    String answer;
}
