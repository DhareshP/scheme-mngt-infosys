package com.pms.scheme_management.controller;

import com.pms.scheme_management.model.Scheme;
import com.pms.scheme_management.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    @Autowired
    private SchemeService schemeService;

    @GetMapping
    public List<Scheme> getAllSchemes() {
        return schemeService.getAllSchemes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheme> getSchemeById(@PathVariable int id) {
        Optional<Scheme> scheme = schemeService.getSchemeById(id);
        return scheme.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Scheme createScheme(@RequestBody Scheme scheme) {
        return schemeService.createScheme(scheme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheme> updateScheme(@PathVariable int id, @RequestBody Scheme schemeDetails) {
        try {
            Scheme updatedScheme = schemeService.updateScheme(id, schemeDetails);
            return ResponseEntity.ok(updatedScheme);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Scheme> updateSchemeActiveStat(@PathVariable int id, @RequestParam boolean isActive) {
        try {
            Scheme updatedScheme = schemeService.setSchemeActiveStatus(id, isActive);
            return ResponseEntity.ok(updatedScheme);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}