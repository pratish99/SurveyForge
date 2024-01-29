package SurveyForge.backend.Entities;

import SurveyForge.backend.Enumerators.QuestionType;

import java.util.List;


public class Question {
    Integer id;
    String question;
    QuestionType questionType;
    List<String> options;
}
