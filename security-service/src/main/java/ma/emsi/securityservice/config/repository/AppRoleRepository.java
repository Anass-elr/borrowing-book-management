package ma.emsi.securityservice.config.repository;

import ma.emsi.securityservice.config.entites.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
