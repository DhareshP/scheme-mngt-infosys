package com.pms.scheme_management.service;

import com.pms.scheme_management.exception.SchemeNotFoundException;
import com.pms.scheme_management.model.Scheme;
import com.pms.scheme_management.model.UserSchemes;
import com.pms.scheme_management.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    @Autowired
    private UserSchemeService userSchemeService;

    private static final Logger log = LoggerFactory.getLogger(SchemeService.class);

    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    public Optional<Scheme> getSchemeById(int id) {
        return Optional.ofNullable(schemeRepository.findById(id)
                .orElseThrow(() -> new SchemeNotFoundException("Scheme not found with ID: " + id)));
    }


    public Scheme createScheme(Scheme scheme) {
         log.info("Received payload for scheme creation: {}", scheme);
        Scheme savedScheme = schemeRepository.save(scheme);
        log.info("Saved scheme: {}", savedScheme);
        return savedScheme;
    }

    public Scheme updateScheme(int id, Scheme schemeDetails) {
        return schemeRepository.findById(id).map(scheme -> {
            log.info("Received payload for scheme update: {}", id , schemeDetails);
            scheme.setSchemeDetails(schemeDetails.getSchemeDetails());
            scheme.setSchemeName(schemeDetails.getSchemeName());
            scheme.setDescription(schemeDetails.getDescription());
            scheme.setEligibilityCriteria(schemeDetails.getEligibilityCriteria());
            scheme.setBenefits(schemeDetails.getBenefits());
            Scheme updatedScheme =  schemeRepository.save(scheme);
            log.info("Received payload for scheme creation: {}", updatedScheme);
            return updatedScheme;
        }).orElseThrow(() -> new SchemeNotFoundException("Scheme not found with id: " + id));
    }

    public void deleteScheme(int id) {
        schemeRepository.deleteById(id);
    }

    public Scheme setSchemeActiveStatus(int id, boolean isActive) {
        return schemeRepository.findById(id).map(scheme -> {
            scheme.setSchemeIsActive(isActive);
            return schemeRepository.save(scheme);
        }).orElseThrow(() -> new SchemeNotFoundException("Scheme not found with id: " + id));
    }

    public List<Scheme> getAllActiveSchemes(){
        return schemeRepository.findBySchemeIsActiveIsTrue();
    }

//    public  List<Scheme> getAllSchemesBySchemeName(String schemeName) {
//        return schemeRepository.findSchemeBySchemeNameAndSchemeIsActiveIsTrue(schemeName);
//    }

    public List<Scheme> getAllSchemesBySchemeName(String schemeName) {
        if (schemeName == null || schemeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Scheme name cannot be null or empty.");
        }

        // Perform a case-insensitive search
        return schemeRepository.searchBySchemeNameFlexible(schemeName);
    }

}
