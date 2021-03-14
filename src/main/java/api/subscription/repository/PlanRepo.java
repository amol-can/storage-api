package api.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.subscription.entity.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan,Long> {
}
