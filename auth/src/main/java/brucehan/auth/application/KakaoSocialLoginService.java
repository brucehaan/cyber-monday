package brucehan.auth.application;

import brucehan.auth.infrastructure.kakao_client.KakaoAccessTokenClient;
import brucehan.auth.infrastructure.kakao_client.KakaoUserInfoClient;
import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoAccessTokenResponse;
import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoOAuthUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoSocialLoginService {

    @Value("${oauth2.client.kakao.client-id}")
    private String kakaoClientId;

    @Value("${oauth2.client.kakao.redirect-uri}")
    private String kakaoRedirectUri;

    @Value("${oauth2.client.kakao.content-type}")
    private String kakaoContentType;

    @Value("${oauth2.client.kakao.grant-type}")
    private String kakaoGrantType;

    @Value("${oauth2.client.kakao.client-secret}")
    private String kakaoClientSecret;

    private static final String TOKEN_TYPE = "Bearer ";

    private final KakaoAccessTokenClient kakaoAccessTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;

    public KakaoOAuthUserResponse loginOrSignUp(final String code) {
        final KakaoAccessTokenResponse kakaoAccessTokenResponse = kakaoAccessTokenClient.kakaoAuth(
                kakaoContentType,
                code,
                kakaoClientId,
                kakaoRedirectUri,
                kakaoGrantType,
                kakaoClientSecret
        );
        //
        // 회원가입 로직도 필요
        return kakaoUserInfoClient.kakaoUserInfo(
                TOKEN_TYPE + kakaoAccessTokenResponse.accessToken(),
                kakaoContentType,
                "user_id",
                4724752501L
        );
    }
}
