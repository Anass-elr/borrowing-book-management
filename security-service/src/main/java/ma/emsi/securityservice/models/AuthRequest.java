package ma.emsi.securityservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class AuthRequest {
    private String grantType;
    private String refreshToken;
    private String username;
    private String password;
    private boolean withRefreshToken;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isWithRefreshToken() {
        return withRefreshToken;
    }

    public void setWithRefreshToken(boolean withRefreshToken) {
        this.withRefreshToken = withRefreshToken;
    }
}
