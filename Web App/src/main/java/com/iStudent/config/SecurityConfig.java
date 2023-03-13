//package com.iStudent.config;
//
//import com.iStudent.model.entity.users.RolesEnum;
//import com.iStudent.repository.UserRepository;
//import com.iStudent.service.AppUserDetailsService;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new Pbkdf2PasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.
//                authorizeRequests().
//                requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
//                antMatchers("/", "/login", "/students/**").permitAll().
//                antMatchers("/register").hasRole(RolesEnum.ADMIN.name()).
//                antMatchers("/clubs/**").hasRole(RolesEnum.STUDENT.name()).
//                antMatchers("/students/add", "/teachers/add", "/employees/add", "/parents/add").hasRole(RolesEnum.ADMIN.name()).
//                antMatchers("/teachers/**").hasRole(RolesEnum.TEACHER.name()).
//                antMatchers("/employees/**").hasRole(RolesEnum.EMPLOYEE.name()).
//                antMatchers("/parents/**").hasRole(RolesEnum.PARENT.name()).
//                antMatchers("/maintenance").permitAll().
//                anyRequest().
//                authenticated().
//                and().
//                formLogin().
//                loginPage("/login").
//                usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
//                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
//                defaultSuccessUrl("/").
//                failureForwardUrl("/login-error").
//                and().
//                logout().
//                logoutUrl("/logout").
//                invalidateHttpSession(true).
//                deleteCookies("JSESSIONID");
//
//
//        return http.build();
//    }
//
//    @Primary
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return new AppUserDetailsService(userRepository);
//    }
//
//
//}
