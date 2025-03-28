package com.pms.scheme_management.controller;

import com.pms.scheme_management.exception.SchemeNotFoundException;
import com.pms.scheme_management.model.Policy;
import com.pms.scheme_management.model.Scheme;
import com.pms.scheme_management.repository.PolicyRepo;
import com.pms.scheme_management.repository.SchemeRepository;
import com.pms.scheme_management.service.SchemeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    @Autowired
    private SchemeService schemeService;

    @Autowired
    private SchemeRepository schemeRepository;

    @Autowired
    private PolicyRepo policyRepository;

    @GetMapping
    public List<Scheme> getAllSchemes() {
        return schemeService.getAllSchemes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheme> getSchemeById(@PathVariable int id) {
        Scheme scheme = schemeService.getSchemeById(id)
                .orElseThrow(() -> new SchemeNotFoundException("Scheme not found with ID: " + id));
        return ResponseEntity.ok(scheme);
    }

    @PostMapping("/{schemeId}/policies")
    public ResponseEntity<String> addPolicyToScheme(@PathVariable int schemeId, @RequestBody Policy policy) {
        return schemeRepository.findById(schemeId).map(scheme -> {
            policy.setScheme(scheme);
            policyRepository.save(policy);
            return ResponseEntity.ok("Policy added successfully to Scheme ID: " + schemeId);
        }).orElse(ResponseEntity.badRequest().body("Scheme not found with ID: " + schemeId));
    }

    @GetMapping("/{schemeId}/policies")
    public ResponseEntity<?> getPoliciesBySchemeId(@PathVariable int schemeId) {
        return schemeRepository.findById(schemeId).map(scheme -> {
            List<Policy> policies = policyRepository.findBySchemeId(schemeId);
            if (policies.isEmpty()) {
                return ResponseEntity.ok("No policies found under Scheme ID: " + schemeId);
            }
            return ResponseEntity.ok(policies);
        }).orElse(ResponseEntity.badRequest().body("Scheme not found with ID: " + schemeId));
    }

//    @GetMapping("/schemes/{schemeId}/policies")
//    public ResponseEntity<List<Policy>> getPoliciesBySchemeId(@PathVariable int schemeId) {
//        List<Policy> policies = policyRepository.findBySchemeId(schemeId);
//        return ResponseEntity.ok(policies);
//    }



    @PostMapping
    public Scheme createScheme(@Valid @RequestBody Scheme scheme) {
        return schemeService.createScheme(scheme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheme> updateScheme(@PathVariable int id, @RequestBody Scheme schemeDetails) {
        Scheme updatedScheme = schemeService.updateScheme(id, schemeDetails);
        return ResponseEntity.ok(updatedScheme);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Scheme> updateSchemeActiveStat(@PathVariable int id, @RequestParam boolean isActive) {
        Scheme updatedScheme = schemeService.setSchemeActiveStatus(id, isActive);
        return ResponseEntity.ok(updatedScheme);
    }

    @GetMapping("/active")
    public List<Scheme> getActiveSchemes(){
        return schemeService.getAllActiveSchemes();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Scheme>> searchSchemeByName(@RequestParam String schemeName) {
        List<Scheme> filteredSchemes = schemeService.getAllSchemesBySchemeName(schemeName);

        if (filteredSchemes.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content if no schemes found
        }

        return ResponseEntity.ok(filteredSchemes);
    }
}

