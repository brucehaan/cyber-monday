package brucehan.auth.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter
public class SocialAccountId implements Serializable {

    @Column(name = "id")
    private byte[] id;

    @Column(name = "provider")
    private String provider;
}
