package brucehan.auth.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "cybermonday", name = "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_pk")
    private Long memberPk;

    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private byte[] memberId;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "savings")
    private Long savings;

    @Column(name = "role")
    private String role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}



