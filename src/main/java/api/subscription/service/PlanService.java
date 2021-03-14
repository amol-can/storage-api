package api.subscription.service;

import api.subscription.entity.Plan;

import java.util.List;

public interface PlanService {
    void addPlan(Plan plan);
    List<Plan> getAllPlan();
    Plan getPlan(Long planId);
}
