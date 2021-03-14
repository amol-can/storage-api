package api.subscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.subscription.entity.Plan;
import api.subscription.repository.PlanRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PlanRepo planRepo;

    @Override
    public void addPlan(Plan plan) {
        planRepo.save(plan);
    }

    @Override
    public List<Plan> getAllPlan() {
        return planRepo.findAll();
    }

    @Override
    public Plan getPlan(Long planId) {
        Optional<Plan> plan = planRepo.findById(planId);
        if (plan.isPresent())
            return plan.get();
        return new Plan(); // TODO can throw custom exception
    }
}
