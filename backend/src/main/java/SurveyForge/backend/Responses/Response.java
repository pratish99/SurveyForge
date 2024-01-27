package SurveyForge.backend.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class Response<T>{
    T returnObject;
    HttpStatus httpStatus;
    public Response(T returnObject){
        this.returnObject = returnObject;
        this.httpStatus = HttpStatus.OK;
    }
}
