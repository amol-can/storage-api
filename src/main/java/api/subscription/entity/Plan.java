package api.subscription.entity;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long planId;
    private String name;
    private int pricePerMonth;
    private int getPricePerYear;

    public Plan(){

    }

    public Plan(String name, int pricePerMonth, int getPricePerYear) {
        this.name = name;
        this.pricePerMonth = pricePerMonth;
        this.getPricePerYear = getPricePerYear;
    }

    public Long getPlanId() {
        return planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(int pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public int getGetPricePerYear() {
        return getPricePerYear;
    }

    public void setGetPricePerYear(int getPricePerYear) {
        this.getPricePerYear = getPricePerYear;
    }
}
