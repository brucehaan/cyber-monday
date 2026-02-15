package brucehan.auth.domain.repository;

import brucehan.auth.domain.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Members, Long> {
}
