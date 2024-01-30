package SurveyForge.backend.Models;

import SurveyForge.backend.Enumerators.PermissionType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratedSurveyModel {
    String surveyId;
    PermissionType permissionType;
}
