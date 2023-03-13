//package com.iStudent.service;
//
//import com.iStudent.model.entity.users.Role;
//import com.iStudent.model.entity.users.UserEntity;
//import com.iStudent.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//// no @Service annotation because we use it as a bean!
//public class AppUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public AppUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository
//                .findByEmail(username)
//                .map(this::map)
//                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found"));
//    }
//
//    private UserDetails map(UserEntity userEntity) {
//        return
//                User.builder().
//                        username(userEntity.getEmail()).
//                        password(userEntity.getPassword()).
//                        authorities(map(userEntity.getRole()))
//                        .build();
//    }
//
//    private GrantedAuthority map(Role userRole) {
//        return new SimpleGrantedAuthority("ROLE_" +
//                userRole.getRole().name());
//    }
//}
