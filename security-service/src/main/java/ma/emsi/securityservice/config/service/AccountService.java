package ma.emsi.securityservice.config.service;

import ma.emsi.securityservice.config.entites.AppRole;
import ma.emsi.securityservice.config.entites.AppUser;

public interface AccountService {

    AppUser addNewUser(String username,String password ,String email ,String confirmPassword);
    AppRole addNewRole(String role);

    void addRoleToUser(String username,String role);

    void removeRoleFromUser(String username,String role);

    AppUser loadUserByUsername(String username);

}
