package Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private  static final Long serialVisionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
