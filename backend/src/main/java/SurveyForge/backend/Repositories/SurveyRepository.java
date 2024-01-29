package SurveyForge.backend.Repositories;

import SurveyForge.backend.Entities.Survey;
import SurveyForge.backend.Models.SurveyModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends MongoRepository<Survey,String> {
    List<Survey> findByUserId(String userId);
    List<Survey> findByCollaboratorsId(String email);
}
