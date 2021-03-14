package resources.subscription.service;

import resources.subscription.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    void addSubscription(Subscription subscription);
    List<Subscription> getAllSubscription();
    Subscription getSubscription(Long subscriptionId);
}
