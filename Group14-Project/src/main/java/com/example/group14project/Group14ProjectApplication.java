package com.example.group14project;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.domain.UserRole;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Group14ProjectApplication implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SkillsBuildUserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Group14ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SkillsBuildUser user1 = new SkillsBuildUser();
        UserRole role = new UserRole("default");
        user1.setName("guest");
        user1.setPassword(passwordEncoder.encode("password"));
        user1.addRole(role);
        repository.save(user1);
    }
}
