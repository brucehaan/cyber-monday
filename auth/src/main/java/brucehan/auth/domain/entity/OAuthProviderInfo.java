package brucehan.auth.domain.entity;

import brucehan.auth.domain.OauthProvider;

/**
 * TODO AuthService에서 사용하면서 여기서 부족한 점은 없는지 고민
 * @param provider
 * @param subject
 */
public record OAuthProviderInfo(
        OauthProvider provider,
        String subject
) {
}
