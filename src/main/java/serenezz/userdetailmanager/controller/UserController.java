package serenezz.userdetailmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getResponse(Principal principal) {
        return ResponseEntity.ok("User is: " + principal.getName());
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping("/manager")
    public ResponseEntity<?> getResponse1(Principal principal) {
        return ResponseEntity.ok("Role is: " + principal.getName());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<?> getResponse2(Principal principal) {
        return ResponseEntity.ok("Only admin has access, name: " + principal.getName());
    }

}
