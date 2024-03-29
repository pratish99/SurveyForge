package SurveyForge.backend.Models;

import SurveyForge.backend.Enumerators.PermissionType;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    String id;
    String email;
    List<CollaboratedSurveyModel> collaboratedSurveyModelList;
}