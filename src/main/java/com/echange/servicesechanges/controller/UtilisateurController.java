package com.echange.servicesechanges.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echange.servicesechanges.auth.JwtUtils;
import com.echange.servicesechanges.exception.ErrorResponse;
import com.echange.servicesechanges.model.utilisateur.LoginReponse;
import com.echange.servicesechanges.model.utilisateur.LoginUtilisateur;
import com.echange.servicesechanges.model.utilisateur.Utilisateur;
import com.echange.servicesechanges.repository.UtilisateurRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UtilisateurController {
    private final AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    private final UtilisateurRepository utilisateurRepository;
    public UtilisateurController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UtilisateurRepository utilisateurRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/login")
    @SuppressWarnings("rawtypes")
    public ResponseEntity login(@RequestBody LoginUtilisateur loginUtilisateur) {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUtilisateur.getContact(), loginUtilisateur.getMotPasse());
            Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            String contact = authentication.getName();
            Utilisateur utilisateur = utilisateurRepository.findByContact(contact);
            String token = jwtUtils.createToken(utilisateur);
            LoginReponse loginReponse = new LoginReponse(contact, token);

            return ResponseEntity.ok(loginReponse);
        } catch (BadCredentialsException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Contact ou mot de passe invalide");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/inscription")
    public ResponseEntity signup(@RequestBody Utilisateur utilisateur) {
        try {
            Utilisateur newUser = this.utilisateurRepository.save(utilisateur);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(newUser.getContact(), newUser.getMotPasse());
            Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            String contact = authentication.getName();
            String token = jwtUtils.createToken(newUser);
            LoginReponse loginReponse = new LoginReponse(contact, token);

            return ResponseEntity.ok(loginReponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
    }
}
