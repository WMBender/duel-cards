package br.com.weslei.bender.api.duelcards.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${ADMIN_USER}")
    private String userName;

    @Value("${ADMIN_PASSWORD}")
    private String password;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers(HttpMethod.GET, "/**").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/**").hasRole("USER")
                    .requestMatchers(HttpMethod.DELETE, "/**").hasRole("USER")
                    .requestMatchers(HttpMethod.PUT, "/**").hasRole("USER")
                    .anyRequest().authenticated()
            )
            .httpBasic(withDefaults())
            .formLogin(withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(userName)
                .password(password)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

}
