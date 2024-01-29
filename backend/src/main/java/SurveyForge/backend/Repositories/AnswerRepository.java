package SurveyForge.backend.Repositories;

import SurveyForge.backend.Entities.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer,Integer> {
}
