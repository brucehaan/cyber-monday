package brucehan.auth.presentation;

import brucehan.auth.infrastructure.kakao_client.dto.request.KakaoSocialLoginRequest;
import brucehan.auth.application.KakaoSocialLoginService;
import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoOAuthUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kakao")
public class KakaoSocialLoginController {
    private final KakaoSocialLoginService kakaoSocialLoginService;

    @PostMapping("/sign-up/openfeign")
    public KakaoOAuthUserResponse loginOrSignUp(
            @RequestBody KakaoSocialLoginRequest kakaoSocialLoginRequest
    ) {
        return kakaoSocialLoginService.loginOrSignUp(kakaoSocialLoginRequest.code());
    }

    @GetMapping("/login/callback")
    public void callback(
            @RequestParam String code,
            @RequestParam String state
    ) {
        System.out.println("code = " + code);
        System.out.println("state = " + state);
    }


}
