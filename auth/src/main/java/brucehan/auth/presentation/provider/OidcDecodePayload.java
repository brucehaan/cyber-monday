package brucehan.auth.presentation.provider;

public record OidcDecodePayload(
        String iss,
        String aud,
        String sub,
        String email
) {

}
