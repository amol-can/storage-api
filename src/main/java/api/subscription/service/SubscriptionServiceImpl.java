package api.subscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.subscription.entity.Subscription;
import api.subscription.repository.SubscriptionRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
    @Autowired
    SubscriptionRepo subscriptionRepo;
    @Override
    public void addSubscription(Subscription subscription) {
        subscriptionRepo.save(subscription);
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return subscriptionRepo.findAll();
    }

    @Override
    public Subscription getSubscription(Long subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepo.findById(subscriptionId);
        if (subscription.isPresent())
            return subscription.get();
        return null; // TODO
    }
}
