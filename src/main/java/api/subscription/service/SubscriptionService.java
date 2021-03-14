package api.subscription.service;

import api.subscription.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    void addSubscription(Subscription subscription);
    List<Subscription> getAllSubscription();
    Subscription getSubscription(Long subscriptionId);
}
