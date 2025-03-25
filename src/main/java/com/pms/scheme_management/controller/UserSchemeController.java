ackage com.pms.scheme_management.controller;

import com.pms.scheme_management.model.Scheme;
import com.pms.scheme_management.model.UserScheme;
import com.pms.scheme_management.service.UserSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-schemes")
public class UserSchemeController {

    @Autowired
    private UserSchemeService userSchemeService;

    @PostMapping("/apply")
    public ResponseEntity<UserScheme> applyToScheme(@RequestParam int schemeId, @RequestParam int userId) {
        UserScheme appliedScheme = userSchemeService.applyToScheme(schemeId, userId);
        return ResponseEntity.ok(appliedScheme);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserScheme>> getAppliedSchemes(@PathVariable int userId) {
        List<UserScheme> schemes = userSchemeService.allAppliedSchemesOfUser(userId);
        return ResponseEntity.ok(schemes);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Scheme>> getAllActiveSchemes() {
        List<Scheme> schemes = userSchemeService.allActiveSchemes();
        return ResponseEntity.ok(schemes);
    }

    @GetMapping
    public ResponseEntity<List<UserScheme>> getAllUserSchemes() {
        List<UserScheme> userSchemes = userSchemeService.getUsersAndSchemes();
        return ResponseEntity.ok(userSchemes);
    }
}