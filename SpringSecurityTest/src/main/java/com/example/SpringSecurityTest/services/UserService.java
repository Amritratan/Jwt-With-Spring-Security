package com.example.SpringSecurityTest.services;

import com.example.SpringSecurityTest.entities.User;
import com.example.SpringSecurityTest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);

    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

//    private List<User> store= new ArrayList<>();
//
//    public UserService(){
//        store.add(new User(UUID.randomUUID().toString(),"Amrit Kumar","amrit@yadav.in"));
//        store.add(new User(UUID.randomUUID().toString(),"Ashish Sharma","ashish@sharma.in"));
//        store.add(new User(UUID.randomUUID().toString(),"Vizit Bhardwaj","vizit@bhardwaj.in"));
//        store.add(new User(UUID.randomUUID().toString(),"Deepti Singh","deepti@singh.in"));
//    }
//
//    public List<User> getUsers() {
//        return this.store;
//    }
}
