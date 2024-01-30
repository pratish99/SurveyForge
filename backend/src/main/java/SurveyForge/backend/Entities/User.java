package SurveyForge.backend.Entities;

import SurveyForge.backend.Enumerators.PermissionType;
import SurveyForge.backend.Models.CollaboratedSurveyModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

import java.security.Permission;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {
    String id;
    String email;
    List<CollaboratedSurveyModel> collaboratedSurveyList;
}
