package com.pms.scheme_management.controller;

import com.pms.scheme_management.exception.SchemeNotFoundException;
import com.pms.scheme_management.model.Scheme;
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

    @GetMapping("/search")
    public ResponseEntity<List<Scheme>> searchSchemesByName(@RequestParam String schemeName) {
        List<Scheme> schemes = schemeService.getBySchemeName(schemeName);
        if (schemes.isEmpty()) {
            throw new SchemeNotFoundException("No schemes found with name containing: " + schemeName);
        }
        return ResponseEntity.ok(schemes);
    }




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
}

