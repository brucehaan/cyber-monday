package brucehan.auth.infrastructure.kakao_client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://developers.kakao.com/docs/ko/kakaologin/rest-api#request-token-response
 */
public record OAuthTokenResponse(
        @JsonProperty("access_token")
        String accessToken,

        @JsonProperty("id_token")
        String idToken,

        @JsonProperty("expires_in")
        Integer expiresIn,

        @JsonProperty("refresh_token")
        String refreshToken,

        @JsonProperty("refresh_token_expires_in")
        Integer refreshTokenExpiresIn
) {
}
