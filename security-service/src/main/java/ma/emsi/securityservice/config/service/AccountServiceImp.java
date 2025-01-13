package ma.emsi.securityservice.config.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.securityservice.config.entites.AppRole;
import ma.emsi.securityservice.config.entites.AppUser;
import ma.emsi.securityservice.config.repository.AppRoleRepository;
import ma.emsi.securityservice.config.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImp implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) throw new RuntimeException("USERNAME ALREADY EXISTS");

        if (!password.equals(confirmPassword))
            throw new RuntimeException("Password don't match");

        AppUser newUser = new AppUser();
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));

        appUser = appUserRepository.save(newUser);
        return appUser;
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole != null) throw new RuntimeException("Role already exists");

        AppRole newRole = new AppRole();
        newRole.setRole(role);
        appRoleRepository.save(newRole);
        return newRole;
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new RuntimeException("User not found");
        }

        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole == null) {
            throw new RuntimeException("Role not found");
        }

        appUser.getRoles().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new RuntimeException("User not found");
        }

        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole == null) {
            throw new RuntimeException("Role not found");
        }

        appUser.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}