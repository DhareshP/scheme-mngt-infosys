package com.pms.scheme_management.service;

import com.pms.scheme_management.model.Scheme;
import com.pms.scheme_management.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    public Optional<Scheme> getSchemeById(int id) {
        return schemeRepository.findById(id);
    }

    public Scheme createScheme(Scheme scheme) {
        return schemeRepository.save(scheme);
    }

    public Scheme updateScheme(int id, Scheme schemeDetails) {
        return schemeRepository.findById(id).map(scheme -> {
            scheme.setSchemeDetails(schemeDetails.getSchemeDetails());
            scheme.setSchemeName(schemeDetails.getSchemeName());
            scheme.setDescription(schemeDetails.getDescription());
            scheme.setEligibiltyCriteria(schemeDetails.getEligibiltyCriteria());
            scheme.setBenifits(schemeDetails.getBenifits());
            return schemeRepository.save(scheme);
        }).orElseThrow(() -> new RuntimeException("Scheme not found with id: " + id));
    }

    public void deleteScheme(int id) {
        schemeRepository.deleteById(id);
    }

    public Scheme setSchemeActiveStatus(int id, boolean isActive) {
        return schemeRepository.findById(id).map(scheme -> {
            scheme.setSchemeIsActive(isActive);
            return schemeRepository.save(scheme);
        }).orElseThrow(() -> new RuntimeException("Scheme not found with id: " + id));
    }

    public List<Scheme> getAllActiveSchemes(){
        return schemeRepository.findBySchemeIsActiveIsTrue();
    }
}
