package com.echange.servicesechanges.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.echange.servicesechanges.model.utilisateur.Utilisateur;
import com.echange.servicesechanges.repository.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;

    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByContact(username);
        if(utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }
        List<String> roles = new ArrayList<>();
        roles.add("user");
        UserDetails userDetails = User.builder().username(utilisateur.getContact()).password(utilisateur.getMotPasse()).roles(roles.toArray(new String[0])).build();
        return userDetails;
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
}
