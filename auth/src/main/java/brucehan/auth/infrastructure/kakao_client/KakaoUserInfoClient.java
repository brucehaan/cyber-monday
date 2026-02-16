package brucehan.auth.infrastructure.kakao_client;

import brucehan.auth.infrastructure.kakao_client.dto.PublicKeysDto;
import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoOAuthUserResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "kakaoInfoClient",
        url = "${oauth2.client.kakao.user-info-url}") // TODO : yml로 묶기
public interface KakaoUserInfoClient {
    @GetMapping
    KakaoOAuthUserResponse kakaoUserInfo(
            @RequestHeader("Authorization") final String token,
            @RequestHeader(name = "Content-type") final String contentType,
            @RequestParam(name = "target_id_type") final String targetIdType,
            @RequestParam(name = "target_id") final Long targetId
    );
}
