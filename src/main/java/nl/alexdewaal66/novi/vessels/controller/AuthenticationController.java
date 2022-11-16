package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.payload.AuthenticationRequest;
import nl.alexdewaal66.novi.vessels.payload.AuthenticationResponse;
import nl.alexdewaal66.novi.vessels.service.EnduserService;
import nl.alexdewaal66.novi.vessels.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final EnduserService userDetailsService;

    final
    JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, EnduserService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

//    @GetMapping(value = "/authenticated")
//    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
//        return ResponseEntity.ok().body(principal);
//    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        System.out.println(" -----> username: " + username );
//        System.out.println(" -----> password: " + password );//logging passwords is a security risk


        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(username, password);
            System.out.println(" -----> token: " + token);
            authenticationManager.authenticate(token);
        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
