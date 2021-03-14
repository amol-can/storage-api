package resources.subscription.service;

import resources.subscription.entity.Plan;

import java.util.List;

public interface PlanService {
    void addPlan(Plan plan);
    List<Plan> getAllPlan();
    Plan getPlan(Long planId);
}
