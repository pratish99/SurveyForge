package SurveyForge.backend.Repositories;

import SurveyForge.backend.Entities.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<Survey,String> {
}
