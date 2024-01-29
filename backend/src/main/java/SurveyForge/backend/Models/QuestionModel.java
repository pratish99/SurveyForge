package SurveyForge.backend.Models;

import SurveyForge.backend.Enumerators.QuestionType;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionModel {
    String question;
    QuestionType questionType;
}