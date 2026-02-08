package brucehan.auth.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(schema = "cybermonday", name = "social_accounts")
public class SocialAccount {

    @EmbeddedId
    private SocialAccountId socialAccountId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
