package org.sid.billing;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Data
public class MyConsulConfiguration {
    private Long accessTokenTimeout;
    private Long refreshTokenTimeout;
}
