package brucehan.auth.infrastructure.kakao_client.dto;

import java.util.List;

public record PublicKeysDto(
        List<JWK> keys
) {
    public record JWK(
            String kid,
            String kty,
            String alg,
            String use,
            String n,
            String e
    ) {

    }
}
