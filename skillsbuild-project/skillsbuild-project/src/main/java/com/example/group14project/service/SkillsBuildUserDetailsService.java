package com.example.group14project.service;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.domain.UserRole;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillsBuildUserDetailsService implements UserDetailsService {

    @Autowired
    private SkillsBuildUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        SkillsBuildUser domainSkillsBuildUser = repository.findByName(login);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : domainSkillsBuildUser.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+ userRole.getName()));
        }
        return new User(domainSkillsBuildUser.getName(), domainSkillsBuildUser.getPassword(), true, true, true, true, authorities);
    }
}
