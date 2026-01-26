package brucehan.auth.presentation;

import brucehan.auth.client.dto.request.KakaoSocialLoginRequest;
import brucehan.auth.application.KakaoSocialLoginService;
import brucehan.auth.client.dto.response.KakaoOAuthUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kakao")
public class KakaoSocialLoginController {
    private final KakaoSocialLoginService kakaoSocialLoginService;

    @PostMapping("/login/openfeign")
    public KakaoOAuthUserResponse login(
            @RequestBody KakaoSocialLoginRequest kakaoSocialLoginRequest
    ) {
        return kakaoSocialLoginService.login(kakaoSocialLoginRequest.code());
    }
}
