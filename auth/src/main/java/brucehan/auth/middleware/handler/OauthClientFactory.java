package brucehan.auth.middleware.handler;

import brucehan.auth.domain.OauthProvider;
import brucehan.auth.application.OAuthClient;
import brucehan.auth.infrastructure.kakao_client.KakaoOAuthClient;
import org.springframework.stereotype.Component;

@Component
public class OauthClientFactory {
    private final KakaoOAuthClient kakaoOauthClient;

    public OauthClientFactory(KakaoOAuthClient kakaoOauthClient) {
        this.kakaoOauthClient = kakaoOauthClient;
    }

    public OAuthClient getClient(OauthProvider provider) {
        return switch (provider) {
            case KAKAO -> kakaoOauthClient;
            case GOOGLE -> throw new UnsupportedOperationException("Google OauthClient is not implemented");
        };
    }
}
