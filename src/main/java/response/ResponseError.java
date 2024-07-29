package response;


import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * The response error structure
 *
 */
@AllArgsConstructor
public final class ResponseError {

    @JsonProperty("status_code")
    private HttpStatus statusCode;
    @Getter
    private String message;

    public int getStatusCode() {
        return statusCode.value();
    }
}

