package brucehan.auth.application;

import brucehan.auth.client.KakaoAccessTokenClient;
import brucehan.auth.client.KakaoUserInfoClient;
import brucehan.auth.client.dto.response.KakaoAccessTokenResponse;
import brucehan.auth.client.dto.response.KakaoUserInfoResponse;
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

    private static final String TOKEN_TYPE = "Bearer ";

    private final KakaoAccessTokenClient kakaoAccessTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;

    public KakaoUserInfoResponse login(final String code) {
        final KakaoAccessTokenResponse kakaoAccessTokenResponse = kakaoAccessTokenClient.kakaoAuth(
                kakaoContentType,
                code,
                kakaoClientId,
                kakaoRedirectUri,
                kakaoGrantType
        );
        return kakaoUserInfoClient.kakaoUserInfo(
                TOKEN_TYPE + kakaoAccessTokenResponse.accessToken(),
                kakaoContentType
        );
    }
}
