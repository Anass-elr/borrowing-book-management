package ma.emsi.securityservice.config.service;

import ma.emsi.securityservice.config.entites.AppRole;
import ma.emsi.securityservice.config.entites.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    private AccountService accountService;

    public UserDetailServiceImp(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser= accountService.loadUserByUsername(username);

        if(appUser == null) throw new UsernameNotFoundException("Not Found with username :"+username);

      String[] collect =  appUser.getRoles().stream().map(AppRole::getRole).toArray(String[]::new);
         UserDetails userDetails= User
                 .withUsername(appUser.getUsername())
                 .password(appUser.getPassword())
                 .roles(collect).build();
        return userDetails;
    }
}
