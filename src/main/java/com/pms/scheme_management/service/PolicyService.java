package com.pms.scheme_management.service;

import com.pms.scheme_management.model.Policy;
import com.pms.scheme_management.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Optional<Policy> getPolicyById(int id) {
        return policyRepository.findById(id);
    }

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy updatePolicy(int id, Policy updatedPolicy) {
        if (policyRepository.existsById(id)) {
            updatedPolicy.setId(id);
            return policyRepository.save(updatedPolicy);
        }
        return null;
    }

    public void deletePolicy(int id) {
        policyRepository.deleteById(id);
    }
}
