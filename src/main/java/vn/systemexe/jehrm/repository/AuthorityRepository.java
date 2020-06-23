package vn.systemexe.jehrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.systemexe.jehrm.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
