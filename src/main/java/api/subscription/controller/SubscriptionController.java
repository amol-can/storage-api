package api.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.subscription.entity.Subscription;
import api.subscription.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping(value = "/subscription")
public class PSubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getSubscriptions(){
        return new ResponseEntity<>(subscriptionService.getAllSubscription(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveSubscription(@RequestBody Subscription subscription){
        subscriptionService.addSubscription(subscription);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/{subId}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long subId){
        Subscription subscription = subscriptionService.getSubscription(subId);
        if (subscription == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(subscription,HttpStatus.OK);
    }


}
