package com.pms.scheme_management.service;

import com.pms.scheme_management.exception.SchemeNotFoundException;
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

    @Autowired
    EmailService emailService;

    public UserSchemes applyToScheme(int schemeId, int userId){
        Scheme scheme = schemeRepository.findById(schemeId).orElseThrow(() -> new SchemeNotFoundException("Scheme not found with id: "+ schemeId));

        if (!scheme.isSchemeIsActive()) {
            throw new SchemeNotFoundException("Scheme not active for application");
        }

        UserSchemes us = new UserSchemes(scheme, userId);
        UserSchemes savedUs = userSchemesRepository.save(us);

        String email = "dhareshcoc@gmail.com"; // Fetch user email from pms db
        String subject = "Scheme Application Confirmation";
        String body = "Dear User,<br><br>You have successfully applied for the scheme: <b>"
                + scheme.getSchemeName() + "</b>.<br>Thank you!<br><br>Regards,<br>Scheme Management Team";

        emailService.sendEmail(email , subject , body);
        return savedUs;
    }

    public List<UserSchemes> allAppliedSchemesOfUser(int userId){
        return userSchemesRepository.findByUserId(userId);
    }
}
