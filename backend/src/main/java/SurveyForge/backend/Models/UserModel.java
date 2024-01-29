package SurveyForge.backend.Models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    Integer userId;
    String email;
}