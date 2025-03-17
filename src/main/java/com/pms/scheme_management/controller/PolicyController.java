package com.pms.scheme_management.controller;

import com.pms.scheme_management.model.Policy;
import com.pms.scheme_management.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Optional<Policy> getPolicyById(@PathVariable int id) {
        return policyService.getPolicyById(id);
    }

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable int id, @RequestBody Policy policy) {
        return policyService.updatePolicy(id, policy);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable int id) {
        policyService.deletePolicy(id);
    }
}
