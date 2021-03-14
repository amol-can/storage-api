package resources.subscription.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;
    private Long userId;
    private Long planId;
    private Date subscriptionStartDate;
    private Date getSubscriptionEndDate;

    public Subscription(){

    }

    public Subscription(Long userId, Long planId, Date subscriptionStartDate, Date getSubscriptionEndDate) {
        this.userId = userId;
        this.planId = planId;
        this.subscriptionStartDate = subscriptionStartDate;
        this.getSubscriptionEndDate = getSubscriptionEndDate;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Date getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(Date subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Date getGetSubscriptionEndDate() {
        return getSubscriptionEndDate;
    }

    public void setGetSubscriptionEndDate(Date getSubscriptionEndDate) {
        this.getSubscriptionEndDate = getSubscriptionEndDate;
    }
}
