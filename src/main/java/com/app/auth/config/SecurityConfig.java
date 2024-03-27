package com.app.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final String[] PUBLIC_MATHERS = {
			"/h2-console/**",
			"/usuarios/**",
			"/auth/**"
	};
	
	 @Bean
	    SecurityFilterChain apiSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
	        return httpSecurity
	                .csrf(AbstractHttpConfigurer::disable)
	                .headers(headers -> headers.disable())
	                .authorizeHttpRequests(auth -> auth
	                		.requestMatchers(HttpMethod.GET, PUBLIC_MATHERS).permitAll()
	                		.requestMatchers(HttpMethod.POST, PUBLIC_MATHERS).permitAll()
	                		.anyRequest().authenticated())
	                .build();
	    }
	 
		@Bean
		AuthenticationManager authenticatioManager(AuthenticationConfiguration authenticationConfiguration)
				throws Exception {
			return authenticationConfiguration.getAuthenticationManager();
		}
	 
		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
}
