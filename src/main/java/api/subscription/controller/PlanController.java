package resources.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import resources.subscription.entity.Plan;
import resources.subscription.service.PlanService;

import java.util.List;

@RestController
@RequestMapping(value = "/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping
    public ResponseEntity<List<Plan>> getPlan(){
        return new ResponseEntity<>(planService.getAllPlan(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity savePlan(@RequestBody Plan plan){
        planService.addPlan(plan);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{planId}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long planId){
        Plan plan = planService.getPlan(planId);
        if (plan == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(planService.getPlan(planId),HttpStatus.OK);
    }

}
