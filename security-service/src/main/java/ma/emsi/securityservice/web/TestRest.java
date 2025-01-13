package ma.emsi.securityservice.web;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestRest {

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String,String> getMessage(){
        return Map.of("HEllo","World");
    }


    @PostMapping("/saveData")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String,String> saveData(String data){
        return Map.of("dataSaved",data);
    }

}
