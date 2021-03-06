package com.aktarulahsan.erp.core.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    public static final String ENCODING = "UTF-8";
    private final long MAX_AGE_SECS = 3600;
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore resourcesTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }

}
