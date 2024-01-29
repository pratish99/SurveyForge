package SurveyForge.backend.Repositories;

import SurveyForge.backend.Entities.SurveyAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyAnswerRepository extends MongoRepository<SurveyAnswer,String> {
    public List<SurveyAnswer> findBySurveyId(String surveyId);
}
