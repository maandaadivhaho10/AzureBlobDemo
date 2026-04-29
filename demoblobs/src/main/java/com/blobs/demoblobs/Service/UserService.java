package com.blobs.demoblobs.Service;

import com.blobs.demoblobs.Model.User;
import com.blobs.demoblobs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService{

    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  void adduser(User user){
        userRepository.save(user);
    }
    public Optional<User> getUser(Long id){
        return  userRepository.findById(id);
    }
}
