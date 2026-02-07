package brucehan.auth.infrastructure.kakao_client.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record KakaoOAuthUserResponse(
        String id,
        KakaoAccount kakaoAccount,
        LocalDateTime connected_at
) {
    public record KakaoAccount(
            String name,
            String email,
            String phoneNumber,
            Profile profile
    ) {
        public record Profile(
                String nickname
        ) {
        }
    }
}
