package brucehan.auth.application;

import brucehan.auth.application.helper.KakaoOauthHelper;
import brucehan.auth.infrastructure.kakao_client.KakaoTokenClient;
import brucehan.auth.infrastructure.kakao_client.KakaoUserInfoClient;
import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoAccessTokenResponse;
import brucehan.auth.infrastructure.kakao_client.dto.response.KakaoOAuthUserResponse;
import brucehan.auth.presentation.provider.OidcDecodePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
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

    private final KakaoOauthHelper kakaoOauthHelper;

    private static final String TOKEN_TYPE = "Bearer ";

    private final KakaoTokenClient kakaoAccessTokenClient;
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
        String idToken = kakaoAccessTokenResponse.idToken();
        System.out.println("kakaoAccessTokenResponse.idToken() = " + idToken);

        OidcDecodePayload decodePayload = kakaoOauthHelper.getOidcDecodePayload(idToken);
        log.info("decodePayload - {}", decodePayload);

        // 회원가입 로직도 필요
        return kakaoUserInfoClient.kakaoUserInfo(
                TOKEN_TYPE + kakaoAccessTokenResponse.accessToken(),
                kakaoContentType,
                "user_id",
                4724752501L
        );
    }

}
