package ma.emsi.securityservice.web;

import ma.emsi.securityservice.models.AuthRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {
    
    private JwtEncoder jwtEncoder;
    private JwtDecoder jwtDecoder;

    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;


    public AuthController(JwtEncoder jwtEncoder,
                          JwtDecoder jwtDecoder,
                          AuthenticationManager authenticationManager,
                          UserDetailsService userDetailsService) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


    @PostMapping("/token")
    public Map<String,String> jwtToken(@RequestBody AuthRequest authRequest){

        Map<String,String> idToken = new HashMap<>();


        String subject="",scope="";

        if(authRequest.getGrantType().equals("password")){
            Authentication authentication= authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));

            subject = authentication.getName();
            scope   = authentication.getAuthorities()
                    .stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));
        }
        else if(authRequest.getGrantType().equals("refreshToken")){
            Jwt decodeJWT = jwtDecoder.decode(authRequest.getRefreshToken());
            subject =decodeJWT.getSubject();
            UserDetails userDetails= userDetailsService.loadUserByUsername(subject);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            scope = authorities.stream().map(GrantedAuthority::getAuthority)
                   .collect(Collectors.joining(" "));
        }

        Instant instant = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(authRequest.isWithRefreshToken() ? 5: 30, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("scope",scope)
                .build();

        String jwtAccesToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();

        idToken.put("accessToken",jwtAccesToken);

        if(authRequest.isWithRefreshToken()){
            JwtClaimsSet jwtClaimsSetRefresh = JwtClaimsSet.builder()
                    .subject(subject)
                    .issuedAt(instant)
                    .expiresAt(instant.plus(30, ChronoUnit.MINUTES))
                    .issuer("security-service")
                    .build();
            String jwtRefreshToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
            idToken.put("refreshToken",jwtRefreshToken);
        }
        return idToken;
    }


}
