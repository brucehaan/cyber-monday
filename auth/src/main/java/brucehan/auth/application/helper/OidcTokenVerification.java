package brucehan.auth.application.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OidcTokenVerification {
    private final ObjectMapper objectMapper;

    public OidcTokenVerification(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


}
