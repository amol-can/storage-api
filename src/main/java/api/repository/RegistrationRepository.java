package api.repository;

import api.entity.RegistrationEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RegistrationRepository extends JpaRepository<RegistrationEO,Long> {
    RegistrationEO findByUserEmail(String email);
}
