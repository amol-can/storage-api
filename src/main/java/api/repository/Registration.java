package api.repository;

import api.entity.RegistrationEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Registration extends JpaRepository<RegistrationEO,Long> {

}
