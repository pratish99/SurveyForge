package SurveyForge.backend.Models;

import SurveyForge.backend.Enumerators.QuestionType;

import java.util.List;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    String id;
    String question;
    QuestionType questionType;
    List<String> options;
}
