package SurveyForge.backend.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Report<T>{
    String ques;
    T stats;
    public Report(T returnObject){
        this.ques = null;
        this.stats = returnObject;
    }
}