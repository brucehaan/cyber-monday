package brucehan.auth.infrastructure.kakao_client;

import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoAccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "kakaoClient", url = "${oauth2.client.kakao.token-url}") // TODO : yml로 묶기
public interface KakaoAccessTokenClient {

    // 토큰 요청 https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token
    @PostMapping
    KakaoAccessTokenResponse kakaoAuth(
            @RequestHeader(name = "Content-Type") final String contentType,
            @RequestParam(name = "code") final String code,
            @RequestParam(name = "client_id") final String clientId,
            @RequestParam(name = "redirect_uri") final String redirectUrl,
            @RequestParam(name = "grant_type") final String grantType
    );
}
