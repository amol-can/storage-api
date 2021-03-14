package resources.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import resources.subscription.entity.Subscription;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription,Long> {
}
