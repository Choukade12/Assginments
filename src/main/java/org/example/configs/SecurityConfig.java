package org.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeRequests().antMatchers("/**").authenticated()
//                .and().formLogin().and().httpBasic();
////        http.authorizeRequests().anyRequest().denyAll();
////        http.authorizeRequests().anyRequest().permitAll();
//        return http.build();
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsServiceApproachOne(){
//        UserDetails admin =User.withUsername("shubhiadmin").password("a123").authorities("admin").build();
//        UserDetails user=User.withUsername("shubhiuser").password("u123").authorities("user").build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder customizePasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
