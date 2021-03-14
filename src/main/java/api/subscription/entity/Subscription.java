package api.subscription.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;
    /* TODO mapping
    @OneToOne
    @JoinColumn(name = "userId")*/
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "planIdRef", referencedColumnName = "planId")
    private Plan plan;
    private Date subscriptionPurchasedDate;
    private Date subscriptionStartDate;
    private Date subscriptionEndDate;

    public Subscription(){

    }

    public Subscription(Long userId, Plan plan, Date subscriptionPurchasedDate, Date subscriptionStartDate,
                        Date subscriptionEndDate) {
        this.userId = userId;
        this.plan = plan;
        this.subscriptionPurchasedDate = subscriptionPurchasedDate;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Date getSubscriptionPurchasedDate() {
        return subscriptionPurchasedDate;
    }

    public void setSubscriptionPurchasedDate(Date subscriptionPurchasedDate) {
        this.subscriptionPurchasedDate = subscriptionPurchasedDate;
    }

    public Date getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(Date subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }
}
