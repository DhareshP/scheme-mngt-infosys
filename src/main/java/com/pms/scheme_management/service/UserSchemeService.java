package com.pms.scheme_management.service;

import com.pms.scheme_management.model.Scheme;
import com.pms.scheme_management.model.UserSchemes;
import com.pms.scheme_management.repository.SchemeRepository;
import com.pms.scheme_management.repository.UserSchemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSchemeService {

    @Autowired
    SchemeRepository schemeRepository;

    @Autowired
    UserSchemesRepository userSchemesRepository;

    public UserSchemes applyToScheme(int schemeId, int userId){
        Scheme scheme = schemeRepository.findById(schemeId).orElseThrow(() -> new RuntimeException("Scheme not found with id: "+ schemeId));

        if (!scheme.isSchemeIsActive()) {
            throw new RuntimeException("Scheme not active for application");
        }

        UserSchemes us = new UserSchemes(scheme, userId);
        return userSchemesRepository.save(us);
    }

    public List<UserSchemes> allAppliedSchemesOfUser(int userId){
        return userSchemesRepository.findByUserId(userId);
    }
}
