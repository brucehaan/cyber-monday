package brucehan.auth.domain;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OauthInfo {

    @Enumerated(EnumType.STRING)
    private OauthProvider provider;

    private Long openId;

    @Builder
    public OauthInfo(OauthProvider provider, Long openId) {
        this.provider = provider;
        this.openId = openId;
    }
}
