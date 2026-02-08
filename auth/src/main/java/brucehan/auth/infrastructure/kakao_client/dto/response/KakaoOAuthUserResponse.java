package brucehan.auth.infrastructure.kakao_client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record KakaoOAuthUserResponse(
        String id,
        @JsonProperty("kakao_account")
        KakaoAccount kakaoAccount,
        @JsonProperty("connected_at")
        LocalDateTime connectedAt
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
