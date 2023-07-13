package com.ll.aaaa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUserService {
    private final PasswordEncoder passwordEncoder;
    private final SiteUserRepository siteUserRepository;
    public void createUser(String username, String email, String password){
        SiteUser siteUser = new SiteUser();
        siteUser.setUserName(username);
        siteUser.setEmail(email);
        String EncodePassword = (passwordEncoder.encode(password));
        siteUser.setPassword(EncodePassword);
        this.siteUserRepository.save(siteUser);
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.siteUserRepository.findByuserName(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            return null;
        }
    }
}
