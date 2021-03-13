package api.repository;

import api.entity.OrgEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepo extends JpaRepository<OrgEO, Long> {

}
