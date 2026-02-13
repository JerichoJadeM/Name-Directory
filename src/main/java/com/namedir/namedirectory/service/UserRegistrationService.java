// package com.namedir.namedirectory.service;

// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.namedir.namedirectory.dao.AuthorityRepository;
// import com.namedir.namedirectory.dao.UserRepository;
// import com.namedir.namedirectory.entity.AppUser;
// import com.namedir.namedirectory.entity.Authority;
// import com.namedir.namedirectory.dto.UserRegistrationDto;


// @Service
// public class UserRegistrationService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final AuthorityRepository authorityRepository;
    
//     public UserRegistrationService(UserRepository userRepository, 
//                                     PasswordEncoder passwordEncoder, 
//                                     AuthorityRepository authorityRepository){
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//         this.authorityRepository = authorityRepository;
//     }

//     @Transactional
//     public AppUser registerUser(UserRegistrationDto dto) {
        
//         // check if user exist
//         if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
//             throw new IllegalArgumentException("Username already exists");
//         }

//         String encodedPassword = passwordEncoder.encode(dto.getPassword());

//         AppUser appUser = new AppUser();

//         appUser.setUsername(dto.getUsername());
//         appUser.setPassword(encodedPassword);
//         appUser.setEnabled(true);
//         appUser.setFirstName(dto.getFirstName());
//         appUser.setLastName(dto.getLastName());
//         appUser.setEmail(dto.getEmail());

//         userRepository.save(appUser);

//         authorityRepository.save(new Authority(dto.getUsername(), "ROLE_USER"));

//         return appUser;
//     }

// }
