package org.sid.billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConsulConfigRestController {
    @Autowired
    private MyConsulConfiguration myConsulConfiguration;
    @Autowired
    private MyVaultConfiguration myVaultConfiguration;
    /*@Value("${token.accessTokenTimeout}")
    private Long accessTokenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private Long refreshTokenTimeout;*/
    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        return Map.of("consultConfig",myConsulConfiguration,
                "vaultConfig",myVaultConfiguration);
    }

}
