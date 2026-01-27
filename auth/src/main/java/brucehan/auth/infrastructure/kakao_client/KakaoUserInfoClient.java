package brucehan.auth.infrastructure.kakao_client;

import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoOAuthUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "kakaoInfoClient", url = "${oauth2.client.kakao.user-info-url}")
public interface KakaoUserInfoClient {
    @GetMapping
    KakaoOAuthUserResponse kakaoUserInfo(
            @RequestHeader("Authorization") final String token,
            @RequestHeader(name = "Content-type") final String contentType
    );
}
