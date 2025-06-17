package tn.esprit.spring.booknetwork.handle;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum BusinessErrorCodes {
    NO_CODE(0, "NO CODE" , NOT_IMPLEMENTED),
    INCORRECT_CURRENT_PASSWORD(300,"current password is incorrect", BAD_REQUEST),
    NEW_PASSWORD_DOES_NOT_MATCH(301 ,"the new password does not match", BAD_REQUEST),
    ACCOUNT_LOCKED(302 ,"User account is locked" ,FORBIDDEN),
    ACCOUNT_DISABLED(303, "User account is disabled",FORBIDDEN ),
    BAD_CREDENTIALS(304, "Login and / or Password is incorrect",FORBIDDEN ),
    ;
    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;



    BusinessErrorCodes(int code, String description, HttpStatus httpStatus) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
