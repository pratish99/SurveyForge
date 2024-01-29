package SurveyForge.backend.Models;

import SurveyForge.backend.Enumerators.QuestionType;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionModel {
    String id;
    String question;
    QuestionType questionType;
    List<String> options;
}