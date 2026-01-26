package brucehan.auth.client.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record KakaoOAuthUserResponse(
        String id,
        Map<String, Object> kakaoAccount
) {
}
