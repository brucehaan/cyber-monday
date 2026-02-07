package brucehan.auth.infrastructure.kakao_client.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// 카멜케이스를 스네이크 케이스로 바꿔줌
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record KakaoAccessTokenResponse(
        String accessToken,
        String idToken,
        Integer expiresIn,
        String refreshToken,
        Integer refreshTokenExpiresIn
) {
}
