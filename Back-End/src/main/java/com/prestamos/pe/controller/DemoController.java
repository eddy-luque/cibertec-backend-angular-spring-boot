package com.prestamos.pe.controller;


import com.prestamos.pe.security.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping
    public ResponseEntity<String> sayHello(Authentication authentication) {
        UserDetails details = userDetailsService.loadUserByUsername(authentication.getName());
        if (details != null && (details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("USER")) || details.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN")))) {
            return new ResponseEntity<>("Ok permitido", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error permitido", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
